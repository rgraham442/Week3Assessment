package BarrenMoor;

import java.util.Random;
import java.util.Scanner;

public class Adventure {
		
	//could add itemlocation as an arraylist later, focus functionality first
	private int itemNorth = 1;
	private int itemSouth = -1;
	private int itemEast = -1;
	private int itemWest = 1;
	
	//same with playerlocation
	private int playerNorth = 0;
	private int playerSouth = 0;
	private int playerEast = 0;
	private int playerWest = 0;
	
	
	private int end = 0;
	private String infoDump;
	
	public Adventure() {
		infoDump = "You awaken to find yourself in a barren moor. \n" +
		"Grey foggy clouds float oppressively close to you reflected in the murky grey water which reaches up your shins. \n" +
		"Some black plants barely poke out of the shallow water.\n" +
		"There's this nagging thought in your head, it seems to grow louder and louder as you stand there until it's a primal roar yelling inside your mind.\n" + 
		"\"LEAVE\"\n" + 
		"The word reverbarates through your skull, shaking you out of your stupor, you see a door a couple of metres ahead.";
	}
	
	public int getItemNorth() {
		return itemNorth;
	}

	public int getItemSouth() {
		return itemSouth;
	}

	public int getItemEast() {
		return itemEast;
	}

	public int getItemWest() {
		return itemWest;
	}
	
	
	public void action (String playerMove) {	
		
		String itemToPlayer;
		
		switch (playerMove) {
		case "north" : 
			playerNorth++;
			playerSouth--;
			
			//there MUST be a better way of getting the distance to a set location
			if (playerNorth < itemNorth) {
				itemToPlayer = "You know that you need to go north some more. \n" + (itemNorth - playerNorth) + "metres north the voice in your head is saying";
			}
			else if (playerNorth > itemNorth) {
				itemToPlayer = "...yeah, that's not the right way. \n" + (playerNorth - itemNorth) + " metres south the voice in your head is saying";
			}
			else {
				itemToPlayer = "STOP! it's straight ahead to your left...maybe your right?";
			}
			
			infoDump = "You move to the north. \n" + itemToPlayer;
			
		break;
		case "south" : 
			playerSouth++;
			playerNorth--;
			
			if (playerSouth < itemSouth) {
				itemToPlayer = "Yeah, you need to go south some more. \n" + (itemSouth - playerSouth) + " metres south the voice in your head is saying";
			}
			else if (playerSouth > itemSouth) {
				itemToPlayer = "...yeah, that's not the right way. \n" + (playerSouth - itemSouth) + " metres north the voice in your head is saying";
			}
			else {
				itemToPlayer = "STOP! it's straight ahead to the east...maybe the west?";
			}
			
			infoDump = "You move to the south. \n" + itemToPlayer;
			
		break;
		case "east" : 
			playerEast++;
			playerWest--;
			
			if (playerEast < itemEast) {
				itemToPlayer = "It might be a bit colder, but you gotta head east. \n" + (itemEast - playerEast) + " metres east the voice in your head is saying";
			}
			else if (playerEast > itemEast) {
				itemToPlayer = "...yeah, that's not the right way. \n" + (playerEast - itemEast) + " metres west the voice in your head is saying";
			}
			else {
				itemToPlayer = "STOP! it's straight ahead to the north...maybe the south?";
			}
			
			infoDump = "You move to the east.\n" + itemToPlayer;
			
		break;
		case "west" : 
			playerWest++;
			playerEast--;
			
			if (playerWest < itemWest) {
				itemToPlayer = "Bound for the western world. \n" + (itemWest - playerWest) + " metres west the voice in your head is saying";
			}
			else if (playerSouth > itemSouth) {
				itemToPlayer = "...yeah, that's not the right way. \n" + (playerWest - itemWest) + " metres east the voice in your head is saying";
			}
			else {
				itemToPlayer = "STOP! it's straight ahead to the north...maybe the south?";
			}
			
			infoDump = "You move to the west. \n" + itemToPlayer;
			
		break;
		case "look" :
			//randomise the description given on look command, is there a better way of doing this?
			int randomNum =  1 + (int)(Math.random() * 4);
			
			switch(randomNum) {
			case 1 :
				if (infoDump != "This place just feels off and wrong in so many different ways.") {
					infoDump = "This place just feels off and wrong in so many different ways.";
				}
				else {
					infoDump = "There's a faint smell of ash in the air, it gets stronger for a bit and then fades";
				}
			break;
			
			case 2 :
				if (infoDump != "Through the seemingly endless darkness, you think you catch sight of a creature scurrying about on mismatched legs.") {
					infoDump = "Through the seemingly endless darkness, you think you catch sight of a creature scurrying about on mismatched legs.";
				}
				else {
					infoDump = "The faint light that seems to follow you starts to hurt...maybe you shouldn't stare up into it";
				}
			break;
			
			case 3 :
				if (infoDump != "The inky black water coats your shoe, you look around and nowhere seems dry.") {
					infoDump = "The inky black water coats your shoe, you look around and nowhere seems dry.";
				}
				else {
					infoDump = "There's a flash of a new colour that lights up the endless expanse you are trapped within, "
							+ "you could never grasp the concept of said colour, but it gave you momentary reprieve from the monotonous landscape";
				}
			break;
			
			case 4 :
				if (infoDump != "This place is just silent, the only sounds are the squelches your feet make in the...water?.") {
					infoDump = "This place is just silent, the only sounds are the squelches your feet make in the...water?.";
				}
				else {
					infoDump = "As you look out at the ever widening expanse, you can't help but feel like you've entered a dark and dready new world";
				}
			break;
			
			}
		break;
		
		case "quit" : 
			//basic quit function added to save time on running through the game
			infoDump = "Quitting game";
			end++;
			
		break;
		
			
		default: 
			infoDump = "...You think about that, and no it doesn't make sense.";
		
		}
	}
	
