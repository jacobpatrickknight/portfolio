package testItems;

/**
 * Tests functionality of Water Stone
 * @author Jacob Knight
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.Item;
import items.Scarf;
import items.WaterStone;

public class TestWaterStone 
{
	/**
	 * Tests that a Water Stone can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item waterScarf = new WaterStone(scarf);
		
		assertEquals("Scarf, Water Stone", waterScarf.getDescription());
	}
	
	/**
	 * Tests that an Water Stone can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon squirtle = PokemonDaycare.Squirtle(50);
		Scarf scarf = new Scarf();
		Item waterScarf = new WaterStone(scarf);
		
		assertEquals(110, squirtle.getMove1().getBaseDam());
		assertEquals(80, squirtle.getMove2().getBaseDam());
		assertEquals(85, squirtle.getMove3().getBaseDam());
		assertEquals(50, squirtle.getMove4().getBaseDam());
		
		/**
		 * Tests that the decorator was added and buffed the correct moves
		 * (Only the first two moves should be buffed)
		 */
		squirtle.setHeldItem(waterScarf);
		
		assertEquals("Scarf, Water Stone", squirtle.getHeldItem().getDescription());
		
		assertEquals(165, squirtle.getMove1().getBaseDam());
		assertEquals(120, squirtle.getMove2().getBaseDam());
		assertEquals(85, squirtle.getMove3().getBaseDam());
		assertEquals(50, squirtle.getMove4().getBaseDam());
	}
}
