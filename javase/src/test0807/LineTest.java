package test0807;
//链表
public class LineTest {

        //定义一个node类用来表示节点类
        private class Node{
        //使用key ,value 的方式 表示元素的内容
        private String key;
        private String value;
        //定义下一个节点
        private Node next;
        //构造方法 ,用来创建结点的时候添加元素内容
        Node(String key,String value){
            this.key = key;
            this.value = value;
        }
    }
    //定义头节点
    private Node head;
//    添加节点的功能
    public  void addNode(String key,String value){
        boolean flag = true;
        //判断头节点是否为空
        if (head == null){
            //如果头节点为空，则将当前元素的内容添加到头节点
            head = new Node(key,value);
        }else {
            //头节点不为空则需要找到尾节点
            Node cur = head;
            while (cur.next != null){
                //判断插入结点的key值是否已经存在
                if(cur.key.equals(key)){
                    System.out.println("该key值已经存在");
                    flag = false;
                    break;
                }
                //只要当前节点指向不为空，则没有走到尾节点
                //将当前节点指向下一个节点
                cur = cur.next;
            }
            if (flag){
                cur.next = new Node(key,value);

            }
        }
    }
//    输所出有值
    public void showAll (LineTest lineTest){
        if (lineTest.head == null ){
            System.out.println("没有");
        }else{
            Node cur = lineTest.head;
            while (cur != null){
                System.out.println( cur.key + "  " + cur.value);
                cur = cur.next;
            }
        }
    }
//    根据key值删除value值
    public  void delete (String key ){
        Node cur = head;
        boolean flag = false;
        if (head == null ){
            System.out.println("没有此节点");
        }else if(head.key.equals(key)){//删除第一个元素
            head= cur.next;
        }else {
            while (cur != null ){
                if (cur.next.key.equals(key)){//如果此为cur.key则 删除的是cur的下一个对象
                    // 想着下面改成cur = cur.next 这里少了指针的意思 next 相当与指针
//                    cur.value = null;
                    cur.next = cur.next.next;//cur的指向由cur.next变为cur.next.next 则删除了 cur.next
                    //删除机制 找到要删除元素的前一个元素 改变他指针的方向 跨过要删除的对象
                    flag = true;
                    break;
//                    System.out.println("删除成功");
                }
                cur = cur.next;
            }

            if (!flag){
                System.out.println("没有此结点");
            }
        }
    }
    //    根据key值修改value值
    public String update (String key,String value){
        String valuef = null;
        boolean flag =false;
        if (head == null){
            valuef = "没有此节点";
        }else {
            Node cur = head;
            while (cur != null){
                if (cur.key.equals(key)){
                    cur.value = value;
                    flag = true;
                    valuef = value;
                    break;
                }
                cur = cur.next;
            }
            if (!flag){
                valuef = "没有此节点";
            }
        }
        return valuef;

    }
//    根据key值 查看value值
    public  String show (String key){
        String value = null;
        boolean flag = false;
        if (head == null){
            value = "没有此节点";
        }else {
            Node cur = head;
            while (cur != null){
                if (cur.key.equals((key))){
                    value = cur.value;
                    flag = true;
                    break;
                }
                cur  = cur.next;
            }
            if (!flag){
                value = "没有此节点";
            }
        }
        return value;
    }

    public static void main(String[] args) {
        //定义线性结构的对象
        LineTest lt = new LineTest();
        //添加节点
        lt.addNode("1","哈哈");
        lt.addNode("2","加油");
        lt.addNode("3","再加油");
        lt.showAll(lt);
//        System.out.println(lt.show("2")+"  "+ lt.show("3"));
        System.out.println("----------------");
        lt.delete("1");
//        lt.addNode("5","加油");
//        lt.addNode("2","?");
        lt.update("2","来了");
        lt.delete("2");
        lt.showAll(lt);
        System.out.println("==========");
        System.out.println(lt.show("3"));
    }
}
