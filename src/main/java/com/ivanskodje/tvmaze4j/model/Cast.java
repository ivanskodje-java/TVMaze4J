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

/**
 * A cast member has the role of both an actor and character.
 *
 * @author Ivan Skodje on 27/09/2017
 */
public class Cast
{
	/**
	 * The Actor in a Show.
	 */
	private Person actor = null;

	/**
	 * The Character the actor portrays.
	 */
	private Person character = null;

	/**
	 * Returns the Actor,
	 * or null if none have been set.
	 *
	 * @return The Actor.
	 */
	public Person getActor()
	{
		return actor;
	}

	/**
	 * Sets the Actor,
	 * if it is not null.
	 *
	 * @param actor The Actor.
	 */
	public void setActor(Person actor)
	{
		if (actor != null)
		{
			this.actor = actor;
		}
	}

	/**
	 * Returns the Character the actor portrays,
	 * or null if none have been set.
	 *
	 * @return The Character.
	 */
	public Person getCharacter()
	{
		return character;
	}

	/**
	 * Sets the Character the actor prortrays,
	 * if it is not null.
	 *
	 * @param character The Character.
	 */
	public void setCharacter(Person character)
	{
		this.character = character;
	}

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
