
public class BinarySearchTree<E extends Comparable> implements BinaryTreeInterface<E> {

    TreeNode<E> root;

    @Override
    public String preOrder() {
        if (root == null) {
            return "[]";
        } else
            return "[" + preOrderHelper(root) + "]";
    }

    public String preOrderHelper(TreeNode<E> node) {
        if (node == null) {
            return "";
        } else if (node == root) {
            return "" + node.getData() + "" + preOrderHelper(node.getLeft()) + preOrderHelper(node.getRight());
        } else return ", " + node.getData() + "" + preOrderHelper(node.getLeft()) + preOrderHelper(node.getRight());

    }

    @Override
    public String inOrder() {
        if (root == null) {
            return "[]";
        } else
            return "[" + inOrderHelper(root).substring(0, inOrderHelper(root).length() - 2) + "]";
    }

    public String inOrderHelper(TreeNode<E> node) {
        if (node == null) {
            return "";
        } else return inOrderHelper(node.getLeft()) + "" + node.getData() + ", " + inOrderHelper(node.getRight());
    }

    @Override
    public String postOrder() {
        if (root == null) {
            return "[]";
        } else return "[" + postOrderHelper(root).substring(0, postOrderHelper(root).length() - 2) + "]";
    }


    public String postOrderHelper(TreeNode<E> node) {
        if (node == null) {
            return "";
        } else return postOrderHelper(node.getLeft()) + postOrderHelper(node.getRight()) + "" + node.getData() + ", ";
    }

    @Override
    public E minValue() {
        TreeNode<E> node = root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    @Override
    public E maxValue() {
        TreeNode<E> node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }

    @Override
    public int maxDepth() {
        if (root == null) {
            return -1;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        } else {
            return depthHelp(root, 0) + 1;
        }
    }

    private int depthHelp(TreeNode current, int depth) {
        if (current == null) {
            return 0;
        } else {
            int Right = depthHelp(current.getRight(), depth + 1);
            int Left = depthHelp(current.getLeft(), depth + 1);

            if (Right > Left) {
                return (Left + 1);
            } else return (Right + 1);
        }

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        return sizeHelper(root);
    }

    public int sizeHelper(TreeNode<E> node) {
        return (node == null) ? 0 : 1 + sizeHelper(node.getLeft()) + sizeHelper(node.getRight());
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else return false;
    }

    @Override
    public boolean contains(E data) {
        return containsHelp(root, data);
    }

    private boolean containsHelp(TreeNode current, E value) {
        if (current == null)
            return false;
        else if (current.getData() == value)
            return true;
        return containsHelp(current.getLeft(), value) || containsHelp(current.getRight(), value);
    }

    @Override
    public boolean insert(E data) {
        return add(data);
    }

    @Override
    public boolean add(E data) {
        TreeNode<E> val = new TreeNode<>(data);

        if (root == null) {
            root = val;
        } else if (root == val) {
            return false;
        } else {
            TreeNode<E> node = root;

            while (true) {
                if (node.getData().compareTo(val.getData()) > 0) {
                    if (node.getLeft() == null) {
                        node.setLeft(val);
                        return true;
                    } else if (node.getLeft().getData() == data) {
                        return false;
                    } else if (node.getLeft() != null) {
                        node = node.getLeft();
                    }
                } else if (node.getData().compareTo(val.getData()) < 0) {
                    if (node.getRight() == null) {
                        node.setRight(val);
                        return true;
                    } else if (node.getRight().getData() == data) {
                        return false;
                    } else if (node.getRight() != null) {
                        node = node.getRight();
                    }
                } else return false;
            }

        }
        return true;

    }

    @Override
    public boolean remove(E data) {
        if (root == null) {
            return false;
        } else if (!contains(data)) {
            return false;
        } else {
            TreeNode<E> node = root;
            while (node != null) {
                if (node.getData() == data) {
                    break;
                } else if (node.getData().compareTo(data) > 0) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
            //if it has no child
            if (node.getRight() == null && node.getLeft() == null) {
                TreeNode<E> checking = root;
                while (checking != null) {
                    if (checking.getLeft() == node) {
                        checking.setLeft(null);
                        break;
                    } else if (checking.getRight() == node) {
                        checking.setRight(null);
                        break;
                    } else if (checking.getData().compareTo(data) > 0) {
                        checking = checking.getLeft();
                    } else {
                        checking = checking.getRight();
                    }
                }
            }
            //if it has one child
            else if ((node.getRight() != null && node.getLeft() == null) || (node.getRight() == null && node.getLeft() != null)) {
                if (node.getLeft() != null) {
                    TreeNode<E> node2 = root;
                    while (node2 != null) {
                        if (node2.getLeft() == node) {
                            node2.setLeft(node.getLeft());
                            break;
                        } else if (node2.getRight() == node) {
                            node2.setRight(node.getLeft());
                            break;
                        } else if (node2.getData().compareTo(data) > 0) {
                            node2 = node2.getLeft();
                        } else {
                            node2 = node2.getRight();
                        }
                    }
                } else {
                    TreeNode<E> node2 = root;
                    while (node2 != null) {
                        if (node2.getLeft() == node) {
                            node2.setLeft(node.getRight());
                            break;
                        } else if (node2.getRight() == node) {
                            node2.setRight(node.getRight());
                            break;
                        } else if (node2.getData().compareTo(data) > 0) {
                            node2 = node2.getLeft();
                        } else {
                            node2 = node2.getRight();
                        }
                    }
                }
            }
            //if it has two children
            else {
                System.out.print("node has 2 children");
                TreeNode<E> current = node.getRight();

                while (current.getLeft() != null) {
                    current = current.getLeft();
                }
                E val = current.getData();

                remove(val);
                node.setData(val);
               /*
               TreeNode<E> current2 = node.getLeft();
               while (current2.getRight() != current) {
                   current2 = current2.getRight();
               }
               current2.setRight(current);
               */

            }

        }
        return true;
    }
    // use chapter notes to code this file
}






