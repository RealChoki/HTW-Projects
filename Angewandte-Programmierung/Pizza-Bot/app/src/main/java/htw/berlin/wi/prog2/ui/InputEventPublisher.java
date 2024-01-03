package htw.berlin.wi.prog2.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class InputEventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishInputEvent(final boolean understood) {
        if(publisher!=null) publisher.publishEvent(new InputEvent(understood));
    }
}