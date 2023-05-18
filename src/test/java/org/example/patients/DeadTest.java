package org.example.patients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.example.drugs.Drug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeadTest {

  @Test
  @DisplayName("test dead given anything always return Dead")
  public void testDeadGivenAnythingAlwaysReturnDead() {
    var patient = new Dead();
    Assertions.assertTrue(patient.treatment(Set.of(Drug.As)) instanceof Dead);
  }
}
