package htw.berlin.wi.prog2.ui;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class PizzaBotPromptProvider implements PromptProvider, Observer {

  private final PizzaBotCommands pizzaBotCommands;

  private int pizzaCount = 0;
  private boolean understood = true;

  @Autowired
  public PizzaBotPromptProvider(PizzaBotCommands pizzaBotCommands) {
      this.pizzaBotCommands = pizzaBotCommands;
  }

  @PostConstruct
  public void registerObserver() {
      pizzaBotCommands.addObserver(this);
  }

  @Override
  public void update() {
    pizzaCount = pizzaBotCommands.getOrderedPizzas().size();
  }

  @Override
  public AttributedString getPrompt() {
    if (understood) {
      return new AttributedString("PIZZA-BOT(" + pizzaCount + "):> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    } else {
      return new AttributedString("PIZZA-BOT(" + pizzaCount + "):> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }
  }

    @EventListener
    public void handleInputEvent(InputEvent event) {
        this.understood = event.getUnderstood();
    }
}