/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.vue;

import fr.caro_marc.component.arrow.Arrow;
import fr.caro_marc.component.arrow.arrow_icon.ArrowIcon;
import fr.caro_marc.component.bar.Bar;
import fr.caro_marc.component.bar.MiddleBar;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author blanchma
 */
public class RangeSlider extends JPanel {

    //Attributes
    private final Bar leftBar, rightBar;
    private final MiddleBar lift;
    private final ArrowIcon leftArrow, rightArrow;
    private final FlowLayout layout;
    
    private RangeSliderModel model;
    
    private int MIN = 0, MAX = 100;
    
    //Constructor
    
    public RangeSlider(){
        this(new RangeSliderModel());
    }
    
    public RangeSlider(RangeSliderModel aModel) {
        layout = new FlowLayout();
        leftBar = new Bar();
        rightBar = new Bar();
        lift = new MiddleBar();
        leftArrow = new ArrowIcon(ArrowIcon.LEFT);
        rightArrow = new ArrowIcon(ArrowIcon.RIGHT);
        
        model = aModel;
        
        layout.setHgap(0);
        setLayout(layout);
        add(leftBar);
        add(leftArrow);
        add(lift);
        add(rightArrow);
        add(rightBar);
        setBackground(Color.red);
    }
    
    
    //Getters & setters
    public RangeSliderModel getModel(){
        return model;
        
    }
    
    public void setModel(RangeSliderModel model) {
        this.model = model;
    }

    public int getMin() {
        return MIN;
    }

    public void setMin(int MIN) {
        this.MIN = MIN;
    }

    public int getMax() {
        return MAX;
    }

    public void setMax(int MAX) {
        this.MAX = MAX;
    }
    
    

    //Methods
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        leftBar.setBounds(x, y, width, height);
        rightBar.setBounds(x, y, width, height);
        lift.setBounds(x, y, width, height);
        leftArrow.setBounds(x, y, width, height);
        rightArrow.setBounds(x, y, width, height);
    }
}
