package Lab06;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Name: Aditya Verma
 * Date: Mar 08, 2022
 * Description: Lab 06 "Building an Orchestra" Submission for CS321.
 */
public class GenOrchestra<T> implements Iterable<T> {

    ArrayList<Instruments> instrumentsList = new ArrayList<>();
    int currentIndex = 0;

    /**
     * Adds an instrument to the array
     * No resizing needed since ArrayList is a dynamic data structure
     *
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {
        instrumentsList.add(instrument); //adds instrument to the array list.
        currentIndex++;
    }

    /**
     * Overriding iterator
     */
    @Override
    public Iterator<T> iterator() {

        Iterator<T> iter = new Iterator<T>() {

            int currentIndexIter = 0;

            @Override
            public boolean hasNext() {

                return currentIndexIter < currentIndex;

            }

            @Override
            public T next() {

                return (T) instrumentsList.get(currentIndexIter++);
            }

        };
        return iter;
    }

    /**
     * Plays all instruments in orchestra
     *
     * @param genOrchestra
     */
    public void playAll(GenOrchestra genOrchestra) {
        Iterator<Instruments> iter = genOrchestra.iterator();
        while (iter.hasNext()) {
            iter.next().play();
        }
    }

    /**
     * Tunes all instruments in orchestra
     *
     * @param note
     */
    public void tuneAll(char note, GenOrchestra genOrchestra) {
        Iterator<Instruments> iter = genOrchestra.iterator();
        while (iter.hasNext()) {
            iter.next().tune(note);
        }
    }
}
