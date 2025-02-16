package dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            if (heap.get(currentIndex) < heap.get(parent(currentIndex))) {
                swap(currentIndex, parent(currentIndex));
                currentIndex = parent(currentIndex);
            } else {
                return;
            }
        }
    }

    private void printHeap(){
        String output = "[";
        for(int i = 0; i< heap.size() ; i++){
            int node = heap.get(i);
            if(i > 0) output += ",";
            output += (node);
        }
        output += "]";
        System.out.println(output + "\n");
    }

    private void sinkDown(int index){
        int minValue = index;
        while(true){
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if(leftIndex < heap.size() && heap.get(leftIndex) < heap.get(index)){
                minValue = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(index)){
                minValue = rightIndex;
            }
            if(minValue != index){
                swap(index, leftIndex);
                index = minValue;
            } else {
                return;
            }
        }
    }

    public Integer remove(){
        if(heap.size() == 0) return null;
        if(heap.size() < 2) return heap.remove(0);
        int minValue = heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return minValue;
    }

}
