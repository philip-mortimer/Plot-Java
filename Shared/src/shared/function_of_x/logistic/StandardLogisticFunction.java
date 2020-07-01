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

/**
 * f(x) = L / (1 + exp(-k * (x - x0)))
 * where k=1, x0=0, L=1 (L is max y).
 * 
 * Equivalent to f(x) = 1 / (1 + exp(-x))
 * 
 * See https://en.wikipedia.org/wiki/Logistic_function
 */
public class StandardLogisticFunction extends LogisticFunction {
    private static final double K = 1;
    private static final double X0 = 0;
    private static final double MAX_Y = 1;
    
    public StandardLogisticFunction() {
        super(K, X0, MAX_Y);        
    }
}
