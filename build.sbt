name := "drawing-program"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.6"
 
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)
