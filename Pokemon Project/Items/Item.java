package items;

import Pokemon.Pokemon;

/**
 * Interface for Items
 * @author Jacob Knight
 */
public interface Item 
{	
	/**
	 * Activates the effect of the item
	 * @param pokemon: Pokemon
	 */
	public void activate(Pokemon pokemon);
	
	/**
	 * Returns the item's description
	 * @return description: String
	 */
	public String getDescription();
}
