package solution;

public class ListNodeOperation {
    public static void main(String[] args) {
        NodeList nodeList1 = new NodeList(1);
        NodeList node1 = new NodeList(2);
        NodeList node2 = new NodeList(4);
        nodeList1.next = node1;
        node1.next = node2;

        NodeList nodeList2 = new NodeList(1);
        NodeList node3 = new NodeList(3);
        NodeList node4 = new NodeList(4);
        nodeList2.next = node3;
        node3.next = node4;

        NodeList newNodeList = mergeTwoLists(nodeList1, nodeList2);
        if (newNodeList != null) {
            System.out.println(
                    newNodeList.value + ""
                    + newNodeList.next.value + ""
                    + newNodeList.next.next.value + ""
                    + newNodeList.next.next.next.value + ""
                    + newNodeList.next.next.next.next.value + ""
                    + newNodeList.next.next.next.next.next.value);
        }
    }

    private static NodeList mergeTwoLists(NodeList nodeList1, NodeList nodeList2) {
        if (nodeList1 == null) {
            return nodeList2;
        }

        if (nodeList2 == null) {
            return nodeList1;
        }

        if (nodeList1.value < nodeList2.value) {
            nodeList1.next = mergeTwoLists(nodeList1.next, nodeList2);
            return nodeList1;
        } else {
            nodeList2.next = mergeTwoLists(nodeList1, nodeList2.next);
            return nodeList2;
        }
    }


}
