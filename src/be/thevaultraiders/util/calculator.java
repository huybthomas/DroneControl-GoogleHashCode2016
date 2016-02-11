package be.thevaultraiders.util;

/**
 * Created by stevendecleene on 11/02/16.
 */
public final class calculator {

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

}
