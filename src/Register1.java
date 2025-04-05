import javax.swing.*;
import java.awt.*;

public class Register1 extends JPanel {
    private GridBagConstraints gbc;
    private JButton logInButton, nextButton, backButton;
    private JPanel formPanel1, formPanel2, mainFormPanel;
    private CardLayout cardLayout;
    private int currentStep = 1;

    public Register1(MainPanel mainPanel) {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        setLayout(new BorderLayout()); // Główny layout na BorderLayout

        // Tworzymy panel na przycisk "Log In" (poza siatką)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Przyciski wyrównane do lewej
        logInButton = new JButton("Log In");
        logInButton.addActionListener(e -> mainPanel.showPanel("LogIN"));
        topPanel.add(logInButton);
        add(topPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainFormPanel = new JPanel(cardLayout);

        formPanel1 = createFirstFormPanel();
        formPanel2 = createSecondFormPanel();

        mainFormPanel.add(formPanel1, "Form1");
        mainFormPanel.add(formPanel2, "Form2");


        // Dodajemy formularz w centrum
        add(mainFormPanel, BorderLayout.CENTER);
    }
    private JPanel createFirstFormPanel(){
        // Panel główny z GridBagLayout (do pól rejestracji)
        JPanel formPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        // Dodajemy etykiety i pola tekstowe
        addLabel(formPanel, "Name:", 0, 0);
        addTextField(formPanel, 1, 0);

        addLabel(formPanel, "Surname:", 0, 1);
        addTextField(formPanel, 1, 1);

        addLabel(formPanel, "Address:", 0, 2);
        addTextField(formPanel, 1, 2);

        addLabel(formPanel, "E-mail:", 0, 3);
        addTextField(formPanel, 1, 3);

        gbc.insets = new Insets(35, 5, 10, 5);
        addNavigationButtons(formPanel);

        return formPanel;
    }
    private JPanel createSecondFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        addLabel(panel, "Phone:", 0, 0);
        addTextField(panel, 1, 0);

        addLabel(panel, "Password:", 0, 1);
        addPasswordField(panel, 1, 1);

        addLabel(panel, "Confirm Password:", 0, 2);
        addPasswordField(panel, 1, 2);

        gbc.insets = new Insets(35, 5, 10, 5);
        addNavigationButtons(panel);

        return panel;
    }

    // Metoda do dodawania etykiety
    private void addLabel(JPanel panel, String text, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(new JLabel(text), gbc);
    }

    // Metoda do dodawania pola tekstowego
    private void addTextField(JPanel panel, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        JTextField textField = new JTextField(15);
        panel.add(textField, gbc);  // Dodajemy utworzone pole tekstowe do panelu
    }
    private void addPasswordField(JPanel panel,int x, int y) {
        gbc.gridx =x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);
    }

    private void addNavigationButtons(JPanel panel) {
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        backButton = new JButton("Back");
        backButton.addActionListener(e -> changeStep(-1));
        backButton.setEnabled(false); // Na początku nie można się cofnąć
        buttonPanel.add(backButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> changeStep(1));
        buttonPanel.add(nextButton);

        panel.add(buttonPanel, gbc);
    }

    // Metoda do zmiany kroku rejestracji
    private void changeStep(int stepChange) {
        currentStep += stepChange;

        if (currentStep == 1) {
            cardLayout.show(mainFormPanel, "Form1");
            backButton.setEnabled(false);
            nextButton.setEnabled(true);
        } else if (currentStep == 2) {
            cardLayout.show(mainFormPanel, "Form2");
            backButton.setEnabled(true);
            nextButton.setEnabled(false);
        }
    }
}
