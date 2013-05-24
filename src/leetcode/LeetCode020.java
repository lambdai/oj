package leetcode;

public class LeetCode020 {
    public boolean isValid(String s){
	
	char[] chars = s.toCharArray();
	int[] unclosed = new int[s.length()+1];
	//unclosed[0]=0;
	char[] parHistory = new char[s.length()+1];
	parHistory[0] = ' ';
	unclosed[0] = 0;
	int j = 0;
	for(int i =0; i<chars.length; i++){
	    char x = chars[i];
	    if(x == '(' || x == '[' || x == '{'){
	        if(parHistory[j] == x) {
	            unclosed[j] ++;
	        } else {
	            j++;
	            parHistory[j] = x;
	            unclosed[j] = 1;
	        }
	    } else {
	        char opposite = 'f';
	        if(x == '}') {
	            opposite = '{';
	        } else {
	            if(x == ']'){
	                opposite = '[';
	            } else {
	                opposite = '(';
	            }
	        }
	        if(parHistory[j] != opposite) {
	            return false;
	        } else {
	            if(j == 0) { return false;}
	            unclosed[j]--;
	            if(unclosed[j] < 0) { return false;}
	            if(unclosed[j]==0){
                        j--;
                    }
                    
	        }
	    }
	}
	return j==0;
	
    }
    
    public static void main(String args[]){
        LeetCode020 solution = new LeetCode020();
        System.out.println(solution.isValid("["));
    }
}
