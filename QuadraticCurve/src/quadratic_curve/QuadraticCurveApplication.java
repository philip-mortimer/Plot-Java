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

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * This application uses the information entered by the user (quadratic 
 * coefficients a, b and c, and minimum and maximum x values) to:
 * <ul>
 * <li>
 * Plot the quadratic function y=ax^2+bx+c in a line chart
 * <li>
 * Display information such as the quadratic roots in a text area (see 
 * {@link shared.function_of_x.quadratic.QuadraticUtils#writeQuadraticDescription(TextOutputDest,double,double,double) writeQuadraticDescription}).
 * </ul>
 */
public class QuadraticCurveApplication extends Application {    
    @Override
    public void start(Stage stage) {
        QuadraticCurveController controller 
                = new QuadraticCurveController(new QuadraticCurveView());
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
}
