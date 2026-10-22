class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #Revision por fila
        for i in range(9): #por fila
            vistos_fila=set()
            for j in range(9): #por columna
                valor=board[i][j]
                if valor !=".":
                    if valor in vistos_fila: #Vistos fila
                        return False
                    vistos_fila.add(valor) #Aniadir por fila
        
        #Revision por columna
        for j in range(9):  # por columna
            vistos_columna = set()
            for i in range(9):  # por fila
                valor = board[i][j]

                if valor != ".":
                    if valor in vistos_columna:
                        return False
                    vistos_columna.add(valor)
        #Revision 3x3
        inicio_fila=0
        inicio_col=0
        for inicio_fila in range(0, 9, 3):
            for inicio_col in range(0, 9, 3):
                vistos_bloque = set()

                for i in range(inicio_fila, inicio_fila + 3):
                    for j in range(inicio_col, inicio_col + 3):
                        valor = board[i][j]

                        if valor != ".":
                            if valor in vistos_bloque:
                                return False
                            vistos_bloque.add(valor)
        return True
        