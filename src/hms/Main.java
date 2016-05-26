package hms;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		welcome();
	}
	/*
	 * Welcome
	 * */
	public static void welcome(){
		System.out.println("-------------------- Welcome to Holtel Management System --------------------");
		System.out.println("1. Input number of floor and room");
		System.out.println("2. Show Menu");
		System.out.println("3. Exit");
		
		Scanner in = new Scanner(System.in);
		int option = 0;
		boolean isNotOption = true;
		while(isNotOption){
			System.out.print("\nChoose Option(1-3): ");
			if(in.hasNextInt()){
				option = in.nextInt();
				if(option <= 3 && option > 0){
					isNotOption = false;
				}
			}
		}
		
		switch (option) {
		case 1:
			// input floor
			boolean isNotFloorRoom = true;
			int floor_room = 0;
			while(isNotFloorRoom){
				System.out.print("Enter Amount of Floor & Room: ");
				if(in.hasNextShort()){
					floor_room = in.nextShort();
					isNotFloorRoom = false;
				}else{
					System.out.println("Invalid Floor & Room!");
				}
			}
			
			Room r = new Room(floor_room);
			System.out.println("\n\nFloor and Room has been setup!");
			System.out.println("You have " + floor_room + " Floors & " + floor_room*floor_room + " Rooms...");
			welcome();
			break;
		case 2:
			showMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
		
	}
	
	public static void showMenu(){
		System.out.print("\n1.CheckIn\t2.CheckOut\t3.Display\t4.Exit\n");
		Room r = new Room();
		Scanner in = new Scanner(System.in);
		int option = 0;
		boolean isNotOption = true;
		while(isNotOption){
			System.out.print("\nChoose Option(1-4): ");
			if(in.hasNextInt()){
				option = in.nextInt();
				if(option <= 4 && option > 0){
					isNotOption = false;
				}
			}
		}
		
		switch (option) {
		case 1:
			r.checkIn();
			showMenu();
			break;
		case 2:
			r.checkOut();
			showMenu();
			break;
		case 3:
			r.display();
			
			showMenu();
			break;
		case 4:
			System.exit(0);
		default:
			break;
		}
		
		
		
	}
}
