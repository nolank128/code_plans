

## 704.二分查找

<a name="vsk91"></a>

### 题目

> 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


> **提示：**
>
> 1. 你可以假设 nums 中的所有元素是不重复的。
> 2. n 将在 [1, 10000]之间。
> 3. nums 的每个元素都将在 [-9999, 9999]之间。


![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1708870324495-e8bc4bf1-45ed-4f71-ab87-efddd68094f3.png#averageHue=%23fafafa&clientId=ufdf286fd-d9d4-4&from=paste&height=249&id=u4e5141b0&originHeight=498&originWidth=1209&originalType=binary&ratio=2&rotation=0&showTitle=false&size=48589&status=done&style=none&taskId=ud8fa8115-7e75-42ae-9a52-022e1c20d39&title=&width=604.5)
<a name="q4rne"></a>

### 思路

二分查找最常用的场景：寻找一个数、寻找左侧边界、寻找右侧边界。<br />而看到该题目给出的提示，数组为有序数组，数组元素不重复。这些不就是使用二分法的前提条件嘛。

使用二分法时主要需要注意区间的定义，区间的定义就是不变量，要在二分查找的过程中，保持不变量，就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作，这就是**循环不变量**规则。

<a name="qI12U"></a>

### 解法

<a name="bG1Ox"></a>

#### 左闭右闭式写法

左闭右闭，即区间定义为[left,right]，那么while条件中，采用的是<=,即 left<=right,if中的判断条件则要根据情况赋值

![496883935.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1708872683128-185c221d-d66c-49ed-9772-7771f0ed235d.jpeg#averageHue=%239a9c9b&from=url&id=VIrgt&originHeight=3860&originWidth=2971&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7111878&status=done&style=none&title=)

- nums[middle] > target，right=middle-1;
- nums[middle] < target，left=middle+1;

代码示例：

```
class Solution {
    public int search(int[] nums, int target) {
// 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else return middle;
        }
        return -1;
    }
}
```

- 时间复杂度：O(log n)
- 空间复杂度：O(1)

<a name="Yg5GR"></a>

#### 左闭右开式写法

左闭右开，即区间定义为[left,right），那么while条件中，采用的是<,即 left<right, if 中的判断条件则要根据情况赋值

![-2137535960.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1708874272206-a12f1ce7-7969-4136-b01a-3013e702d172.jpeg#averageHue=%23aaaca7&from=url&id=fYWCK&originHeight=2464&originWidth=3060&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4772551&status=done&style=none&title=)

- nums[middle] > target，right=middle;
- nums[middle] < target，left=middle+1;

代码示例：

```
class Solution {
    public int search(int[] nums, int target) {
// 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle+1;
            } else return middle;
        }
        return -1;
    }
}
```

- 时间复杂度：O(log n)
- 空间复杂度：O(1)




<a name="bfFSm"></a>

##   27.移除元素

<a name="xkyDO"></a>

### 题目

> 给你一个数组 nums_ _和一个值 val，你需要 [原地](https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95) 移除所有数值等于 val_ _的元素，并返回移除后数组的新长度。
> 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 [原地](https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95)**修改输入数组**。
> 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。


> **说明:**
> 为什么返回数值是整数，但输出的答案是数组呢?
> 请注意，输入数组是以**「引用」**方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
> 你可以想象内部操作如下:

```
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```


![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1708912799304-1535bf8e-f5b0-441d-ab06-f4d9d05ca165.png#averageHue=%23f8f8f8&clientId=u57978e2c-0742-4&from=paste&height=482&id=u4dda30e3&originHeight=964&originWidth=1143&originalType=binary&ratio=2&rotation=0&showTitle=false&size=139297&status=done&style=none&taskId=u02d8953e-5e0c-4d15-a95f-8ae1cb5ca25&title=&width=571.5)


<a name="lai03"></a>

### 思路

暴力解法主要是两层for循环，一层for循环找到val，一层for循环用于覆盖val，将val后的所有的数组元素全部前移。

![-1516976305.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1708914279205-1d5480c1-3a95-4d9a-a3a4-33497123c97e.jpeg#averageHue=%23bdbcb6&from=url&id=YcBRx&originHeight=976&originWidth=2679&originalType=binary&ratio=1&rotation=0&showTitle=false&size=1682598&status=done&style=none&title=)

双指针法主要是通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。

- 快指针用于寻找新数组元素的值
- 慢指针用于来确定新数组元素的下标

![283705997.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1708916350127-cfa02f8f-d77f-4195-914c-df996c3ef3b7.jpeg#averageHue=%23acada7&from=url&id=kMfKm&originHeight=2399&originWidth=2572&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3822096&status=done&style=none&title=)

<a name="CVLsl"></a>

### 解法

<a name="lhUY7"></a>

#### 暴力解法

代码实现

```
class Solution {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        for(int i=0; i<length;i++){
            if(nums[i]==val){
                for(int j=i+1;j<length;j++){
                    nums[j-1]=nums[j];
                }
                i--;
                length--;
            }
        }
        return length;
    }
}
```

- 时间复杂度：O(n^2)
- 空间复杂度：O(1)

<a name="h7AX1"></a>

#### 快慢指针解法

代码实现

```
class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)



<a name="fa3l6"></a>

## 977.有序数组的平方

<a name="YxiQf"></a>

### 题目

> 给你一个按 **非递减顺序** 排序的整数数组 nums，返回 **每个数字的平方** 组成的新数组，要求也按 **非递减顺序** 排序。


![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1709045205612-cb5281b7-0594-4e8d-9fc7-24ab6e05a1de.png#averageHue=%23f7f7f7&clientId=u505879de-8e05-4&from=paste&height=240&id=uc3264e1d&originHeight=479&originWidth=699&originalType=binary&ratio=2&rotation=0&showTitle=false&size=47889&status=done&style=none&taskId=u827ded56-a2da-43dc-9a83-e90769234e5&title=&width=349.5)

<a name="qeruv"></a>

### 思路

**该题目中给的序列为非递减序列，即有可重复值的递增序列。**<br />暴力解法、快慢指针法都是先平方后排序。<br />双指针法，使用start下标和end下标进行指向，并将元素平方后的大小判断的结果填入新的数组，在新数组中，从后往前依次填入数组元素。

- 若 nums[startIndex]*nums[startIndex]<nums[endIndex]*nums[endIndex]，那么result[k--]=nums[endIndex]*nums[endIndex];
- 若nums[startIndex]*nums[startIndex]>nums[endIndex]*nums[endIndex]，那么 result[k--]=nums[startIndex]*nums[startIndex];

![144100158.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1709046527692-60ad00de-d27d-4df0-af5f-e3a9c95e229e.jpeg#averageHue=%23a5a5a1&from=url&id=Ze5CL&originHeight=2636&originWidth=2780&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4103368&status=done&style=none&title=)

<a name="Ia8m6"></a>

### 解法

<a name="HiT9j"></a>

#### 暴力解法

代码示例：

```
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] newNums=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            newNums[i]=nums[i]*nums[i];
        }
        Arrays.sort(newNums);
        return newNums;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)
  <a name="WZnqf"></a>

#### 快慢指针法

代码示例：

```
class Solution {
    public int[] sortedSquares(int[] nums) {
        int fastIndex=0;
        int slowIndex=0;

        for(fastIndex=0;fastIndex<nums.length;fastIndex++){
            nums[slowIndex]=nums[fastIndex]*nums[fastIndex];
            slowIndex++;
        }
        Arrays.sort(nums);
        return nums;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)
  <a name="d9FYo"></a>

#### 双指针法

代码示例

```
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int k=nums.length-1;
        int startIndex=0;
        int endIndex=nums.length-1;
        while(startIndex<=endIndex){
            if(nums[startIndex]*nums[startIndex]<nums[endIndex]*nums[endIndex]){
                result[k--]=nums[endIndex]*nums[endIndex];
                endIndex--;
            }else{
                result[k--]=nums[startIndex]*nums[startIndex];
                startIndex++;
            }
        }
        return result;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)



<a name="yVHaE"></a>

## 209.长度最小的子数组

<a name="VWUGs"></a>

### 题目

> 给定一个含有 n** **个正整数的数组和一个正整数 target** 。**
> 找出该数组中满足其总和大于等于** **target** **的长度最小的 **连续子数组** [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度**。**如果不存在符合条件的子数组，返回 0 。


![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1709086776144-011020a9-31ad-4119-b78d-506ab6aa8637.png#averageHue=%23fafafa&clientId=u2c9f3757-222b-4&from=paste&height=300&id=u44600ebe&originHeight=600&originWidth=1229&originalType=binary&ratio=2&rotation=0&showTitle=false&size=52077&status=done&style=none&taskId=u0cd095b1-9b3e-4ebe-86cc-60473e114f9&title=&width=614.5)

<a name="rITuU"></a>

### 思路

暴力解法主要就是两个for循环，一个for循环固定一个数组元素，例如n,另一个for循环从n的下一个元素开始累加，当和大于等于target时终止内层循环，并记录该最小长度。

![-1891226098.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1709133080419-2ed17a71-44f7-4e8a-9474-8a2a5ddeeaf3.jpeg#averageHue=%23ada7a0&from=url&id=s2bV5&originHeight=4080&originWidth=2101&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5118661&status=done&style=none&title=)

滑动窗口（其实可以看成队列）主要就是通过不断地调节子序列的起始位置和终止位置来得到相应的结果。<br />我们把数组中的元素不停的入队，直到总和大于等于 s 为止，接着记录下队列中元素的个数，然后再不停的出队，直到队列中元素的和小于 s 为止（如果不小于 s，也要记录下队列中元素的个数，这个个数其实就是不小于 s 的连续子数组长度，我们要记录最小的即可）。接着再把数组中的元素添加到队列中……重复上面的操作，直到数组中的元素全部使用完为止。<br />![-916795231.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1709134400849-d43d224a-eb9c-4c92-9b16-182c33fa0c29.jpeg#averageHue=%23b0a7a0&from=url&id=Wmyd5&originHeight=3834&originWidth=1848&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4323647&status=done&style=none&title=)

<a name="rhGxy"></a>

### 解法

<a name="DnVJv"></a>

#### 暴力解法

代码示例：

```
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    break; 
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```

- 时间复杂度：O(n^2)
- 空间复杂度：O(1)
  <a name="G2QKv"></a>

#### 队列相加法（滑动窗口）

代码示例

```
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int startIndex=0;
        int endIndex=0;
        int sum = 0;

        for (endIndex=0; endIndex < nums.length; endIndex++) {
            sum+=nums[endIndex];
            while (sum>=target) {
                result=Math.min(result,endIndex-startIndex+1);
                sum-=nums[startIndex];
                startIndex++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)
  <a name="SGruv"></a>

#### 对列相减法（滑动窗口）

代码示例

```
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int startIndex=0;
        int endIndex=0;
        int sum = 0;

        for (endIndex=0; endIndex < nums.length; endIndex++) {
            target-=nums[endIndex];
            while (target<=0) {
                result=Math.min(result,endIndex-startIndex+1);
                target+=nums[startIndex];
                startIndex++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)

> 不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。





<a name="hq8Rm"></a>

## 59.螺旋矩阵 II

<a name="Ep22n"></a>

### 题目

> 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。


![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1709175327725-3938a14c-5a4a-4de7-be4e-5511dc8f12a4.png#averageHue=%23f7f7f7&clientId=uf3d4ed08-249e-4&from=paste&height=445&id=u1de72de5&originHeight=890&originWidth=1214&originalType=binary&ratio=2&rotation=0&showTitle=false&size=69454&status=done&style=none&taskId=u5012846f-0f7c-4457-ba37-c007583e458&title=&width=607)

<a name="aSWpe"></a>

### 思路

顺时针螺旋排列的正方形矩阵的分析过程：

- 填充上行从左到右
- 填充右列从上到下
- 填充下行从右到左
- 填充左列从下到上

由外向内一圈一圈这么画下去。<br />按照左闭右开的原则，画出相应的图。<br />![-114936546.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/35027732/1709216460064-fe4569e3-c546-41a6-9ee9-d84a4801afac.jpeg#averageHue=%23a9a69e&from=url&id=g913G&originHeight=4080&originWidth=3060&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4256742&status=done&style=none&title=)

<a name="xIdgl"></a>

### 解法

代码示例

```
class Solution {
    public int[][] generateMatrix(int n) {

        int startX = 0;
        int startY = 0;
        int[][] nums = new int[n][n];
        int mid = n / 2;// 如果n为奇数，那么最中间的位置为mid，例如 n 为3，中间的位置下标为【1,1】
        int m = 0;// 控制循环次数，每循环一圈加一
        int offset = 1;// 每循环一圈，右边界收缩一位
        int count = 1;
        int i, j;

        while (m++ < mid) {
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
        }

        if (n % 2 != 0) {
            nums[mid][mid] = count;
        }
        return nums;
    }
}
```

- 时间复杂度 O(n^2): 模拟遍历二维矩阵的时间
- 空间复杂度 O(1)

