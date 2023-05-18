package org.example.sideeffects;

import java.util.List;
import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Patient;
import org.springframework.stereotype.Component;

@Component
public class DefaultSideEffectChecker implements SideEffectChecker {

  // ordered list of side effects
  private final List<SideEffect> sideEffects;

  public DefaultSideEffectChecker(List<SideEffect> sideEffects) {
    this.sideEffects = sideEffects;
  }

  public Patient check(Set<Drug> drugs, Patient patient) {

    for (var sideEffect : sideEffects) {
      var sideEffectedPatient = sideEffect.check(drugs, patient);
      if (!sideEffectedPatient.getCode().equals(patient.getCode())) {
        // there is side effect
        return sideEffectedPatient;
      }
    }

    return patient;
  }
}
