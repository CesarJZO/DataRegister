package ui;

import javax.swing.*;
import java.awt.*;

public class Status extends JPanel {
    private final int COLUMNS = 10;
    private JLabel title;
    private JLabel minLabel;
    private JTextField minTextField;
    private JLabel maxLabel;
    private JTextField maxTextField;
    private JLabel avgLabel;
    private JTextField avgTextField;
    private JButton cleanButton;

    /**
     *
     */
    public Status() {
        title = new JLabel("Status");
        minLabel = new JLabel("Minimum");
        minTextField = new JTextField(COLUMNS);
        maxLabel = new JLabel("Maximum");
        maxTextField = new JTextField(COLUMNS);
        avgLabel = new JLabel("Average");
        avgTextField = new JTextField(COLUMNS);
        cleanButton = new JButton("Clean");

        minTextField.setEditable(false);
        maxTextField.setEditable(false);
        avgTextField.setEditable(false);
        add(title);
        add(minLabel);
        add(minTextField);
        add(maxLabel);
        add(maxTextField);
        add(avgLabel);
        add(avgTextField);
        add(cleanButton);
//        setLayout(new GridLayout(10, 1));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setCleanButton(JButton cleanButton) {
        this.cleanButton = cleanButton;
    }
    public JButton getCleanButton() {
        return cleanButton;
    }

    public void setResults(int min, int max, double avg) {
        minTextField.setText(min + "");
        maxTextField.setText(max + "");
        avgTextField.setText(avg + "");
    }

    public void resetPanel() {
        minTextField.setText("");
        maxTextField.setText("");
        avgTextField.setText("");
    }
}
