package Pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import Battlefield.Battlefield;
import Resources.Constants.TYPE;
import attacks.Attack;
import attacks.createAttack;
import type.WaterType;

/**
 * Tests functionality of the Pokemon class
 * @author Jacob Knight
 */
public class TestPokemon 
{
	
	/**
	 * Tests that a Pokemon can be created correctly
	 */
	@Test
	public void testPokemonInitialization() 
	{
		Pokemon missingno = new Pokemon ("Missingno", 20, 25, 30, 35, new WaterType());
		
		/**
		 * Tests stat getter methods and that the Pokemon was
		 * created correctly in the constructor
		 */
		assertEquals("Missingno", missingno.getName());
		assertEquals(20, missingno.getMaxHitPoints());
		assertEquals(20, missingno.getCurrentHitPoints());
		assertEquals(25, missingno.getAttack());
		assertEquals(30, missingno.getDefense());
		assertEquals(35, missingno.getSpeed());
		assertEquals(TYPE.WATER, missingno.getType());
		assertEquals(0, missingno.getLevel());
	}
	
	@Test
	public void testPokemonStatSetters()
	{
		Pokemon missingno = new Pokemon ("Missingno", 0, 0, 0, 0, new WaterType());
		
		missingno.setMaxHitPoints(20);
		missingno.setCurrentHitPoints(20);
		missingno.setAttack(25);
		missingno.setDefense(30);
		missingno.setSpeed(35);
		missingno.setLevel(50);
		
		/**
		 * Test that the stat setter methods correctly reassign stats
		 */
		assertEquals(20, missingno.getMaxHitPoints());
		assertEquals(20, missingno.getCurrentHitPoints());
		assertEquals(25, missingno.getAttack());
		assertEquals(30, missingno.getDefense());
		assertEquals(35, missingno.getSpeed());
		assertEquals(50, missingno.getLevel());
		
		/**
		 * Tests that currentHitPoints will be reduced to
		 * maxHitPoints value when setMaxHitPoints is called
		 */
		missingno.setMaxHitPoints(19);
		assertEquals(19, missingno.getMaxHitPoints());
		assertEquals(19, missingno.getCurrentHitPoints());
		
		/**
		 * Tests that negative numbers cannot be assigned to 
		 * currentHitPoints or maxHitPoints
		 */
		missingno.setCurrentHitPoints(-1);
		missingno.setMaxHitPoints(-1);
		assertEquals(0, missingno.getMaxHitPoints());
		assertEquals(0, missingno.getCurrentHitPoints());
	}
	
	/**
	 * Tests that the Pokemon's moves will be set and returned correctly
	 */
	@Test
	public void testPokemonMoves()
	{
		Pokemon missingno = new Pokemon ("Missingno", 0, 0, 0, 0, new WaterType());
		
		/**
		 * Tests Pokemon's move setters and getters
		 */
		missingno.setMove1(createAttack.HydroPump(missingno));
		missingno.setMove2(createAttack.Scald(missingno));
		missingno.setMove3(createAttack.BodySlam(missingno));
		missingno.setMove4(createAttack.Tackle(missingno));
		
		assertEquals("Hydro Pump", missingno.getMove1().getName());
		assertEquals("Scald", missingno.getMove2().getName());
		assertEquals("Body Slam", missingno.getMove3().getName());
		assertEquals("Tackle", missingno.getMove4().getName());
		
		assertEquals("Scald", missingno.getMove(1).getName());
		
		Attack[] moveset = missingno.getMoves();
		assertEquals("Hydro Pump", moveset[0].getName());
		assertEquals("Scald", moveset[1].getName());
		assertEquals("Body Slam", moveset[2].getName());
		assertEquals("Tackle", moveset[3].getName());
		
		/**
		 * Tests that if an invalid move slot is asked for an
		 * error message is printed and the Pokemon's first
		 * move is returned instead
		 */
		assertEquals("Hydro Pump", missingno.getMove(-1).getName());
		assertEquals("Hydro Pump", missingno.getMove(5).getName());
	}
	
	/**
	 * Tests that the Pokemon's moves will be used correctly
	 */
	@Test
	public void testPokemonUseMove()
	{
		Battlefield b = Battlefield.getBattlefield();
		Pokemon bulbasaur = PokemonDaycare.Bulbasaur(50);
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Pokemon missingno = new Pokemon ("Missingno", 20, 25, 30, 35, new WaterType());
		b.setHumanPokemon(vulpix);
		b.setComputerPokemon(bulbasaur);
		
		/**
		 * Tests that useMove methods function and return the
		 * name of the attack used.
		 */
		assertEquals("Power Whip", bulbasaur.useMove1());
		assertEquals("Giga Drain", bulbasaur.useMove2());
		assertEquals("Body Slam", bulbasaur.useMove3());
		assertEquals("Tackle", bulbasaur.useMove4());
		
		assertEquals("Inferno", vulpix.useMove(0));
		assertEquals("Inferno", vulpix.useMove(-1));
		assertEquals("Inferno", vulpix.useMove(5));
		
		/**
		 * Boundary and error checking for useMove methods
		 */
		b.setHumanPokemon(missingno);
		assertEquals("Invalid move", missingno.useMove1());
		assertEquals("Invalid move", missingno.useMove2());
		assertEquals("Invalid move", missingno.useMove3());
		assertEquals("Invalid move", missingno.useMove4());
		
		assertEquals("Invalid move", missingno.useMove(0));
		assertEquals("Invalid move", missingno.useMove(-1));
		assertEquals("Invalid move", missingno.useMove(5));
	}
}