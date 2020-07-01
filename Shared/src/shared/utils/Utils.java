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

public class Utils {
    public static final double EPSILON = 10e-12;
    
    public static boolean almostEqual(double x1, double x2) {
        return Math.abs(x1 - x2) < EPSILON;
    }

    public static String realToStr(double x) {
        String str = String.format("%.2f", x);
        if (str.equals("-0.00")) {
            return "0.00";
        }
        else {
            return str;
        }
    }    
}
