<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="eticaret.dao.UyeDao"
        import="eticaret.model.Uye" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<meta charset="UTF-8">
    <title>AydınTicaret.com </title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="admin.css" type="text/css" rel="stylesheet"/>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
    <h3 align="center"> Admin Panel Ekranı</h3>
     <c:choose>
       <c:when test="${uyelik != null}">
             <p style="margin-left:1100px;padding-left:15px; border-radius:7px ; border:1px solid green;">${uyelik.uyeAd} ${uyelik.uyeSoyad} </>
       </c:when>
        <c:when test="${uyelik == null}" >
       </c:when>
     </c:choose>     
	<div id="mySidenav" class="sidenav">
       <a href="http://localhost:8080/akset/UyeListele.jsp" id="uye">üye</a>
       <a href="http://localhost:8080/akset/Urun.jsp" id="urun">ürün</a>
       <a href="http://localhost:8080/akset/siparis.jsp" id="siparis">sipariş</a>
       <a href="http://localhost:8080/akset/Kategori.jsp" id="kategori">kategori</a>
    </div>
</div>	
</body>
</html>