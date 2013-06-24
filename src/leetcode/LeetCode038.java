package leetcode;

public class LeetCode038 {
    public String countAndSay(int n) {
	StringBuilder sb = new StringBuilder();
	StringBuilder newSb = new StringBuilder();
	for(int i = 0; i < n; i++){
	    if(i == 0) {
		newSb.append("1");
//		System.out.println(newSb.length());
	    } else {
		int len = sb.length();
		int currentPos = 0;

		char currentChar = 0;
		int thisLen = 0;
		while(currentPos != len) {
		    if(thisLen == 0){
			currentChar = sb.charAt(currentPos);
			thisLen ++;
			currentPos ++;
		    } else {
			if(sb.charAt(currentPos) == currentChar){
			    thisLen ++;
			    currentPos ++;
			} else {
			    newSb.append(thisLen);
			    newSb.append(currentChar);
			    thisLen = 1;
			    currentChar = sb.charAt(currentPos);
			    currentPos++;
			}
		    }
		}
		newSb.append(thisLen);
		newSb.append(currentChar);
		//System.out.println(newSb.toString());

	    }
	    StringBuilder tempSb = sb;
	    sb = newSb;
	    newSb = tempSb;
	    
	    newSb.setLength(0);
	    //System.out.print("Sb:");
            //System.out.println(sb.toString());
	}
        return sb.toString();
    }
    
    public static void main(String[] args){
        LeetCode038 solution = new LeetCode038();
        System.out.println(solution.countAndSay(8));
    }
    
}