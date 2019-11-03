package datastruct.recur;

import java.util.LinkedList;
import java.util.List;

/**
 * 77 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {


    List<List<Integer>> output = new LinkedList<>();

    int n;
    int k;

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4,2);
        System.out.println(c.output);

//
//
//        for (int j = 1; j <= 4; j++) {
//            int result = c.sumNum(j,0,0);
//            System.out.println(result + ",");
//            System.out.println("###########################");
//
//        }
    }

    public int sumNum(int n,int i,int j) {
        if (n==1 || n==2) {
            System.out.println("i:"+i + "\tj:"+j + "\t1" );
            return 1;
        }
        int result = sumNum(n-1,i+1,j)+sumNum(n-2,i,j+1);
        //ystem.out.println("i:"+i + "\tj:"+j+"\tn:"+ n + "\t"+result);
        return result;
    }

    public List<List<Integer>> combine(int n,int k) {
        this.n = n;
        this.k = k;
        backtrack(1,new LinkedList<>());
        return output;
    }

    public void backtrack(int first,LinkedList<Integer> curr) {
        if (curr.size() == k)
            output.add(new LinkedList<>(curr));

        for (int i = first;i < n+1;++i) {
            curr.add(i);
            backtrack(i+1,curr);
            curr.removeLast();
        }
    }
}
