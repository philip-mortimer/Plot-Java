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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shared.gui.*;
import javafx.scene.Node;
import java.util.ArrayList;
import javafx.scene.Scene;
import shared.utils.Updater;
import shared.utils.NumericRange;

/**
 * The main user interface of an application which consists of:
 * <ul> 
 *  <li>An area containing numeric input fields such as minimum and maximum 
 *  x values for the plot and quadratic coefficients.
 * 
 *  <li>The main area where components such as a line chart may be placed.
 *
 *  <li>2 buttons:
 *     <ul>
 *     <li>A button named 'Redraw' to which an action can be assigned when 
 *     it is clicked such as redrawing a line plot.
 * 
 *     <li>A button named 'Exit' which when clicked causes the application 
 *     to be exited.
 *     </ul>
 *  <li>An area for displaying error messages.
 * </ul>
 */
public class FunctionOfXView {
    private static final String STYLE_SHEET_PATH = "shared/gui/styles.css";

    private final String windowTitle;
    
    private final BorderPane root;
    
    private final SingleLineChart lineChart;
    private final NumericInputArea inputArea;
    private final MessageArea errorMessageArea; 
    private final XRangeInputGroup xRangeInputGroup;
    
    // Contains 'Redraw' and 'Exit' buttons.
    private final BasicControlArea controlArea; 
    
    // Input groups are stored in this list so that
    // they can be updated.
    private final ArrayList<NumericInputGroup> inputGroups;
    
    
    private Node mainComponent;

    /**
     * @param windowTitle title which appears at the top of the main window
     * 
     * @param lineChart line chart which is the view's main component (unless
     * another component is specified by calling {@link 
     * #setMainComponent(Node) setMainComponent}), and is the line chart
     * returned by the {@link #getLineChart() getLineChart} method
     * 
     * @param initialMinX initial value of the Min X input field
     * 
     * @param initialMaxX initial value of the Max X input field
     */
    public FunctionOfXView(String windowTitle, 
                           SingleLineChart lineChart,
                           double initialMinX,
                           double initialMaxX) {
        this.windowTitle = windowTitle;        
        
        this.inputArea = new NumericInputArea();
        this.controlArea = new BasicControlArea("Redraw");
        this.errorMessageArea = new MessageArea();
        this.xRangeInputGroup = new XRangeInputGroup(initialMinX, initialMaxX);
        
        this.lineChart = lineChart;
        this.mainComponent = lineChart.getNode();
        
        VBox controlAndMessageArea = new VBox(this.controlArea.getNode(),
                                              this.errorMessageArea.getNode());
        controlAndMessageArea.getStyleClass().add("controlandmessagearea");
        
        this.root = new BorderPane();
        this.root.setLeft(inputArea.getNode());
        this.root.setBottom(controlAndMessageArea);
        
        this.inputGroups = new ArrayList<>();
    }
    
    /**
     * Adds a group of numeric input fields to the view.
     * 
     * @param group group of numeric input fields
     */
    protected void addInputGroup(NumericInputGroup group) {
        this.inputArea.addGroup(group);
        this.inputGroups.add(group);
    }
    
    /**
     * Sets the main component of the view (in the current implementation the 
     * main component is the 'center' of a BorderPane object). If the main
     * component is not set using setMainComponent then it will default 
     * to the line chart which was passed to the constructor.
     * 
     * @param node the main component such as a VBox object which normally 
     * contains the line chart which was passed to the constructor.
     */
    protected void setMainComponent(Node node) {
        this.mainComponent = node;
    }
    
    /**
     * See {@link #setMainComponent(Node)}.
     */
    protected void setMainComponent(GUIComponent component) {
        this.setMainComponent(component.getNode());        
    }
    
    /**
     * Assign action to the 'Redraw' button when it is clicked such as draw a
     * line plot.
     */    
    public void setRedrawAction(EventHandler<ActionEvent> e) {
        this.controlArea.setActionHandler(e);        
    }
        
    public void showErrorMessage(String message) {
        this.errorMessageArea.showErrorMessage(message);
    }

    public void clearErrorMessage() {
        this.errorMessageArea.clear();
    }
    
    /**
     * @return the range of values which the user has entered in the Min X and 
     * Max X fields
     */
    public NumericRange getXRange() {
        return this.xRangeInputGroup.getRange();
    }
    
    /**
     * @return the line chart passed to the constructor
     */
    public SingleLineChart getLineChart() {
        return this.lineChart;
    }

    /**
     * Retrieves the values entered by the user in the input fields.
     * 
     * @return true if there are no errors in the input data, otherwise 
     * displays an error message and returns false
     */        
    public boolean retrieveInputData() {
        final Updater updater = new Updater();

        boolean ok = true;
        for (NumericInputGroup inputGroup: inputGroups) {
            if (! updater.update(inputGroup)) {
                ok = false;
            }
        }

        if (ok) {
            this.clearErrorMessage();
            return true;
        }
        else {
            this.showErrorMessage(updater.getErrorString());
            return false;
        }        
    }
    
    public void show(Stage stage) {
        // Add the Min X and Max X input fields as the last group of input 
        // fields in the area of the interface containing the input fields.
        this.addInputGroup(this.xRangeInputGroup);

        this.mainComponent.getStyleClass().add("maincomponent");
        this.root.setCenter(this.mainComponent);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(STYLE_SHEET_PATH);
        
        stage.setScene(scene);
        stage.setTitle(this.windowTitle);
        stage.show();
    }
 }
