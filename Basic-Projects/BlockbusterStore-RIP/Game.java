public class Game extends Rental
{
    private String platform;
    private int numberOfPlayers;
    
    static final int G = 0;
    static final int EVERYONE = 1;
    static final int EVERYONE_TEN_PLUS = 2;
    static final int TEEN = 3;
    static final int MATURE = 4;
    static final int ADULTS_ONLY = 5;
    static final int RATING_PENDING = 6;
    
    public Game(String title, double cost, int rating, String platform, int numberOfPlayers)
    {
        super(title, cost, rating, false);
        this.platform = platform;
        this.numberOfPlayers = numberOfPlayers;
    }
    
    public String getPlatform()
    {
        return platform;
    }
    
    public int getNumberOfPlayers()
    {
        return numberOfPlayers;
    }
    
    public String toString()
    {
        return platform+", "+numberOfPlayers;
    }
}
