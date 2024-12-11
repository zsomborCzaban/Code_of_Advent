package utils;

//doubly linked list without a head element
//optimally this should have a wrapper class with a head node and methods that are usable without knowing the implementation of them. (for our use case it's fine)
public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> nodeBefore;
    private LinkedListNode<T> nodeAfter;

    public LinkedListNode(T data, LinkedListNode<T> nodeBefore, LinkedListNode<T> nodeAfter) {
        this.data = data;
        this.nodeBefore = nodeBefore;
        this.nodeAfter = nodeAfter;
    }

    public T getData() {
        return data;
    }

    public LinkedListNode<T> getNodeBefore() {
        return nodeBefore;
    }

    public LinkedListNode<T> getNodeAfter() {
        return nodeAfter;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNodeBefore(LinkedListNode<T> nodeBefore) {
        this.nodeBefore = nodeBefore;
    }

    public void setNodeAfter(LinkedListNode<T> nodeAfter) {
        this.nodeAfter = nodeAfter;
    }

    public void addBefore(T data){
        //this.elementBefore = new CustomLinkedList<T>(data, this.elementBefore, this);
        LinkedListNode<T> newNode = new LinkedListNode<T>(data, this.nodeBefore, this);
        if(nodeBefore != null) this.nodeBefore.nodeAfter = newNode;
        this.nodeBefore = newNode;
    }

    public void addAfter(T data){
        //this.elementAfter = new CustomLinkedList<T>(data, this, this.elementAfter);
        LinkedListNode<T> newNode = new LinkedListNode<T>(data, this, this.nodeAfter);
        if(nodeAfter != null) this.nodeAfter.nodeBefore = newNode;
        this.nodeAfter = newNode;
    }

    public void remove(){
        if(nodeBefore != null) {
            this.nodeBefore.nodeAfter = this.nodeAfter;
        }

        if(nodeAfter != null){
            this.nodeAfter.nodeBefore = this.nodeBefore;
        }
    }

    public LinkedListNode<T> getStartNode(){
        if(nodeBefore == null) return this;
        return nodeBefore.getStartNode();
    }

    //this method should be in a wrapper class
    public int getSize(){
        if(nodeBefore != null) return -1;

        LinkedListNode<T> currentNode = this;
        int cnt = 0;
        while(currentNode != null){
            cnt += 1;
            currentNode = currentNode.nodeAfter;
        }

        return cnt;
    }

    //this method should be in a wrapper class, and it could be named toString()
    public String wholeListToString(){
        if(nodeBefore != null) return "WholeListToString() method wasn't used on the head of the list";
        StringBuilder sb = new StringBuilder();
        sb.append(data);

        LinkedListNode<T> currentNode = nodeAfter;
        while(currentNode != null){
            sb.append(", ");
            sb.append(currentNode.data);
            currentNode = currentNode.nodeAfter;
        }

        return sb.toString();
    }

}
