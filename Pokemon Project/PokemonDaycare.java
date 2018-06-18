package Pokemon;

import Resources.Constants.TYPE;
import type.AbstractType;
import type.FireType;
import type.GrassType;
import type.NormalType;
import type.WaterType;

/**
 * Creates Pokemon instances
 * @author Jacob Knight
 */
public class PokemonDaycare
{
	/**
	 * Creates factories that make moves and adjusts stats based on leveling
	 */
	static GrassMoveFactory grassMoves = new GrassMoveFactory();
	static FireMoveFactory fireMoves = new FireMoveFactory();
	static WaterMoveFactory waterMoves = new WaterMoveFactory();
	static StatFactory statFactory = new StatFactory();
	
	
	/**
	 * Creates Pokemon, adjusts their stats based on leveling,
	 * and gives the Pokemon moves based on their attack strength
	 * @param name, level, hp, atk, def, speed, type
	 * @return Pokemon
	 */
	
	public static Pokemon createPokemon(String name, int level, int hp, int atk, int def, int speed, AbstractType type)
	{
		Pokemon pokemon = new Pokemon(name, hp, atk, def, speed, type);
		/**
		 * Determines which moves the Pokemon should get based on
		 * what type it is and how much attack power it has
		 */
		if (AbstractType.isStab(type.getType(), TYPE.GRASS)==2)
			if (atk < 55)
				grassMoves.strongMoves(pokemon);
			else if (atk < 65)
				grassMoves.mediumMoves(pokemon);
			else
				grassMoves.weakMoves(pokemon);
		else if (AbstractType.isStab(type.getType(), TYPE.FIRE)==2)
			if (atk < 55)
				fireMoves.strongMoves(pokemon);
			else if (atk < 65)
				fireMoves.mediumMoves(pokemon);
			else
				fireMoves.weakMoves(pokemon);
		else
			if (atk < 55)
				waterMoves.strongMoves(pokemon);
			else if (atk < 65)
				waterMoves.mediumMoves(pokemon);
			else
				waterMoves.weakMoves(pokemon);
		
		/**
		 * Recalculates the stats of the Pokemon
		 * based on leveling
		 */
		statFactory.buildStats(pokemon, level);
		
		return pokemon;	
	}
	
	/** Calls createPokemon to make a Bulbasaur
	 * @return bulbasaur
	 */
	public static Pokemon Bulbasaur(int level)
	{
		return createPokemon("Bulbasaur", level, 45, 49, 49, 45, new GrassType());
	}
	
	/**
	 * Calls createPokemon to make an Ivysaur
	 * @return ivysaur
	 */
	public static Pokemon Ivysaur(int level)
	{
		return createPokemon("Ivysaur", level, 60, 62, 63, 60, new GrassType());
	}
	
	/**
	 * Calls createPokemon to make a Venusaur
	 * @return venusaur
	 */
	public static Pokemon Venusaur(int level)
	{
		return createPokemon("Venusaur", level, 80, 92, 83, 80, new GrassType());
	}
	
	/**
	 * Calls createPokemon to make a Charmander
	 * @return charmander
	 */
	public static Pokemon Charmander(int level)
	{
		return createPokemon("Charmander", level, 39, 52, 43, 65, new FireType());
	}
	
	/**
	 * Calls createPokemon to make a Charmeleon
	 * @return charmeleon
	 */
	public static Pokemon Charmeleon(int level)
	{
		return createPokemon("Charmeleon", level, 58, 64, 58, 80, new FireType());
	}
	
	/**
	 * Calls createPokemon to make a Charizard
	 * @return charizard
	 */
	public static Pokemon Charizard(int level)
	{
		return createPokemon("Charizard", level, 78, 94, 78, 100, new FireType());
	}
	
	/**
	 * Calls createPokemon to make a Squirtle
	 * @return squirtle
	 */
	public static Pokemon Squirtle(int level)
	{
		return createPokemon("Squirtle", level, 44, 48, 65, 43, new WaterType());
	}
	
	/**
	 * Calls createPokemon to make a Wartortle
	 * @return wartortle
	 */
	public static Pokemon Wartortle(int level)
	{
		return createPokemon("Wartortle", level, 59, 63, 80, 58, new WaterType());
	}
	
	/**
	 * Calls createPokemon to make a Blastiose
	 * @return blastiose
	 */
	public static Pokemon Blastoise(int level)
	{
		return createPokemon("Blastoise", level, 79, 83, 90, 78, new WaterType());
	}
	
	/**
	 * Calls createPokemon to make a Exeggcute
	 * @return exeggcute
	 */
	public static Pokemon Exeggcute(int level)
	{
		return createPokemon("Exeggcute", level, 60, 40, 80, 40, new GrassType());
	}
	
	/**
	 * Calls createPokemon to make a Vulpix
	 * @return vulpix
	 */
	public static Pokemon Vulpix(int level)
	{		
		return createPokemon("Vulpix", level, 38, 41, 40, 65, new FireType());
	}
	
	/**
	 * Calls createPokemon to make a Staryu
	 * @return staryu
	 */
	public static Pokemon Staryu(int level)
	{
		return createPokemon("Staryu", level, 30, 45, 55, 85, new WaterType());
	}
	
	/**
	 * Calls createPokemon to make a Missingno
	 * @return Missingno
	 */
	public static Pokemon Missingno(int level)
	{
		return createPokemon("Missingno", 150, 33, 136, 11, 29, new NormalType());
	}
}
