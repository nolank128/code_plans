<a name="MWg5L"></a>
### 环境准备
> 操作系统版本为centos 7.9，内核版本需要在3.10以上

```
sudo uname -r

sudo cat /etc/redhat-release
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710755754846-ada73d36-b21e-4b9a-aa82-8efc69e40298.png#averageHue=%232b2928&clientId=u6755cfcc-6338-4&from=paste&height=85&id=MZuJU&originHeight=170&originWidth=1163&originalType=binary&ratio=2&rotation=0&showTitle=false&size=19852&status=done&style=none&taskId=uf3872dd9-f5f1-4a13-9820-92c1a9e594d&title=&width=581.5)

1.确认环境好后，安装工具包并设置仓库
```sql
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710755834649-bafba7f0-b6ce-48fb-a0f5-8ebec005ad10.png#averageHue=%23282726&clientId=u6755cfcc-6338-4&from=paste&height=399&id=uf26029ee&originHeight=798&originWidth=1373&originalType=binary&ratio=2&rotation=0&showTitle=false&size=86979&status=done&style=none&taskId=uf464d8cb-ba7c-490c-af18-cc04d21e978&title=&width=686.5)

<a name="uRUQD"></a>
#### 设置yum源
设置一下yum源，这里采用一下阿里云，也可以使用网易云等。<br />[阿里巴巴开源镜像站-OPSX镜像站-阿里云开发者社区](https://developer.aliyun.com/mirror/)<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710756130879-d3942beb-ba11-4af6-862d-5b3dc283f257.png#averageHue=%23faf8f7&clientId=u6755cfcc-6338-4&from=paste&height=342&id=u57759dc4&originHeight=683&originWidth=2174&originalType=binary&ratio=2&rotation=0&showTitle=false&size=66267&status=done&style=none&taskId=ucb2c01ff-ccb1-4a59-8e91-55023ee4e83&title=&width=1087)

1. 备份
```sql
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup

```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710756571439-ee3a535a-9ec7-42e0-a807-609a78ee72ef.png#averageHue=%23535150&clientId=u6755cfcc-6338-4&from=paste&height=91&id=ucea23366&originHeight=182&originWidth=1653&originalType=binary&ratio=2&rotation=0&showTitle=false&size=26262&status=done&style=none&taskId=u80fe6b1f-a77f-4ef2-87b3-58be82b6c21&title=&width=826.5)

2.下载新的centos-Base.repo
```sql
wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-7.repo
```

3.运行 yum makecache 生成缓存
```sql
yum clean all # 清除系统所有的yum缓存
yum makecache # 生成新的yum缓存
yum repolist
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710758081476-42439585-1085-46d1-b3d8-efc28bb3e32e.png#averageHue=%23282726&clientId=u6755cfcc-6338-4&from=paste&height=397&id=u93519004&originHeight=793&originWidth=1408&originalType=binary&ratio=2&rotation=0&showTitle=false&size=93988&status=done&style=none&taskId=u0ec524e3-f3b0-49d0-abcd-9a236f5f129&title=&width=704)
<a name="fL0rd"></a>
### 安装docker
1.通过yum安装Docker
```sql
yum -y install docker-ce
```
<a name="yozC7"></a>
#### 报错 Loaded plugins: fastestmirror
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710758510973-318c964c-d737-48ac-8645-b5cd307ca205.png#averageHue=%2333302d&clientId=u6755cfcc-6338-4&from=paste&height=158&id=u4909636e&originHeight=316&originWidth=575&originalType=binary&ratio=2&rotation=0&showTitle=false&size=25734&status=done&style=none&taskId=uecb12a8a-9579-4b7e-bc6f-4936c349356&title=&width=287.5)<br />解决方案：<br />1.禁用插件
```sql
vi /etc/yum/pluginconf.d/fastestmirror.conf
 enabled = 1//由1改为0，禁用该插件

vi /etc/yum.conf
plugins=1//改为0，不使用插件
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710758384951-926f4639-b7c8-4637-a776-613741990565.png#averageHue=%232b2a2a&clientId=u6755cfcc-6338-4&from=paste&height=87&id=kdFKD&originHeight=173&originWidth=570&originalType=binary&ratio=2&rotation=0&showTitle=false&size=8819&status=done&style=none&taskId=ud191c24b-d425-4595-ba8f-ffaaa244599&title=&width=285)

2.清除yum缓存,重新遍历
```sql
yum clean all # 清除系统所有的yum缓存
yum makecache # 生成新的yum缓存
yum repolist
```

3.重新安装docker
```sql
#通过yum安装Docker
yum -y install docker-ce

#启动Docker
sudo systemctl start docker
#设置Docker开机自启
sudo systemctl enable docker
#查看Docker版本
sudo docker version
```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710759306931-565863e6-4e20-4499-9978-3761ae82ecbe.png#averageHue=%23282726&clientId=u6755cfcc-6338-4&from=paste&height=411&id=uefc82ffa&originHeight=821&originWidth=1036&originalType=binary&ratio=2&rotation=0&showTitle=false&size=76513&status=done&style=none&taskId=u59dfd107-9801-4d0a-b2c8-3b3112a7837&title=&width=518)

<a name="Ptoop"></a>
#### 配置镜像加速
1..安装完成后，配置阿里镜像加速<br />（使用命令查看镜像源，如果没有该文件或没有配置，则镜像源位于国外）
```sql
cat /etc/docker/daemon.json
```
2.配置国内镜像
```sql
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["加速器地址"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

//加速器镜像地址，可以去阿里云等注册获取，
也可以使用 http://hub-mirror.c.163.com该地址
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710759586550-6b9e9ecd-394c-4336-a731-2c632f3fb28b.png#averageHue=%23f7f9fb&clientId=u6755cfcc-6338-4&from=paste&height=483&id=u7344cdb2&originHeight=966&originWidth=1418&originalType=binary&ratio=2&rotation=0&showTitle=false&size=107840&status=done&style=none&taskId=u5f233693-2724-49c9-a498-c4530962376&title=&width=709)

<a name="L64Nz"></a>
#### 配置远程访问docker
1.找到以ExecStart开头的行，在该行的末尾添加内容 -H tcp://0.0.0.0:2375 添加完成后保存文件。<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710764136277-ab79da54-aa1e-4436-b309-2cd648535403.png#averageHue=%23262423&clientId=u7bc2e3ec-691a-4&from=paste&height=159&id=u5465f092&originHeight=318&originWidth=1281&originalType=binary&ratio=2&rotation=0&showTitle=false&size=27328&status=done&style=none&taskId=u793e2c39-fee2-4c00-b690-9bb003b367d&title=&width=640.5)<br />2.重启完成后可通过浏览器访问http://Docker主机IP:2375/version将输出Docker版本信息，若无法访问请检查防火墙设置。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710764408676-523dd601-8cf6-44d3-a3dd-c655f99baf45.png#averageHue=%23faf8f6&clientId=u091ead49-96cf-4&from=paste&height=112&id=udc4e9e8f&originHeight=224&originWidth=2980&originalType=binary&ratio=2&rotation=0&showTitle=false&size=51068&status=done&style=none&taskId=u0405e230-6f2d-49a7-a55a-547a2c391b7&title=&width=1490)
<a name="l3jn1"></a>
### 安装Java
<a name="e2dEE"></a>
#### 卸载原有的Java版本
可以先用命令查看一下Linux系统是否已有Java。
```sql
java -verison
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710760360278-882fbc56-9bf7-453b-a89a-24fb46189648.png#averageHue=%2333302d&clientId=u36d857b0-73ba-4&from=paste&height=56&id=ue61cd235&originHeight=111&originWidth=817&originalType=binary&ratio=2&rotation=0&showTitle=false&size=14951&status=done&style=none&taskId=u3d65a525-62b7-4f5f-9a20-6f20e9b6177&title=&width=408.5)

如果系统自带了 Open JDK，我们需要先把它卸载掉。
```sql
sudo rpm -qa | grep java | xargs rpm -e --nodeps
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710760484665-d78a14d3-c1ea-4d05-826c-0e4c8ff9c5a2.png#averageHue=%232e2b29&clientId=u36d857b0-73ba-4&from=paste&height=39&id=ue2b387bc&originHeight=78&originWidth=1171&originalType=binary&ratio=2&rotation=0&showTitle=false&size=14345&status=done&style=none&taskId=u99c3ada6-5299-4187-bcd9-f54b3f162e2&title=&width=585.5)<br />删除完成后，重新安装。<br />1.进入对应的目录
```
创建一个java目录
mkdir -p /home/local/java
进入该目录，将压缩包上传至该目录下
cd /home/local/java

或者在一个已有的目录下安装jdk（ 例如 在/usr/local 目录下安装jdk，切换到该目录，并将压缩包上传到该目录下）
cd /usr/local
```
2.通过Linux命令下载JDK安装包并解压
```
tar -zxvf jdk-8u401-linux-x64.tar.gz 

# 将jdk1.8.0_401改名为java
mv jdk1.8.0_401 java
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710760950308-32fed80c-8f50-4c1e-916d-40155e81ffdb.png#averageHue=%232b2726&clientId=u64d09d9d-e5cc-4&from=paste&height=91&id=u6607d4be&originHeight=181&originWidth=966&originalType=binary&ratio=2&rotation=0&showTitle=false&size=25320&status=done&style=none&taskId=u1dc30a63-e541-49f0-b762-d1f56232a61&title=&width=483)

<a name="qgizn"></a>
#### 添加环境变量
1.进入当前目录（/root ）下.bash_profile文件，按i进入编辑模式<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710761541637-43e86c11-d231-4898-96ea-d4c3a1aa5274.png#averageHue=%23faf8f5&clientId=u7bd8c034-a18f-4&from=paste&height=167&id=ua67f73a1&originHeight=334&originWidth=313&originalType=binary&ratio=2&rotation=0&showTitle=false&size=6025&status=done&style=none&taskId=ua750a202-f8df-4873-9edc-705e8709395&title=&width=156.5)

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1707467261848-9267f675-ff15-4628-9fd9-8f6b419e722e.png#averageHue=%23fefdfc&clientId=uac731324-78a0-4&from=paste&height=214&id=Uoflf&originHeight=374&originWidth=1100&originalType=binary&ratio=1.75&rotation=0&showTitle=false&size=22919&status=done&style=none&taskId=u6e0be93f-29bd-48b3-bed6-ad1b5f042c5&title=&width=628.5714285714286)

2.在文件下方添加以下代码
```
export JAVA_HOME="/home/local/java/java/"    //安装的JDK目录
export CLASSPATH="$JAVA_HOME/lib"
export PATH=$JAVA_HOME/bin:$PATH
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710761419113-2bbe002c-b293-4439-afa4-da61434d89e2.png#averageHue=%23fefdfd&clientId=u7bd8c034-a18f-4&from=paste&height=130&id=u0b299a54&originHeight=259&originWidth=941&originalType=binary&ratio=2&rotation=0&showTitle=false&size=22832&status=done&style=none&taskId=ue093b282-8170-4097-a6f9-01fb249c767&title=&width=470.5)

3.按下Esc退出编辑模式，Shift + q 进入键盘编辑,wq 保存并退出后并使用该命令重新加载下配置文件。
```
source 刚刚修改的文件的路径
source /root/.bash_profile
```

4.验证Java是否安装成功。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710761470153-036ceb42-d70c-4f1e-8ed3-a2c18d0bc368.png#averageHue=%232f2d2a&clientId=u7bd8c034-a18f-4&from=paste&height=69&id=ub4b2ab45&originHeight=138&originWidth=974&originalType=binary&ratio=2&rotation=0&showTitle=false&size=19895&status=done&style=none&taskId=u98d662e2-6fcc-4416-943e-683f9358ea1&title=&width=487)

5.建立一个Java超链接
> 这是因为，一些自己注册的Linux服务，默认情况下会从 /usr/bin/java路径使用 Java。如果系统的 Java环境是通过 yum安装的时候，这个超链接会自动创建；如果是自己下载包安装的话，这个超链接就需要自己手动创建了。

```
ln -s /home/local/java/java/bin/java /usr/bin/java
```
至此，Java环境全部配置完毕，可以正常使用了。

<a name="egx9F"></a>
### 安装maven

1.创建文件夹，用于存放maven。
```
mkdir /home/local/maven && cd /home/local/maven

解压
tar xzvf apache-maven-3.6.3-bin.tar.gz
```
2.配置PATH，同上面的Java环境配置。
```
export MAVEN_HOME="/home/local/maven/apache-maven-3.6.3"
export PATH=$MAVEN_HOME/bin:$PATH
```
3.检查是否配置完成。
```
mvn -v
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710763467291-6f79a913-6c6a-465e-980c-aac4c70d854b.png#averageHue=%232f2c2a&clientId=u7bc2e3ec-691a-4&from=paste&height=84&id=LlY78&originHeight=167&originWidth=1264&originalType=binary&ratio=2&rotation=0&showTitle=false&size=23993&status=done&style=none&taskId=ud1aad4a4-3642-4237-b47d-a14e33592e9&title=&width=632)

**maven的其他配置**<br />1.设置本地仓库路径
```
<localRepository>/home/local/maven/local_repo/</localRepository>
```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710763706329-4d39d622-50df-412b-abc3-aa426ac544a1.png#averageHue=%23faf7f4&clientId=u7bc2e3ec-691a-4&from=paste&height=125&id=VvE49&originHeight=249&originWidth=1226&originalType=binary&ratio=2&rotation=0&showTitle=false&size=30734&status=done&style=none&taskId=ube10f766-f09e-4816-aa97-7707cd06090&title=&width=613)

2.更换为阿里源
```
<mirror>
      <mirrorOf>central</mirrorOf>
      <id>aliyun-public</id>
      <name>aliyun maven public repository</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710763778152-df71e79a-e6a0-4528-8769-c9e559cd7927.png#averageHue=%23fdfcfb&clientId=u7bc2e3ec-691a-4&from=paste&height=333&id=Sefhn&originHeight=666&originWidth=1765&originalType=binary&ratio=2&rotation=0&showTitle=false&size=61665&status=done&style=none&taskId=u822149aa-1a46-4182-8939-aca7113f3f6&title=&width=882.5)

<a name="IRPPb"></a>
### 安装git
使用命令下载后，并进行测试
```
sudo yum install -y git

安装完成后,测试版本号
git --version
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710762951722-ec623897-8e9d-489d-be95-d37ddba013d0.png#averageHue=%23292726&clientId=u7bc2e3ec-691a-4&from=paste&height=389&id=u14ca0a84&originHeight=777&originWidth=1149&originalType=binary&ratio=2&rotation=0&showTitle=false&size=78185&status=done&style=none&taskId=u81032260-e706-452c-addd-bc18ba425b3&title=&width=574.5)


<a name="xvrFM"></a>
### 安装MYSQL

1.拉取官方镜像
```
# 拉取 mysql 5.7 如果不写后面的版本号则会自动拉取最新版
sudo docker pull mysql:5.7     
```
2.创建并启动容器<br />创建文件夹，用于存放MYSQL配置文件、日志以及数据。
```
sudo mkdir -p /home/docker/mysql/conf /home/docker/mysql/logs /home/docker/mysql/data
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710767770643-f15df976-8d31-47df-bc39-53c1faa0d7e5.png#averageHue=%23faf7f1&clientId=u2d5666b6-b332-4&from=paste&height=155&id=u7d7810fd&originHeight=309&originWidth=381&originalType=binary&ratio=2&rotation=0&showTitle=false&size=10272&status=done&style=none&taskId=u8b828b29-b329-4134-8ba3-ef35c1e0f4f&title=&width=190.5)

3.创建并编辑配置文件。
```
sudo vi /home/docker/mysql/conf/my.conf
```

my.conf配置文件内容如下，可根据实际情况做适当调整。
```
[mysqld]

character-set-server=utf8

#绑定IPv4和3306端口

bind-address = 0.0.0.0

port = 3306

sql_mode="STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION"

default_storage_engine=innodb

innodb_buffer_pool_size=1000M

innodb_log_file_size=50M

# 允许最大连接数

max_connections=1000

# 时区

default-time-zone = '+8:00'

[mysql]

default-character-set=utf8

[mysql.server]

default-character-set=utf8

[mysql_safe]

default-character-set=utf8

```

4.创建容器并挂载目录
```
sudo docker run -p 3306:3306 --name mysql --restart always --privileged=true  -v /home/docker/mysql/conf:/etc/mysql -v /home/docker/mysql/logs:/var/log/mysql -v /home/docker/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7

#参数说明
-p 3306:3306 映射端口
--name mysql 容器名称
--restart always 自动启动容器
--privileged=true 提升容器内权限
-v /home/docker/mysql/conf:/etc/mysql 映射配置文件目录
-v /home/docker/mysql/logs:/var/log/mysql 映射日志目录
-v /home/docker/mysql/data:/var/lib/mysql 映射数据目录
-e MYSQL_ROOT_PASSWORD=root root用户密码
-d mysql:5.7 后台运行-镜像名称

```

5.进入Docker终端通过mysql客户端访问Mysql
```
sudo docker exec -it  mysql  /bin/bash
sudo mysql -uroot -proot
```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710768250597-6ac4a0f7-d8a5-4a30-8a81-c1227313b030.png#averageHue=%23262524&clientId=u2d5666b6-b332-4&from=paste&height=184&id=u0b5a93e9&originHeight=367&originWidth=1301&originalType=binary&ratio=2&rotation=0&showTitle=false&size=28246&status=done&style=none&taskId=u7fedc7ca-7c02-47dd-bd7d-d03b45ff304&title=&width=650.5)

**远程连接**<br />远程连接MYSQL时连接信息如下：<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710768538699-cd4340e3-5a72-4993-9263-358195cbe8fb.png#averageHue=%23fafafa&clientId=u2d5666b6-b332-4&from=paste&height=513&id=u2e79f6cb&originHeight=1026&originWidth=910&originalType=binary&ratio=2&rotation=0&showTitle=false&size=27673&status=done&style=none&taskId=ud7d70bdf-0bd5-4bc4-ac0b-bf7392c62a0&title=&width=455)

如果容器运行正常，但是无法访问到MySQL，一般有以下几个可能的原因：<br />1.在云服务器安全组中添加对应开放的端口号。
```
#开放端口
sudo systemctl status firewalld
sudo firewall-cmd  --zone=public --add-port=3306/tcp -permanent
sudo firewall-cmd  --reload

#关闭并禁用防火墙
sudo systemctl stop firewalld
sudo systemctl disable firewalld
```

2.MYSQL未设置远程访问权限
```
grant all privileges on *.* to root@'%' identified by "root";
```
设置后，连接测试成功。<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710768523061-0ebb9a3b-1bed-4eee-8d57-1585d98e9d6b.png#averageHue=%23d5b372&clientId=u2d5666b6-b332-4&from=paste&height=83&id=ud0f5de10&originHeight=166&originWidth=321&originalType=binary&ratio=2&rotation=0&showTitle=false&size=7692&status=done&style=none&taskId=u5745f71c-8200-413e-8124-f1706f065ee&title=&width=160.5)

<a name="ao369"></a>
### 安装Redis
1.拉取镜像。
```
# 拉取 redis 6 如果不写后面的版本号则会自动拉取最新版
sudo docker pull redis:6   

```

2.创建文件夹，用于存放Redis配置文件及数据。
```
sudo mkdir -p /home/docker/redis/conf /home/docker/redis/data
```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710769099078-e7940107-17f3-41d8-a4dc-0d410ce4c08e.png#averageHue=%23f9f7f3&clientId=u2d5666b6-b332-4&from=paste&height=96&id=uc383334c&originHeight=191&originWidth=363&originalType=binary&ratio=2&rotation=0&showTitle=false&size=4424&status=done&style=none&taskId=u849349e4-0b70-4896-afe9-cfd922dbccc&title=&width=181.5)<br />从[官网下载](http://download.redis.io/redis-stable/redis.conf)配置文件并修改默认配置项，修改完成后将redis.conf文件复制到/home/docker/redis/conf目录。
```
bind 127.0.0.1 -::1  #注释掉这部分，允许所有IP访问Redis
protected-mode no #默认yes，开启保护模式，限制为本地访问，改为no，取消限制
databases 16 #数据库个数（可选）
appendonly yes #redis持久化（可选）
requirepass redis #开启访问认证并配置redis访问密码
```

3.创建容器并挂载目录
```
docker run -itd --name redis -p 6379:6379 redis:6 --requirepass 'Redis' --bind 0.0.0.0 --daemonize NO --protected-mode yes

#参数说明
-p 6379:6379 映射端口
--name redis 容器名称
--restart always 自动启动容器
--privileged=true 提升容器内权限
-v /home/docker/redis/conf/redis.conf:/etc/redis/redis.conf 映射配置文件
-v /home/docker/redis/data:/data 映射数据目录
-d redis:6 后台运行-镜像名称
redis-server /etc/redis/redis.conf  让redis按照这个redis.conf的配置启动
--appendonly yes redis启动后数据持久化
```

4.本地连接测试
```
sudo docker exec -it  redistest  /bin/bash
sudo redis-cli
127.0.0.1:6379> auth 密码
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710770517061-ea64e4ca-3ad7-4dc7-9fd1-b1c6b562da6b.png#averageHue=%231f1f1e&clientId=u2d5666b6-b332-4&from=paste&height=33&id=u45850a1d&originHeight=66&originWidth=414&originalType=binary&ratio=2&rotation=0&showTitle=false&size=3149&status=done&style=none&taskId=u3522a2a8-2911-4847-9dcd-3ddadacd0b0&title=&width=207)

**远程连接**<br />使用图形化工具连接redis，连接测试成功（如图所示）。<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710770458666-29b8d995-4dc5-4f1b-9db8-b51659cda314.png#averageHue=%23fefdfd&clientId=u2d5666b6-b332-4&from=paste&height=475&id=u17df836d&originHeight=949&originWidth=1521&originalType=binary&ratio=2&rotation=0&showTitle=false&size=96674&status=done&style=none&taskId=u741f9b0f-3a9d-48ca-aa7a-a105b06c324&title=&width=760.5)


<a name="jcl7h"></a>
### 安装RabbitMq

1.拉取官方镜像
```
# 拉取 rabbitmq 3 如果不写后面的版本号则会自动拉取最新版
sudo docker pull rabbitmq:3-management
```
2.创建容器并挂载目录
```
sudo mkdir -p /home/docker/rabbit/data
```
3.启动容器
```
sudo docker run  -p 15672:15672 -p 5672:5672 --name rabbitmq --restart=always --privileged=true -v /home/docker/rabbit/data:/var/lib/rabbitmq -e RABBITMQ_DEFAULT_USER=rabbit -e RABBITMQ_DEFAULT_PASS=Rabbit -d rabbitmq:3-management

#参数说明
-p 15672:15672 -p 5672:5672 映射端口
--name rabbitmq 容器名称
--restart always 自动启动容器
--privileged=true 提升容器内权限
-v /home/docker/rabbit/data:/var/lib/rabbitmq 映射数据目录
-e RABBITMQ_DEFAULT_USER=rabbit 默认用户名
-e RABBITMQ_DEFAULT_PASS=Rabbit 默认密码
-d rabbitmq:3-management 后台运行-镜像名称
```

4.访问rabbitmq<br />控制台访问地址：http://Docker主机IP:15672/，输入默认的用户名和密码即可登录。<br />![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710772137835-9845362a-e5fa-4c5a-ae31-dbce4662d1f4.png#averageHue=%23f6f6f6&clientId=u56647bc5-cbf5-4&from=paste&height=682&id=u29d4a6d0&originHeight=1363&originWidth=2238&originalType=binary&ratio=2&rotation=0&showTitle=false&size=147397&status=done&style=none&taskId=uf91f028a-46a3-41a1-b5cc-3dd28ef4791&title=&width=1119)


<a name="bRKNk"></a>
### 安装minio

1.拉取官方镜像
```
docker pull minio/minio
```

2.创建目录
```
mkdir -p /home/minio/config
mkdir -p /home/minio/data
```

3.启动容器
```
docker run -p 9000:9000 -p 9090:9090 \
  --name minio -d --restart=always \
  -e "MINIO_ACCESS_KEY=minioadmin" \
  -e "MINIO_SECRET_KEY=minioadmin" \
  -v /home/minio/data:/data \
  -v /home/minio/config:/root/.minio \
  minio/minio server /data --console-address ":9090" -address ":9000"
```

4.浏览器访问地址 http://localhost:9090 ，可访问 MinIO 的 Web 控制台，输入相应的用户名和密码就行。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/35027732/1710778049780-4ea8de77-72a7-49c0-b3c9-a4590b41b038.png#averageHue=%23fdfdfd&clientId=u8880f433-48ad-4&from=paste&height=553&id=u146f4fd3&originHeight=1105&originWidth=2715&originalType=binary&ratio=2&rotation=0&showTitle=false&size=327430&status=done&style=none&taskId=u91f2c3a2-e74d-45c6-981e-2e3b6c26335&title=&width=1357.5)

