package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.Item;
import items.Scarf;
import items.SpeedGem;

/**
 * Tests functionality of Speed Gem
 * @author Jacob Knight
 */
public class TestSpeedGem 
{
	/**
	 * Tests that an Speed Gem can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item speedScarf = new SpeedGem(scarf);
		
		assertEquals("Scarf, Speed Gem", speedScarf.getDescription());
	}
	
	/**
	 * Tests that an Speed Gem can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item speedScarf = new SpeedGem(scarf);
		vulpix.setHeldItem(speedScarf);
		
		/**
		 * Tests that the decorator was added and increased the selected stat
		 */
		assertEquals("Scarf, Speed Gem", vulpix.getHeldItem().getDescription());
		
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(46, vulpix.getAttack());
		assertEquals(45, vulpix.getDefense());
		assertEquals(105, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
	}
}
