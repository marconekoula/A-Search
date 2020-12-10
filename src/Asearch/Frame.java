/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {

    private static JButton[][] tile = new JButton[15][15];

    public Frame() {
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(15, 15));

        //create tiles
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                tile[i][j] = new JButton(i + ", " + (j));
                if (Math.random() <= 0.1) {
                    tile[(i)][j].setBackground(Color.black);
                    add(tile[i][j]);
                } else {
                    add(tile[i][j]);
                }
            }
        }
        setVisible(true);
    }

    public static void main(String args[]) {
        int startRow;
        int startCol;
        int endRow;
        int endCol;
        Node StartNode;
        Node EndNode;
        path a = new path();

        new Frame();

        //User input Start row and column
        startRow = Integer.parseInt(JOptionPane.showInputDialog("Enter Starting Row: "));
        startCol = Integer.parseInt(JOptionPane.showInputDialog("Enter Starting Column: "));
        tile[startRow][startCol].setBackground(Color.green);

        //User inout end row and column
        endRow = Integer.parseInt(JOptionPane.showInputDialog("Enter Ending Row: "));
        endCol = Integer.parseInt(JOptionPane.showInputDialog("Enter Ending Column: "));
        tile[endRow][endCol].setBackground(Color.red);

        StartNode = new Node(startRow, startCol, tile[startRow][startCol]);
        EndNode = new Node(endRow, endCol, tile[endRow][endCol]);

        StartNode.setG(0);
        StartNode.setH(getH(StartNode, EndNode));
        System.out.print("Heuristic  = " + getH(StartNode, EndNode) + "\n");
        StartNode.setF();

        a.path(StartNode, EndNode, tile);
        tile[startRow][startCol].setBackground(Color.green);

    }

    //Calulate Heuristics
    public static int getH(Node start, Node end) {
        int h;
        h = (Math.abs(start.getRow() - end.getRow()) * 10) + (Math.abs(start.getCol() - end.getCol()) * 10);
        return h;
    }

  
}
