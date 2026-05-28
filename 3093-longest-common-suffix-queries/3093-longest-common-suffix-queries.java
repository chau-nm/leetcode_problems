class Solution {
    public class Node{
            int ind;
            Node[] child;
            Node(int idx) {  
                ind = idx;
                child = new Node[26];
            }
    };
    
    public void add(Node ptr, String[] wordsContainer, int i){
        for(int j = wordsContainer[i].length() - 1; j >= 0; --j){
            int c = wordsContainer[i].charAt(j) - 'a';
            if(ptr.child[c] == null) ptr.child[c] = new Node(i);
            ptr = ptr.child[c]; 
            if(wordsContainer[ptr.ind].length() > wordsContainer[i].length()) ptr.ind = i;
        }
    }
    
    public int search(Node ptr, String s){
        int ans = ptr.ind;
        for(int i = s.length()-1; i >= 0; --i){
            ptr = ptr.child[s.charAt(i) - 'a'];
            if(ptr == null) return ans;
            ans = ptr.ind;
        }
        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] ans = new int[wordsQuery.length];
        Node head = new Node(0);
        for(int i = 0; i < wordsContainer.length; ++i) {
            if(wordsContainer[head.ind].length() > wordsContainer[i].length()) head.ind = i;
            add(head, wordsContainer, i);
        }
        for(int i = 0; i < wordsQuery.length; ++i) ans[i] = search(head, wordsQuery[i]);
        return ans;
    }
}