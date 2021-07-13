package dataStructure.until;

/**
 * 仿ArrayList
 * 数组+扩容
 * @param <E>
 */
public class Array<E> {
    private Object[] objects;
    //数组储存值的有效长度
    public int lenth;
    //当前Object数组的总长度
    public int arrayLenth;
    public Array(){
        this(10);
    }
    public Array(int intlenth) {
        objects =  new Object[intlenth];
        lenth = 0;
        arrayLenth = objects.length;
    }
    //末尾添加
    public void put(E e){
        put(lenth,e);
    }
    //末尾删除
    public void remove(){
        remove(lenth-1);
    }

    public void put(int i ,E e){
        //判断是否是修改
        if (objects[i] == null) {
            lenth++;
        }
        objects[i] = e;
        //扩容 object数组长度*2
        if (lenth == objects.length) {
            Object[] objectsAdd = new Object[objects.length*2];
            for (int k =0;k<objects.length;k++){
                objectsAdd[k] = objects[k];
            }
            this.objects = objectsAdd;
            arrayLenth = objects.length;
        }


    }
    public E get(int i){
        return (E) objects[i];
    }

    //删除
    public void remove(int i){
        if (objects[i]!=null){
            objects[i]=null;
            for (;i<this.lenth-1;i++){
                objects[i] = objects[i+1];
            }
            lenth--;
        }

    }
    //获取头坐标(查看前面有多少空值)
    public int getHeadIndex(){
        for (int i=0;i<=lenth;i++){
            if (objects[i]!=null){
                return i;
            }
        }
        return -1;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Object o : objects) {
            if (o!=null) {
                s.append(o.toString()+" ");
            }
        }
        return s.toString().trim();
    }
}
