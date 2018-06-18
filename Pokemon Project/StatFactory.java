package Pokemon;

/**
 * Adjusts Pokemon stats based on Pokemon levels
 * @author Jacob Knight
 */
public class StatFactory 
{
	int level;
	
	/**
	 * Gathers the Pokemon's different stats and then calls
	 * the appropriate methods to recalculate them based on leveling
	 * @param pokemon, lvl
	 */
	public void buildStats(Pokemon pokemon, int lvl)
	{
		int hitPoints;
		int attack;
		int defense;
		int speed;
		level = lvl;
		
		hitPoints = buildHitPoints(pokemon.getMaxHitPoints());
		attack = buildOtherStat(pokemon.getAttack());
		defense = buildOtherStat(pokemon.getDefense());
		speed = buildOtherStat(pokemon.getSpeed());
		
		pokemon.setMaxHitPoints(hitPoints);
		pokemon.setCurrentHitPoints(hitPoints);
		pokemon.setAttack(attack);
		pokemon.setDefense(defense);
		pokemon.setSpeed(speed);
		pokemon.setLevel(level);
	}

	
	/**
	 * Calculates the Pokemon's Hit Points
	 * @param hitPoints
	 * @return hitPoints
	 */
	private int buildHitPoints(int hitPoints) 
	{
		hitPoints = ((2 * hitPoints * level) / 100) + level + 10;
		return hitPoints;
	}
	
	/**
	 * Calculates the Pokemon's stats besides Hit Points
	 * @param stat
	 * @return stat
	 */
	private int buildOtherStat(int stat) 
	{
		stat = ((2 * stat * level) / 100) + 5;
		return stat;
	}
}
