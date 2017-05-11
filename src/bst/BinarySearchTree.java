package bst;

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
    List<T> getAllInOrder();
    List<T> getAllPreOrder();
    List<T> getAllPostOrder();
    int size();
    int height();
    BinarySearchTree<T> subtree(T t);
}
