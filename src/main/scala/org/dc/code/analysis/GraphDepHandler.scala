package org.dc.code.analysis

import org.dc.persistence.CodePropertyPersistenceHandler
import org.dc.model.{JarNode, Relationships, ClassNode, Relationship}
import com.tonicsystems.jarjar.{PathClass, DepHandler}

case class GraphDepHandler(level:Int, persistenceHandler:CodePropertyPersistenceHandler)
  extends AbstractDepHandler(level:Int) {

  def handle(from:String, to:String) {
    if(level == DepHandler.LEVEL_CLASS){
      persistenceHandler.save[ClassNode,ClassNode](Relationship(ClassNode(from), ClassNode(to),Relationships.Dependency))
    }else{
      persistenceHandler.save[JarNode,JarNode](Relationship(JarNode(from), JarNode(to),Relationships.Dependency))
    }
  }

}