import java.util.HashMap;

public class LongestCommonSubstring {


    static HashMap<String, String> lcsMap = new HashMap<>();

    static String lcs(String string1, String string2){


        String key = string1 + "-" + string2;
        String value = lcsMap.get(key);


        if(value!= null){
            return value;
        }

        if(string1 == null || string2 == null){
            return null;
        }

        int Start = 0;
        int Max = 0;
        for (int i = 0; i < string1.length(); i++)
        {
            for (int j = 0; j < string2.length(); j++)
            {
                int x = 0;
                while (string1.charAt(i + x) == string2.charAt(j + x))
                {
                    x++;
                    if (((i + x) >= string1.length()) || ((j + x) >= string2.length())) break;
                }
                if (x > Max)
                {
                    Max = x;
                    Start = i;
                }
            }
        }
        return string1.substring(Start, (Start + Max));
    }

    static String fastLCS(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] lcsValues = new int[m][n];

        int len = 0;
        int row = 0, col = 0;

        //build lcsValues up to lcsValues[str1 length - 1][str2 length - 1]

        for(int i = 0; i < m; i++){
            for(int j=0; j < n; j++){
                if(i == 0 || j == 0){
                    lcsValues[i][j] = 0;
                }
                else if(str1.charAt(i) == str2.charAt(j)){
                    lcsValues[i][j] = lcsValues[i-1][j-1] + 1;
                    if(lcsValues[i][j] > len){
                        len = lcsValues[i][j];
                        row = i;
                        col = j;
                    }
                }
                else {
                    lcsValues[i][j] = 0;
                }
            }
        }

        if(len == 0){
            System.out.println("No Common Substring");
            return "";
        }

        String result = "";

        while(lcsValues[row][col] != 0){
            result = str1.charAt(row) + result;
            row--;
            col--;
        }
        return  result;

    }



    public static void main(String[] args){
        String string1 = "OldSite:GeeksforGeeks.orggegeghrhrhtj";
        String string2 = "NewSite:GeeksQuiz.comfwgrhjthjtjtjtj";

        long timestamp1 = System.currentTimeMillis();

//        String longestCommonSubstring = lcs(string1, string2);
//        System.out.println("LCS is "+longestCommonSubstring);

        String longestCommonSubstring = fastLCS(string1, string2);
        System.out.println("LCS is "+longestCommonSubstring);

        long timestamp2 = System.currentTimeMillis();
        System.out.println(" Time Taken : "+(timestamp2-timestamp1));
    }
}
