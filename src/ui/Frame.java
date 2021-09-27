package ui;

import sorting.DataRegister;
import javax.swing.*;

public class Frame extends JFrame {
    DataRegister array = new DataRegister(10, 10);

    Frame () {
        super("Data Register");
        array.quickSort();
        MainMenu mainMenu = new MainMenu();
        Status status = new Status();
        mainMenu.getCreateLogBtn().addActionListener(
                e -> JOptionPane.showMessageDialog(
                        this, status
                )
        );
        add(mainMenu);
        status.setResults(0,10,5);
        status.getCleanButton().addActionListener(e -> status.resetPanel());
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
