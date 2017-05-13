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
        System.out.println(testTree);
        testTree.add(20);
        System.out.println(testTree);
        testTree.add(5);
        System.out.println(testTree);
        testTree.add(6);
        System.out.println(testTree);
        testTree.add(7);
        System.out.println(testTree);
        testTree.add(25);
        System.out.println(testTree);
        testTree.add(15);
        System.out.println(testTree);


        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(7);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(5);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        testTree.delete(20);
        BinarySearchTree.testIfSorted(testTree, Integer::compareTo);

        for (int i = 0; i < 100; i++){
            if(testTree.size() == 0){
                testTree.add((int)(Math.random()*100));
            } else {
                if (!testTree.add((int)(Math.random()*100))) System.out.println("Add failed, number already in set");
            }
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
            BinarySearchTree.assertSize(testTree);
//            printTree(testTree);
        }

        while (testTree.size() > 0){
            BinarySearchTree.removeRandom(testTree);
            BinarySearchTree.testIfSorted(testTree, Integer::compareTo);
//            printTree(testTree);
        }
    }
}