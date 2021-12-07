/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;

/**
 *
 * @author marcb
 */
public class Bar extends JComponent {

    //Attributs 
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Color myColor;
    private final static int DEFAULT_WIDTH = 100;
    private final static int DEFAULT_HEIGHT = 20;
    private final static Color DEFAULT_COLOR = Color.GRAY;
    
    //Constructeur
    
    public Bar() { 
        this(DEFAULT_COLOR);
    }
    
    public Bar(Color aColor) {
        myColor = aColor;
    }
    
   
    
    //Setters & getters
    public Color getColor() {
        return myColor;
    }

    public void setColor(Color myColor) {
        Color oldValue = getColor();
        this.myColor = myColor;
        repaint();
        
        support.firePropertyChange("couleur", oldValue, myColor);
    }

    
   
    
    //Method
    private void test(){
        
    }
    
    
    @Override
    public void paint(Graphics g) {
        g.setColor(myColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    //Listeners

    
    
}
