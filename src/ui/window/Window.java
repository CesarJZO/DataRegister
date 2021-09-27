package ui.window;

import sorting.DataRegister;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;


public class Window extends JFrame {
    Thread thread;
    //MAIN PANEL
    private JPanel mainPanel;
    private JButton buttonShowLog;
    // END MAIN PANEL
    
    //MENU STATUS
    private JLabel menuStatus;
    private RoundJTextField minTextField, maxTextField, avgTextField;
    // END MENU STATUS
    
    // MENU SORT
    private JLabel menuSort;
    private JLabel[] timeLabels;
    // END MENU SORT

    //MENU CREATE LOG
    private JLabel menuCreateLog;
    private RoundJTextField sizeTextField;
    private RoundJTextField boundTextField;
    private JButton createButton;
    private JLabel errorNum, errorNum2;
    //END MENU CREARTE LOG

    //MENU CONSULT
    private RoundJTextField minTextFieldC;
    private RoundJTextField maxTextFieldC;
    private JLabel menuConsult;
    private RoundJTextField repeatedTextField;
    private RoundJTextField diffValTextField;
    private RoundJTextField mostCommNumTextField;
    //END MENU CONSULT

    //MENU VIEW LOG
    private JLabel menuViewLog;
    private JTextArea areaViewLog;
    private JTextArea areaOrderedLog;
    private JLabel errorNull, errorNull2;
    private JLabel timeSecuencial;
    private JLabel timeBinaria;
    // END MENU VIEW LOG

    //GLOBAL VARIABLES
    private final Color colorMainMenu = new Color(32, 32, 32);
    private final Color colorMenuDD = new Color(0, 0, 0);
    private final Color colorButtons = new Color(64, 64, 64);
    private final Color colorError = new Color(255, 0, 0);

    private final Font fontTextField = new Font("Calibri", Font.BOLD, 30);
    private final Font textFont = new Font("Helvetica", Font.PLAIN, 35);
    private final Font titleFont = new Font("Arial Nova Light", Font.BOLD, 55);
    private final Font buttonFont = new Font("Helvetica", Font.PLAIN, 25);
    private final Font buttonLFont = new Font("Helvetica", Font.PLAIN, 20);
    private final Font errorFont = new Font("Arial", Font.BOLD, 15);

    private final ButtonBack[] backButton = new ButtonBack[4];

    private DataRegister log;
    //28, 41, 122   133, 149, 251
    //END GLOBAL VARIABLES

    /**
     * Constructs a JFrame using auxiliary methods to add all the JPanels and its contents
     */
    public Window(){ 
        setSize(1280, 990);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Data Register");
        setLocationRelativeTo(null);
        setComponents();
    }

    /**
     * Auxiliary method that sets the initial status of the main panel
     */
    private void setComponents() {
        mainPanel = new JPanel();
        mainPanel.setVisible(true);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(true);
        mainPanel.setBackground(colorMainMenu);
        
        setMainMenu();
        setMenuStatus();
        setMenuCreateLog();
        setMenuSort();
        setMenuConsult();
        setMenuViewLog();
        setCreateLogButton();
        setViewLogBtn();
        setActListenerBackButton();
        this.add(mainPanel);
    }

