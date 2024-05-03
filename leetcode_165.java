import java.util.Arrays;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tempV1 = version1.split("\\.");
        String[] tempV2 = version2.split("\\.");
        int len1 = tempV1.length;
        int len2 = tempV2.length;
        int[] v1 = new int[len1];
        int[] v2 = new int[len2];
        for(int i=0;i<len1;i++) v1[i] = Integer.parseInt(tempV1[i]);
        for(int i=0;i<len2;i++) v2[i] = Integer.parseInt(tempV2[i]);

        int max = Math.max(len1, len2);
        int index = 0;
        while (index < max){
            if ((index<len1 ? v1[index]:0) > (index<len2 ? v2[index]:0)) return 1;
            if ((index<len1 ? v1[index]:0) < (index<len2 ? v2[index]:0)) return -1;
            index++;
        }
        return 0;
    }
}