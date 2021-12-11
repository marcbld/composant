/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.caro_marc.component.arrow.arrow_icon;

import fr.caro_marc.component.arrow.Arrow;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author caros
 */
public class ArrowIconEditor extends PropertyEditorSupport{
    
    private int myType;
    private static final String RIGHT_TEXT_VALUE = "right";
    private static final String LEFT_TEXT_VALUE = "left";
    private static final String[] TAGS = {RIGHT_TEXT_VALUE,
        LEFT_TEXT_VALUE};
    
    
    @Override
    public void setValue(Object obj) {
        myType = ((Integer) obj);
    }

    @Override
    public Object getValue() {
        return myType;
    }

    @Override
    public String getJavaInitializationString() {
        return Integer.toString(myType);
    }

    @Override
    public String[] getTags() {
        return TAGS;
    }

    @Override
    public String getAsText() {
        String res;
        switch (myType) {
            case Arrow.RIGHT :
                res = RIGHT_TEXT_VALUE;
                break;
            default :
                res = LEFT_TEXT_VALUE;
                break;
        }
        return res;
    }

    @Override
    public void setAsText(String str) {
        if (str.equals(RIGHT_TEXT_VALUE)) {
            myType = Arrow.RIGHT ;
        } else {
            myType = Arrow.LEFT;
        }
        firePropertyChange();
    }
    
}
