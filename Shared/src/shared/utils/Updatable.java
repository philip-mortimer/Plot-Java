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
package shared.utils;

/**
 * An object containing an update action which would typically entail 
 * synchronising the object's internal data with a source e.g. updating a 
 * numeric value so that it is the same as the value entered in a GUI input 
 * field.
 */
public interface Updatable {
    /**
     * @return true if the update action is successful, otherwise returns 
     * false e.g it will return false if a numeric input field contains illegal 
     * characters
     */
    public boolean update();
    
    /**
     * @return the error string set by {@link #update() update} if the update
     * action failed
     */
    public String getErrorString();    
}
