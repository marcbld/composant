/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.model;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * La classe gère les valeurs min et max et prévient les différents composants de ses modifications
 *
 * @author blanchma
 */
public class RangeSliderModel extends JComponent {

    private int MAX, MIN;
    private double max, min;
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 500;
    private static int OFFSET = 15;

    //Constructors
    public RangeSliderModel() {
        this(RangeSliderModel.DEFAULT_MIN, RangeSliderModel.DEFAULT_MAX);
    }

    public RangeSliderModel(int aMIN, int aMAX) {
        MAX = aMAX;
        MIN = aMIN;
        max = MAX;
        min = MIN;
        setOffset();
        System.out.println("Modele: constructor --> "+ MIN + " /// " + MAX );
    }

    public void initializer() {
        setMin(MIN);
        setMax(MAX);
    }

    //Getters & setters
    public double getMax() {
        return max;
    }

    public void setMax(double aMax) {
        double oldMax = this.max;
        if (aMax >= MAX) {
            max = MAX;
        } else if (aMax <= min + OFFSET) {
            max = min + OFFSET;
            System.out.println("Modele: offset triggered");
        } else {
            max = aMax;
        }

        System.out.println("Modele: max --> " + aMax + " /// " + max);

        firePropertyChange("max", oldMax, max);

    }

    public double getMin() {
        return min;
    }

    public void setMin(double aMin) {
        double oldMin = min;
        if (aMin <= MIN) {
            min = MIN;
        } else if (aMin >= max - OFFSET) {
            min = max - OFFSET;
        } else {
            min = aMin;
        }

        System.out.println("Modele: min --> " + aMin + " /// " + min);

        firePropertyChange("min", oldMin, min);

    }

    public void setMAX(int MAX) {
        if (MAX >= MIN) {
            int oldMAX = this.MAX;
            this.MAX = MAX;
            setOffset();
            firePropertyChange("MAX", oldMAX, MAX);
            
            
            if (max >= oldMAX) {
                System.out.println("Modele: setMax --> "+ max);
                max = MAX;
            }
        }
    }

    public int getMAX() {
        return MAX;
    }

    public void setMIN(int MIN) {
        if (MIN <= MAX) {
            int oldMIN = this.MIN;
            this.MIN = MIN;
            setOffset();
            firePropertyChange("MIN", oldMIN, MIN);
            
            if (min <= oldMIN) {
                min = MIN;
            }
        }
    }

    public int getMIN() {
        return MIN;
    }
    
    private void setOffset(){
        OFFSET = (int) ((double) (MAX - MIN) / (double) 5 );
        System.out.println("Modele: min et max --> " + MIN + " /// "+ MAX);
        System.out.println("Modele: offset --> " + OFFSET);
    }

}
