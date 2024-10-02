package org.example.Entities;

import org.example.Enums.State;

public class Cell {

    private State state;

    public Cell() {
        this.state = State.DEAD;
    }

    public boolean isAlive() {
        return this.state == State.ALIVE;
    }

    public void setAlive() {
        this.state = State.ALIVE;
    }
}