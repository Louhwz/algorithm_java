package common.datastructure;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode k = new ListNode(arr[1]);
        ListNode tp = k;
        for (int i = 2; i < arr.length; i++) {
            tp.next = new ListNode(arr[i]);
            tp = tp.next;
        }
        this.next = k;
    }

    @Override
    public String toString() {
        ListNode tp = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (tp != null) {
            stringBuilder.append(tp.val).append("->");
            tp = tp.next;
        }
        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).toString();
    }

    public void print() {
        String arrow = next != null ? "->" : "";
        System.out.println(val + arrow);
        if (next != null) {
            next.print();
        }
    }


}
