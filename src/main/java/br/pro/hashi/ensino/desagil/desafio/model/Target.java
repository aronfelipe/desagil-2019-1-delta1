package br.pro.hashi.ensino.desagil.desafio.model;

import java.util.LinkedList;
import java.util.Random;

public class Target extends Element {
    private final Board board;

    public Target(int row, int col, Board board) {
        super(row, col);
        this.board = board;
    }

    public void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }

    public void aleatoryMove() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("up");
        list.add("down");
        list.add("right");
        list.add("left");

        int len = list.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(len);

        if (list.get(randomInt) == "up"){
            this.moveUp();
        }

        if (list.get(randomInt) == "down"){
            this.moveDown();
        }

        if (list.get(randomInt) == "right"){
            this.moveRight();
        }

        if (list.get(randomInt) == "left"){
            this.moveLeft();
        }

    }

    public void moveUp() {
        if (row>0 && !board.isWall(row - 1, col)) {
            move(-1, 0);
        }
    }

    public void moveRight() {
        if (col   <   board.getNumCols() - 1 && !board.isWall(row, col + 1)) {
            move(0, 1);
        }
    }

    public void moveDown() {
        if (row <      board.getNumRows() - 1 && !board.isWall(row + 1, col)) {
            move(1, 0);
        }
    }

    public void moveLeft() {
        if (col  >0 && !board.isWall(row,col - 1)) {
            move(0, -1)  ;
        }
    }
}
