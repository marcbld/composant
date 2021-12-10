/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.caro_marc.component.arrow;

import java.util.EventListener;

/**
 *
 * @author blanchma
 */
public interface ArrowListener extends EventListener {
    
    public void onArrowMousePressed(ArrowEvent evt);
    
    public void onArrowMouseReleased(ArrowEvent evt);
    
    public void onArrowDrag(ArrowEvent evt);
    
    
}
