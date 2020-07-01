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
package shared.function_of_x.logistic;

import shared.function_of_x.FunctionOfX;

/**
 * f(x) = L / (1 + exp(-k * (x - x0)))
 * where k is steepness of curve, x0 is mid-point of curve and L is max y.
 * 
 * See https://en.wikipedia.org/wiki/Logistic_function
 */
public class LogisticFunction implements FunctionOfX {
    private final double k;
    private final double x0;
    private final double maxY;
    
    public LogisticFunction(double k, double x0, double maxY) {
        this.k = k;
        this.x0 = x0;
        this.maxY = maxY;
    }
    
    public LogisticFunction(LogisticCoefficients coeffs) {
        this(coeffs.getK(), coeffs.getX0(), coeffs.getMaxY());
    }
    
    @Override
    public double f(double x) {
        return this.maxY / (1.0 + Math.exp(-this.k * (x - this.x0)));
    }    
}
