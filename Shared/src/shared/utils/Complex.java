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
package shared.utils;

import static shared.utils.Utils.realToStr;
import static shared.utils.Utils.almostEqual;

/**
 * Stores a complex number.
 */
public class Complex {
    private final double realPart;
    private final double imagPart;
    
    public Complex(double realPart, double imagPart) {
        this.realPart = realPart;
        this.imagPart = imagPart;
    }

    /**
     * @return the realPart
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * @return the imagPart
     */
    public double getImagPart() {
        return imagPart;
    }  
    
    @Override
    public String toString() {
        if (almostEqual(this.getImagPart(), 0)) {
            // Number is real.
            return realToStr(this.getRealPart());
        }
        else {
            // Number is complex.
            char sign = this.getImagPart() < 0 ? '-' : '+';            
            double absImagPart = Math.abs(this.getImagPart());
            return String.format("(%s %c %si)", 
                    realToStr(this.getRealPart()),
                    sign,
                    realToStr(absImagPart)
            );
        }
    }
}
