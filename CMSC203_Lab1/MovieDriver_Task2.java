package Lab1;

import java.util.Scanner;

public class MovieDriver_Task2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String anotherMovie;

        do {
            Movie one = new Movie();
            System.out.println("Enter the name of a movie: ");
            String title = keyboard.nextLine();
            one.setTitle(title);

            System.out.println("Enter the rating of the movie: ");
            String rating = keyboard.nextLine();
            one.setRating(rating);

            System.out.println("Enter the number of tickets sold for this movie: ");
            int ticketsSold = keyboard.nextInt();
            one.setSoldTickets(ticketsSold);
            // Consume the remaining newline character
            keyboard.nextLine();

            System.out.println("Movie Details: " + one.toString());

            System.out.println("Do you want to enter another movie? yes/no ");
            anotherMovie = keyboard.nextLine();
        } while (anotherMovie.equalsIgnoreCase("yes"));

        keyboard.close();
    }
}


