/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
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
                
                double newVal = fromValuetoPix((double)evt.getNewValue());
                
                if (!leftInitialised) {
                    maxPix = newVal;
                    leftInitialised = true;
                }
                firePropertyChange("maxPix", maxPix, newVal);
                maxPix = newVal;
            }
        });
        
        model.addPropertyChangeListener("MAX", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MAX = (int) evt.getNewValue();
            }
        });
        
        model.addPropertyChangeListener("min", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double newVal = fromValuetoPix((double)evt.getNewValue());
                
                if (!rightInitialised) {
                    minPix = newVal;
                    rightInitialised = true;
                }
                
                firePropertyChange("minPix", minPix, newVal);
                minPix = newVal;
            }
        });
        
        model.addPropertyChangeListener("MIN", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MIN = (int) evt.getNewValue();
            }
        });
        
    }
    
     private int fromValuetoPix(double value) {
        double pix =  value * (double)sliderWidth / (double) (MAX - MIN) + (double)sliderWidth / (1 - (double)MAX/ (double)MIN) ;
        return (int)pix;
    } 

    public void setSliderWidth(double sliderWidth) {
        this.sliderWidth = sliderWidth;
    }
     
    
    
    public void setModel(RangeSliderModel model) {
        this.model = model;
        MIN = model.getMIN();
        MAX = model.getMAX();
    }
     
     
    
}
