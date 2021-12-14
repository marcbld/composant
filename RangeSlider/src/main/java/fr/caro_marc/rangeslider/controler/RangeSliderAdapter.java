/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
import fr.caro_marc.rangeslider.model.RangeSliderModelEvent;
import fr.caro_marc.rangeslider.model.RangeSliderModelListener;
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

    public RangeSliderAdapter(RangeSliderModel model) {
        this.model = model;
        
        model.addPropertyChangeListener("max", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double newVal = fromValuetoPix((int)evt.getNewValue());
                firePropertyChange("maxPix", maxPix, newVal);
                maxPix = newVal;
            }
        });
        
        model.addPropertyChangeListener("min", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double newVal = fromValuetoPix((int)evt.getNewValue());
                firePropertyChange("minPix", minPix, newVal);
                minPix = newVal;
            }
        });
        
    }
    
    private int fromValuetoPix(int value) {
        return 0;
    } 
    
}
