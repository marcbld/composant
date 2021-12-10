/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;

/**
 *
 * @author marcb
 */
public class Bar extends JComponent {

    //Attributs 
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final static int DEFAULT_WIDTH = 100;
    private final static int DEFAULT_HEIGHT = 20;
    private final static Color DEFAULT_COLOR = Color.GRAY;
    private final RangeSliderModel model;
    private Color myColor;
    
    //Constructeur
    
    public Bar() { 
        this(DEFAULT_COLOR, new RangeSliderModel());
    }
    
    public Bar(RangeSliderModel aModel) { 
        this(DEFAULT_COLOR, aModel);
    }
    
    public Bar(Color aColor, RangeSliderModel aModel) {
        myColor = aColor;
        model = aModel;
        
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
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
