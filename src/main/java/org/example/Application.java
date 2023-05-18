package org.example;

import org.example.simulator.Simulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private final Simulator simulator;

  public Application(Simulator simulator) {
    this.simulator = simulator;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    if (args.length > 2) {
      System.out.println("Invalid input");
      return;
    }
    var result = simulator.simulate(args);
    System.out.println(result);
  }
}
