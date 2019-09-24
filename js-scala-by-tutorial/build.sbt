import Dependencies._

enablePlugins(ScalaJSPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "js-scala-by-tutorial",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.5",
    libraryDependencies += "org.querki" %%% "jquery-facade" % "1.2",
    skip in packageJSDependencies := false,
    jsDependencies +=
      "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js",
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.6.3" % "test",
    testFrameworks += 
      new TestFramework("utest.runner.Framework")
  )
