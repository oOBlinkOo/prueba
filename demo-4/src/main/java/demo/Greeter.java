package demo;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Greeter {
    public String sayHello(String x) {
        return "Bienvenido " + x;

    }
 
}
