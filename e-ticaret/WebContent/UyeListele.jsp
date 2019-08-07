<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="eticaret.dao.UyeDao"
        import="eticaret.model.Uye" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 List<Uye> uye = new UyeDao().butunUyeler();
 request.setAttribute("uye", uye);
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
      <h1> Üyeler</h1>
       <a href="http://localhost:8080/Aydın Ticaret/Uyeekleguncelle.jsp">üye ekle</a>  
        &nbsp;&nbsp;&nbsp;
    </center>
	<div>
		<table align="center" class="tab"  border="1" cellpadding="5">
           <tr>
             <th>üye numarasi</th>
             <th>üye adi</th>
             <th>üye soyadi</th>
             <th>üye tel</th>
             <th>üye mail</th>
             <th>üye adres</th>
             <th>üye yetki</th>
             <th></th>
          </tr>
	    <c:forEach var="uye" items="${uye}">
                <tr>
                    <td> ${uye.uyeId}</td>
                    <td> ${uye.uyeAd} </td>
                    <td> ${uye.uyeSoyad} </td>
                    <td> ${uye.uyeTel} </td>
                    <td> ${uye.uyeEposta} </td>
                    <td> ${uye.uyeAdres} </td>
                    <td> ${uye.uyeYetki}</td>
                   <td>
                        <a href="http://localhost:8080/akset/Uyeguncelle.jsp?id=<c:out value='${uye.uyeId}' />">üye yetki güncelle</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Uyesil?id=${uye.uyeId}">Sil</a>                     
                    </td>
                </tr>
            </c:forEach> 
          </table>
	</div>
</body>
</html>