package items;

/**
 * Abstract class that Item Decorators will inherit from
 * @author Jacob Knight
 */
public abstract class ItemDecorator implements Item
{
	protected Item item;
	protected String description;
	
	/**
	 * Constructor, sets item description
	 * @param i: Item
	 */
	public ItemDecorator(Item i)
	{
		this.item = i;
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
