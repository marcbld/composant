/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.component.arrow_icon.ArrowIcon;
import fr.caro_marc.component.bar.Bar;
import fr.caro_marc.component.bar.MiddleBar;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import fr.caro_marc.rangeslider.vue.RangeSlider;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author blanchma
 */
public class RangeSliderControler {

    //Attributes
    private final ArrowIcon leftArrow, rightArrow;
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

        MIN = slider.getMin();
        MAX = slider.getMax();
        this.sliderX = slider.getX();
        this.sliderWidth = (double) (leftBar.getPreferredSize().width + 2 * leftArrow.getPreferredSize().width + lift.getPreferredSize().width + rightBar.getPreferredSize().width);

        
        model.addPropertyChangeListener("MAX", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MAX = (int) evt.getNewValue();
            }
        });
        
        model.addPropertyChangeListener("MIN", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MIN = (int) evt.getNewValue();
            }
        });
        
        leftBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prevenir le modèle du changement de min après calcul
                double clickPosition = (int) evt.getNewValue();
                double value = fromPixtoValue(clickPosition);
                model.setMin(value + MIN);

            }
        });

        leftArrow.addPropertyChangeListener("delta", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prévnient le modèle du changement de min après calcul
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);
                model.setMin((double) model.getMin() + value);
            }
        });

        lift.addPropertyChangeListener("drag", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);

                //System.out.println("Controler: lift --> " + delta +  " /// " + value);
                model.setMin((double) model.getMin() + value);
                model.setMax((double) model.getMax() + value);

            }
        });

        rightArrow.addPropertyChangeListener("delta", new PropertyChangeListener() {
            //previent le modèle du changement de max (après calcul)
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);
                model.setMax((double) model.getMax() + value);

            }
        });

        rightBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prévient le modèle du changement de max (après calcul)
                double clickPosition = (int) evt.getNewValue() + rightBar.getX();
                model.setMax(fromPixtoValue(clickPosition) + MIN);
            }
        });

    }

    public void setSliderWidth(double sliderWidth) {
        this.sliderWidth = sliderWidth;
    }

    public double getSliderWidth() {
        return sliderWidth;
    }

    //Methods
    private double fromPixtoValue(double pix) {
        //System.out.println("Controller: avant traitement --> " + pix);
        double value = pix * ((double) (MAX - MIN) / (double) sliderWidth); //+ (double) MIN;
        //System.out.println("Controler: après traitement --> " + value);

        return value;
    }
    
    
    public void setModel(RangeSliderModel model) {
        this.model = model;
        MIN = model.getMIN();
        MAX = model.getMAX();
    }

}
