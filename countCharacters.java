import sun.tools.attach.HotSpotVirtualMachine;

public class countCharacters {
    //3.17拼写单词
    //每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
    public static int countCharacters(String[] words, String chars){
        //挨个遍历
        int count = 0;
        boolean flag = true;
        for(String str : words){
            str.toCharArray();
            for(int i = 0;i < str.length();i ++){
                if(flag == false){
                    break;
                }
                for(int j = 0;j < chars.length();j ++){
                    if(str.charAt(i) == chars.charAt(j)){
                        flag = true;
                        break;
                    }
                    flag = false;
                }
            }
            if(flag == true){
                count = count + str.length();
            }
            flag = true;
        }
        return count;
    }
    public static int countCharactersCount(String[] words, String chars){
        //分别对words、chars中的字母计数进行比较
        int res = 0;
        boolean flag = true;
        int charsCount[] = new int[26];
        int wordsCount[] = new int[26];
        for(char c : chars.toCharArray()){
            charsCount[c - 'a'] ++;
        }
        for(String str : words){
            for(char c : str.toCharArray()){
                wordsCount[c - 'a'] ++;
                if(wordsCount[c - 'a'] <= charsCount[c - 'a']){
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                res = res + str.length();
            }
            wordsCount = new int [26];
        }
        return res;

    }

    public static void main(String[] args) {
        String words[] = {"cat","bt","hat","tree"};
        String chars = "atach";
        countCharactersCount(words,chars);
    }
}
