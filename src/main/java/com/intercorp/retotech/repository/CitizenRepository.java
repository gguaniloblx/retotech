package com.intercorp.retotech.repository;

import com.intercorp.retotech.commons.Constants;
import com.intercorp.retotech.domain.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

  @Query(value = Constants.CITIZENS_QUERY, nativeQuery = true)
  public List<Citizen> findAll();

  @Query(value = Constants.CITIZENS_ADULT_QUERY, nativeQuery = true)
  public List<Citizen> findAllAdult();

  @Query(value = Constants.CITIZENS_AVERAGE_QUERY, nativeQuery = true)
  public Integer averageAge();

  @Query(value = Constants.CITIZENS_DEVIATION_STD_QUERY, nativeQuery = true)
  public Float deviationStandarAllCitizens();
}
