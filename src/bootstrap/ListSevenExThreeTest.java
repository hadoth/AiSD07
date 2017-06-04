package bootstrap;

import bst.BinarySearchTree;
import bst.RBTree;
import bst.SimpleBST;

/**
 * Created by Karol on 2017-05-18.
 */
public class ListSevenExThreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> testTree = new RBTree<>(Integer::compareTo);
        int numberToAdd = 100000;

        for (int i = 0; i < numberToAdd; i++) {
            if (testTree.size() == 0) {
                testTree.add((int) (Math.random() * numberToAdd*10));
            } else {
                int number = (int) (Math.random() * numberToAdd*10);
                if (!testTree.add(number)) System.out.println("Add failed, number " + number + " already in set");
                else {
                    System.out.println("Add:\t" + number);
                }
            }
//            testTree.add(i);
//            System.out.println(testTree);
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.treeDetails(testTree);
            BinarySearchTree.assertSize(testTree);
        }
    }
}
