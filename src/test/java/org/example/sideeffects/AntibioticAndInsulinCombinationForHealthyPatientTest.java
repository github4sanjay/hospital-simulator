package org.example.sideeffects;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Fever;
import org.example.patients.Healthy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AntibioticAndInsulinCombinationForHealthyPatientTest {

  @Autowired
  private AntibioticAndInsulinCombinationForHealthyPatient
      antibioticAndInsulinCombinationForHealthyPatient;

  @Test
  @DisplayName(
      "test AntibioticAndInsulinCombinationForHealthyPatient given antibiotic and insulin to a healthy patient expect fever")
  public void
      testAntibioticAndInsulinCombinationForHealthyPatientGivenAntibioticAndInsulinToAHealthyPatientExpectFever() {
    var result =
        antibioticAndInsulinCombinationForHealthyPatient.check(
            Set.of(Drug.An, Drug.I), new Healthy());
    Assertions.assertTrue(result instanceof Fever);
  }

  @Test
  @DisplayName(
      "test AntibioticAndInsulinCombinationForHealthyPatient given only antibiotic to a healthy patient expect no side effect")
  public void
      testAntibioticAndInsulinCombinationForHealthyPatientGivenOnlyAntibioticToAHealthyPatientExpectNoSideEffect() {
    var result =
        antibioticAndInsulinCombinationForHealthyPatient.check(Set.of(Drug.An), new Healthy());
    Assertions.assertTrue(result instanceof Healthy);
  }
}
