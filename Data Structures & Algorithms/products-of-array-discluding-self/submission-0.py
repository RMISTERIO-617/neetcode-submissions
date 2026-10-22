class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        longitud=len(nums)
        output = [1] * longitud

        izquierda = 1
        for i in range(longitud):
            output[i] = izquierda
            izquierda = izquierda * nums[i]

        derecha = 1
        for i in range(longitud - 1, -1, -1):
            output[i] = output[i] * derecha
            derecha = derecha * nums[i]

        return output
        