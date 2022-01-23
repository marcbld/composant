/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.model;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * La classe gère les valeurs min et max et prévient les différents composants 
 * de ses modifications
 * @author blanchma
 */
public class RangeSliderModel extends JComponent{
    
    
    
    private final int MAX, MIN;
    private int max, min;
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 500;
    private static final int OFFSET = 15;
    
    
    //Constructors
    public RangeSliderModel(){
        this(RangeSliderModel.DEFAULT_MIN, RangeSliderModel.DEFAULT_MAX);
    }
    
    public RangeSliderModel(int aMIN, int aMAX){
        MAX = aMAX;
        MIN = aMIN;
        max = MAX;
        min = MIN;
    }

    
    //Getters & setters
    public int getMax() {
        return max;
    }

    public void setMax(int aMax) {
        int oldMax = this.max;
        if (aMax >= MAX) {
            max = MAX;
        } else if (aMax <= min + OFFSET){
            max = min + OFFSET;
        }
        else{
            max = aMax;
        }
        firePropertyChange("max", oldMax, max);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int aMin) {
        int oldMin = min;
        if (aMin <= MIN) {
            min = MIN;
        } else if (aMin >= max - OFFSET){
            min = max - OFFSET;
        }
        else{
            min = aMin;
        }
        firePropertyChange("min", oldMin, min);
    }
    
    
    //Event managment
    
    
    
}
