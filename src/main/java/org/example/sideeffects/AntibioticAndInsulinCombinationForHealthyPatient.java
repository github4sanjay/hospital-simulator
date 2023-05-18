package org.example.sideeffects;

import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Fever;
import org.example.patients.Healthy;
import org.example.patients.Patient;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** A SideEffect from combination of antibiotic and insulin given to healthy patient. */
@Component
@Order(value = 2)
public class AntibioticAndInsulinCombinationForHealthyPatient implements SideEffect {

  @Override
  public Patient check(Set<Drug> drugs, Patient patient) {
    if (patient instanceof Healthy && drugs.contains(Drug.An) && drugs.contains(Drug.I)) {
      return new Fever();
    }
    return patient;
  }
}
