package org.dc.model

import java.util.Date


case class SVNDocument(id:String,name:String,revision:String,deleted:Boolean = false,
                       dateLastUpdated:Date,commitMessage:String,lastAuthor:String) {}