package ru.aserdyuchenko;

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
			RandomAccessFile distFile = new RandomAccessFile(dist, "rw");
			int countLine = countLineInFile(source);
			int lineLength = 1;
			String firstLine;
			while (lineLength < countLine) {
			RandomAccessFile file = new RandomAccessFile(source, "r");
				while ((firstLine = file.readLine()) != null) {
					if (lineLength == firstLine.length()) {
						distFile.writeBytes(firstLine + "\n");
					}
				}
				lineLength++;
			}
		} catch (IOException e) {
            System.out.print("IOException: do not give up! try again");
            e.printStackTrace();
        }
	}
/**
 * @param source			Unsorted file.
 * @return result			Count line in file.
 */
	public int countLineInFile(File source) {
		int result = 0;
		try {
			RandomAccessFile file = new RandomAccessFile(source, "r");
			while (file.readLine() != null) {
				result++;
			}
		} catch (IOException e) {
            System.out.print("IOException: do not give up! try again");
            e.printStackTrace();
        }
		return result + 1;
	}
}
