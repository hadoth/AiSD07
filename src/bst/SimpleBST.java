package bst;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-05-10.
 */
public class SimpleBST<T> implements BinarySearchTree<T> {
    private Comparator<T> comparator;
    private Element root;

    @Override
    public T minValue() {
        return this.getMinRecurrence(this.root);
    }

    @Override
    public T maxValue() {
        return this.getMaxRecurrence(this.root);
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
    public boolean add(T t){
        if (this.root != null) return this.addElement(t, null);
        this.root = new Element(t);
        return true;
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

    private boolean addElement(T t, Element element){
        int compareResult = this.comparator.compare(t, element.getContent());
        if(compareResult == 0) return false;
        if (compareResult > 0){
            if (element.getRight() == null) {
                element.setRight(new Element(t));
                return true;
            }
            else return this.addElement(t, element.getRight());
        } else {
            if (element.getLeft() == null) {
                element.setLeft(new Element(t));
                return true;
            }
            else return this.addElement(t, element.getLeft());
        }
    }

    private T getMinRecurrence(Element element){
        if (element.getLeft() == null) return element.getContent();
        return this.getMinRecurrence(element.getLeft());
    }

    private T getMaxRecurrence(Element element){
        if (element.getRight() == null) return element.getContent();
        return this.getMaxRecurrence((element.getRight()));
    }

    private Element getElementFormSubtree(T t, Element element){
        int compareResult = this.comparator.compare(t, element.getContent());
        if (compareResult == 0) return element;
        if (compareResult > 0) return this.getElementFormSubtree(t, element.getRight());
        else return this.getElementFormSubtree(t, element.getLeft());
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

        Element getLeft(){
            return this.left;
        }

        Element getRight(){
            return this.right;
        }

        T getContent(){
            return this.content;
        }

        public void setLeft(Element left) {
            this.left = left;
        }

        public void setRight(Element right) {
            this.right = right;
        }

        public void setContent(T content) {
            this.content = content;
        }
    }
}
