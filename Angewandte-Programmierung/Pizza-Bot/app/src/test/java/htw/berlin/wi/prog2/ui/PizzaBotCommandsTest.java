package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.data.MenuUtils;
import htw.berlin.wi.prog2.domain.Pizza;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.PizzaBuilder;
import htw.berlin.wi.prog2.parsing.ExtendableInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PizzaBotCommandsTest {

  @Mock
  private ExtendableInputParser inputParser;

  @Mock
  private PizzaBuilder pizzaBuilder;

  @Mock
  private InputEventPublisher inputEventPublisher;

  @InjectMocks
  private PizzaBotCommands classUnderTest;

  @Test
  @DisplayName("should pass user input to input parser")
  void shouldPassInputToParser() {
    String input = "Ich hätte gerne eine Italian-style-Pizza mit Sauce";
    classUnderTest.order(input);
    verify(inputParser).idsAndCountFromInput(matches(input), anyMap());
  }

  @Test
  @DisplayName("should print the whole menu if the input was not understood")
  void printMenu() {
    doReturn(emptyMap()).when(inputParser).idsAndCountFromInput(anyString(), anyMap());
    var actual = classUnderTest.order("irgendwas");
    assertTrue(actual.startsWith("Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
            + MenuUtils.focusOnNames(Menu.getInstance().getAllArticles())));
  }

  @Test
  @DisplayName("should return single pizza order summary")
  void returnSinglePizzaOrderSummary() {
    Ingredient baseMock = mock(Ingredient.class);
    doReturn("Teig").when(baseMock).toString();
    Ingredient sauceMock = mock(Ingredient.class);
    doReturn("Sauce").when(sauceMock).toString();
    Pizza pizzaMock = mock(Pizza.class);
    doReturn(List.of(baseMock.toString(), sauceMock.toString())).when(pizzaMock).getIngredientNames();
    doReturn(new BigDecimal("3.70")).when(pizzaMock).calculatePrice();
    doReturn(Map.of(1L, 1, 9L, 1)).when(inputParser).idsAndCountFromInput(anyString(), anyMap());
    doReturn(pizzaBuilder).when(pizzaBuilder).add(any());
    doReturn(pizzaMock).when(pizzaBuilder).build();

    String orderSummary = classUnderTest.order("any order");

    var expectedOrderSummary = "In Ordnung. Deine 1. Pizza mit [Sauce, Teig] kostet 3.70 EUR.\nGib <confirm> ein, " +
                               "um die Bestellung abzuschliessen oder bestelle eine weitere Pizza mit <order -t '...'>";
    assertEquals(expectedOrderSummary, orderSummary);
  }

  @Test
  @DisplayName("should return order confirmation")
  void returnOrderConfirmation() {
    Pizza pizzaMock1 = mock(Pizza.class);
    Pizza pizzaMock2 = mock(Pizza.class);
    doReturn(new BigDecimal("7.50")).when(pizzaMock1).calculatePrice();
    doReturn(new BigDecimal("5.30")).when(pizzaMock2).calculatePrice();
    classUnderTest.orderedPizzas.addAll(List.of(pizzaMock1, pizzaMock2));

    String actual = classUnderTest.confirm();

    var expectedMessage = "Vielen Dank für deine Bestellung. Du hast 2 Pizzas bestellt. Die Gesamtsumme beträgt 12.80 EUR.";
    assertEquals(expectedMessage, actual);
  }
}
