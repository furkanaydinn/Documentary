<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="eticaret.dao.SiparisDao"
        import="eticaret.model.Siparis" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 List<Siparis> siparis = new SiparisDao().tumSiparisleriGetir();
 request.setAttribute("siparis", siparis);
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
      <h1>Siparişler</h1>
    </center>
	<div>
		<table class="tab" align="center"  border="1" cellpadding="5">
           <tr>
             <th>siparis id</th>
             <th>siparis tutar</th>
             <th>siparis  toplam urun sayısı</th>
             <th>alındımı</th>
             <th>alan üye numarası</th>
             <th>ödeme yöntemi</th>
          </tr>
	   <c:forEach var="siparis" items="${siparis}">
                <tr>
                    <td> ${siparis.siparisId} </td>
                    <td> ${siparis.siparisTutar} </td>
                    <td> ${siparis.siparisUrunAdet} </td>
                    <td> ${siparis.siparisSonuc} </td>
                    <td> ${siparis.uyeId}</td>
                    <td> ${siparis.siparisOdeme}</td>
                </tr>
            </c:forEach>  
          </table>
	</div> 
</body>
</html>