package demo;


import Modelo.Employee;
import Util.HibernateUtil;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by oOBlinkOo on 7/10/15.
 */
@Theme("valo")
@SpringUI
public class MyVaadinUI extends UI {
    private TextField username;
    private TextField pass;

    // we can use either constructor autowiring or field autowiring
    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(username= new TextField("Usuario","admin"));
        username.setWidth(15, Unit.EM);
        navigationBar.addComponent(pass= new TextField("Usuario","admin"));
        pass.setWidth(15, Unit.EM);

        navigationBar.addComponent(createNavigationButton("UI Scoped View",
                UIScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));

        navigationBar.addComponent(botonhibernate());
        root.addComponent(navigationBar);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
//        ManageEmployee manageEmployee = new ManageEmployee();
//        manageEmployee.addEmployee("letitgo","JOJOJO",49);
       // prueba();
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    getUI().getNavigator().navigateTo(viewName);
                } catch (Exception e) {
                    Notification.show("se produjo una excepcion!!!" + e);
                }
            }

        } );
///////////////////////////////////////
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent event) {
//                try {
//                    getUI().getNavigator().navigateTo(viewName);
//                } finally {
//
//                }
//            }
//        });
        return button;
    }

    private Button botonhibernate() {
        Button button = new Button("Insertar a BD");
        final Employee qq = new Employee(username.getValue(),pass.getValue());
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {

                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    session.save(qq);
                    session.getTransaction().commit();
                    Query q = session.createQuery("From Employee ");
                    System.out.println(q);

                    List<Employee> resultList = q.list();
                    System.out.println("num of employess:" + resultList.size());
                    for (Employee next : resultList) {
                        System.out.println("next employee: " + next);
                    }

                } catch (Exception e) {
                    Notification.show("se produjo una excepcion!!!" + e);
                }
            }

        } );
///////////////////////////////////////
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent event) {
//                try {
//                    getUI().getNavigator().navigateTo(viewName);
//                } finally {
//
//                }
//            }
//        });
        return button;
    }

    public void prueba(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Employee x = new Employee("num1", "num2");
        Employee x1 = new Employee("nose", "nose");


        session.save(x);
        session.save(x1);



        session.getTransaction().commit();

        Query q = session.createQuery("From Employee ");
        System.out.println(q);

        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }

    }



}
