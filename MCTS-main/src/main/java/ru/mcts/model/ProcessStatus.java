package ru.mcts.model;

public class ProcessStatus {
    private Status status;
    private double w;

    public ProcessStatus(Status status, int w) {
        this.status = status;
        this.w = w;
    }
}
