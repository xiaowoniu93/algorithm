package com.xszheng.chapter99;

import java.util.Objects;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseList {

    // 节点
    private static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    private static Node solution(Node head, int k) {
        if (Objects.isNull(head.next)) {
            return head;
        }
        // 定义新的链表
        Node newNode = null;
        Node[] nodes = new Node[k];
        int index = 0;
        while (Objects.nonNull(head)) {
            nodes[index] = head;
            if (index >= k - 1) {
                newNode = fill(newNode, nodes, k);
                nodes = new Node[k];
                index = 0;
            } else {
                index++;
            }
            head = head.next;
        }
        newNode = fill(newNode, nodes, k);
        return newNode;
    }

    private static Node point = null;

    private static Node fill(Node newNode, Node[] nodes, int k) {
        if (Objects.isNull(nodes[k - 1])) {
            for (int i=0; i<k-1; i++) {
                Node node = nodes[i];
                if (Objects.nonNull(node)) {
                    if (Objects.isNull(newNode)) {
                        newNode = new Node(node.val);
                        point = newNode;
                    } else {
                        point.next = new Node(node.val);
                        point = point.next;
                    }
                }
            }
        } else {
            for (int i=k-1; i>=0; i--) {
                Node node = nodes[i];
                if (Objects.isNull(newNode)) {
                    newNode = new Node(node.val);
                    point = newNode;
                } else {
                    point.next = new Node(node.val);
                    point = point.next;
                }
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node head0 = new Node(0);
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        Node head5 = new Node(5);
        head0.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        Node newHead = solution(head0, 2);
        System.out.println(newHead);
    }
}
