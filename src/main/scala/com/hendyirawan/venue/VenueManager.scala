/**
 * 
 */
package com.hendyirawan.venue

import reflect._
import collection.JavaConversions._
import collection.mutable._

import javax.inject._
import javax.annotation._
import org.slf4j._
import javax.persistence._
import javax.faces.application._
import javax.faces.context._

/**
 * @author ceefour
 *
 */
@Named
class VenueManager {

  @BeanProperty var venues: java.util.List[Venue] = _
  private val logger = LoggerFactory.getLogger(getClass())
  
  @PersistenceContext
  private var em: EntityManager = _
  
  @PostConstruct
  def init(): Unit = {
    logger.info("VenueManager init")
    reload()
  }
  
  def reload(): Unit = {
	val faces = FacesContext.getCurrentInstance
    venues = em.createQuery("SELECT v FROM Venue v", classOf[Venue]).getResultList()
    faces.addMessage(null, new FacesMessage("Reloaded, got "+ venues.length + " venues"))
    logger.info("Venues: {}", venues.length)
  }
  
}

