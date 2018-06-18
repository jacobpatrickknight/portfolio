package items;

import Pokemon.Pokemon;

/**
 * Buffs a Pokemon's fire moves
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class FireStone extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public FireStone(Item i) 
	{
		super(i);
		description = item.getDescription() + ", Fire Stone";
	}

	/**
	 * Buffs the pokemon's fire moves by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon) 
	{
		for (int i = 0; i < 4; i++)
		{
			if (pokemon.getMove(i).getType() == "fire")
				pokemon.getMove(i).setBaseDam((int)(pokemon.getMove(i).getBaseDam() * 1.5));		
		}
	}
}
