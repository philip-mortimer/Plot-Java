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
package quadratic_curve;

import shared.gui.*;
import shared.utils.Updatable;
import shared.utils.Updater;
import shared.function_of_x.quadratic.QuadraticCoefficients;

/**
* Group of fields where user enters the a, b and c values in the quadratic
* function f(x)=ax^2+bx+c.
*/
public class QuadraticCoefficientInputGroup implements 
        NumericInputGroup,QuadraticCoefficients {
    private final NumericField a;
    private final NumericField b;
    private final NumericField c;
    
    private String errorString;

    public QuadraticCoefficientInputGroup(double initialA,
                                          double initialB, 
                                          double initialC) {
        this.a = new NumericField("a", initialA);
        this.b = new NumericField("b", initialB);
        this.c = new NumericField("c", initialC);
        
        this.errorString = "";
    }
    
    @Override
    public boolean update() {
        // Retrieve the coefficients from the input fields.
        Updater updater = new Updater();
        if (! updater.updateAll(this.a, this.b, this.c)) {
            this.errorString = updater.getErrorString();
            return false;
        }
        return true;
    }

    @Override
    public double getA() {
        return this.a.getValue();
    }

    @Override
    public double getB() {
        return this.b.getValue();
    }

    @Override
    public double getC() {
        return this.c.getValue();
    }
    
    @Override
    public void addTo(NumericInputArea inputArea) {
        inputArea.addFields(this.a, this.b, this.c);
    }
    
    @Override
    public String getErrorString() {
        return this.errorString;
    }
}
