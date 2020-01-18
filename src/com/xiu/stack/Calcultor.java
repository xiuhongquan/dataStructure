package com.xiu.stack;

/**
 * 栈实现计算器
 */
public class Calcultor {
    public static void main(String[] args) {
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        String expression="6+2*6-2";//16
        int index=0;//扫描的元素
        int num1;
        int num2;
        int oper;//操作符
        int res;
        String keepNum = "";//用于拼接多位数字
        char ch;//保存每次扫描得到的char
        while (true){
            ch=expression.substring(index, index+1).charAt(0);
            //判断ch是什么
            if(operStack.isOper(ch)){
                //是操作符，先判断符号栈是否为空，如果没空，就直接入栈
                //如果不为空需要先判断优先级
                if(!operStack.isEmoty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        //从数栈中pop两个数进行运算
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1, num2, oper);
                        numStack.push(res);//将运算结果放入数栈
                        operStack.push(ch);//将当前符号放入符号栈
                    }else {
                        //当前操作符优先级大于栈中的优先级，就直接入符号栈
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                //当前扫描的如果是数字就直接入数栈
                //因为ascii中数字1的值是49
//                numStack.push(ch-48);
                //没有考虑多位数的情况
                //如果第一位是数字，需要判断下一位是否也是数字，直到发现符号位
                keepNum +=ch;
                //如果ch是最后一位，不需要判断，直接入栈
                if(index==expression.length()-1)  numStack.push(Integer.parseInt(keepNum));
                //如果后一位是操作符
                if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))){
                    //入栈
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum="";//将当前值加入数栈后，将keepNum清空
                }
            }
            index++;
            if(index>=expression.length()) break;
        }
        //扫描完毕后，就顺序的从数栈和符号栈中pop出相应的数字和符号，运算
        while (true){
            if(operStack.isEmoty())    break;
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("结果"+numStack.pop());
    }
}
//定义一个数组栈
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top =-1;//表示栈顶

    public ArrayStack2(int maxSize){
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

    /**
     * 返回当前栈顶的值,并不是出栈
     */
    public int peek(){
        return stack[top];
    }

    /**
     * 返回运算符的优先级，自己定义。
     * 数字越大，优先级越高
     */
    public int priority(int oper){
        if(oper == '*' || oper =='/'){
            return 1;
        }else if(oper =='+' ||oper == '-'){
            return 0;
        }else {
            return -1;//设定运算符只有+-*/
        }
    }

    /**
     * 判断是否是运算符
     */
    public boolean isOper(char value){
        return value=='+' || value=='-' || value=='*' || value=='/';
    }

    /**
     * 运算
     */
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}
