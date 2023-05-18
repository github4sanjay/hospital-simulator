package org.example.patients;

import java.util.Set;
import org.example.drugs.Drug;

public class Healthy implements Patient {

  @Override
  public Patient treatment(Set<Drug> drugs) {
    return this;
  }

  @Override
  public String getCode() {
    return "H";
  }
}
