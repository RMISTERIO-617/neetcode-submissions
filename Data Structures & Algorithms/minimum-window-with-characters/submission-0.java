class Solution {
    public String minWindow(String s, String t) {
    if (s.length() < t.length()){
            return "";
    }
    
    int[] freqT = new int[128];
    int letrasUnicasNecesarias = 0;

    for(char c : t.toCharArray()){
        if(freqT[c] == 0) letrasUnicasNecesarias++;
        freqT[c]++;
    }

    int[] freqVentana = new int [128];
    int izq = 0, minIzq = 0;
    int letrasCumplidas = 0;
    int minLong =Integer.MAX_VALUE; 

    for (int der = 0; der < s.length(); der++) {
        char cDer = s.charAt(der);
        freqVentana[cDer] ++;

        // Si el caracter actual importa y su frecuencia en la ventana coincide con la necesaria en T
        if(freqT[cDer]>0 && freqVentana[cDer] == freqT[cDer]){
            letrasCumplidas++;
        }
        // Cuando la ventana tiene todas las letras requeridas, intentamos encogerla
        while (letrasCumplidas == letrasUnicasNecesarias)
        {
            if (der - izq + 1 < minLong){
                minLong = der - izq + 1;
                minIzq = izq;
            }

            char cIzq = s.charAt((izq));
            freqVentana[cIzq]--;

            if(freqT[cIzq] > 0 && freqVentana[cIzq] < freqT[cIzq]){
                letrasCumplidas--;
            }
            izq++; 
        }
    }
    return minLong == Integer.MAX_VALUE ? "" : s.substring(minIzq, minIzq + minLong );
    }
}

