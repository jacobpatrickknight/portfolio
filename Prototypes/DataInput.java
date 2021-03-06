import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jacob Knight
 * Reads input from a file
 */
public class DataInput 
{
	private String fileName;
	
	/**
	 * Constructor for DataInput
	 * Stores the name of the file
	 * @param file:String - the name of the file
	 */
	public DataInput(String file)
	{
		fileName = file;
	}
	
	/**
	 * Reads from a text file and adds it to the array
	 * @param data:ArrayList<Integer> - the array for storing the file's contents
	 */
	public void read(double[] data) 
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			String line = input.readLine();
			int i = 0;
			while (line != null && i < data.length)
			{
				data[i] = Double.parseDouble(line);
				line = input.readLine();
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}