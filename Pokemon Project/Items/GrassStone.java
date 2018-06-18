package items;

import Pokemon.Pokemon;

/**
 * Buffs a Pokemon's grass moves
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class GrassStone extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public GrassStone(Item i) 
	{
		super(i);
		description = item.getDescription() + ", Grass Stone";
	}

	/**
	 * Buffs the pokemon's grass moves by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon) 
	{
		for (int i = 0; i < 4; i++)
		{
			if (pokemon.getMove(i).getType() == "grass")
				pokemon.getMove(i).setBaseDam((int)(pokemon.getMove(i).getBaseDam() * 1.5));		
		}
	}
}
