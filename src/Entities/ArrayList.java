package Entities;import Interfaces.ListWithIteratorInterface;import java.util.Iterator;import java.util.NoSuchElementException;import java.util.Set;public class ArrayList<T> implements ListWithIteratorInterface<T> {  private T[] list; // array of list entries  private int numberOfEntries;  private static final int DEFAULT_INITIAL_CAPACITY = 25;  public ArrayList() {    this(DEFAULT_INITIAL_CAPACITY);  } // end default constructor  public ArrayList(int initialCapacity) {    numberOfEntries = 0;    // the cast is safe because the new array contains null entries    @SuppressWarnings("unchecked")    T[] tempList = (T[]) new Object[initialCapacity];    list = tempList;  } // end constructor  public Iterator<T> getIterator() {    return new IteratorForArrayList();  } // end getIterator  public boolean add(T newEntry) {    if (isArrayFull()) {      doubleArray();    }    list[numberOfEntries] = newEntry;    numberOfEntries++;    return true;  }  public boolean add(int newPosition, T newEntry) {    boolean isSuccessful = true;    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {      if (isArrayFull()) {        doubleArray();      }      makeRoom(newPosition);      list[newPosition - 1] = newEntry;      numberOfEntries++;    } else {      isSuccessful = false;    }    return isSuccessful;  }  public T remove(int givenPosition) {    T result = null;    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {      result = list[givenPosition - 1];      if (givenPosition < numberOfEntries) {        removeGap(givenPosition);      }      numberOfEntries--;    }    return result;  }  public void clear() {    numberOfEntries = 0;  }  @Override  public boolean replace(int givenPosition, T newEntry) {    boolean isSuccessful = true;    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {      list[givenPosition - 1] = newEntry;    } else {      isSuccessful = false;    }    return isSuccessful;  }  public T getEntry(int givenPosition) {    T result = null;    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {      result = list[givenPosition - 1];    }    return result;  }  public boolean contains(T anEntry) {    boolean found = false;    for (int index = 0; !found && (index < numberOfEntries); index++) {      if (anEntry.equals(list[index])) {        found = true;      }    }    return found;  }  @Override  public int size() {    return numberOfEntries;  }  public boolean isEmpty() {    return numberOfEntries == 0;  }  public boolean isFull() {    return false;  }  public String toString() {    String outputStr = "";    for (int index = 0; index < numberOfEntries; ++index) {      outputStr += list[index] + "\n";    }    return outputStr;  }  private boolean isArrayFull() {    return numberOfEntries == list.length;  }  /**   * Task: Doubles the size of the array of list entries.   */  private void doubleArray() {    T[] oldList = list; // save reference to array of list entries    int oldSize = oldList.length;     // save old max size of array    list = (T[]) new Object[2 * oldSize];    // double size of array    // copy entries from old array to new, bigger array    for (int index = 0; index < oldSize; index++) {      list[index] = oldList[index];    }  } // end doubleArray  /**   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=   * newPosition <= numberOfEntries + 1; numberOfEntries is list's   * numberOfEntries before addition.   */  private void makeRoom(int newPosition) {    int newIndex = newPosition - 1;    int lastIndex = numberOfEntries - 1;    // move each entry to next higher index, starting at end of    // list and continuing until the entry at newIndex is moved    for (int index = lastIndex; index >= newIndex; index--) {      list[index + 1] = list[index];    }  }  /**   * Task: Shifts entries that are beyond the entry to be removed to the next   * lower position. Precondition: list is not empty; 1 <= givenPosition <   * numberOfEntries; numberOfEntries is list's numberOfEntries before removal.   */  private void removeGap(int givenPosition) {    // move each entry to next lower position starting at entry after the    // one removed and continuing until end of list    int removedIndex = givenPosition - 1;    int lastIndex = numberOfEntries - 1;    for (int index = removedIndex; index < lastIndex; index++) {      list[index] = list[index + 1];    }  }  @Override  public T get(int index) {    T selectedIndex = null;    if (!isEmpty()) {      selectedIndex = list[index];    } // end if    return selectedIndex;  } //    public T addAll(Set<Item> findDuplicates) {//        ArrayList//        for(int i = 0; i < numberOfEntries; i++){//            findDuplicates[i];//        }//    }    //  < Segment 15.25 begins a description of the following inner class. >  private class IteratorForArrayList implements Iterator<T> {    private int nextIndex;    private boolean wasNextCalled; // needed by remove    private IteratorForArrayList() {      nextIndex = 0;      wasNextCalled = false;    } // end default constructor    //    < Implementations of the methods in the interface Iterator go here;    //      you can see them in Segments 15.26 through 15.28. >    //    . . .    @Override    public boolean hasNext() {      return nextIndex < numberOfEntries;    }    @Override    public T next() {      if (hasNext()) {        wasNextCalled = true;        T nextEntry = list[nextIndex];        nextIndex++; // advance iterator        return nextEntry;      } else {        throw new NoSuchElementException("Illegal call to next();"                + "iterator is after end of list.");      }    }    public void remove() {      if (wasNextCalled) {      // nextIndex was incremented by the call to next, so it         // is the position number of the entry to be removed        ArrayList.this.remove(nextIndex);        nextIndex--;           // index of next entry in iteration        wasNextCalled = false; // reset flag      } else {        throw new IllegalStateException("Illegal call to remove(); "                + "next() was not called.");      }    }  } // end IteratorForArrayList} // end ArrayList