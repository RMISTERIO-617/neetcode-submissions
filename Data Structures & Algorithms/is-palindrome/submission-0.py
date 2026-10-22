class Solution:
    def isPalindrome(self, s: str) -> bool:
        charseen=[]
        minusculas=s.lower()
        sinespacios=minusculas.replace(" ","")
        len_pal=len(sinespacios)-1
        limpio=""
        for char in sinespacios:
            if char.isalnum():
                limpio += char.lower()
    
        len_pal=len(limpio)-1

        while len_pal >= 0:
            charseen.append(limpio[len_pal])
            len_pal-=1
        
        for i in range(len(limpio)):
            if charseen[i] != limpio[i]:
                return False

        return True