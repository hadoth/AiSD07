package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-05-10.
 */
public interface BinarySearchTree<T> {
    T minValue();
    T maxValue();
    T previousValue(T t) throws IndexOutOfBoundsException;
    T nextValue(T t) throws IndexOutOfBoundsException;
    boolean add(T t);
    boolean delete(T t);
    boolean contains(T t);
    List<T> getAllInOrder();
    List<T> getAllPreOrder();
    List<T> getAllPostOrder();
    int size();
    int height();
    int misbalance();
    int maxMisbalance();
    int leavesCount();
    BinarySearchTree<T> subtree(T t);

    static<T> void printTree(BinarySearchTree<T> tree){
        System.out.println(Arrays.toString(tree.getAllInOrder().toArray()));
    }

    static<T> void removeRandom(BinarySearchTree<T> tree){
        T elementToDelete = tree.getAllInOrder().get((int)(Math.random()*tree.size()));
        tree.delete(elementToDelete);
    }

    static<T> void testIfSorted(BinarySearchTree<T> tree, Comparator<T> comparator){
        List<T> list = tree.getAllInOrder();
        if (list.size() > 1){
            T left = list.get(0);
            T right;
            for (int i = 1; i < list.size(); i++){
                right = list.get(i);
                if (comparator.compare(left, right) >= 0) throw new AssertionError("BST tree is not sorted");
                left = right;
            }
        }
    }

    static<T> void assertSize(BinarySearchTree<T> tree){
        if (tree.size() != tree.getAllInOrder().size()) throw new AssertionError("BST tree is not sorted");
    }

    static<T> void treeDetails(BinarySearchTree<T> tree){
        StringBuilder result = new StringBuilder();
        result.append("tree height: ");
        result.append(tree.height());
        result.append("; tree size: ");
        result.append(tree.size());
        result.append("; max: ");
        result.append(tree.maxValue());
        result.append("; min: ");
        result.append(tree.minValue());
        result.append("; misbalance: ");
        result.append(tree.misbalance());
        result.append("; max misbalance: ");
        result.append(tree.maxMisbalance());
        result.append("; leaves: ");
        result.append(tree.leavesCount());
        System.out.println(result);
    }
}
