/*
	可以在之前的tire搜索树的基础上进行拓展，主要拓展的是search函数，因为这里有了通配符，所以匹配字符出现了
	通配符的时候要遍历TNode的children数组查看是否有满足条件的，所以重载了search方法添加了当前TNode节点和对
	应word中的index
*/

// solution for 211
    class WordDictionary {

        TNode root;

        class TNode {
            boolean isWordEnd;
            TNode[] children;

            TNode() {
                isWordEnd = false;
                children = new TNode[26];
            }
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TNode tmp = root;
            for (int i = 0; i < word.length(); ++i) {
                if (tmp.children[word.charAt(i) - 97] == null)
                    tmp.children[word.charAt(i) - 97] = new TNode();
                tmp = tmp.children[word.charAt(i) - 97];
            }
            tmp.isWordEnd = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null) return false;
            TNode tmp = root;
            return search(word, tmp, 0);
        }

        public boolean search(String word, TNode node, int index) {
            if (index == word.length()) return node.isWordEnd;
            if (word.charAt(index) != '.') {
                if (node.children[word.charAt(index) - 97] != null)
                    if (search(word, node.children[word.charAt(index) - 97], index + 1))
                        return true;
            }else{
                for(int j=0;j<26;++j){
                    if(node.children[j]!=null)
                        if(search(word, node.children[j], index + 1))
                            return true;
                }
            }
            return false;
        }
    }