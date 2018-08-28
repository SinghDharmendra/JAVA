package concept.java.basic.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConCurrentModificatioException {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Iterator<String> iterator = list.iterator();
		System.out.println("l:" + list);
		while (iterator.hasNext()) {
			String s = iterator.next();
			if(s.equals("c"))
			iterator.remove();
		}
		System.out.println("l:" + list);

	}

}
