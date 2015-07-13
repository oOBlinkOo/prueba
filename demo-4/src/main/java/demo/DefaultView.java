package demo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by oOBlinkOo on 7/12/15.
 */
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Al tener view Name pasa eso pero tengo q ver pk se pone en el contenedor"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}