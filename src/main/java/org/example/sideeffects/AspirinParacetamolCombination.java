package org.example.sideeffects;

import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Dead;
import org.example.patients.Patient;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** A SideEffect from combination of aspirin and paracetamol given to a patient. */
@Component
@Order(value = 1)
public class AspirinParacetamolCombination implements SideEffect {

  @Override
  public Patient check(Set<Drug> drugs, Patient patient) {
    if (drugs.contains(Drug.As) && drugs.contains(Drug.P)) {
      return new Dead();
    }
    return patient;
  }
}
