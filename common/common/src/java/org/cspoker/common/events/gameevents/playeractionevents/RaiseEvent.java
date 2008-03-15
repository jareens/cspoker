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

package org.cspoker.common.events.gameevents.playeractionevents;

import java.rmi.RemoteException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.cspoker.common.elements.pots.Pots;
import org.cspoker.common.eventlisteners.RemoteAllEventsListener;
import org.cspoker.common.player.Player;

/**
 * A class to represent raise events.
 * 
 * @author Kenzo
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RaiseEvent extends ActionChangedPotEvent {

	private static final long serialVersionUID = -5634645028675762487L;

	private Player player;

	private int amount;

	public RaiseEvent(Player player, int amount, Pots pots) {
		super(pots);
		this.player = player;
		this.amount = amount;
	}

	protected RaiseEvent() {
		// no op
	}

	
	public String toString() {
		return getPlayer().getName() + " raises with " + getAmount()
				+ " chips.";
	}

	public int getAmount() {
		return amount;
	}

	public Player getPlayer() {
		return player;
	}

	
	public void dispatch(RemoteAllEventsListener listener)
			throws RemoteException {
		listener.onRaiseEvent(this);
	}

}