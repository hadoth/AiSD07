package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-05-10.
 */
public class SimpleBST<T> implements BinarySearchTree<T> {
    private Comparator<T> comparator;
    private Element root;

    public SimpleBST(Comparator<T> comparator){
        this.comparator = comparator;
    }

    private SimpleBST(Comparator<T> comparator, Element element){
        this.comparator = comparator;
        this.root = new Element(element.getContent());
        this.root.setLeft(element.getLeft());
        this.root.setRight(element.getRight());
    }

    @Override
    public T minValue() {
        return this.root.getMinRecurrence();
    }

    @Override
    public T maxValue() {
        return this.root.getMaxRecurrence();
    }

    @Override
    public T previousValue(T t) throws IndexOutOfBoundsException {
        Element thisOne = this.getElementFormSubtree(t, this.root);
        if (thisOne.hasLeft()) return thisOne.getLeft().getMaxRecurrence();
        Element parent = thisOne.getParent();
        while (!parent.hasRight()) parent = parent.getParent();
        return parent.getContent();
    }

    @Override
    public T nextValue(T t) throws IndexOutOfBoundsException {
        Element thisOne = this.getElementFormSubtree(t, this.root);
        if (thisOne.hasRight()) return thisOne.getRight().getMinRecurrence();
        Element parent = thisOne.getParent();
        while (!parent.hasLeft()) parent = parent.getParent();
        return parent.getContent();
    }

    @Override
    public boolean add(T t){
        if (this.root != null) return this.addElement(t, this.root);
        this.root = new Element(t);
        return true;
    }

    @Override
    public boolean delete(T t) {
        try {
            Element toDelete = this.getElementFormSubtree(t, this.root);
            int childCount = toDelete.childCount();
            if (childCount == 0){
                if (this.root.equals(toDelete)){
                    this.root = null;
                    return true;
                }
                if (toDelete.equals(toDelete.getParent().getLeft())) toDelete.getParent().setLeft(null);
                else toDelete.getParent().setRight(null);
            } else if (childCount == 1){
                Element child = toDelete.hasLeft() ? toDelete.getLeft() : toDelete.getRight();
                if (this.root.equals(toDelete)){
                    this.root = child;
                    this.root.setParent(null);
                    return true;
                }
                if (toDelete.equals(toDelete.getParent().getLeft())) toDelete.getParent().setLeft(child);
                else toDelete.getParent().setRight(child);
            } else {
                Element nextOne = this.getElementFormSubtree(this.nextValue(t), this.root);
                toDelete.setContent(nextOne.getContent());
                nextOne.setContent(t);
                if (nextOne.childCount() == 0){
                    if (nextOne.equals(nextOne.getParent().getLeft())){
                        nextOne.getParent().setLeft(null);
                    } else {
                        nextOne.getParent().setRight(null);
                    }
                } else {
                    Element child = nextOne.hasLeft() ? nextOne.getLeft() : nextOne.getRight();
                    if (nextOne.equals(nextOne.getParent().getLeft())){
                        nextOne.getParent().setLeft(child);
                    } else {
                        nextOne.getParent().setRight(child);
                    }
                }
            }
        } catch (NullPointerException e){
            return false;
        }
        return true;
    }

    @Override
    public List<T> getAllInOrder() {
        ArrayList<T> result = new ArrayList<T>();
        if (this.root != null) this.root.insertInOrder(result);
        return result;
    }

    @Override
    public List<T> getAllPreOrder() {
        ArrayList<T> result = new ArrayList<T>();
        if (this.root != null) this.root.insertPreOrder(result);
        return result;
    }

    @Override
    public List<T> getAllPostOrder() {
        ArrayList<T> result = new ArrayList<T>();
        if (this.root != null) this.root.insertPostOrder(result);
        return result;
    }

    @Override
    public int size() {
        return (this.root == null) ? 0 : this.root.subtreeSize();
    }

    @Override
    public int height() {
        return this.root.subtreeHeight() - 1;
    }

    @Override
    public BinarySearchTree<T> subtree(T t) {
        return new SimpleBST<>(this.comparator, this.getElementFormSubtree(t, this.root));
    }

    public int getTreeMisbalance(){
        return this.root.subtreeMisbalance();
    }

    public int getTreeMaxmisbalance(){
        return this.root.subtreeMaxMisbalance();
    }

    public int getLeavesCount(){
        return this.root.subtreeLeaves();
    }

    private boolean addElement(T t, Element element){
        int compareResult = this.comparator.compare(t, element.getContent());
        if(compareResult == 0) return false;
        if (compareResult > 0){
            if (element.hasRight()) return this.addElement(t, element.getRight());
            element.setRight(new Element(t));
            return true;
        } else {
            if (element.hasLeft()) return this.addElement(t, element.getLeft());
            element.setLeft(new Element(t));
            return true;
        }
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
        private Element parent;
        private T content;

        Element(T t){
            this.content = t;
            this.left = null;
            this.right = null;
        }

        boolean hasLeft(){
            return this.left != null;
        }

        boolean hasRight(){
            return this.right != null;
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
            if (left != null) this.left.setParent(this);
        }

        public void setRight(Element right) {
            this.right = right;
            if (right != null) this.right.setParent(this);
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Element getParent() {
            return parent;
        }

        public void setParent(Element parent) {
            this.parent = parent;
        }

        void insertInOrder(List<T> list){
            if (this.hasLeft()) this.getLeft().insertInOrder(list);
            list.add(this.content);
            if (this.hasRight()) this.getRight().insertInOrder(list);
        }

        void insertPreOrder(List<T> list){
            list.add(this.content);
            if (this.hasLeft()) this.getLeft().insertPreOrder(list);
            if (this.hasRight()) this.getRight().insertPreOrder(list);
        }

        void insertPostOrder(List<T> list){
            list.add(this.content);
            if (this.hasLeft()) this.getLeft().insertPostOrder(list);
            if (this.hasRight()) this.getRight().insertPostOrder(list);
        }

        // One-liner hell of code readability
        private T getMinRecurrence(){
            return this.hasLeft() ? this.left.getMinRecurrence() : this.content;
        }

        private T getMaxRecurrence(){
            return this.hasRight() ? this.right.getMaxRecurrence() : this.content;
        }

        int subtreeHeight(){
            return 1 + Math.max(this.hasLeft() ? this.left.subtreeHeight() : 0, this.hasRight() ? this.right.subtreeHeight() : 0);
        }

        int subtreeSize(){
            return 1 + (this.hasLeft() ? this.left.subtreeSize() : 0) + (this.hasRight() ? this.right.subtreeSize() : 0);
        }

        int subtreeLeaves(){
            return (!this.hasLeft() && ! this.hasRight()) ? 1 : (this.hasLeft() ? this.left.subtreeLeaves() : 0) + (this.hasRight() ? this.right.subtreeLeaves() : 0);
        }

        int subtreeMisbalance(){
            return Math.abs((this.hasLeft() ? this.left.subtreeHeight() : 0) - (this.hasRight() ? this.right.subtreeHeight() : 0));
        }

        int subtreeMaxMisbalance(){
            return Math.max(this.subtreeMisbalance(), Math.max(this.hasLeft() ? this.left.subtreeMaxMisbalance() : 0, this.hasRight() ? this.right.subtreeMaxMisbalance() : 0));
        }

        int childCount(){
            return (this.hasLeft() ? 1 : 0) + (this.hasRight() ? 1 : 0);
        }
    }
}
