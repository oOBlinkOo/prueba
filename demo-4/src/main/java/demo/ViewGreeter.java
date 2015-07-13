package demo;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

/**
 * Created by oOBlinkOo on 7/12/15.
 */
@SpringComponent
@ViewScope
public class ViewGreeter {
    public String sayHello() {
        return "Hello from a view scoped bean " + toString();
    }
}