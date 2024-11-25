<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <title><tiles:getAsString name="title"/></title>
      	<!-- login.css/join.css -->
      <link href='<tiles:getAsString name="css"/>' type="text/css" rel="stylesheet" />
      <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
   </head>
   <body>
    <!-- header 부분 시작 -->
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- header 부분 종료 -->
		<!-- visual 부분 종료 -->
		<tiles:insertAttribute name="visual"></tiles:insertAttribute>
		<!-- visual 부분 종료 -->

      <div id="main">
         <div class="top-wrapper clear">
           <!-- content 부분 종료 -->
           <tiles:insertAttribute name="content"></tiles:insertAttribute>
			<!-- content 부분 종료 -->
			<!-- navi 부분 시작 -->
			<tiles:insertAttribute name="aside"></tiles:insertAttribute>
			<!-- navi 부분 종료 -->
         </div>
      </div>
      <!-- footer 부분 시작 -->
      <tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<!-- footer 부분 종료 -->
    </body>
</html>
