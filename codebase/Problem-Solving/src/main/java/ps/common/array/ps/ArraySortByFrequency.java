package ps.common.array.ps;


import java.util.*;

class ArraySortByFrequency {
    public static void main (String[] args) {
        //code

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++) {
            int c = sc.nextInt();
            Map<Integer,Node> map=new HashMap<>();
            for(int j=0;j<c;j++){
                int el=sc.nextInt();
                if(map.containsKey(el)){
                    Node dataNode=map.get(el);
                    dataNode.setFreq(dataNode.getFreq()+1);

                }else{
                    map.put(el,new Node(el,1));
                }
            }

            Set<Map.Entry<Integer,Node>> eSet=map.entrySet();
            List<Node> nodes=new ArrayList<>();

            for(Map.Entry<Integer,Node> es:eSet){
               nodes.add(es.getValue()) ;
            }

            Collections.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                   return (o1.getFreq()!=o2.getFreq())?o1.getFreq()-o2.getFreq():o2.getData()-o1.getData();
                }
            });
           for(Node node:nodes){
               System.out.print(node.getData());
           }

        }


    }
}

class Node{

    int data;
    int freq;
    Node(int data,int freq){
        this.data=data;
        this.freq=freq;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
}