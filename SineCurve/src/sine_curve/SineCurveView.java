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
package sine_curve;

import shared.gui.function_of_x.FunctionOfXView;
import shared.gui.SingleLineChart;

/**
 * The user interface for the sine curve application.
 */
public class SineCurveView extends FunctionOfXView {
    private static final String WINDOW_TITLE  = "Sine Curve Function";
    private static final String CHART_TITLE   = WINDOW_TITLE;

    private static final String X_AXIS_LABEL  = "x (radians)";
    private static final String Y_AXIS_LABEL  = "Sine x";

    // Initial values in the input fields when the application starts.
    private static final double INITIAL_MIN_X = 0;
    private static final double INITIAL_MAX_X = 6.28; // 2 * pi approx.
    
    public SineCurveView() {
        super(WINDOW_TITLE,                 
              new SingleLineChart(CHART_TITLE, 
                                  X_AXIS_LABEL,
                                  Y_AXIS_LABEL),
              INITIAL_MIN_X, 
              INITIAL_MAX_X);
    }    
}
