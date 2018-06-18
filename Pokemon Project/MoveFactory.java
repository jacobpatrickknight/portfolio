package Pokemon;

/**
 * Interface for the move related factories
 * @author Jacob Knight
 */

public interface MoveFactory 
{
	/**
	 * Gives the pokemon strong moves
	 * @param pokemon
	 */
	public void strongMoves(Pokemon pokemon);
	
	/**
	 * Gives the pokemon medium-powered moves
	 * @param pokemon
	 */
	public void mediumMoves(Pokemon pokemon);
	
	/**
	 * Gives the pokemon weak moves
	 * @param pokemon
	 */
	public void weakMoves(Pokemon pokemon);
}
