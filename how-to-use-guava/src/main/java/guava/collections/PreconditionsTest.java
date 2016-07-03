package guava.collections;

import com.google.common.base.Preconditions;

/**
 * Created by daijiajia on 16/7/3.
 */
public class PreconditionsTest {

    public static boolean validateObjectState() {
        return false;
    }

    public static void main(String[] args) {
        Preconditions.checkNotNull("", "检查对象不能为空");
        int[] arr = {1, 3, 5};

        Preconditions.checkElementIndex(2, arr.length, "检查数组索引是否越界");

        int valueToSet = 10;
        Preconditions.checkArgument(valueToSet <= 100, "检查参数值");


        Preconditions.checkState(validateObjectState(), "检查对象状态（返回boolean值）");
    }
}
