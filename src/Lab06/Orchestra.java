package Lab06;
import java.util.Iterator;

/**
 * Name: Aditya Verma
 * Date: Mar 08, 2022
 * Description: Lab 06 "Building an Orchestra" Submission for CS321.
 */
public class Orchestra<T> implements Iterable<T> {

    Instruments[] instArray = new Instruments[6];
    int size = instArray.length;
    int currentIndex = 0;
    int counter = 0;
    int newSize;


    /**
     * Adds an instrument to the array, when array is full, array resizes by 1.5 times
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {

        int i;

        if (counter >= size) { //when array is full
            newSize = (int) (size + size * 0.5);

            Instruments[] newInstArray = new Instruments[newSize]; //creating new array 1.5 times original array
            for (int j = 0; j < size; j++) { // copying/adding instruments from original array into new array
                newInstArray[j] = instArray[j];
            }

            instArray = newInstArray; //assigning the new array ands its size to original array and its size
            size = newSize;
        }

        for (i = counter; i < counter + 1; i++) {   // adding instrument to instArray

            instArray[i] = instrument;
        }
        counter++; // keeping track of array index where instrument needs to be added

        currentIndex++; // used in hasNext() for the Iterator
    }

    /**
     * Overriding iterator
     */
    @Override
    public Iterator<T> iterator() {

        Iterator<T> iter = new Iterator<T>() {

            int currentIndexIter = 0;

            @Override
            public T next() {
                return (T) instArray[currentIndexIter++];
            }

            @Override
            public boolean hasNext() {
                return currentIndexIter < currentIndex;
            }

            //removes the instrument with appropriate array resizing
            @Override
            public void remove() {
                System.out.println("Size before remove: " + size);
                for (int i = 0; i < size; i++) {
                    if (instArray[i] == null) {    //checks for any null element value
                        newSize = size - 1;        //resizing
                        Instruments[] newInstruments = new Instruments[newSize];
                        for (int j = 0; j < newSize; j++) {
                            newInstruments[j] = instArray[j];
                        }
                        instArray = newInstruments;  //assigning the new array ands its size to original array and its size
                        size = newSize;
                    }
                }
                System.out.println("Current size is: " + size);
            }
        };
        return iter;
    }

    /**
     * Plays all instruments in orchestra
     *
     * @param orchestra
     */
    public void playAll(Orchestra orchestra) {

        Iterator<Instruments> iter = orchestra.iterator();

        while (iter.hasNext()) {
            iter.next().play();
        }
    }

    /**
     * Tunes all instruments in orchestra
     *
     * @param note
     */
    public void tuneAll(char note, Orchestra orchestra) {

        Iterator<Instruments> iter = orchestra.iterator();

        while (iter.hasNext()) {
            iter.next().tune(note);
        }
    }
}
