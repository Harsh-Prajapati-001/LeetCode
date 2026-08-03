class Solution {
    public String sortSentence(String s) {
        String[] word = s.split(" ");
        String[] result = new String[word.length];
        for(String w:word){
            int pos = w.charAt(w.length()-1) -'0';
            String act = w.substring(0, w.length()-1);
            result[pos -1] = act;
        }
        return String.join(" ", result);
    }
}