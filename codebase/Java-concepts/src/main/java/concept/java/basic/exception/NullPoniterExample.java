package concept.java.basic.exception;

public class NullPoniterExample {
	public String sampleNPE(){
	     String a = null;
		 String b = "abc";
		 //this = null;
		 a = b;
		 return a;
	}
	public static void main(String[] args) {
		NullPoniterExample o=new NullPoniterExample();
		o.sampleNPE();
	}

}
