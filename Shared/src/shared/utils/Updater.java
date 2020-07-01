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
 * Updates one or more objects that implement the 
 * {@link shared.utils.Updatable} interface.
 */
public class Updater {
    private static final String DEFAULT_SEPARATOR = "; ";
    
    private final String separator;
    private String errorString;
    
    /**
     * @param separator separates error messages where each error message is
     * generated by one of the objects where the update failed
     */
    public Updater(String separator) {
        this.separator = separator;
        errorString = "";
    
    }
    
    public Updater() {
        this(DEFAULT_SEPARATOR);
    
    }

    private void addErrorMessage(String message) {
        if (this.errorString.equals("")) {
            this.errorString = message;
        }
        else {
            this.errorString = this.errorString + this.separator
                    + message;
        }
    }

    public boolean update(Updatable item) {
        if (item.update()) {
            return true;
        }
        else {
            this.addErrorMessage(item.getErrorString());
            return false;
        }
    }
    
    public boolean updateAll(Updatable... items) {
        boolean ret = true;
        for (Updatable item: items) {
            if (! this.update(item)) {
                ret = false;
            }
        }
        return ret;
    }

    /**
     * @return concatenation of error messages where each error message is
     * generated by one of the objects where the update failed
     */
    public String getErrorString() {
        return errorString;
    }
}