package com.stbasarab.collections;

import com.stbasarab.ElectricalAppliance;

import java.lang.reflect.Array;
import java.util.*;

/**
 * ElectricalApplianceList is a custom implementation of the List interface
 * that stores ElectricalAppliance objects using a doubly linked list.
 * This class provides various methods for manipulating the list of appliances.
 */
public class ElectricalApplianceList implements List<ElectricalAppliance> {
    private final DoublyLinkedList<ElectricalAppliance> list; // Underlying doubly linked list

    /**
     * Constructs an empty ElectricalApplianceList.
     */
    public ElectricalApplianceList() {
        this.list = new DoublyLinkedList<>();
    }

    /**
     * Constructs an ElectricalApplianceList containing a single appliance.
     *
     * @param appliance The ElectricalAppliance to add to the list.
     */
    public ElectricalApplianceList(ElectricalAppliance appliance) {
        this();
        add(appliance);
    }

    /**
     * Constructs an ElectricalApplianceList containing the elements
     * of the specified collection.
     *
     * @param collection The collection of ElectricalAppliance to add.
     */
    public ElectricalApplianceList(Collection<? extends ElectricalAppliance> collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public int size() {
        return list.getSize(); // Returns the size of the list
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0; // Checks if the list is empty
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o); // Checks if the list contains the specified object
    }

    @Override
    public Iterator<ElectricalAppliance> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Checks if there are more elements
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++); // Returns the next element
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = list.get(i); // Populates the array with elements from the list
        }
        return array; // Returns the populated array
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            return (T[]) Array.newInstance(a.getClass().getComponentType(), size()); // Creates a new array if the provided one is too small
        }
        for (int i = 0; i < size(); i++) {
            a[i] = (T) list.get(i); // Populates the provided array with elements
        }
        if (a.length > size()) {
            a[size()] = null; // Null-terminate the array if it's larger than the list
        }
        return a; // Returns the populated array
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(ElectricalAppliance electricalAppliance) {
        list.add(electricalAppliance); // Adds an ElectricalAppliance to the list
        return true; // Always returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) {
                list.remove(i); // Removes the element if found
                return true; // Returns true if an element was removed
            }
        }
        return false; // Returns false if no element was found
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!this.contains(item)) {
                return false; // Checks if all items in the collection are contained in the list
            }
        }
        return true; // Returns true if all items are found
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends ElectricalAppliance> c) {
        for (ElectricalAppliance appliance : c) {
            add(appliance); // Adds each appliance from the collection
        }
        return true; // Returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends ElectricalAppliance> c) {
        for (ElectricalAppliance appliance : c) {
            add(index++, appliance); // Adds each appliance at the specified index
        }
        return true; // Returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true; // Marks the list as modified if any elements were removed
            }
        }
        return modified; // Returns true if any changes were made
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size(); i++) {
            if (!c.contains(list.get(i))) {
                remove(i--); // Removes elements not in the specified collection
                modified = true; // Marks the list as modified
            }
        }
        return modified; // Returns true if any changes were made
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            list.remove(0); // Removes all elements from the list
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElectricalAppliance get(int index) {
        return list.get(index); // Returns the element at the specified index
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElectricalAppliance set(int index, ElectricalAppliance element) {
        ElectricalAppliance old = list.get(index);
        list.remove(index);
        list.add(index, element); // Replaces the element at the specified index
        return old; // Returns the old element that was replaced
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, ElectricalAppliance element) {
        this.list.add(index, element); // Adds an element at the specified index
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElectricalAppliance remove(int index) {
        return list.remove(index); // Removes the element at the specified index
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) {
                return i; // Returns the index of the specified object
            }
        }
        return -1; // Returns -1 if the object is not found
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (list.get(i).equals(o)) {
                return i; // Returns the last index of the specified object
            }
        }
        return -1; // Returns -1 if the object is not found
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<ElectricalAppliance> listIterator() {
        return new ListIterator<>() {
            private int currentIndex = 0; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Checks if there are more elements
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++); // Returns the next element
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0; // Checks if there is a previous element
            }

            @Override
            public ElectricalAppliance previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No previous element.");
                return list.get(--currentIndex); // Returns the previous element
            }

            @Override
            public int nextIndex() {
                return currentIndex; // Returns the index of the next element
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1; // Returns the index of the previous element
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove before the first next() call.");
                list.remove(--currentIndex); // Removes the last returned element
            }

            @Override
            public void set(ElectricalAppliance e) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set before the first next() call.");
                list.set(currentIndex - 1, e); // Replaces the last returned element
            }

            @Override
            public void add(ElectricalAppliance e) {
                list.add(currentIndex++, e); // Inserts the specified element into the list
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<ElectricalAppliance> listIterator(int index) {
        return new ListIterator<>() {
            private int currentIndex = index; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Checks if there are more elements
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++); // Returns the next element
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0; // Checks if there is a previous element
            }

            @Override
            public ElectricalAppliance previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No previous element.");
                return list.get(--currentIndex); // Returns the previous element
            }

            @Override
            public int nextIndex() {
                return currentIndex; // Returns the index of the next element
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1; // Returns the index of the previous element
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove before the first next() call.");
                list.remove(--currentIndex); // Removes the last returned element
            }

            @Override
            public void set(ElectricalAppliance e) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set before the first next() call.");
                list.set(currentIndex - 1, e); // Replaces the last returned element
            }

            @Override
            public void add(ElectricalAppliance e) {
                list.add(currentIndex++, e); // Inserts the specified element into the list
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ElectricalAppliance> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid indices: fromIndex=" + fromIndex + ", toIndex=" + toIndex);
        }
        ElectricalApplianceList sublist = new ElectricalApplianceList();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(list.get(i)); // Creates a sublist from the specified range
        }
        return sublist; // Returns the created sublist
    }
}