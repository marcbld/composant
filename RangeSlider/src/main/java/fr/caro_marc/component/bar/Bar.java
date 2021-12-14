/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import fr.caro_marc.rangeslider.controler.RangeSliderAdapter;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;

/**
 *
 * @author marcb
 */
public class Bar extends JComponent {

    //Attributs 
    
    private final static int DEFAULT_WIDTH = 100;
    private final static int DEFAULT_HEIGHT = 20;
    private final static Color DEFAULT_COLOR = Color.GRAY;
    private final RangeSliderAdapter adapter;
    private Color myColor;
    
    //Constructeur
    
    public Bar(RangeSliderAdapter adapter) { 
        this(DEFAULT_COLOR, adapter);
    }
    
    public Bar(Color aColor, RangeSliderAdapter aAdapter) {
        myColor = aColor;
        adapter = aAdapter;
        
    }
    
   
    
    //Setters & getters
    
    public Color getColor() {
        return myColor;
    }

    public void setColor(Color myColor) {
        Color oldValue = getColor();
        this.myColor = myColor;
        repaint();
        
        firePropertyChange("couleur", oldValue, myColor);
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
    
    
}
