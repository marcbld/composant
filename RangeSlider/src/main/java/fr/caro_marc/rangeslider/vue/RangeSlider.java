/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.vue;

import fr.caro_marc.component.arrow.Arrow;
import fr.caro_marc.component.bar.Bar;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author blanchma
 */
public class RangeSlider extends JPanel {

    //Attributes
    private final Bar leftBar, rightBar, lift;
    private final Arrow leftArrow, rightArrow;
    private final FlowLayout layout;
    
    private final RangeSliderModel model = new RangeSliderModel();
    
    //Constructor
    public RangeSlider() {
        layout = new FlowLayout();
        leftBar = new Bar();
        rightBar = new Bar();
        lift = new Bar(Color.YELLOW);
        leftArrow = new Arrow(Arrow.LEFT);
        rightArrow = new Arrow(Arrow.RIGHT);
        
        this.setLayout(layout);
        this.add(leftBar);
        this.add(leftArrow);
        this.add(lift);
        this.add(rightArrow);
        this.add(rightBar);
    }
}