    /**
     * Auxiliary method that sets the initial status of the main menu panel
     */
    private void setMainMenu() {
        ImageIcon imageCreateLog = new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/ui/images/create_log_button.png")));
        JLabel logoCreateLog = new JLabel();
        logoCreateLog.setBounds(100, 50, 250, 250);
        logoCreateLog.setIcon(new ImageIcon(imageCreateLog.getImage().getScaledInstance(logoCreateLog.getWidth(),
                logoCreateLog.getHeight(), Image.SCALE_SMOOTH)));
        mainPanel.add(logoCreateLog);

        JButton buttonCreateLog = new JButton("Create Log");
        buttonCreateLog.setBounds(150, 350, 150, 30);
        buttonCreateLog.setBorder(null);
        buttonCreateLog.setBackground(colorButtons);
        buttonCreateLog.setForeground(Color.WHITE);
        buttonCreateLog.setFont(buttonLFont);
        buttonCreateLog.addActionListener(ae -> {
            menuStatus.setVisible(false);
            menuCreateLog.setVisible(true);
            menuSort.setVisible(false);
            menuConsult.setVisible(false);
            menuViewLog.setVisible(false);
        });
        mainPanel.add(buttonCreateLog);
        
        ImageIcon imageSort = new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/ui/images/sort_button.png")));
        JLabel logoSort = new JLabel();
        logoSort.setBounds(500, 50, 250, 250);
        logoSort.setIcon(new ImageIcon(imageSort.getImage().getScaledInstance(logoSort.getWidth(),
                logoSort.getHeight(), Image.SCALE_SMOOTH)));
        mainPanel.add(logoSort);

        String unCreatedError = "You must create a log otherwise you cannot interact with this option";

        JButton buttonSort = new JButton("Sort");
        buttonSort.setBounds(550, 350, 150, 30);
        buttonSort.setBorder(null);
        buttonSort.setBackground(colorButtons);
        buttonSort.setForeground(Color.WHITE);
        buttonSort.setFont(buttonLFont);
        buttonSort.addActionListener(ae -> {
            if (log == null)
                JOptionPane.showMessageDialog(this, unCreatedError);
            else {
                menuStatus.setVisible(false);
                menuCreateLog.setVisible(false);
                menuSort.setVisible(true);
                menuConsult.setVisible(false);
                menuViewLog.setVisible(false);
            }
        });
        mainPanel.add(buttonSort);
        
        ImageIcon imageConsult = new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/ui/images/consult_button.png")));
        JLabel logoConsult = new JLabel();
        logoConsult.setBounds(100, 500, 250, 250);
        logoConsult.setIcon(new ImageIcon(imageConsult.getImage().getScaledInstance(logoConsult.getWidth(),
                logoConsult.getHeight(), Image.SCALE_SMOOTH)));
        mainPanel.add(logoConsult);

        JButton buttonConsult = new JButton("Consult");
        buttonConsult.setBounds(150, 800, 150, 30);
        buttonConsult.setBorder(null);
        buttonConsult.setBackground(colorButtons);
        buttonConsult.setForeground(Color.WHITE);
        buttonConsult.setFont(buttonLFont);
        buttonConsult.addActionListener(ae -> {
            if (log == null)
                JOptionPane.showMessageDialog(this, unCreatedError);
            else {
                menuStatus.setVisible(false);
                menuCreateLog.setVisible(false);
                menuSort.setVisible(false);
                menuConsult.setVisible(true);
                menuViewLog.setVisible(false);
            }
        });
        mainPanel.add(buttonConsult);
        
        ImageIcon imageViewLog = new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/ui/images/view_log_button.png")));
        JLabel logoViewLog = new JLabel();
        logoViewLog.setBounds(500, 500, 250, 250);
        logoViewLog.setIcon(new ImageIcon(imageViewLog.getImage().getScaledInstance(logoViewLog.getWidth(),
                logoViewLog.getHeight(), Image.SCALE_SMOOTH)));
        mainPanel.add(logoViewLog);
        
        buttonShowLog = new JButton("View Log");
        buttonShowLog.setBounds(550, 800, 150, 30);
        buttonShowLog.setBorder(null);
        buttonShowLog.setBackground(colorButtons);
        buttonShowLog.setForeground(Color.WHITE);
        buttonShowLog.setFont(buttonLFont);
        buttonShowLog.addActionListener(ae -> {
            if (log == null)
                JOptionPane.showMessageDialog(this, unCreatedError);
            else {
                menuStatus.setVisible(false);
                menuCreateLog.setVisible(false);
                menuSort.setVisible(false);
                menuConsult.setVisible(false);
                menuViewLog.setVisible(true);
            }
        });
        mainPanel.add(buttonShowLog);
        
    }

