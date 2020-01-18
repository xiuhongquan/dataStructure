package com.xiu.linkedList;


import java.util.Stack;

public class SingleLinkList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(new HeroNode(1,"松江","及时雨"));
        linkedList.addNode(new HeroNode(2, "李逵", "黑旋风"));
        linkedList.addNode(new HeroNode(3, "吴用", "智多星"));
        linkedList.addNode(new HeroNode(4, "卢俊义", "玉麒麟"));
        /*System.out.println("反转前的链表");
        linkedList.showLinkedList();
        linkedList.reverLinkedList();
        System.out.println("反转后的情况");
        linkedList.showLinkedList();*/
        linkedList.reversePrint();

    }
}


class LinkedList{
    //头结点
    private HeroNode head=new HeroNode(0, "","");


    /**
     * 添加节点到单项链表
     * 不考虑编号的顺序时，找到当前链表的最后节点
     * 将最后节点的next域指向新的节点
     * @param node
     */
    public void addNode(HeroNode node){
        HeroNode tmp=head;
        //遍历链表
        while (true){
            if(tmp.next==null){
                break;
            }
            //如果没有找到最后，将tmp后移
            tmp=tmp.next;
        }
        //当退出while时tmp就是当前链表的最后节点
        tmp.next=node;
    }

    /**
     * 按照编号添加节点
     */
    public void addNode2(HeroNode node){
        //遍历链表，找到新节点添加的位置
        HeroNode tmp=head;
        boolean flag=false;
        while(true){

            if(tmp.next==null){
                break;
            }
            //判断新节点位置
            if(tmp.next.no > node.no){
                System.out.println("新节点的位置");
                break;
            }else if(tmp.next.no == node.no){
                flag=true;//说明编号存在
                break;
            }
            tmp=tmp.next;
        }
        if(flag){
            System.out.println("该英雄已经存在");
        }else {
            //新的节点的next=tmp.next
            node.next=tmp.next;
            tmp.next=node;
        }

    }

    /**
     * 修改链表节点信息
     * 根据编号修改（约定编号不可以修改）
     */
    public void update(HeroNode newNode){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode tmp=head.next;
        boolean flag=false;
        //找到需要修改的节点
        while (true){
            if(tmp == null){
                break;
            }
            if(tmp.no == newNode.no){
                flag=true;
                break;
            }
            tmp=tmp.next;
        }
        //找到要修改的节点
        if(flag){
            //修改信息即可
            tmp.name=newNode.name;
            tmp.nickName= newNode.nickName;
        }else{
            //没有找到要修改的节点
            System.out.println("没有找到要修改的节点");
        }
    }

    /**
     * 删除某个节点
     */
    public void del(HeroNode node){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode tmp=head.next;
        boolean flag=false;
        while (true){
            if(tmp.next==null){
                System.out.println("链表最后");
                break;
            }
            if(tmp.next.no == node.no){
                //找到要删除的节点
                flag=true;
                break;
            }
            tmp=tmp.next;
        }
        if(flag)
        tmp.next=tmp.next.next;
    }

    /**
     * 显示链表，遍历
     */
    public void showLinkedList(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode tmp=head.next;
        while(true){
            if(tmp == null){
                break;
            }
            //输出节点信息
            System.out.println(tmp);
            tmp=tmp.next;
        }
    }

    /**
     * 单链表反转
     *
     */
    public void reverLinkedList(){
        //链表是空或者只有一个节点
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode curr=head.next;
        HeroNode next=null;//当前节点的下一个节点
        HeroNode reverNode=new HeroNode(0, "","");
        //遍历原来的节点，将当前节点取出，放入新的链表中
        while (curr!=null){
            /**
             * 重点是下面这四句
             * 先将当前节点的下一个节点保存，然后操作当前节点，让当前节点的下一个节点==新的链表的第一个节点
             * 然后将新的链表头结点的next==当前节点
             */
            next=curr.next;
            curr.next=reverNode.next;//实现反转
            reverNode.next=curr;//把当前节点装入新链表
            curr=next;
        }
        head.next=reverNode.next;
    }

    /**
     * 逆序打印单链表，不破坏链表结构
     * 使用栈
     */
    public void reversePrint(){
        if(head.next== null){
            System.out.println("空链表");
        }
        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        //打印栈中节点
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
}
/**
 * 一个HeroNode就是一个节点
 */
class HeroNode{
    int no;
    String name;
    String nickName;
    HeroNode next;
    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }

}
