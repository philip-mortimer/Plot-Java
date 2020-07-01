/*
 * Copyright (C) 2019 Philip Mortimer
 *
 * This file is part of Philip Mortimer Example Programs.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package shared.gui;

import javafx.scene.control.TextField;
import javafx.scene.Node;
import shared.utils.Updatable;

/**
 * Named field in which the user can enter a real (double) number.
 */
public class NumericField implements Updatable {
    private static final double DEFAULT_INIT_VALUE = 0;
    private static final int    DEFAULT_COLUMN_COUNT = 10;
    private static final double DEFAULT_MAX_MAGNITUDE = 1e12;
    
    private String name;
    private double value;
    private TextField textField;
    private String errorString;
    private double maxMagnitude;
    
    private static void setValue(double value, TextField textField) {
        String contents = String.valueOf(value);
        textField.setText(contents);        
    }
    
    /**
     * 
     * @param name  name of field - forms field's label and identifies
     *              field in error messages
     * 
     * @param initValue value which initially appears in the field
     * 
     * @param maxMagnitude maximum allowable absolute value of the number 
     *                     entered by the user - see 
     *                     {@link #setMaxMagnitude(double) setMaxMagnitude}
     * 
     */
    public NumericField(String name, double initValue, double maxMagnitude) {
        this.name = name;
        this.value = initValue;
        this.maxMagnitude = maxMagnitude;        

        this.textField = new TextField();
        this.textField.setPrefColumnCount(DEFAULT_COLUMN_COUNT);
        setValue(initValue, this.textField);
    }

    public NumericField(String name, double initValue) {
        this(name, initValue, DEFAULT_MAX_MAGNITUDE);   
    }
    
    public NumericField(String name) {
        this(name, DEFAULT_INIT_VALUE, DEFAULT_MAX_MAGNITUDE);
    }
       
    private void setErrorString(String errorString) {
        this.errorString =  this.name + " - " +  errorString;
    }

    /**
     * Attempts to convert string entered by user in the text field to 
     * a number (a double). 
     * <p>
     * If successful it will set the value returned by the {@link #getValue()}
     * method to the number entered by the user and return true. 
     * <p>
     * If not successful (string is not a valid number or 
     * is outside range -maxMagnitude..maxMagnitude) it will
     * set the string returned by getErrorString method to a description of
     * the error and return false.
     * 
     * @return  true if no errors detected, otherwise false
     */
    @Override
    public boolean update()
    {
        boolean ret;
        try {
            String str = this.textField.getText();
            this.value = Double.valueOf(str).doubleValue();
            if (Math.abs(this.value) > this.maxMagnitude) {
               String maxMagnitudeString = String.valueOf(this.maxMagnitude);
               this.setErrorString("not within range -" +
                      maxMagnitudeString + ".." + maxMagnitudeString);
               ret = false;
            }
            else {
               ret = true;
            }
        }
        catch (NumberFormatException e) {
            this.setErrorString("not a valid number");
            ret = false;
        }
        return ret;
    }
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        setValue(value, this.textField);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPreferredColumnCount(int preferredColumnCount) {
        this.textField.setPrefColumnCount(preferredColumnCount);
    }
    
    /**
     * Sets maximum absolute size of number that can be entered by the user. 
     * For example, if maxMagnitude is 1e9 then number entered by user cannot 
     * be less than -1e9 or greater than 1e9. If user enters number outside 
     * of this range then the subsequent call to updateValue method will return 
     * false.
     * 
     * @param maxMagnitude maximum allowable absolute value of the number 
     *                      entered by the user
     */
    public void setMaxMagnitude(double maxMagnitude) {
        this.maxMagnitude = maxMagnitude;        
    }

    /**
     * @return error string set by {@link #update()} method if it returns false 
     */
    @Override
    public String getErrorString() {
        return this.errorString;
    }
    
    public Node getNode() {
        return this.textField;
    }
}
