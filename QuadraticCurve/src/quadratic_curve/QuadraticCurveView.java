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

package quadratic_curve;

import javafx.scene.layout.VBox;
import shared.gui.TextOutputArea;
import shared.gui.SingleLineChart;
import shared.gui.function_of_x.FunctionOfXView;
import shared.function_of_x.quadratic.QuadraticCoefficients;
import shared.utils.TextOutputDest;

/**
 * The user interface for the quadratic curve application.
 */
public class QuadraticCurveView extends FunctionOfXView {
    private static final String WINDOW_TITLE = "Quadratic Function";
    private static final String CHART_TITLE = "y=ax^2+bx+c";

    // Initial values in the input fields when the application starts.
    private static final double INITIAL_MIN_X = -5;
    private static final double INITIAL_MAX_X = 5;
    
    private static final double INITIAL_A = 2;
    private static final double INITIAL_B = 1;
    private static final double INITIAL_C = -3;
    
    private static final int TEXT_AREA_NUM_LINES = 3;
    
    private final QuadraticCoefficientInputGroup coeffsInputGroup;    
    private final TextOutputArea textOutputArea;
    
    public QuadraticCurveView() {
        super(WINDOW_TITLE, 
              new SingleLineChart(CHART_TITLE),
              INITIAL_MIN_X, 
              INITIAL_MAX_X);
        
        // Create the input fields where the user enters the quadratic
        // coefficients.
        this.coeffsInputGroup = new QuadraticCoefficientInputGroup(INITIAL_A, 
                                                                   INITIAL_B, 
                                                                   INITIAL_C);

        // Add the input fields to the view.
        this.addInputGroup(this.coeffsInputGroup);

        // Create the text area where information such as the quadratic roots 
        // is displayed.
        this.textOutputArea = new TextOutputArea(TEXT_AREA_NUM_LINES);
        
        // Create an output area and populate it with the line chart and text
        // area.
        VBox outputArea = new VBox();
        outputArea.getChildren().addAll(this.getLineChart().getNode(),
                                        this.textOutputArea.getNode());

        // Add the output area to the main view window. 
        this.setMainComponent(outputArea);                
    }

    QuadraticCoefficients getCoeffs() {
        return this.coeffsInputGroup;
        
    }
    
    TextOutputArea getTextOutputArea() {
        return this.textOutputArea;
    }
}
