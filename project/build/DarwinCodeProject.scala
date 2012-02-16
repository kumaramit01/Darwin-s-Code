import sbt._

class DarwinCodeProject(info: ProjectInfo) extends DefaultProject(info)
{

  val mavenLocal = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  val scalaToolsSnapshots = "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"
  val mvnRepository = "mvnrepository" at "http://repo1.maven.org/maven2/"


  lazy val hi = task { println("Hello World"); None }
  val mavenVersion ="3.0.3-RC1"

  val slf4j = "org.slf4j" % "slf4j-api" % "1.6.1" withSources()
  val logback= "ch.qos.logback" % "logback-classic" % "0.9.26" withSources()
  val jdepend = "jdepend" % "jdepend" % "2.9.1"     withSources()

  val neo4jAdvanced = "org.neo4j" % "neo4j-advanced" % "1.4.2" withSources()
  val svnkit = "org.tmatesoft.svnkit" % "svnkit" % "1.3.6"    withSources()
  val junit="junit" % "junit" % "4.7" % "test"           withSources()
  val scala_testing="org.scala-tools.testing" %% "specs" % "1.6.8" % "test" withSources()

  val scalatest = "org.scalatest" %% "scalatest" % "1.6.1" % "test"     withSources()
    // this is custom jarjar -it was compiled with
    // added functionality that allows find class classpath-withjars classpath-withclasses
    // functionality.
  val jarjar="jarjar.custom" % "jarjar" % "1.2" withSources()

  var mavenCore = "org.apache.maven" % "maven-core" % mavenVersion     withSources()
  var mavenSettings = "org.apache.maven" % "maven-settings" % mavenVersion  withSources()
  var mavenModel = "org.apache.maven" % "maven-model-builder" % mavenVersion  withSources()
  var mavenEmbedder = "org.apache.maven" % "maven-embedder" % mavenVersion    withSources()
  var aether = "org.sonatype.aether" %  "aether-connector-wagon" %  "1.7"   withSources()
  var wagon = "org.apache.maven.wagon" % "wagon-http" % "1.0-beta-6"       withSources()

  var plexusUtils = "org.codehaus.plexus" % "plexus-utils" %   "3.0"  withSources()

}