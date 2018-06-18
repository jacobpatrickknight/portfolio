package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.DefenseGem;
import items.Item;
import items.Scarf;

/**
 * Tests functionality of Defense Gem
 * @author Jacob Knight
 */
public class TestDefenseGem 
{
	/**
	 * Tests that an Defense Gem can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item defenseScarf = new DefenseGem(scarf);
		
		assertEquals("Scarf, Defense Gem", defenseScarf.getDescription());
	}
	
	/**
	 * Tests that an Defense Gem can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item defenseScarf = new DefenseGem(scarf);
		vulpix.setHeldItem(defenseScarf);
		
		/**
		 * Tests that the decorator was added and increased the selected stat
		 */
		assertEquals("Scarf, Defense Gem", vulpix.getHeldItem().getDescription());
		
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(46, vulpix.getAttack());
		assertEquals(67, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
	}
}
