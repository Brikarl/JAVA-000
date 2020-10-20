

# Week_01

## 10.15 JVM核心技术

### Java字节码技术

#### 理解字节码诀窍

- 给局部变量赋值时，需要使用相应的指令来进行 `store` ，如 `astore_1` 。 `store` 类的指令都会删除栈顶值。 存储在本地变量表中。
- 相应的 `load` 指令则会将值从局部变量表压入操作数栈，但并不会删除局部变量中的值。

#### `for each` 和 `for i++` 的区别

```java
/**
 * 流程控制指令
 *
 * @Author: Yunkai Bo
 * @Date: 2020/10/17 12:54
 * @Version 1.0
 */
public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }
}
```




```java
public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 14 L0
    NEW Week_01/demo/MovingAverage
    DUP
    INVOKESPECIAL Week_01/demo/MovingAverage.<init> ()V
    ASTORE 1
   L1
    LINENUMBER 15 L1
    GETSTATIC Week_01/demo/ForLoopTest.numbers : [I
    ASTORE 2
    ALOAD 2
    ARRAYLENGTH
    ISTORE 3
    ICONST_0
    ISTORE 4
   L2
   FRAME FULL [[Ljava/lang/String; Week_01/demo/MovingAverage [I I I] []
    ILOAD 4
    ILOAD 3
    IF_ICMPGE L3 // 比较部分
    ALOAD 2
    ILOAD 4
    IALOAD
    ISTORE 5
   L4
    LINENUMBER 16 L4
    ALOAD 1
    ILOAD 5
    I2D
    INVOKEVIRTUAL Week_01/demo/MovingAverage.submit (D)V
   L5
    LINENUMBER 15 L5
    IINC 4 1
    GOTO L2
   L3
    LINENUMBER 18 L3
   FRAME CHOP 3
    ALOAD 1
    INVOKEVIRTUAL Week_01/demo/MovingAverage.getAvg ()D
    DSTORE 2
   L6
    LINENUMBER 19 L6
    RETURN
   L7
    LOCALVARIABLE number I L4 L5 5
    LOCALVARIABLE args [Ljava/lang/String; L0 L7 0
    LOCALVARIABLE ma LWeek_01/demo/MovingAverage; L1 L7 1
    LOCALVARIABLE avg D L6 L7 2
    MAXSTACK = 3
    MAXLOCALS = 6
```




```java
/**
 * 流程控制指令
 *
 * @Author: Yunkai Bo
 * @Date: 2020/10/17 12:54
 * @Version 1.0
 */
public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int i = 0; i < numbers.length; i++) {
            ma.submit(numbers[i]);
        }
        double avg = ma.getAvg();
    }
}
```



```java
public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 14 L0
    NEW Week_01/demo/MovingAverage
    DUP
    INVOKESPECIAL Week_01/demo/MovingAverage.<init> ()V
    ASTORE 1
   L1
    LINENUMBER 15 L1
    ICONST_0
    ISTORE 2
   L2
   FRAME APPEND [Week_01/demo/MovingAverage I]
    ILOAD 2
    GETSTATIC Week_01/demo/ForLoopTest.numbers : [I
    ARRAYLENGTH
    IF_ICMPGE L3
   L4
    LINENUMBER 16 L4
    ALOAD 1
    GETSTATIC Week_01/demo/ForLoopTest.numbers : [I
    ILOAD 2
    IALOAD
    I2D
    INVOKEVIRTUAL Week_01/demo/MovingAverage.submit (D)V
   L5
    LINENUMBER 15 L5
    IINC 2 1
    GOTO L2
   L3
    LINENUMBER 18 L3
   FRAME CHOP 1
    ALOAD 1
    INVOKEVIRTUAL Week_01/demo/MovingAverage.getAvg ()D
    DSTORE 2
   L6
    LINENUMBER 19 L6
    RETURN
   L7
    LOCALVARIABLE i I L2 L3 2
    LOCALVARIABLE args [Ljava/lang/String; L0 L7 0
    LOCALVARIABLE ma LWeek_01/demo/MovingAverage; L1 L7 1
    LOCALVARIABLE avg D L6 L7 2
    MAXSTACK = 3
    MAXLOCALS = 4
```

### Java类加载器

==类加载机制有三个特点：==

1. **双亲委托**：当一个自定义类加载器需要加载一个类，比如java.lang.String，它很懒，不会一上来就直接试图加载它，而是先委托自己的父加载器去加载，父加载器如果发现自己还有父加载器，会一直往前找，这样只要上级加载器，比如启动类加载器已经加载了某个类比如java.lang.String，所有的子加载器都不需要自己加载了。如果几个类加载器都没有加载到指定名称的类，那么会抛出  ClassNotFountException异常。
2. **负责依赖**：如果一个加载器在加载某个类的时候，发现这个类依赖于另外几个类或接口，也会去尝试加载这些依赖项。
3. **缓存加载**：为了提升加载效率，消除重复加载，一旦某个类被一个类加载器加载，那么它会缓存这个加载结果，不会重复加载。同一个类只会加载一次

### Java内存模型（JMM）

方法中使用的原生数据类型和对象引用地址在栈上存储；对象、对象成员与类定义、静态变量在堆上。

## 10.17 工具与 GC 策略

###  JDK 内置命令行工具

当默认配置 `java -jar xxx.jar` 时，显示堆栈信息如下：

```powershell
Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 2147483648 (2048.0MB) // 最大堆容量，默认是物理内存容量(8GB)的 1 / 4 
   NewSize                  = 44564480 (42.5MB)  // 初始化新生代容量，默认是物理容量(8GB)的 1 / 64
   MaxNewSize               = 715653120 (682.5MB) // 最大新生代容量，恰好是堆最大容量(2GB)的 1 / 3
   OldSize                  = 89653248 (85.5MB)
   NewRatio                 = 2 // 老年代 : 新生代 = 2 : 1
   SurvivorRatio            = 8 // Eden : survivor = 8 : 1 : 1
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)
```

### 垃圾回收器

- ==JDK 1.8 及之前为**并行GC**，JDK9 之后为 **G1**。==
- CMS GC 为**并发 GC**，即在垃圾回收的过程中，业务代码也会并发运行，不会 STW。而**并行 GC** 则是会 STW。
- CMS GC 的  `MaxNewSize` 为 $64(64位机器)*4(并行线程数)*c(系数)$ 。
- **并行垃圾收集器**适用于多核服务器，主要目标是增加吞吐量。**CMS GC** 的设计目标是避免在老年代垃圾收集时出现长时间的卡顿。**G1 GC**最主要的设计目标是：将STW停顿的时间和分布，变成可预期且可配置的。每次只处理一部分内存块。

