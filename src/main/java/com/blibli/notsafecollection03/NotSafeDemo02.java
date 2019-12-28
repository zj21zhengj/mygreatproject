package com.blibli.notsafecollection03;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * hashSet底层是 hashMap , put k v v是常量
 * 同样用 CopyOnWriteArraySet
 */
public class NotSafeDemo02 {

    public static void main(String[] args) {
        Set<String> sets = new CopyOnWriteArraySet<>();
    }
}
