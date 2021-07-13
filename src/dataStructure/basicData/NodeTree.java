package dataStructure.basicData;

import dataStructure.until.Array;
import dataStructure.until.Node;

/**
 * 这是一颗二叉排序树
 *
 * 使用链表完成二叉树数据结构
 * 实现简单的增加和查找和遍历
 */
public class NodeTree {

    //根据数值大小添加左节点或者右节点
    //默认头节点不为空
    int index = 0;
    Node<Integer> headNode;


    public Node<Integer> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<Integer> headNode) {
        this.headNode = headNode;
    }

    //添加树叶
    public void add(int value){
        if (this.getHeadNode() == null){
            this.setHeadNode(new Node<>(value));
            return;
        }
        addNode(value,this.getHeadNode());
    }
    //遍历

    //查找树值
    public void query(int value){
        query(value,headNode);
    }

    public void addNode(int values, Node<Integer> headNode){
        if (values > headNode.getT()) {
            if (headNode.getNextNode() == null) {
                headNode.setNextNode(new Node(values));
            } else {
                addNode(values, headNode.getNextNode());
            }
        }else {
            if (headNode.getPreNode() == null) {
                headNode.setPreNode(new Node(values));
            } else {
                addNode(values, headNode.getPreNode());
            }
        }
    }

    //查找
    public void query(int valuse,Node<Integer> headNode){
        if (headNode == null){
            System.out.println("没找到。。。。。。");
            return;
        }
        index++;
        if (valuse==headNode.getT()){
            System.out.println("已找到！查找次数为:"+index);
            return;
        }else if (valuse>headNode.getT()){
            query(valuse,headNode.getNextNode());
        }else {
            query(valuse,headNode.getPreNode());
        }
    }
    //深度优先遍历-前序遍历-（根节点-左子树-右子树）
    public void rootLRItertor(){
        rootLRItertor(this.getHeadNode());
    }
    public void rootLRItertor(Node<Integer>   headNode){
        System.out.print(headNode.getT());

        if (headNode.getPreNode() != null){
            rootLRItertor(headNode.getPreNode());
        }
        if (headNode.getNextNode()!=null){
            rootLRItertor(headNode.getNextNode());
        }
    }
    //深度优先遍历-中序遍历-（左-根-右）
    public void leftRRItertor(){
        leftRRItertor(this.getHeadNode());
    }
    public void leftRRItertor(Node headNode){
        if (headNode.getPreNode() != null){
            leftRRItertor(headNode.getPreNode());
        }
        System.out.print(headNode.getT());
        if (headNode.getNextNode()!=null){
            leftRRItertor(headNode.getNextNode());
        }
    }
    //深度优先遍历-后序遍历-（左-右-根）
    public void leftRightRItertor(){
        leftRRItertor(this.getHeadNode());
    }
    public void leftRightRItertor(Node<Integer>  headNode){
        if (headNode.getPreNode() != null){
            leftRightRItertor(headNode.getPreNode());
        }
        if (headNode.getNextNode()!=null){
            leftRightRItertor(headNode.getNextNode());
        }
        System.out.print(headNode.getT());

    }
//    广度优先遍历-层序优先遍历-（从上到下，从左到右）--未完成
    public void topToDown(){
        Array<Node<Integer>> arrays = new Array<>(100);
        arrays.put(this.getHeadNode());
        topToDown(this.getHeadNode(),arrays);
    }
    public void topToDown(Node<Integer> headNode, Array<Node<Integer>> array){
        if (headNode.getPreNode()!=null){array.put(headNode.getPreNode());}
        if (headNode.getNextNode()!=null){array.put(headNode.getNextNode());}
        System.out.print(array.get(array.getHeadIndex()).getT());
        array.remove(array.getHeadIndex());
        if (array.getHeadIndex()>=0){
            topToDown(array.get(array.getHeadIndex()),array);
        }

    }
    public static void main(String[] args) {
        NodeTree nodeTree = new NodeTree();
        nodeTree.add(4);
        nodeTree.add(2);
        nodeTree.add(1);
        nodeTree.add(3);
        nodeTree.add(5);
        nodeTree.add(6);

        nodeTree.rootLRItertor();
        System.out.println();
        nodeTree.leftRRItertor();
        System.out.println();
        nodeTree.leftRightRItertor();
        System.out.println();
        nodeTree.topToDown();
    }


}
