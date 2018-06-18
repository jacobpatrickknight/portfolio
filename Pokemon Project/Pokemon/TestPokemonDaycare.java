package Pokemon;

import static org.junit.Assert.*;
import org.junit.Test;
import type.WaterType;

/**
 * Tests functionality of the Pokemon class
 * @author Jacob Knight
 */
public class TestPokemonDaycare 
{

	/**
	 * Tests that CreatePokemon correctly instantiates
	 * a Pokemon and gives it the correct attributes
	 */
	@Test
	public void testCreatePokemon() 
	{
		Pokemon missingbro = PokemonDaycare.createPokemon("Missingbro", 20, 25, 30, 35, 40, new WaterType());
		
		/**
		 * Tests that the Pokemon is given the correct leveled stats
		 */
		assertEquals("Missingbro", missingbro.getName());
		assertEquals(40, missingbro.getMaxHitPoints());
		assertEquals(40, missingbro.getCurrentHitPoints());
		assertEquals(17, missingbro.getAttack());
		assertEquals(19, missingbro.getDefense());
		assertEquals(21, missingbro.getSpeed());
		assertEquals(20, missingbro.getLevel());
		
		/**
		 * Tests that the Pokemon is given the correct moves based
		 * on its base attack power
		 * Missingno base attack < 55, strong moves
		 */
		assertEquals("Hydro Pump", missingbro.getMove1().getName());
		assertEquals("Scald", missingbro.getMove2().getName());
		assertEquals("Body Slam", missingbro.getMove3().getName());
		assertEquals("Tackle", missingbro.getMove4().getName());
	}
	
	/**
	 * Tests that Bulbasaur correctly makes an instance
	 * of a Bulbasaur Pokemon
	 */
	@Test
	public void testBulbasaur() 
	{
		Pokemon bulbasaur = PokemonDaycare.Bulbasaur(50);
		
		/**
		 * Tests that bulbasaur is given the correct leveled stats
		 */
		assertEquals(105, bulbasaur.getMaxHitPoints());
		assertEquals(105, bulbasaur.getCurrentHitPoints());
		assertEquals(54, bulbasaur.getAttack());
		assertEquals(54, bulbasaur.getDefense());
		assertEquals(50, bulbasaur.getSpeed());
		assertEquals(50, bulbasaur.getLevel());
		
		/**
		 * Tests that bulbasaur gets strong grass moves
		 */
		assertEquals("Power Whip", bulbasaur.getMove1().getName());
		assertEquals("Giga Drain", bulbasaur.getMove2().getName());
		assertEquals("Body Slam", bulbasaur.getMove3().getName());
		assertEquals("Tackle", bulbasaur.getMove4().getName());
	}
	
	/**
	 * Tests that Ivysaur correctly makes an instance
	 * of a Ivysaur Pokemon
	 */
	@Test
	public void testIvysaur() 
	{
		Pokemon ivysaur = PokemonDaycare.Ivysaur(50);
		
		/**
		 * Tests that ivysaur is given the correct leveled stats
		 */
		assertEquals(120, ivysaur.getMaxHitPoints());
		assertEquals(120, ivysaur.getCurrentHitPoints());
		assertEquals(67, ivysaur.getAttack());
		assertEquals(68, ivysaur.getDefense());
		assertEquals(65, ivysaur.getSpeed());
		assertEquals(50, ivysaur.getLevel());
		
		/**
		 * Tests that ivysaur gets medium-powered grass moves
		 */
		assertEquals("Razor Leaf", ivysaur.getMove1().getName());
		assertEquals("Giga Drain", ivysaur.getMove2().getName());
		assertEquals("Tackle", ivysaur.getMove3().getName());
		assertEquals("Quick Attack", ivysaur.getMove4().getName());
	}
	
	/**
	 * Tests that Venusaur correctly makes an instance
	 * of a Venusaur Pokemon
	 */
	@Test
	public void testVenusaur() 
	{
		Pokemon venusaur = PokemonDaycare.Venusaur(50);
		
		/**
		 * Tests that venusaur is given the correct leveled stats
		 */
		assertEquals(140, venusaur.getMaxHitPoints());
		assertEquals(140, venusaur.getCurrentHitPoints());
		assertEquals(87, venusaur.getAttack());
		assertEquals(88, venusaur.getDefense());
		assertEquals(85, venusaur.getSpeed());
		assertEquals(50, venusaur.getLevel());
		
		/**
		 * Tests that venusaur gets weak grass moves
		 */
		assertEquals("Vine Whip", venusaur.getMove1().getName());
		assertEquals("Razor Leaf", venusaur.getMove2().getName());
		assertEquals("Tackle", venusaur.getMove3().getName());
		assertEquals("Scratch", venusaur.getMove4().getName());	
	}
	
