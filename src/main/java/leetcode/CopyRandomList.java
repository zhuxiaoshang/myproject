package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.random = null;
        n2.random= n1;
        n3.random=n5;
        n4.random = n3;
        n5.random = n1;
        System.out.println(copyRandomList(n1));

    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = clone(oldNode.next, map);
            newNode.random = clone(oldNode.random, map);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }

    public static Node clone(Node node,Map map) {
        if (null != node) {
            if (map.containsKey(node)) {
                return (Node) map.get(node);
            } else {
                map.put(node, new Node(node.val));
            }
        }
        return (Node) map.get(node);
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
