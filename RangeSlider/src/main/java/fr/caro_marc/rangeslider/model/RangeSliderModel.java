/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.model;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * La classe gère les valeurs min et max et prévient les différents composants 
 * de ses modifications
 * @author blanchma
 */
public class RangeSliderModel {
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ArrayList<RangeSliderModelListener> listeners;
    
    private final int MAX, MIN;
    private int max, min;
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 500;
    
    
    //Constructors
    public RangeSliderModel(){
        this(RangeSliderModel.DEFAULT_MIN, RangeSliderModel.DEFAULT_MAX);
    }
    
    public RangeSliderModel(int aMAX, int aMIN){
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
        max = aMax;
        
        support.firePropertyChange("max", oldMax, aMax);
        fireMaxUpdate();
    }

    public int getMin() {
        return min;
    }

    public void setMin(int aMin) {
        int oldMin = min;
        min = aMin;
        
        support.firePropertyChange("min", oldMin, aMin);
        fireMinUpdate();
    }
    
    
    //Event managment
    public void addListener(RangeSliderModelListener listener){
        listeners.add(listener);
    }
    
    public void removelistener(RangeSliderModelListener listener){
        listeners.remove(listener);
    }
    
    private void fireMinUpdate() {
        listeners.forEach( l -> {
            l.onMinUpdate(new RangeSliderModelEvent(this));
        });
    }
    
    private void fireMaxUpdate() {
        listeners.forEach( l -> {
            l.onMaxUpdate(new RangeSliderModelEvent(this));
        });
    }
    
    
}
