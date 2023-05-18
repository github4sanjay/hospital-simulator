package org.example.simulator;

import java.util.ArrayList;
import java.util.HashSet;
import org.example.drugs.Drug;
import org.example.patients.Patient;
import org.example.patients.factory.PatientFactory;
import org.example.sideeffects.SideEffectChecker;
import org.example.store.PatientStore;
import org.springframework.stereotype.Component;

@Component
public class Simulator {

  private final PatientStore patientStore;
  private final PatientFactory patientFactory;
  private final SideEffectChecker sideEffectChecker;

  public Simulator(
      PatientStore patientStore,
      PatientFactory patientFactory,
      SideEffectChecker sideEffectChecker) {
    this.patientStore = patientStore;
    this.patientFactory = patientFactory;
    this.sideEffectChecker = sideEffectChecker;
  }

  public String simulate(String[] args) {
    String patientsCode = null;
    String drugCodes = null;
    if (args.length == 2) {
      patientsCode = args[0];
      drugCodes = args[1];
    } else if (args.length == 1) {
      patientsCode = args[0];
    }

    var patients = getPatients(patientsCode);
    var drugSet = getDrugs(drugCodes);

    for (var patient : patients) {
      // check treatment
      var result = patient.treatment(drugSet);

      // check side effect
      result = sideEffectChecker.check(drugSet, result);

      // store
      patientStore.add(result.getCode());
    }
    return patientStore.get();
  }

  private HashSet<Drug> getDrugs(String drugCodes) {
    var drugSet = new HashSet<Drug>();
    if (drugCodes != null) {
      for (var drugCode : drugCodes.split(",")) {
        drugSet.add(Drug.valueOf(drugCode));
      }
    }
    return drugSet;
  }

  private ArrayList<Patient> getPatients(String patientsCode) {
    var patients = new ArrayList<Patient>();
    if (patientsCode != null) {
      for (var patientCode : patientsCode.split(",")) {
        patients.add(patientFactory.createPatient(patientCode));
      }
    }
    return patients;
  }
}
