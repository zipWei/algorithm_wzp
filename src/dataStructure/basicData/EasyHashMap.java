package dataStructure.basicData;

import dataStructure.until.KeyValuePair;
import dataStructure.until.Node;


/**
 * 使用数组链表实现一个简易的hashMap
 */
public class EasyHashMap {
    //初始化一个键值对数组
    int lenth;
    Node<KeyValuePair>[] nodes ;


    public EasyHashMap(int lenth) {
        this.lenth = lenth;
        nodes = new Node[3];

    }

    //获取key的hashcode对应的数组坐标
    private int getcode(int hashcode){
        return hashcode%nodes.length;
    }


    //在链表中寻找相同Key的元素
    public Node getNodeByKey(Node<KeyValuePair> headNode,String key){
        if (!headNode.getT().getKey().equals(key)){
            if (headNode.getNextNode()==null ){
                return null;
            }else {
                return getNodeByKey(headNode.getNextNode(), key);
            }
        }
        return headNode;
    }
    //遍历EasyHashMap
    public String toString(){
        String rt = "";
        for (int i =0;i<nodes.length;i++) {
            if (nodes[i]!=null) {
                rt = rt + nodes[i].toString() + "\n\r";
            }else {
                rt = rt+"\n\r";
            }
        }
        return rt;
    }

    //增加修改数据
    public void put(String key, Object value) {
        KeyValuePair keyValuePair = new KeyValuePair(key,value);
        int sub = getcode(key.hashCode());
        if (nodes[sub] == null) {
            nodes[sub] = new Node(keyValuePair);
        } else if (getNodeByKey(nodes[sub],key) != null){
            getNodeByKey(nodes[sub],key).setT(keyValuePair);
        }else {
            nodes[sub].addLastNode(new Node(keyValuePair));
        }
    }

    //删除数据
    public void deleteByKey(String key) {
        int sub = getcode(key.hashCode());
        if (nodes[sub] == null){return;}
        Node<KeyValuePair> node = getNodeByKey(nodes[sub],key);
        if (node.getPreNode()!=null){
            node.getPreNode().setNextNode(node.getNextNode());
        }else {
            nodes[sub] = node.getNextNode();
        }
    }




    public static void main(String[] args) {
        EasyHashMap map = new EasyHashMap(3);
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");
        map.put("6","e");
        map.put("7","e");
        map.put("8","e");
        map.put("9","e");
        map.put("5","9999");
        map.deleteByKey("7");


        System.out.println(map.toString());

    }



}
