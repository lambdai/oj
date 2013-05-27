package leetcode;

import java.util.ArrayList;

public class LeetCode023 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
	int heapSize = lists.size();
	//if(heapSize == 0) { return null; }
	ListNode[] heap = new ListNode[heapSize+1];
	heap[1] = null;
	int currentHeapSize = init(lists, heap);
	if(currentHeapSize <= 1) {
	    return heap[1];
	}
	ListNode listHead = new ListNode(0);
	ListNode preNode = listHead;
	
	while(currentHeapSize > 1) {
	    preNode.next = heap[1];
	    preNode = heap[1];
	    heap[1] = heap[1].next;
	    if(heap[1] != null) {
		down(heap, 1, currentHeapSize);
	    } else {
		currentHeapSize --;
		heap[1] = heap[currentHeapSize+1];
		down(heap, 1, currentHeapSize);
	    }
	}
	preNode.next = heap[1];
	return listHead.next;
    }

    private int init(ArrayList<ListNode> lists, ListNode[] heap){
	int j = 1;
	for(int i = 0; i < lists.size(); i++){
	    heap[j] = lists.get(i);
	    if(heap[j] != null) { j++; }
	}
	int maxSize = j-1;
	for(int i = maxSize/2; i >= 1; i--){
	    down(heap, i, maxSize);
	}
	return maxSize;
    }

    public static void down(ListNode [] heap, int index, int max) {
	int minorIndex = -1;
	int rightIndex = 2*index+1;
	if(rightIndex <= max) {
	    minorIndex = heap[rightIndex].val < heap[rightIndex-1].val ? rightIndex : rightIndex -1;
	} else if(rightIndex >= max + 2) {
	    return;
	} else {
	    minorIndex = rightIndex-1;
	}
	if(heap[minorIndex].val >= 
	        heap[index].val) {
	    return;
	} else {
	    ListNode temp = heap[index];
	    heap[index] = heap[minorIndex];
	    heap[minorIndex] = temp;
	    down(heap, minorIndex, max);
	}
	    
    }
    
    public static void main(String args[]){
        LeetCode023 solution = new LeetCode023();
        ListNode[] arr = new ListNode[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ListNode(10-i);
            if(i-2 >=0){
                arr[i].next = arr[i-2];
            }
        }
        ArrayList<ListNode> l = new ArrayList<ListNode>();
        l.add(arr[8]);
        l.add(arr[7]);
        ListNode nodes = solution.mergeKLists(l);
        nodes.show();
        
    }
}
