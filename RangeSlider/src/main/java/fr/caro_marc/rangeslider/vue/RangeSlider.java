/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.rangeslider.vue;


import fr.caro_marc.component.arrow.arrow_icon.ArrowIcon;
import fr.caro_marc.component.bar.LeftBar;
import fr.caro_marc.component.bar.MiddleBar;
import fr.caro_marc.component.bar.RightBar;
import fr.caro_marc.rangeslider.controler.RangeSliderAdapter;
import fr.caro_marc.rangeslider.controler.RangeSliderControler;
import fr.caro_marc.rangeslider.model.RangeSliderModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author blanchma
 */
public class RangeSlider extends JPanel {

    //Attributes
    private final int DEFAULT_WIDTH = 200;
    private final int DEFAULT_HEIGHT = 20;

    private final LeftBar leftBar;
    private final RightBar rightBar;
    private final MiddleBar lift;
    private final ArrowIcon leftArrow, rightArrow;
    private final FlowLayout layout;

    private RangeSliderModel model;
    private RangeSliderControler control;
    private RangeSliderAdapter adapter;

    private int MIN = 0, MAX = 100;

    //Constructor
    public RangeSlider() {
        this(new RangeSliderModel(0, 100));
    }

    public RangeSlider(RangeSliderModel aModel) {

        model = aModel;
        adapter = new RangeSliderAdapter(model, this);

        layout = new FlowLayout();
        leftBar = new LeftBar(adapter);
        rightBar = new RightBar(adapter);
        lift = new MiddleBar(adapter);
        leftArrow = new ArrowIcon(ArrowIcon.LEFT, adapter);
        rightArrow = new ArrowIcon(ArrowIcon.RIGHT, adapter);

        control = new RangeSliderControler(leftArrow, rightArrow, leftBar, rightBar, lift, this, model);
        adapter.setSliderWidth(control.getSliderWidth());

        layout.setHgap(0);
        setLayout(layout);
        add(leftBar);
        add(leftArrow);
        add(lift);
        add(rightArrow);
        add(rightBar);
        setBackground(Color.red);
        
        
        initiate();
    }

    //Getters & setters
    public RangeSliderModel getModel() {
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
    
    public void setMinLabel(JLabel label) {
        model.setMinLabel(label);
    }
    
    public void setMaxLabel(JLabel label) {
        model.setMaxLabel(label);
    }
    

    //Methods
    
    private void initiate() {
        leftArrow.setMyX(leftBar.getPreferredSize().width);
        rightArrow.setMyX(leftBar.getPreferredSize().width + 2*leftArrow.getPreferredSize().width + lift.getPreferredSize().width);
    }
    
    
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        leftBar.setBounds(x, y, width, height);
        rightBar.setBounds(x, y, width, height);
        lift.setBounds(x, y, width, height);
        leftArrow.setBounds(x, y, width, height);
        rightArrow.setBounds(x, y, width, height);
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
