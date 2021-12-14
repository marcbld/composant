/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.component.arrow.arrow_icon.ArrowIcon;
import fr.caro_marc.component.bar.Bar;
import fr.caro_marc.component.bar.MiddleBar;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import fr.caro_marc.rangeslider.model.RangeSliderModelEvent;
import fr.caro_marc.rangeslider.model.RangeSliderModelListener;
import fr.caro_marc.rangeslider.vue.RangeSlider;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author blanchma
 */
public class RangeSliderControler {
    
    //Attributes
    
    private ArrowIcon leftArrow, rightArrow;
    private Bar leftBar, rightBar;
    private MiddleBar lift;
    private RangeSlider slider;
    
    private RangeSliderModel model;
    
    private double rangeSliderWidth;
    private int MIN, MAX;
    
    
    //Constructor

    public RangeSliderControler(ArrowIcon leftArrow, ArrowIcon rightArrow, Bar leftBar, Bar rightBar, MiddleBar lift, RangeSlider slider, RangeSliderModel model) {
        this.leftArrow = leftArrow;
        this.rightArrow = rightArrow;
        this.leftBar = leftBar;
        this.rightBar = rightBar;
        this.lift = lift;
        this.slider = slider;
        this.model = model;
        
        rangeSliderWidth = slider.getWidth();
        MIN = slider.getMax();
        MAX = slider.getMin();
        
        
        leftBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prevenir le modèle du changement de min après calcul
            }
        });
        
        leftArrow.addPropertyChangeListener("myX", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("ici le controleur");
                //prévnient le modèle du changement de min après calcul
            }
        }) ;
        
        lift.addPropertyChangeListener("drag", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                model.setMax(MAX);
                
            }
        }) ;
        
        rightArrow.addPropertyChangeListener("myX", (PropertyChangeEvent evt) -> {
            //previent le modèle du changement de max (après calcul)
        });
        
        rightBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prévient le modèle du changement de max (après calcul)
            }
        });
        
        
       
        
    }
    
    
    //Methods
    
    private int fromPixtoValue(double pix){
        return 0;
    }
    
    private int fromValuetoPix(int value) {
        return 0;
    }
    
    
}
