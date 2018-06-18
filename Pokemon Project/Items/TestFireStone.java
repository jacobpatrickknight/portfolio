package testItems;

/**
 * Tests functionality of Fire Stone
 * @author Jacob Knight
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.FireStone;
import items.Item;
import items.Scarf;

public class TestFireStone 
{
	/**
	 * Tests that a Fire Stone can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item fireScarf = new FireStone(scarf);
		
		assertEquals("Scarf, Fire Stone", fireScarf.getDescription());
	}
	
	/**
	 * Tests that an Fire Stone can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item fireScarf = new FireStone(scarf);
		
		assertEquals(100, vulpix.getMove1().getBaseDam());
		assertEquals(65, vulpix.getMove2().getBaseDam());
		assertEquals(85, vulpix.getMove3().getBaseDam());
		assertEquals(50, vulpix.getMove4().getBaseDam());
		
		/**
		 * Tests that the decorator was added and buffed the correct moves
		 * (Only the first two moves should be buffed)
		 */
		vulpix.setHeldItem(fireScarf);
		
		assertEquals("Scarf, Fire Stone", vulpix.getHeldItem().getDescription());
		
		assertEquals(150, vulpix.getMove1().getBaseDam());
		assertEquals(97, vulpix.getMove2().getBaseDam());
		assertEquals(85, vulpix.getMove3().getBaseDam());
		assertEquals(50, vulpix.getMove4().getBaseDam());
	}
}
