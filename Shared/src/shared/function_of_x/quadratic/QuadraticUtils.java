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
package shared.function_of_x.quadratic;

import shared.utils.Complex;
import shared.utils.Coord2D;
import shared.utils.TextOutputDest;
import static shared.utils.Utils.realToStr;
import static shared.utils.Utils.almostEqual;

public class QuadraticUtils {
    /**
     * 
     * @return the result of the quadratic function ax^2 + bx + c
     */
    public static double quadratic(double x, double a, double b, double c) {
        return a*x*x + b*x + c;        
    }
    
    public static QuadraticRoots getQuadraticRoots(double a, 
                                                   double b, 
                                                   double c) {
        Complex root1, root2;
        double discrim = b * b - 4.0 * a * c;
        double denom = 2.0 * a;
        if (discrim < 0) {
            // Roots are complex.
            double realPart = -b / denom;            
            double absImagPart = Math.sqrt(-discrim) / denom;
            
            root1 = new Complex(realPart, absImagPart);
            root2 = new Complex(realPart, -absImagPart);
        }
        else {
            // Roots are real.
            double sqRootOfDiscrim = Math.sqrt(discrim);

            double root1Value = (-b + sqRootOfDiscrim) / denom;
            root1 = new Complex(root1Value, 0);

            double root2Value = (-b - sqRootOfDiscrim) / denom;            
            root2 = new Complex(root2Value, 0);            
        }
        return new QuadraticRoots(root1, root2);        
    } 
    
    /**
     * @return x,y coordinate where y is at a minimum or maximum for the 
     * quadratic function 
     */
    public static Coord2D getQuadraticVertex(double a, double b, double c) {
        double vertex_x = -b / (2.0 * a);
        double vertex_y = quadratic(vertex_x, a, b, c);
        
        return new Coord2D(vertex_x, vertex_y);        
    }
    
    public static boolean closeToLinear(double a, double b) {
        final double epsilon = 10e-9;
        return a < (b * epsilon);
    }
    
    /**
      * Outputs information about the quadratic coefficients a, b and c in a 
      * text area. This includes:
      *    <ul>
      *       <li>
      *       The quadratic roots. 
      *       <li>
      *       The vertex - the x and y values on the plot line 
      *       where y is at a minimum or maximum.
      *    </ul>
      * If a=0 (and b is not 0) it displays the linear intercept (x where y=0)
      * in place of the above information.
      * 
      * <p>If a=0 and b=0 it just states in place of the above information
      * that y has a constant value equal to c.
      * 
      * @param dest the destination of the text output such as standard
      * output or a text area in in a GUI window
      * 
      * @param a the a coefficient
      * 
      * @param b the b coefficient
      * 
      * @param c the c coefficient
      * 
      */    
    public static void writeQuadraticDescription(TextOutputDest dest,
                                                 double a, 
                                                 double b, 
                                                 double c) {
        String str = String.format("a=%s, b=%s, c=%s", realToStr(a),
                                                       realToStr(b),
                                                       realToStr(c));
        dest.writeLine(str);
        
        if (almostEqual(a, 0) && almostEqual(b, 0)) {
            dest.write(String.format("Constant y:  %s", realToStr(c)));
            return;
        }

        if (almostEqual(a, 0)) {
            double intercept = -c/b;
            str = String.format("Linear intercept (x where y=0):  %s",
                            realToStr(intercept));
            dest.write(str);
            return;
        }
        
        QuadraticRoots roots = getQuadraticRoots(a, b, c);
        String root1Str = roots.getRoot1().toString();
        String root2Str = roots.getRoot2().toString();
        if (root1Str.equals(root2Str)) {
            dest.writeLine("Root:  " + root1Str);                                    
        }
        else {
            str = "Roots:  " + root1Str + ", " + root2Str;
            dest.writeLine(str);
        }
        
        Coord2D vertex = getQuadraticVertex(a, b, c);
        String minMax = a < 0 ? "maximum" : "minimum";
        dest.write("Vertex (point where y is at a " + minMax + "):  "
            + vertex.toString());
    }
}
