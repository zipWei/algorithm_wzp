package dataStructure.basicData;
/***
 * 使用数组实现栈操作
 */
public class ArrayStack {
    static int[] ins = new int[9];
    static int top = 0;
    static int max = 8;
    public static void main(String[] args) {
        statckIn(ins, 1);
        statckIn(ins, 2);
        statckOut(ins);
        statckOut(ins);
        statckOut(ins);
        statckIn(ins, 3);
        statckIn(ins, 4);
        statckOut(ins);
        statckOut(ins);
        statckIn(ins, 5);
        statckIn(ins, 6);
        statckOut(ins);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);
        statckIn(ins, 6);

    }
    //出栈
    public static int[] statckOut(int[] ins){
        if (top<=0){
            System.out.println("别出去了，一滴也没有了...");
            return ins;
        }
        System.out.println(ins[top-1]+"已出栈");
        ins[top-1] = 0;
        top--;
        System.out.print("栈内数据为");
        for (int t: ins ) {
            System.out.print(t+" ");
        }
        System.out.println();
        return ins;
    }
    //入栈
    public static int[] statckIn(int[] ins,int i){
        if (top>=max){
            System.out.println("都堆满了，实在挤不下了......");
            return ins;
        }
        ins[top] = i;
        top++;
        System.out.println(i+"已入栈");
        System.out.print("栈内数据为");
        for (int t: ins ) {
            System.out.print(t+" ");
        }
        System.out.println();
        return ins;
    }


}
