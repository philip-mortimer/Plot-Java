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

/**
 * Stores the x and y values of a coordinate in a 2-dimensional space.
 */
public class Coord2D {
    private final double x; 
    private final double y;
    
    public Coord2D(double x, double y) {
        this.x = x;
        this.y = y;        
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return String.format("x=%s, y=%s", realToStr(this.x), 
                                           realToStr(this.y));
    }
}
