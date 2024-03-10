<a name="Xw3xB"></a>

### 数组理论基础

**数组**是存放在**连续内存空间**上的**相同类型数据**的集合。

数组是一种线性表结构，线性表结构，顾名思义就是，将存储的数据排成一条线一样的结构，存储的每个数据最多只有前后两个方向。

![](https://cdn.nlark.com/yuque/0/2023/png/35027732/1697638424475-2017715e-5659-46f4-8461-55ac8a8329a2.png#averageHue=%23f8f8f7&clientId=ubd3b8c1e-ee2f-4&from=paste&id=kHpfq&originHeight=157&originWidth=488&originalType=url&ratio=2&rotation=0&showTitle=false&status=done&style=none&taskId=u1599e93d-af46-4aea-837e-79fc02c06db&title=)


**因为数组的在内存空间的地址是连续的，**使得数组按照下标随机访问(**随机访问：可以用同等的时间访问到一组数据中的任意一个元素**)数组中数据元素时间复杂度达到 O(1) 级别。

计算机会为每一个内存单元分配一个地址，并通过该地址来访问内存中的数据。数组在内存空间中的地址是连续的，当我们知道数据的首地址后，通过公式便可以计算出元素的内存地址，让计算机直接访问，达到 O(1) 级别的时间复杂度。

> 我们是**通过数组下标访问数据时，时间复杂度才是 O(1)**,
> 当我们通过数据查找元素时，我们需要遍历数组查找对应的数据，时间复杂度是 O(n)。

```
// i 表示数组下标， base_address 表示数组首地址，data_type_size 表示数组中每个数据大小
a[i]_address=base_address+i*data_type_size
```

 <br />**但是我们在删除或者增添元素的时候，就难免要移动其他元素的地址。**<br />例如 删除下标为3的元素，需要对下标为3的元素后面的所有元素都要做移动操作，如图所示：<br />![](https://cdn.nlark.com/yuque/0/2024/png/35027732/1708480175632-8a28d996-991a-4041-99ff-cb59dc9189e4.png#averageHue=%23f4f3f3&clientId=u4ebcff89-b41c-4&from=paste&id=u35e5c20c&originHeight=316&originWidth=1164&originalType=url&ratio=2&rotation=0&showTitle=false&status=done&style=none&taskId=u55caba47-c650-4745-b9c5-4a7586872fb&title=)

数组具有以下特点：

- **在存储空间中按顺序存储，地址连续。**
- **数值数组元素的默认值为 0，而引用元素的默认值为 null。**
- **数组的索引从 0 开始，如果数组有 n 个元素，那么数组的索引是从 0 到（n-1）。**
- **数组元素可以是任何类型，包括数组类型。**
- **数组的元素是不能删的，只能覆盖，平时删除操作也是依次用后一位覆盖，因为申请且初始化后，存储空间就固定了。**

<a name="gwHTf"></a>

### 数组变量的声明

首先必须声明数组变量，才能在程序中使用数组。

```
dataType[] arrayRefVar;   // 首选的方法
 
或
 
dataType arrayRefVar[];  // 效果相同，但不是首选方法
```

<a name="bJ2Go"></a>

### 数组的创建

```
创建数组的方式
array =new dataType[arraySize];

dataType[] array={value0,value1,....,valuen};
```

> array =new dataType[arraySize];
> 代码分析
> 1、使用dataType[arraySize]创建一个数组。
> 2、把新创建的数组引用赋值给变量array。
>
> 数组变量的声明并创建数组；
> dataType[] array=new dataType[arraySize];

<a name="mfoBs"></a>

### 数组遍历

数组创建后，元素类型和数组的大小都是确定的。遍历数组时可以选取for循环或者For-Each循环<br />**for循环**

```
       double[] arr={1.1,2.2,3.3};
				for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
```

**For-Each循环**<br />For-Each 循环或者加强型循环，它能在不使用下标的情况下遍历数组。

```
for (double element:arr
             ) {
            System.out.println(element);
        }
```

<a name="N5pBt"></a>

### 多维数组

二维数组可以看成是数组的数组，三维数组可以看成二维数组的数组。<br />比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组。<br />**多维数组声明**

```
数据类型[][] 数组名称;
数据类型[]   数组名称[];
数据类型     数组名称[][];

int[][] array;
char arrays[][];

数据类型[][][] 数组名称;
多维数组声明以此类推。
```

> 数组声明以后在内存中没有分配具体的存储空间，也没有设定数组的长度。 
> Java 中多维数组不必都是规则矩阵形式，例如 int[][] arr = new int[][]{{1, 1, 2}, {2, 5}, {1, 2, 3, 4}};

> 注意：int[] x,y[]:  x是一维数组，y 是二维数组。

**多维数组初始化**

1. 静态初始化（整体赋值）

数组静态初始化时，必须和数组的声明写在一起。

```
int[][] arrays = {{ 1, 2, 3, 4 }, { 5, 6, 7, 8 },{ 9, 10, 11, 12 }};
//定义一个名称为 arrays 的二维数组，二维数组中有三个一维数组，每一个一维数组中具体元素也都初始化了。

int[][][] arrays2 = { { {1,2,3} , {1,2,3} } ,{{3,4,1},{2,3,4}} };
//定义一个名称为 arrays2 的三维数组，三维数组中有两个二维数组，每个二维数组中有两个一维数组，每一个一维数组中具体元素也都初始化了。
```

2. 动态初始化

```
数据类型[][] 数组名称= new 数据类型[第一维的长度][第二维的长度];
数据类型[][] 数组名称;
数组名称= new 数据类型[第一维的长度][第二维的长度];

int[][] array=new int[2][2];
int [][] arrays;
arrays=new int[3][4];
```

动态初始化可以和数组的声明分开，动态初始化只指定数组的长度，数组中每个元素的初始化是数组声明时数据类型的默认值。

> int[][] a=new int [2][3];
> int[][] b;
> b=new int [1][2];
> 这种初始化方式的数组中，第二维长度都是相同的。也可以从最高维开始，分别为每一个维度分配空间。
> String[][]s = newString[2][];
> s[0] = newString[2]; 
> s[1] = newString[3]; 
> 所以，在初始化第一维的长度时，其实是将数组看成了一个一维数组，初始化长度为2，而该数组包含2个元素，这两个元素分别也是一个一维数组。

> Java 中多维数组不必都是规则矩阵形式，每个一维数组的长度可以各不相同。

![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1697814334999-53f118da-752d-4944-9786-cbe873d6d392.png#averageHue=%23fbfaf9&clientId=ue7f5c679-b0a8-4&from=paste&height=329&id=u4845f0d5&originHeight=658&originWidth=1285&originalType=binary&ratio=2&rotation=0&showTitle=false&size=100924&status=done&style=none&taskId=u1102fea2-9108-481a-85ed-ef3a12948a7&title=&width=642.5)

> C++中⼆维数组在地址空间上是连续的。像Java是没有指针的，同时也不对程序员暴露其元素的地址，寻址操作完全交给虚拟机。
> ![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1697818297001-f26365f6-c48f-4a20-a0e5-7b748e0d5566.png#averageHue=%23f6f6f6&clientId=ue7f5c679-b0a8-4&from=paste&height=294&id=u749ab2c5&originHeight=588&originWidth=1279&originalType=binary&ratio=2&rotation=0&showTitle=false&size=63825&status=done&style=none&taskId=u3d7017a1-c783-469c-a95d-9e599b3f694&title=&width=639.5)
> 这⾥的数值也是16进制，这不是真正的地址，⽽是经过处理过后的数值了，我们也可以看出，⼆维数组的每⼀⾏头结点的地址是没有规则的，更谈不上连续。
> Java的⼆维数组可能是如下排列的⽅式：
> ![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1697818165074-273a97c4-a03a-4861-aa19-a90817be22f7.png#averageHue=%23ededed&clientId=ue7f5c679-b0a8-4&from=paste&height=300&id=DrElq&originHeight=599&originWidth=1326&originalType=binary&ratio=2&rotation=0&showTitle=false&size=40477&status=done&style=none&taskId=uc5da4b85-b485-4f59-b044-1848cb58e84&title=&width=663)


**数组默认值（以二维数组为例）**<br />二维数组分为外层数组的元素，内层数组的元素，例如外层元素：arr[1]等 ，内层元素：arr[1][2]等<br />数组元素的默认初始化值：

- 针对于初始化方式一：比如：int[][] arr = new int[4][3];

外层元素的初始化值为：内层数组的地址值。<br />内层元素的初始化值为：与一维数组初始化情况相同

> 一维数组的默认值取决于数组元素的类型。以下是一些常见类型的默认值：
>
> - 对于整数类型（如int、byte、short、long），默认值为0。
> - 对于浮点数类型（如float、double），默认值为0.0。
> - 对于布尔类型（boolean），默认值为false。
> - 对于字符类型（char），默认值为\u0000，即空字符。
> - 对于引用类型（如类、接口、数组），默认值为null，表示没有引用任何对象

- 针对于初始化方式二：比如：int[][] arr = new int[2][];

外层元素的初始化值为： null<br />内层元素的初始化值为：不能调用，否则报错。

**多维数组的长度**

```
//多维数组的长度
int[][] m = {{1,2,3,1},{1,3},{3,4,2}};
int sum=0;
for (int i=0;i<m.length;i++){
    sum+=m[i].length;
 }
System.out.println("sum="+sum);
```

**遍历多维数组**（以二维数组为例）<br />对二维数组中的每个元素，引用方式为 **arrayName[index1][index2]，例如：num[1][0]**<br />**for循环遍历**

```
for (int i=0;i<m.length;i++){
            for (int j=0;j<m[i].length;j++){
                System.out.println(m[i][j]);
            }
            System.out.println();
        }
```

**foreach循环遍历**

```
for (int[] type:m  ) // 第一个循环，第一个参数代表循环中的类型，即数组，第二个参数为循环对象
{
	for (int j:type) {System.out.println(j); }// 循环上一个循环中的第一个参数中的每一个即可
  	System.out.println();
}
```









