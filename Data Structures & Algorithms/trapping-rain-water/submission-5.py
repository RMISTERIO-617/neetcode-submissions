class Solution:
    def trap(self, height: List[int]) -> int:
        l = 1
        r = len(height) - 2

        lMax = height[l - 1]
        rMax = height[r + 1]

        total = 0
        while l <= r:
        
            if rMax <= lMax:
            
                total += max(0, rMax - height[r])
                rMax = max(rMax, height[r])

                r -= 1
            else: 
            
                total += max(0, lMax - height[l])
                lMax = max(lMax, height[l])

                l += 1
        return total