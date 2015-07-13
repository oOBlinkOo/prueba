package demo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by oOBlinkOo on 7/12/15.
 */
@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "view";
    @Autowired
    private ViewGreeter viewGreeter;
    @Autowired
    private Greeter uiGreeter;
    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("Esta es la segunda vista"));
        addComponent(new Label(uiGreeter.sayHello("LOLOLOLO ")));
        addComponent(new Label(viewGreeter.sayHello()));

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}