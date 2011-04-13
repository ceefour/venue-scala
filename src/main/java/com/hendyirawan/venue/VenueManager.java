/**
 * 
 */
package com.hendyirawan.venue;

import javax.faces.context.*;

/**
 * @author ceefour
 *
 */
public class VenueManager {

  void reload() {
	FacesContext faces = FacesContext.getCurrentInstance();
	System.out.println(faces.toString()); // dummy
	
//    venues = em.createQuery("SELECT v FROM Venue v", classOf[Venue]).getResultList()
//    System.out.println("Venues: {}", venues.length)
  }
  
}

