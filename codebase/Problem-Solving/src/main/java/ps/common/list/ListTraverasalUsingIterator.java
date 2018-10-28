package ps.common.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTraverasalUsingIterator {
	public static void main(String[] args) {
		List<List<Integer>> elements = Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Iterator<List<Integer>> combinations = new Combinations<>(elements);
		/*while(true) {
			List<Integer> next = combinations.next();
			System.out.println(next);
		}*/
		combinations.forEachRemaining(System.out::println);
	}

}
class Combinations<T> implements Iterator<List<T>> {

    final List<List<T>> elements;
    final int[] indices;

    public Combinations(List<List<T>> elements) {
        this.elements = elements;
        this.indices = new int[elements.size()];
    }

    @Override
    public boolean hasNext() {
        // has first index not yet reached max position?
        return indices[0] < elements.get(0).size();
    }

    @Override
    public List<T> next() {
        // get next
        List<T> result = new ArrayList<>(indices.length);
        for (int i = 0; i < indices.length; i++) {
            result.add(elements.get(i).get(indices[i]));
        }
        // increase indices
        for (int i = indices.length - 1; i >= 0; i--) {
            indices[i]++;
            if (indices[i] >= elements.get(i).size() && i > 0) {
                indices[i] %= elements.get(i).size();
            } else {
                break;
            }
        }
        return result;
    }
}