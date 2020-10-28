# Week_01

## 10.22 调优分析与面试经验

### GC 日志解读与分析

- `‐XX:ParallelGCThreads=n`

设置STW阶段的并行 worker 线程数量。 

如果逻辑处理器**小于等于8**个，则默认值 **n** 等于逻辑处理器的数量。 

如果逻辑处理器**大于8**个，则默认值 n 等于处理器数量的 **5/8+3** 。 在大多数情况下都是个比较合理的值。 如果是高配置的 SPARC 系统，则默认值 n  大约等于逻辑处理器数量的 5/16 。

> [Garbage First Garbage Collector Tuning](https://www.oracle.com/technical-resources/articles/java/g1gc.html)

### 关于一点 G1 与 CMS 的思考

既然有了 G1 为什么还要使用 CMS 呢？

> G1相对于CMS仍然不是占全方位、压倒性优势的，从它出现几年仍不能在所有应用场景中代替CMS就可以得知这个结论。比起CMS，G1的弱项也可以列举出不少，如在用户程序运行过程中，G1无论是为了垃圾收集产生的内存占用（Footprint）还是程序运行时的额外执行负载（Overload）都要比CMS要高。
>
> ...
>
> 按照笔者的实践经验，目前在小内存应用上CMS的表现大概率仍然要会优于G1，而在大内存应用上G1则大多能发挥其优势，这个优劣势的Java堆容量平衡点通常在6GB至8GB之间
>
> ——周志明「深入理解 Java 虚拟机」



