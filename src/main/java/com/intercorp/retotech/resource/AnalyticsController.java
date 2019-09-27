package com.intercorp.retotech.resource;

import com.intercorp.retotech.domain.Analytics;
import com.intercorp.retotech.service.CitizenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analytics")
@Api(value = "Analisis de Información", description = "Analisis Estadistico del Repositorio")
public class AnalyticsController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AnalyticsController.class);

  @Autowired private CitizenService citizenService;

  @GetMapping("/citizens")
  @ApiOperation(value = "Analisis estadistico de todos los Clientes", response = Analytics.class)
  public Analytics findAll() {
    int average = citizenService.averageAgeAllCitizens();
    float deviation = citizenService.deviationStandarAllCitizens();
    return new Analytics(average, deviation);
  }
}
