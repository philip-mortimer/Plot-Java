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
package logistic_curve;

import shared.gui.*;
import shared.utils.Updatable;
import shared.utils.Updater;
import shared.function_of_x.logistic.LogisticCoefficients;

/**
* Group of fields where user enters the curve's k (steepness), x0 (mid-point) 
* and L (max y) values for the logistic function f(x)=L/(1+exp(-k(x-x0))).
*/
public class LogisticCoefficientInputGroup 
        implements NumericInputGroup,LogisticCoefficients {    
    private final NumericField k;
    private final NumericField x0;
    private final NumericField maxY;
    
    String errorString;

    public LogisticCoefficientInputGroup(double initialK,
                                         double initialX0, 
                                         double initialMaxY) {
        this.k    = new NumericField("k", initialK);
        this.x0   = new NumericField("x0", initialX0);
        this.maxY = new NumericField("L (max Y)", initialMaxY);
        
        this.errorString = "";
    }
    
    /** 
     * Retrieves the k, x0 and max y values from the input fields. If there are
     * no errors the values retrieved are returned by the {@link #getK()} 
     * {@link #getX0()} and {@link #getMaxY()}.
     * 
     * @return true if there are no errors, otherwise returns false
     * and sets the error string returned by {@link #getErrorString()
     * getErrorString}.
     */
    @Override
    public boolean update() {
        Updater updater = new Updater();
        if (! updater.updateAll(this.k, this.x0, this.maxY)) {
            this.errorString = updater.getErrorString();
            return false;
        }
        return true;
    }
    
    /**
     * @return the curve's steepness value
     */
    @Override
    public double getK() {
        return this.k.getValue();
    }

    /**
     * @return the curve's mid-point value
     */
    @Override
    public double getX0() {
        return this.x0.getValue();
    }

    @Override
    public double getMaxY() {
        return this.maxY.getValue();
    }
    
    @Override
    public void addTo(NumericInputArea inputArea) {
        inputArea.addFields(this.k, this.x0, this.maxY);
    }
    
    /**
     * @return the string set by {@link #update()} if there are any errors
     */
    @Override
    public String getErrorString() {
        return this.errorString;
    }
}
