/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asearch;

/**
 *
 * @author marco
 */
public class Node {

    private int row, col, f, g, h;
    private Node parent;

    public Node(int r, int c, Object a) {
        row = r;
        col = c;
        parent = null;
    }

    //Mutator
    public void setF() {
        f = g + h;
    }

    public void setG(int value) {
        g = value;
    }

    public void setH(int value) {
        h = value;
    }

    public void setParent(Node n) {
        parent = n;
    }

    //Accessor
    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public Node getParent() {
        return parent;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean equals(Object in) {
        Node n = (Node) in;
        return row == n.getRow() && col == n.getCol();
    }

    public String toString() {
        return "Node: " + row + " " + col;
    }
}
