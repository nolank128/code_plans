# Docker | Docker入门安装




## 2.卸载旧版Docker

首先如果系统中已经存在旧的Docker，则先卸载：

```bash
yum remove docker \
    docker-client \
    docker-client-latest \
    docker-common \
    docker-latest \
    docker-latest-logrotate \
    docker-logrotate \
    docker-engine
```



## 3.配置yum仓库

笔者服务器是 `centos 7` 环境

如果CentOS系统内核低于3.10，可以升级软件包及内核，通过 `yum update` 升级

> Linux系统分为两种：
>
> 1. RedHat系列：Redhat、Centos、Fedora等
> 2. Debian系列：Debian、Ubuntu等
>
> RedHat系列的包管理工具是`yum`
>
> Debian系列的包管理工具是`apt-get`

首先要安装一个yum工具

```Bash
yum install -y yum-utils
```

安装成功后，执行命令，配置Docker的yum源：

```Bash
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```



## 4.安装Docker

最后，执行命令，安装Docker

```Bash
yum install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```



## 5.添加自启动配置

因为我们是本地虚拟机，不能像云服务器一样无时无刻在运行，所以我们需要配置一下，让他开机自启，省得我们每次打开虚拟机都要打开docker。

```bash
# 启动Docker
systemctl start docker

# 停止Docker
systemctl stop docker

# 重启
systemctl restart docker

# 设置开机自启
systemctl enable docker

# 执行docker ps命令，如果不报错，说明安装启动成功
docker ps
```



## 6.配置阿里云镜像加速

### 6.1 注册阿里云账号

阿里云官网： https://www.aliyun.com/

![image-20231123152645907](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231526065.png)





### 6.2 开启镜像服务

![image-20231123152747592](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231527634.png)

点击后进入控制台：

![image-20231123152851462](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231529709.png)



### 6.3 配置镜像加速

找到**镜像工具**下的**镜像加速器**：	

![image-20231123153033393](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231530423.png)



页面向下滚动，即可找到配置的文档说明：

选择自己Linux对应的版本即可

![image-20231123153103236](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231531268.png)

具体命令如下：

```bash
# 创建目录
mkdir -p /etc/docker

# 复制内容，注意把其中的镜像加速地址改成你自己的
tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://xxxx.mirror.aliyuncs.com"]
}
EOF

# 重新加载配置
systemctl daemon-reload

# 重启Docker
systemctl restart docker
```



### 6.4 测试

输入命令测试docker是否安装完毕

```bash
docker--version
```

![image-20231123155308179](https://gaoziman.oss-cn-hangzhou.aliyuncs.com/LeoPic202311231553203.png)



## 7.文章参考

- https://docs.docker.com/engine/install/centos/#install-from-a-package


