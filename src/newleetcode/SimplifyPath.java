//http://oj.leetcode.com/problems/simplify-path/
package newleetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<String>();
    	char[] bpath = path.toCharArray();
    	char[] dest = new char[path.length()];
    	int j = 0;
    	int l = 0;
    	// "XXX/YY/"
    	//      l i
    	int i;
    	for (i = 0; i < bpath.length; i++) {
    		if(bpath[i] == '/') {
    			// "//"
    			if(l == i) {
    		//		l = i+1;
    			//	continue;
    			} else if (bpath[l] == '.' ) {
    				//"./"
    				if (i == l+1) {
    				//	l = i+1;
    					//continue;
    				} else if (bpath[l+1] == '.') {
    					// "/../"
    					if (i == l+2) {
    						if (!stack.isEmpty()) {
    							stack.pop();
    						}
    					} else {
    						stack.push(String.copyValueOf(bpath, l, i-l));
    					}
    				} else {
    					stack.push(String.copyValueOf(bpath, l, i-l));
    				}
    			} else {
    				stack.push(String.copyValueOf(bpath, l, i-l));
    			}
        		l = i + 1;
    		}    		
    	}
    	if (l<i){
    		if (bpath[l] == '.') {
    			if (i > l+2) {
    				stack.push(String.copyValueOf(bpath,l, i-l));
    			} else if (i == l+2){ 
    				if (bpath[l+1] == '.') {
    					// "/../"
    						if (!stack.isEmpty()) {
    							stack.pop();
    						}
    					} else {
    						stack.push(String.copyValueOf(bpath, l, i-l));
    					}
    			} 
    		} else {
    			stack.push(String.copyValueOf(bpath,l, i-l));
    		}
    	}
    	if (stack.empty()) { return "/";}
    	StringBuffer sb = new StringBuffer();
        for(String s: stack) {
        	sb.append("/");
        	sb.append(s);
        }
        return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/de/."));
		System.out.println(new SimplifyPath().simplifyPath("/.hidden/"));
	}

}
