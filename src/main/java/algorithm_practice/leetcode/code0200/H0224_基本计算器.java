package algorithm_practice.leetcode.code0200;

import org.junit.Test;

import javax.management.relation.InvalidRelationTypeException;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H0224_基本计算器 {

    Stack<Integer> operand = new Stack<>();
    Stack<Character> operator = new Stack<>();

    char[] op = new char[]{'(', '+', '-', ')'};

    private boolean match(char c) {
        for (char c1 : op) {
            if (c1 == c)
                return true;
        }
        return false;
    }
    //#TODO:我的判断右括号的左边都是最多含一个操作符的算式，应该可以利用这一点，减少代码。利用高或等于的优先级就出栈运算的特点
    public int calculate(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ')
                continue;
            if (match(s.charAt(i))) {
                char k = s.charAt(i);
                if (k == ')') {
                    while (operator.peek() != '(') {
                        int a1 = operand.pop();
                        int a2 = operand.pop();
                        char m = operator.pop();
                        if (m == '+') {
                            operand.push(a1 + a2);
                        } else {
                            operand.push(a2 - a1);
                        }
                    }
                    operator.pop();
                } else if (k == '+' || k == '-') {
                    if (operator.isEmpty() || operator.peek() == '(') {
                        operator.push(k);
                    } else {
                        char p = operator.pop();
                        int m1 = operand.pop();
                        int m2 = operand.pop();
                        if (p == '+') {
                            operand.push(m1 + m2);
                        } else {
                            operand.push(m2 - m1);
                        }
                        operator.push(k);
                    }
                } else {
                    operator.push(k);
                }

            } else {
                int tp = 0;
                int j;
                for (j = i; j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++) {
                    tp = tp * 10 + (int) (s.charAt(j) - '0');
                }
                operand.push(tp);
                i = j - 1;
            }
        }
        while (!operator.isEmpty()) {
            char k = operator.pop();
            int a1 = operand.pop();
            int a2 = operand.pop();
            if (k == '+') {
                operand.push(a1 + a2);
            } else {
                operand.push(a2 - a1);
            }
        }
        return operand.peek();
    }

    @Test
    public void test() {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        Character.isDigit('c');

    }


}
