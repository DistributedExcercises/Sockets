package ClientLogic;

public class Main {

	private final static short TEMP_BUFFER_SIZE = 10;
	private DataController controller = new DataController();
	
	public static void main(String[] args) 
	{
		while (true)
		{
			String temps = DataGenerator.bufferedData(TEMP_BUFFER_SIZE);
			
		}
	}
	
}
