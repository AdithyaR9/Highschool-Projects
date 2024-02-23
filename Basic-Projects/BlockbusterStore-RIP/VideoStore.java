import java.util.ArrayList; 

public class VideoStore
  {
    ArrayList<Rental> rentals = new ArrayList<Rental>();
    ArrayList<Video> vids = new ArrayList<Video>();
    ArrayList<Game> g = new ArrayList<Game>();
    public VideoStore()
    {
        ArrayList<String> vid1cast = new ArrayList<String>();
        vid1cast.add("Richard Petty, ");
        vid1cast.add("Owen Wilson, ");
        vid1cast.add("Michael Keaton, ");
        Video vid1 = new Video("Cars", 14.99, 0, "Mqueen Journey to get back on the track", "Bryan Singer", vid1cast, 117);

        ArrayList<String> vid2cast = new ArrayList<String>();
        vid2cast.add("Robert Downey Jr, ");
        vid2cast.add("Brie Larson, ");
        vid2cast.add("Chris Evans, ");
        vid2cast.add("Chris Hemsworth");
        Video vid2 = new Video("Avengers: Infinity War", 4.99, 2, "The Quest to kill Thanos", "Anthony Russo", vid2cast, 160 );

        ArrayList<String> vid3cast = new ArrayList<String>();
        vid3cast.add("Daniel Craig, ");
        vid3cast.add("Lea Seydoux, ");
        vid3cast.add("Christoph Waltz, ");
        vid3cast.add("Naomi Harris");
        Video vid3 = new Video("Spectre", 26.99, 2, "James Bond and his agentness", "Sam Mendes", vid3cast, 160 );

        ArrayList<String> vid4cast = new ArrayList<String>();
        vid4cast.add("Samuel L. Jackson, ");
        vid4cast.add("Lee Pace, ");
        vid4cast.add("Brie Larson, ");
        vid4cast.add("Jude law");
        Video vid4 = new Video("Captain Marvel", 17.99, 2, "Complete Letdown", "Anthony Russo, Joe Russo", vid4cast, 125 );
        
        Game g1 =  new Game("MineCraft", 7, 1, "PC, Xbox, Mobile", 8 );
        
        Game g2 = new Game("Call of Duty 4", 5, 3, "PC, Xbox, Playstation", 1);
        
        Game g3 = new Game("Super Mario Galaxy", 10, 1, "Wii,Nintendo ", 2 );
        
        Game g4 = new Game("Pong8", 2300, 5, "Atari", 2);
        
        
        rentals.add(vid1);
        rentals.add(vid2);
        rentals.add(vid3);
        rentals.add(vid4);
        rentals.add(g1);
        rentals.add(g2);
        rentals.add(g3);
        rentals.add(g4);
        vids.add(vid1);
        vids.add(vid2);
        vids.add(vid3);
        vids.add(vid4);
g.add(g1);
g.add(g2);
g.add(g3);
g.add(g4);

    }
    
    
    public ArrayList<Video> getVideos()
    {
        return vids;
    }
    
    public ArrayList<Game> getGames()
    {
        return g;
    }
    
    public ArrayList<Rental> getRented()
    {
        ArrayList<Rental> rented = new ArrayList<Rental>();
        for(int x = 0; x < rentals.size(); x++)
        {
            if(rentals.get(x).getRented() == true)
            {
                rented.add(rentals.get(x));
            }
        }
        
        return rented;
    }
    
    public void addRental(Rental r)
    {
        rentals.add(r);
    }
    
    public ArrayList<Game> gamesInStock()
    {
        ArrayList<Game> notRented = new ArrayList<Game>();
        for(int i = 0; i < g.size(); i++)
        {
        if(g.get(i).getRented() == false){
            notRented.add(g.get(i));
          }
         }
         
         return notRented;
     }
     
    public ArrayList<Video> videosInStock()
    {
        ArrayList<Video> notRented = new ArrayList<Video>();
        
        for(int i = 0; i < vids.size(); i++)
        {
            if(vids.get(i).getRented() == false)
            {
                notRented.add(vids.get(i));
            }
        }
        return notRented;
    }
}
