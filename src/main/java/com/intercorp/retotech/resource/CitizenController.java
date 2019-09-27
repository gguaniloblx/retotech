package com.intercorp.retotech.resource;

import com.intercorp.retotech.domain.Citizen;
import com.intercorp.retotech.service.CitizenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/citizens")
@Api(value = "Gestion de Ciudadanos", description = "Mantenimiento de ciudadanos")
public class CitizenController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CitizenController.class);

  @Autowired private CitizenService citizenService;

  @GetMapping
  @ApiOperation(value = "Muestra el listado de todos los ciudadanos", response = List.class)
  public List<Citizen> findAll() {
    return citizenService.findAll();
  }

  @GetMapping("/adults")
  @ApiOperation(
      value = "Muestra el listado de todos los Clientes (Mayores a 18 años)",
      response = List.class)
  public List<Citizen> findAllCustomer() {
    return citizenService.findAllAdult();
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Busca un Ciudadano por su Identificador en el repositorio",response = Citizen.class)
  public Citizen findById(@PathVariable Integer id) {
    return citizenService.findById(id).get();
  }

  @PostMapping
  @ApiOperation(value = "Agregar un Ciudadano al repositorio")
  public ResponseEntity create(@Valid @RequestBody Citizen citizen) {
    return ResponseEntity.ok(citizenService.save(citizen));
  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Actualiza un Ciudadano en el repositorio")
  public ResponseEntity<Citizen> update(
      @PathVariable Integer id, @Valid @RequestBody Citizen citizen) {
    if (!citizenService.findById(id).isPresent()) {
      LOGGER.error("Id " + id + " is not existed");
      ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(citizenService.save(citizen));
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Elimina un Ciudadano en el repositorio")
  public ResponseEntity delete(@PathVariable Integer id) {
    if (!citizenService.findById(id).isPresent()) {
      LOGGER.error("Id " + id + " is not existed");
      ResponseEntity.badRequest().build();
    }
    citizenService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
