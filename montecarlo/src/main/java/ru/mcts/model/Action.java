package org.example.montecarlo.service;

import java.util.Arrays;

public class Action {
    private final double[] actionFeatures;

    public Action(double[] actionFeatures) {
        this.actionFeatures = actionFeatures;
    }

    public double[] getActionFeatures() {
        return actionFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Arrays.equals(actionFeatures, action.actionFeatures);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(actionFeatures);
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionFeatures=" + Arrays.toString(actionFeatures) +
                '}';
    }
}
