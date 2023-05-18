package org.example.patients.factory;

import org.example.patients.Patient;

public interface PatientFactory {
  Patient createPatient(String code);
}
