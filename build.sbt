name := """vr"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final"
)
