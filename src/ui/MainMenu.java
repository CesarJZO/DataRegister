package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JButton createLogBtn;
    private JButton sortBtn;
    private JButton consultBtn;
    private JButton viewLogBtn;

    public MainMenu() {
        createLogBtn = new JButton("Create log");
        sortBtn = new JButton("Sort");
        consultBtn = new JButton("Consult");
        viewLogBtn = new JButton("View log");
        setLayout(new GridLayout(2,2));
        add(createLogBtn);
        add(sortBtn);
        add(consultBtn);
        add(viewLogBtn);
    }

    public JButton getCreateLogBtn() {
        return createLogBtn;
    }

    public JButton getSortBtn() {
        return sortBtn;
    }

    public JButton getConsultBtn() {
        return consultBtn;
    }

    public JButton getViewLogBtn() {
        return viewLogBtn;
    }
}
