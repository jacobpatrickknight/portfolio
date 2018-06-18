package items;

import Pokemon.Pokemon;

/**
 * Increases a Pokemon's defense stat
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class DefenseGem extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public DefenseGem(Item i)
	{
		super(i);
		description = item.getDescription() + ", Defense Gem";
	}
	
	/**
	 * Increases the pokemon's defense stat by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon)
	{
		pokemon.setDefense((int)(pokemon.getDefense() * 1.5));
	}
}
