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

package org.cspoker.server.game.gameControl.rounds;

import org.apache.log4j.Logger;
import org.cspoker.server.game.GameMediator;
import org.cspoker.server.game.events.gameEvents.NewRoundEvent;
import org.cspoker.server.game.gameControl.Game;
import org.cspoker.server.game.gameControl.Showdown;
import org.cspoker.server.game.player.Player;

public class FinalRound extends BettingRound{
	private static Logger logger = Logger.getLogger(FinalRound.class);

	public FinalRound(GameMediator gameMediator, Game game) {
		super(gameMediator, game);
		Player currentPlayer = game.getCurrentPlayer();
		if(currentPlayer!=null)
			gameMediator.publishNewRoundEvent(new NewRoundEvent(toString(), currentPlayer.getSavedPlayer()));
		FinalRound.logger.info("** Final Round **");
		drawMuckCard();
		drawOpenCardAndPublishCommonCard();
	}

	@Override
	public void endRound() {
		if(onlyOnePlayerLeft()){
			super.endRound();
		}else{
			collectChips();
			game.getPots().close(game.getCurrentDealPlayers());
			Showdown showdown = new Showdown(gameMediator, getGame());
			showdown.determineWinners();
		}
		game.setDealer(game.getNextDealer());
	}

	@Override
	public Round getNextRound() {
		return getNewDealRound();
	}
	@Override
	public boolean isLowBettingRound() {
		return false;
	}

	@Override
	public boolean isHighBettingRound() {
		return !isLowBettingRound();
	}

	@Override
	public String toString(){
		return "final round";
	}
}