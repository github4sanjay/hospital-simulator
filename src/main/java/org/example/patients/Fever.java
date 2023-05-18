package org.example.patients;

import java.util.Set;
import org.example.drugs.Drug;

public class Fever implements Patient {

  @Override
  public Patient treatment(Set<Drug> drugs) {
    if (drugs.contains(Drug.P) || drugs.contains(Drug.As)) {
      return new Healthy();
    }
    return this;
  }

  @Override
  public String getCode() {
    return "F";
  }
}
