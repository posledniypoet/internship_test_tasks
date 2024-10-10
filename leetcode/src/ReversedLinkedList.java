class ReversedLinkedList {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        ListNode node = head.next;
        ListNode newTail = new ListNode(head.val);
        while(node != null){
            ListNode nextNode = node.next;
            node.next = newTail;
            newTail = node;
            node = nextNode;
        }
        return newTail;
    }
}