/**
 * @(#)ListNode.java, May 27, 2013. 
 * 
 * Copyright 2013 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 *
 * @author dyc
 *
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
    
    public void show() {
        System.out.print(val);
        System.out.print("->");
        if(next != null) {
            next.show();
        } else {
            System.out.println("null");
        }
    }

    public void print() {
        if (next != null) {
            next.print();
        };
        System.out.print(val);
    }

    public static ListNode genFromInt(int x) {
        ListNode preNode = null;
        ListNode result = null;
        while (x > 0) {
            ListNode n = new ListNode(x % 10);
            if (preNode != null) {
                preNode.next = n;
                preNode = n;
            } else {
                preNode = n;
                result = n;
            }
            x = x / 10;
        }
        return result;
    }

}
