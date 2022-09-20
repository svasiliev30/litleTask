package org.example.montecarlo.service;

import java.util.Arrays;

public class State {

    private final double[] features;

    public State(double[] features) {
        this.features = features;
    }

    public double[] getFeatures() {
        return features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Arrays.equals(features, state.features);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(features);
    }

    @Override
    public String toString() {
        return "State{" +
                "features=" + Arrays.toString(features) +
                '}';
    }
}
