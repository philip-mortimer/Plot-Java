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
package shared.function_of_x;

import shared.utils.NumericRange;

/**
 * Plots the results of calling function f(x) for a specified range of x 
 * values.
 */
abstract public class FunctionOfXPlotter {
    /**
     * Plots a single point, specified by its x,y coordinate, in, for example, 
     * a line chart.
     */
    abstract public void plotPoint(double x, double y);

    /**
     * Creates the plot.
     * 
     * @param functionOfX   the f(x) function for calculating the y values
     * @param xRange        the range of x values
     * @param numPoints     number of x,y points in the plot
     * 
     */
    public void plot(FunctionOfX functionOfX, NumericRange xRange, 
                                                        int numPoints) {
        assert(numPoints > 1);
        
        final double xStep = xRange.getSpan() / (numPoints - 1);
        for (double x = xRange.getMin(); x < xRange.getMax(); x += xStep) {
            this.plotPoint(x, functionOfX.f(x));
        }
        this.plotPoint(xRange.getMax(), functionOfX.f(xRange.getMax()));
    }
}
