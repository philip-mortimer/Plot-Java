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

import javafx.stage.Stage;
import shared.function_of_x.quadratic.QuadraticFunction;
import shared.gui.function_of_x.FunctionOfXController;
import shared.gui.TextOutputArea;
import static shared.gui.function_of_x.FunctionOfXGUIUtils.plot;

public class QuadraticCurveController extends FunctionOfXController {
    private final QuadraticCurveView quadraticCurveView;    
    
    public QuadraticCurveController(QuadraticCurveView quadraticCurveView) {
        super(quadraticCurveView);
        this.quadraticCurveView = quadraticCurveView;
    }
    
    /**
     * Outputs information (draws the plot line and displays information about 
     * the quadratic coefficients in the text area) based on the information 
     * entered by the user (the a, b and c values and range of x values). 
     * Called when the user clicks the Redraw button and there are no errors in 
     * the input data.
     */
    @Override
    public void generateOutput() {
        var quadraticFunction 
                = new QuadraticFunction(this.quadraticCurveView.getCoeffs());

        plot(this.quadraticCurveView.getLineChart(), quadraticFunction, 
                this.quadraticCurveView.getXRange());

        TextOutputArea dest = this.quadraticCurveView.getTextOutputArea();
        dest.clear();
        quadraticFunction.writeDescription(dest);
    }
}
