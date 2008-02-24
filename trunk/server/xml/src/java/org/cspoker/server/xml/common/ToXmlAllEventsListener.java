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
package org.cspoker.server.xml.common;

import java.io.StringWriter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;
import org.cspoker.common.eventlisteners.AllEventsListener;
import org.cspoker.common.events.Event;
import org.cspoker.common.events.gameevents.GameMessageEvent;
import org.cspoker.common.events.gameevents.NewCommunityCardsEvent;
import org.cspoker.common.events.gameevents.NewDealEvent;
import org.cspoker.common.events.gameevents.NewRoundEvent;
import org.cspoker.common.events.gameevents.NextPlayerEvent;
import org.cspoker.common.events.gameevents.PlayerJoinedGameEvent;
import org.cspoker.common.events.gameevents.PlayerLeftTableEvent;
import org.cspoker.common.events.gameevents.ShowHandEvent;
import org.cspoker.common.events.gameevents.WinnerEvent;
import org.cspoker.common.events.gameevents.playeractionevents.AllInEvent;
import org.cspoker.common.events.gameevents.playeractionevents.BetEvent;
import org.cspoker.common.events.gameevents.playeractionevents.BigBlindEvent;
import org.cspoker.common.events.gameevents.playeractionevents.CallEvent;
import org.cspoker.common.events.gameevents.playeractionevents.CheckEvent;
import org.cspoker.common.events.gameevents.playeractionevents.FoldEvent;
import org.cspoker.common.events.gameevents.playeractionevents.RaiseEvent;
import org.cspoker.common.events.gameevents.playeractionevents.SmallBlindEvent;
import org.cspoker.common.events.gameevents.privateevents.NewPocketCardsEvent;
import org.cspoker.common.events.serverevents.PlayerJoinedEvent;
import org.cspoker.common.events.serverevents.PlayerLeftEvent;
import org.cspoker.common.events.serverevents.ServerMessageEvent;
import org.cspoker.common.events.serverevents.TableCreatedEvent;
import org.cspoker.common.xml.EventAndActionJAXBContext;
import org.cspoker.common.xml.XmlEventListener;
import org.cspoker.common.xml.eventlisteners.invocation.AllInvocationEventsListener;
import org.cspoker.common.xml.events.invocation.IllegalActionEvent;
import org.cspoker.common.xml.events.invocation.SuccessfulInvocationEvent;

public class ToXmlAllEventsListener implements AllEventsListener, AllInvocationEventsListener {

	private final static Logger logger = Logger.getLogger(ToXmlAllEventsListener.class);
	private final XmlEventListener collector;

	public ToXmlAllEventsListener(XmlEventListener collector) {
		this.collector = collector;
	}

	public void eventToCollector(Event event) {
		try {
			StringWriter xml = new StringWriter();
			Marshaller m = EventAndActionJAXBContext.context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FRAGMENT,true);
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(event, xml);
			collector.collect(xml.toString());
		} catch (PropertyException e) {
			logger.fatal(e);
			throw new IllegalStateException(e);
		} catch (JAXBException e) {
			logger.fatal(e);
			throw new IllegalStateException(e);
		}
	}

	public void onAllInEvent(AllInEvent event) {
		eventToCollector(event);
	}

	public void onBetEvent(BetEvent event) {
		eventToCollector(event);
	}

	public void onBigBlindEvent(BigBlindEvent event) {
		eventToCollector(event);
	}

	public void onCallEvent(CallEvent event) {
		eventToCollector(event);
	}

	public void onCheckEvent(CheckEvent event) {
		eventToCollector(event);
	}

	public void onFoldEvent(FoldEvent event) {
		eventToCollector(event);
	}

	public void onRaiseEvent(RaiseEvent event) {
		eventToCollector(event);
	}

	public void onSmallBlindEvent(SmallBlindEvent event) {
		eventToCollector(event);
	}

	public void onNewPocketCardsEvent(NewPocketCardsEvent event) {
		eventToCollector(event);
	}

	public void onNewCommunityCardsEvent(NewCommunityCardsEvent event) {
		eventToCollector(event);
	}

	public void onNewDealEvent(NewDealEvent event) {
		eventToCollector(event);
	}

	public void onNewRoundEvent(NewRoundEvent event) {
		eventToCollector(event);
	}

	public void onNextPlayerEvent(NextPlayerEvent event) {
		eventToCollector(event);
	}

	public void onPlayerJoinedGameEvent(PlayerJoinedGameEvent event) {
		eventToCollector(event);
	}

	public void onPlayerLeftTableEvent(PlayerLeftTableEvent event) {
		eventToCollector(event);
	}

	public void onShowHandEvent(ShowHandEvent event) {
		eventToCollector(event);
	}

	public void onWinnerEvent(WinnerEvent event) {
		eventToCollector(event);
	}

	public void onGameMessageEvent(GameMessageEvent event) {
		eventToCollector(event);
	}

	public void onPlayerJoinedEvent(PlayerJoinedEvent event) {
		eventToCollector(event);
	}

	public void onPlayerLeftEvent(PlayerLeftEvent event) {
		eventToCollector(event);
	}

	public void onTableCreatedEvent(TableCreatedEvent event) {
		eventToCollector(event);
	}

	public void onServerMessageEvent(ServerMessageEvent event) {
		eventToCollector(event);
	}

	@Override
	public void onIllegalAction(IllegalActionEvent event) {
		eventToCollector(event);
	}

	@Override
	public void onSuccessfullInvokation(SuccessfulInvocationEvent<?> event) {
		eventToCollector(event);
	}

}