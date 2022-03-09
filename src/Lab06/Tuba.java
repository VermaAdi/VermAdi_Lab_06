package Lab06;

/**
 * Name: Aditya Verma
 * Date: Mar 08, 2022
 * Description: Lab 06 "Building an Orchestra" Submission for CS321.
 */
public class Tuba implements Instruments {
    String song;
    String name;
    int repeatMel;

    //Constructor for Tuba Instrument
    public Tuba(String song, int repeatMelody) {
        this.song = song;
        this.name = "Tuba";
        this.repeatMel = repeatMelody;

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
        System.out.print(this.name + " playing " + song);
        for (int i = 0; i < repeatMel; i++) {
            System.out.print(" oom pa pa ");
        }
        System.out.println();
    }

    /**
     * Override tune() method
     * From interface Instrument
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuba tuned to note: " + note);
    }
}