    /**
     * Auxiliary method that sets the initial status of the status menu panel
     */
    private void setMenuStatus(){
        menuStatus = new JLabel();
        menuStatus.setBackground(colorMenuDD);
        menuStatus.setOpaque(true);
        menuStatus.setBounds(880, 0, 400, 990);
        menuStatus.setVisible(true);
        mainPanel.add(menuStatus);
        
        JLabel status = new JLabel("Status");
        status.setFont(titleFont);
        status.setForeground(Color.WHITE);
        status.setBounds(110, 100, 335, 50);
        menuStatus.add(status);        
        
        JLabel minLabel = new JLabel("Minimum");
        minLabel.setBounds(120, 200, 335, 50);
        minLabel.setForeground(Color.WHITE);
        minLabel.setFont(textFont);
        menuStatus.add(minLabel);
        
        minTextField = new RoundJTextField(1);
        minTextField.setFont(fontTextField);
        minTextField.setEditable(false);
        minTextField.setBounds(25, 250, 335, 50);
        minTextField.setHorizontalAlignment(0);
        menuStatus.add(minTextField);
        
        JLabel maxLabel = new JLabel("Maximum");
        maxLabel.setBounds(120, 400, 335, 50);
        maxLabel.setForeground(Color.WHITE);
        maxLabel.setFont(textFont);
        menuStatus.add(maxLabel);
        
        maxTextField = new RoundJTextField(1);
        maxTextField.setFont(fontTextField);
        maxTextField.setEditable(false);
        maxTextField.setBounds(25, 450, 335, 50);
        maxTextField.setHorizontalAlignment(0);
        menuStatus.add(maxTextField);
        
        JLabel avgLabel = new JLabel("Average");
        avgLabel.setBounds(120, 600, 335, 50);
        avgLabel.setForeground(Color.WHITE);
        avgLabel.setFont(textFont);
        menuStatus.add(avgLabel);
        
        avgTextField = new RoundJTextField(1);
        avgTextField.setFont(fontTextField);
        avgTextField.setEditable(false);
        avgTextField.setBounds(25, 650, 335, 50);
        avgTextField.setHorizontalAlignment(0);
        menuStatus.add(avgTextField);

        JButton cleanButton = new JButton("Clean");
        cleanButton.setFont(buttonFont);
        cleanButton.setBorder(null);
        cleanButton.setForeground(Color.WHITE);
        cleanButton.setBounds(140, 750, 100, 50);
        cleanButton.setBackground(colorButtons);
        cleanButton.addActionListener(e -> resetWindow());
        menuStatus.add(cleanButton);
    }

    /**
     * Auxiliary method that sets the initial status of the Create log menu panel
     */
    private void setMenuCreateLog() {
        menuCreateLog = new JLabel();
        menuCreateLog.setBackground(colorMenuDD);
        menuCreateLog.setOpaque(true);
        menuCreateLog.setBounds(880, 0, 400, 990);
        menuCreateLog.setVisible(false);
        
        JLabel createLog = new JLabel("Create Log");
        createLog.setBounds(50, 150, 335, 100);
        createLog.setForeground(Color.WHITE);
        createLog.setFont(titleFont);
        menuCreateLog.add(createLog);
        
        JLabel sizeLabel = new JLabel("Length");
        sizeLabel.setBounds(120, 300, 335, 50);
        sizeLabel.setForeground(Color.WHITE);
        sizeLabel.setFont(textFont);
        menuCreateLog.add(sizeLabel);
        
        sizeTextField = new RoundJTextField(1);
        sizeTextField.setFont(fontTextField);
        sizeTextField.setBounds(25, 350, 335, 50);
        sizeTextField.setHorizontalAlignment(0); 
        menuCreateLog.add(sizeTextField);

        String errorMessage = "Error: int expected";

        errorNum = new JLabel(errorMessage);
        errorNum.setBounds(125, 400, 335, 50);
        errorNum.setForeground(colorError);
        errorNum.setFont(errorFont);
        errorNum.setVisible(false);
        menuCreateLog.add(errorNum);
        
        JLabel boundLabel = new JLabel("Bound");
        boundLabel.setBounds(120, 500, 335, 50);
        boundLabel.setForeground(Color.WHITE);
        boundLabel.setFont(textFont);
        menuCreateLog.add(boundLabel);
        
        boundTextField = new RoundJTextField(1);
        boundTextField.setFont(fontTextField);
        boundTextField.setBounds(25, 550, 335, 50);
        boundTextField.setHorizontalAlignment(0);
        menuCreateLog.add(boundTextField);
        
        errorNum2 = new JLabel(errorMessage);
        errorNum2.setBounds(125, 600, 335, 50);
        errorNum2.setForeground(colorError);
        errorNum2.setFont(errorFont);
        errorNum2.setVisible(false);
        menuCreateLog.add(errorNum2);
        
        createButton = new JButton("Create");
        createButton.setFont(buttonFont);
        createButton.setBorder(null);
        createButton.setBounds(120, 750, 150, 50);
        createButton.setBackground(colorButtons);
        createButton.setForeground(Color.WHITE);
        menuCreateLog.add(createButton);
               
        backButton[0] = new ButtonBack("Back");
        backButton[0].setBounds(120, 850, 150, 50);
        menuCreateLog.add(backButton[0]);
        
        mainPanel.add(menuCreateLog);
    }

