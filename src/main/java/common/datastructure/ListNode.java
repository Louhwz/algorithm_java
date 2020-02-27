package common.datastructure;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }

    public void print() {
        String arrow = next != null ? "->" : "";
        System.out.println(val + arrow);
        if (next != null) {
            next.print();
        }
    }


}
