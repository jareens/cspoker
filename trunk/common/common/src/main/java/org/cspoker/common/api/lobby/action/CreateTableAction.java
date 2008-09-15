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
package org.cspoker.common.api.lobby.action;

import javax.xml.bind.annotation.XmlRootElement;

import org.cspoker.common.api.lobby.LobbyContext;
import org.cspoker.common.elements.table.Table;
import org.cspoker.common.elements.table.TableConfiguration;

@XmlRootElement
public class CreateTableAction extends LobbyAction<Table> {

	private static final long serialVersionUID = 2423639524369017909L;
	
	private String name;
	private TableConfiguration configuration;

	public CreateTableAction(long id, String name) {
		super(id);
		this.name = name;
		configuration = null;
	}

	public CreateTableAction(long id, String name, TableConfiguration settings) {
		super(id);
		this.name = name;
		this.configuration = settings;
	}

	protected CreateTableAction() {
		// no op
	}

	@Override
	public Table perform(LobbyContext lobbyContext) {
		return lobbyContext.createTable(name, configuration);
	}

}
