package Pokemon;

import Resources.Constants.TYPE;
import attacks.Attack;
import items.Item;
import javafx.scene.image.Image;
import type.AbstractType;
import type.FireType;
import type.GrassType;
import type.NormalType;
import type.WaterType;

/**
 * Keeps track of information related to an individual Pokemon
 * @author Jacob Knight
 */
public class Pokemon
{
	
	private Attack[] moves = new Attack[4];
	private AbstractType type;
	private Item heldItem;
	private String name;
	private int currentHitPoints;
	private int maxHitPoints;
	private int attack;
	private int defense;
	private int speed;
	private int level;
	
	private String prevMove;
	
	/**
	 * Constructor for Pokemon
	 * @param species, hp, atk, def, spd, type
	 */
	public Pokemon(String species, int hp, int atk, int def, int spd, AbstractType type)
	{
		name = species;
		maxHitPoints = hp;
		currentHitPoints = hp;
		attack = atk;
		defense = def;
		speed = spd;
		this.type = type;
		level = 0;
	}
	
	
	/************************************************************************
	 * Getter Methods for Attributes
	 ************************************************************************/
	
	/**
	 * Returns the Pokemon's name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the Pokemon's held item
	 * @return itemDescription
	 */
	public Item getHeldItem()
	{
		return heldItem;
	}
	
	/**
	 * Returns the Pokemon's Max Hit Points
	 * @return maxHitPoints
	 */
	public int getMaxHitPoints()
	{
		return maxHitPoints;
	}
	
	/**
	 * Returns the Pokemon's Current Hit Points
	 * @return currentHitPoints
	 */
	public int getCurrentHitPoints()
	{
		return currentHitPoints;
	}
	
	/**
	 * Returns the Pokemon's Attack stat
	 * @return attack
	 */
	public int getAttack()
	{
		return attack;
	}
	
	/**
	 * Returns the Pokemon's Defense stat
	 * @return defense
	 */
	public int getDefense()
	{
		return defense;
	}
	
	/**
	 * Returns the Pokemon's Speed stat
	 * @return speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Returns the Pokemon's Type
	 * @return type.getType()
	 */
	public TYPE getType()
	{
		return type.getType();
	}
	
	/**
	 * Returns the Pokmeon's level
	 * @return level
	 */
	public int getLevel()
	{
		return level;
	}
	
	
	
	/************************************************************************
	 * Setter Methods for Attributes
	 ************************************************************************/

	/**
	 * Sets the Pokemon's item
	 * @param item
	 */
	public void setHeldItem(Item item)
	{
		heldItem = item;
		heldItem.activate(this);
	}
	/**
	 * Sets the Pokemon's Max Hit Points
	 * @param hp: int
	 */
	public void setMaxHitPoints(int hp)
	{
		if (hp >= 0)
		{
			maxHitPoints = hp;
			if (currentHitPoints > maxHitPoints)
				currentHitPoints = maxHitPoints;
		}
		else
		{
			maxHitPoints = 0;
			currentHitPoints = 0;
		}
	}
	
	/**
	 * Sets the Pokemon's Current Hit Points
	 * @param hp: int
	 */
	public void setCurrentHitPoints(int hp)
	{
		if (hp >= 0)
			currentHitPoints = hp;
		else
			currentHitPoints = 0;
	}
	
	/**
	 * Sets the Pokemon's Attack stat
	 * @param atk: int
	 */
	public void setAttack(int atk)
	{
		attack = atk;
	}
	
	/**
	 * Sets the Pokemon's Defense stat
	 * @param def: int
	 */
	public void setDefense(int def)
	{
		defense = def;
	}
	
	/**
	 * Sets the Pokemon's Speed stat
	 * @param spd: int
	 */
	public void setSpeed(int spd)
	{
		speed = spd;
	}
	
	/**
	 * Sets the Pokemon's level
	 * @param lvl: int
	 */
	public void setLevel(int lvl)
	{
		level = lvl;
	}
	
	
	
	/************************************************************************
	 * Move Methods
	 ************************************************************************/

	
	
	/**
	 * Sets the Pokemon's first move (moves[0])
	 * @param move: Attack
	 */
	public void setMove1(Attack move)
	{
		moves[0] = move;
	}
	
	/**
	 * Sets the Pokemon's second move (moves[1])
	 * @param move: Attack
	 */
	public void setMove2(Attack move)
	{
		moves[1] = move;
	}
	
