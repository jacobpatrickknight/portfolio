package Battlefield;

import AI.AI;
import GUI.GUI;
import Pokemon.Pokemon;
import commands.Command;
import observer.Trainer;

/**
 * Creates the Battlefield which keeps track of the currently
 * selected pokemon as well as the trainers
 * @author Jacob Knight
 */
public class Battlefield 
{
	private static Battlefield battlefield;
	private Trainer human;
	private static AI computer;
	private Pokemon humanPokemon;
	private Pokemon computerPokemon;
	
	private String ai_action = "";
	private String player_action = "";
	
	private boolean playerFirst;
	
	/**
	 * Constructor for Battlefield
	 */
	private Battlefield()
	{	
		human = new Trainer();
		computer = AI.getAI();
		
		/**
		 * Forces user to select a difficulty before continuing
		 */
	}
	
	/**
	 * Creates a single instance of Battlefield if one is
	 * not already created and returns it
	 * @return battlefield
	 */
	public static Battlefield getBattlefield()
	{
		if (battlefield == null)
		{
			synchronized (Battlefield.class)
			{
				if (battlefield == null)
				{
					battlefield = new Battlefield();
					return battlefield;
				}
			}
		}
		return battlefield;
	}
	
	/**
	 * Deletes the current instance of Battlefield
	 * @return true or false based on if battlefield == null
	 */
	public Boolean deleteBattlefield()
	{
		battlefield = null;
		if (battlefield == null)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the Human Player
	 * @return human
	 */
	public Trainer getHuman()
	{
		return human;
	}
	
	/**
	 * Returns the Computer Player
	 * @return computer
	 */
	public static AI getComputer()
	{
		return computer;
	}
	
	/**
	 * Sets the active Pokemon for the Human Player
	 * @param pokemon
	 */
	public void setHumanPokemon(Pokemon pokemon)
	{
		humanPokemon = pokemon;
	}
	
	/**
	 * Sets the active Pokemon for the Computer Player
	 * @param pokemon
	 */
	public void setComputerPokemon(Pokemon pokemon)
	{
		computerPokemon = pokemon;
	}
	
	/**
	 * Returns the opponent Pokemon of the active player
	 * @param pokemon
	 * @return humanPokemon or computerPokemon
	 */
	public Pokemon getOpponent(Pokemon pokemon)
	{
		if(pokemon.equals(humanPokemon))
			return computerPokemon;
		else
			return humanPokemon;
	}
	
	/**
	 * Gets the active Pokemon of the Human Player
	 * @return humanPokemon
	 */
	public Pokemon getHumanPokemon()
	{
		return humanPokemon;
	}
	
	/**
	 * Gets the active Pokemon of the Computer Player
	 * @return computerPokemon;
	 */
	public Pokemon getComputerPokemon()
	{
		return computerPokemon;
	}
	
	public boolean order()
	{
		return playerFirst;
	}
	
	/**
	 * @return player_action
	 */
	public String getPlayerAction()
	{
		return player_action;
	}
	
	/**
	 * @return ai_action
	 */
	public String getAIAction()
	{
		return ai_action;
	}
}
