package PracticeProjects;

import java.util.List;
import java.util.Objects;

public class TLinkedList<T>{
    private int size = 0;
    private int modCount = 0;
    private TNode<T> firstNode = null;
    
    private TNode<T> lastNode = null;

    public TLinkedList() {
    }

    public TLinkedList(List<T> list){
        if (list.size() == 0) return;
        createFirstNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public TNode<T> getFisTNode() {
        return firstNode;
    }

    public void setFisrstTNode(TNode<T> fisTNode) {
        this.firstNode = fisTNode;
        modCount++;
    }

    public TNode<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(TNode<T> lastNode) {
        this.lastNode = lastNode;
        modCount++;
    }

    public int size(){
        return this.size;
    }

    public void add(T value){
        lastNode = createNextNode(lastNode, value);
        size++;
        modCount++;
    }

    private TNode<T> createNextNode(TNode<T> startnode, T value) {
        TNode<T> newNode;
        if (size > 0){
            newNode = startnode.createNextNode(value);
        }else{
            newNode = createFirstNode(value);
        }
        return newNode;
    }

    private TNode<T> createBeforeNode(TNode<T> startnode, T value) {
        TNode<T> newNode;
        if (size > 0) {
            newNode = startnode.createBeforeNode(value);
        } else {
            newNode = createFirstNode(value);
        }
        return newNode;
    }

    public void set(T value, TNode<T> node){
        node.setValue(value);
        modCount++;
    }

    public void set(T value, int index) {
        getNodeIndex(index).setValue(value);
        modCount++;
    }

    public void insertAfter(T value, int index) {
        TNode<T> node = getNodeIndex(index);
        insertAfter(value, node);
    }

    public void insertAfter(T value, TNode<T> node){
        TNode<T> newNode = node.createNextNode(value);
        lastNode = (node == lastNode ? newNode : lastNode);
        size++;
        modCount++;
    }

    public void insert(T value, int index) {
        TNode<T> node = getNodeIndex(index);
        insert(value, node);
    }

    public TNode<T> insert(T value, TNode<T> node) {
        TNode<T> newNode = createBeforeNode(node, value);
        if(firstNode != null && firstNode == node){
            this.firstNode = newNode;
        }
        size++;
        modCount++;
        return newNode;
    }

    public void remove(int index){
        TNode<T> node = getNodeIndex(index - 1);
        remove(node);
    }
    
    public void remove(TNode<T> node) {
        node.removeNode();
        size--;
        modCount++; 
    }

    public void removeNext(TNode<T> node){
        node.removeNextNode();
        size--;
        modCount++;
    }
    
    public T pullFirst(){
        T value = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        firstNode.setBeforeNode(null);
        size--;
        modCount++;
        return value;
    }

    public T get(int index){
        return getNodeIndex(index).getValue();
    }
    
    public T get(TNode<T> node) {
        return node.getValue();
    }

    public TNode<T> getNodeIndex(int index){
        Objects.checkIndex(index, size);
        TNode<T> current = firstNode;
        int i = 0;
        while(i < index){
            if (current.getNextNode() == null) {
                System.out.println("TLInkedList is only" + i + "elements long");
                break;
                }
            current = current.getNextNode();
            i++;
        }
        return current;
    }

    public void toArray(Object[] arr){
        TNode<T> node = firstNode;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = node.getValue();
            node = node.getNextNode();
        }
    }
    
    public TNode<T> createFirstNode(T value){
        firstNode = new TNode<T>(this, null, null, value);
        lastNode = firstNode;
        size++;
        return firstNode;
    }

    public int modCount() {
        return this.modCount;
    }
}