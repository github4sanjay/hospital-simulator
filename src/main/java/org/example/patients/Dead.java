package org.example.patients;

import java.util.Random;
import java.util.Set;
import org.example.drugs.Drug;

public class Dead implements Patient {

  @Override
  public Patient treatment(Set<Drug> drugs) {
    // will give an int between 1 - 1000000
    int result = new Random().nextInt(1000000) + 1;
    if (result == 1) {
      return new Healthy();
    }
    return this;
  }

  @Override
  public String getCode() {
    return "X";
  }
}
