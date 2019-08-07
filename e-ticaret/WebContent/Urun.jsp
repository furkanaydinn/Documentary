<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="eticaret.dao.UrunDao"
        import="eticaret.model.Urun" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 List<Urun> urun = new UrunDao().TumUrunleriGetir();
 request.setAttribute("urun", urun);
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
      <h1> Ürünler</h1>
     <a href="http://localhost:8080/Aydın Ticaret/UrunEkle.jsp">ürün ekle</a>  
        &nbsp;&nbsp;&nbsp;
    </center>
	<div>
		<table align="center" class="tab" border="1" cellpadding="5">
           <tr>
             <th>ürün id</th>
             <th>ürün adı</th>
             <th>ürün fiyatı</th>
             <th>ürün adeti</th>
             <th>ürün garanti süresi</th>
             <th>ürün renk</th>
             <th></th>
          </tr>
	    <c:forEach var="urun" items="${urun}">
                <tr>
                    <td> ${urun.urunId}</td>
                    <td> ${urun.urunAd} </td>
                    <td> ${urun.urunFiyat} </td>
                    <td> ${urun.urunAdet} </td>
                    <td> ${urun.urunGaranti} </td>
                    <td> ${urun.urunRenk} </td>
                   <td>
                        <a href="http://localhost:8080/akset/UrunGuncelle.jsp?id=${urun.urunId}">düzenle</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Urunsil?id=${urun.urunId}">sil</a>                     
                    </td>
                </tr>
            </c:forEach> 
          </table>
	</div>
</body>
</html>