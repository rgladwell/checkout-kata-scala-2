libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.8" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

scalaVersion := "2.11.8"
