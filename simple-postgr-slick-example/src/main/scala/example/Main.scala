package example

import scala.slick.driver.PostgresDriver.simple._

object Main {

  // this is a class that represents the table I've created in the database
  class Users(tag: Tag) extends Table[(Int, String)](tag, "users") {
    def id = column[Int]("id")
    def username = column[String]("username")
    def * = (id, username)
  }

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val db = Map(
      // "name" -> "public.playground",
    	"name" -> "public",
    	"username" -> "postgres",
    	"password" -> "password"
    )
    // val connectionUrl = "jdbc:postgresql://localhost/my-db?user=postgres&password=postgres"
    // val connectionUrl = s"jdbc:postgres://localhost:5432/${db("name")}?user=${db("username")}&password=${db("password")}"
    val connectionUrl = s"jdbc:postgresql://localhost:5432/play_example_postgres?user=postgres&password=password"
    // val connectionUrl = "jdbc:postgresql://postgres:password@localhost:5432/public.playground"

    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val users = TableQuery[Users]

        // SELECT * FROM users
        users.list foreach { row =>
          println("user with id " + row._1 + " has username " + row._2)
        }

        // SELECT * FROM users WHERE username='john'
        users.filter(_.username === "john").list foreach { row => 
           println("user whose username is 'john' has id "+row._1 )
        }
    }
  }
}
