import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            curr.next = top;
            curr = top;
            if (top.next != null) {
                minHeap.add(top.next);
            }
        }

        return dummy.next;
    }
    
    public static void Main(String args[]) {
        
    }
}
