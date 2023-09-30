<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="./css/admin.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <table cellspacing=0 cellpadding=0 width="100%" 
               background="./img/header_bg.jpg" border=0>
            <tr height=56>
                <td width=260>
				<!--<img height=56 src="img/header_left.jpg"  width=260>--></td>
                <td style="font-weight: bold; color: #fff; padding-top: 20px" 
                    align=middle> 
														<!-- onclick="if (confirm('确定要退出吗？')) return true; else return false;"  -->
                </td>
                <td style="font-weight: bold; color: #fff; padding-top: 20px" 
                    align="right">
                    当前用户：${u1.realName} &nbsp;&nbsp;
					
					
                    </td></tr></table>
        <table cellspacing=0 cellpadding=0 width="100%" border=0>
            <tr bgcolor=#1c5db6 height=4>
                <td></td>
            </tr>
        </table>
    </body>
</html>