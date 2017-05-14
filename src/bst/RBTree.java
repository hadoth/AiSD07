package bst;

import javax.lang.model.element.Element;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-05-14.
 */
public class RBTree<T> implements BinarySearchTree<T> {
    private Comparator<T> comparator;
    private Element root;

    public ()

    @Override
    public T minValue() {
        return null;
    }

    @Override
    public T maxValue() {
        return null;
    }

    @Override
    public T previousValue(T t) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T nextValue(T t) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public List<T> getAllInOrder() {
        return null;
    }

    @Override
    public List<T> getAllPreOrder() {
        return null;
    }

    @Override
    public List<T> getAllPostOrder() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int misbalance() {
        return 0;
    }

    @Override
    public int maxMisbalance() {
        return 0;
    }

    @Override
    public int leavesCount() {
        return 0;
    }

    @Override
    public BinarySearchTree<T> subtree(T t) {
        return null;
    }
}
