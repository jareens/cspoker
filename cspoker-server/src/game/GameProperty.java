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

package game;

/**
 * 
 * This class should contain all parameters of a game,
 * such as maximum number of players, maximum bet/raise,
 * the amount for small/big blinds,...
 * 
 * @author Kenzo
 *
 */
public class GameProperty {
	
	private final int smallBlind;
	
	private final int bigBlind;
	
	public GameProperty(){
		smallBlind = 25;
		bigBlind = 50;
	}
	
	
	public int getSmallBlind(){
		return smallBlind;
	}
	
	public int getBigBlind(){
		return bigBlind;
	}
	
	public boolean isClosedGame(){
		return false;
	}
	
	public int getMaxNbPlayers(){
		return 10;
	}

}
