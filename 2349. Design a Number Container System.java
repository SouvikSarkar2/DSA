//BEATS 40%
import java.util.*;

class NumberContainers {
    HashMap<Integer, Integer> indexToNumber;
    HashMap<Integer, TreeSet<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (numberToIndices.containsKey(oldNumber)) {
                numberToIndices.get(oldNumber).remove(index); 
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }

        indexToNumber.put(index, number); 
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index); 
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first(); 
    }
}

//BEATS 100%
class NumberContainers {

    HashMap<Integer,PriorityQueue<Integer>> res;
    HashMap<Integer,Integer> index_val;

    public NumberContainers() {
        res = new HashMap<>();
        index_val = new HashMap<>();
    }
    
    public void change(int index, int number) {

        if(index_val.containsKey(index)){
            int num = index_val.get(index);
            if(num == number){
                return ;
            }

            res.get(num).remove(index);
        }

        res.computeIfAbsent(number, k-> new PriorityQueue<>()).offer(index);
        index_val.put(index, number);
    }
    
    public int find(int number) 
    {
        PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());
        if(pq.size() == 0)
        {
            return -1;
        }
        return pq.peek();
    }
}

