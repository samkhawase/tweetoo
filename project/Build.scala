import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "tweetoo"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
     "com.google.code.morphia" % "morphia" % "0.99",
     "org.mongodb" % "mongo-java-driver" % "2.7.3",
     "com.google.code.morphia" % "morphia-logging-slf4j" % "0.99",
     "org.twitter4j" % "twitter4j-stream" % "2.2.5",
     "org.twitter4j" % "twitter4j-core" % "2.2.5"

    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here     
     resolvers += "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/",
     resolvers += "MongoDb Java Driver Repository" at "http://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/",
     resolvers += "A Java library for the Twitter API" at "http://repo1.maven.org/maven2/org/twitter4j/twitter4j-stream/",
	 resolvers += "A Java library for the Twitter API" at "http://repo1.maven.org/maven2/org/twitter4j/twitter4j/"
    )

}
