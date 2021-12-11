/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JButton;

/**
 *
 * @author marcb
 */
public class MiddleBar extends JButton {
    
    //Attributs 
    
    private final static int DEFAULT_WIDTH = 100;
    private final static int DEFAULT_HEIGHT = 20;
    private final static Color DEFAULT_COLOR = Color.BLUE;
    
    //Constructeur
    
    public MiddleBar() { 
        this(DEFAULT_COLOR);
    }
    
    public MiddleBar(Color aColor) {
        super("");
        setBackground(aColor);
        
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                System.out.println("Not Supported yet");
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                System.out.println("Not supported yet");
            }
            
        });
    }
    
   
    
    //Setters & getters
    
    public Color getColor() {
        return getBackground();
    }

    public void setColor(Color myColor) {
        Color oldValue = getColor();
        setBackground(myColor);
        repaint();
        
        firePropertyChange("couleur", oldValue, myColor);
    }

    
   
    
    //Method
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
