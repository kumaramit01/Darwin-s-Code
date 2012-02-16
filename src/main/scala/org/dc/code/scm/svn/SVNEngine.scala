package org.dc.code.scm.svn

import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory
import org.tmatesoft.svn.core.io.{SVNRepositoryFactory, SVNRepository}
import java.io.File
import org.tmatesoft.svn.core.wc.{SVNRevision, SVNClientManager, SVNWCUtil, ISVNOptions}
import org.tmatesoft.svn.core.{SVNDepth, SVNException, SVNURL}


case class SVNEngine(repositoryURL:String, login:String, password:String) {
     private val authManager:ISVNAuthenticationManager = SVNWCUtil.createDefaultAuthenticationManager(login,password);
     private val options:ISVNOptions = SVNWCUtil.createDefaultOptions(true);
     private val repository:SVNRepository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(repositoryURL));
     private val svnClientManager = SVNClientManager.newInstance(options, authManager);
     // http://  and https:// support
     DAVRepositoryFactory.setup();
     // svn:// and other svn+?:// support
     SVNRepositoryFactoryImpl.setup();
     // file:/// support
     FSRepositoryFactory.setup();

  def connected(): Boolean = {
    try{
      repository.testConnection()
    }catch {
      case e:SVNException => return false
    }
    true
  }


  def export(srcLocation:String,dstLocation:String): Option[Long]={
    val dstFile:File = new File(dstLocation);
    require(dstFile.exists() && dstFile.isDirectory && dstFile.canRead && dstFile.canWrite)
    val url:SVNURL = SVNURL.parseURIDecoded(repositoryURL+srcLocation);
    Some(svnClientManager.getUpdateClient.doExport(url,dstFile,SVNRevision.HEAD,
      SVNRevision.HEAD,"native",true,SVNDepth.INFINITY));
  }

  def root():String={
    repository.getRepositoryPath("/");
  }





}