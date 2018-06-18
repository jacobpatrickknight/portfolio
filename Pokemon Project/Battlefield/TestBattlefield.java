package Battlefield;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;

/**
 * Tests the functionality of the Battlefield
 * @author Jacob Knight
 */
public class TestBattlefield 
{
	
	/**
	 * Tests that a Battlefield can be created and deleted
	 */
	@Test
	public void testBattlefieldInitialization() 
	{
		Battlefield b = Battlefield.getBattlefield();
		
		assertTrue(b.getHuman() != null);
		assertTrue(b.getComputer() != null);
		
		assertTrue(b.deleteBattlefield());
	}
	
	/**
	 * Tests that the Pokemon currently on the battlefield can be accessed
	 */
	@Test
	public void testActivePokemon()
	{
		Battlefield b = Battlefield.getBattlefield();
		
		Pokemon bulbasaur = PokemonDaycare.Bulbasaur(50);
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		b.setHumanPokemon(bulbasaur);
		b.setComputerPokemon(vulpix);
		
		/**
		 * Tests that a Pokemon can be returned from the battlefield
		 */
		assertEquals(bulbasaur, b.getHumanPokemon());
		assertEquals(vulpix, b.getComputerPokemon());
		
		/**
		 * Tests that a Pokemon can find it's opponent
		 */
		assertEquals(vulpix, b.getOpponent(bulbasaur));
		assertEquals(bulbasaur, b.getOpponent(vulpix));
		
		
		assertTrue(b.deleteBattlefield());
	}

}
