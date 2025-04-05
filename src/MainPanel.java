import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    CardLayout cardLayout;
    LogIN logIN;
    Register1 register;

    public MainPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        logIN = new LogIN(this);
        register = new Register1(this);

        add(logIN, "LogIN");
        add(register, "Register");

        cardLayout.show(this, "LogIN");  // Start od ekranu logowania
    }

    public void showPanel(String panelName) {
        cardLayout.show(this, panelName);
    }
}


