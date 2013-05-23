package leetcode;

public class LeetCode017 {
    public static Map<Char,String[]> map = new HashMap<Char,String[]>();
    public char[] chars = {1,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','+', '#'};
    public int offset[256] = {
	-1, -1, -1,
    }
    static {
	map.push('2',{'a','b','c'});
	map.push('3',{'d','e','f'});
    }
    public ArrayList<String> letterCombinations(String digits) {
    }
    
}
