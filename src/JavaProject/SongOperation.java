package JavaProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperation extends SongDetails {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static int result;
	private static String setPath = "C:\\New folder\\PlayMusicPro\\resources\\db_info.properties";
	private static String query;
	static int songNo;
	static String songName;
	static String singerName;
	static String filmName;
	static Scanner sc1;

	private static void openConnection() {

		try {
			fileReader = new FileReader(setPath);
			properties = new Properties();
			properties.load(fileReader);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addSong() {
		sc1 = new Scanner(System.in);
		System.out.println("Song no : ");
		songNo = sc1.nextInt();
		System.out.println("Song name : ");
		songName = sc1.next();
		System.out.println("Singer name : ");
		singerName = sc1.next();
		System.out.println("Film name : ");
		filmName = sc1.next();
		openConnection();
		try {
			query = "insert into songs " + "values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, songNo);
			preparedStatement.setString(2, songName);
			preparedStatement.setString(3, singerName);
			preparedStatement.setString(4, filmName);

			result = preparedStatement.executeUpdate();

			System.out.println("Song " + result + "added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
    public static void selectSong() {
    	openConnection();
		try {
			query = "select * from songs";
			preparedStatement =connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" || "
						+resultSet.getString(2)+" || "
						+resultSet.getString(3)+" || "
						+resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        closeConnection();

    }
	public static void renameSong() {
		openConnection();
		sc1 = new Scanner(System.in);
		System.out.println("Enter a song no to rename : ");
		int songNo = sc1.nextInt();
		System.out.println("Ente a new name: ");
		String NewName = sc1.next();
		
		try {
			query = "update songs " + "set songName = ?"
					+ "where songNo =? ";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, NewName);
			preparedStatement.setInt(2, songNo);
			
			result = preparedStatement.executeUpdate();
			System.out.println("song renamed");
		} catch (Exception e) {
			e.printStackTrace();
		}
        closeConnection();
	}
	public static void RemoveSongs() {
		openConnection();
		sc1 = new Scanner(System.in);
		System.out.println("Enter a song no to remove : ");
		int songNo = sc1.nextInt();
		
		try {
			query = "delete from songs "
					+ "where songNo =? ";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setInt(1, songNo);
			
			result = preparedStatement.executeUpdate();
			System.out.println("song deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
        closeConnection();
	}
	public static void changeSinger() {
		openConnection();
		sc1 = new Scanner(System.in);
		System.out.println("Enter a somg no to rename singer : ");
		int songNo = sc1.nextInt();
		System.out.println("Ente a new singer name: ");
		String NewSingerName = sc1.next();
		
		try {
			query = "update songs " + "set singerName = ?"
					+ "where songNo =? ";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, NewSingerName);
			preparedStatement.setInt(2, songNo);
			result = preparedStatement.executeUpdate();
			System.out.println("singer renamed");
		} catch (Exception e) {
			e.printStackTrace();
		}
        closeConnection();
	}
	public static void movieNameChange() {
		openConnection();
		sc1 = new Scanner(System.in);
		System.out.println("Enter a song no to rename movie : ");
		int songNo = sc1.nextInt();
		System.out.println("Ente a new movie name: ");
		String NewMovieName = sc1.next();
		
		try {
			query = "update songs " + "set filmName = ?"
					+ "where songNo =? ";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, NewMovieName);
			preparedStatement.setInt(2, songNo);
			result = preparedStatement.executeUpdate();
			System.out.println("Movie renamed");
		} catch (Exception e) {
			e.printStackTrace();
		}
        closeConnection();

	}
}
