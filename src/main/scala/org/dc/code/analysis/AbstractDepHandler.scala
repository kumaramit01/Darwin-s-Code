package org.dc.code.analysis

import com.tonicsystems.jarjar.{PathClass, DepHandler}

import scala.collection.mutable.ListBuffer

abstract class AbstractDepHandler(level:Int) extends DepHandler{
  val level1:Int = level;
  var seen:ListBuffer[(String,String)] = new ListBuffer[(String,String)]


  def handle(to:String, from:String);
  def handleStart(){}

  def handle(from: PathClass, to: PathClass) {
    if(level1 == DepHandler.LEVEL_CLASS){
      if(!seen.contains((from.getClassName,to.getClassName))){
        seen += Tuple2(from.getClassName,to.getClassName)
        handle(from.getClassName,to.getClassName)
      }
    }else if(level1 == DepHandler.LEVEL_JAR){
      if (!seen.contains((from.getClassPath, to.getClassPath))){
        seen += Tuple2(from.getClassPath, to.getClassPath)
        handle(from.getClassPath, to.getClassPath);
      }

      }
  }
 def handleEnd() {}
}