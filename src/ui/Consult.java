package ui;

import javax.swing.*;

public class Consult extends JPanel {
    private JLabel noElementsLabel = new JLabel("Elements in a range");
    private JLabel minElementLabel = new JLabel("Min");
    private JLabel maxElementLabel = new JLabel("Max");
    private JTextField minTextField = new JTextField(4);
    private JTextField maxTextField = new JTextField(4);
    private JLabel repeatedLabel = new JLabel("Times repeated");
    private JTextField repeatedTextField = new JTextField(10);
    private JLabel diffValLabel = new JLabel("Different Values");
    private JTextField diffValTextField = new JTextField(10);
    private JLabel mostCommNumLabel = new JLabel("Most common number");
    private JTextField mostCommNumTextField = new JTextField(10);
    public Consult() {
        diffValTextField.setEditable(false);
        mostCommNumTextField.setEditable(false);
        add(noElementsLabel);
        add(minElementLabel);
        add(minTextField);
        add(maxElementLabel);
        add(maxTextField);
        add(repeatedLabel);
        add(repeatedTextField);
        add(diffValLabel);
        add(diffValTextField);
        add(mostCommNumLabel);
        add(mostCommNumTextField);
    }

    public int getMin() {
        return Integer.parseInt(minTextField.getText());
    }

    public int getMax() {
        return Integer.parseInt(maxTextField.getText());
    }
}
