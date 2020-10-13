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