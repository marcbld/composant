/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.arrow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;

/**
 *
 * @author caros
 */
public class Arrow extends JComponent{
    
    //private GEOPoly arrowView;
    private float myX;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public final static int RIGHT = 1;
    public final static int LEFT = 2;
    private int myType;
    
    @Override
    public void paint(Graphics g) {
        
        int xRect[] = { 0, 20, 20, 0};
        int yRect[] = { 0, 0, 20, 20};
        Polygon polygon1 = new Polygon( xRect, yRect, 4 );
        g.setColor(Color.GRAY);
        g.fillPolygon( polygon1);  
        
        switch (myType){
            case RIGHT:
                int xArrow[] = { 5, 15, 15};
                int yArrow[] = { 10, 5, 15};
                Polygon polygon2 = new Polygon( xArrow, yArrow, 3);
                g.setColor(Color.BLACK);
                g.fillPolygon( polygon2); 
                break;
            case LEFT:
                int xArrow2[] = { 5, 5, 15};
                int yArrow2[] = { 5, 15, 10};
                Polygon polygon3 = new Polygon( xArrow2, yArrow2, 3);
                g.setColor(Color.BLACK);
                g.fillPolygon( polygon3); 
                break;
            default:
                int xArrow3[] = { 5, 15, 15};
                int yArrow3[] = { 10, 5, 15};
                Polygon polygon4 = new Polygon( xArrow3, yArrow3, 3);
                g.setColor(Color.BLACK);
                g.fillPolygon( polygon4); 
                break;
        }

        
    
    }
    
    public final void setType(int theType) {
        int oldType = myType;
        myType = (theType == RIGHT || theType == LEFT)
                ? theType
                : RIGHT;
        repaint();
        support.firePropertyChange("type", oldType, myType);
    }
    
    public final void setMyX(float theMyX) {
        float oldMyX = myX;
        myX = theMyX;
        repaint();
        support.firePropertyChange("myX", oldMyX, myX);
    }
    
//    public final void setMyX(int theMyX) {
//        float oldMyX = xLeft;
//        xLeft = (theMyX.getType() == float || theMyX.getType() == double)
//                ? theMyX
//                : 0.;
//        repaint();
//        support.firePropertyChange("myX", oldMyX, xLeft);
//    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }
  
    public Arrow(){
        this(RIGHT);
    }
    
    public Arrow(int newtype){
        super();
        myType = newtype;
    }
    
    

}
