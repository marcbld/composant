/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.arrow.arrow_icon;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.IntStream;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author caros
 */
public class ArrowIcon extends JButton{
    
    //Attributes
    
    public final static int RIGHT = 1;
    public final static int LEFT = 2;
    
    private final static Icon RIGHT_ICON = new Icon() {
        
        int xArrow[] = { 5, 15, 15};
        int yArrow[] = { 10, 5, 15};
        
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Polygon polygon = new Polygon( xArrow, yArrow, 3);
            g.setColor(Color.BLACK);
            g.fillPolygon( polygon ); 
        }

        @Override
        public int getIconWidth() {
            return IntStream.of(xArrow).max().getAsInt() - IntStream.of(xArrow).min().getAsInt();
        }

        @Override
        public int getIconHeight() {
            return IntStream.of(yArrow).max().getAsInt() - IntStream.of(yArrow).min().getAsInt();
        }
    };
    
    private final static Icon LEFT_ICON = new Icon() {
        
        int xArrow[] = { 5, 5, 15};
        int yArrow[] = { 5, 15, 10};
        
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Polygon polygon = new Polygon( xArrow, yArrow, 3);
            g.setColor(Color.BLACK);
            g.fillPolygon( polygon ); 
        }

        @Override
        public int getIconWidth() {
            return IntStream.of(xArrow).max().getAsInt() - IntStream.of(xArrow).min().getAsInt();
        }

        @Override
        public int getIconHeight() {
            return IntStream.of(yArrow).max().getAsInt() - IntStream.of(yArrow).min().getAsInt();
        }
    };
    
    
    private int myType;
    
    private int myX = 10;
    
   
    
    //Constructors
    
    public ArrowIcon(){
        this(RIGHT);
    }
    

    
    public ArrowIcon(int aType){
        super("");
        myType = aType;
        myX = this.getX();
        
        
        
        switch(myType) {
            case LEFT:
                setIcon(LEFT_ICON);
                break;
            default:
                setIcon(RIGHT_ICON);
                break;
        }
        
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
        if (theType == LEFT) {
            setIcon(LEFT_ICON);
            myType = theType;
        } else {
            setIcon(RIGHT_ICON);
            myType = RIGHT;
        }
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
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }
    
    
    //Event management
  
    
    

}
