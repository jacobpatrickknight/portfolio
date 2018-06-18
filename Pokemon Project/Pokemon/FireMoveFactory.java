package Pokemon;

import attacks.createAttack;

/**
 * Adds moves to Fire Type Pokemon
 * @author Jacob Knight
 */
public class FireMoveFactory implements MoveFactory
{
	/**
	 * Adds strong moves to a Fire Pokemon
	 */
	public void strongMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.Inferno(pokemon));
		pokemon.setMove2(createAttack.FireFang(pokemon));
		pokemon.setMove3(createAttack.BodySlam(pokemon));
		pokemon.setMove4(createAttack.Tackle(pokemon));
	}
	
	/**
	 * Adds medium-powered moves to a Fire Pokemon
	 */
	public void mediumMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.FlameBurst(pokemon));
		pokemon.setMove2(createAttack.FireFang(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.QuickAttack(pokemon));
	}
	
	/**
	 * Adds weak moves to a Fire Pokemon
	 */
	public void weakMoves(Pokemon pokemon)
	{
		pokemon.setMove1(createAttack.Ember(pokemon));
		pokemon.setMove2(createAttack.FlameBurst(pokemon));
		pokemon.setMove3(createAttack.Tackle(pokemon));
		pokemon.setMove4(createAttack.Scratch(pokemon));
	}
}
