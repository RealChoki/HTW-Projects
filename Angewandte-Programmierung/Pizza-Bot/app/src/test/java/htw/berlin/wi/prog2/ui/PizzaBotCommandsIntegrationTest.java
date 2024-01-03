package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.domain.PizzaBuilder;
import htw.berlin.wi.prog2.parsing.CountingInputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzaBotCommandsIntegrationTest {

  private PizzaBotCommands classUnderTest;

  @BeforeEach
  void setup() {
    classUnderTest = new PizzaBotCommands(
        new CountingInputParser(),
        new PizzaBuilder(),
        new InputEventPublisher());
  }

  @Test
  @DisplayName("should understand a simple order and list the pizza's individual ingredients and it's price")
  void testSimpleOrder() {
    String simpleOrder = "Ich hätte gerne eine Italian-style Pizza mit Champignons, Basilikum, Seitan-Chicken und Olivenöl";

    var actual = classUnderTest.order(simpleOrder);

    var expectedMessage = "In Ordnung. Deine 1. Pizza mit [Basilikum, Champignons, Italian-style, Olivenöl, Seitan-Chicken] kostet 2.80 EUR.";
    assertTrue(actual.startsWith(expectedMessage));
  }
}
