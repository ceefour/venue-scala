package com.hendyirawan.venue

import java.io.Serializable

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Widget extends Serializable {
   private var id: Long
   private var partNumber: String
   private var name: String
   private var description: String

   @Id
   @GeneratedValue
   def getId(): Long = {
      return id;
   }

   def setId(id: Long): Unit = {
      this.id = id;
   }

   // demonstrates a column name override
   @Column(name = "partno")
   def getPartNumber(): String = {
      return partNumber;
   }

   def setPartNumber(partNumber: String): Unit = {
      this.partNumber = partNumber;
   }

   def getName(): String = {
      return name;
   }

   def setName(name: String): Unit = {
      this.name = name;
   }

   def getDescription(): String = {
      return description;
   }

   def setDescription(description: String): Unit = {
      this.description = description;
   }
   
   /** Default value included to remove warning.  Remove or modify at will.  */  
   private val serialVersionUID = 1L
}