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
 * le controleur permet de transformer les données de pixels en valeur pour les transférer au modèle
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

        //ecouteur sur la modification de MAX du modèle
        model.addPropertyChangeListener("MAX", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MAX = (int) evt.getNewValue();
            }
        });
        
        
        //ecouteur sur la modification de MIN du modèle
        model.addPropertyChangeListener("MIN", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MIN = (int) evt.getNewValue();
            }
        });
        
        //ecouteur de nouvelle valeur de la leftBar
        leftBar.addPropertyChangeListener("clickPosition", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prevenir le modèle du changement de min après calcul
                double clickPosition = (int) evt.getNewValue();
                double value = fromPixtoValue(clickPosition);
                model.setMin(value + MIN);

            }
        });

        //ecouteur de nouvelle valeur de la leftArrow
        leftArrow.addPropertyChangeListener("delta", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //prévnient le modèle du changement de min après calcul
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);
                model.setMin((double) model.getMin() + value);
            }
        });

        
        //ecouteur de la nouvelle valeur du lift
        lift.addPropertyChangeListener("drag", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //previent le modèle du changement de min et max (après calcul)
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);

                model.setMin((double) model.getMin() + value);
                model.setMax((double) model.getMax() + value);

            }
        });

        //ecouteur de la nouvelle valeur de la rightArrow
        rightArrow.addPropertyChangeListener("delta", new PropertyChangeListener() {
            //previent le modèle du changement de max (après calcul)
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double delta = (int) evt.getNewValue();
                double value = fromPixtoValue(delta);
                model.setMax((double) model.getMax() + value);

            }
        });

        //ecouteur de la nouvelle valeur de la rightBar
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
        double value = pix * ((double) (MAX - MIN) / (double) sliderWidth); //+ (double) MIN;

        return value;
    }
    
    
    public void setModel(RangeSliderModel model) {
        this.model = model;
        MIN = model.getMIN();
        MAX = model.getMAX();
    }

}
