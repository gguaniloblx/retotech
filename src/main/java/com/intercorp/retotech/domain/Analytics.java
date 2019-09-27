package com.intercorp.retotech.domain;

import io.swagger.annotations.ApiModelProperty;

public class Analytics {

  @ApiModelProperty(notes = "Promedio de Edad de todos los Ciudadanos", example = "27")
  private Integer averageAge;

  @ApiModelProperty(
      notes = "Desviacion Estandar de Edad de todos los Ciudadanos",
      example = "8.9736438")
  private Float deviationStandart;

    public Analytics(Integer averageAge, Float deviationStandart) {
        this.averageAge = averageAge;
        this.deviationStandart = deviationStandart;
    }

    public Integer getAverageAge() {
    return averageAge;
  }

  public void setAverageAge(Integer averageAge) {
    this.averageAge = averageAge;
  }

  public Float getDeviationStandart() {
    return deviationStandart;
  }

  public void setDeviationStandart(Float deviationStandart) {
    this.deviationStandart = deviationStandart;
  }
}
