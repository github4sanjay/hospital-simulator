package org.example.sideeffects;

import java.util.Set;
import org.example.drugs.Drug;
import org.example.patients.Dead;
import org.example.patients.Fever;
import org.example.patients.Healthy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AspirinParacetamolCombinationTest {

  @Autowired private AspirinParacetamolCombination aspirinParacetamolCombination;

  @Test
  @DisplayName(
      "test AspirinParacetamolCombination given aspirin and paracetamol to a patient expect dead")
  public void testAspirinParacetamolCombinationGivenSspirinAndParacetamolToAPatientExpectDead() {
    var result = aspirinParacetamolCombination.check(Set.of(Drug.As, Drug.P), new Fever());
    Assertions.assertTrue(result instanceof Dead);
  }

  @Test
  @DisplayName(
      "test AspirinParacetamolCombination given only aspirin to a patient expect no side effect")
  public void testAspirinParacetamolCombinationGivenOnlyAspirinToAPatientExpectNoSideEffect() {
    var result = aspirinParacetamolCombination.check(Set.of(Drug.As), new Healthy());
    Assertions.assertTrue(result instanceof Healthy);
  }
}
