// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Meeting {
    int start, end, idx;
    
    public Meeting(int start, int end, int idx){
        this.start = start;
        this.end = end;
        this.idx = idx;
    }
    
    @Override
    public String toString(){
        return "start " + start + " end " + end; 
    }
}

class Solution 
{
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        if(n==0){
            return 0;
        }
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++){
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        meetings.sort((a, b) -> {
            if(a.end==b.end){
                return Integer.compare(a.idx, b.idx);
            }else{
                return Integer.compare(a.end, b.end);
            }
        });
        int curLimit = meetings.get(0).end;
        int ans = 1;
        for(int i=1; i<n; i++){
            if(meetings.get(i).start>curLimit){
                ans++;
                curLimit = meetings.get(i).end;
            }
        }
        return ans;
    }
}
