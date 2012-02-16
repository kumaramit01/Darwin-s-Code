package org.dc.code.svn

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfter, FlatSpec}
import org.dc.code.scm.svn.SVNEngine
import java.io.File

class SVNEngineSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter with BeforeAndAfterAll{
   val dst = System.getProperty("java.io.tmpdir")+ File.separator + "TEST"
   val src = "/IND/trunk";
   val dstFile:File = new File(dst);

  "SVNEngine" should "connect to file:// based repository" in{
    val svnEngine:SVNEngine   = SVNEngine("file:///content/svn/IND","user","password");
    assert(svnEngine.connected() == true , "svn engine was not connected to the file system based repository.")
  }

  it should "connect to http:// based repository" is pending

  it should "connect to https:// based repository" is pending

  it should "connect to svn+ssh:// based repository" is pending

  it should "connect to svn:// based repository" is pending

  it must "export the contents and the number of files should be greater than 0" in{
    val svnEngine:SVNEngine   = SVNEngine("file:///content/svn/IND","user","password");
    svnEngine.export(src,dst) match {
      case Some(value) => // all is good
      case None => fail("Invalid version number returned.")
    }
    assert(dstFile.list.size > 0,"checkout created no new files " + dstFile.list.size);
  }


  before {
    if(dstFile.exists){
      dstFile.delete
     }
     dstFile.mkdir
  }

  after {
    dstFile.delete
  }

  override def beforeAll(configMap: Map[String, Any]) {}

  override def afterAll(configMap: Map[String, Any]) {}


}