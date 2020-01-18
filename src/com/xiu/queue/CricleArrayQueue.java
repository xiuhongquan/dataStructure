package com.xiu.queue;

public class CricleArrayQueue {
}

/**
 * 环形数组队列
 */
class CricleQUeue{
    private int maxSize;//数组最大容量
    /**
     *     front:修改为指向队列的第一个元素，也就是说arr[front]是队列的第一个元素。
     *     front=0ront:修改为指向队列的第一个元素，也就是说arr[front]是队列的第一个元素。front=0
     */
    private int front;
    /**
     * rear：修改为指向队列的最后一个元素的后一个位置。因为希望留出一个空间作为约定。rear=0
     */
    private int rear;
    private int[] arr;//模拟队列

    public CricleQUeue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }

    /**
     * 一个大小为4的数组
     * 1,2,3 front=0,rear=3
     *3+1/4=
     *
     *
     */
    /**
     * 判断队列是否满
     * 条件是(rear+1)%maxSize=front
     */
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return this.front == this.rear;
    }

    /**
     * 添加数据到队列
     */
    public void addToWueue(int data){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear]=data;
        //将rear后移
        rear=(rear+1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     */

    public int getFromQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        //front是指向队列的第一个元素
        //1.先将front保存到临时变量
        //2.将front后移，考虑取模，不然会下标越界
        //3.将临时变量返回
        int value=arr[front];
        front=(front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("空");
            return;
        }
        //从front开始遍历多少个元素就可以
        for (int i = front; i <front+size() ; i++) {
            System.out.println(arr[i%maxSize]);
        }
    }

    /**
     * 求出当前队列的有效个数
     *
     */
    public int size(){
        return (rear+maxSize-front) % maxSize;
    }
    /**
     * 队列头数据
     * @return
     */
    public int headQueue(){
        if(isEmpty()) throw new RuntimeException("空");
        return arr[front];
    }
}
