package com.xiu.queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        char aaa;
        while (loop){
            System.out.println("e:退出队列");
            System.out.println("s:显示队列");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列获取数据");
            System.out.println("h:队列头数据");
            aaa=scanner.next().charAt(0);
            switch (aaa){
                case 'a':
                    int a;
                    System.out.println("输入要添加的数字");
                    a=scanner.nextInt();
                    queue.addToWueue(a);
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    queue.getFromQueue();
                    break;
                case 'h':
                    int head=queue.headQueue();
                    System.out.println("head:"+head);
                    break;
            }
        }
    }
}

class Queue{
    private int maxSize;//数组最大容量
    private int front=-1;//队列头指针,指向队列的第一个数据的前一个位置
    private int rear=-1;//队列尾，指向队列尾的最后一个数据的位置，即队列的最后一个数据
    private int[] arr;//模拟队列

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }


    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        return this.rear == this.maxSize-1;
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
        rear++;
        arr[rear]=data;
    }

    /**
     * 获取队列的数据，出队列
     */

    public int getFromQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("空");
            return;
        }
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }

    /**
     * 队列头数据
     * @return
     */
    public int headQueue(){
        if(isEmpty()) throw new RuntimeException("空");
        return arr[front+1];
    }
}
