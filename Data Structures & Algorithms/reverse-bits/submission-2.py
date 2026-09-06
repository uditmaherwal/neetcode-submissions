class Solution:
    def reverseBits(self, n: int) -> int:
        if n == 0 :
            return 0;
        
        res = 0

        for i in range(32):
            res <<= 1
            res |= (n & 1)
            n >>= 1

        return res