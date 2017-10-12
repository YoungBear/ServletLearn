# Servlet 菜鸟学习笔记

## HelloWorld
http://47.95.249.79:8080/HelloWorld

linux部署配置文件：
`/usr/lib/apache-tomcat-9.0.0.M26/webapps/ROOT/WEB-INF/web.xml`
```
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
  metadata-complete="true">

  <servlet>
      <servlet-name>HelloWorld</servlet-name>
      <servlet-class>com.ysx.test.HelloWorld</servlet-class>
  </servlet>

  <servlet-mapping>
      <servlet-name>HelloWorld</servlet-name>
      <url-pattern>/HelloWorld</url-pattern>
  </servlet-mapping>

  <display-name>Welcome to Tomcat</display-name>
  <description>
     Welcome to Tomcat
  </description>

</web-app>
```

HelloWorld.class位置：

`/usr/lib/apache-tomcat-9.0.0.M26/webapps/ROOT/WEB-INF/classes/com/ysx/test/HelloWorld.class`

HelloWorld.java源代码：

```
package com.ysx.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello World";
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        // 什么也不做
    }

}

```

## HelloForm

http://47.95.249.79:8080/ServletLearn/HelloForm?name=菜鸟教程&url=www.runoob.com

http://47.95.249.79:8080/hello.html

post请求：
http://47.95.249.79:8080/hello_post.html

```
  <servlet>
    <servlet-name>HelloForm</servlet-name>
    <servlet-class>com.ysx.test.HelloForm</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>HelloForm</servlet-name>
    <url-pattern>/ServletLearn/HelloForm</url-pattern>
  </servlet-mapping>
```

## CheckBox 复选框数据传递到 Servlet 程序
http://47.95.249.79:8080/checkbox.html

```
  <servlet>
    <servlet-name>CheckBox</servlet-name>
    <servlet-class>com.ysx.test.CheckBox</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>CheckBox</servlet-name>
    <url-pattern>/ServletLearn/CheckBox</url-pattern>
  </servlet-mapping>
```

## ReadParams 读取所有的表单参数
`HttpServletRequest.getParameterNames()`

http://47.95.249.79:8080/readparams.html

```
  <servlet>
    <servlet-name>ReadParams</servlet-name>
    <servlet-class>com.ysx.test.ReadParams</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ReadParams</servlet-name>
    <url-pattern>/ServletLearn/ReadParams</url-pattern>
  </servlet-mapping>
```

## DisplayHeader HTTP Header 请求实例
对应API:`HttpServletRequest.getHeaderNames()`，返回结果是Enumeration<String>。

http://47.95.249.79:8080/ServletLearn/DisplayHeader

```
  <servlet>
    <servlet-name>DisplayHeader</servlet-name>
    <servlet-class>com.ysx.test.DisplayHeader</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DisplayHeader</servlet-name>
    <url-pattern>/ServletLearn/DisplayHeader</url-pattern>
  </servlet-mapping>
```

## Refresh HTTP Header 响应实例
HttpServletResponse相关API：
```
void setContentType(String type)
如果响应还未被提交，设置被发送到客户端的响应的内容类型。
void setIntHeader(String name, int value)
设置一个带有给定的名称和整数值的响应报头。
```

http://47.95.249.79:8080/ServletLearn/Refresh

```
  <servlet>
    <servlet-name>Refresh</servlet-name>
    <servlet-class>com.ysx.test.Refresh</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>Refresh</servlet-name>
    <url-pattern>/ServletLearn/Refresh</url-pattern>
  </servlet-mapping>
```

## ShowError HTTP 状态码实例
HttpServletResponse相关API：
```
public void sendError(int code, String message)
该方法发送一个状态码（通常为 404），连同一个在 HTML 文档内部自动格式化并发送到客户端的短消息。
```
http://47.95.249.79:8080/ServletLearn/ShowError

在linux的tomcat显示为404，但是在windows本地可以显示407。

## LogFilter Servlet 过滤器实例
