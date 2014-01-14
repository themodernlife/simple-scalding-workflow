name := "Example Workflow"

version := "0.1"

organization := "example"

scalaVersion := "2.10.2"

description := "Shows some scalding stuff"

scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-unchecked", "-feature")



resolvers += "Concurrent Maven Repo" at "http://conjars.org/repo"

resolvers += "Twitter Maven Repository" at "http://maven.twttr.com/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"



libraryDependencies += "com.twitter" %% "scalding-core" % "0.8.11"

// Extras I like

libraryDependencies += "joda-time"          % "joda-time"          % "2.1"

libraryDependencies += "org.joda"           % "joda-convert"       % "1.2"

libraryDependencies += "com.amazonaws"      % "aws-java-sdk"       % "1.6.8"

libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.3"



// Hadoop needs to be included for compilation, but is always decalred "provided"

libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "0.20.2" % "provided"



libraryDependencies += "ch.qos.logback"     % "logback-classic" % "1.0.13" % "runtime"

libraryDependencies += "org.slf4j"          % "jcl-over-slf4j"  % "1.7.5"  % "runtime"



libraryDependencies += "org.scalatest"     %% "scalatest"       % "1.9.1" % "test"

libraryDependencies += "org.mockito"        % "mockito-all"     % "1.9.5" % "test"



// SLF4J complains when tests are run in parallel

testOptions += Tests.Setup( cl ⇒ {
	cl.loadClass("org.slf4j.LoggerFactory")
		.getMethod("getLogger", cl.loadClass("java.lang.String"))
		.invoke(null, "ROOT")
})
