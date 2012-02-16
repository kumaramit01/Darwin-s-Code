package org.dc.code.project.maven

import java.io.File
import org.apache.maven.artifact.Artifact
import org.apache.maven.project.MavenProject
import org.apache.maven.cli.MavenCli
import org.apache.maven.execution.DefaultMavenExecutionRequest


class MavenProject(projectDirectory:String){
  val baseDir:String = new File(projectDirectory).getCanonicalPath
  //val configuration:Configuration = new SimpleConfiguration();
  //val mavenEmbedder:MavenEmbedder = new MavenEmbedder(configuration);

}

object MavenProject extends App{
  val maven:MavenCli = new MavenCli()
  //val cliRequest:DefaultMavenExecutionRequest   =    _
  //maven.doMain(null,"/tmp/testme/IND/IND/trunk",System.out,System.err);
  val str=new Array[String](3)
  str(0) ="compile"
  str(1) ="package"
  str(2) ="jar:jar"
  maven.doMain(str,"/tmp/testme/IND/IND/trunk",System.out,System.err);


}