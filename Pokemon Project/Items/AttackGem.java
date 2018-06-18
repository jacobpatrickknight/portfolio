package items;

import Pokemon.Pokemon;

/**
 * Increases a Pokemon's attack stat
 * when placed onto a Scarf
 * @author Jacob Knight
 */
public class AttackGem extends ItemDecorator
{
	/**
	 * Constructor, sets item and description
	 * @param i: Item
	 */
	public AttackGem(Item i)
	{
		super(i);
		description = item.getDescription() + ", Attack Gem";
	}
	
	/**
	 * Increases the pokemon's attack stat by 1.5
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon)
	{
		pokemon.setAttack((int)(pokemon.getAttack() * 1.5));
	}
}
