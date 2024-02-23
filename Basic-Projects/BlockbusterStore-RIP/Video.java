import java.util.ArrayList;
public class Video extends Rental
{
    private String director;
    private String description;
    private ArrayList<String> leadingActors;
    private int minutes;
    static final int G = 0;
    static final int PG = 1;
    static final int PG13 = 2;
    static final int R = 3;
    
    public Video(String title, double cost, int rating, String description, String director, ArrayList<String> leadingActors, int minutes)
    {
        super(title, cost, rating, false);
        this.description = description;
        this.director = director;
        this.leadingActors = leadingActors;
        this.minutes = minutes;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public ArrayList<String> getLeadingActors()
    {
        return leadingActors;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public String toString()
    {
        return director+", "+leadingActors+", "+minutes+", "+description;
    }
}
