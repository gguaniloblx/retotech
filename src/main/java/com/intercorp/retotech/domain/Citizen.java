package com.intercorp.retotech.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Citizen {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(notes = "ID autogenerado por el programa",example = "1")
  private int id;


  @ApiModelProperty(notes = "Nombres del Ciudadano", example = "Alberto ")
  private String firstName;


  @ApiModelProperty(notes = "Apellidos del Ciudadano", example = "Garcia Mendoza")
  private String lastName;


  @ApiModelProperty(notes = "Fecha de Nacimiento", example = "1982-05-25")
  private Date birthDay;

  @ApiModelProperty(notes = "Fecha Probable de Muerte (https://population.io/#/1982/05/25/male/Peru/summary) ", example = "2061-05-25")
  private Date deathDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public Date getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(Date deathDate) {
    this.deathDate = deathDate;
  }
}
