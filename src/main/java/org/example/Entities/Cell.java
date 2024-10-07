package org.example.Entities;

import org.example.Enums.State;

public class Cell {

    private State currentState;
    private State nextState;

    public Cell() {
        this.currentState = State.DEAD;
    }

    public boolean isAlive() {
        return this.currentState == State.ALIVE;
    }

    public void setAlive() {
        this.currentState = State.ALIVE;
    }

    public void determineNextState(int aliveNeighbors) {
        if (this.shouldBeAlive(aliveNeighbors)){
            this.nextState = State.ALIVE;
        } else {
            this.nextState = State.DEAD;
        }
    }

    public void updateState() {
        this.currentState = this.nextState;
    }

    private boolean shouldBeAlive(int aliveNeighbors) {
        return (this.isAlive() && (aliveNeighbors == 2 || aliveNeighbors == 3)) || (!this.isAlive() && aliveNeighbors == 3);
    }
}