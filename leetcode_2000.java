class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index < 0) return word;
        char[] chars = word.toCharArray();

        for(int i=0;i<=index/2;i++){
            swap(chars,i,index-i);
        }
        return String.valueOf(chars);
    }
    private void swap(char[] chars, int x, int y) {
        char temp = chars[y];
        chars[y] = chars[x];
        chars[x] = temp;
    }
}
