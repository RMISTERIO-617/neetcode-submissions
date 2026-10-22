class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int izq = 1;
        int der = 1;
        for(int pile : piles){
            der = Math.max(der, pile);
        }

        int velocidadMin = der;

        while(izq <= der){
            int k = izq + (der - izq) / 2;
            long horasTotales =0;

            for (int pile : piles){
                horasTotales += Math.ceil((double) pile / k);
            }    

            if(horasTotales <= h){
                velocidadMin = k;
                der = k -1;
            } else {
                izq= k+1;
            }
        }
        return velocidadMin;
    }
}
