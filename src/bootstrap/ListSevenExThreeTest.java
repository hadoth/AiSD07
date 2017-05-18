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

        for (int i = 0; i < 25; i++) {
//            if (testTree.size() == 0) {
//                testTree.add((int) (Math.random() * 50));
//                testTree.add((int) (Math.random() * 50));
//            } else {
////                int number = (int) (Math.random() * 50);
//                if (!testTree.add(number)) System.out.println("Add failed, number " + number + " already in set");
//                else {
//                    System.out.println("Add:\t" + number);
//                    System.out.println(testTree);
//                }
//            }
            testTree.add(i);
            System.out.println(testTree);
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.assertSize(testTree);
        }
    }
}
