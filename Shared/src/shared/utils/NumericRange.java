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

/**
 * Range of numeric values specified by the minimum and maximum values in the
 * range.
 */
public class NumericRange {
    private final double min;
    private final double max;
    
    public NumericRange(double min, double max) {
        assert(min < max);
        
        this.min = min;
        this.max = max;
    }
    
    public double getMin() {
        return this.min;
    }
    
    public double getMax() {
        return this.max;
    }
    
    /**
     * @return difference between the min and max values in the range
     */
    public double getSpan() {
        return this.getMax() - this.getMin();
    }
}
