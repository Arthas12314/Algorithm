public class BST<K extends Comparable<K>,V> {
    private class Node{
        K key;
        V value;
        Node left;
        Node right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
        public Node(Node node){
            this.key=node.key;
            this.value=node.value;
            this.left=node.left;
            this.right=node.right;
        }
    }
    Node root;
    int size;
    public BST(){
        root=new Node(null,null);
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public K minimum(){
        return minimum(root).key;
    }
    public K maximum(){
        return maximum(root).key;
    }
    public void add(K key,V value){
        add(root,key,value);
    }
    public void removeMin(){
        removeMin(root);
    }
    public void removeMax(){
        removeMax(root);
    }
    public void remove(K key){
        remove(root,key);
    }
    public K findFloor(K key){
        return findFloor(root,key).key;
    }
    public K findCeil(K key){
        return findCeil(root,key).key;
    }
    private void add(Node node,K key,V value){
        if(node==null){
            node=new Node(key,value);
            size++;
            return;
        }
        if(key.compareTo(node.key)<0){
            add(node.left,key,value);
        }
        else if(key.compareTo(node.key)>0){
            add(node.right,key,value);
        }
        else {
            node.value=value;
        }

    }
    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    private Node maximum(Node node){
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }
    private Node remove(Node node,K key){
        if(key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
        }
        else if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
        }
        else {
            if(node.left==null){
                Node rightNode=node.right;
                node=null;
                size--;
                return rightNode;
            }
            else if(node.right==null){
                Node leftNode=node.left;
                node=null;
                size--;
                return leftNode;
            }
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node=null;
            return successor;
        }
        return node;
    }
    private Node findFloor(Node node,K key){
        if (node == null) {
            return node;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return findFloor(node.left, key);
        }
        Node temp=findFloor(node.right,key);
        if (temp != null) {
            return temp;
        }
        return node;
    }
    private Node findCeil(Node node,K key){
        if (node == null) {
            return node;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) < 0) {
            return findCeil(node.right, key);
        }
        Node temp=findCeil(node.left,key);
        if (temp != null) {
            return temp;
        }
        return node;
    }
}
