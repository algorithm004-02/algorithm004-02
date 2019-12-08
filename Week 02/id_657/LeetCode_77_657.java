package com.arithmetic.arithmetic.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_657 {

    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if(k>n)return list;
        List<Integer> ll = new ArrayList<Integer>();
        for(int i=1; i<=n;i++){
            ll.add(i);
        }
        if(k==n){
            list.add(ll);
            return list;
        }
        List<Integer> res = new ArrayList<Integer>();
        get(ll,k,res,0);
        return list;
    }
    
    private void get(List<Integer> ll, int k, List<Integer> res,int start){
        if(k==ll.size()-start){
            List<Integer> newl = new ArrayList<Integer>();
            newl.addAll(res);
            for(int v=start; v<ll.size();v++){
                newl.add(ll.get(v));
            }
            list.add(newl);
            return;
        }
        int i = ll.get(start);
        start++;

        get(ll,k,res,start);
        List<Integer> newl = new ArrayList<Integer>();
        newl.addAll(res);
        newl.add(i);
        if(k-1==0){
            list.add(newl);
        }else{
            get(ll,k-1,newl,start);
        }

    }


}
