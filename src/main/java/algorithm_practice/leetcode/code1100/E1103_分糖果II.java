package algorithm_practice.leetcode.code1100;

public class E1103_分糖果II {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        //循环遍历的次数
/*        int times = 0, location = 0;
        long gradual = 0, gradualPre = 0;
        while (gradual < candies) {
            gradual += gradualPre;


            times++;
        }*/
        //1  2  3  4
        //5  6  7  8
        //9 10 11 12
        //1+times*4
        int index = 0, can = 1, candiesTemp = candies;
        while (candies > can) {
            res[index++] += can;
            index %= num_people;
            candies -= can;
            can++;
        }
        res[index] += candies;
        return res;

    }
}
