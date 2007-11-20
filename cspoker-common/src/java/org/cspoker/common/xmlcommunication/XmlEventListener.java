/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.cspoker.common.xmlcommunication;

/**
 * Interface for collecting XML messages encoded as a String.
 */
public interface XmlEventListener {

    /**
     * This method should queue up the XML for handling rather than
     * block during handling.
     *  
     * @param xml
     * 	      The XML message to collect.
     */
    public void collect(String xmlEvent);
    
}
