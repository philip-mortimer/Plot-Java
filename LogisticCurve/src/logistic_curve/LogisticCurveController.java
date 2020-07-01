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

import javafx.stage.Stage;
import shared.function_of_x.logistic.LogisticFunction;
import shared.gui.function_of_x.FunctionOfXController;
import static shared.gui.function_of_x.FunctionOfXGUIUtils.plot;

public class LogisticCurveController extends FunctionOfXController {
    private final LogisticCurveView logisticCurveView;    
    
    public LogisticCurveController(LogisticCurveView logisticCurveView) {
        super(logisticCurveView);
        this.logisticCurveView = logisticCurveView;
    }
    
    /**
     * Draw's the line in the line chart using the k, x0, L and range of x 
     * values entered by the user. Called when the user clicks the Redraw
     * button and there are no errors in the input data.
     */
    @Override
    public void generateOutput() {
        var logisticFunction 
                = new LogisticFunction(this.logisticCurveView.getCoeffs());
        plot(this.logisticCurveView.getLineChart(), logisticFunction, 
                                        this.logisticCurveView.getXRange());
    }
}
