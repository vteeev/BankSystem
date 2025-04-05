import javax.swing.*;
import java.awt.*;

public class LogIN extends JPanel {
    private GridBagConstraints gbc;
    private JTextField loginField;
    private JPasswordField passwordField;

    public LogIN(MainPanel mainPanel) {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marginesy między elementami

        // Tworzenie elementów GUI
        addLabel("Login:", 0, 0);
        loginField = addTextField(1, 0);

        addLabel("Password:", 0, 1);
        passwordField = addPasswordField(1, 1);

        addButtons(mainPanel, 2);
        //addLogInButton(mainPanel,0,2);
        //addRegisterButton(mainPanel,0, 2);

    }

    // Metoda do dodawania etykiet
    private void addLabel(String text, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel(text), gbc);
    }

    // Metoda do dodawania pola tekstowego
    private JTextField addTextField(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.LINE_START;
        JTextField textField = new JTextField(15);
        add(textField, gbc);
        return textField;
    }

    // Metoda do dodawania pola hasła
    private JPasswordField addPasswordField(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.LINE_START;
        JPasswordField passwordField = new JPasswordField(15);
        add(passwordField, gbc);
        return passwordField;
    }

    private void addButtons(MainPanel mainPanel, int y) {
        gbc.insets = new Insets(25, 5, 5, 5); // Marginesy dla odstępu od pól tekstowych
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        // Panel dla przycisków
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JButton logInButton = new JButton("LogIN");
        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(e -> mainPanel.showPanel("Register"));

        buttonPanel.add(logInButton);
        buttonPanel.add(registerButton);

        add(buttonPanel, gbc);
    }

}
