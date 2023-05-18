package org.example.store;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PatientStore {
  private final Map<String, Integer> store;

  public PatientStore() {
    store = new HashMap<>();
  }

  public void add(String code) {
    store.merge(code, 1, Integer::sum);
  }

  public String get() {
    return "F:"
        + store.getOrDefault("F", 0)
        + ",H:"
        + store.getOrDefault("H", 0)
        + ",D:"
        + store.getOrDefault("D", 0)
        + ",T:"
        + store.getOrDefault("T", 0)
        + ",X:"
        + store.getOrDefault("X", 0);
  }
}
