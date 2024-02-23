import java.util.*;
public class Main 

{
    public static void main(String[] args) 
    {
        VideoStore store = new VideoStore();
        Scanner k = new Scanner(System.in);
        System.out.println("---Blockbuster Store---");
        ArrayList<Rental> c = new ArrayList<Rental>();
        int x = 0;
        do 
        {
            System.out.println("\n\n--Renting menu--");
            System.out.println("1.Rent a video\n2.Rent a game\n3.Checkout\nChoose ");
            int choice = k.nextInt();
            if (choice == 1) 
            {
                for(int i = 0; i < store.getVideos().size(); i++)
                {
                    System.out.println((i + 1) + ". " + store.getVideos().get(i).getTitle());
                    
                }
                System.out.println("0. Cancel\nEnter an option");
                int enter = k.nextInt();
                if (enter == 1)
                {
                    System.out.println("Title: "+ store.getVideos().get(0).getTitle());
                    System.out.println("Rating: " + store.getVideos().get(0).getRating());
                    System.out.println("Cost: " + store.getVideos().get(0).getCost());
                    System.out.println("Director: " + store.getVideos().get(0).getDirector());
                    System.out.println("Leading Actors: " + store.getVideos().get(0).getLeadingActors());
                    System.out.println("Runtime: " + store.getVideos().get(0).getMinutes());
                    System.out.println("Description: " + store.getVideos().get(0).getDescription());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1)
                    {
                        c.add(store.getVideos().get(0));
                    } else if (r == 2){
                        continue;
                    }
                } else if (enter == 2) {
                    System.out.println("Title: "+ store.getVideos().get(1).getTitle());
                    System.out.println("Rating: " + store.getVideos().get(1).getRating());
                    System.out.println("Cost: " + store.getVideos().get(1).getCost());
                    System.out.println("Director: " + store.getVideos().get(1).getDirector());
                    System.out.println("Leading Actors: " + store.getVideos().get(1).getLeadingActors());
                    System.out.println("Runtime: " + store.getVideos().get(1).getMinutes());
                    System.out.println("Description: " + store.getVideos().get(1).getDescription());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1)
                    {
                        c.add(store.getVideos().get(1));
                    } else if (r == 2){
                        continue;
                    }
                } else if (enter == 3) {
                    System.out.println("Title: "+ store.getVideos().get(2).getTitle());
                    System.out.println("Rating: " + store.getVideos().get(2).getRating());
                    System.out.println("Cost: " + store.getVideos().get(2).getCost());
                    System.out.println("Director: " + store.getVideos().get(2).getDirector());
                    System.out.println("Leading Actors: " + store.getVideos().get(2).getLeadingActors());
                    System.out.println("Runtime: " + store.getVideos().get(2).getMinutes());
                    System.out.println("Description: " + store.getVideos().get(2).getDescription());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1)
                    {
                        c.add(store.getVideos().get(2));
                    } else if (r == 2){
                        continue;
                    }
                } else if (enter == 4) {
                    System.out.println("Title: "+ store.getVideos().get(3).getTitle());
                    System.out.println("Rating: " + store.getVideos().get(3).getRating());
                    System.out.println("Cost: " + store.getVideos().get(3).getCost());
                    System.out.println("Director: " + store.getVideos().get(3).getDirector());
                    System.out.println("Leading Actors: " + store.getVideos().get(3).getLeadingActors());
                    System.out.println("Runtime: " + store.getVideos().get(3).getMinutes());
                    System.out.println("Description: " + store.getVideos().get(3).getDescription());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1)
                    {
                        c.add(store.getVideos().get(3));
                    } else if (r == 2){
                        continue;
                    }
                }
            }
            else if (choice == 2)
            {
                System.out.println("\n\n--Game Menu--");
                for (int i = 0; i < store.getGames().size(); i++)
                {
                    System.out.println((i + 1) + ". " + store.getGames().get(i).getTitle());
                }
                System.out.println("0. Cancel");
                int enter = k.nextInt();
                if (enter == 1)
                {
                    System.out.println("Title: " + store.getGames().get(0).getTitle());
                    System.out.println("Rating: " + store.getGames().get(0).getRating());
                    System.out.println("Cost: " + store.getGames().get(0).getCost());
                    System.out.println("Platform: " + store.getGames().get(0).getPlatform());
                    System.out.println("Number Of Players: " +store.getGames().get(0).getNumberOfPlayers());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1) {
                        c.add(store.getGames().get(0));
                    } else if (r == 2) {
                        continue;
                    }
                } else if (enter == 2) {
                    System.out.println("Title: " + store.getGames().get(1).getTitle());
                    System.out.println("Rating: " + store.getGames().get(1).getRating());
                    System.out.println("Cost: " + store.getGames().get(1).getCost());
                    System.out.println("Platform: " + store.getGames().get(1).getPlatform());
                    System.out.println("Number Of Players: " +store.getGames().get(1).getNumberOfPlayers());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1) {
                        c.add(store.getGames().get(1));
                    } else if (r == 2) {
                        continue;
                    }
                } else if (enter == 3) {
                    System.out.println("Title: " + store.getGames().get(2).getTitle());
                    System.out.println("Rating: " + store.getGames().get(2).getRating());
                    System.out.println("Cost: " + store.getGames().get(2).getCost());
                    System.out.println("Platform: " + store.getGames().get(2).getPlatform());
                    System.out.println("Number Of Players: " +store.getGames().get(2).getNumberOfPlayers());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1) {
                        c.add(store.getGames().get(2));
                    } else if (r == 2) {
                        continue;
                    }
                } else if (enter == 4) {
                    System.out.println("Title: " + store.getGames().get(3).getTitle());
                    System.out.println("Rating: " + store.getGames().get(3).getRating());
                    System.out.println("Cost: " + store.getGames().get(3).getCost());
                    System.out.println("Platform: " + store.getGames().get(3).getPlatform());
                    System.out.println("Number Of Players: " +store.getGames().get(3).getNumberOfPlayers());
                    
                    System.out.println("\n\n1. Rent\n2. Put Back");
                    int r = k.nextInt();
                    if (r == 1) {
                        c.add(store.getGames().get(3));
                    } else if (r == 2) {
                        continue;
                    }
                }
            } 
            else if (choice == 3) 
            {
                if (c.size() == 0) 
                {
                    System.out.println("You didn't get anything!");
                    System.out.println("See ya!");
                    break;
                }
                else
                {
                    int i = 0;
                    double y = 0;
                    do 
                    {
                        System.out.println(c.get(i).getTitle());
                        System.out.println("Price: " + c.get(i).getCost());
                        y += c.get(i).getCost();
                        i++;
                    } while(i < c.size());
                    System.out.printf("Subtotal: $%.2f",y);
                    System.out.println();
                    System.out.printf("Tax: $%.2f", (y * .0875));
                    System.out.println();
                    System.out.printf("Total: $%.2f", (y * 1.0875));
                    System.out.println();
                    System.out.printf("See ya!");
                    break;
                }
            }
        } while (true);
    }
}