package com.hendyirawan.venue

import javax.annotation.PostConstruct
import javax.enterprise.inject.Model
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty

@Model class HelloWorld {

   private var text: String = "Hello World!";

   private var letters: String = _;
   
   private var numbers: String = _;
   
   private var email: String = _;
   
   @PostConstruct
   def initialize(): Unit = {
      System.out.println(this.getClass().getSimpleName() + " was constructed");
   }

   def getText(): String = {
      return text;
   }

   @NotNull
   @NotEmpty
   @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
   def getLetters(): String = {
      return letters;
   }

   def setLetters(letters: String): Unit = {
      this.letters = letters
   }

   @NotNull
   @NotEmpty
   @Digits(fraction = 0, integer = 2)
   def getNumbers(): String = {
      return numbers;
   }

   def setNumbers(numbers: String): Unit = {
      this.numbers = numbers
   }

   @NotNull
   @NotEmpty
   @Email
   def getEmail(): String = {
      return email
   }

   def setEmail(email: String): Unit = {
      this.email = email
   }

}