package com.hendyirawan.venue

import javax.persistence._
import reflect._

@Entity
class Venue {

  @BeanProperty @Id @GeneratedValue(strategy=GenerationType.IDENTITY) var id: Long = _
  @BeanProperty var name: String = _
  
}