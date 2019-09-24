package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.lifted

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PersonRepository @Inject()(dbConfigprovider: DatabaseConfigProvider)(implicit  ec: ExecutionContext) {
  private val dbConfig = dbConfigprovider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class PeopleTable(tag: Tag) extends Table[Person](tag, "people") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def age = column[Int]("age")

    def * = (id, name, age) <> ((Person.apply _).tupled, Person.unapply)
  }

  private val people = lifted.TableQuery[PeopleTable]

  def create(name: String, age: Int) : Future[Person] = db.run {
    (people.map(p => (p.name, p.age))
      returning people.map(_.id)
      into( (nameAge, id) => Person(id, nameAge._1, nameAge._2))
    ) += (name, age)
  }

  def list(): Future[Seq[Person]] = db.run {
    people.result
  }
}
