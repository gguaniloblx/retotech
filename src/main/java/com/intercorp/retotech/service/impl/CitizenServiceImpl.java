package com.intercorp.retotech.service.impl;

import com.intercorp.retotech.domain.Citizen;
import com.intercorp.retotech.repository.CitizenRepository;
import com.intercorp.retotech.service.CitizenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService {

  private CitizenRepository citizenRepository;

  public CitizenServiceImpl(CitizenRepository citizenRepository) {
    this.citizenRepository = citizenRepository;
  }

  @Override
  public List<Citizen> findAll() {
    return citizenRepository.findAll();
  }

  @Override
  public List<Citizen> findAllAdult() {
    return citizenRepository.findAllAdult();
  }

  @Override
  public Optional<Citizen> findById(Integer id) {
    return citizenRepository.findById(id);
  }

  @Override
  public Citizen save(Citizen citizen) {
    return citizenRepository.save(citizen);
  }

  @Override
  public void deleteById(Integer id) {
    citizenRepository.deleteById(id);
  }

  @Override
  public Integer averageAgeAllCitizens() {
    return citizenRepository.averageAge();
  }

  @Override
  public Float deviationStandarAllCitizens() {
    return citizenRepository.deviationStandarAllCitizens();
  }
}
