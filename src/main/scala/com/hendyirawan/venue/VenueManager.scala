/**
 * 
 */
package com.hendyirawan.venue

import reflect._
import collection.JavaConversions._
import collection.mutable._

import javax.inject._
import javax.enterprise.context._
import javax.ejb._
import javax.annotation._
import org.slf4j._
import javax.persistence._
import javax.faces.application.FacesMessage
import javax.faces.context._
import javax.transaction._

/**
 * @author ceefour
 *
 */
@Named
@ApplicationScoped
//@TransactionAttribute
class VenueManager {

  @BeanProperty var venues: java.util.List[Venue] = _
  private val logger = LoggerFactory.getLogger(getClass())
  
  @PersistenceContext
  private var em: EntityManager = _
  
  @Resource
  private var tx: UserTransaction = _
  
  @PostConstruct
  def init(): Unit = {
    logger.info("VenueManager init")
    reload()
  }
  
  def reload(): Unit = {
    venues = em.createQuery("SELECT v FROM Venue v", classOf[Venue]).getResultList()
    logger.info("Venues: {}", venues.length)
	val faces = FacesContext.getCurrentInstance
    faces.addMessage(null, new FacesMessage("Reloaded, got "+ venues.length + " venues"))
  }
  
  def createVenue(name: String): Unit = {
    tx.begin
    try {
	    val venue = new Venue
	    venue.name = name
	    em.merge(venue)
	    tx.commit
	    logger.info("Created venue: {}", venue.name)
		val faces = FacesContext.getCurrentInstance
	    faces.addMessage(null, new FacesMessage("Created venue: "+ venue.name))
	    reload
    } catch {
      case e => tx.rollback
    }
  }
  
}

