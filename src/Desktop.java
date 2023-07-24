/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Desktop PC Class
 */

public class Desktop extends Computer {

    public Desktop() {

    }

    public Desktop(String line) {
        String[] data = line.split(",");
        setCategory(data[0]);
        setType(data[1]);
        setId(data[2]);
        setBrand(data[3]);
        setCpu(data[4]);
        setMemory(data[5]);
        setSsd(data[6]);
        setPrice(data[7]);
    }
}
