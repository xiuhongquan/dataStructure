package com.xiu.recursion;

/**
 * 八皇后问题
 */
public class Queue {
    int max=8;
    int[] array=new int[max];//array[n]=i,n是第n行，i是第i列
    static int count=0;//共有多少种解法
    static int num=0;//共判断多少次
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.println(count);
        System.out.printf("共进行判断%d次", num);//%d输出整数，%s输出浮点型
    }

    /**
     * 编写一个方法,放置第N个皇后
     *
     */
    private void check(int n){
        if(n == max){
            //n=8时说明八个皇后已经摆放好了
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        //todo 如何实现回溯的？？？
        for (int i = 0; i <max ; i++) {
            //先把当前这个皇后放入该行的第一列
            array[n]=i;
            //判断当前位置是否和前面的皇后位置冲突
            if (judge(n)){
                //不冲突就开始放第n+1个皇后
                check(n+1);
            }
            //如果冲突，继续执行array[n]=i,因为在for循环中，相当于将第一列往后移一位
        }
    }

    /**
     * 查看当前皇后的摆放位置是否和前面已经摆好的皇后冲突
     */
    private boolean judge(int n){
        num++;
        for (int i=0;i<n;i++){
            //在同一列或者同一条斜线上
            if(array[i]==array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i : array) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
