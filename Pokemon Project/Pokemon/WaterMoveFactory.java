package Pokemon;

import attacks.createAttack;

/**
 * Adds moves to Water Type Pokemon
 * @author Jacob Knight
 */
public class WaterMoveFactory implements MoveFactory
{
	/**
	 * Adds strong moves to a Water Pokemon
	 */
	public void strongMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.HydroPump(pokemon));
		pokemon.setMove2(createAttack.Scald(pokemon));
		pokemon.setMove3(createAttack.BodySlam(pokemon));
		pokemon.setMove4(createAttack.Tackle(pokemon));
	}
	
	/**
	 * Adds medium-powered moves to a Water Pokemon
	 */
	public void mediumMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.WaterPulse(pokemon));
		pokemon.setMove2(createAttack.Scald(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.QuickAttack(pokemon));
	}
	
	/**
	 * Adds weak moves to a Water Pokemon
	 */
	public void weakMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.WaterGun(pokemon));
		pokemon.setMove2(createAttack.WaterPulse(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.Scratch(pokemon));
	}
}
