<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="eticaret.dao.UyeDao"
        import="eticaret.model.Uye" %>
<%
 String uId = request.getParameter("id");
Uye uye = new UyeDao().uyegetiryetki(Integer.valueOf(uId));
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
        <h1>Üye</h1>
    </center>
    <div align="center">
        <c:if test="${uye != null}">
            <form action="Uyeguncelle" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${uye != null}">
                        üye  yetki güncelle
                    </c:if>
                </h2>
            </caption> 
              <tr>
                 <th>üye numarası: </th>
                 <td>
                    <input type="text" name="uyeid" size="45"
                            value="<c:out value='${uye.uyeId}' />"
                    />
                 </td>
            </tr>
            <tr>        
             <tr>
                 <th>yetki: </th>
                 <td>
                    <input type="text" name="uyeyetki" size="45"
                            value="<c:out value='${uye.uyeYetki}' />"
                    />
                 </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>