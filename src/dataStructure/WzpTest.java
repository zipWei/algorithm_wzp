package dataStructure;

import dataStructure.until.Array;
import dataStructure.until.KeyValuePair;
import dataStructure.until.Node;

public class WzpTest {
    KeyValuePair keyValuePairRoot;
    public static void main(String[] args) {
        WzpTest wzpTest = new WzpTest();
        wzpTest.keyValuePairRoot = new KeyValuePair("2",1);
        wzpTest.test1();
    }

    public void test(KeyValuePair keyValuePair){
        keyValuePair.setKey("999");
        System.out.println(this.keyValuePairRoot);
    }
    public void test1(){
        Array<Integer> array = new Array<>(10);
        array.put(0,0);
        array.put(1,1);
        array.put(2,2);
        System.out.println(array.get(1)+array.get(2));
        array.remove(2);
        System.out.println(array.get(1)+array.get(2));
        System.out.println(array.get(2));
        System.out.println(array.get(2));
        System.out.println(array.get(34));
    }
    
}
