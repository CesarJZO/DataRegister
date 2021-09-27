package ui;

import javax.swing.*;

public class Sort extends JPanel {
    private final int N = 6;
    private final JButton[] sortButtons = new JButton[N];
    private final JLabel[] timeLabels = new JLabel[N];
    public Sort() {
        sortButtons[0] = new JButton("Selection");
        sortButtons[1] = new JButton("Insertion");
        sortButtons[2] = new JButton("Exchange");
        sortButtons[3] = new JButton("Shell sort");
        sortButtons[4] = new JButton("Quick sort");
        sortButtons[5] = new JButton("Heap sort");
        for (int i = 0; i < N; i++)
            timeLabels[i] = new JLabel("0 ms");
    }

    public JButton[] getButtons() {
        return sortButtons;
    }

    /**
     * Returns the specified button
     * @return Index per button
     *          0 -> Selection button
     *          1 -> Insertion button
     *          2 -> Exchange button
     *          3 -> Shell sort button
     *          4 -> Quick sort button
     *          5 -> Heap sort button
     */
    public JButton getButton(int i) {
        return sortButtons[i];
    }
}
