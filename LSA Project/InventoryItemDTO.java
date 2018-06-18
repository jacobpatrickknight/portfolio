package DataTransferObjects;

/**
 * 
 * @author Jacob Knight
 * Creates a data transfer object for a Inventory Item
 */
public class InventoryItemDTO 
{
	private int itemId;
	private String upc;
	private int manId;
	private int price;
	
	/**
	 * Returns the id of the inventory item
	 * @return itemId (id of the inventory item)
	 */
	public int getItemId()
	{
		return itemId;
	}
	
	/**
	 * Returns the upc of the inventory item
	 * @return upc (upc of the inventory item)
	 */
	public String getUpc()
	{
		return upc;
	}
	
	/**
	 * Returns the manufacturer id of the inventory item
	 * @return manID (manufacturer id of the inventory item)
	 */
	public int getManId()
	{
		return manId;
	}
	
	/**
	 * Returns the price of the inventory item
	 * @return price (price of the inventory item)
	 */
	public int getPrice()
	{
		return price;
	}
	
	/**
	 * Sets the id of the inventory item
	 * @param itemId (id of the inventory item)
	 */
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	
	/**
	 * Sets the upc of the inventory item
	 * @param upc (upc of the inventory item)
	 */
	public void setUpc(String upc)
	{
		this.upc = upc;
	}
	
	/**
	 * Sets the manufacturer id of the inventory item
	 * @param manId (manufacturer id of the inventory item)
	 */
	public void setManId(int manId)
	{
		this.manId = manId;
	}
	
	/**
	 * Sets the price of the inventory item
	 * @param price (price of the inventory item)
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}
}
