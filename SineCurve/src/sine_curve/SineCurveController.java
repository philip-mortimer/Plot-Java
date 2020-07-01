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

import javafx.stage.Stage;
import shared.function_of_x.SineFunction;
import shared.gui.function_of_x.FunctionOfXController;
import static shared.gui.function_of_x.FunctionOfXGUIUtils.plot;

public class SineCurveController extends FunctionOfXController {
    private final SineCurveView sineCurveView;    
    private final SineFunction sineFunction;
    
    public SineCurveController(SineCurveView sineCurveView) {
        super(sineCurveView);
        this.sineCurveView = sineCurveView;
        this.sineFunction = new SineFunction();
    }
    
    /**
     * Draws the line in the line chart based on the range of x values 
     * entered by the user. Called when the user clicks the Redraw
     * button and there are no errors in the input data.
     */
    @Override
    public void generateOutput() {
        plot(this.sineCurveView.getLineChart(), this.sineFunction, 
                                        this.sineCurveView.getXRange());
    }
}
