package com.xiu.linkedList;

/**
 * 约瑟夫问题：使用单向环形链表
 */
public class Josephu {
    public static void main(String[] args) {
        CricleLinkedList cricleLinkedList = new CricleLinkedList();
        cricleLinkedList.addBoys(5);
//        cricleLinkedList.showList();
        cricleLinkedList.countBoy(1, 2, 5);
    }
}

/**
 * 创建一个环形链表
 *
 */
class CricleLinkedList{
    private Boy first=new Boy(0);
    //添加节点，构建环形链表
    public void addBoys(int nums){
        if(nums < 1){
            return;
        }
        Boy cur=null;
        for (int i = 1; i <=nums ; i++) {
            //创建小孩节点
            Boy boy=new Boy(i);
            if(i ==1){
                first=boy;//让第一个节点自己形成环形
                boy.setNext(first);
                cur=first;
            }else {
                //后面的节点就加到最后一个节点后面
                cur.setNext(boy);
                boy.setNext(first);
                cur=cur.getNext();
            }
        }
    }

    /**
     * 遍历当前环形链表
     */
    public void showList(){
        if(first ==null){
            System.out.println("链表为空");
        }
        Boy cur=first;
        while (true){
            System.out.println("编号"+cur.getNo());
            if(cur.getNext()==first){
                System.out.println("已经遍历完成");
                break;
            }
            cur=cur.getNext();
        }
    }

    /**
     * 根据countNum计算出队列的顺序
     * @param startNo 起始位置
     * @param countNums 数几下
     * @param num 最初队列中有多少个
     */
    public void countBoy(int startNo,int countNums,int num){
        if(first == null || startNo < 1 || startNo >num){
            System.out.println("有问题");
            return;
        }
        Boy helper=first;
        while (true){
            if(helper.getNext() == first){
                //helper是最后一个节点
                break;
            }
            helper=helper.getNext();
        }
        //出队列前先让first和helper移动到startNo位置
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //开始出队列
        while (true){
            if(helper==first)break;
             for(int i=0;i<countNums-1;i++){
                 first=first.getNext();
                 helper=helper.getNext();
             }
             System.out.println("出队列的编号"+first.getNo());
             first=first.getNext();
             helper.setNext(first);
        }
    }
}

/**
 * 节点
 */
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
