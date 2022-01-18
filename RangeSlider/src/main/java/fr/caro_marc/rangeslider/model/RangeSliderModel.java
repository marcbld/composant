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
        System.out.println("RangesliderController: setMax");
        int oldMax = this.max;
        max = aMax;
        
        firePropertyChange("max", oldMax, aMax);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int aMin) {
        System.out.println("RangesliderController: setMin");
        int oldMin = min;
        min = aMin;
        
        firePropertyChange("min", oldMin, aMin);
    }
    
    
    //Event managment
    
    
    
}
