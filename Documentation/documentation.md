# 踩坑记录

## git 提交代码时 src refspec feature does not match any.

### 问题描述

```shell
$ git push -u origin master
error: src refspec master does not match any
error: failed to push some refs to 'git@github.com:Brikarl/JAVA-000.git'
```

### 解决方案

```shell
$ git branch -a
* main
  remotes/origin/HEAD -> origin/main
  remotes/origin/main
```

使用 `git branch -a` 命令查看仓库分支，发现主分支名字为`main`。将命令修改为如下：

```shell
$ git push -u origin main
Everything up-to-date
Branch 'main' set up to track remote branch 'main' from 'origin'.
```

提交成功。

## 获取 base64 加密信息

在 git 命令行添加命令：

```shell
$ base64 Hello.class
yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUB
AA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgH
ABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5n
L09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsB
ABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAh
AAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQAL
AAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN
```

## Error:(11, 30) java: 找不到符号 符号:   类 Launcher 位置: 程序包 sun.misc

将 JDK  11.0 改为 JDK 1.8