package ui;

import javax.swing.*;

public class CreateRegister extends JPanel {
    private int columns;
    private JLabel title;
    private JLabel sizeLabel;
    private JTextField sizeTextField;
    private JLabel boundLabel;
    private JTextField boundTextField;
    private JButton createButton;
    private JButton backBtn;

    public CreateRegister() {
        columns = 10;
        title = new JLabel("Title");
        sizeLabel = new JLabel("Length");
        sizeTextField = new JTextField(columns);
        boundLabel = new JLabel("Bound");
        boundTextField = new JTextField(columns);
        createButton = new JButton("Create");
        add(title);
        add(sizeLabel);
        add(sizeTextField);
        add(boundLabel);
        add(boundTextField);
        add(createButton);
        new BoxLayout(this, BoxLayout.Y_AXIS);
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
        add(backBtn);
    }
    public JButton getCreateButton() {
        return createButton;
    }

    public int getLength() {
        return Integer.parseInt(sizeTextField.getText());
    }
    public int getBound() {
        return Integer.parseInt(boundTextField.getText());
    }
}
