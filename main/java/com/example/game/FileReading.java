package com.example.game;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;

public class FileReading {
	public String filePath;
	// public String fileName;
	private Context context;

	/*public FileReading(String _filePath) {
		filePath = "data\\"+_filePath;
	}*/

	public FileReading(Context context, String _fileName) {
		this.context = context;
		this.filePath = _fileName;
	}

	public void ReadDataFromFile(ArrayList<String> dataList, int _iLine) {
	    int i = 0;
	    dataList.clear();
	    String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream()))) {
			
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

	public void ReadDataFromFile(ArrayList<String> dataList) {
		int i = 0;
		dataList.clear();
		String text="", line;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream()))) {
			while ((line = br.readLine()) != null) {
				// dataList.add(line);
				text = text + line;
			}

			if(text != null) {
				String[] splitData = text.split("#");
				for(String data : splitData) {
					dataList.add(data);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private InputStream getInputStream() throws IOException {
		AssetManager assetManager = context.getAssets();
		return assetManager.open(filePath);
	}
}
