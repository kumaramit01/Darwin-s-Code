package org.dc.code.analysis

/**
 * Created by IntelliJ IDEA.
 * User: amitku
 * Date: 11/16/11
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */

abstract class DepHandlerFilter {
      def filter(to:String, from:String):Boolean;
}