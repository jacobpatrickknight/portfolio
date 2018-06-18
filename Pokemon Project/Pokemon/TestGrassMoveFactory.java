package Pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests functionality for GrassMoveFactory
 * @author Jacob Knight
 */
public class TestGrassMoveFactory 
{
	/**
	 * Tests that a Pokemon gets the strong moveset
	 */
	@Test
	public void testStrongMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the strong moveset
		 * PokemonDaycare makes an instance of GrassMoveFactory
		 */
		Pokemon bulbasaur = PokemonDaycare.Bulbasaur(50);
		
		assertEquals("Power Whip", bulbasaur.getMove1().getName());
		assertEquals("Giga Drain", bulbasaur.getMove2().getName());
		assertEquals("Body Slam", bulbasaur.getMove3().getName());
		assertEquals("Tackle", bulbasaur.getMove4().getName());	
	}
	
	/**
	 * Tests that a Pokemon gets the medium moveset
	 */
	@Test
	public void testMediumMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the medium moveset
		 * PokemonDaycare makes an instance of GrassMoveFactory
		 */
		Pokemon ivysaur = PokemonDaycare.Ivysaur(50);
		
		assertEquals("Razor Leaf", ivysaur.getMove1().getName());
		assertEquals("Giga Drain", ivysaur.getMove2().getName());
		assertEquals("Tackle", ivysaur.getMove3().getName());
		assertEquals("Quick Attack", ivysaur.getMove4().getName());
	}
	
	/**
	 * Tests that a Pokemon gets the weak moveset
	 */
	@Test
	public void testWeakMoves() 
	{
		/**
		 * Creates a Pokemon that always gets the weak moveset
		 * PokemonDaycare makes an instance of GrassMoveFactory
		 */
		Pokemon venusaur = PokemonDaycare.Venusaur(50);
		
		assertEquals("Vine Whip", venusaur.getMove1().getName());
		assertEquals("Razor Leaf", venusaur.getMove2().getName());
		assertEquals("Tackle", venusaur.getMove3().getName());
		assertEquals("Scratch", venusaur.getMove4().getName());	
	}
}
