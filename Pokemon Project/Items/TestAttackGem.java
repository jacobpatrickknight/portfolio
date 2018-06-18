package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.AttackGem;
import items.Item;
import items.Scarf;

/**
 * Tests functionality of Attack Gem
 * @author Jacob Knight
 */
public class TestAttackGem 
{
	/**
	 * Tests that an Attack Gem can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item attackScarf = new AttackGem(scarf);
		
		assertEquals("Scarf, Attack Gem", attackScarf.getDescription());
	}
	
	/**
	 * Tests that an Attack Gem can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item attackScarf = new AttackGem(scarf);
		vulpix.setHeldItem(attackScarf);
		
		/**
		 * Tests that the decorator was added and increased the selected stat
		 */
		assertEquals("Scarf, Attack Gem", vulpix.getHeldItem().getDescription());
		
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(45, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
	}
}
