package com.cg.onlinepizza.entities;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

  @DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
  @DiscriminatorValue(value="Admin")
  @Entity
  public class Admin extends User{
  
  }
  
  
  