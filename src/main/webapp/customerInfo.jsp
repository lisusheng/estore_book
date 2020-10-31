<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-个人信息页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="#"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current" style="font-size: 15px;">用户<strong style="color: green;font-size: 20px;">${customer.name }</strong>的个人信息</li>
                </ul>
            </div>
        </div>
        <div class="content2">
			<form action="RegisterServlet" method="post">
            <ul class="reg_box">
                <li>
                    <span><b>*</b>用户名：</span>
                    <input type="text" name="name" value="${customer.name }" readonly="readonly"/>
                </li>
               <li>
                    <span><b>*</b>密码：</span>
                    <input type="password" name="password" value="${customer.password }" readonly="readonly"/>
                </li>
                <li>
                    <span><b>*</b>邮编：</span>
                    <input type="text" name="zipCode" value="${customer.zipCode }" readonly="readonly"/>
                </li>
                <li>
                    <span><b>*</b>地址：</span>
                    <input type="text" name="address" value="${customer.address }" readonly="readonly"/>
                </li>
                <li>
                    <span><b>*</b>电话：</span>
                    <input type="text" name="telephone" value="${customer.telephone }" readonly="readonly"/>
                </li>
                <li>
                    <span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email" value="${customer.email }" readonly="readonly"/>
                </li>
            </ul>
           </form>
        </div>
   	</div>
</body>
</html>
