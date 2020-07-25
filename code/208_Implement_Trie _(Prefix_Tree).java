/*
	本题的目标是构造一棵Tire树
	首先是定义一个TNode结构，用于表示Tire树中的节点，对于每个节点，包含了ch当前节点对应的字符，children中非null的值用于表示子节点
	isEndOfWord表示遍历到当前节点是否作为某个已存储单词的结束字符
	对于单词的插入，可以从根节点开始遍历，如果存在当前字符对应的自己点，就一直遍历下去，没有，则将children中对应的位置设置为null并创建新的TNode
	节点，对于单词的查找，可以从根节点，对当前字符在children中进行验证，其对应的值不为null，最后还需要对最后一个字符的isEndOfWord来判断是否为
	完整的单词，判断是否为前缀单词中可以在search方法的基础上将最后的判断isEndOfWord改为直接返回true
*/

public class Solution {
	
   class Trie {

        TNode root;

        class TNode{
            char ch;
            TNode[] children;
            boolean isEndOfWord;
            TNode(char ch){
                isEndOfWord = false;
                this.ch = ch;
                children = new TNode[26];
            }
        }


        /** Initialize your data structure here. */
        public Trie() {
            root = new TNode('\0');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TNode tmp =  root;
            int i = 0;
            for(i=0;i<word.length();++i){
                if(tmp.children[word.charAt(i)-97]==null){
                    tmp.children[word.charAt(i)-97] = new TNode(word.charAt(i));
                }
                tmp = tmp.children[word.charAt(i)-97];
            }
            tmp.isEndOfWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TNode tmp = root;
            int i=0;
            for(;i<word.length();++i){
                if(tmp.children[word.charAt(i)-97]==null)   return false;
                tmp = tmp.children[word.charAt(i)-97];
            }
            return tmp.isEndOfWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TNode tmp = root;
            int i=0;
            for(;i<prefix.length();++i){
                if(tmp.children[prefix.charAt(i)-97]==null)   return false;
                tmp = tmp.children[prefix.charAt(i)-97];
            }
            return true;
        }
    }
}
