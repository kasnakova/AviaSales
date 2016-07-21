/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviasales.ui;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Liza
 */
public class MessageBoxes {
    public static void showInvalidInputMessageBox(Component component, String message){
         JOptionPane.showMessageDialog(component, message, "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorMessageBox(Component component, String message){
         JOptionPane.showMessageDialog(component, message, "Problem", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showSuccessMessageBox(Component component, String message){
         JOptionPane.showMessageDialog(component, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
