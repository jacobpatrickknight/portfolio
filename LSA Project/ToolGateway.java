package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Jacob Knight
 * Allows access into the Tool table of the database
 */

public class ToolGateway 
{

	private String driver;
	private String URL;
	private String uname;
	private String pass;
	private Connection conn;
	private Statement statement;
	
	/**
	 * Connects to the database
	 * @param conn, URL, driver, uname, pass
	 */
	public ToolGateway(Connection conn, String URL, String driver, String uname, String pass)
	{
		this.conn=conn;
		this.URL=URL;
		this.driver=driver;
		this.uname=uname;
		this.pass=pass;
	}
	
	/**
	 * Returns the connection
	 * @return conn
	 */
	public Connection getConn()
	{
		return conn;
	}

	/**
	 * Creates a new entry into the Tool and InventoryItem tables
	 * @param upc, manufacturerID, price, description
	 * @return true if successful, false if not
	 * @throws SQLException
	 */
	public boolean create(String upc, String manufacturerID, String price, String description) throws SQLException 
	{
		statement = conn.createStatement();
		
		String sql = "INSERT INTO InventoryItem VALUES("+0+", "+"\""+upc+"\", "+manufacturerID+", "+price+");";
		statement.execute(sql);
		
		sql = "SELECT ID FROM InventoryItem;";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		String ID = result.getString(1);
		
		sql = "INSERT INTO Tool VALUES("+ID+", "+"\""+description+"\");";
		
		try
		{
			statement.execute(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Finds the entry based on column provided
	 * Uses joins when the column is within another table
	 * @param col, val
	 * @return ResultSet result
	 * @throws SQLException
	 */
	public ResultSet findBy(String col, String val) throws SQLException
	{
		statement = conn.createStatement();
		String sql;
		
		if(col == "id" || col == "description")
			sql = "SELECT * FROM Tool WHERE "+col+"='"+val+"';";
		else
			sql = "SELECT * FROM Tool JOIN InventoryItem WHERE "+col+"='"+val+"';";
		
		ResultSet result = statement.executeQuery(sql);
		
		return result;
	}

	/**
	 * Updates an entry based on the new entry and an identifying column provided
	 * Updates superclass tables when new entry is a column in an upper table
	 * @param colToUpdate, newVal, whereCol, whereVal
	 * @return true if successful, false if not
	 * @throws SQLException
	 */
	public boolean updateBy(String colToUpdate, String newVal, String whereCol, String whereVal) throws SQLException
	{
		statement = conn.createStatement();
		String sql;
		
		if (colToUpdate == "description")
			sql ="UPDATE Tool SET "+colToUpdate+"='"+newVal+"' WHERE "+whereCol+"='"+whereVal+"';";
		else
			sql ="UPDATE InventoryItem SET "+colToUpdate+"='"+newVal+"' WHERE "+whereCol+"='"+whereVal+"';";

		try
		{
			statement.executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Deletes an entry based on the column provided
	 * Deletes all instances with the same ID from Tool, and InventoryItem
	 * @param col, val
	 * @return true if successful, false if not
	 * @throws SQLException
	 */
	public boolean deleteBy(String col, String val) throws SQLException 
	{
		statement = conn.createStatement();
		String sql;
		
		if(col == "description")
			sql = "SELECT ID FROM Tool WHERE "+col+"='"+val+"';";
		else
			sql = "SELECT ID FROM InventoryItem WHERE "+col+"='"+val+"';";
		ResultSet result = statement.executeQuery(sql);
		result.next();
		String ID = result.getString(1);
		
		try
		{
			sql = "DELETE FROM Tool WHERE id='"+ID+"';";
			statement.executeUpdate(sql);
			
			sql = "DELETE FROM InventoryItem WHERE id='"+ID+"';";
			statement.executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}