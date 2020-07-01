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
import shared.utils.TextOutputDest;
import shared.gui.GUIComponent;
import javafx.scene.control.TextArea;

/**
 * An area in a GUI where non user-editable multi-line text is displayed.
 */
public class TextOutputArea extends TextOutputDest implements GUIComponent  {
    private final TextArea textArea;
    
    public TextOutputArea(int prefRowCount) {
        this.textArea = new TextArea();
        this.textArea.setEditable(false);
        this.textArea.setPrefRowCount(prefRowCount);
    }
    
    @Override
    public void write(String str) {
        this.textArea.appendText(str);
    }
    
    public void clear() {
        this.textArea.setText("");
    }
    
    @Override
    public Node getNode() {
        return this.textArea;
    }

}