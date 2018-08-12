package ps.common.problem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		Set<String> D=new HashSet<>();
		  D.add("poon");
		    D.add("plee");
		    D.add("same");
		    D.add("poie");
		    D.add("plie");
		    D.add("poin");
		    D.add("plea");
		    String start = "toon";
		    String target = "plea";
		    
		    int res=shortestChainLength(start,target,D);
		    System.out.println(res);
	}

	private static int shortestChainLength(String start, String target, Set<String> d) {
		// TODO Auto-generated method stub
		Queue<String> q=new LinkedList<>();
		int count=1;
		q.add(start);
		while(!q.isEmpty()) {
			String current=q.peek();
			q.remove(current);
			Iterator<String> iterator = d.iterator();
			while(iterator.hasNext()) {
				String dVal=iterator.next();
				if(isAdj(current,dVal)) {
					q.add(dVal);
					count++;
					iterator.remove();
				}
			}
		}
		
		return count;
	}

	private static boolean isAdj(String current, String dVal) {
		int count=0;
	for(int i=0;i<current.length();i++) {
		if(current.charAt(i)!=dVal.charAt(i))
			count++;
		
	}
	return count==1?true:false;
	}
}
