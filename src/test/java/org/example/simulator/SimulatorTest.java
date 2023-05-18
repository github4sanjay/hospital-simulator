package org.example.simulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SimulatorTest {

  @Autowired private Simulator simulator;

  @Test
  @DisplayName("test simulator when both patient and drugs args are passed expect correct result")
  public void testSimulatorWhenBothPatientAndDrugsArgsArePassedExpectCorrectResult() {
    var result = simulator.simulate(new String[] {"T,F,D", "An,I"});
    Assertions.assertEquals("F:2,H:0,D:1,T:0,X:0", result);
  }

  @Test
  @DisplayName("test simulator when only patient arg is passed expect correct result")
  public void testSimulatorWhenOnlyPatientArgIsPassedExpectCorrectResult() {
    var result = simulator.simulate(new String[] {"D,D"});
    Assertions.assertEquals("F:0,H:0,D:0,T:0,X:2", result);
  }

  @Test
  @DisplayName(
      "test simulator when fever patient is treaded with paracetamol expect healthy count 1")
  public void testSimulatorWhenFeverPatientIsTreadedWithParacetamolExpectHealthyCount1() {
    var result = simulator.simulate(new String[] {"F", "P"});
    Assertions.assertEquals("F:0,H:1,D:0,T:0,X:0", result);
  }
}
