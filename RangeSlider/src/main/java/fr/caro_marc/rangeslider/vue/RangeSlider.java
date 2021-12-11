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
    
    private final RangeSliderModel model;
    
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
        
        layout.setHgap(1);
        this.setLayout(layout);
        this.add(leftBar);
        this.add(leftArrow);
        this.add(lift);
        this.add(rightArrow);
        this.add(rightBar);
        this.setBackground(Color.red);
    }
    
    
    
    
    
    //Setter and getter
    
    
    //Methods
    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        leftBar.setBounds(x, y, width, height);
        rightBar.setBounds(x, y, width, height);
        lift.setBounds(x, y, width, height);
        leftArrow.setBounds(x, y, width, height);
        rightArrow.setBounds(x, y, width, height);
    }
}
