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
package org.cspoker.server.game.gameControl;

import org.cspoker.server.game.elements.chips.IllegalValueException;
import org.cspoker.server.game.player.GamePlayer;
import org.cspoker.server.game.player.IllegalNameException;
import org.cspoker.server.game.player.PlayerFactory;

class TestPlayerFactory extends PlayerFactory{

	@Override
	public synchronized GamePlayer getUniquePlayer(String name) throws IllegalNameException{
		return createNewPlayer(name);
	}

	@Override
	public synchronized GamePlayer getUniquePlayer(String name, int initialValue) throws IllegalValueException, IllegalNameException{
		try {
			return createNewPlayer(name, initialValue);
		} catch (IllegalValueException e) {
			throw new IllegalStateException(getStdStackValue()
					+ " should be a valid value.");
		}
	}
}