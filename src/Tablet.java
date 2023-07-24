/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Tablet Class
 */

public class Tablet extends Computer {

    public Tablet() {

    }

    public Tablet(String line) {
        String[] data = line.split(",");
        setCategory(data[0]);
        setType(data[1]);
        setId(data[2]);
        setBrand(data[3]);
        setCpu(data[4]);
        setScreenSize(data[5]);
        setPrice(data[6]);
    }
}
