package com.xiu.linkedList;

public class DobuleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.addNode(new HeroNode2(1,"松江","及时雨"));
        doubleList.addNode(new HeroNode2(2, "李逵", "黑旋风"));
        doubleList.addNode(new HeroNode2(3, "吴用", "智多星"));
        doubleList.addNode(new HeroNode2(4, "卢俊义", "玉麒麟"));
        doubleList.showLinkedList();
        doubleList.del(2);
        doubleList.showLinkedList();
    }
}

class DoubleLinkedList{
    //头结点
    private HeroNode2 head=new HeroNode2(0, "","");

    public HeroNode2 getHead(){
        return this.head;
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
        HeroNode2 tmp=head.next;
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
     * 添加节点
     * @param node
     */
    public void addNode(HeroNode2 node){
        HeroNode2 tmp=head;
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
        node.pre=tmp;
    }

    /**
     * 修改链表节点信息
     * 根据编号修改（约定编号不可以修改）
     */
    public void update(HeroNode2 newNode){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 tmp2=head.next;
        boolean flag=false;
        //找到需要修改的节点
        while (true){
            if(tmp2 == null){
                break;
            }
            if(tmp2.no == newNode.no){
                flag=true;
                break;
            }
            tmp2=tmp2.next;
        }
        //找到要修改的节点
        if(flag){
            //修改信息即可
            tmp2.name=newNode.name;
            tmp2.nickName= newNode.nickName;
        }else{
            //没有找到要修改的节点
            System.out.println("没有找到要修改的节点");
        }
    }

    /**
     * 删除某个节点
     */
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 tmp=head.next;
        boolean flag=false;
        while (true){
            if(tmp==null){
                System.out.println("链表最后");
                break;
            }
            if(tmp.no == no){
                //找到要删除的节点
                flag=true;
                break;
            }
            tmp=tmp.next;
        }
        if(flag)
            tmp.pre.next=tmp.next;
            if(tmp.next!=null){
                tmp.next.pre=tmp.pre;//如果删除的是最后的节点，有问题
            }
    }
}
//双向链表节点类
class HeroNode2{
    int no;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 pre;
    public HeroNode2(int no,String name,String nickName){
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
