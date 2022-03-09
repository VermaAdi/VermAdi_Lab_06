package Lab06;

/**
 * Name: Aditya Verma
 * Date: Mar 08, 2022
 * Description: Lab 06 "Building an Orchestra" Submission for CS321.
 */
public class Viola implements Instruments {
    String song;
    String name;

    //Constructor for Viola Instrument
    public Viola(String song) {
        this.song = song;
        this.name = "Viola";
    }

    /**
     * Override toString method
     * Prints the name of the instrument
     */
    public String toString() {
        return this.name;
    }

    /**
     * Override play() method
     * From interface Instrument
     */
    @Override
    public void play() {
        System.out.println(this.name + " playing " + song);
    }

    /**
     * Override tune() method
     * From interface Instrument
     */
    @Override
    public void tune(char note) {
        System.out.println("Viola tuned to note: " + note);
    }
}
