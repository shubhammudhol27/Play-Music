package JavaProject;

import java.util.Scanner;

public class PlayMusic {
	public static void main(String[] args) {

		PlayMusic pl = new PlayMusic();

		pl.Music();
	}

	public void Music() {
		SongOperation operation = new SongOperation();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Choice \n1. Play Song \n2. Add/Remove song \n3. Update Song \n4. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("1. Play All Songs \n2. Choose Song \n3. Play Random \n4. Go Back");
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 1:
					operation.selectSong();
					break;
				case 2:
					System.out.println("Choose song from list");
					break;
				case 3:
					System.out.println("playing song randomly");
				case 4:
					break;
				default:
					System.out.println("invalid input");
					break;
				}
				break;
			case 2:
				System.out.println("1. Add Song \n2. Rename Song \n3. Remove song ");
				int choice2 = sc.nextInt();
				switch (choice2) {
				case 1:
					operation.addSong();
					break;
				case 2:
					operation.renameSong();

					break;
				case 3:
					operation.RemoveSongs();
					break;
				}
				break;
			case 3:
				System.out.println("1. Name \n2.Singer \n3. Movie & Album \n4. Go Back");
				int choice3 = sc.nextInt();
				switch (choice3) {
				case 1:
					operation.renameSong();
					break;
				case 2:
					operation.changeSinger();
					break;
				case 3:
					operation.movieNameChange();
					break;
				case 4:
					continue;
				default:
					break;
				}
				break;
			case 4:
				continue;
			default:
				System.out.println("Invalid Input");
				break;
			}
			continue;
		}
	}

}
