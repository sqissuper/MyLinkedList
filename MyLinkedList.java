import jdk.nashorn.internal.ir.CallNode;

class Node{
    public Node next;
    public int val;
    //默认构造方法
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    //打印链表
    public void disPlay(){
        Node ret = this.head;
        while(ret != null){

            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

    //判断是链表空否
    public boolean isFull(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    //找最后一个节点
    public Node lastNode(){
        if(isFull()){
            System.out.println("单链表为空！");
            return null;
        }
        Node ret = this.head;
        while(ret.next != null){
            ret = ret.next;
        }
        return ret;
    }

    //找倒数第二个节点
    public Node lastSecondNode(){
        if(isFull()){
            System.out.println("单链表为空！");
            return null;
        }
        if(this.head.next == null){
            System.out.println("链表只有一个节点！");
            return null;
        }
        Node ret = this.head;
        while(ret.next.next != null){
            ret = ret.next;
        }
        return ret;
    }

    //求链表长度
    public int size(){
        int count = 0;
        Node ret = this.head;
        while(ret != null){
            ret = ret.next;
            count++;
        }
        return count;
    }

//    找第N个节点
    public Node nNode(int n){
        if (isFull()) {
            System.out.println("单链表为空！");
            return null;
        }
        if(n < 0 || n > size()){
            System.out.println("输入的n不合法！");
            return null;
        }
        int count = 1;
        Node ret = this.head;
        while(ret != null){
            ret = ret.next;
            count++;
            if(count == n){
                break;
            }
        }
        return ret;
    }

    //头插法
    public void headInset(int val){
        Node nod = new Node(val);//创建新节点
        if(isFull()){
            this.head = nod;
        }else{
            nod.next = this.head;
            this.head = nod;
        }
    }

    //尾插法
    public void tailInsert(int val){
        Node nod = new Node(val);
        if(isFull()){
            this.head = nod;
        }else{
            Node ret = this.head;
            while(ret.next != null){
                ret = ret.next;
            }
            ret.next = nod;
        }
    }

    //n位置插进去
    public void nInsert(int n,int val){
        Node nod = new Node(val);
        if(isFull()){
            this.head = nod;
        }
        if(n < 0 || n > size()){
            System.out.println("n值不合法！");
            return;
        }
        if(n == 0){
            headInset(val);//头插法
            return;
        }
        if(n == size()){
            tailInsert(val);//尾插法
            return;
        }
        Node ret = this.head;
        int count = 1;
        while((n - 1) != count){
            ret = ret.next;
            count++;
        }
        nod.next = ret.next;
        ret.next = nod;
    }


    public Node head;//头节点
    //创建链表
    public void creatList(){
        this.head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    public static void main(String[] args){
        MyLinkedList myList = new MyLinkedList();
        myList.creatList();//创建链表
        myList.disPlay();//打印链表
        System.out.println();//换行
        System.out.println("最后一个节点是：" + myList.lastNode().val);//找最后一个节点
        System.out.println("倒数第二个节点是：" + myList.lastSecondNode().val);//找倒数第二个节点
        System.out.println("链表长度为：" + myList.size());//链表长度
        System.out.println("第n个节点是：" + myList.nNode(2).val);//找第n个节点
        myList.headInset(0);//头插法
        myList.disPlay();//打印链表
        System.out.println();//换行
        myList.tailInsert(6);//尾插法
        myList.disPlay();//打印链表
        System.out.println();//换行
        myList.nInsert(3,22);//任意插入
        myList.nInsert(8,7);
        myList.disPlay();//打印链表
        System.out.println();//换行
    }
}

