package dk.via.exercise18_2;

import java.util.ArrayList;

public class NumberList {
    private final ArrayList<Double> elements;
    private double sum;
    private double closestToZero;

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

    public double closestToZero() {
        if (elements.isEmpty()) throw new IllegalStateException("No elements");
        double closest = elements.get(0);
        for(int i = 1; i < size(); i++) {
            if (Math.abs(elements.get(i)) < Math.abs(closest)) closest = elements.get(i);
        }
        return closest;
    }
}
