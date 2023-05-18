package org.example.patients;

import java.util.Set;
import org.example.drugs.Drug;

public interface Patient {

  Patient treatment(Set<Drug> drugs);

  String getCode();

}
