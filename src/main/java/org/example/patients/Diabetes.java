package org.example.patients;

import java.util.Set;
import org.example.drugs.Drug;

public class Diabetes implements Patient {

  @Override
  public Patient treatment(Set<Drug> drugs) {
    if (drugs.contains(Drug.I)) {
      return new Diabetes();
    } else {
      return new Dead();
    }
  }

  @Override
  public String getCode() {
    return "D";
  }
}
