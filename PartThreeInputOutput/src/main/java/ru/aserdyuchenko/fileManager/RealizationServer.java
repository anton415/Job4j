package ru.aserdyuchenko.fileManager;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
/**
 * @author Anton Serdyuchenko.
 */
public class RealizationServer {
/**
 * @param socket - socket.
 */
	private final Socket socket;
/**
 * @param port - port.
 */
	private static int port;
/**
 * Переменная нужна для перехода в нужный каталог.
 * @param nowPath.
 */
	private String nowPath = "./";
/**
 * Переменная нужна для перехода в нужный каталог.
 * @param homePath.
 */
	private String homePath = "./";
/**
 * @param socket - server socket.
 */
	public RealizationServer(Socket socket) {
		this.socket = socket;
	}
/**
 * @param args - args.
 * @throws IOException - exception.
 */
	public static void main(String[] args) throws IOException {
		port = Integer.parseInt(readProperties("number.port"));
		try (final Socket socket = new ServerSocket(port).accept()) {
			new RealizationServer(socket);
		}
	}
/**
 * @param newHomePath - home path.
 * @throws IOException - IOException.
 */
	public void startServer(String newHomePath) throws IOException {
		homePath = newHomePath;
		PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		String ask = null;
		do {
   		System.out.println("wait command ...");
    	ask = in.readLine();
    	System.out.println(ask);
			if ("Go to".equals(ask)) {
				do {
					ask = in.readLine();
					out.println(Arrays.toString(seeThisPath(ask)));
					ask = in.readLine();
				} while (!("Exit in menu".equals(ask)));
			} else if ("Go home".equals(ask)) {
				nowPath = homePath;
				out.println(Arrays.toString(seeHomePath()));
			} else if (!("Exit".equals(ask))) {
				out.println("I don`t understand.");
			}
		} while (!("Exit".equals(ask)));
	}
/**
 * @param needValue - what value you need.
 * @return value - value.
 * @throws IOException - IOException.
 */
	public static String readProperties(String needValue) throws IOException {
		RealizationSettings settings = new RealizationSettings();
		File file = new File("./src/resources/app.properties");
		try (FileInputStream io = new FileInputStream(file)) {
			settings.load(io);
		}
		String value = settings.getValue(needValue);
		return value;
	}
/**
 * Возвращает список корневого каталога.
 * @return list - содержимое корневой папки.
 */
	public String[] seeHomePath() {
		String[] list = new File(homePath).list();
		return list;
	}
/**
 * Осуществляет переход в выбранные каталог.
 * @param thisPath - thisPath.
 * @return list - содержимое данной папки.
 */
	public String[] seeThisPath(String thisPath) {
		String[] list = new File(homePath + thisPath).list();
		return list;
	}
/**
 * Скачать файл.
 * @param nameFile - nameFile.
 */
	public void downloadFile(String nameFile) {
		// Реализация скачивания файла.
	}
/**
 * Загрузить файл.
 * Я ещё не знаю как будет происходить загрузка файла, поэтому не знаю
 * нужно ли передавать какой-нибудь параметр.
 */
	public void pushFile() {
		// Реализация загрузки файла.
	}
}
