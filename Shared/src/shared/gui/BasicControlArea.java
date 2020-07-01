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

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import shared.gui.GUIComponent;

/**
 * Area in a GUI containing an action button, which performs
 * an action specified by the setActionHandler method when clicked,
 * and an exit button which causes the application to be exited
 * when clicked.
 */
public class BasicControlArea implements GUIComponent {
    // Top level container containing the 2 buttons.
    HBox root;
    
    Button actionButton;
    Button exitButton;
    
    public BasicControlArea(String actionButtonText) {
        this.actionButton = new Button(actionButtonText);
        
        this.exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        // Create the container and add both buttons to it.
        this.root = new HBox(actionButton, exitButton);
        this.root.getStyleClass().add("controlarea");
    }
    
    /**
     * Specifies an action to be performed when the action button (the 
     * button which is not the exit button) is clicked.
     * 
     * @param e the action to be performed
     */
    public void setActionHandler(EventHandler<ActionEvent> e) {
        this.actionButton.setOnAction(e);
    }
    
    @Override
    public Node getNode() {
        return this.root;
    }
}
