package com.esprit.gestionfoyer.entities;

public enum TypeChambre {
    SIMPLE(1), DOUBLE(2), TRIPLE(3);

    private final int capacity;

    TypeChambre(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}