package items;

import Pokemon.Pokemon;

/**
 * Buffs a Pokemon's water moves
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class WaterStone extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public WaterStone(Item i) 
	{
		super(i);
		description = item.getDescription() + ", Water Stone";
	}

	/**
	 * Buffs the pokemon's water moves by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon) 
	{
		for (int i = 0; i < 4; i++)
		{
			if (pokemon.getMove(i).getType() == "water")
				pokemon.getMove(i).setBaseDam((int)(pokemon.getMove(i).getBaseDam() * 1.5));		
		}
	}
}
