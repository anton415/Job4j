package ru.aserdyuchenko;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
/**
 * Class FileSort. Task 860.
 * @author Anton Serdyuchenko (anton415@gmail.com).
 * @version 1.
 * @since 17.12.2016.
 */
public class FileSort implements SortLines {
/**
 * @param source			Unsorted file.
 * @param dist				Sorted file.
 */
	public void sort(File source, File dist) {
		try {
			RandomAccessFile file = new RandomAccessFile(source, "r");
			RandomAccessFile distFile = new RandomAccessFile(dist, "rw");
			ArrayList<String> array = new ArrayList<String>();
			String lines;
			while ((lines = file.readLine()) != null) {
				array.add(lines);
			}
			String[] stringArray = array.toArray(new String[0]);
			Arrays.sort(stringArray);
			for (String line : stringArray) {
				distFile.writeBytes(line + "\n");
			}
			System.out.print("sort files.");
		} catch (IOException e) {
            System.out.print("IOException, file is not sorted.");
            e.printStackTrace();
        }
	}
}
