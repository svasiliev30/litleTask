package ru.mcts.algo;

import ru.mcts.model.Action;
import ru.mcts.model.State;

import java.util.List;

public interface ActionSelector {
    List<Action> selectPossibleActionsForCurrentState(State state, List<Action> actions);
}
