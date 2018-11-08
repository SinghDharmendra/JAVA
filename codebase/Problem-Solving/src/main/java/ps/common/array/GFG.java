package ps.common.array;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GFG {
	/* You are required to complete this function */
	public static  int[] remove_duplicate(int a[]) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], null);
		}
		//return map.keySet();
		int res[]=new int [map.size()];
		int i=0;
		for(Integer v:map.keySet()) {
			res[i]=v;
		}
		return res;
		
	}

	public static void main(String[] args) {
		int[] in = { 1, 3, 4, 5, 6, 12, 13, 17, 19, 22, 23, 25, 27, 28, 28, 35, 36, 37, 39, 43, 46, 48, 54, 59, 62, 63,
				65, 68, 68, 70, 70, 72, 79, 82, 83, 92, 92, 93, 95, 96, 96, 100 };
		int out[]= {1,3,4,5,6,12,13,17,19,22,23,25,27,28,35,36,37,39,43,46,48,54,59,62,63,65,68,70,72,79,82,83,92,93,95,96,100};
		int cal[]=remove_duplicate(in);
	
	}
}