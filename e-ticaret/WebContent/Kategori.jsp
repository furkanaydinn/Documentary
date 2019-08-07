<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="eticaret.dao.KategoriDao"
        import="eticaret.model.Kategori" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 List<Kategori> kategori = new KategoriDao().Kategoriler();
 request.setAttribute("kategori", kategori);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="girisekrani.css" type="text/css" rel="stylesheet"/>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<jsp:include page="admin.jsp" />	
</head>
<body>
    <center>
      <h1> Kategoriler</h1>
       <a href="http://localhost:8080/AydınTicaret/KategoriEkle.jsp">kategori ekle</a>  
        &nbsp;&nbsp;&nbsp;
    </center>
	<div>
		<table  align="center" class="tab" border="1" cellpadding="5" >
           <tr>
             <th>kategori id</th>
             <th>kategori ad</th>
             <th></th>
          </tr>
	   <c:forEach var="kategori" items="${kategori}">
                <tr>
                    <td> ${kategori.kategoriId} </td>
                    <td> ${kategori.kategoriAd} </td>
                   <td>
                        <a href="KategoriGuncelle.jsp?id=${kategori.kategoriId}">düzenle</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="KategoriServlet?id=${kategori.kategoriId} ">Sil</a>                     
                    </td>
                </tr>
            </c:forEach>  
          </table>
	</div> 
</body>
</html>