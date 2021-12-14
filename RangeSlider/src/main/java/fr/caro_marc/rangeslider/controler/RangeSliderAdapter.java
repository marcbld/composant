/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.rangeslider.controler;

import fr.caro_marc.rangeslider.model.RangeSliderModel;
import fr.caro_marc.rangeslider.model.RangeSliderModelEvent;
import fr.caro_marc.rangeslider.model.RangeSliderModelListener;

/**
 *
 * @author marcb
 */
public class RangeSliderAdapter {
    
    private RangeSliderModel model;

    public RangeSliderAdapter(RangeSliderModel model) {
        this.model = model;
        
        model.addListener(new RangeSliderModelListener() {
            @Override
            public void onMaxUpdate(RangeSliderModelEvent e) {
                //prevenir lift et right components
            }

            @Override
            public void onMinUpdate(RangeSliderModelEvent e) {
               //prevenir lift et left components
            }
            
        });
        
    }
    
    private int fromValuetoPix(int value) {
        return 0;
    } 
    
}
