

public class FishSquare {

    private boolean oneFish;
    private boolean twoFish;
    private boolean threeFish;
    private boolean orangePenguin;
    private boolean yellowPenguin;
    private boolean collected;
    private boolean selected;

    public FishSquare() {

        oneFish = false;
        twoFish = false;
        threeFish = false;
        orangePenguin = false;
        yellowPenguin = false;
        collected = false;
        selected = false;

    }

    // accessors/getters


    public boolean getCollected() {
        return collected;
    }

    public boolean getOneFish() {
        return oneFish;
    }

    public boolean getTwoFish() {
        return twoFish;
    }

    public boolean getThreeFish() {
        return threeFish;
    }

    public boolean getOrangePenguin() {
        return orangePenguin;
    }

    public boolean getYellowPenguin() {
        return yellowPenguin;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean a) {
        selected = a;
    }


    //mutators/setters


    public void setCollected(boolean a) {
        collected = a;
    }

    public void setOneFish(boolean a) {
        oneFish = a;
    }

    public void setTwoFish(boolean a) {
        twoFish = a;
    }

    public void setThreeFish(boolean a) {
        threeFish = a;
    }

    public void setOrangePenguin(boolean a) {
        orangePenguin = a;
    }

    public void setYellowPenguin(boolean a) {
        yellowPenguin = a;
    }

    public String toString() {

        // oneFish = 1
        // twoFish = 2
        // threeFish = 3
        // Collected/EmptySpace = E

        if (oneFish)
            return "1";
        if (twoFish)
            return "2";
        if (threeFish)
            return "3";
        else return "E";

    }
}

