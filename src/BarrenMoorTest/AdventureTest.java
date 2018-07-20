package BarrenMoorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import BarrenMoor.Adventure;

public class AdventureTest {
	
	@Test
	public void adventureConstructorTest () {
		Adventure play = new Adventure();
		assertNotNull("No adventure was constructed", play);
	}
	
	@Test
	public void adventureItemLocationTest () {
		Adventure play = new Adventure();
		assertEquals("North wasn't set for the item", play.getItemNorth(),1);
		assertEquals("South wasn't found for the item", play.getItemSouth(),0);
		assertEquals("East wasn't found for the item", play.getItemEast(),0);
		assertEquals("West wasn't set for the item", play.getItemWest(),1);
	}
	
	@Test 
	public void adventurePlayerMoveTest () {
		Adventure play = new Adventure();
		
		play.action("flangle");
		assertEquals("infodump returned incorrectly", play.getInfoDump(),"...You think about that, and no it doesn't make sense.");
		
		play.action("north");
		assertEquals("Player did not move north", play.getPlayerNorth(),1);
		assertEquals("Player did not move north", play.getPlayerSouth(),-1);
		
		play.action("east");
		assertEquals("Player did not move east", play.getPlayerEast(),1);
		assertEquals("Player did not move east", play.getPlayerWest(),-1);
		
		play.action("south");
		assertEquals("Player did not move south", play.getPlayerSouth(),0);
		assertEquals("Player did not move south", play.getPlayerNorth(),0);
		
		play.action("west");
		assertEquals("Player did not move west", play.getPlayerWest(),0);
		assertEquals("Player did not move west", play.getPlayerEast(),0);
		
		//Had this set up to return a changed infoDump, when I changed the look command to use a random number, I did not know how to test that
		/*
		play.action("look");
		assertEquals("infoDump returned incorrectly", play.getInfoDump(),"Grey foggy clouds float oppressively close to you reflected in the murky grey water which reaches up your shins. \nSome black plants barely poke out of the shallow water.");
		*/
		
		
		play.action("quit");
		assertNull("Thegame did not terminate", play);
		
	}
	
	@Test
	public void infoDumpTest () {
		Adventure play = new Adventure();
		String start = "You awaken to find yourself in a barren moor. \n" +
				"Grey foggy clouds float oppressively close to you reflected in the murky grey water which reaches up your shins. \n" +
				"Some black plants barely poke out of the shallow water.\n" +
				"There's this nagging thought in your head, it seems to grow louder and louder as you stand there until it's a primal roar yelling inside your mind.\n" + 
				"\"LEAVE\"\n" + 
				"The word reverbarates through your skull, shaking you out of your stupor, you see a door a couple of metres ahead.";
		
		assertEquals("infodump returned incorrectly", play.getInfoDump(),start);	
	}
	
	
	

}
