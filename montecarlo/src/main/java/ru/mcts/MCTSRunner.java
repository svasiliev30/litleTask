package ru.mcts;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mcts.algo.DecisionPredictor;
import ru.mcts.model.ProcessStatus;
import ru.mcts.model.Action;
import ru.mcts.model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.mcts.model.Status.*;

@SpringBootApplication
public class MCTSRunner {

    public static void main(String[] args) {
        double[] features = new double[3];
        features[0] = 0; //чей ход
        features[1] = 167; //номер последнего хода
        features[2] = 0; //чем ты играешь 0 -0 ; 1- x

        features[3] = 166;
        features[4] = 167;

        State state = new State(features, s -> {
            int r = new Random().nextInt(100);
            if (r > 20) return new ProcessStatus(NOT_FINISHED, 0);
            if (r < 10) return new ProcessStatus(WIN, 1);
            return new ProcessStatus(LOSE, 0);
        });
        List<Action> possibleActions = new ArrayList<>();
        for (int i = 0; i < 255; i++) {
            double[] actionFeatures = {i};
            possibleActions.add(new Action(actionFeatures));
        }
        DecisionPredictor decisionPredictor = new DecisionPredictor();
        Action predictedAction = decisionPredictor.predict(state, possibleActions, MCTSRunner::getPossibleActions);
        System.out.println(predictedAction);

    }

    private static ArrayList<Action> getPossibleActions(State s, List<Action> actions) {
        double[] stateFeatures = s.getFeatures();
        ArrayList<Action> res = new ArrayList<>(actions);
        for (int i = 3; i < stateFeatures.length; i++) {
            res.remove(i);
        }
        return res;
    }
}
