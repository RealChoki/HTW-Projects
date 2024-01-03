package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Pizza;
import htw.berlin.wi.prog2.domain.PizzaBuilder;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.parsing.ExtendableInputParser;
import htw.berlin.wi.prog2.data.MenuUtils;
import java.util.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class PizzaBotCommands implements Observable{

  private final List<Observer> observers = new ArrayList<>();
  final List<Pizza> orderedPizzas;

  private final ExtendableInputParser parser;
  private final PizzaBuilder builder;
  private final InputEventPublisher inputEventPublisher;
  private final Menu menu;

  public PizzaBotCommands(ExtendableInputParser parser, PizzaBuilder builder, InputEventPublisher inputEventPublisher) {
    this.inputEventPublisher = inputEventPublisher;
    this.orderedPizzas = new ArrayList<>();
    this.parser = parser;
    this.builder = builder;
    this.menu = Menu.getInstance();
  }

  public List<Pizza> getOrderedPizzas() {
    return Collections.unmodifiableList(orderedPizzas);
  }

  @Override
  public void addObserver(Observer obs) {
    observers.add(obs);
  }

  @Override
  public void removeObserver(Observer obs) {
    observers.remove(obs);
  }

  @Override
  public void notifyObservers() {
    for (Observer obs : observers) {
      obs.update();
    }
  }

  @ShellMethod("Order a pizza")
  public String order(@ShellOption({"-t", "--text"}) String inputLine) {
      Map<Long, Ingredient> articles = menu.getAllArticles();
      Map<String, Long> keywordsToIds = MenuUtils.focusOnNameAndInvert(articles);
      Map<Long, Integer> ingredientsCount = parser.idsAndCountFromInput(inputLine, keywordsToIds);
      List<Ingredient> ingredients = MenuUtils.ingredientsFromIdAndCount(ingredientsCount, articles);
      if(ingredients.isEmpty()) {
          inputEventPublisher.publishInputEvent(false);
          return "Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
                  + MenuUtils.focusOnNames(articles);
      } else {
          for (Ingredient ing : ingredients) builder.add(ing);
          Pizza pizza = builder.build();
          orderedPizzas.add(pizza);
          notifyObservers();
          List<String> ingrNames = new ArrayList<>(pizza.getIngredientNames());
          Collections.sort(ingrNames);
          inputEventPublisher.publishInputEvent(true);
          return "In Ordnung. Deine "+ orderedPizzas.size() + ". Pizza mit " + ingrNames +
                  " kostet " + String.format("%.2f", pizza.calculatePrice().doubleValue()) + " EUR." +
                  "\nGib <confirm> ein, um die Bestellung abzuschliessen oder bestelle eine weitere Pizza mit <order -t '...'>";
      }
  }

  @ShellMethod("Confirm your order")
  public String confirm() {
    double total = orderedPizzas.stream().mapToDouble(pizza -> pizza.calculatePrice().doubleValue()).sum();
    return "Vielen Dank für deine Bestellung. Du hast " + orderedPizzas.size() + " Pizzas bestellt. Die Gesamtsumme beträgt " + String.format("%.2f", total) + " EUR.";
  }
}