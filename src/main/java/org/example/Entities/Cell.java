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

    public boolean isDead() {
        return this.state == State.DEAD;
    }

    public void setAlive() {
        this.state = State.ALIVE;
    }

    public void setDead(){
        this.state = State.DEAD;
    }
}