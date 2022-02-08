/*
 * Click nbfs://nbhost///SystemFile//System/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost///SystemFile//System/Templates/Classes/Class.java to edit this template
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

    private boolean clicked = false;
    private int xMouseDown;

    //Constructeur
    public MiddleBar(RangeSliderAdapter adapter) {
        this(DEFAULT_COLOR, adapter);
    }

    public MiddleBar(Color aColor, RangeSliderAdapter aAdapter) {
        super("");
        adapter = aAdapter;
        setBackground(aColor);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                clicked = true;
                xMouseDown = e.getXOnScreen();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clicked = false;
            }

        });

        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (clicked) {
                    int delta = e.getXOnScreen() - xMouseDown;
                    if (Math.abs(delta) >= 5) {
                        firePropertyChange("drag", 0, delta);
                        xMouseDown = e.getXOnScreen();
                    }

                }
            }

        });

        adapter.addPropertyChangeListener("minPix", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                updateMin(evt);

            }
        });

        adapter.addPropertyChangeListener("maxPix", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                updateMax(evt);

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

    private void updateMin(PropertyChangeEvent evt) {
        double delta = (double) evt.getNewValue() - (double) evt.getOldValue();
        double nv = (double) getWidth() - delta;
        setBounds(getX() + (int) delta, getY(), (int) nv, getHeight());
    }

    private void updateMax(PropertyChangeEvent evt) {
        double delta = (double) evt.getNewValue() - (double) evt.getOldValue();
        double nv = (double) getWidth() + delta;
        setBounds(getX(), getY(), (int) nv, getHeight());
    }
}
