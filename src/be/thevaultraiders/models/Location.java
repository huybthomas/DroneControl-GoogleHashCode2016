package be.thevaultraiders.models;

/**
 * Created by stevendecleene on 11/02/16.
 */
public class Location {

    private int locX, locY;

    public Location(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;
    }

    public void setDestX(int locX) {
        this.locX = locX;
    }

    public int getDestX() {
        return locX;
    }

    public void setDestY(int locY) {
        this.locY = locY;
    }

    public int getDestY() {
        return locY;
    }

}