    /**
     * Auxiliary method that sets the initial status of the Sort menu panel
     */
    private void setMenuSort() {
        menuSort = new JLabel();
        menuSort.setBackground(colorMenuDD);
        menuSort.setOpaque(true);
        menuSort.setBounds(880, 0, 400, 990);
        menuSort.setVisible(false);
        mainPanel.add(menuSort);
        
        JLabel sort = new JLabel("Sort");
        sort.setBounds(150, 50, 335, 100);
        sort.setForeground(Color.WHITE);
        sort.setFont(titleFont);
        menuSort.add(sort);

        JButton[] sortButtons = new JButton[6];
        timeLabels = new JLabel[6];

        String[] sortLabels = {"Selection", "Insertion", "Bubble", "Shell sort", "Quick sort", "Heap sort"};

        for (int i = 0; i < sortButtons.length; i++)
            sortButtons[i] = new JButton(sortLabels[i]);
        
        int num = 200;
        for(int i = 0; i < 6; i++){
            sortButtons[i].setFont(buttonFont);
            sortButtons[i].setBounds(50, num, 150, 50);
            sortButtons[i].setBackground(colorButtons);
            sortButtons[i].setForeground(Color.WHITE);
            sortButtons[i].setBorder(null);
            menuSort.add(sortButtons[i]);
            num += 100; 
        }

        num = 200;
        for (int i = 0; i < 6; i++){
            timeLabels[i] = new JLabel("0 ms");
            timeLabels[i].setBounds(210, num, 335, 50);
            timeLabels[i].setForeground(Color.WHITE);
            timeLabels[i].setFont(textFont);
            menuSort.add(timeLabels[i]);
            num += 100;
        }

        sortButtons[0].addActionListener(e -> {
            thread = new Thread(() -> {
                long start = System.currentTimeMillis();
                log.selectSort();
                long finish = System.currentTimeMillis();
                log.reset();
                long deltaTime = finish - start;
                timeLabels[0].setText(deltaTime + " ms");
            });
            thread.start();
        });

        sortButtons[1].addActionListener(e -> {
            thread = new Thread(() -> {
                long start = System.currentTimeMillis();
                log.insertionSort();
                long finish = System.currentTimeMillis();
                log.reset();
                long deltaTime = finish - start;
                timeLabels[1].setText(deltaTime + " ms");
            });
            thread.start();
        });

        sortButtons[2].addActionListener(e -> {
            long start = System.currentTimeMillis();
            log.bubbleSort();
            long finish = System.currentTimeMillis();
            log.reset();
            long deltaTime = finish - start;
            timeLabels[2].setText(deltaTime + " ms");
        });

        sortButtons[3].addActionListener(e -> {
            long start = System.currentTimeMillis();
            log.shellSort();
            long finish = System.currentTimeMillis();
            log.reset();
            long deltaTime = finish - start;
            timeLabels[3].setText(deltaTime + " ms");
        });

        sortButtons[4].addActionListener(e -> {
            long start = System.currentTimeMillis();
            log.quickSort();
            long finish = System.currentTimeMillis();
            log.reset();
            long deltaTime = finish - start;
            timeLabels[4].setText(deltaTime + " ms");
        });

        sortButtons[5].addActionListener(e -> {
            long start = System.currentTimeMillis();
            log.heapSort();
            long finish = System.currentTimeMillis();
            log.reset();
            long deltaTime = finish - start;
            timeLabels[5].setText(deltaTime + " ms");
        });

        backButton[1] = new ButtonBack("Back");
        backButton[1].setBounds(120, 850, 150, 50);
        menuSort.add(backButton[1]);
    }

