package com.divisor;

/**
 * 求公约数
 */
public class CommonDivisor {

    /**
     * 暴力枚举法
     * 传入的整数是10  000和10  001，用你的方法就需要循环10000/2-1=4999次！
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDiv1(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        for (int i = small / 2; i > 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;
    }


    /**
     * 辗转相除法
     * 当两个整数较大时，做a%b取模运算的性能会比较差。
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDiv2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDiv2(big % small, small);
    }

    /**
     * 更相减损术
     * <p>
     * 避免了大整数  取模可能出现的性能问题
     * 若是计算10000和1的最大公约数，就要递归9999次！
     * 有什么办法可以既避免大整数取模，又能尽可能地减
     * 少运算次数呢？
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDiv3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int samll = a < b ? a : b;
        return getGreatestCommonDiv3(big - samll, samll);
    }

    /**
     * 更相减损术与移位相结合
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {   // a 为偶数， b为偶数
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {  // a 为偶数，b为奇数
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {  // a 为奇数，b为偶数
            return gcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }

    /**
     * 在上述代码中，判断整数奇偶性的方式是让整数和1进行与运算，如果
     * (a&1)==0，则说明整数a是偶数；如果(a&1)!=0，则说明整数a是奇数
     * <p>
     * 总结
     * 众所周知，移位运算的性能非常好。对于给出的正整数a和b，不难得到如下的
     * 结论。
     * <p>
     * 当 a和b均为偶数时， gcd(a, b) = 2*gcd(a/2, b/2) = 2*gcd(a>>1, b>>1)
     * 当 a为偶数，b为奇数是，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)
     * 当 a 为奇数，b为偶数时， gcd(a,b) = gcd(a, b/2) = gcd(a, b>>1)
     * 当 a 和b均为奇数是， 先利用更相减损术运算一次， gcd(a, b) = gcd(b, a-b),
     * 此时a-b 必然是偶数， 然后又可以继续进行移位运算
     * <p>
     * 例如：计算 10 和 25 的最大公约数的步骤如下
     * 1.整数10通过移位，可以转换成求5和25的最大公约数
     * 2.利用更相减损术，计算出25-5=20,转换成求 5 和20的最大公约数
     * 3.整数20通过移位，可以转换成求5和10的最大公约数
     * 4.整数10通过移位，可以转换成求5和5的最大公约数
     * 5.利用更相减损术，因为两数相等，所以最大公约数是5
     * <p>
     * 这种方式在两数都比较小时，可能看不出计算次数的优势；当两数越大时，计
     * 算次数的减少就会越明显。
     */


    public static void main(String[] args) {
        System.out.println(gcd(25, 5));
        System.out.println(gcd(100, 80));
        System.out.println(gcd(27, 14));
    }
}
