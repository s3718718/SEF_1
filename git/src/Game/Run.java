package Game;
import java.util.*;


public class Run {
	
	static Account[] accounts = new Account[2];
	static int length =0;
	
	public static void main(String[] args) {
		menu();
		Scanner sc = new Scanner(System.in);
		Validate test = new Validate();
		int turn = -1;
		while (turn == -1){
			System.out.println();
			System.out.println("****Welcome to the 'Chess game'****");
			System.out.print("Enter number of turn: ");
			String input = sc.nextLine();
			turn = test.isPositiveInt(input);
			if (turn == -1){
				System.out.println("Invalid input!");
			}
		}
		Game game = new Game(turn);
		game.play();
	}
	
	static void menu(){
		Scanner sc = new Scanner(System.in);
		Validate test = new Validate();
		int playerLogin = 0;
		while (playerLogin != 2){
			System.out.println();
			System.out.println("****Welcome to the 'Chess game'****");
			System.out.println();
			System.out.println("Please login or register");
			System.out.println("Enter 1 to login or 2 to register");
			String input = sc.nextLine();
			int option = test.isPositiveInt(input);
			if (option == 1){
				login();
				playerLogin++;
			}
			else if (option == 2){
				register();
			}
			else System.out.println("Invalid input");
		}
	}
	
	static void login(){
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		while (check == false){
			System.out.println();
			System.out.println("****Login****");
			System.out.print("Enter your id: ");
			String id = sc.nextLine();
			System.out.println();
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			for (int x=0; x < length;x++){
				if (id.equals(accounts[x].getId())){
					if (password.equals(accounts[x].getPassword())){
						check = true;
					}
				}
			}
			if (check == false){
				System.out.println();
				System.out.println("Id and password incorrect!");
			}
		}
		System.out.println("****Login Successfully****");
	}
	
	static void register(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("****Register****");
		boolean check;
		String id = "";
		do {
			check =true;
			System.out.print("Enter your id: ");
			id = sc.nextLine();
			for (int x=0;x < length;x++){
				if (id.equals(accounts[x].getId())){
					System.out.println("Account ID have been taken");
					System.out.println();
					check = false;
				}
			}
		} while (check == false);
		System.out.println();
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		accounts[length] = new Account(id,password);
		length++;
		System.out.println("****Account created****");
	}
}