    /**
     * Auxiliary method that sets the initial status of the Consult menu panel
     */
    private void setMenuConsult() {
        menuConsult = new JLabel();
        menuConsult.setBackground(colorMenuDD);
        menuConsult.setOpaque(true);
        menuConsult.setBounds(880, 0, 400, 990);
        menuConsult.setVisible(false);
        mainPanel.add(menuConsult);
        
        JLabel consult = new JLabel("Consult");
        consult.setBounds(110, 10, 335, 100);
        consult.setForeground(Color.WHITE);
        consult.setFont(titleFont);
        menuConsult.add(consult);
        
        JLabel noElementsLabel = new JLabel("Elements in a range");
        noElementsLabel.setBounds(50, 100, 335, 50);
        noElementsLabel.setForeground(Color.WHITE);
        noElementsLabel.setFont(textFont);
        menuConsult.add(noElementsLabel);
        
        JLabel minElementLabel = new JLabel("Min");
        minElementLabel.setBounds(85, 150, 335, 50);
        minElementLabel.setForeground(Color.WHITE);
        minElementLabel.setFont(textFont);
        menuConsult.add(minElementLabel);

        minTextFieldC = new RoundJTextField(1);
        minTextFieldC.setFont(fontTextField);
        minTextFieldC.setBounds(35, 200, 150, 50);
        minTextFieldC.setHorizontalAlignment(0);
        menuConsult.add(minTextFieldC);

        JLabel errorMin = new JLabel("Error: int excepted");
        errorMin.setBounds(35, 240, 335, 50);
        errorMin.setForeground(colorError);
        errorMin.setFont(errorFont);
        errorMin.setVisible(false);
        menuConsult.add(errorMin);

        JLabel maxElementLabel = new JLabel("Max");
        maxElementLabel.setBounds(245, 150, 335, 50);
        maxElementLabel.setForeground(Color.WHITE);
        maxElementLabel.setFont(textFont);
        menuConsult.add(maxElementLabel);

        maxTextFieldC = new RoundJTextField(1);
        maxTextFieldC.setFont(fontTextField);
        maxTextFieldC.setBounds(210, 200, 150, 50);
        maxTextFieldC.setHorizontalAlignment(0);
        menuConsult.add(maxTextFieldC);

        JLabel errorMax = new JLabel("Error: int excepted");
        errorMax.setBounds(210, 240, 335, 50);
        errorMax.setForeground(colorError);
        errorMax.setFont(errorFont);
        errorMax.setVisible(false);
        menuConsult.add(errorMax);

        JLabel repeatedLabel = new JLabel("Times repeated");
        repeatedLabel.setBounds(85, 300, 335, 50);
        repeatedLabel.setForeground(Color.WHITE);
        repeatedLabel.setFont(textFont);
        menuConsult.add(repeatedLabel);

        repeatedTextField = new RoundJTextField(1);
        repeatedTextField.setFont(fontTextField);
        repeatedTextField.setBounds(25, 350, 350, 50);
        repeatedTextField.setHorizontalAlignment(0);
//        repeatedTextField.setEditable(true);
        menuConsult.add(repeatedTextField);

        JLabel errorConsult = new JLabel("Error: int excepted");
        errorConsult.setBounds(130, 390, 335, 50);
        errorConsult.setForeground(colorError);
        errorConsult.setFont(errorFont);
        errorConsult.setVisible(false);
        menuConsult.add(errorConsult);

        JLabel diffValLabel = new JLabel("Different Values");
        diffValLabel.setBounds(85, 550, 335, 50);
        diffValLabel.setForeground(Color.WHITE);
        diffValLabel.setFont(textFont);
        menuConsult.add(diffValLabel);
        
        diffValTextField = new RoundJTextField(1);
        diffValTextField.setFont(fontTextField);
        diffValTextField.setBounds(25, 600, 350, 50);
        diffValTextField.setHorizontalAlignment(0);
        diffValTextField.setEditable(false);
        menuConsult.add(diffValTextField);
        
        JLabel mostCommNumLabel = new JLabel("Most common number");
        mostCommNumLabel.setBounds(30, 700, 435, 50);
        mostCommNumLabel.setForeground(Color.WHITE);
        mostCommNumLabel.setFont(textFont);
        menuConsult.add(mostCommNumLabel);
        
        mostCommNumTextField = new RoundJTextField(1);
        mostCommNumTextField.setFont(fontTextField);
        mostCommNumTextField.setBounds(25, 750, 350, 50);
        mostCommNumTextField.setHorizontalAlignment(0);
        mostCommNumTextField.setEditable(false);
        menuConsult.add(mostCommNumTextField);


        JButton buttonConsult = new JButton("Consult");
        buttonConsult.setBounds(120, 450, 150, 50);
        buttonConsult.setBorder(null);
        buttonConsult.setBackground(colorButtons);
        buttonConsult.setForeground(Color.WHITE);
        buttonConsult.setFont(buttonFont);
        buttonConsult.addActionListener(ae -> {
            boolean error = false;
            int min = 0, max = 0, consultNumber = 0;

            try{
                min = Integer.parseInt(minTextFieldC.getText());
                errorMin.setVisible(false);
            }catch(Exception e){
                errorMin.setVisible(true);
                maxTextField.setText("");
                error = true;
            }

            try{
                max = Integer.parseInt(maxTextFieldC.getText());
                errorMax.setVisible(false);
            }catch(Exception e){
                errorMax.setVisible(true);
                maxTextField.setText("");
                error = true;
            }

            try{
                consultNumber = Integer.parseInt(repeatedTextField.getText());
                errorConsult.setVisible(false);
            }catch(Exception e){
                errorConsult.setVisible(true);
                repeatedTextField.setText("");
                error = true;
            }

            if(!error) {
                JOptionPane.showMessageDialog(this, "The range is: " +
                        log.calculateRange(min, max));

                repeatedTextField.setText(consultNumber + " is in the log " +
                        log.repeatedValue(consultNumber) + " times");
                repeatedTextField.setText(repeatedTextField.getText());
            }
        });
        menuConsult.add(buttonConsult);

        backButton[2] = new ButtonBack("Back");
        backButton[2].setBounds(120, 850, 150, 50);
        menuConsult.add(backButton[2]);
    }

