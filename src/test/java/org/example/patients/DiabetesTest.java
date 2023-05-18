package org.example.patients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.example.drugs.Drug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiabetesTest {

  @Test
  @DisplayName("test diabetes given without insulin will return Dead")
  public void testDiabetesGivenWithoutInsulinWillReturnDead() {
    var patient = new Diabetes();
    Assertions.assertTrue(patient.treatment(Set.of(Drug.As)) instanceof Dead);
  }

  @Test
  @DisplayName("test diabetes given treated with insulin will return Diabetes")
  public void testDiabetesGivenTreatedWithInsulinWillReturnDiabetes() {
    var patient = new Diabetes();
    Assertions.assertTrue(patient.treatment(Set.of(Drug.I)) instanceof Diabetes);
  }
}
