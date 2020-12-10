/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asearch;

import static Asearch.Frame.getH;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author marco
 */
public class path {

    public void path(Node start, Node end, JButton[][] button) {

        boolean look = true;
        ArrayList<Node> openList = new ArrayList<>();
        ArrayList<Node> closedList = new ArrayList<>();

        openList.add(start);

        while (look) {
            Node node = openList.remove(0);
            if (node.equals(end)) {
                look = false;

                while (!node.equals(start)) {
                    node = node.getParent();
                    button[node.getRow()][node.getCol()].setBackground(Color.MAGENTA);
                }

            } else {
                int row = node.getRow();
                int col = node.getCol();

                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {

                        if (i >= 0 && i < 15 && j >= 0 && j < 15 && (i != row || j != col) && (button[i][j].getBackground() != Color.BLACK)) {
                            Node n = new Node(i, j, button[i][j]);

                            n.setParent(node);

                            int g = 10;
                            n.setG(node.getG() + g);
                            n.setH(getH(n, end));
                            n.setF();

                            if (inOpen(n, closedList) == null) {
                                Node a = inOpen(n, openList);
                                if (a == null) {
                                    openList.add(n);

                                } else {
                                    if (n.getG() < a.getG()) {
                                        a.setG(n.getG());
                                        a.setParent(node);

                                    }
                                }
                            }
                        }
                    }
                }
                sortList(openList);
                closedList.add(node);
            }
        }
    }

    //Check if its in open list
    public static Node inOpen(Node a, ArrayList<Node> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(a)) {
                return list.get(i);
            }
        }
        return null;
    }

    public static void sortList(ArrayList<Node> list) {
        int num;

        for (int i = 0; i < list.size(); i++) {
            num = i;
            for (int j = i; j < list.size() - 1; j++) {
                if (list.get(j + 1).getF() < list.get(num).getF()) {
                    num = j + 1;
                }
            }
            list.set(i, list.get(num));
            list.set(num, list.get(i));
        }
    }
}
