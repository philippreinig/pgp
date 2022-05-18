import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class BinaryTree<T> implements Iterable<T>{
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    @Override 
    public InorderIterator iterator() {
        return new InorderIterator(this);
    }

    private class InorderIterator implements Iterator<T>{
        Stack<BinaryTree<T>> stack = new Stack<>();

        private InorderIterator(BinaryTree<T> node){
            stack.push(node);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public T next() {
            if(stack.empty()) throw new NoSuchElementException();
            BinaryTree<T> next = stack.pop();
            if (next.getLeft() != null) stack.push(next.getLeft());
            if (next.getRight() != null) stack.push(next.getRight());

            return next.getValue();
        }
        }
    }

class BinTreeTraversal {
    public static void main(String[] args) {
        /*
            Following is an usage example, creating a binary tree and printing out all values in the order of the given iterator
         */

        BinaryTree<Integer> root = new BinaryTree<Integer>(1);

        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));

        // Your implementation should be able to perform a for each with the given syntax
        for (int item : root) {
            System.out.println(item);
        }
    }
}

