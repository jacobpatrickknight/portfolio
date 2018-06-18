package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.GrassStone;
import items.Item;
import items.Scarf;

/**
 * Tests functionality of Grass Stone
 * @author Jacob Knight
 */
public class TestGrassStone 
{
	/**
	 * Tests that a Grass Stone can be created and added to a Scarf
	 */
	@Test
	public void testInitialization() 
	{
		Scarf scarf = new Scarf();
		Item grassScarf = new GrassStone(scarf);
		
		assertEquals("Scarf, Grass Stone", grassScarf.getDescription());
	}
	
	/**
	 * Tests that an Grass Stone can be given to a Pokemon
	 */
	@Test
	public void testSetHeldItem()
	{
		Pokemon bulbasaur = PokemonDaycare.Bulbasaur(50);
		Scarf scarf = new Scarf();
		Item grassScarf = new GrassStone(scarf);
		
		assertEquals(120, bulbasaur.getMove1().getBaseDam());
		assertEquals(70, bulbasaur.getMove2().getBaseDam());
		assertEquals(85, bulbasaur.getMove3().getBaseDam());
		assertEquals(50, bulbasaur.getMove4().getBaseDam());
		
		/**
		 * Tests that the decorator was added and buffed the correct moves
		 * (Only the first two moves should be buffed)
		 */
		bulbasaur.setHeldItem(grassScarf);
		
		assertEquals("Scarf, Grass Stone", bulbasaur.getHeldItem().getDescription());
		
		assertEquals(180, bulbasaur.getMove1().getBaseDam());
		assertEquals(105, bulbasaur.getMove2().getBaseDam());
		assertEquals(85, bulbasaur.getMove3().getBaseDam());
		assertEquals(50, bulbasaur.getMove4().getBaseDam());
	}
}
