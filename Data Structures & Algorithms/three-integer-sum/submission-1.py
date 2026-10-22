class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        lista=[]
        for i in range(len(nums)):
            left= i+1
            right=len(nums)-1
            while left < right:
                suma = nums[i] + nums[left] + nums[right]
                if suma < 0:
                    left+=1
                elif suma > 0:
                    right-=1
                else :
                    nueva_lista=nums[i],nums[left],nums[right]
                    if nueva_lista not in lista:
                        lista.append(nueva_lista)
                    left += 1
                    right -= 1
        return lista