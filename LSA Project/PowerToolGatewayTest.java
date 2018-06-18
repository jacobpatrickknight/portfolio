package Tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Main.PowerToolGateway;

/**
 * 
 * @author Jacob Knight
 * Tests the PowerToolGateway class
 */

public class PowerToolGatewayTest 
{
	
	private String driver="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://db.cs.ship.edu:3306/swe400-33";
	private String uname="swe400_3";
	private String pass="pwd4swe400_3F16";
	private Connection conn;

	/**
	 * @author Elisabeth Ostrow
	 * loads driver and connects to the db
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Before
	public void connect() throws SQLException, ClassNotFoundException
	{
		//Dynamically load driver class
		Class.forName(driver);
		//Establish connection with DriverManager
		conn=DriverManager.getConnection(URL, uname, pass);
		conn.setAutoCommit(false);
	}
	
	/**
	 * @author Elisabeth Ostrow
	 * rolls-back changes and closes connection to db
	 * @throws SQLException
	 */
	@After
	public void disconnect() throws SQLException
	{
		////NOTE: conn.rollback() throwing an error. DB changes currently persist
		conn.rollback();
		conn.close();
	}
	
	/**
	 * Tests that the gateway can be initialized
	 */
	@Test
	public void testInit() 
	{
		PowerToolGateway powerToolGateway = new PowerToolGateway(conn, URL, driver, uname, pass);
		assertEquals(conn, powerToolGateway.getConn());
	}
	
	/**
	 * Tests that a new power tool can be created
	 * @throws SQLException
	 */
	@Test
	public void testCreate() throws SQLException
	{
		PowerToolGateway powerToolGateway = new PowerToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		
		assertTrue(powerToolGateway.create("1010101010", "1", "5", "saw", "0"));
	}
	
	/**
	 * Tests that a power tool can be found
	 * @throws SQLException
	 */
	@Test
	public void testFind() throws SQLException
	{
		PowerToolGateway powerToolGateway = new PowerToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String powerToolID;
		powerToolGateway.create("1010101010", "1", "5", "saw", "0");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		powerToolID = result.getString(1);
		
		// Find by id
		result = powerToolGateway.findBy("id", powerToolID);
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), powerToolID);
			assertNotEquals(result.getString("id"), powerToolID + 1);
			assertEquals(result.getString("batteryPowered"), "0");
		}
		
		// find by batteryPowered
		result = powerToolGateway.findBy("batteryPowered", "0");
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), powerToolID);
			assertNotEquals(result.getString("id"), powerToolID + 1);
			assertEquals(result.getString("batteryPowered"), "0");
		}
		
		// find by description (requires join with Tool table)
		result = powerToolGateway.findBy("description", "saw");
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), powerToolID);
			assertNotEquals(result.getString("id"), powerToolID + 1);
			assertEquals(result.getString("batteryPowered"), "0");
		}
	}
	
	/**
	 * Tests that a power tool can be updated
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException
	{
		PowerToolGateway powerToolGateway = new PowerToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String powerToolID;
		powerToolGateway.create("1010101010", "1", "5", "saw", "0");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		powerToolID = result.getString(1);
		
		// Update by batteryPowered
		assertTrue(powerToolGateway.updateBy("batteryPowered", "0", "id", powerToolID));
		
		// Update by description (Tool table)
		assertTrue(powerToolGateway.updateBy("description", "heatgun", "id", powerToolID));
		
		// Update by upc (InventoryItem table)
		assertTrue(powerToolGateway.updateBy("upc", "1010101010", "id", powerToolID));
	}
	
	/**
	 * Tests that a power tool can be deleted
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException
	{
		PowerToolGateway powerToolGateway = new PowerToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String powerToolID;
		powerToolGateway.create("1010101010", "1", "5", "saw", "0");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		powerToolID = result.getString(1);
		
		// Delete by id
		assertTrue(powerToolGateway.deleteBy("id", powerToolID));
		
		// Delete by description (Tool table)
		powerToolGateway.create("0000011111", "2", "6", "jigsaw", "0");
		assertTrue(powerToolGateway.deleteBy("description", "jigsaw"));
		
		// Delete by upc (InventoryItem table
		powerToolGateway.create("0000011111", "2", "6", "screw driver", "1");
		assertTrue(powerToolGateway.deleteBy("upc", "0000011111"));
	}
}