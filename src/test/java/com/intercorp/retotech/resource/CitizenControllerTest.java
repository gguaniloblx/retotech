package com.intercorp.retotech.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.retotech.domain.Citizen;
import com.intercorp.retotech.service.CitizenService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CitizenController.class)
public class CitizenControllerTest {

  private static final String CITIZENS_ID = "/api/v1/citizens/{id}";
  @Autowired private MockMvc mockMvc;

  @MockBean protected CitizenService citizenService;

  @Autowired private ObjectMapper objectMapper;

  @Before
  public void setup() {
    Citizen citizen = createCitizen();
    Optional<Citizen> optionalCitizen = Optional.ofNullable(citizen);
    given(this.citizenService.findById(1)).willReturn(optionalCitizen);
  }

  private Citizen createCitizen() {
    Citizen citizen = new Citizen();
    citizen.setId(1);
    citizen.setFirstName("Pedro");
    citizen.setLastName("Diaz");
    citizen.setBirthDay(new Date());
    citizen.setDeathDate(new Date());
    return citizen;
  }

  @Test
  public void findAll() throws Exception {
    mockMvc.perform(get("/api/v1/citizens")).andExpect(status().isOk());
  }

  @Test
  public void findAllAdult() throws Exception {
    mockMvc.perform(get("/api/v1/citizens/adults")).andExpect(status().isOk());
  }

  @Test
  public void findById() throws Exception {
    mockMvc.perform(get(CITIZENS_ID, "1")).andExpect(status().isOk());
  }

  @Test
  public void create() throws Exception {
    Citizen citizen = createCitizen();
    mockMvc
        .perform(
            post("/api/v1/citizens")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(citizen)))
        .andExpect(status().isOk());
  }

  @Test
  public void update() throws Exception {
    mockMvc
        .perform(
            put("/api/v1/citizens/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(objectMapper.writeValueAsString(createCitizen())))
        .andExpect(status().isOk());
  }

  @Test
  public void deleteCitizen() throws Exception {
    mockMvc
        .perform(delete("/api/v1/citizens/{id}", "1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}
