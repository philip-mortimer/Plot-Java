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
package shared.gui.function_of_x;

import shared.gui.NumericField;
import shared.gui.NumericInputArea;
import shared.gui.NumericInputGroup;
import shared.utils.NumericRange;
import shared.utils.Updatable;
import shared.utils.Updater;

/**
* 2 fields ('Min X' and 'Max X') where user specifies a range of numeric x 
* values by inputting the minimum and maximum values in the range. 
*/
public class XRangeInputGroup implements NumericInputGroup {
    private final NumericField minXField;
    private final NumericField maxXField;
    
    private NumericRange range;
    
    String errorString;

    public XRangeInputGroup(double initialMinX, double initialMaxX) {
        this.minXField = new NumericField("Min X", initialMinX);
        this.maxXField = new NumericField("Max X", initialMaxX);

        this.range = new NumericRange(initialMinX, initialMaxX);
        this.errorString = "";
    }

    /**
     * Obtains the range of x values input by the user, and sets it to the  
     * NumericRange value returned by the {@link #getRange() getRange} method. 
     * If an error is detected it will set the string returned by 
     * {@link #getErrorString() getErrorString} method to a description of the 
     * error.
     * 
     * @return true if no error is detected, otherwise false
     */
    @Override
    public boolean update() {
        Updater updater = new Updater();
        if (! updater.updateAll(this.minXField, this.maxXField)) {
            this.errorString = updater.getErrorString();
            return false;
        }
        
        double minX = this.minXField.getValue();
        double maxX = this.maxXField.getValue();       
        if (minX < maxX) {
            this.range = new NumericRange(minX, maxX);
            return true;
        }
        else {
            this.errorString = this.minXField.getName() + " must be < "
                    + this.maxXField.getName();
            return false;
        }
    }

    /**
     * @return the range of x values input by the user
     */
    public NumericRange getRange() {
        assert(this.range != null);
        return this.range;
    }
    
    @Override
    public void addTo(NumericInputArea inputArea) {
        inputArea.addFields(this.minXField, this.maxXField);
    }
    
    /**
     * @return error string set by getXRange method if it returns null 
     */
    @Override
    public String getErrorString() {
        return this.errorString;
    }
}
