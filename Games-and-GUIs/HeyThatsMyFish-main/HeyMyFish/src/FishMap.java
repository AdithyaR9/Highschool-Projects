
public class FishMap {

    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 10;
    public int threeFish = 10;
    public int twoFish = 20;
    public int oneFish = 30;


    private FishSquare[][] grid = new FishSquare[NUM_ROWS][NUM_COLUMNS];

    public FishMap() {
        createMap();
        placeFish();
    }

    public void createMap() {

        for (int x = 0; x < NUM_ROWS; x++) {
            for (int y = 0; y < NUM_COLUMNS; y++) {
                grid[x][y] = new FishSquare();
            }
        }
    }

    public void placeFish() {

        //places one fish

        for (int x = 0; x < oneFish; x++) {

            int oneR = (int) (Math.random() * NUM_ROWS);
            int oneC = (int) (Math.random() * NUM_COLUMNS);

            if (grid[oneR][oneC].getOneFish()) {
                while (grid[oneR][oneC].getOneFish()) {

                    oneR = (int) (Math.random() * NUM_ROWS);
                    oneC = (int) (Math.random() * NUM_COLUMNS);

                }
            }
            grid[oneR][oneC].setOneFish(true);
        }

        //places two fish

        for (int x = 0; x < twoFish; x++) {

            int twoR = (int) (Math.random() * NUM_ROWS);
            int twoC = (int) (Math.random() * NUM_COLUMNS);

            if (grid[twoR][twoC].getOneFish() || grid[twoR][twoC].getTwoFish()) {
                while (grid[twoR][twoC].getOneFish() || grid[twoR][twoC].getTwoFish()) {

                    twoR = (int) (Math.random() * NUM_ROWS);
                    twoC = (int) (Math.random() * NUM_COLUMNS);

                }
            }
            grid[twoR][twoC].setTwoFish(true);
        }

        //places three fish

        for (int x = 0; x < threeFish; x++) {

            int threeR = (int) (Math.random() * NUM_ROWS);
            int threeC = (int) (Math.random() * NUM_COLUMNS);

            if (grid[threeR][threeC].getOneFish() || grid[threeR][threeC].getTwoFish() || grid[threeR][threeC].getThreeFish()) {
                while (grid[threeR][threeC].getOneFish() || grid[threeR][threeC].getTwoFish() || grid[threeR][threeC].getThreeFish()) {

                    threeR = (int) (Math.random() * NUM_ROWS);
                    threeC = (int) (Math.random() * NUM_COLUMNS);

                }
            }
            grid[threeR][threeC].setThreeFish(true);
        }

    }

    public FishSquare getSquare(int col, int row) {

        if ((row < NUM_ROWS && row >= 0) && (col < NUM_COLUMNS && col >= 0)) {
            return grid[row][col];
        }
        return null;

    }



    public String toString() {

        String toString = "";

        for (int y = 0; y < NUM_ROWS; y++) {
            for (int x = 0; x < NUM_COLUMNS; x++) {
                toString += grid[y][x].toString();
            }
            toString += "\n";
        }
        return toString + "\n";

    }

}
