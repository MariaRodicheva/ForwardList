class Node
{
    private Integer data;
    private Node nextElement;
    public Node next() { return nextElement; }
    public Integer getData() { return this.data; }
    public void setData(Integer otherData) { this.data = otherData; }
    public void setNextElement(Node otherNextElement) { this.nextElement = otherNextElement; }
}

class List {
    private Node head;
    private Node tail;

    public Node getHead() { return head; }

    void addBack(int data) {
        Node a = new Node();
        a.setData(data);
        if (tail == null) {
            head = a;
            tail = a;
        } else if (head == tail) head.setNextElement(a);
        else tail.setNextElement(a);
        tail = a;
    }

    void showElem() {
        Node t = head;
        while (t != null) {
            System.out.print(t.getData() + " ");
            t = t.next();
        }
    }

    public static Integer sizeList(List A) {
        int size = 0;
        Node head = A.getHead();
        while (head != null) {
            size++;
            head = head.next();
        }
        return size;
    }

    public static List FindFirstNode(List A, List B) {

        Node headA = A.getHead();
        Node headB = B.getHead();
        int sizeA=(sizeList(A));
        int sizeB=(sizeList(B));
        int razAB = sizeA - sizeB;
        int razBA = sizeB - sizeA;

        if (sizeA < sizeB) {
            for (int i = 0; i < razAB; i++) {
                headB = headB.next();
            }

        } else if (sizeA > sizeB) {
            for (int i = 0; i < razAB; i++) {
                headA = headA.next();
            }
        }

        if (headA != null && headB != null) {
            while (headA.getData() != headB.getData()) {
            headA = headA.next();
            headB = headB.next();
            }
            System.out.println("Общий узел = " + headB.getData());
        }
        return null;
    }

    public static void main (String[]args){

        List b = new List();
        List c = new List();

        b.addBack(-4);
        b.addBack(-3);
        b.addBack(1);
        b.addBack(2);
        b.addBack(3);
        b.addBack(7);
        b.addBack(8);
        b.addBack(10);
        c.addBack(-2);
        c.addBack(-1);
        c.addBack(2);
        c.addBack(7);
        c.addBack(8);
        c.addBack(10);

        b.showElem();
        System.out.println();
        c.showElem();

        System.out.println();
        FindFirstNode(b,c);
    }

}