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
import shared.function_of_x.FunctionOfXPlotter;

/**
 * Plots the results of y=f(x) for a specified range of x 
 * values by adding the resultant x,y values to a JavaFX series .
 */
public class FunctionOfXPlotterToFXSeries extends FunctionOfXPlotter {
    private final XYChart.Series<Number,Number> series;
    
    public FunctionOfXPlotterToFXSeries(XYChart.Series<Number,Number> series) {
        this.series = series;
    }
    
    @Override
    public void plotPoint(double x, double y) {
        this.series.getData().add(new XYChart.Data<>(x, y)); 
    }
}
