/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Laptop Class
 */

public class Laptop extends Computer{

    public Laptop() {

    }

    public Laptop(String line) {
        String[] data = line.split(",");
        setCategory(data[0]);
        setType(data[1]);
        setId(data[2]);
        setBrand(data[3]);
        setCpu(data[4]);
        setMemory(data[5]);
        setSsd(data[6]);
        setScreenSize(data[7]);
        setPrice(data[8]);
    }
}
