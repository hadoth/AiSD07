package bst;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-05-10.
 */
public class SimpleBST<T> implements BinarySearchTree<T> {
    private Comparator<T> comparator;

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

    private class Element{
        private Element left;
        private Element right;
        private T content;

        Element(T t){
            this.content = t;
            this.left = null;
            this.right = null;
        }

        boolean addElement(T t) {
            int result = comparator.compare(content, t);

            if (result == 0) return false;
            if (result < 0){
                if (left != null) left.addElement(t);
                else left = new Element(t);
            } else {
                if (right != null) left.addElement(t);
                else right = new Element(t);
            }
            return true;
        }
    }
}
