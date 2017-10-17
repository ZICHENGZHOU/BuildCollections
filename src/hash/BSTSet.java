package hash;

public class BSTSet<T> implements Set<T> {
    BSTree tree;
    int number;

    class BSTree {
        T element;
        BSTree left, right;

        BSTree add(T element) {
            if (this.element == null) {
                this.element = element;
                return this;
            }
            else if (element.hashCode() < this.element.hashCode()) {
                if (left == null)
                    left = new BSTree();
                return left.add(element);
            }
            else {
                if (right == null)
                    right = new BSTree();
                return right.add(element);
            }
        }

        void add(BSTree tree) {
            if (tree != null && tree.element != null) {
                add(tree.element);
                add(tree.left);
                add(tree.right);
            }
        }

        BSTree find(T element, boolean detach) {
            if (element == null || this.element == null)
                return null;
            if (this.element.equals(element))
                return this;
            else if (element.hashCode() < this.element.hashCode()) {
                if (left == null)
                    return null;
                BSTree t = left.find(element, detach);
                if (detach && t == left)
                    left = null;
                return t;
            }
            else {
                if (right == null)
                    return null;
                BSTree t = right.find(element, detach);
                if (detach && t == right)
                    right = null;
                return t;
            }
        }


        public String toString() {
            if (this.element == null)
                return "";
            return (left == null) ? "" : (left + ", ") +
                    element.toString()
                    + ((right == null) ? "" : (", " + right));
        }

    }

    @Override
    public void add(T element) {

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<T> newInstance() {
        return null;
    }
}
