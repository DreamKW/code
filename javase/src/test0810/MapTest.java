package test0810;

import java.util.HashMap;

public class MapTest<K,V> {
    int capaction;
    //定义当前MapTest的长度
    int size;
    //定义每个位置对应的链表集（即存放多个链结点的数组）
    Entry<K,V>[] entries;
    public static int DEFAULTSIZE = 16;
    public  static float yinzi = 0.75f;
    //存储的最大量
    public int max;
    public MapTest(){
//        HashMap
        //装载因子的确定
        this(DEFAULTSIZE,yinzi);
    }

    public MapTest(int size,float yinzi){
        //判断长度是否小于0
        if (size < 0){
            new IllegalAccessException("小于零的数不能创建数组");
        }
        //判断装载因子是否合法
        if (yinzi < 0 || Float.isNaN(yinzi)){
            new IllegalAccessException("装载因子不合法");
        }
        this.yinzi = yinzi;
        this.size = size;
        //创建结点数组
        entries = new Entry[size];
    }

    /**
     *
     * @param hash 结点的哈希值
     * @param compaticy 数组的长度
     * @return
     */

    public  int indexOf(int hash,int compaticy){
        return hash & (compaticy-1);
    }

    /**
     *
     * @param key  添加元素的key值
     * @param value 添加元素的value 值
     * @return
     */
    public boolean put (K key,V value){
        //根据元素的key值 得到元素的hash值，这是一种计算哈希地址的算法
        int hash = key.hashCode();
        boolean flag= false;
        //创建新的Entry结点
//        Entry<K,V> newEntry = new Entry<K, V>(key,value,hash);
        //我们根据是否正常添加来修改当前数组的容量，所以调用添加的方法来进行添加
//        if (setEntry(newEntry,entries)){
//            capaction++;
//            flag = true;
//        }
        return flag;

    }

    private boolean setEntry(Entry<K,V> newEntry, Entry<K,V>[] entries) {
        //定义一个标识，表示可以添加此结点为true
        boolean flag = false;
        //计算结点的位置
        int index = indexOf(newEntry.hash, entries.length);
        //获取当前位置的首结点
        Entry<K, V> temp = entries[index];
        //判断首结点是否为空
        if (temp != null) {
            while (temp != null) {
                if ((newEntry.key.equals(temp.key) || newEntry.key == temp.key) && (newEntry.value.equals(temp.value) || newEntry.value == temp.value) &&
                        newEntry.hash == temp.hash) {
                    flag =false;
                    break;
                }else if ((newEntry.key != temp.key) && (newEntry.value != temp.value)) {
                    temp = temp.next;
                }
            }
            //循环结束 尾结点为temp
            if (flag)
            addlastEntry(temp,newEntry);
        } else {
            if (flag){
                addFirstEntry(temp,newEntry);
            }
        }
        return flag;
    }

    private void addFirstEntry(Entry<K,V> temp, Entry<K,V> newEntry) {
    }

    private void addlastEntry(Entry<K,V> temp, Entry<K,V> newEntry) {
    }
}



class Entry<K,V>{
    Entry<K,V> next;
    K key;
    K value;
    int hash;

    public Entry() {
    }
    public Entry( K key, K value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }
}
