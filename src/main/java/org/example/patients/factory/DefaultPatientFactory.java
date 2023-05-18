package org.example.patients.factory;

import org.example.patients.*;
import org.springframework.stereotype.Component;

@Component
public class DefaultPatientFactory implements PatientFactory {

  @Override
  public Patient createPatient(String code) {
    return switch (code) {
      case "F" -> new Fever();
      case "H" -> new Healthy();
      case "D" -> new Diabetes();
      case "T" -> new Tuberculosis();
      case "X" -> new Dead();
      default -> throw new IllegalStateException("Unexpected code for patient");
    };
  }
}
