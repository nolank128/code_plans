![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1675349673927-077a28d5-3b45-423d-bc19-b660cab245f9.png#averageHue=%23eeddd7&clientId=u27925506-2d6d-4&from=paste&height=338&id=u272b5fe5&originHeight=676&originWidth=1000&originalType=binary&ratio=1&rotation=0&showTitle=false&size=52238&status=done&style=none&taskId=ua011ab0c-7b0b-4362-8ad2-edf0fa27872&title=&width=500)
<a name="aGwdy"></a>
# HTML
<a name="DS4b1"></a>
## 简介
**     超文本标记语言**（英语：HyperText Markup Language，简称：HTML）是一种用于创建网页的标准标记语言。<br />HTML产生于1990年，1997年HTML4成为互联网标准，并广泛应用于互联网应用的开发。HTML5是Web中核心语言HTML的规范，用户使用任何手段进行网页浏览时看到的内容原本都是HTML格式的，在浏览器中通过一些技术处理将其转换成为了可识别的信息。<br />HTML预览<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1675349678241-5fb8a3a3-8a83-4d0c-8850-854a33a160c8.png#averageHue=%23fbfafa&clientId=u27925506-2d6d-4&from=paste&height=322&id=ue8ae1c6d&originHeight=644&originWidth=788&originalType=binary&ratio=1&rotation=0&showTitle=false&size=114215&status=done&style=none&taskId=u97763eb8-b99d-4ae7-93c8-022ac015b35&title=&width=394)

**浅析html,.css,js区别**

- html

用于勾勒出网页的结构和内容

- CSS

用于美化网页

- JavaScript

让网页呈现动态的数据和效果<br />jQuery<br />web项目基础<br />浏览器            HTTP协议                  服务器<br />网页存到服务器上，运在浏览器上
<a name="EnMph"></a>
## 基础
<a name="uOOJy"></a>
### 声明
为了让浏览器识别html版本，正确显示网页。减少中文乱码等问题。<br />声明不区分大小写。
```
HTML5
<!DOCTYPE html>
html 4.01
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
html 1.0
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
```

> 对于中文网页需要使用 <meta charset="utf-8"> 声明编码，否则会出现乱码。有些浏览器(如 360 浏览器)会设置 GBK 为默认编码，但是，只要在HTML文件里写了<!doctype hmtl>和 <meta charset="utf-8" />，浏览器将会按照utf-8编码解析网页。
> 不过，一定要确保文档编码和meta设置的编码，一定要相同。比如，在记事本保存时，选择编码为utf-8，保存。（代码无需变动）。另一种，改变方式可以变动meta中所设置的编码和文档编码保持一致。
> utf-8和utf8的区别
> "UTF-8" 是标准写法，php 在 Windows 下边英文不区分大小写，所以也可以写成 "utf-8"。"UTF-8" 也可以把中间的"-"省略，写成 "UTF8"。
> 在数据库中只能使用"utf8"(MySQL) 在MySQL的命令模式中只能使用"utf8"，不能使用"utf-8"，也就是说在PHP程序中只能使用 "set names utf8(不加小横杠)"，如果你加了"-"此行命令将不会生效，但是在 PHP 中 header 时却要加上"-"
> <?php header('Content-Type: text/html; charset=UTF-8'); ?>
> 即
> 除了在命令 "mysql_query(set names utf8)" 外一律用大写"UTF-8"。

<a name="z3OMb"></a>
### HTML标签
**HTML标签对于大小写不敏感：<P>等同于<p>。**

- HTML 标签是由尖括号包围的关键词，比如 
- 标签分为开放标签和闭合标签。
- HTML 标签通常是成对出现的，但也有例外,<br>和</br>这两个都是单独存在的，本身也都是开放标签和闭合标签,不包含内容，所以只是个标签。
```
<标签>内容<标签>
```
单标签 等于无内容的双标签
```
<student/>
```
双标签
```
<student "id=""uid"></student>
```
浏览器并不会直接显示HTML标签，但是通过标签来决定如何展示HTML页面的内容.

<a name="mg0xt"></a>
#### 标题
标题（Heading）是通过 <h1> - <h6> 标签进行定义的。
```
<h1>hello</h1>
<h2>hello</h2>
```
> 尽量不要使用标题这个标签来生成粗体或者大号字体，这种可能会打乱原有的文档结构。

<a name="L7O7Y"></a>
#### 段落
**<p>标签（块级元素）**<br />HTML可以将文档分成若干段落。
> 折行，不产生新段落的情况下进行换行，可以借助<br>标签

```
<p>hello</p>
<p>你好<br>bob</p>
```
<a name="pj3mo"></a>
#### 注释
可以将注释插入 HTML 代码中，这样可以提高其可读性，使代码更易被人理解。浏览器会忽略注释，也不会显示它们。
```
<!--这是注释-->
```
<a name="gjQ1O"></a>
#### 水平线
<hr>标签在HTML页面中创建水平线，可以用于分隔内容。
```
<h1>hello</h1>
<hr>
<h1>world</h1>
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685372721526-0e4c2d3a-e8f2-4adc-ad6a-6d81b8dbdd07.png#averageHue=%23fdf9f9&clientId=u6c88e64a-5ddb-4&from=paste&height=381&id=ud37616db&originHeight=762&originWidth=1345&originalType=binary&ratio=2&rotation=0&showTitle=false&size=72679&status=done&style=none&taskId=u85289d44-683f-4b26-bf2f-fa368dd572e&title=&width=672.5)

<a name="WYxFr"></a>
#### 文本格式化标签
        一些 HTML 标签除了具有一定的语义（含义）外，还有默认的样式，例如<b>（加粗），通过这些标签我们无需借助 CSS 就可以为网页中的内容定义样式。在这些具有语义和默认样式的标签中，有许多是针对文本的，通过这些标签我们可以格式化文本（为文本添加样式），例如使文本加粗、倾斜或者添加下划线等。<br />文本格式化标签

| 标签 | 描述 |
| --- | --- |
| <b>...</b> | 加粗标签中的字体 |
| <em>...</em> | 强调标签中的内容，并使标签中的字体倾斜 |
| <i>...</i> | 定义标签中的字体为斜体 |
| <small>...</small> | 定义标签中的字体为小号字体 |
| <strong>...</strong> | 强调标签中的内容，并将字体加粗 |
| <sub>...</sub> | 定义下标文本 |
| <sup>...</sup> | 定义上标文本 |
| <ins>...</ins> | 定义文档的其余部分之外的插入文本 |
| <del>...</del> | 在文本内容上添加删除线 |
| <code>...</code> | 定义一段代码 |
| <kbd>...</kbd> | 用来表示文本是通过键盘输入的 |
| <samp>...</samp> | 定义程序的样本 |
| <var>...</var> | 定义变量 |
| **<pre>...</pre>** | **定义预格式化的文本，被该标签包裹的文本会保留所有的空格和换行符，字体也会呈现为等宽字体** |
| <abbr>...</abbr> | 用来表示标签中的内容为缩写形式 |
| <address>...</address> | 用来定义文档作者的联系信息，被该标签包裹的文本通常会以斜体呈现，并在文本前面换行 |
| <bdo>...</bdo> | 定义标签中的文字方向 |
| <blockquote>...</blockquote> | 定义一段引用的文本，例如名人名言，文本会换行输出，并在左右两边进行缩进 |
| <q>...</q> | 定义一段短的引用，浏览器会将引用的内容使用双引号包裹起来 |
| <cite>...</cite> | 表示对某个文献的引用，例如书籍或杂志的名称，文本会以斜体显示 |
| <dfn>...</dfn> | 用来定义一个术语，标签中的文本会以斜体呈现 |

> **关于 <b> 和 <strong>**
> 在显示上，这两个标签都可是加粗文本，呢么为什么会有两个功能"相同"的标签呢？而且好像 strong 并非个例。
> -  首先，这两个并非完全相同。比如，如果使用网页阅读器阅读网页（盲人使用），strong 会重读，b 则不会。
> -  其次，从起源上来说，strong 是为了在未来建设语义网而诞生的。应该知道的是，html 是负责显示的标记，不能表示语义。也就是说，浏览器知道这个标签如何显示，而不知道标签所标记的内容应该是什么含义。而 strong 在语义上走出了第一步。

示例：
```
<b>这个文本是加粗的</b>
<br />
<strong>这个文本是加粗的</strong>
	
<br />
这个文本包含
<sub>下标</sub>
<br />
这个文本包含
<sup>上标</sup>
	
<br>
<del>这是删除线</del>
<br>
	<p>前面是宋体，<dfn>后面是斜体</dfn></p>
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685373655480-81bdce9a-4898-4442-a0e7-f95cd218fc91.png#averageHue=%23faf9f9&clientId=u6c88e64a-5ddb-4&from=paste&height=532&id=ud8bac0a7&originHeight=1063&originWidth=1564&originalType=binary&ratio=2&rotation=0&showTitle=false&size=160102&status=done&style=none&taskId=ub9674713-b7a5-469f-9bdc-cfdbde75550&title=&width=782)
<a name="dI3Tn"></a>
#### 超链接
        HTML 使用超级链接与网络上的另一个文档相连。几乎可以在所有的网页中找到链接。点击链接可以从一张页面跳转到另一张页面。<br />**<a>标签来设置超文本链接，**在标签<a> 中使用了href属性来描述链接的地址。
```
<a href="链接地址">链接文本</a>
<a href="#">回到顶部</a>
```
链接文本不一定是要文本，可以是图片，HTML其他元素都行。

- **target属性**

    使用 target 属性，你可以定义被链接的文档在何处显示。

1. target="_blank":在新窗口中浏览新的页面。
2. target="_self":在同一个窗口打开新的页面。
3. target="_parent":在父窗口中打开新的页面。（页面中使用框架才有用）
4. target="_top" :以整个浏览器作为窗口显示新页面。（突破了页面框架的限制）
```
<a href="https://www.baidu.com/" target="_blank"
rel="noopener noreferrer">访问百度!</a>

<p>如果你将 target 属性设置为"_blank";, 链接将在新窗口打开，同时
加上rel="noopener noreferrer"意思是不会打开其他的网站，
因为恶意病毒可能会修改你的浏览器空白页地址。。</p>

```

- **id属性**

id 属性可用于创建一个 HTML 文档书签.(注意，id不能重复)<br />书签不会以任何特殊方式显示，即在 HTML 页面中是不显示的。

在HTML文档中插入ID:
```
<a id="tips">有用的提示部分</a>
```
在HTML文档中创建一个链接到"有用的提示部分(id="tips"）"：
```
<a href="#tips">访问有用的提示部分</a>
```
或者，从另一个页面创建一个链接到"有用的提示部分(id="tips"）"：
```
<a href="https://www.baidu.com/html/html-links.html#tips">访问有用的提示部分</a>
```

> 注意：
> 请始终将正斜杠添加到子文件夹。一般情况，依赖服务器配置。
> 1. 主要问了区分访问的是文件还是文件夹，比如访问路径为[http://www.a.com/b](http://www.a.com/b)浏览器不知道访问的是文件还是文件夹，会先访问一遍确认是那种类型，如果是文件夹则会加上/,重新访问地址为[http://www.a.com/b/](http://www.a.com/b/)的路径。
> 2. 如果带后缀名[http://www.a.com/b.html](http://www.a.com/b.html)可以明确知道访问的是文件，不需要再次请求。


<a name="hPTZ0"></a>
#### 图像
<a name="liP6R"></a>
##### <img>标签
图像由**<img> 标签**定义。<br /><img> 是空标签，只包含属性，并且没有闭合标签。<br />**源属性（src）**<br />源属性的值就是图像的URL地址<br />**Alt属性 **<br />图像定义一串预备的可替换的文本。<br />在浏览器无法载入图像时，替换文本属性告诉读者她们失去的信息。此时，浏览器将显示这个替代性的文本而不是图像。为页面上的图像都加上替换文本属性是个好习惯，这样有助于更好的显示信息，。<br />**高度和宽度属性**<br />height（高度）与width（宽度）属性用于设置图像的高度与宽度。
```
<img src="http://www.a,com/images/a.jpg" alt="error"
width="400px" height="400">
```
**绝对路径与相对路径**
> 1绝对路径
> 从盘符开始写出图片的绝对路径
> C:/images/1.jpg或者/home/soft01/images/1.jpg
> 缺点
> 1.路径过长
> 2.不方便迁移，路径易报错。
> 
> 2相对路径
> 只需要写出图片和网页的相对位置。方便迁移，简单。
> 1.平级 （同目录下）<img src="i.jpg">
> 2.下级          <img src="image/2.jpg">
> 3.上级         <img src="../3.jpg">
> （照片最好全放到一个文件下里，使用上级最方便）
> （然后统一放到src下）
> <img src="../images/4.jpg">

<a name="EiGaL"></a>
##### <map>标签
<map> 标签用于客户端图像映射。<br />**图像映射指带有可点击区域的一幅图像。**<br /><img>中的 usemap 属性可引用 <map> 中的 id 或 name 属性（取决于浏览器），所以我们应同时向 <map> 添加 id 和 name 属性。<br />**area 元素永远嵌套在 map 元素内部**。<br />area 元素可定义图像映射中的区域。<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685419572450-f70b154b-393b-4ddd-839a-5da289a90986.png#averageHue=%23f4f4f4&clientId=u6cbb177c-9957-4&from=paste&height=193&id=u16c3cf57&originHeight=385&originWidth=1169&originalType=binary&ratio=2&rotation=0&showTitle=false&size=84796&status=done&style=none&taskId=u60586bad-44c7-4252-a6e7-2044e26308c&title=&width=584.5)
```
<img src="planets.gif" width="145" height="126" alt="Planets"
usemap="#planetmap">

<map name="planetmap">
  <area shape="rect" coords="0,0,82,126" href="sun.htm" alt="Sun">
  <area shape="circle" coords="90,58,3" href="mercur.htm" alt="Mercury">
  <area shape="circle" coords="124,58,8" href="venus.htm" alt="Venus">
</map>
//shape指的是点击区域的形状，
coords指的应该是链接区域在图片中的坐标（像素为单位
```


<a name="DpvXG"></a>
#### 表格
表格由 **<table>** 标签来定义。

- table 表格声明范围
- tr 行
- td 行里的单元格
- tr 声明表头

表格中的标签

| 标签 | 描述 |
| --- | --- |
| <table> | 定义表格 |
| <th> | 定义表格的表头 |
| <tr> | 定义表格的行 |
| <td> | 定义表格单元 |
| <caption> | 定义表格标题 |
| <colgroup> | 定义表格列的组 |
| <col> | 定义用于表格列的属性 |
| <thead> | 定义表格的页眉 |
| <tbody> | 定义表格的主体 |
| <tfoot> | 定义表格的页脚 |

实例：
```
<table border="1"cellspacing="0" width="30%" >
<caption>单元格间距</caption>
    <tr>
        <td>alice</td>
        <td>bob</td>
    </tr>
    <tr>
         <td>cc</td>
         <td>dd</td>
     </tr>
</table>

<table border="1" cellpadding="0" width="30%" >
<caption>单元格边距</caption>
    <tr>
        <td>Alice</td>
        <td>Bob</td>
    </tr>
  <tr>
         <td>cc</td>
         <td>dd</td>
     </tr>
</table>


<table border="1">
    <tr>
        <td rowspan="2" >alice</td>
        <td>bob</td>
    </tr>
    <tr>
        <td>cc</td>
    </tr>
</table>

<table border="1">
    <tr>
        <td colspan="2">bob</td>
    </tr>
    <tr>
        <td >alice</td>
        <td>cc</td>
    </tr>
</table>

<table border="1">
  <caption>带有标题的表格</caption>
  <tr>
    <th>A</th>
    <th>B</th>
  </tr>
</table>

<table border="1">
<caption>多元化的表格</caption>
<tr>
  <td>
   <p>这是一个段落</p>
   <p>这是另一个段落</p>
  </td>
  <td>这个单元格包含一个表格:
   <table border="1">
<caption>表格中的表格</caption>
   <tr>
     <td>A</td>
     <td>B</td>
   </tr>
   <tr>
     <td>C</td>
     <td>D</td>
   </tr>
   </table>
  </td>
</tr>
<tr>
  <td>这个单元格包含一个列表
   <ul>
    <li>apples</li>
    <li>bananas</li>
    <li>pineapples</li>
   </ul>
  </td>
  <td>HELLO</td>
</tr>
</table>
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685436063080-28462a48-76f2-4cc1-99d3-1afe4038153c.png#averageHue=%23fafaf9&clientId=u6cbb177c-9957-4&from=paste&height=803&id=u3ad015fb&originHeight=1605&originWidth=2146&originalType=binary&ratio=2&rotation=0&showTitle=false&size=246966&status=done&style=none&taskId=u9717d467-1dd2-4154-8f2e-5246c198d80&title=&width=1073)

<a name="fXQnT"></a>
#### 框架
通过使用框架，你可以在同一个浏览器窗口中显示不止一个页面。<br />**iframe标签**

- height 和 width 属性用来定义iframe标签的高度与宽度。
- frameborder 属性用于定义iframe表示是否显示边框，设置属性值为"0"可移除
```
<iframe src="demo_iframe.htm" name="iframe_a"></iframe>
<p><a href="https://www.runoob.com" target="iframe_a">
	RUNOOB.COM</a></p>

<p>因为 a 标签的 target 属性是名为
	iframe_a 的 iframe 框架，
	所以在点击链接时页面会显示在 iframe框架中。</p>

```


![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685456103978-e965afd6-3225-48db-a5f8-8e64e3e68bac.png#averageHue=%23f9f6f5&clientId=u6cbb177c-9957-4&from=paste&height=349&id=uff2ad0fa&originHeight=698&originWidth=1731&originalType=binary&ratio=2&rotation=0&showTitle=false&size=123069&status=done&style=none&taskId=ua94dce64-2e46-4684-8c58-324431d206e&title=&width=865.5)

> 网页对于嵌套的设置：
> X-Frame-Options
> 这个有三个可配置值
> - DENY：表示该网站页面不允许被嵌套，即便是在自己的域名的页面中也不能进行嵌套。
> - SAMEORIGIN：表示该页面可以在相同域名页面中被嵌套展示。 
> - ALLOW-FROM uri：表示该页面可以在指定来源页面中进行嵌套展示。


<br />
<a name="pbqH1"></a>
#### 脚本标签
<script>标签

- <script> 标签用于定义客户端脚本。
- <script> 元素既可包含脚本语句，也可通过 src 属性指向外部脚本文件。

<noscript>标签

- <noscript> 标签提供无法使用脚本时的替代内容，比方在浏览器禁用脚本时，或浏览器不支持客户端脚本时。
- <noscript>元素可包含普通 HTML 页面的 body 元素中能够找到的所有元素。
- 只有在浏览器不支持脚本或者禁用脚本时，才会显示 <noscript> 元素中的内容：
```
<script>
document.write("Hello World!")
</script>
<noscript>抱歉，你的浏览器不支持 JavaScript!</noscript>
```
<br />
<a name="Vz0z8"></a>
### HTML元素
<a name="g3tMk"></a>
#### 元素
元素语法：

- 元素以开始标签起始，以结束标签终止。
- 元素内容是开始标签与结束标签之间的内容。
- 空元素在开始标签中进行关闭（以开始标签的结束而结束）
- 不少元素具有空内容。
- 大多数元素可以嵌套其他元素。
```
<p>这是一个段落。</p>，这一整个就是元素。
```
**标签加属性加内容为元素**<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685348887005-97567a4a-ea58-433e-b816-92a8e2a3cfa4.png#averageHue=%232b2726&clientId=u1f5e19a9-9317-4&from=paste&id=u73be91a6&originHeight=156&originWidth=1287&originalType=url&ratio=2&rotation=0&showTitle=false&size=22761&status=done&style=none&taskId=u44c33fcd-e33c-423a-9ff6-e4066df9f52&title=)
```
<html>

<body>
<p>hello</p>
</body>

</html>
```
<a name="PFtZr"></a>
#### 属性

- 元素中可以设置属性
- 属性一般添加到开始标签中
- 属性总是以名称或者值对的形式出现，例如：name="value"或者name='value'
- 属性和属性值对大小写都行。
- 属性值始终被包括在引号内，双引号或单引号皆可。
> _在某些个别的情况下，比如属性值本身就含有双引号，那么就必须使用单引号，例如：_
> _name='hello "bob" '_

```
 <div style="color: antiquewhite">hello</div>
```

<a name="YMPlv"></a>
#### 头部元素
<head> 元素包含了所有的头部标签元素。在 <head>元素中声明元信息，指示浏览器在何处可以找到样式表，包含的脚本等等。<br />可以添加在头部区域的元素标签为: **<title>, <style>, <meta>, <link>, <script>, <noscript> 和 <base>**。

**<title>元素**<br /><title>标签定义了不同文档的标题。<br />在HTML/XHTML文档是必需的。<br /><title> 元素:

1. 定义了浏览器工具栏的标题
2. 当网页添加到收藏夹时，显示在收藏夹中的标题
3. 显示在搜索引擎结果页面的标题
```
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8"> 
<title>文档标题</title>
</head>
 
<body>
文档内容......
</body>
 
</html>
```

**<base>元素**<br /><base> 标签描述了基本的链接地址/链接目标，该标签作为HTML文档中所有的链接标签的默认链接。
```
<head>
<base href="http://www.baidu.com" target="_blank">
</head>
```
**<link>元素**<br /><link> 标签定义了文档与外部资源之间的关系。<br /><link> 标签通常用于链接到样式表。
```
<head>
<link rel="stylesheet" type="text/css" href="test.css">
</head>
```
**<style> 元素**<br /><style> 标签定义了HTML文档的样式文件引用地址.<br />在<style> 元素中你也可以直接添加样式来渲染 HTML 文档.
```
<head>
<style type="text/css">
body{
    background-color:red;
}
</style>
</head>
```


**<meta>元素**<br />meta标签描述了一些基本的元数据。<br /><meta> 标签提供了元数据.元数据也不显示在页面上，但会被浏览器解析。<br />META 元素通常用于指定网页的描述，关键词，文件的最后修改时间，作者，和其他元数据。<br />常用属性：content、http-equiv、charset

```
//为搜索引擎定义关键词:
<meta name="keywords" content="HTML, CSS, XML, XHTML, JavaScript">
//为网页定义描述内容:
<meta name="description" content="免费 Web & 编程 教程">
定义网页作者:
<meta name="author" content="ktrol">
每30秒钟刷新当前页面
<meta http-equiv="refresh" content="30">
```
<a name="nLAlo"></a>
#### 列表元素
**无序列表使用 <ul> 标签，有序列表使用<ol> 标签。**
```
<ul>
<li>A</li>
<li>B</li>
</ul>

<ol>
<li>C</li>
<li>D</li>
</ol>
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685442207632-26ee28a4-2ee2-4de8-8fa0-e80a265f0f29.png#averageHue=%23fafafa&clientId=u6cbb177c-9957-4&from=paste&height=276&id=u8e4d8fd4&originHeight=551&originWidth=1186&originalType=binary&ratio=2&rotation=0&showTitle=false&size=37916&status=done&style=none&taskId=u4b417098-1750-4943-813a-ed5ebd2636d&title=&width=593)<br />**自定义列表以 <dl> 标签开始**。每个自定义列表项以 <dt> 开始。每个自定义列表项的定义以 <dd> 开始。<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685442400986-77e62f15-3807-43b9-b743-ef4ed8356cb4.png#averageHue=%23fbfaf9&clientId=u6cbb177c-9957-4&from=paste&height=175&id=uac518840&originHeight=350&originWidth=1393&originalType=binary&ratio=2&rotation=0&showTitle=false&size=39883&status=done&style=none&taskId=u32d34a19-e2bf-416b-a83a-cfc7e632034&title=&width=696.5)

<a name="w4HkP"></a>
#### 区块元素
块级元素显示时通常会以新行来开始（和结束）， <h1>, <p>, <ul>, <table>。<br />内联元素显示时通常不会以新行开始，<b>, <td>, <a>, <img>。<br />**独立成行的元素为块元素，行内元素不能独立成行。**<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685443003651-db647829-00d2-4d65-bd9b-4bccb1d58917.png#averageHue=%23f4f3f1&clientId=u6cbb177c-9957-4&from=paste&height=132&id=u5c6c4ab0&originHeight=264&originWidth=1394&originalType=binary&ratio=2&rotation=0&showTitle=false&size=80318&status=done&style=none&taskId=u6f94aeb2-5266-4423-8577-c379401e6c7&title=&width=697)<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1675349724057-a2128579-286e-484b-b641-ce980017a4a9.png#averageHue=%2357555c&clientId=u27925506-2d6d-4&from=paste&height=115&id=u0833963d&originHeight=229&originWidth=1062&originalType=binary&ratio=1&rotation=0&showTitle=false&size=84105&status=done&style=none&taskId=ua2f2b79e-5eca-4ac2-9f6c-97919ff5caa&title=&width=531)
```
<p>区块元素</p>
<div style="color:red">
  <h3>这是一个在 div 元素中的标题。</h3>
  <p>这是一个在 div 元素中的段落。</p>
</div>
<br>
<p>内联元素</p>
<p>北京<span style="color: blue">北京大学</span><p>
<p>北京<b>北京大学</b></p>
<p>北京<u>北京大学</u></p>
```

![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685443390100-b5fb772a-3b84-42dc-ba18-587fabc9ec85.png#averageHue=%23fcf9f8&clientId=u6cbb177c-9957-4&from=paste&height=320&id=u6a68c6c1&originHeight=639&originWidth=1524&originalType=binary&ratio=2&rotation=0&showTitle=false&size=93829&status=done&style=none&taskId=u6bdc148b-a7f1-479c-9841-5aa84480960&title=&width=762)

<a name="RDQfg"></a>
#### 表单元素
HTML 表单用于收集用户的输入信息。<br />**表单标签**

| 标签 | 描述 |
| --- | --- |
| [<form>](https://www.runoob.com/tags/tag-form.html) | 定义供用户输入的表单 |
| [<input>](https://www.runoob.com/tags/tag-input.html) | 定义输入域 |
| [<textarea>](https://www.runoob.com/tags/tag-textarea.html) | 定义文本域 (一个多行的输入控件) |
| [<label>](https://www.runoob.com/tags/tag-label.html) | 定义了 <input> 元素的标签，一般为输入标题 |
| [<fieldset>](https://www.runoob.com/tags/tag-fieldset.html) | 定义了一组相关的表单元素，并使用外框包含起来 |
| [<legend>](https://www.runoob.com/tags/tag-legend.html) | 定义了 <fieldset> 元素的标题 |
| [<select>](https://www.runoob.com/tags/tag-select.html) | 定义了下拉选项列表 |
| [<optgroup>](https://www.runoob.com/tags/tag-optgroup.html) | 定义选项组 |
| [<option>](https://www.runoob.com/tags/tag-option.html) | 定义下拉列表中的选项 |
| [<button>](https://www.runoob.com/tags/tag-button.html) | 定义一个点击按钮 |
| [<datalist>](https://www.runoob.com/tags/tag-datalist.html) | 指定一个预先定义的输入控件选项列表 |
| [<keygen>](https://www.runoob.com/tags/tag-keygen.html) | 定义了表单的密钥对生成器字段 |
| [<output>](https://www.runoob.com/tags/tag-output.html) | 定义一个计算结果 |

表单元素（声明表单范围，声明数据信息提交到服务器的范围)<br />表单控件（用来给用户输入数据）

1. **input元素，输入类型由type属性决定。**
- 文本框<input type="text">  

      value ：默认输入的值，maxlength：最大长度 ，readonly：设置只读。

-   密码框<input type="password">
- 文件框<input type="file"/>
- 隐藏框<input type="hidden" value="kk"/>
- 单选框<input type="radio">

       name ：组名，同组radio互斥，checked:设置默认选中

- 复选框<input type="checkbox">

      checked 设置默认选中

- 提交按钮<input type="submit">

     method属性，用来定义表单数据的提交方式
> - post：指的是 HTTP POST 方法，表单数据会包含在表单体内然后发送给服务器，用于提交敏感数据，如用户名与密码等。
> - get：默认值，指的是 HTTP GET 方法，表单数据会附加在 action 属性的 URL 中，并以 ?作为分隔符，一般用于不敏感信息，如分页等。例如：https://www.baidu.com/?page=1，这里的 page=1 就是 get 方法提交的数据。

- 重置按钮 <input type="reset">
- 普通按钮 <input type="button">

2.  **其他元素（3个）**

**label**:用来管理表单中的文本,可以将文本和控件联系在一起。<br />**select**:下拉选,selected 默认选中<br />**textarea** 文本域,cols 指定最大列数,rows 指定指定最大行数,readonly 

```
<form action="https://www.baidu.com">
  <p>
    账号:<input type="text"
  value="baidu"
  maxlength="12">
 </p>
  <p>
    密码:<input type="password"3. maxlength="16">
  </p>
    <p>
        头像：<input type="file"/>
    </p>
    <p>
        <input type="hidden" value="kk"/>
    </p>
    <p>
        性别：
        <input type="radio" name="sex" checked/>男
        <input type="radio" name="sex"/>女
    </p>
    <p>
        兴趣:
        <input type="checkbox" checked/>music
        <input type="checkbox"/>reading
        <input type="checkbox"/>football
    </p>
    <p>
    <input type="submit" value="注册"/>
    <input type="reset" value="重置"/>
    <input type="button" value="试试"/>
    <p/>

    <p>
        <input type="checkbox" id="a"/>
        <label for="a">I agree</label>
    </p>
    <p>
        城市：
        <select>
            <option>请选择</option>
            <option> beijng</option>
            <option>shanghai</option>
            <option>guangzhou</option>
            <option>changsha</option>
        </select>
    </p>
    <p>
        简介：
        <textarea cols="5" rows="5">想啥呢</textarea>
    </p>
</form>
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35027732/1685448090118-1837e307-cc7b-4bce-b863-4ab7e1679089.png#averageHue=%23f9f7f7&clientId=u6cbb177c-9957-4&from=paste&height=432&id=u67d6f723&originHeight=864&originWidth=612&originalType=binary&ratio=2&rotation=0&showTitle=false&size=46338&status=done&style=none&taskId=u13386fb6-fa35-4517-84e2-141063ea8c8&title=&width=306)
<a name="HE7o6"></a>
### 颜色
 颜色由一个十六进制符号来定义，这个符号由红色、绿色和蓝色的值组成（RGB）。<br />RGBA 的意思是（Red-Green-Blue-Alpha）它是在 RGB 上扩展包括了 **“alpha” **通道，运行对颜色值设置透明度，该透明度的设置范围为0-1。<br />可以去该网站进行颜色对比。<br />[HTML颜色代码表🎨](https://www.rapidtables.org/zh-CN/web/color/html-color-codes.html)

<a name="DKzty"></a>
### 字符实体
HTML 中的预留字符必须被替换为字符实体。<br />一些在键盘上找不到的字符也可以使用字符实体来替换。
> 不间断空格
> 浏览器总是会截短 HTML 页面中的空格。如果您在文本中写 10 个空格，在显示该页面之前，浏览器会删除它们中的 9 个。如需在页面中增加空格的数量，您需要使用 &nbsp; 字符实体。

**实体名称对大小写敏感！**

| 显示结果 | 描述 | 实体名称 |
| --- | --- | --- |
|   | 空格 | &nbsp; |
| < | 小于号 | &lt; |
| > | 大于号 | &gt; |
| & | 和号 | &amp; |
| " | 引号 | &quot; |
| ' | 撇号  | &apos; (IE不支持) |
| ￠ | 分 | &cent; |
| £ | 镑 | &pound; |
| ¥ | 人民币/日元 | &yen; |
| € | 欧元 | &euro; |
| § | 小节 | &sect; |
| © | 版权 | &copy; |
| ® | 注册商标 | &reg; |
| ™ | 商标 | &trade; |
| × | 乘号 | &times; |
| ÷ | 除号 | &divide; |








