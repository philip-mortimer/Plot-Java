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
package shared.function_of_x.quadratic;

import shared.utils.Complex;

/**
 * Stores the 2 quadratic roots as complex numbers.
 */
public class QuadraticRoots {
    private final Complex root1;
    private final Complex root2;
    
    QuadraticRoots(Complex root1, Complex root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public Complex getRoot1() {
        return root1;
    }

    public Complex getRoot2() {
        return root2;
    }    
}
