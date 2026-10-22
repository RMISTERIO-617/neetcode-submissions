class Solution:
    def encode(self, strs: List[str]) -> str:
        encoded = ""
        for palabra in strs:
            len_palabra = len(palabra)
            n_string = str(len_palabra) + "#" + palabra
            encoded = encoded + n_string
        return encoded


    def decode(self, s: str) -> List[str]:
        #Lista final
        res = []
        #inicio
        i = 0

        while i < len(s):
            #fin
            j = i

            #hasta que no ncuentre #
            while s[j] != "#":
                #suma j / fin
                j += 1
            #Se calcula la longitud del inicio y fin
            longitud = int(s[i:j])

            #Inicio
            start = j + 1
            #inicio + longitud
            end = start + longitud

            palabra = s[start:end]
            res.append(palabra)

            i = end
        return res
