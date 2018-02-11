import java.util.HashMap;

public class LongestCommonSequence {


    static String lcs(String string1, String string2){

        if(string1 == null || string2 == null){
            return null;
        }

        String longestCommonSequence = "";

        if(string1.length() <= 0 || string2.length() <= 0){
            return longestCommonSequence;
        }

        if(string1.charAt(string1.length() - 1) == string2.charAt(string2.length() - 1)){
            longestCommonSequence += string1.charAt(string1.length() - 1);
            longestCommonSequence += lcs(string1.substring(0, string1.length()-1), string2.substring(0, string2.length()-1));
        }
        else {
            String str1 = lcs(string1.substring(0, string1.length()-1), string2);
            String str2 = lcs(string1, string2.substring(0, string2.length()-1));

            if(str1.length() > str2.length()){
                longestCommonSequence += str1;
            }
            else {
                longestCommonSequence += str2;
            }
        }

        return  longestCommonSequence;
    }


    static HashMap<String, String> lcsMap = new HashMap<>();

    static String fastLCS(String string1, String string2){


        String key = string1 + "-" + string2;
        String value = lcsMap.get(key);


        if(value!= null){
            return value;
        }



        if(string1 == null || string2 == null){
            return null;
        }

        String longestCommonSequence = "";

        if(string1.length() <= 0 || string2.length() <= 0){
            return longestCommonSequence;
        }

        if(string1.charAt(string1.length() - 1) == string2.charAt(string2.length() - 1)){
            longestCommonSequence = string1.charAt(string1.length() - 1) + longestCommonSequence;
            longestCommonSequence = fastLCS(string1.substring(0, string1.length()-1), string2.substring(0, string2.length()-1)) + longestCommonSequence;
        }
        else {
            String str1 = fastLCS(string1.substring(0, string1.length()-1), string2);
            String str2 = fastLCS(string1, string2.substring(0, string2.length()-1));

            if(str1.length() > str2.length()){
                longestCommonSequence += str1;
            }
            else {
                longestCommonSequence += str2;
            }
        }
        lcsMap.put(key, longestCommonSequence);

        return  longestCommonSequence;
    }


    public static void main(String[] args){
        String string1 = "AGGTABNDSV";
        String string2 = "GXTXAYBDFGHOI";

        long timestamp1 = System.currentTimeMillis();

       // String longestCommonSubsequence = lcs(string1, string2);
       //System.out.println("LCS is "+new StringBuilder(longestCommonSubsequence).reverse().toString());

        String longestCommonSubsequence = fastLCS(string1, string2);
        System.out.println("LCS is "+longestCommonSubsequence);

        long timestamp2 = System.currentTimeMillis();	        System.out.println(" Time Taken : "+(timestamp2-timestamp1));
    }
}
