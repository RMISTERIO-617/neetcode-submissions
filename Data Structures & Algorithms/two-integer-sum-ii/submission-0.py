class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        izq=0
        der=len(numbers)-1
        for i in range(len(numbers)):
            suma = numbers[izq] + numbers[der]
            if suma > target:
                der -= 1
            elif suma < target:
                izq += 1
            else:
                return [izq + 1, der + 1]