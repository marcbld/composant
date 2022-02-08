/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
import fr.caro_marc.rangeslider.model.RangeSliderModelEvent;
import fr.caro_marc.rangeslider.model.RangeSliderModelListener;
import fr.caro_marc.rangeslider.vue.RangeSlider;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;

/**
 *
 * @author marcb
 */
public class RangeSliderAdapter extends JComponent{
    
    private RangeSliderModel model;
    
    private double maxPix;
    private double minPix;
    
    private int MIN, MAX;
    
    private double sliderX;
    private double sliderWidth; 
    
    private boolean leftInitialised = false;
    private boolean rightInitialised = false;
    
    private RangeSlider slider;

    public RangeSliderAdapter(RangeSliderModel model, RangeSlider slider) {
        this.model = model;
        
        this.slider = slider;
        MIN = slider.getMin();
        MAX = slider.getMax();
        this.sliderX = slider.getX();
        
        
        model.addPropertyChangeListener("max", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double newVal = fromValuetoPix((int)evt.getNewValue());
                
                if (!leftInitialised) {
                    maxPix = newVal;
                    leftInitialised = true;
                }
                
                firePropertyChange("maxPix", maxPix, newVal);
                maxPix = newVal;
            }
        });
        
        model.addPropertyChangeListener("min", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double newVal = fromValuetoPix((int)evt.getNewValue());
                
                if (!rightInitialised) {
                    maxPix = newVal;
                    rightInitialised = true;
                }
                
                firePropertyChange("minPix", minPix, newVal);
                minPix = newVal;
            }
        });
        
    }
    
     private int fromValuetoPix(int value) {
        double pix = value * (double)sliderWidth / (double)MAX ;
        return (int)pix;
    } 

    public void setSliderWidth(double sliderWidth) {
        this.sliderWidth = sliderWidth;
    }
     
     
     
    
}
