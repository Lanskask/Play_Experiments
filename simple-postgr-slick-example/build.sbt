import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Simple Postgr Slick Example",

    libraryDependencies ++= Seq(
		  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
		  "com.typesafe.slick" %% "slick" % "2.1.0",
		  "org.slf4j" % "slf4j-nop" % "1.6.4",
      "com.h2database" % "h2" % "1.4.187"

      scalaTest % Test
		)
  )
