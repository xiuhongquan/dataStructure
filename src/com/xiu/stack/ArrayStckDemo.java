package com.xiu.stack;

public class ArrayStckDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.pop();
        arrayStack.show();
    }
}

//定义一个数组栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top =-1;//表示栈顶
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull(){
        return top==maxSize;
    }

    /**
     * 判断栈空
     */
    public boolean isEmoty(){
        return top==-1;
    }

    /**
     * 入栈操作
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmoty()){
            System.out.println("空");
        }
        int value=stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈，倒序
     */
    public void show(){
        if(isEmoty())
            System.out.println("没有数据");
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}
