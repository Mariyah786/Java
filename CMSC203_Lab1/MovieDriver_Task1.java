package Lab1;

import java.util.Scanner;

public class MovieDriver_Task1 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Movie one = new Movie();
		System.out.println("Enter the name of a movie");
		String title = keyboard.next();
		one.setTitle(title);
		System.out.println("Enter the rating of the movie ");
		String rating = keyboard.next();
		one.setRating(rating);
		System.out.println("Enter the number of tickets sold for this movie ");
		int ticketsSold = keyboard.nextInt();
		one.setSoldTickets(ticketsSold);
		System.out.println("Movie Details: " + one.toString());
		

		
	}
}
