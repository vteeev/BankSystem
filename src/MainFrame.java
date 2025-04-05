import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BANK");

        add(new MainPanel());
        pack();
        setLocationRelativeTo(null);

        setResizable(false);
    }

}
