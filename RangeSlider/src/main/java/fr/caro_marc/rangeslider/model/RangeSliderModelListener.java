package fr.caro_marc.rangeslider.model;


import java.util.EventListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blanchma
 */
public interface RangeSliderModelListener extends EventListener{
    
    public void onMaxUpdate (int max);
    
    public void onMinUpdate (int min);
}
