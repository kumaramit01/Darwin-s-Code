package org.dc.persistence

import org.dc.model.Relationship

/**
 * Created by IntelliJ IDEA.
 * User: amitku
 * Date: 11/16/11
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */

trait CodePropertyPersistenceHandler {
 def save[T,K](relation:Relationship[T,K]):Boolean;
}