package ps.common.problem;
/**
 * 
 * @author Dharmendra Singh
 * This problem is about calculating fare for parking based on below criteria
 * 1>entry fee=2
 * 2>for initial fist hour=3
 * 3>from 2nd hour onwards= 4
 * 
 *
 */

public class ParkingFareCalculator {
	public static void main(String[] args) {
		String startTime="11:45";
		String endTime="13:10";
		int fare=calculateFare(startTime,endTime);
		System.out.println("fare:"+fare);
		
	}

	private static int calculateFare(String startTime, String endTime) {
		int fare;
		String s[]=startTime.split(":");
		String e[]=endTime.split(":");
		int h1=Integer.valueOf(s[0]);
		int m1=Integer.valueOf(s[1]);
		int h2=Integer.valueOf(e[0]);
		int m2=Integer.valueOf(e[1]);
		int dm=m2-m1;
		int dh;
	
		if(dm>0) {
			dh=h2-h1;
			
		}else {
			dh=h2-h1-1;
			dm=dm+60;
		}
		int c=((dm==0)?0:1);
		if(dh>0) {
			fare=2+3+4*(dh-1)+4*c;
		}else {
			fare=2+3*c;
		}
		return fare;
	}

}
