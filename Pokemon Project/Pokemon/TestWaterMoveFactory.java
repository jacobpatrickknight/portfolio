package Pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests functionality for WaterMoveFactory
 * @author Jacob Knight
 */
public class TestWaterMoveFactory 
{
	/**
	 * Tests that a Pokemon gets the strong moveset
	 */
	@Test
	public void testStrongMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the strong moveset
		 * PokemonDaycare makes an instance of WaterMoveFactory
		 */
		Pokemon squirtle = PokemonDaycare.Squirtle(50);
		
		assertEquals("Hydro Pump", squirtle.getMove1().getName());
		assertEquals("Scald", squirtle.getMove2().getName());
		assertEquals("Body Slam", squirtle.getMove3().getName());
		assertEquals("Tackle", squirtle.getMove4().getName());	
	}
	
	/**
	 * Tests that a Pokemon gets the medium moveset
	 */
	@Test
	public void testMediumMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the medium moveset
		 * PokemonDaycare makes an instance of WaterMoveFactory
		 */
		Pokemon wartortle = PokemonDaycare.Wartortle(50);
		
		assertEquals("Water Pulse", wartortle.getMove1().getName());
		assertEquals("Scald", wartortle.getMove2().getName());
		assertEquals("Tackle", wartortle.getMove3().getName());
		assertEquals("Quick Attack", wartortle.getMove4().getName());
	}
	
	/**
	 * Tests that a Pokemon gets the weak moveset
	 */
	@Test
	public void testWeakMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the weak moveset
		 * PokemonDaycare makes an instance of WaterMoveFactory
		 */
		Pokemon blastoise = PokemonDaycare.Blastoise(50);
		
		assertEquals("Water Gun", blastoise.getMove1().getName());
		assertEquals("Water Pulse", blastoise.getMove2().getName());
		assertEquals("Tackle", blastoise.getMove3().getName());
		assertEquals("Scratch", blastoise.getMove4().getName());	
	}
}
