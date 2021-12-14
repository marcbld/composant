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
    
    private int MIN, MAX;
    
    private double sliderX;
    private double sliderWidth; 
    
    //Constructor

    public RangeSliderControler(ArrowIcon leftArrow, ArrowIcon rightArrow, Bar leftBar, Bar rightBar, MiddleBar lift, RangeSlider slider, RangeSliderModel model) {
        this.leftArrow = leftArrow;
        this.rightArrow = rightArrow;
        this.leftBar = leftBar;
        this.rightBar = rightBar;
        this.lift = lift;
        this.slider = slider;
        this.model = model;
        
        MIN = slider.getMax();
        MAX = slider.getMin();
        this.sliderX = slider.getX();
        this.sliderWidth = processWidth();
        System.out.println(sliderWidth);
        
        
        leftBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prevenir le modèle du changement de min après calcul
                System.out.println("leftbar controller");
            }
        });
        
        leftArrow.addPropertyChangeListener("myX", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("leftarrow controller");
                //prévnient le modèle du changement de min après calcul
            }
        }) ;
        
        lift.addPropertyChangeListener("drag", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                //model.setMax(MAX);
                //System.out.println("lift controller");
                double value = (double)lift.getX() + (double)evt.getNewValue();
                System.out.println(value);
                System.out.println(sliderWidth);
                System.out.println(value/sliderWidth);
                
            }
        }) ;
        
        rightArrow.addPropertyChangeListener("myX", (PropertyChangeEvent evt) -> {
            //previent le modèle du changement de max (après calcul)
            System.out.println("rightarrow controller");
        });
        
        rightBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prévient le modèle du changement de max (après calcul)
                System.out.println("rightbar controller");
            }
        });
        
        
       
        
    }
    
    
    //Methods
    
    private int fromPixtoValue(double pix){
        double value = pix * (double)MAX / (double)sliderWidth;
        return (int)value;
    }
    
   
    private double processWidth(){
        return leftBar.getWidth() + 2*leftArrow.getWidth() + lift.getWidth() + rightBar.getWidth();
    }
    
}