    /**
     * Auxiliary method that sets the initial status of the View log menu panel
     */
    private void setMenuViewLog() {
        menuViewLog = new JLabel();
        menuViewLog.setBackground(colorMenuDD);
        menuViewLog.setOpaque(true);
        menuViewLog.setBounds(880, 0, 400, 990);
        menuViewLog.setVisible(false);
        mainPanel.add(menuViewLog);

        JLabel viewLog = new JLabel("View Log");
        viewLog.setBounds(100, 50, 335, 100);
        viewLog.setForeground(Color.WHITE);
        viewLog.setFont(titleFont);
        menuViewLog.add(viewLog);

        JLabel log = new JLabel("Log");
        log.setBounds(160, 150, 335, 50);
        log.setForeground(Color.WHITE);
        log.setFont(textFont);
        menuViewLog.add(log);

        areaViewLog = new JTextArea();
        areaViewLog.setFont(fontTextField);
        areaViewLog.setText("");
        areaViewLog.setEditable(false);

        errorNull = new JLabel("Error: any log has been created yet");
        errorNull.setBounds(25, 250, 335, 50);
        errorNull.setForeground(colorError);
        errorNull.setFont(errorFont);
        errorNull.setVisible(false);
        menuViewLog.add(errorNull);

        JScrollPane scrollViewLog = new JScrollPane(areaViewLog,JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollViewLog.setBounds(30, 200, 335, 50);
        menuViewLog.add(scrollViewLog);

        JLabel orderedLog = new JLabel("OrderedLog");
        orderedLog.setBounds(100, 350, 335, 50);
        orderedLog.setForeground(Color.WHITE);
        orderedLog.setFont(textFont);
        menuViewLog.add(orderedLog);

        areaOrderedLog = new JTextArea();
        areaOrderedLog.setFont(fontTextField);
        areaOrderedLog.setText("");
        areaOrderedLog.setEditable(false);

        errorNull2 = new JLabel("Error: any log has been created yet");
        errorNull2.setBounds(25, 450, 335, 50);
        errorNull2.setForeground(colorError);
        errorNull2.setFont(errorFont);
        errorNull2.setVisible(false);
        menuViewLog.add(errorNull2);

        JScrollPane scrollOrderedLog = new JScrollPane(areaOrderedLog,JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollOrderedLog.setBounds(30, 400, 335, 50);
        menuViewLog.add(scrollOrderedLog);

        JLabel searchTypes = new JLabel("Search Types");
        searchTypes.setBounds(25, 530, 335, 50);
        searchTypes.setForeground(Color.WHITE);
        searchTypes.setFont(buttonLFont);
        menuViewLog.add(searchTypes);

        JLabel avgTime = new JLabel("Average Time");
        avgTime.setBounds(200, 530, 335, 50);
        avgTime.setForeground(Color.WHITE);
        avgTime.setFont(buttonLFont);
        menuViewLog.add(avgTime);

        JButton busSecuencial = new JButton("Sequential");
        busSecuencial.setBounds(25, 580, 150, 50);
        busSecuencial.setBorder(null);
        busSecuencial.setBackground(colorButtons);
        busSecuencial.setForeground(Color.WHITE);
        busSecuencial.setFont(buttonFont);

        timeSecuencial = new JLabel("0 ns");
        timeSecuencial.setBounds(200, 580, 150, 50);
        timeSecuencial.setForeground(Color.WHITE);
        timeSecuencial.setFont(textFont);
        menuViewLog.add(timeSecuencial);

        JButton busBinaria = new JButton("Binary");
        busBinaria.setBounds(25, 650, 150, 50);
        busBinaria.setBorder(null);
        busBinaria.setBackground(colorButtons);
        busBinaria.setForeground(Color.WHITE);
        busBinaria.setFont(buttonFont);
        menuViewLog.add(busSecuencial);
        menuViewLog.add(busBinaria);

        timeBinaria = new JLabel("0 ns");
        timeBinaria.setBounds(200, 650, 150, 50);
        timeBinaria.setForeground(Color.WHITE);
        timeBinaria.setFont(textFont);
        menuViewLog.add(timeBinaria);

        busSecuencial.addActionListener(ae -> timeSecuencial.setText(this.log.testSeqEfficiency() + " ns"));
        busBinaria.addActionListener(ae -> timeBinaria.setText(this.log.testBinEfficiency() + " ns"));

        backButton[3] = new ButtonBack("Back");
        backButton[3].setBounds(120, 850, 150, 50);
        menuViewLog.add(backButton[3]);
    }

    /**
     * Sets the action listener to the back buttons
     */
    private void setActListenerBackButton(){
        for (ButtonBack buttonBack : backButton) {
            buttonBack.addActionListener(ae -> {
                menuStatus.setVisible(true);
                menuCreateLog.setVisible(false);
                menuSort.setVisible(false);
                menuConsult.setVisible(false);
                menuViewLog.setVisible(false);
            });
        }               
    }

    /**
     * Adds an action listener to the create log button
     */
    private void setCreateLogButton() {
        createButton.addActionListener(ae -> {
            boolean create = true;
            int length = 0, bound = 0;
            try {
                length = Integer.parseInt(sizeTextField.getText());
                errorNum.setVisible(false);
            } catch(Exception e) {
                create = false;
                sizeTextField.setText("");
                errorNum.setVisible(true);
            }

            try{
                bound = Integer.parseInt(boundTextField.getText());
                errorNum2.setVisible(false);
            } catch(Exception e){
                create = false;
                boundTextField.setText("");
                errorNum2.setVisible(true);
            }
            if(create){
                resetWindow();
                log = new DataRegister(length, bound);
                sizeTextField.setText("");
                boundTextField.setText("");

                minTextField.setText("" + log.min());
                maxTextField.setText("" + log.max());
                avgTextField.setText("" + log.average());
                mostCommNumTextField.setText("" + log.mostRepeatedValue());
                diffValTextField.setText("" + log.totalValues());
            }
        });
    }

    /**
     * Adds the action listener of the view log button
     */
    private void setViewLogBtn() {
        buttonShowLog.addActionListener(ae -> {
            try {
                areaViewLog.setText(Arrays.toString(log.getOriginalArray()));
                areaOrderedLog.setText(Arrays.toString(log.getSortedArray()));
                errorNull.setVisible(false);
                errorNull2.setVisible(false);
            } catch(Exception e) {
                errorNull.setVisible(true);
                errorNull2.setVisible(true);
            }
        });
    }

    /**
     * Returns this window to its initial status, which means that all the fields are empty
     */
    private void resetWindow() {
        log = null;
        for (JLabel timeLabel : timeLabels)
            timeLabel.setText("0 ms");
        minTextField.setText("");
        maxTextField.setText("");
        avgTextField.setText("");
        diffValTextField.setText("");
        mostCommNumTextField.setText("");
        areaViewLog.setText("");
        areaOrderedLog.setText("");
        minTextFieldC.setText("");
        maxTextFieldC.setText("");
        repeatedTextField.setText("");
        timeBinaria.setText("0 ns");
        timeSecuencial.setText("0 ns");
    }

}