	/**
	 * Tests that Charmander correctly makes an instance
	 * of a Charmander Pokemon
	 */
	@Test
	public void testCharmander() 
	{
		Pokemon charmander = PokemonDaycare.Charmander(50);
		
		/**
		 * Tests that charmander is given the correct leveled stats
		 */
		assertEquals(99, charmander.getMaxHitPoints());
		assertEquals(99, charmander.getCurrentHitPoints());
		assertEquals(57, charmander.getAttack());
		assertEquals(48, charmander.getDefense());
		assertEquals(70, charmander.getSpeed());
		assertEquals(50, charmander.getLevel());
		
		/**
		 * Tests that charmander gets strong fire moves
		 */
		assertEquals("Inferno", charmander.getMove1().getName());
		assertEquals("Fire Fang", charmander.getMove2().getName());
		assertEquals("Body Slam", charmander.getMove3().getName());
		assertEquals("Tackle", charmander.getMove4().getName());
	}
	
	/**
	 * Tests that Charmeleon correctly makes an instance
	 * of a Charmeleon Pokemon
	 */
	@Test
	public void testCharmeleon() 
	{

		Pokemon charmeleon = PokemonDaycare.Charmeleon(50);
		
		/**
		 * Tests that charmeleon is given the correct leveled stats
		 */
		assertEquals(118, charmeleon.getMaxHitPoints());
		assertEquals(118, charmeleon.getCurrentHitPoints());
		assertEquals(69, charmeleon.getAttack());
		assertEquals(63, charmeleon.getDefense());
		assertEquals(85, charmeleon.getSpeed());
		assertEquals(50, charmeleon.getLevel());
		
		/**
		 * Tests that charmeleon gets medium-powered fire moves
		 */
		assertEquals("Flame Burst", charmeleon.getMove1().getName());
		assertEquals("Fire Fang", charmeleon.getMove2().getName());
		assertEquals("Tackle", charmeleon.getMove3().getName());
		assertEquals("Quick Attack", charmeleon.getMove4().getName());
	}
	
	/**
	 * Tests that Charizard correctly makes an instance
	 * of a Charizard Pokemon
	 */
	@Test
	public void testCharizard() 
	{
		Pokemon charizard = PokemonDaycare.Charizard(50);
		
		/**
		 * Tests that charizard is given the correct leveled stats
		 */
		assertEquals(138, charizard.getMaxHitPoints());
		assertEquals(138, charizard.getCurrentHitPoints());
		assertEquals(89, charizard.getAttack());
		assertEquals(83, charizard.getDefense());
		assertEquals(105, charizard.getSpeed());
		assertEquals(50, charizard.getLevel());
		
		/**
		 * Tests that charizard gets weak fire moves
		 */
		assertEquals("Ember", charizard.getMove1().getName());
		assertEquals("Flame Burst", charizard.getMove2().getName());
		assertEquals("Tackle", charizard.getMove3().getName());
		assertEquals("Scratch", charizard.getMove4().getName());
	}
	
	/**
	 * Tests that Squirtle correctly makes an instance
	 * of a Squirtle Pokemon
	 */
	@Test
	public void testSquirtle() 
	{
		Pokemon squirtle = PokemonDaycare.Squirtle(50);
		
		/**
		 * Tests that squirtle is given the correct leveled stats
		 */
		assertEquals(104, squirtle.getMaxHitPoints());
		assertEquals(104, squirtle.getCurrentHitPoints());
		assertEquals(53, squirtle.getAttack());
		assertEquals(70, squirtle.getDefense());
		assertEquals(48, squirtle.getSpeed());
		assertEquals(50, squirtle.getLevel());
		
		/**
		 * Tests that squirtle gets strong water moves
		 */
		assertEquals("Hydro Pump", squirtle.getMove1().getName());
		assertEquals("Scald", squirtle.getMove2().getName());
		assertEquals("Body Slam", squirtle.getMove3().getName());
		assertEquals("Tackle", squirtle.getMove4().getName());
	}
	
	/**
	 * Tests that Wartortle correctly makes an instance
	 * of a Wartortle Pokemon
	 */
	@Test
	public void testWartortle() 
	{
		Pokemon wartortle = PokemonDaycare.Wartortle(50);
		
		/**
		 * Tests that wartortle is given the correct leveled stats
		 */
		assertEquals(119, wartortle.getMaxHitPoints());
		assertEquals(119, wartortle.getCurrentHitPoints());
		assertEquals(68, wartortle.getAttack());
		assertEquals(85, wartortle.getDefense());
		assertEquals(63, wartortle.getSpeed());
		assertEquals(50, wartortle.getLevel());
		
		/**
		 * Tests that wartortle gets medium-powered water moves
		 */
		assertEquals("Water Pulse", wartortle.getMove1().getName());
		assertEquals("Scald", wartortle.getMove2().getName());
		assertEquals("Tackle", wartortle.getMove3().getName());
		assertEquals("Quick Attack", wartortle.getMove4().getName());
	}
	
