package org.example.montecarlo.service;

import java.util.List;

public class DecisionPredictor {

    public Action predict(State state, List<Action> possibleActions) {
        //TODO implement mcts
        return possibleActions.get(0);
    }
}
