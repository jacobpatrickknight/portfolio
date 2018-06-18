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

import Main.ToolGateway;

/**
 * 
 * @author Jacob Knight
 * Tests the ToolGateway class
 */

public class ToolGatewayTest 
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
		ToolGateway toolGateway = new ToolGateway(conn, URL, driver, uname, pass);
		assertEquals(conn, toolGateway.getConn());
	}
	
	/**
	 * Tests that a new tool can be created
	 * @throws SQLException
	 */
	@Test
	public void testCreate() throws SQLException
	{
		ToolGateway toolGateway = new ToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		
		assertTrue(toolGateway.create("1010101010", "1", "5", "hammer"));
	}
	
	/**
	 * Tests that a tool can be found
	 * @throws SQLException
	 */
	@Test
	public void testFind() throws SQLException
	{
		ToolGateway toolGateway = new ToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String toolID;
		toolGateway.create("1010101010", "1", "5", "hammer");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		toolID = result.getString(1);
		
		// Find by id
		result = toolGateway.findBy("id", toolID);
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), toolID);
			assertNotEquals(result.getString("id"), toolID + 1);
			assertEquals(result.getString("description"), "hammer");
		}
		
		// Find by description
		result = toolGateway.findBy("description", "hammer");
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), toolID);
			assertNotEquals(result.getString("id"), toolID + 1);
			assertEquals(result.getString("description"), "hammer");
		}
		
		// Find by upc (requires join with InventoryItem table)
		result = toolGateway.findBy("upc", "1010101010");
		assertTrue(result.next());
		
		if(result.next())
		{
			assertEquals(result.getString("id"), toolID);
			assertNotEquals(result.getString("id"), toolID + 1);
			assertEquals(result.getString("description"), "hammer");
		}
	}
	
	/**
	 * Tests that a tool can be updated
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException
	{
		ToolGateway toolGateway = new ToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String toolID;
		
		toolGateway.create("1010101010", "1", "5", "hammer");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		toolID = result.getString(1);
		
		// Update by description
		assertTrue(toolGateway.updateBy("description", "wrench", "id", toolID));
		
		// Update by upc (InventoryItem table
		assertTrue(toolGateway.updateBy("upc", "1010101010", "id", toolID));
	}
	
	/**
	 * Tests that a tool can be deleted
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException
	{
		ToolGateway toolGateway = new ToolGateway(conn, URL, driver, uname, pass);
		conn.setAutoCommit(false);
		String toolID;
		
		toolGateway.create("1010101010", "1", "5", "hammer");
		
		// finds the ID of the item created
		Statement statement = conn.createStatement();
		String sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		toolID = result.getString(1);
		
		// Update by description
		assertTrue(toolGateway.updateBy("description", "wrench", "id", toolID));
		
		// Update by upc (InventoryItem table
		assertTrue(toolGateway.updateBy("upc", "1010101010", "id", toolID));
		
		// Delete by description
		assertTrue(toolGateway.deleteBy("description", "wrench"));
		
		// Delete by upc (InventoryItem table
		toolGateway.create("0000011111", "2", "6", "pliers");
		assertTrue(toolGateway.deleteBy("upc", "0000011111"));
	}

}