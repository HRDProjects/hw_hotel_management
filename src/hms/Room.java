package hms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Room {
	
	private static String[][] floor_room;
	private static String guestName;
	private short floor;
	private short room;
	
	// constructor
	public Room(){
		
	}
	
	public Room(int floor_room){
		this.floor_room = new String[floor_room][floor_room];
	}
	
	// checkIn
	private int checkInCount = 0;
	public boolean checkIn(){
		Scanner in = new Scanner(System.in);
		boolean isCheckIn = false;
		// input floor
		boolean isNotFloor = true;
		
		while(isNotFloor){
			System.out.print("Enter Floor(0-" + (floor_room.length-1) + "): ");
			if(in.hasNextShort()){
				this.floor = in.nextShort();
				if(this.floor <= (floor_room.length-1) && this.floor >= 0){
					isNotFloor = false;
				}else{
					System.out.println("\nInvalid Floor!");
				}
			}else{
				System.out.println("\nInvalid Floor!");
			}
		}
		
		// input room
		boolean isNotRoom = true;
		while(isNotRoom){
			System.out.print("Enter Room(0-" + (floor_room.length-1) + "): ");
			if(in.hasNextShort()){
				this.room = in.nextShort();
				if(this.room <= (floor_room.length-1) && this.room >= 0){
					isNotRoom = false;
				}else{
					System.out.println("\nInvalid Room!");
				}
				
			}else{
				System.out.println("\nInvalid Room!");
			}
		}
		// check if room is checked in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		out: if(floor_room[this.floor][this.room] == null){
			System.out.print("Enter Guest Name: ");
			this.guestName = br.readLine();
			floor_room[this.floor][this.room] = this.guestName;
			isCheckIn = true;
		}else{
			System.out.println("\nThis room is already checked in!");
			checkInCount++;
			if(checkInCount >= 3){
				System.out.println("\nYou attemp to checked in the existing checked in room 3 time, please try again!");
				isCheckIn = false;
				break out;
			}else{
				checkIn();
			}
			
		}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return isCheckIn;
		
	}
	
	// checkOut
	private int checkOutCount = 0;
	public boolean checkOut(){
		Scanner in = new Scanner(System.in);
		boolean isCheckOut = false;
		// input floor
		boolean isNotFloor = true;

		while(isNotFloor){
			
			System.out.print("Enter Floor(0-" + (floor_room.length-1) + "): ");
			if(in.hasNextShort()){
				this.floor = in.nextShort();
				if(this.floor <= (floor_room.length-1) && this.floor >= 0){
					isNotFloor = false;
				}else{
					System.out.println("\nInvalid Floor!");
				}
			}else{
				System.out.println("\nInvalid Floor!");
			}
		}
		
		// input room
		boolean isNotRoom = true;
		while(isNotRoom){
			System.out.print("Enter Room(0-" + (floor_room.length-1) + "): ");
			if(in.hasNextShort()){
				this.room = in.nextShort();
				if(this.room <= (floor_room.length-1) && this.room >= 0){
					isNotRoom = false;
				}else{
					System.out.println("\nInvalid Room!");
				}
			}else{
				System.out.println("\nInvalid Room!");
			}
		}
		
		// check if room is checked in
		if(floor_room[this.floor][this.room] != null){
			
			System.out.println("Guest Name: " + floor_room[this.floor][this.room]);
			
			boolean isNotCon = true;
			while(isNotCon){
			System.out.print("Press 1 to comfirm or 0 to cancel!\t");
				int option = 0;
				if(in.hasNextInt()){
					option = in.nextInt();
					switch (option) {
					case 1:
						floor_room[this.floor][this.room] = null;
						System.out.println("\nCheckOut completed!");
						isCheckOut = true;
						break;
					case 0:
						System.out.println("\nCheckOut Cancel!");
						break;
					default:
						break;
					}
					
					isNotCon = false;
				}else{
					System.out.println("\nInvalid Option!");
				}
			}
		}else{
			System.out.println("\nThis room not checked in!");
			checkOutCount++;
			if(checkOutCount == 3){
				System.out.println("\nYou attemp to check out with the room that is not checked in 3 time, please try agian!");
				isCheckOut = false;
			}else{
				checkOut();
			}
			
		}
		
		return isCheckOut;
	}
	
	// display room
	public void display(){
		
		for(int i=0; i<floor_room.length; i++){
			System.out.print("Floor: " + i + "  ");
			
			for(int j=0; j<floor_room.length; j++){
				System.out.print(floor_room[i][j] + "\t");
			}
			
			System.out.println();
		}
	}
}
