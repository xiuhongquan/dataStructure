package com.xiu.recursion;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        test(8);
        int[][] x={
                {1,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,3,2,0,0,0},
                {0,0,0,0,0,4},
                {5,0,0,0,0,3},
                {2,0,0,6,0,0}
        };
        Test test = new Test(x);
        //test.testR(0,0);
        test.testMapPut();
    }

    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println(n);
    }
    int[][] x;
    public Test(int[][] x){
        this.x=x;
    }
    public void testR(int i,int j){
        if(i == 5 && j == 6){
            System.out.println("得到结果");
            printArr();
            return;
        }
        if(j==6){
            i++;
            j=0;
        }
        if(x[i][j]== 0){
            for(int k=1;k<=6;k++){
                if(check(i,j,k)){
                    x[i][j]=k;
                    testR(i,j+1);
                    x[i][j]=0;
                }
            }
        }else{
            testR(i,j+1);
        }
    }

    public boolean check(int row,int line,int num){
        for(int i=0;i<4;i++){
            if(x[row][i] == num || x[i][line] == num){
                return false;
            }
        }
        return true;
    }

    public void printArr(){
        System.out.println("jaja:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void testMapPut(){
        HashMap<String, String> map = new HashMap<>();
        map.put("test1", "aaa");
        map.put("test2", "bbb");
        map.put("test1", "ccc");
        System.out.println("aaa");
    }
}
