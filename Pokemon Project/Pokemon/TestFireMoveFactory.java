package Pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests functionality for FireMoveFactory
 * @author Jacob Knight
 */
public class TestFireMoveFactory 
{

	/**
	 * Tests that a Pokemon gets the strong moveset
	 */
	@Test
	public void testStrongMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the strong moveset
		 * PokemonDaycare makes an instance of FireMoveFactory
		 */
		Pokemon charmander = PokemonDaycare.Charmander(50);
		
		assertEquals("Inferno", charmander.getMove1().getName());
		assertEquals("Fire Fang", charmander.getMove2().getName());
		assertEquals("Body Slam", charmander.getMove3().getName());
		assertEquals("Tackle", charmander.getMove4().getName());	
	}
	
	/**
	 * Tests that a Pokemon gets the medium moveset
	 */
	@Test
	public void testMediumMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the medium moveset
		 * PokemonDaycare makes an instance of FireMoveFactory
		 */
		Pokemon charmeleon = PokemonDaycare.Charmeleon(50);
		
		assertEquals("Flame Burst", charmeleon.getMove1().getName());
		assertEquals("Fire Fang", charmeleon.getMove2().getName());
		assertEquals("Tackle", charmeleon.getMove3().getName());
		assertEquals("Quick Attack", charmeleon.getMove4().getName());
	}
	
	/**
	 * Tests that a Pokemon gets the weak moveset
	 */
	@Test
	public void testWeakMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the weak moveset
		 * PokemonDaycare makes an instance of FireMoveFactory
		 */
		Pokemon charizard = PokemonDaycare.Charizard(50);
		
		assertEquals("Ember", charizard.getMove1().getName());
		assertEquals("Flame Burst", charizard.getMove2().getName());
		assertEquals("Tackle", charizard.getMove3().getName());
		assertEquals("Scratch", charizard.getMove4().getName());	
	}
}