	/**
	 * Tests that Blastoise correctly makes an instance
	 * of a Blastoise Pokemon
	 */
	@Test
	public void testBlastoise() 
	{
		Pokemon blastoise = PokemonDaycare.Blastoise(50);
		
		/**
		 * Tests that blastoise is given the correct leveled stats
		 */
		assertEquals(139, blastoise.getMaxHitPoints());
		assertEquals(139, blastoise.getCurrentHitPoints());
		assertEquals(88, blastoise.getAttack());
		assertEquals(105, blastoise.getDefense());
		assertEquals(83, blastoise.getSpeed());
		assertEquals(50, blastoise.getLevel());
		
		/**
		 * Tests that blastoise gets weak water moves
		 */
		assertEquals("Water Gun", blastoise.getMove1().getName());
		assertEquals("Water Pulse", blastoise.getMove2().getName());
		assertEquals("Tackle", blastoise.getMove3().getName());
		assertEquals("Scratch", blastoise.getMove4().getName());
	}
	
	/**
	 * Tests that Exeggcute correctly makes an instance
	 * of an Exeggcute Pokemon
	 */
	@Test
	public void testCaterpie() 
	{
		Pokemon exeggcute = PokemonDaycare.Exeggcute(50);
		
		/**
		 * Tests that caterpie is given the correct leveled stats
		 */
		assertEquals(120, exeggcute.getMaxHitPoints());
		assertEquals(120, exeggcute.getCurrentHitPoints());
		assertEquals(45, exeggcute.getAttack());
		assertEquals(85, exeggcute.getDefense());
		assertEquals(45, exeggcute.getSpeed());
		assertEquals(50, exeggcute.getLevel());
		
		/**
		 * Tests that caterpie gets strong grass moves
		 */
		assertEquals("Power Whip", exeggcute.getMove1().getName());
		assertEquals("Giga Drain", exeggcute.getMove2().getName());
		assertEquals("Body Slam", exeggcute.getMove3().getName());
		assertEquals("Tackle", exeggcute.getMove4().getName());	
	}
	
	/**
	 * Tests that Vulpix correctly makes an instance
	 * of a Vulpix Pokemon
	 */
	@Test
	public void testVulpix() 
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		
		/**
		 * Tests that vulpix is given the correct leveled stats
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(46, vulpix.getAttack());
		assertEquals(45, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that vulpix gets strong fire moves
		 */
		assertEquals("Inferno", vulpix.getMove1().getName());
		assertEquals("Fire Fang", vulpix.getMove2().getName());
		assertEquals("Body Slam", vulpix.getMove3().getName());
		assertEquals("Tackle", vulpix.getMove4().getName());
	}
	
	/**
	 * Tests that Staryu correctly makes an instance
	 * of a Staryu Pokemon
	 */
	@Test
	public void testStaryu() 
	{
		Pokemon staryu = PokemonDaycare.Staryu(50);
		
		/**
		 * Tests that poliwag is given the correct leveled stats
		 */
		assertEquals(90, staryu.getMaxHitPoints());
		assertEquals(90, staryu.getCurrentHitPoints());
		assertEquals(50, staryu.getAttack());
		assertEquals(60, staryu.getDefense());
		assertEquals(90, staryu.getSpeed());
		assertEquals(50, staryu.getLevel());
		
		/**
		 * Tests that poliwag gets strong water moves
		 */
		assertEquals("Hydro Pump", staryu.getMove1().getName());
		assertEquals("Scald", staryu.getMove2().getName());
		assertEquals("Body Slam", staryu.getMove3().getName());
		assertEquals("Tackle", staryu.getMove4().getName());
	}
	
	/**
	 * Tests that Missingno correctly makes an instance
	 * of a Missingno Pokemon
	 */
	@Test
	public void Missingno()
	{
		Pokemon missingno = PokemonDaycare.Missingno(50);
		
		/**
		 * Tests that missingno is given the correct leveled stats
		 */
		assertEquals(93, missingno.getMaxHitPoints());
		assertEquals(93, missingno.getCurrentHitPoints());
		assertEquals(141, missingno.getAttack());
		assertEquals(16, missingno.getDefense());
		assertEquals(34, missingno.getSpeed());
		assertEquals(150, missingno.getLevel());
		
		/**
		 * Tests that blastoise gets weak water moves
		 */
		assertEquals("Water Gun", missingno.getMove1().getName());
		assertEquals("Water Pulse", missingno.getMove2().getName());
		assertEquals("Tackle", missingno.getMove3().getName());
		assertEquals("Scratch", missingno.getMove4().getName());
	}

}