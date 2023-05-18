package org.example.sideeffects;

import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Patient;

public interface SideEffect {
  Patient check(Set<Drug> drugs, Patient patient);
}
