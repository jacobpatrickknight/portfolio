package Pokemon;

import attacks.createAttack;

/**
 * Adds moves to Grass Type Pokemon
 * @author Jacob Knight
 */
public class GrassMoveFactory implements MoveFactory
{
	/**
	 * Adds strong moves to a Grass Pokemon
	 */
	public void strongMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.PowerWhip(pokemon));
		pokemon.setMove2(createAttack.GigaDrain(pokemon));
		pokemon.setMove3(createAttack.BodySlam(pokemon));
		pokemon.setMove4(createAttack.Tackle(pokemon));
	}
	
	/**
	 * Adds medium-powered moves to a Grass Pokemon
	 */
	public void mediumMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.RazorLeaf(pokemon));
		pokemon.setMove2(createAttack.GigaDrain(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.QuickAttack(pokemon));
	}
	
	/**
	 * Adds weak moves to a Grass Pokemon
	 */
	public void weakMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.VineWhip(pokemon));
		pokemon.setMove2(createAttack.RazorLeaf(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.Scratch(pokemon));
	}
}
