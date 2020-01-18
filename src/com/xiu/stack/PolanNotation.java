package com.xiu.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 实现逆波兰表达式计算器
 */
public class PolanNotation {
    public static void main(String[] args) {
        /*//(3+4)*5-6 ---> 3 4 + 5 x 6 -
        String expression="3 4 + 5 * 6 -";
        List<String> list = getList(expression);*/
        convert();
    }

    public static List<String> getList(String expression){
        String[] strings = expression.split(" ");
        return Arrays.asList(strings);
    }

    /**
     * 完成计算
     * @param list
     */
    public int calc(List<String> list){

        //定义一个栈用来存放数
        Stack<String> stack=new Stack<String>();
        for (String s : list) {
            if(s.matches("\\d+")){
                //匹配的是多位数
                stack.push(s);
            }else {
                //是操作符，就pop出两个数进行运算之后再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if(s.equals("+")){
                    res=num1+num2;
                }else if(s.equals("-")){
                    res=num1-num2;
                }else if(s.equals("*")){
                    res=num1*num2;
                }else if(s.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("错误");
                }
                //把结果入栈
                stack.push(""+res);
            }
        }
        //最后留在栈中的数就是结果
        return Integer.parseInt(stack.pop());
    }


    /**
     * 中缀表达式转后缀表达式功能实现
     * 1+((2+3)*4)-5 ---> 1 2 3 + 4 * + 5 -
     */
    public static void convert(){
        String expression="1+((2+3)*4)-5";
        List<String> list=toList(expression);
        System.out.println("中缀表达式的list"+list);
        List<String> strings = tosuffixExpression(list);
        System.out.println("后缀表达式的list"+strings);
    }

    /**
     * ArrayList[1,+,(,(,2,+,3,),*,4,),-,5,]--->ArrayList[1,2,3,+,4,*,5,-]
     *将得到的中缀表达式list转换成后缀表达式list
     */
    public static List<String> tosuffixExpression(List<String> list){
        //定义两个栈
        Stack<String> s1=new Stack<>();//符号栈
        //另外s2这个栈没有pop操作，并且还需要倒序输出栈的元素，所以使用list
        List<String> s2=new ArrayList<>();
        for (String item : list) {
            //如果是数字，就加入到s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")) {
                //左括号直接入符号栈
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                    break;
                }
                s1.pop();//将（小括号弹出s1栈，消除小括号
            }else {
                //当s1的运算符的优先级小于s1栈顶的优先级，就将s1的运算符加入s2栈
                while (s1.size() !=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                    break;
                }
                //将item压入栈中
                s1.push(item);
            }

        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }


    /**
     * 将中缀表达式转成对应的list
     */
    public static List<String> toList(String exp){
        int index=0;//索引
        String str;//拼接多位数
        char c;//遍历到的字符
        List<String> list=new ArrayList<>();
        do {
            if( (c=exp.charAt(index))<48 || (c=exp.charAt(index) )>57){
                list.add(""+c);
                index++;
            }else{
                str="";
                while(index<exp.length() && (c=exp.charAt(index))>=48 && (c=exp.charAt(index) )<=57){
                    str=str+c;
                    index++;
                }
                list.add(str);
            }
        }while (index < exp.length());
        return list;
    }
}


class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    //返回对应的优先级数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
        }
        return result;
    }
}
