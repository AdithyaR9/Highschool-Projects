public class Rental
{
    private String title;
    private double cost;
    private int rating;
    private boolean rented;
    
    
    public Rental(String title, double cost, int rating, boolean rented)
    {
        this.cost = cost;
        this.title = title;
        this.rating = rating;
        rented = false;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public boolean getRented()
    {
        return rented;
    }
    
    public void setRented(boolean rented)
    {
        this.rented = rented;
    }
    
    public String toString()
    {
        return title+", "+cost;
    }
}
