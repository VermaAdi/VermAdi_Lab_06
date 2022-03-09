package Lab06;
import java.util.Iterator;

/**
 * Name: Aditya Verma
 * Date: Mar 08, 2022
 * Description: Lab 06 "Building an Orchestra" Submission for CS321.
 */
public class Main extends Orchestra {

    /**
     * Tests the functioning of the Orchestra and the GenOrchestra.
     *
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) {

        Instruments Trumpet = new Instruments() { //anonymous class for Trumpet
            @Override
            public void play() {
                System.out.println("Trum Trum Pet!");
            }

            @Override
            public void tune(char note) {
                System.out.println("Trumpet Tuned to note: " + note);
            }
        };

        System.out.println("\n---------------------------------------------------------");
        System.out.println("Anonymous Class Testing: ");
        Trumpet.tune('G');
        Trumpet.play();
        System.out.println("\n---------------------------------------------------------");


       // Orchestra
        Orchestra<Instruments> orchestra = new Orchestra<>();

        orchestra.addInstruments(new Cello("Symphony #1"));
        orchestra.addInstruments(new Cello("Symphony #3"));
        orchestra.addInstruments(new Viola("Sonata #1"));
        orchestra.addInstruments(new Viola("Wildest Dreams"));
        orchestra.addInstruments(new Tuba("All I Ask", 3));
        orchestra.addInstruments(new Cello("I Will Always Love You"));
        orchestra.addInstruments(new Viola("Fly"));

        // Gen Orchestra
        GenOrchestra<Instruments> genOrchestra = new GenOrchestra<>();

        genOrchestra.addInstruments(new Cello("Symphony #1"));
        genOrchestra.addInstruments(new Cello("Symphony #3"));
        genOrchestra.addInstruments(new Viola("Sonata #1"));
        genOrchestra.addInstruments(new Viola("Wildest Dreams"));
        genOrchestra.addInstruments(new Tuba("All I Ask", 3));
        genOrchestra.addInstruments(new Cello("I Will Always Love You"));
        genOrchestra.addInstruments(new Viola("Fly"));

        Iterator<Instruments> iter1 = orchestra.iterator();

        System.out.println("\nTesting remove() method");

        //After adding the 7th instrument and removing ending NULL, final array size should be 7.
        iter1.remove();

        // Printing all instruments in Orchestra
        System.out.println("\n---------------------------------------------------------");
        System.out.println("\nAll Instruments in Orchestra: ");
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + ", ");
        }
        System.out.println("\n---------------------------------------------------------");

        System.out.println("\nTuning all instruments: ");
        orchestra.tuneAll('D', orchestra);
        System.out.println("\n---------------------------------------------------------");

        System.out.println("\nAll instruments play songs: ");
        orchestra.playAll(orchestra);
        System.out.println("\n---------------------------------------------------------");

        Iterator<Instruments> iter2 = genOrchestra.iterator();

        // Printing all instruments in Gen Orchestra
        System.out.println("\nAll Instruments in Gen Orchestra: ");
        while (iter2.hasNext()) {
            System.out.print(iter2.next() + ", ");
        }
        System.out.println("\n---------------------------------------------------------");


        System.out.println("\nTuning all instruments: ");
        genOrchestra.tuneAll('C', genOrchestra);
        System.out.println("\n---------------------------------------------------------");

        System.out.println("\nAll instruments play songs: ");
        genOrchestra.playAll(genOrchestra);
        System.out.println("\n---------------------------------------------------------");

        System.out.println("\nPlaying and Tuning other Instruments:");
        Tuba tuba = new Tuba("Circle of Life", 3);
        Tuba tuba2 = new Tuba("Circle of Life", 5);

        Cello cello  = new Cello("Pirates of the Caribbean");
        Viola viola = new Viola("Sadness and Sorrow");
        tuba.tune('A');
        tuba2.tune('A');
        tuba.play();
        tuba2.play();
        cello.tune('D');
        cello.play();
        viola.tune('F');
        viola.play();
        System.out.println("\n---------------------------------------------------------");

    }
}
