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

package shared.gui;

import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * A line chart containing no more than one line.
 */
public class SingleLineChart implements GUIComponent {
    public static final String DEFAULT_X_AXIS_LABEL = "x";
    public static final String DEFAULT_Y_AXIS_LABEL = "y";
    
    private LineChart<Number,Number> root;
    
    static private NumberAxis createNumberAxis(String labelText) {
        final NumberAxis axis = new NumberAxis();
        axis.setAutoRanging(true);
        axis.setLabel(labelText);
        
        return axis;        
    }
    
    public SingleLineChart(String title, String xAxisLabel,
                                            String yAxisLabel) {
        final NumberAxis xAxis = createNumberAxis(xAxisLabel);
        final NumberAxis yAxis = createNumberAxis(yAxisLabel);     

        this.root = new LineChart<>(xAxis, yAxis);  
        root.setTitle(title);
        
        root.setCreateSymbols(false);
        root.setLegendVisible(false);
    }

    public SingleLineChart(String title) {
        this(title, DEFAULT_X_AXIS_LABEL, DEFAULT_Y_AXIS_LABEL);
    }
    
    /**
     * Sets the series of x,y data points for the line. This results in the
     * line being (re-)drawn with the new data points.
     */
    public void setDataPoints(XYChart.Series<Number,Number> dataPoints) {
        // Remove current line from the chart if it exists.
        if (! this.root.getData().isEmpty()) {
            this.root.getData().remove(0);
        }
        // Add the series of points to the chart.
        this.root.getData().add(dataPoints);        
    }

    @Override
    public Node getNode() {
        return this.root;
    }
}
