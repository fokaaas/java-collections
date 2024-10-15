package com.stbasarab.collections;

import com.stbasarab.ElectricalAppliance;

import java.lang.reflect.Array;
import java.util.*;

public class ElectricalApplianceList implements List<ElectricalAppliance> {
    private final DoublyLinkedList<ElectricalAppliance> list;

    public ElectricalApplianceList() {
        this.list = new DoublyLinkedList<>();
    }

    public ElectricalApplianceList(ElectricalAppliance appliance) {
        this();
        add(appliance);
    }

    public ElectricalApplianceList(Collection<? extends ElectricalAppliance> collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<ElectricalAppliance> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size();
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++);
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            return (T[]) Array.newInstance(a.getClass().getComponentType(), size());
        }
        for (int i = 0; i < size(); i++) {
            a[i] = (T) list.get(i);
        }
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override
    public boolean add(ElectricalAppliance electricalAppliance){
        list.add(electricalAppliance);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends ElectricalAppliance> c) {
        for (ElectricalAppliance appliance : c) {
            add(appliance);
        }
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends ElectricalAppliance> c) {
        for (ElectricalAppliance appliance : c) {
            add(index++, appliance);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size(); i++) {
            if (!c.contains(list.get(i))) {
                remove(i--);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            list.remove(0);
        }
    }

    @Override
    public ElectricalAppliance get(int index) {
        return list.get(index);
    }

    @Override
    public ElectricalAppliance set(int index, ElectricalAppliance element) {
        ElectricalAppliance old = list.get(index);
        list.remove(index);
        list.add(index, element);
        return old;
    }

    @Override
    public void add(int index, ElectricalAppliance element) {
        this.list.add(index, element);
    }

    @Override
    public ElectricalAppliance remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (list.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<ElectricalAppliance> listIterator() {
        return new ListIterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size();
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++);
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public ElectricalAppliance previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No previous element.");
                return list.get(--currentIndex);
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove before the first next() call.");
                list.remove(--currentIndex);
            }

            @Override
            public void set(ElectricalAppliance e) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set before the first next() call.");
                list.set(currentIndex - 1, e);
            }

            @Override
            public void add(ElectricalAppliance e) {
                list.add(currentIndex++, e);
            }
        };
    }

    @Override
    public ListIterator<ElectricalAppliance> listIterator(int index) {
        return new ListIterator<>() {
            private int currentIndex = index;

            @Override
            public boolean hasNext() {
                return currentIndex < size();
            }

            @Override
            public ElectricalAppliance next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements to iterate.");
                return list.get(currentIndex++);
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public ElectricalAppliance previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No previous element.");
                return list.get(--currentIndex);
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove before the first next() call.");
                list.remove(--currentIndex);
            }

            @Override
            public void set(ElectricalAppliance e) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set before the first next() call.");
                list.set(currentIndex - 1, e);
            }

            @Override
            public void add(ElectricalAppliance e) {
                list.add(currentIndex++, e);
            }
        };
    }

    @Override
    public List<ElectricalAppliance> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid indices: fromIndex=" + fromIndex + ", toIndex=" + toIndex);
        }
        ElectricalApplianceList sublist = new ElectricalApplianceList();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(list.get(i));
        }
        return sublist;
    }
}
