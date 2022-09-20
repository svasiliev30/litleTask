package ru.mcts.model;

import ru.mcts.algo.ProcessStatusResolver;

import java.util.Arrays;

public class State {

    private final double[] features;
    private final ProcessStatusResolver winDetector;

    public State(double[] features, ProcessStatusResolver winDetector) {
        this.features = features;
        this.winDetector = winDetector;
    }

    public double[] getFeatures() {
        return features;
    }

    public ProcessStatusResolver getWinDetector() {
        return winDetector;
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
