/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.window;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Lenovo Legion
 */
public class ButtonBack extends JButton{

    public ButtonBack(String text){
        super(text);
        Font buttonFont = new Font("Helvetica", Font.PLAIN, 25);
        this.setFont(buttonFont);
        this.setBorder(null);
        Color colorButtons = new Color(64, 64, 64);
        this.setBackground(colorButtons);
        this.setForeground(Color.WHITE);
    }
}
