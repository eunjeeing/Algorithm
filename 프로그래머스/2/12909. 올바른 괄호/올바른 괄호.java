import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean result = true;
        
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
				if(ch == '(') {
					stack.push('(');
				} else {
					if(stack.empty()) result = false;
					else stack.pop();
				}
			}
             
        return  stack.empty() && result ? true : false;
    }
}