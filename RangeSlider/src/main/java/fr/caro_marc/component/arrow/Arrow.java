/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.arrow;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author caros
 */
public class Arrow extends JComponent{
    
    //Attributes
    
    public final static int RIGHT = 1;
    public final static int LEFT = 2;
    private int myType;
    
    private int myX = 0;
    
   
    
    //Constructors
    
    public Arrow(){
        this(RIGHT);
    }
    

    
    public Arrow(int aType){
        super();
        myType = aType;
        myX = this.getX();
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setMyX(e.getXOnScreen());
            }
            
        });
    }
    
    
    //getters & setters
    public int getType() {
        return myType;
    }
    
    public final void setType(int theType) {
        int oldType = myType;
        myType = (theType == RIGHT || theType == LEFT)
                ? theType
                : RIGHT;
        repaint();
        firePropertyChange("type", oldType, myType);
    }
    
    public final int getMyX() {
        return myX;
    }
    
    public final void setMyX(int theMyX) {
        int oldMyX = myX;
        switch (myType){
            case RIGHT:
                myX = theMyX;
                break;
            case LEFT:
                myX = theMyX + getWidth();  //changement du signe - en +
                break;
            default:
                System.out.println("erreur de type");
                break;
        }
        myX = theMyX;
        repaint();
        firePropertyChange("myX", oldMyX, myX);
    }
    
    
    //Methods
    
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
                //setBounds(myX, getY(), getWidth(), getHeight());
                setBounds(getX(), getY(), getWidth(), getHeight());
                break;
            case LEFT:
                int xArrow2[] = { 5, 5, 15};
                int yArrow2[] = { 5, 15, 10};
                Polygon polygon3 = new Polygon( xArrow2, yArrow2, 3);
                g.setColor(Color.BLACK);
                g.fillPolygon( polygon3); 
                //setBounds(myX, getY(), getWidth(), getHeight());
                setBounds(getX(), getY(), getWidth(), getHeight());
                break;
        }
    }
    
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }
    
    
    //Event management
  
    
    

}
