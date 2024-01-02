//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair
{
    String first;
    int second;
    public Pair(String f,int s)
    {
        this.first=f;
        this.second=s;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set=new HashSet<>();
        for(String word:wordList)
        {
            set.add(word);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        set.remove(startWord);
        while(!q.isEmpty())
        {
            String word=q.peek().first;
            int steps=q.peek().second;
            int len=word.length();
            q.remove();
            if(word.equals(targetWord)) return steps;
            for(int i=0;i<len;i++)
            {
                {
                    for(char ch='a';ch<='z';ch++)
                    {
                        char[] seq=word.toCharArray();
                        seq[i]= ch;
                        String newWord=new String(seq);
                        if(set.contains(newWord))
                        {
                            set.remove(newWord);
                            q.add(new Pair(newWord,steps+1));
                        }
                    }
                }
                
            }
        }
        return 0;
    }
}