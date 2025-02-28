import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {
	public String filePath;

	public FileReading(String _filePath) {
		filePath = "..\\data\\"+_filePath;
	}

	public void ReadDataFromFile(ArrayList<String> dataList, int _iLine) {
	    int i =0;
	    dataList.clear();
	    String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			for(i=0; i<(_iLine+1); i++){
			    line = br.readLine();
			}
			
			if (line != null) {
				String[] splitData = line.split(", ");
				for (String data : splitData) {
					dataList.add(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
