package bootstrap;

import bst.BinarySearchTree;
import bst.SimpleBST;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class ListSevenExOneTest {
    public static void main(String[] args){
        BinarySearchTree<Integer> testTree = new SimpleBST<>(Integer::compareTo);

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
        BinarySearchTree.treeDetails(testTree);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(5);
        BinarySearchTree.treeDetails(testTree);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(20);
        BinarySearchTree.treeDetails(testTree);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        for (int i = 0; i < 100; i++){
            if(testTree.size() == 0){
                testTree.add((int)(Math.random()*100));
            } else {
                if (!testTree.add((int)(Math.random()*100))) System.out.println("Add failed, number already in set");
            }
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.treeDetails(testTree);
            BinarySearchTree.assertSize(testTree);
//            printTree(testTree);
        }

        while (testTree.size() > 0){
            BinarySearchTree.treeDetails(testTree);
            BinarySearchTree.removeRandom(testTree);
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
//            printTree(testTree);
        }
    }
}