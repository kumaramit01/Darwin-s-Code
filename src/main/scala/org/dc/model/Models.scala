package org.dc.model

object Relationships extends Enumeration {
    type Relationships = Value
    val Dependency = Value
  }

import Relationships._
case class ClassNode(name:String) {}
case class JarNode(name:String) {}
case class Relationship[T, K](fromNode:T,toNode:K, value:Relationships){}