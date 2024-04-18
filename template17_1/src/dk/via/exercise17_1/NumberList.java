package dk.via.exercise17_1;

import java.util.ArrayList;

public class NumberList {
    private final ArrayList<Double> elements;
    private double sum;

    public NumberList() {
        sum = 0;
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public double get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException("Out of bounds");
        return elements.get(index);
    }

    public double remove(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException("Out of bounds");
        Double removed = elements.remove(index);
        sum -= removed;
        return removed;
    }

    public double sum() {
        return sum;
    }

    public void add(double element) {
        this.elements.add(element);
        sum += element;
    }
}
