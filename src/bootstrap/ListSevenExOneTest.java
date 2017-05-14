package bootstrap;

import bst.BinarySearchTree;
import bst.SimpleBST;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class ListSevenExOneTest {
    public static void main(String[] args){
        BinarySearchTree<Integer> testTree = new SimpleBST<>(Integer::compareTo);
        int numberOfTests = 100;

        testTree.add(10);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(20);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(5);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(6);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(7);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(25);
        BinarySearchTree.treeDetails(testTree);
        testTree.add(15);
        BinarySearchTree.treeDetails(testTree);


        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(7);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(5);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(20);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        for (int i = 0; i < numberOfTests; i++){
            if(testTree.size() == 0){
                testTree.add((int)(Math.random()*numberOfTests));
            } else {
                if (!testTree.add((int)(Math.random()*numberOfTests))) ;//System.out.println("Add failed, number already in set");
            }
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.assertSize(testTree);
            BinarySearchTree.treeDetails(testTree);
            BinarySearchTree.printTree(testTree);
        }

        while (testTree.size() > 1){
            BinarySearchTree.removeRandom(testTree);
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.assertSize(testTree);
            BinarySearchTree.treeDetails(testTree);
            BinarySearchTree.printTree(testTree);
        }

        for (int i = 0; i < numberOfTests; i++){
            BinarySearchTree.removeRandom(testTree);
            testTree.add((int)(Math.random()*numberOfTests));
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.assertSize(testTree);
        }
    }
}