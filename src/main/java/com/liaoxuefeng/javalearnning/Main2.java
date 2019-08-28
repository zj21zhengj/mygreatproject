package com.liaoxuefeng.javalearnning;

import java.util.*;

/**
 * 由名知意，凡是Tree 底层数据结构均为二叉树，而TreeSet集合 只需实现Comparable借口中的compareTo方法
 * 而只有底层数据结构为哈希表时才会重写equals和HashCode方法
 *
 */
public class Main2 {
    public static void main(String[] args) {
        List<Message> received = new ArrayList<>();
        received.add( new Message(1, "Hello!"));
        received.add( new Message(2, "发工资了吗？"));
        received.add( new Message(2, "发工资了吗？"));
        received.add( new Message(3, "去哪吃饭？"));
        received.add( new Message(3, "去哪吃饭？"));
        received.add(  new Message(4, "Bye"));
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> receiveds = new TreeSet<>(received);
        List<Message> re = new ArrayList<>(receiveds);
        return re;
    }
}

class Message implements Comparable {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public int compareTo(Object o) {
        Message ms = (Message) o;
        return compare(this.sequence, ms.sequence);
    }

    public static int compare(int x, int y) {//a.compateTo(b)
        //如果a比b小,那么返回-1,相等就是0,否则就是1
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}