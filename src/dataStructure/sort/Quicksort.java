package dataStructure.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 * 本类使用单边循环（还可以使用双边循环）
 */
public class Quicksort {


    public int sortdg(int[] ints,int startIndex,int endIndex){
        int js = ints[startIndex],index = startIndex;
        for (int i = startIndex + 1;i<=endIndex;i++){
         if (ints[i] >= js){continue;}else {
             index++;
             int mid = ints[index];
             ints[index] = ints[i];
             ints[i] = mid;
         }
        }
        ints[startIndex] = ints[index];
        ints[index] = js;
        return index;
    }
    //给一个数组然后排序--递归写法
    public void sort(int[] ints,int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return ;
        }
        int index = sortdg(ints,startIndex,endIndex);

        sort(ints,startIndex,index - 1);
        sort(ints,index + 1,endIndex);
    }
    //出入栈写法
    public void stackSort(int[] ints,int startIndex,int endIndex){
        Stack<Map<String,Integer>> stack = new Stack<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",startIndex);
        map.put("endIndex",endIndex);
        stack.push(map);

        while (!stack.isEmpty()){
            Map<String,Integer> lmap = stack.pop();
            int index = sortdg(ints,lmap.get("startIndex"),lmap.get("endIndex"));
            if (lmap.get("startIndex") < index -1){
                Map<String,Integer> leftMap = new HashMap<>();
                leftMap.put("startIndex",lmap.get("startIndex"));
                leftMap.put("endIndex",index -1);
                stack.push(leftMap);
            }
            if (lmap.get("endIndex") > index + 1){
                Map<String,Integer> rightMap = new HashMap<>();
                rightMap.put("startIndex",index + 1);
                rightMap.put("endIndex",lmap.get("endIndex"));
                stack.push(rightMap);
            }
        }
    }


    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        int[] is = {55,1,23,45,78,2,0,23,56,89,2};
        quicksort.stackSort(is,0,is.length-1);


        for (int i:is ) {
            System.out.print(i+" ");
        }

    }
}
