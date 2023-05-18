package org.example.patients.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.example.patients.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DefaultPatientFactoryTest {

  @Autowired private PatientFactory patientFactory;

  @Test
  @DisplayName("test createPatient given correct code should create a patient")
  public void testCreatePatientGivenCorrectCodeShouldCreateAPatient() {
    Assertions.assertTrue(patientFactory.createPatient("F") instanceof Fever);
    Assertions.assertTrue(patientFactory.createPatient("H") instanceof Healthy);
    Assertions.assertTrue(patientFactory.createPatient("D") instanceof Diabetes);
    Assertions.assertTrue(patientFactory.createPatient("T") instanceof Tuberculosis);
    Assertions.assertTrue(patientFactory.createPatient("X") instanceof Dead);
  }

  @Test
  @DisplayName("test createPatient given incorrect code should throw exception")
  public void testCreatePatientGivenIncorrectCodeShouldThrowException() {
    Assertions.assertThrows(
        IllegalStateException.class,
        () -> {
          patientFactory.createPatient("M");
        });
  }
}
