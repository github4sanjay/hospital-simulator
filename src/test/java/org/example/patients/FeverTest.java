package org.example.patients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.example.drugs.Drug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FeverTest {

  @Test
  @DisplayName("test fever when treated with paracetamol or aspirin should return Healthy")
  public void testFeverWhenTreatedWithParacetamolOrAspirinShouldReturnHealthy() {
    var patient = new Fever();
    Assertions.assertTrue(patient.treatment(Set.of(Drug.P)) instanceof Healthy);
    Assertions.assertTrue(patient.treatment(Set.of(Drug.As)) instanceof Healthy);
  }

  @Test
  @DisplayName("test fever when treated without paracetamol or aspirin should return Fever")
  public void testFeverWhenTreatedWithoutParacetamolOrAspirinShouldReturnHealthy() {
    var patient = new Fever();
    Assertions.assertTrue(patient.treatment(Set.of()) instanceof Fever);
  }
}
