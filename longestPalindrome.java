public class longestPalindrome {
    //3.19最长回文串
    public static int longestPalindrome(String s){
        int count[] = new int[58];
        for(int i = 0;i < s.length();i ++){
            char tmp = s.charAt(i);
            count[tmp - 'A'] ++;
        }
        int odd = 0;   //奇数个数

        for(int i = 0;i < count.length;i ++){
            if(count[i] % 2 == 1){
                odd ++;
            }
        }
        return odd == 0 ? s.length() : s.length()- odd+ 1;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        longestPalindrome(s);
    }
}
