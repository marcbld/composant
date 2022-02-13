/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.bar;

import fr.caro_marc.component.arrow.arrow_icon.ArrowIcon;
import fr.caro_marc.rangeslider.controler.RangeSliderAdapter;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author marcb
 */
public class RightBar extends Bar {

    public RightBar(RangeSliderAdapter adapter) {
        super(adapter);

        adapter.addPropertyChangeListener("maxPix", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                double delta = (double) evt.getNewValue() - (double) evt.getOldValue();
                double nv = (double) getWidth() - delta;
                setBounds(getX() + (int) delta, getY(), (int) nv, getHeight());

            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(0, super.getPreferredSize().height); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
