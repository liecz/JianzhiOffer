package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Q:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * https://leetcode.com/articles/next-permutation/
 * Created by liec on 2017-02-15.
 */
public class Solution_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str!=null&&str.length()>0){
            char[] seq = str.toCharArray();
            Arrays.sort(seq);
            result.add(String.valueOf(seq));
            int len = seq.length;
            while (true){
                int i = len - 2;
                while(i>=0&&seq[i] >= seq[i+1]) i--;
                if(i==-1) break;
                if(i>=0){
                    int j = i+1;
                    while(j<len&&seq[i] < seq[j]) j++;
                    swap(seq,i,j-1);
                }
                reverse(seq,i+1);
                result.add(String.valueOf(seq));
            }
        }
        return result;
    }
    private void swap(char[] seq,int i,int j){
        char t = seq[i];
        seq[i] = seq[j];
        seq[j] = t;
    }
    private void reverse(char[] seq,int i){
        int j = seq.length - 1;
        while(i<j){
            swap(seq,i,j);
            i++;j--;
        }
    }
}
