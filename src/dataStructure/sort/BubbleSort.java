package dataStructure.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] is = {55,1,23,45,78,2,0,23,56,89,2};

        bubbleSort.sort(is);
        for (int i:is ) {
            System.out.print(i+" ");
        }

    }

    //给一个数组然后排序
    public int[] sort(int[] ints){
        for (int i = 0;i<=ints.length - 1;i++){
            for (int j = 0;j<ints.length - 1 - i;j++){
                if (ints[j] > ints[j + 1]){
                    int mid = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = mid;
                }
            }
        }
        return ints;
    }
}
