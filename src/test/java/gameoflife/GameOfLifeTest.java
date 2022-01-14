package gameoflife;

import org.junit.jupiter.api.Test;
import gameoflife.Cell.LifeStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
TODO: Problem Description This Kata is about calculating the next generation of Conway’s game of life,given any starting position.
 See http://en.wikipedia.org/wiki/Conway
 %27s_Game_of_Life for background. You start with a two dimensional grid of cells, where each cell is either alive ordead.
 in this version of the problem, the grid is finite, and no life can exist off the edges. When calculating the next generation of the grid,
 follow these rules:
   /*
 1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
 2. Any live cell with more than three live neighbors dies, as if by overcrowding.
 3. Any live cell with two or three live neighbors lives on to the next generation.
 4. Any dead cell with exactly three live neighbors becomes a live cell.
 /*
 You should write a program that can accept an arbitrary grid of cells, and will output a similar grid showing the next generation.
 Try to work with immutable objects and pure functions as much as possible.
 */

class GameOfLifeTest {

    Cell cell;
    Cell neighbour;
    LifeStatus lifeStatus;

    @Test
    void aCellWithOnlyOneNeighbourDies() {
        cell = new Cell(Cell.LifeStatus.ALIVE);
        lifeStatus = cell.getNextCellState(1);
        assertEquals(LifeStatus.DEAD, lifeStatus);
    }

    @Test
    void diesWithZeroNeighbours(){
        cell= new Cell(LifeStatus.ALIVE);

        lifeStatus = cell.getNextCellState(2);

        assertEquals(LifeStatus.DEAD,lifeStatus);
    }
    @Test
    void aCellWithTwoNeighbourLives(){
        cell = new Cell(LifeStatus.ALIVE);
        lifeStatus = cell.getNextCellState(2);

        assertEquals(cell.getLifeStatus(),lifeStatus);
    }
}