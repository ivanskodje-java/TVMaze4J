/*************************************************************************
 * This file (Cast.java) is part of TVMaze4J.                            *
 *                                                                       *
 * Copyright (c) 2017 Ivan Skodje.                                       *
 *                                                                       *
 * TVMaze4J is free software: you can redistribute it and/or modify      *
 * it under the terms of the GNU General Public License as published by  *
 * the Free Software Foundation, either version 3 of the License, or     *
 * (at your option) any later version.                                   *
 *                                                                       *
 * TVMaze4J is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 * GNU General Public License for more details.                          *
 *                                                                       *
 * You should have received a copy of the GNU General Public License     *
 * along with TVMaze4J.  If not, see <http://www.gnu.org/licenses/>.     *
 *************************************************************************/

package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

/**
 * A cast member has the role of both an actor and character.
 *
 * @author Ivan Skodje on 27/09/2017
 */
public @Data class Cast
{
	/**
	 * The Actor in a Show.
	 */
	private Person actor;

	/**
	 * The Character the actor portrays.
	 */
	private Person character;

	/**
	 * To string will be formatted as
	 * "'[actor name]' portraying the role as '[character name]'".
	 *
	 * @return A description of the cast member.
	 */
	@Override
	public String toString()
	{
		return "'" + actor.getName() + "' portraying the role as '" + character.getName() + "'";
	}
}
