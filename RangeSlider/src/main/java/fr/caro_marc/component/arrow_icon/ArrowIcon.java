/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.arrow_icon;

import fr.caro_marc.rangeslider.controler.RangeSliderAdapter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.IntStream;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author caros
 */
public class ArrowIcon extends JButton {

    //Attributes
    public final static int RIGHT = 1;
    public final static int LEFT = 2;
    public final static int SIZE = 20;

    private final static Icon RIGHT_ICON = new Icon() {

        int xArrow[] = {5, 15, 15};
        int yArrow[] = {10, 5, 15};

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Polygon polygon = new Polygon(xArrow, yArrow, 3);
            g.setColor(Color.BLACK);
            g.fillPolygon(polygon);
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

        int xArrow[] = {5, 5, 15};
        int yArrow[] = {5, 15, 10};

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Polygon polygon = new Polygon(xArrow, yArrow, 3);
            g.setColor(Color.BLACK);
            g.fillPolygon(polygon);
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

    private int xPosition;

    //Constructors
    public ArrowIcon(int aType, RangeSliderAdapter aAdapter) {
        super("");
        myType = aType;

        switch (myType) {
            case LEFT:
                setIcon(LEFT_ICON);
                break;
            default:
                setIcon(RIGHT_ICON);
                break;
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPosition = e.getXOnScreen();
            }

        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                //System.out.println("ArrowIcon: delta -->" + (x - xPosition));
                firePropertyChange("delta", 0, x - xPosition);
                xPosition = x;
            }

        });

        aAdapter.addPropertyChangeListener("minPix", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (myType == LEFT) {
                    double delta = (double) evt.getNewValue() - (double) evt.getOldValue();
                    setBounds(getX() + (int) delta, getY(), getWidth(), getHeight());

                }

            }
        });

        aAdapter.addPropertyChangeListener("maxPix", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (myType == RIGHT) {
                    double delta = (double) evt.getNewValue() - (double) evt.getOldValue();
                    System.out.println("ArrowIcon: right --> " + delta);
                    System.out.println("ArrowIcon: right --> " + (getX() + delta));
                    setBounds(getX() + (int) delta, getY(), getWidth(), getHeight());
                }

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

    //Methods
    @Override
    public final Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }

    public void initialier(int size) {
        switch (myType) {
            case LEFT:
                System.out.println("ArrowIcon: LEFT --> " + size);
                firePropertyChange("delta", 0, size);
                break;
            case RIGHT:
                System.out.println("ArrowIcon: RIGHT --> " + size);
                firePropertyChange("delta", 0, size);
                break;
        }
    }

}
