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
import javafx.scene.paint.Color;

/**
 * An area in a GUI where information and error messages are displayed.
 */
public class MessageArea implements GUIComponent {
    private static final Color ERROR_TEXT_COLOUR = Color.RED;
    private static final Color INFO_TEXT_COLOUR = Color.BLACK;
    
    private final Label label;
    
    public MessageArea() {
        this.label = new Label();
        this.label.getStyleClass().add("messagearea");
    }
    
    private void showMessage(String message, Color colour) {
        this.label.setTextFill(colour);
        this.label.setText(message);        
    }
    
    public void showErrorMessage(String message) {
        this.showMessage(message, ERROR_TEXT_COLOUR);
    }
    
    public void showInfoMessage(String message) {
        this.showMessage(message, INFO_TEXT_COLOUR);
    }

    public void clear() {
        this.label.setText("");
    }
    
    @Override
    public Node getNode() {
        return this.label;
    }       
}
