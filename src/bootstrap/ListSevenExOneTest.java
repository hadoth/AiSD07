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
        testTree.add(20);
        testTree.add(5);
        testTree.add(6);
        testTree.add(7);
        testTree.add(25);
        testTree.add(15);

        testIfSorted(testTree);

        testTree.delete(7);
        testIfSorted(testTree);

        testTree.delete(5);
        testIfSorted(testTree);

        testTree.delete(20);
        testIfSorted(testTree);

        for (int i = 0; i < 100; i++){
            if(testTree.size() == 0){
                testTree.add((int)(Math.random()*100));
            } else {
                if (!testTree.add((int)(Math.random()*100))) System.out.println("Add failed, number already in set");
            }
            testIfSorted(testTree);
            printTree(testTree);
        }

        while (testTree.size() > 0){
            removeRandom(testTree);
            testIfSorted(testTree);
            printTree(testTree);
        }
    }

    public static<T> void printTree(BinarySearchTree<T> tree){
        System.out.println(Arrays.toString(tree.getAllInOrder().toArray()));
    }

    public static void removeRandom(BinarySearchTree<Integer> tree){
        int elementToDelete = tree.getAllInOrder().get((int)(Math.random()*tree.size()));
        System.out.println(elementToDelete);
        tree.delete(elementToDelete);
    }

    public static void testIfSorted(BinarySearchTree<Integer> tree){
        List<Integer> list = tree.getAllInOrder();
        if (list.size() > 1){
            int left = list.get(0);
            int right;
            for (int i = 1; i < list.size(); i++){
                right = list.get(i);
                if (Integer.compare(left, right) >= 0) throw new AssertionError("BST tree is not sorted");
                left = right;
            }
        }
    }
}