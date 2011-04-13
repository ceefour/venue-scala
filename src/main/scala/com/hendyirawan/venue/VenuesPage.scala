/**
 * 
 */
package com.hendyirawan.venue

import reflect._
import javax.inject._
import javax.enterprise.context._

/**
 * @author ceefour
 *
 */
@Named
@RequestScoped
class VenuesPage {

  @BeanProperty var venueName: String = _
  
}