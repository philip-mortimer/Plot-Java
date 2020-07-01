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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;

/**
 *
 * An area of a GUI containing numeric input fields.
 * 
 */
public class NumericInputArea {
    private static final int GROUP_SEPARATOR_SIZE = 2;

    private final GridPane grid;
    private int rowIndex;
    
    public NumericInputArea() {
        this.grid = new GridPane();
        this.grid.getStyleClass().add("numericinputarea");
        this.rowIndex = 0;        
    }
    
    /**
     * Adds a field labelled by the field's name to the GUI area .
     */
    public void addField(NumericField field) {
        Label label = new Label(field.getName() + ": ");
        GridPane.setHalignment(label, HPos.RIGHT); // right justifies the label               
        this.grid.add(label, 0, this.rowIndex);
        this.grid.add(field.getNode(), 1, this.rowIndex);  
        
        this.rowIndex++;
    }

    public void addFields(NumericField... fields) {
        for (NumericField field: fields) {
            this.addField(field);
        }        
    }
    
    /**
     * Adds a group of numeric input fields to the GUI area followed
     * by a gap to separate the last field in the group from the next 
     * field added to the area (see {@link #addGap(int) addGap} method).
     */
    public void addGroup(NumericInputGroup group) {
        group.addTo(this);    
        this.addGap(GROUP_SEPARATOR_SIZE);
    }

    public void addGroups(NumericInputGroup... groups) {
        for (NumericInputGroup group: groups) {
            this.addGroup(group);
        }
    }
    
    /**
     * Adds a gap to the GUI area so that the next field added to the area 
     * is preceded by the gap.
     * 
     * @param size size of the gap (in the current implementation it is the 
     * number of grid pane rows).
     */
    public void addGap(int size) {
        for (int i = 0; i < size; i++) {
            this.grid.add(new Label(), 0, this.rowIndex, 2, 1);
            rowIndex++;
        }
    }
    
    public Node getNode() {
        return this.grid;
    }
}
