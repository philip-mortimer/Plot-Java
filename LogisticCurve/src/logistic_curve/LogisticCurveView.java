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
package logistic_curve;

import shared.function_of_x.logistic.LogisticCoefficients;
import shared.gui.SingleLineChart;
import shared.gui.function_of_x.FunctionOfXView;

/**
 * The user interface for the logistic curve application.
 */
public class LogisticCurveView extends FunctionOfXView {
    private static final String WINDOW_TITLE = "Logistic Function";
    private static final String CHART_TITLE 
                                = "y = L / (1 + exp(-k * (x - x0)))";

    // Initial values in the input fields when the application starts.
    private static final double INITIAL_MIN_X = -8;
    private static final double INITIAL_MAX_X = 8;
    
    private static final double INITIAL_K = 1;
    private static final double INITIAL_X0 = 0;
    private static final double INITIAL_MAX_Y = 1;
    
    private final LogisticCoefficientInputGroup coeffsInputGroup;    
    
    public LogisticCurveView() {
        super(WINDOW_TITLE, 
              new SingleLineChart(CHART_TITLE), 
              INITIAL_MIN_X, 
              INITIAL_MAX_X);
        
        // Create the input fields where the user enters the
        // k, x0 and max y values.
        this.coeffsInputGroup = new LogisticCoefficientInputGroup(
                                                                INITIAL_K, 
                                                                INITIAL_X0, 
                                                                INITIAL_MAX_Y);                
        // Add the input fields to the view.
        this.addInputGroup(this.coeffsInputGroup);        
    }

    public LogisticCoefficients getCoeffs() {
        return this.coeffsInputGroup;
    }
}
