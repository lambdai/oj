package newleetcode;

public class TrappingRainWater {
    public int trap(int[] A) {
	int i = 0;
	int irmhighest = 0;
	int ilmhighest = A.length-1;
	int sofar = 0, current = 0;
	if (A.length <=2) { return 0; }
	for (i = 1; i< A.length; i++) {
	    if (A[i] < A[irmhighest]) {
		current += (A[irmhighest]-A[i]);
		
	    } else {
		sofar += current;
		current = 0;
		irmhighest = i;
	    }
	}
	if (current > 0) {
	    current = 0;
	    
	    for(i = A.length-1; i >= irmhighest; i--) {
		if(A[ilmhighest] > A[i]) {
		    current += A[ilmhighest] - A[i];
		} else {
		    sofar += current;
		    current = 0;
		    ilmhighest = i;
		}
	    }
	}
	
        return sofar;
    }
    
    public static void main(String[] args) {
    	System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    	System.out.println(new TrappingRainWater().trap(new int[]{0,1}));
    }
}
