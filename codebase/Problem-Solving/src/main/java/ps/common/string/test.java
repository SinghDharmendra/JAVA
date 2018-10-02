package ps.common.string;

import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max=0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int v=0;
             if(deque.size()>m){
                 deque.removeFirst();
                 deque.add(num);
               v=getUniCount(deque);
                 if(v>m)
                     m=v;
             }
            if(deque.size()==m){
               v=getUniCount(deque);
                 m=v;
            }else{
                deque.add(num);
            }
           
        }
    }
    public static int getUniCount( Deque<Integer> deque){
        HashMap<Integer,Integer> map=new HashMap();
        Iterator itr=deque.iterator();
        while(itr.hasNext()){
            map.put((Integer)itr.next(),0);
        }
       
        return map.keySet().size();
    }
    
}



