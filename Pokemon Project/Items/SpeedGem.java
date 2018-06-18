package items;

import Pokemon.Pokemon;

/**
 * Increases a Pokemon's speed stat
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class SpeedGem extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public SpeedGem(Item i)
	{
		super(i);
		description = item.getDescription() + ", Speed Gem";
	}
	
	/**
	 * Increases the pokemon's speed stat by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon)
	{
		pokemon.setSpeed((int)(pokemon.getSpeed() * 1.5));
	}
}
