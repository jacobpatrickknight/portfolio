package items;

import Pokemon.Pokemon;

public class Scarf implements Item
{

	private String description;
	
	/**
	 * Constructor, sets item description
	 * @param i: Item
	 */
	public Scarf()
	{
		description = "Scarf";
	}
	
	/**
	 * Required method, empty
	 * (Scarfs require decorators to affect Pokemon)
	 */
	public void activate(Pokemon pokemon) 
	{	

	}

	/**
	 * Returns item description
	 * @return description
	 */
	public String getDescription() 
	{
		return description;
	}
}
