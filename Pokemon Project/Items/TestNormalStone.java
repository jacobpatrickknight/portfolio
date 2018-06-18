package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.Item;
import items.NormalStone;
import items.Scarf;

/**
 * Tests functionality of Normal Stone
 * @author Jacob Knight
 */
public class TestNormalStone 
{
	/**
	 * Tests that a Normal Stone can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item normalScarf = new NormalStone(scarf);
		
		assertEquals("Scarf, Normal Stone", normalScarf.getDescription());
	}
	
	/**
	 * Tests that an Normal Stone can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item normalScarf = new NormalStone(scarf);
		
		assertEquals(100, vulpix.getMove1().getBaseDam());
		assertEquals(65, vulpix.getMove2().getBaseDam());
		assertEquals(85, vulpix.getMove3().getBaseDam());
		assertEquals(50, vulpix.getMove4().getBaseDam());
		
		/**
		 * Tests that the decorator was added and buffed the correct moves
		 * (Only the last two moves should be buffed)
		 */
		vulpix.setHeldItem(normalScarf);
		
		assertEquals("Scarf, Normal Stone", vulpix.getHeldItem().getDescription());
		
		assertEquals(100, vulpix.getMove1().getBaseDam());
		assertEquals(65, vulpix.getMove2().getBaseDam());
		assertEquals(127, vulpix.getMove3().getBaseDam());
		assertEquals(75, vulpix.getMove4().getBaseDam());
	}
}
