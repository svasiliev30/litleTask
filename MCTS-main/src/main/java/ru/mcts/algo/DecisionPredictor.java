package ru.mcts.algo;

import ru.mcts.model.Action;
import ru.mcts.model.State;

import java.util.List;

public class DecisionPredictor {

    public Action predict(State state, List<Action> possibleActions, ActionSelector actionSelector) {
        //TODO implement mcts
        return possibleActions.get(0);
    }
}
