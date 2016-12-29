package org.java.learn.topic.algorithm;

/**
 * ClassName: Make100From1To9 <br/>
 * Description: TODO <br/>
 * Date: 2016-03-14 11:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-14 jdai@ created. <br/>
 */
public class Make100From1To9 {

    public static void main(String[] args) {
        //编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，使得计算结果总是 100 的程序，并输出所有的可能性。
        //例如：1 + 2 + 34 – 5 + 67 – 8 + 9 = 100。
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sym = new int[8];

        //0 + 1 - 2 none
        for (sym[0] = 0; sym[0] < 3; sym[0]++)
            for (sym[1] = 0; sym[1] < 3; sym[1]++)
                for (sym[2] = 0; sym[2] < 3; sym[2]++)
                    for (sym[3] = 0; sym[3] < 3; sym[3]++)
                        for (sym[4] = 0; sym[4] < 3; sym[4]++)
                            for (sym[5] = 0; sym[5] < 3; sym[5]++)
                                for (sym[6] = 0; sym[6] < 3; sym[6]++)
                                    for (sym[7] = 0; sym[7] < 3; sym[7]++) {
                                        int result = 0;
                                        StringBuffer sb = new StringBuffer();
                                        sb.append(b[0]);
                                        for (int i = 0; i < 8; i++) {
                                            if (sym[i] == 0) {
                                                sb.append("+" + b[i + 1]);
                                            } else if (sym[i] == 1) {
                                                sb.append("-" + b[i + 1]);
                                            } else {
                                                sb.append(b[i + 1]);
                                            }
                                        }

                                        String str = sb.toString();
                                        result = getResult(str);

                                        if (result == 100) {
                                            for (int i = 0; i < 8; i++) {
                                                if (sym[i] == 0) {
                                                    System.out.print(b[i] + "+");
                                                } else if (sym[i] == 1) {
                                                    System.out.print(b[i] + "-");
                                                } else {
                                                    System.out.print(b[i]);
                                                }
                                            }
                                            System.out.println(b[8]);
                                        }

                                    }
    }

    public static int getResult(String str) {
        int result = 0;
        boolean isPlus = true;
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (isPlus) {
                    result += temp;
                    temp = 0;
                } else {
                    result -= temp;
                    temp = 0;
                }
                if (c == '-') {
                    isPlus = false;
                } else {
                    isPlus = true;
                }
            } else {
                temp = temp * 10 + Integer.parseInt(str.charAt(i) + "");
            }
        }
        //deal with the last number
        if (isPlus) {
            result += temp;
        } else {
            result -= temp;
        }
        return result;
    }
}