	public void gameLoop() {
		System.out.println(infoDump);
		boolean stillPlaying = true;
		//Scanner is never closed resource leak, how to close the scanner? 
		Scanner sc = new Scanner(System.in);
		do {
			String userInput = sc.nextLine();
			itemDrop();
			action(userInput);
			System.out.println(infoDump);
			if (playerNorth == itemNorth && playerSouth == itemSouth && playerEast == itemEast && playerWest == itemWest) {
				System.out.println("Huh, how about that, you found a door, standing here all alone. \nYou get the feeling it leads to home \nYou Win!");
				stillPlaying = false;
			}
			
			if(end == 1) {
				stillPlaying = false;
			}
			
		}while(stillPlaying);	
	}
	
	public void itemDrop() {
		//trying to set the goal to appear at random on game start, only takes last case for some reason
		int randomNum =  1 + (int)(Math.random() * 5);
		
		switch(randomNum) {
		case 1 :
			itemNorth = 1;
			itemSouth = -1;
			itemEast = -1;
			itemWest = 1;
		case 2 :
			itemNorth = 4;
			itemSouth = -4;
			itemEast = 3;
			itemWest = -3;
		case 3 :
			itemNorth = -1;
			itemSouth = 1;
			itemEast = 5;
			itemWest = -5;
		case 4 :
			itemNorth = 2;
			itemSouth = -2;
			itemEast = -1;
			itemWest = 1;
		case 5 :
			itemNorth = -1;
			itemSouth = 1;
			itemEast = 0;
			itemWest = 0;	
		}
	}
	
	
	public int getPlayerNorth () {
		return playerNorth;
	}
	public int getPlayerSouth () {
		return playerSouth;
	}
	public int getPlayerEast () {
		return playerEast;
	}
	public int getPlayerWest () {
		return playerWest;
	}
	
	public String getInfoDump () {
		return infoDump;
	}
	
}
	


