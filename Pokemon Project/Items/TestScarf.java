package testItems;

import static org.junit.Assert.*;

import org.junit.Test;

import Pokemon.Pokemon;
import Pokemon.PokemonDaycare;
import items.AttackGem;
import items.DefenseGem;
import items.FireStone;
import items.Item;
import items.NormalStone;
import items.Scarf;
import items.WaterStone;

/**
 * Tests functionality of Scarf
 * @author Jacob Knight
 */
public class TestScarf 
{
	/**
	 * Tests that a Scarf can be created and set onto a Pokemon
	 */
	@Test
	public void testInitialzation() 
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		vulpix.setHeldItem(scarf);
		
		/**
		 * Tests the scarf's description
		 */
		assertEquals("Scarf", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that a scarf doesn't change a Pokemon's stats by it's own
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(46, vulpix.getAttack());
		assertEquals(45, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
	}
	
	/**
	 * Tests that a ItemDecorator can be added to a Scarf
	 */
	@Test
	public void testAddItemDecorator()
	{
		Pokemon vulpix = PokemonDaycare.Vulpix(50);
		Scarf scarf = new Scarf();
		Item attackScarf = new AttackGem(scarf);
		vulpix.setHeldItem(attackScarf);
		
		/**
		 * Tests that the scarf now has an Attack Gem
		 */
		assertEquals("Scarf, Attack Gem", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that attackScarf boosts vulpix's attack and nothing else
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(45, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that the scarf has an Attack and Defense Gem
		 */
		Item defAtkScarf = new DefenseGem(attackScarf);
		vulpix.setHeldItem(defAtkScarf);
		assertEquals("Scarf, Attack Gem, Defense Gem", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that atkDefScarf boosts vulpix's attack and defense and nothing else
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(67, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that vulpix's fire moves haven't been changed
		 * Used for the next test
		 */
		assertEquals(100, vulpix.getMove1().getBaseDam());
		assertEquals(65, vulpix.getMove2().getBaseDam());
		
		/**
		 * Tests that the scarf has an Attack Gem, Defense Gem, and Fire Stone
		 */
		Item fireDefAtkScarf = new FireStone(defAtkScarf);
		vulpix.setHeldItem(fireDefAtkScarf);
		assertEquals("Scarf, Attack Gem, Defense Gem, Fire Stone", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that Fire Stone hasn't changed vulpix's stats
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(67, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that Vulpix's fire moves have been buffed
		 */
		assertEquals(150, vulpix.getMove1().getBaseDam());
		assertEquals(97, vulpix.getMove2().getBaseDam());
		
		/**
		 * Tests that the scarf has an Attack Gem, Defense Gem, Fire Stone
		 * and Normal Stone
		 */
		Item normalFireDefAtkScarf = new NormalStone(fireDefAtkScarf);
		vulpix.setHeldItem(normalFireDefAtkScarf);
		assertEquals("Scarf, Attack Gem, Defense Gem, Fire Stone, Normal Stone", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that Normal Stone hasn't changed vulpix's stats
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(67, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that Vulpix's normal moves have been buffed
		 */
		assertEquals(150, vulpix.getMove1().getBaseDam());
		assertEquals(97, vulpix.getMove2().getBaseDam());
		assertEquals(127, vulpix.getMove3().getBaseDam());
		assertEquals(75, vulpix.getMove4().getBaseDam());
		
		/**
		 * Tests that the scarf has an Attack Gem, Defense Gem, Fire Stone,
		 * Normal Stone, and Water Stone
		 */
		Item waterNormalFireDefAtkScarf = new WaterStone(normalFireDefAtkScarf);
		vulpix.setHeldItem(waterNormalFireDefAtkScarf);
		assertEquals("Scarf, Attack Gem, Defense Gem, Fire Stone, Normal Stone, Water Stone", vulpix.getHeldItem().getDescription());
		
		/**
		 * Tests that Water Stone hasn't changed vulpix's stats
		 */
		assertEquals(98, vulpix.getMaxHitPoints());
		assertEquals(98, vulpix.getCurrentHitPoints());
		assertEquals(69, vulpix.getAttack());
		assertEquals(67, vulpix.getDefense());
		assertEquals(70, vulpix.getSpeed());
		assertEquals(50, vulpix.getLevel());
		
		/**
		 * Tests that Vulpix's moves have not been buffed
		 * (Vulpix has no water moves
		 */
		assertEquals(150, vulpix.getMove1().getBaseDam());
		assertEquals(97, vulpix.getMove2().getBaseDam());
		assertEquals(127, vulpix.getMove3().getBaseDam());
		assertEquals(75, vulpix.getMove4().getBaseDam());
	}
}
