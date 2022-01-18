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
    
    private double maxPix = 0.;
    private double minPix = 0.;
    
    private int MIN, MAX;
    
    private double sliderX;
    private double sliderWidth; 
    
    private RangeSlider slider;

    public RangeSliderAdapter(RangeSliderModel model, RangeSlider slider) {
        this.model = model;
        
        this.slider = slider;
        MIN = slider.getMin();
        MAX = slider.getMax();
        this.sliderX = slider.getX();
        
        System.out.println("RangeSliderAdapter: " + MIN);
        System.out.println("RangeSliderAdapter: " + MAX);
        
        model.addPropertyChangeListener("max", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("RangeSliderAdapter: MaxPropertyChange");
                double newVal = fromValuetoPix((int)evt.getNewValue());
                System.out.println(newVal);
                firePropertyChange("maxPix", maxPix, newVal);
                maxPix = newVal;
            }
        });
        
        model.addPropertyChangeListener("min", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("RangeSliderAdapter: MinPropertyChange");
                double newVal = fromValuetoPix((int)evt.getNewValue());
                firePropertyChange("minPix", minPix, newVal);
                System.out.println("minPix = " + newVal);
                minPix = newVal;
            }
        });
        
    }
    
     private int fromValuetoPix(int value) {
        System.out.println("RangeSliderAdapter: " + slider.getWidth());
        double pix = value * (double)slider.getWidth() / (double)MAX ;
        return (int)pix;
    } 
    
}
