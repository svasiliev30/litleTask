package ru.mcts.algo;

import ru.mcts.model.ProcessStatus;
import ru.mcts.model.State;

public interface ProcessStatusResolver {
     ProcessStatus resolveProcessStatus(State state);
}
