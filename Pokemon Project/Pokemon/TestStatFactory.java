package Pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests functionality for StatFactory
 * @author Jacob Knight
 */
public class TestStatFactory 
{
	
	/**
	 * Tests that the StatFactory correctly builds stats
	 */
	@Test
	public void testBuildStats() 
	{
		/**
		 * Creates a Pokemon with PokemonDaycare which calls StatFactory
		 */
		Pokemon charmander = PokemonDaycare.Charmander(50);
		
		/**
		 * Tests that the Pokemon is given the correct stats
		 * based on it's level
		 */
		assertEquals(99, charmander.getMaxHitPoints());
		assertEquals(99, charmander.getCurrentHitPoints());
		assertEquals(57, charmander.getAttack());
		assertEquals(48, charmander.getDefense());
		assertEquals(70, charmander.getSpeed());
		assertEquals(50, charmander.getLevel());
	}
}
