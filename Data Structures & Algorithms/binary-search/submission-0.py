class Solution:
    def search(self, nums: List[int], target: int) -> int:
        izq=0
        der=len(nums)-1
        medio=(izq+der)//2
        for i in range(len(nums)):
            if nums[medio]==target: 
                return medio
            if target < nums[medio]:
                der-=1
                medio=(izq+der)//2
            else:
                izq+=1
                medio=(izq+der)//2

        return -1 

        