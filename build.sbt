ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "org.bionic"
ThisBuild / organizationName := "bionicscala"
ThisBuild / name             := "BionicHScala"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.3"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.3"

// Logger
libraryDependencies += "org.wvlet.airframe" % "airframe-log_2.12" % "20.3.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-jul" % "2.6.1"

// Scala Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"