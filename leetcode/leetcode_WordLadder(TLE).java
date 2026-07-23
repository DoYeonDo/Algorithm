import java.util.*;

class Solution {
    static int shortest;
    static boolean[] visited;
    static String publicEndWord;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for(String word : wordList){
            if(word.equals(endWord)){
                flag = true;
                break;
            }
        }

        if(!flag) return 0;
        shortest = Integer.MAX_VALUE;

        visited = new boolean[wordList.size()];
        publicEndWord = endWord;

        recursive(beginWord, 1, wordList);

        return shortest == Integer.MAX_VALUE ? 0 : shortest;
    }

    static void recursive(String curStr, int cnt, List<String> wordList){
        if(curStr.equals(publicEndWord)){
            shortest = Math.min(shortest, cnt);

            return;
        }

        for(int idx = 0; idx < wordList.size(); idx++){
            // 이미 본 단어이면 건너뛰기
            if(visited[idx]) continue;

            String nextStr = wordList.get(idx);

            // 하나의 문자만 차이가 난다면
            if(oneCharDiff(curStr, nextStr)){
                visited[idx] = true;
                recursive(nextStr, cnt+1, wordList);
                visited[idx] = false;
            }
        }
    }

    static boolean oneCharDiff(String s1, String s2){
        int cnt = 0;

        for(int idx=0; idx<s1.length(); idx++){
            if(s1.charAt(idx)!=s2.charAt(idx)) cnt++;
        }

        if(cnt==1) return true;
        else return false;
    }
}