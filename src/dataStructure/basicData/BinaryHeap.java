package dataStructure.basicData;


import dataStructure.until.Array;

/***
 * 使用数组构建最大堆
 * 实际上实现了优先队列
 */
public class BinaryHeap{

    Array<Integer> array;

    public Array<Integer> getArray() {
        return array;
    }

    public void setArray(Array<Integer> array) {
        this.array = array;
    }


    /**
     * 添加新的节点
     * 将新的节点放到数组最后，之后和父节点比较并交换位置
     * @param value
     */
    public void add(int value){
        if (array == null){
            array = new Array<>(3);
            array.put(value);
        }else {
            //先将其放到最后，然后进行移位
            array.put(value);
            addRecursion(array.lenth - 1,value,array);
        }
    }
    //add的递归方法
    public void addRecursion(int index,int value,Array<Integer> array){
        if (index > 0 && value>array.get((index-1)/2)){
            array.put((index-1)/2,array.get((index-1)/2)+value);
            array.put(index,array.get((index-1)/2)-value);
            array.put((index-1)/2,array.get((index-1)/2)-array.get(index));
            addRecursion((index-1)/2,value,array);
        }else {
            return;
        }
    }

    /**
     * 删除节点
     * 先删除最大值（堆顶），然后将最后的节点放到堆顶，之后和左右节点对比取左右节点的最小值进行下沉
     * @param
     */
    public void deleteRoot(){
        if (this.array.lenth<=2){
            array.put(0,array.get(1));
            array.remove();
            return;
        }
        array.put(0,array.get(array.lenth-1));
        array.remove();
        deleteRoot(0,this.array);

    }
    public void deleteRoot(int index,Array<Integer> array){
        if ((index*2+1) >= array.lenth){return;}
        int sunIndex = array.get(index+1)>array.get(index+2)?index+1:index+2;
            if (array.get(index) < array.get(sunIndex)) {
                int mid = array.get(index);
                array.put(index, array.get(sunIndex));
                array.put(sunIndex, mid);
                deleteRoot(sunIndex,array);
            }
    }
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.add(1);
        binaryHeap.add(2);
        binaryHeap.add(6);
        binaryHeap.add(5);
        binaryHeap.add(80);
        binaryHeap.add(12);
        binaryHeap.add(25);

        binaryHeap.deleteRoot();
        binaryHeap.deleteRoot();
        binaryHeap.deleteRoot();

        System.out.println(binaryHeap.getArray());





    }
}
