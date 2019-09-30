import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Scala Seed Project",
    libraryDependencies += scalaTest % Test,
    // libraryDependencies += "com.storm-enroute" %% "scalameter-core" % "0.6"
    libraryDependencies += "com.storm-enroute" %% "scalameter-core" % "0.8.2",

    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.2.3",
      "org.slf4j" % "slf4j-nop" % "1.6.4",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3"
    )

  )
