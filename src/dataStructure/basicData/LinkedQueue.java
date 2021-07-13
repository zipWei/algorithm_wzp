package dataStructure.basicData;

/***
 * 使用链表模拟队列的出队与入队
 */

import dataStructure.until.Node;

/**
 * 这是用链表模仿队列的入队出队
 * 简单的先使用int来使用
 */
public class LinkedQueue {
     Node nodeHead = null;

    //入队列
    public void inQueue(int num){
        if (nodeHead == null){
            nodeHead = new Node(num);
        }else {
            nodeHead.addLastNode(new Node(num));
        }
    }
    //出队列
    public void outQueue(){
        if (nodeHead == null){
            System.out.println("队列已空");
            return;
        }
        nodeHead = nodeHead.getNextNode();
    }
    //遍历队列
    public String toString(){
        return this.nodeHead.toString();
    }

    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.inQueue(1);
        lq.inQueue(2);
        lq.inQueue(3);
        lq.outQueue();
        lq.inQueue(4);
        lq.inQueue(5);
        lq.outQueue();
        lq.inQueue(6);
        System.out.println(lq);

    }
}
