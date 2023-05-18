package org.example.patients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.example.drugs.Drug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TuberculosisTest {

  @Test
  @DisplayName("test fever when treated with antibiotic should return Healthy")
  public void testFeverWhenTreatedWithParacetamolOrAspirinShouldReturnHealthy() {
    var patient = new Tuberculosis();
    Assertions.assertTrue(patient.treatment(Set.of(Drug.An)) instanceof Healthy);
  }

  @Test
  @DisplayName("test fever when treated without antibiotic should return Tuberculosis")
  public void testFeverWhenTreatedWithoutParacetamolOrAspirinShouldReturnHealthy() {
    var patient = new Tuberculosis();
    Assertions.assertTrue(patient.treatment(Set.of()) instanceof Tuberculosis);
  }
}
