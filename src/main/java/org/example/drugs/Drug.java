package org.example.drugs;

public enum Drug {
  As("Aspirin"),
  An("Antibiotic"),
  I("Antibiotic"),
  P("Paracetamol");

  private final String code;

  Drug(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
