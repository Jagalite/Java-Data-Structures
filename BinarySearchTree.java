public class BinarySearchTree {
    
    public void insert(Integer data) {
        TreeNode<Integer> node = new TreeNode<Integer>(data);
        
        if(root == null) {
            root = node;
        }
        else {
            insert(root, node);
        }
    }
    
    public void printInOrder() {
        printInOrder(root);
    }

    public void delete(Integer data) {
        TreeNode<Integer> parent = findParent(root, data);
        TreeNode<Integer> node = findNode(parent, data);
        
        //System.out.println(parent.data);
        //System.out.println(node.data);
        
        
        //delete root
        if(root != null && root.data == data) {
            if(root.data == data && root.left == null && root.right == null) {
                root = null;
                return;
            }
            
            
            TreeNode<Integer> minOfSubTree;
            TreeNode<Integer> parentOfMin;
            if(root.right != null) {
                minOfSubTree = findMin(root.right);   
                parentOfMin = findParent(root.right, minOfSubTree.data);
            }
            else {
                minOfSubTree = findMin(root.left);   
                parentOfMin = findParent(root.left, minOfSubTree.data);
            }
            root.data = minOfSubTree.data;
            if(parentOfMin.left != null && parentOfMin.left.data == minOfSubTree.data) {
                parentOfMin.left = null;
            }
            else {
                parentOfMin.right = null;
            }
            return;
        }
        
        //leaf
        if(node.left == null && node.right == null) {
            if(parent.left == node) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
            
            return;
        }
        
        //one branch
        if(node.left == null && node.right != null) {
            if(parent.right == node) {
                parent.right = node.right;    
            }
            else {
                parent.left = node.right;
            }
            return;
        }
        else if(node.left != null && node.right == null) {
            if(parent.right == node) {
                parent.right = node.left;    
            }
            else {
                parent.left = node.left;
            }
            return;
        }
        
        
        //both branches present
        TreeNode<Integer> minOfSubTree;
        TreeNode<Integer> parentOfMin;
        if(node.right != null) {
            minOfSubTree = findMin(node.right);   
            parentOfMin = findParent(node.right, minOfSubTree.data);
        }
        else {
            minOfSubTree = findMax(node.left);   
            parentOfMin = findParent(node.left, minOfSubTree.data);
        }
        node.data = minOfSubTree.data;
        if(parentOfMin.left != null && parentOfMin.left.data == minOfSubTree.data) {
            parentOfMin.left = null;
        }
        else {
            parentOfMin.right = null;
        }
        
    }
    
    public void printPostOrder() {
        printInOrder(root);
    }
   
    public void printPreOrder() {
        printInOrder(root);
    }   
   
    public Integer findMax() {
        return findMax(root).data;
    }   
    
    public Integer findMin() {
        return findMin(root).data;
    }
    
    public boolean hasNumber(Integer n) {
        TreeNode found = findNode(root, n);
        
        if(found == null) {
            return false;
        }
        
        return true;
    }
    
    private TreeNode<Integer> findParent(TreeNode<Integer> current, Integer target) {
        if(current != null) {
            if((current.left != null && current.left.data == target) || (current.right != null && current.right.data == target)) {
                return current;
            }
            
            
            
            if(current.left != null) {
                TreeNode left = findParent(current.left, target);
                if(left != null) {
                    return left;
                }
            }
            
            return findParent(current.right, target);
            
        }
        
        return null;
    }
    
    private TreeNode<Integer> findMax(TreeNode<Integer> current) {
        if(current != null) {
            if(current.right == null) {
                return current;
            }
            
            return findMax(current.right);
        }
        
        return null;
    }
    
    private TreeNode<Integer> findMin(TreeNode<Integer> current) {
        if(current != null) {
            if(current.left == null) {
                return current;
            }
            
            return findMax(current.left);
        }
        
        return null;
    }
   
    private void delete(TreeNode current) {
        
    }
    
    private TreeNode<Integer> findNode(TreeNode<Integer> current, Integer data) {
        if(current == null) {
            return null;
        }
        
        if(current.data == data) {
            return current;
        }
        
        if(data < current.data) {
            return findNode(current.left, data);
        }
        else {
            return findNode(current.right, data);
        }
    }
    
    
    private void printInOrder(TreeNode current) {
        if(current != null) {
            printInOrder(current.left);
            System.out.println(current.data);
            printInOrder(current.right);
        }
    }
    
    
    private void printPreOrder(TreeNode current) {
        if(current != null) {
            System.out.println(current.data);
            printInOrder(current.left);
            printInOrder(current.right);
        }
    }

    
    private void printPostOrder(TreeNode current) {
        if(current != null) {
            printInOrder(current.left);
            printInOrder(current.right);
            System.out.println(current.data);
        }
    }
    
    private void insert(TreeNode<Integer> current, TreeNode<Integer> target) {
        if(current != null) {
            if(target.data < current.data) {
                if(current.left == null) {
                    current.left = target;
                }
                else {
                    insert(current.left, target);
                }
            }
            else {
                if(current.right == null) {
                    current.right = target;
                }
                else {
                    insert(current.right, target);
                }
            }
        }
    }

    
    TreeNode<Integer> root;
}
