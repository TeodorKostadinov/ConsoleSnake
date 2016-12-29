import java.io.IOException;
import java.util.Scanner;

public class Engine {
	
	static boolean isRunning = true;
	static int DELAY_IN_MILLIS = 500;

	public static void main(String[] args) {
		setKeyboardListener();
		startGame();
	}

	/**
	 * Listens for pressed keys and notifies the handleKeyPressed method. 
	 * setKeyboardListener is async and does not work on the main thread.
	 * This method should not be modified.
	 */
	private static void setKeyboardListener() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (isRunning) {
					char input = scanner.nextLine().charAt(0);
					handleKeyPressed(input);
				}
				scanner.close();
			}
		}).start();
	}

	private static void handleKeyPressed(char keyCode) {
		System.out.println("Key pressed:" + keyCode);
	}

	private static void startGame() {
		
	}

	/**
	 * Stops the main thread for a specified time
	 */
	private static void delay() {
		try {
			Thread.sleep(DELAY_IN_MILLIS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clears everything from the console
	 */
	private static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
