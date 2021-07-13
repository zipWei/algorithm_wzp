package dataStructure.until;

/**
 * 基本链表
 * @param <T>
 */
public class Node<T> {

    private T t;
    private Node<T> nextNode;
    private Node<T> preNode;

    public Node() {
    }
    public Node(T t){
        this.t = t;
    };

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getPreNode() {
        return preNode;
    }

    public void setPreNode(Node<T> preNode) {
        this.preNode = preNode;
    }



    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


    //寻找头节点
    public Node getHeadNode(Node node){
        while(node.getPreNode()!=null){
            return getHeadNode(node.getPreNode());
        }
        return node;
    }

    //增加最后一个节点的列表
    public void addLastNode(Node node){
        if (this.nextNode !=null){
            this.nextNode.addLastNode(node);
        }else{
            node.setPreNode(this);
            this.nextNode = node;
        }
    }


    //循环展示Node的值(该链表的所有值)
    public  String toString(){
        String ret= this.getT().toString();
        if (this.nextNode!=null){
            return ret+"->"+this.getNextNode().toString();
        }
        return ret;
    }

}