	/**
	 * Sets the Pokemon's third move (moves[2])
	 * @param move: Attack
	 */
	public void setMove3(Attack move)
	{
		moves[2] = move;
	}

	/**
	 * Sets the Pokemon's fourth move (moves[3])
	 * @param move: Attack
	 */
	public void setMove4(Attack move)
	{
		moves[3] = move;
	}
	
	/**
	 * Returns the move at index i of moves[]
	 * @param i: int
	 * @return move[i]
	 */
	public Attack getMove(int i)
	{
		if (i > -1 && i < 4)
			return moves[i];
		else
		{
			System.out.println("Error: Not a valid move slot. Returning first move.");
			return moves[0];
		}
	}
	
	/**
	 * Returns the Pokemon's first move
	 * @return moves[0]
	 */
	public Attack getMove1()
	{
		return moves[0];
	}
	
	/**
	 * Returns the Pokemon's second move
	 * @return moves[1]
	 */
	public Attack getMove2()
	{
		return moves[1];
	}
	
	/**
	 * Returns the Pokemon's third move
	 * @return moves[2]
	 */
	public Attack getMove3()
	{
		return moves[2];
	}
	
	/**
	 * Returns the Pokemon's fourth move
	 * @return moves[3]
	 */
	public Attack getMove4()
	{
		return moves[3];
	}
	
	/**
	 * Returns the Pokemon's moveset
	 * @return moves[]
	 */
	public Attack[] getMoves()
	{
		return moves;
	}
	
	/**
	 * Uses the move at index i of moves[]
	 * @param i: int
	 */
	public String useMove(int i)
	{
		if (i > -1 && i < 4)
		{
			if(moves[i] != null)
			{
				moves[i].Use();
				prevMove = moves[i].getName();
				return moves[i].getName();
			}
			else
			{
				System.out.println("No move in this slot");
				return "Invalid move";
			}
		}
		else
		{
			System.out.println("Error: Not a valid move slot. Using first move.");
			if(moves[0] != null)
			{
				moves[0].Use();
				prevMove = moves[i].getName();
				return moves[0].getName();
			}
			else
			{
				System.out.println("No move in this slot");
				return "Invalid move";
			}
		}
	}
	
	/**
	 * Uses the Pokemon's first move
	 */
	public String useMove1()
	{
		if(moves[0] != null)
		{
			moves[0].Use();
			prevMove = moves[0].getName();
			return moves[0].getName();
		}
		else
		{
			System.out.println("No move in this slot");
			return "Invalid move";
		}
	}
	
	/**
	 * Uses the Pokemon's second move
	 */
	public String useMove2()
	{
		if(moves[1] != null)
		{
			moves[1].Use();
			prevMove = moves[1].getName();
			return moves[1].getName();
		}
		else
		{
			System.out.println("No move in this slot");
			return "Invalid move";
		}
	}
	
	/**
	 * Uses the Pokemon's third move
	 */
	public String useMove3()
	{
		if(moves[2] != null)
		{
			moves[2].Use();
			prevMove = moves[2].getName();
			return moves[2].getName();
		}
		else
		{
			System.out.println("No move in this slot");
			return "Invalid move";
		}
	}
	
	/**
	 * Uses the Pokemon's fourth move
	 */
	public String useMove4()
	{
		if(moves[3] != null)
		{
			moves[3].Use();
			prevMove = moves[3].getName();
			return moves[3].getName();
		}
		else
		{
			System.out.println("No move in this slot");
			return "Invalid move";
		}
	}

	/**
	 * @author Aaron Gerber
	 * Need these for the gui
	 * @param p
	 */
	public Pokemon(Pokemon p)
	{
		name = p.getName();
		maxHitPoints = p.getCurrentHitPoints();
		currentHitPoints = p.getMaxHitPoints();
		attack = p.getAttack();
		defense = p.getDefense();
		speed = p.getSpeed();
		setType(p.getType());
		level = 0;
		
		setMove1(p.getMove1());
		setMove2(p.getMove2());
		setMove3(p.getMove3());
		setMove4(p.getMove4());
	}
	
	public void setType(TYPE type)
	{
		switch(type)
		{
		case FIRE:
			this.type = new FireType();
		case WATER:
			this.type = new WaterType();
		case GRASS:
			this.type = new GrassType();
		case NORMAL:
			this.type = new NormalType();
		}
	}
	
	public String getLastMove()
	{
		return prevMove;
	}

}