/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import fr.caro_marc.component.arrow.arrow_icon.ArrowIcon;
import fr.caro_marc.rangeslider.controler.RangeSliderAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private final RangeSliderAdapter adapter;
    
    //Constructeur
    
    public MiddleBar(RangeSliderAdapter adapter) { 
        this(DEFAULT_COLOR, adapter);
    }
    
    public MiddleBar(Color aColor, RangeSliderAdapter aAdapter) {
        super("");
        adapter = aAdapter;
        setBackground(aColor);
        
        this.addMouseMotionListener(new MouseAdapter() {
            boolean clicked = false;
            double x;
            
            @Override
            public void mousePressed(MouseEvent arg0) {
                clicked = true;
                x = arg0.getX();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (clicked){
                    firePropertyChange("drag", 0, e.getX() - x);
                    x = e.getX();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clicked = false;
            }
            
            
            
        });
        

        adapter.addPropertyChangeListener("minPix",  new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                updateSize(evt);
              
            }
        });
        
        adapter.addPropertyChangeListener("maxPix",  new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                updateSize(evt);
              
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
    
    private void updateSize(PropertyChangeEvent evt) {
        double delta = (double)evt.getNewValue() - (double)evt.getOldValue();
        double nv = (double)getWidth()+ delta - (2* ArrowIcon.SIZE);
        setBounds(getX(), getY(), (int)nv, getHeight());
    }
}
