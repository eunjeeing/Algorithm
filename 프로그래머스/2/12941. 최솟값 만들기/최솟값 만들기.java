import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int lengthB = B.length;
        for (int i = 0; i < A.length; i++) {
            lengthB--;
            answer += A[i] * B[lengthB];
        }

        return answer;
    }
}