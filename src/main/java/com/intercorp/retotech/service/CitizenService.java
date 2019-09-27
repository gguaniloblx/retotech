package com.intercorp.retotech.service;

import com.intercorp.retotech.domain.Citizen;

import java.util.List;
import java.util.Optional;

public interface CitizenService {
  public List<Citizen> findAll();

  public List<Citizen> findAllAdult();

  public Optional<Citizen> findById(Integer id);

  public Citizen save(Citizen citizen);

  public void deleteById(Integer id);

  public Integer averageAgeAllCitizens();

  public Float deviationStandarAllCitizens();
}
