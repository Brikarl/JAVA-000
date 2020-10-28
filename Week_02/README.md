# Week_01

## 10.22 调优分析与面试经验

### GC 日志解读与分析

- `‐XX:ParallelGCThreads=n`

设置STW阶段的并行 worker 线程数量。 

如果逻辑处理器**小于等于8**个，则默认值 **n** 等于逻辑处理器的数量。 

如果逻辑处理器**大于8**个，则默认值 n 等于处理器数量的 **5/8+3** 。 在大多数情况下都是个比较合理的值。 如果是高配置的 SPARC 系统，则默认值 n  大约等于逻辑处理器数量的 5/16 。

> [Garbage First Garbage Collector Tuning](https://www.oracle.com/technical-resources/articles/java/g1gc.html)