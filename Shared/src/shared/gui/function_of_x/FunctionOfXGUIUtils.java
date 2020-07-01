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

package shared.gui.function_of_x;

import javafx.scene.chart.XYChart;
import shared.function_of_x.FunctionOfX;
import shared.utils.NumericRange;
import shared.gui.SingleLineChart;

public class FunctionOfXGUIUtils {
    public static final int DEFAULT_NUM_PLOT_POINTS = 200;
    
    /**
     * Draws the line.
     * 
     * @param lineChart     the line chart on which the line is to be plotted
     * @param functionOfX   the f(x) function for calculating the y values
     * @param xRange        the range of x values
     * @param numPoints     the number of x,y data points 
     */
    public static void plot(SingleLineChart lineChart,
                            FunctionOfX functionOfX, 
                            NumericRange xRange,
                            int numPoints) {        
        XYChart.Series<Number, Number> dataPoints = new XYChart.Series<>();
        
        FunctionOfXPlotterToFXSeries plotter 
                = new FunctionOfXPlotterToFXSeries(dataPoints);
        plotter.plot(functionOfX, xRange, numPoints);
        
        lineChart.setDataPoints(dataPoints);
    } 

    public static void plot(SingleLineChart lineChart,
                            FunctionOfX functionOfX, 
                            NumericRange xRange) {
        plot(lineChart, functionOfX, xRange, DEFAULT_NUM_PLOT_POINTS);
    }
}
