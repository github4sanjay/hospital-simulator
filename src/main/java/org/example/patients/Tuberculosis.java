package org.example.patients;

import java.util.Set;
import org.example.drugs.Drug;

public class Tuberculosis implements Patient {

  @Override
  public Patient treatment(Set<Drug> drugs) {
    if (drugs.contains(Drug.An)) {
      return new Healthy();
    }
    return this;
  }

  @Override
  public String getCode() {
    return "T";
  }
}
