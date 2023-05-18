package org.example.sideeffects;

import static org.junit.jupiter.api.Assertions.*;

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
class DefaultSideEffectCheckerTest {

  @Autowired private SideEffectChecker sideEffectChecker;

  @Test
  @DisplayName("test given aspirin and paracetamol together returns Dead")
  public void testGivenAspirinAndParacetamolTogetherReturnsDead() {
    var result = sideEffectChecker.check(Set.of(Drug.As, Drug.P), new Healthy());
    Assertions.assertTrue(result instanceof Dead);
  }

  @Test
  @DisplayName("test given antibiotic and insulin to a healthy person together returns Fever")
  public void testGivenAntibioticAndInsulinToAHealthyPersonTogetherReturnsFever() {
    var result = sideEffectChecker.check(Set.of(Drug.An, Drug.I), new Healthy());
    Assertions.assertTrue(result instanceof Fever);
  }

  @Test
  @DisplayName("test given no combination of side effect drugs return same")
  public void testGivenNoCombinationOfSideEffectDrugsReturnSame() {
    var result = sideEffectChecker.check(Set.of(Drug.P), new Healthy());
    Assertions.assertTrue(result instanceof Healthy);
  }
}
