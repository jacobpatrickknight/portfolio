package items;

import Pokemon.Pokemon;

/**
 * Buffs a Pokemon's normal moves
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class NormalStone extends ItemDecorator
{

	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public NormalStone(Item i) 
	{
		super(i);
		description = item.getDescription() + ", Normal Stone";
	}

	/**
	 * Buffs the pokemon's normal moves by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon) 
	{
		for (int i = 0; i < 4; i++)
		{
			if (pokemon.getMove(i).getType() == "normal")
				pokemon.getMove(i).setBaseDam((int)(pokemon.getMove(i).getBaseDam() * 1.5));		
		}
	}
}
