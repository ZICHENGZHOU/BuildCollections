//package hash;
//
//public class BSTree<T> {
//    T element;
//    BSTree<T> left, right;
//
//    BSTree add(T element) {
//        if (this.element == null) {
//            this.element = element;
//            return this;
//        } else if (this.element.equals(element)) {
//            return null;
//        } else if (element.hashCode() < this.element.hashCode()) {  // add to left
//            if (left == null)
//                left = new BSTree();
//            return left.add(element);
//        } else { // add to right
//            if (right == null)
//                right = new BSTree();
//            return right.add(element);
//        }
//    }
//
//    void add(BSTree<T> tree) {
//        if (tree != null && tree.element != null) {
//            add(tree.element);
//            add(tree.left);
//            add(tree.right);
//        }
//    }
//
//    BSTree find(T element, boolean detatch) {
//        if (element == null || this.element == null)
//            return null;
//        else if (element.equals(this.element))
//            return this; // found it!
//        else if (element.hashCode() < this.element.hashCode()) {
//            if (left == null)
//                return null;
//            else {
//                BSTree t = left.find(element, detatch);
//                if (detatch)
//                    left = null;
//                return t;
//            }
//        } else {
//            if (right == null)
//                return null;
//            else {
//                BSTree t = right.find(element, detatch);
//                if (detatch)
//                    right = null;
//                return t;
//            }
//        }
//    }
//
//    public String toString() {
//        if (element == null)
//            return "";
//        return ((left == null ) ? "" : (left.toString() + ", ")) +
//                element.toString() +
//                ((right == null ) ? "" : (", "+ right.toString()));
//    }
//
//
//    public static void main(String[] args) {
//        BSTree<Integer> tree = new BSTree<>();
//        tree.add(5);
//        tree.add(3);
//        tree.add(7);
//        tree.add(1);
//        tree.add(4);
//        tree.add(6);
//        tree.add(8);
//
//        System.out.println(tree.toString());
//
//        BSTree<Integer> t = tree.find(8,true);
//        System.out.println(t.toString());
//    }
//}
