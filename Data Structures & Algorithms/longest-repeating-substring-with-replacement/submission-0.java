class Solution {
    public int characterReplacement(String s, int k) {
        int[] conteo = new int[26];
        int izq = 0;
        int maxFreq =0;
        int maxLong = 0;

        for (int der = 0; der < s.length(); der ++){
            char letraActual = s.charAt(der);
            conteo[letraActual - 'A']++;

            maxFreq = Math.max(maxFreq, conteo[letraActual - 'A']);

            while((der - izq + 1) - maxFreq > k) {
                char letraIzq = s.charAt(izq);
                conteo[letraIzq - 'A']--;
                izq++;
            }
            maxLong = Math.max(maxLong, der - izq + 1);
        }
        return maxLong;
    }
}
