class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()){
            return false;
        }
        
        int[] freqS1 = new int[26];
        int[] ventana = new int[26];

        for(int i =0; i< s1.length(); i++){
            freqS1[s1.charAt(i) - 'a']++;
        }

        int izq = 0;     

        for (int der = 0; der < s2.length(); der++){
            ventana[s2.charAt(der)-'a']++;


            if((der - izq + 1) > s1.length()){
                ventana[s2.charAt(izq) - 'a']--;
                izq++;
            }

            if((der - izq + 1) == s1.length()){
                if(Arrays.equals(freqS1, ventana)){
                    return true;
                }
            }
        }
        return false;
    }
}
