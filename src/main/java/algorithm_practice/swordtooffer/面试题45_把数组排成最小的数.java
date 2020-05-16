package algorithm_practice.swordtooffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 面试题45. 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class 面试题45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] asStr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            asStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String a = o1+o2;
                String b = o2+o1;
                return a.compareTo(b);
            }
        });
        if(asStr[nums.length-1].equals("0")){
            return "0";
        }
        StringBuilder st = new StringBuilder();
        for(String k:asStr){
            st.append(k);
        }
        return st.toString();
    }
}
