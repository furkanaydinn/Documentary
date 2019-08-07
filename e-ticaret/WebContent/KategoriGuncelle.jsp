<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="eticaret.dao.KategoriDao"
        import="eticaret.model.Kategori" %>
<%
 String kId = request.getParameter("id");
 Kategori kategori = new KategoriDao().kgetirId(Integer.valueOf(kId));
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
        <h1>Kategoriler</h1>
        <h2> 
              <a href="Kategoriguncelle"> kategori guncelle</a>
         </h2>
    </center>
    <div align="center">
        <c:if test="${kategori != null}">
            <form action="Kategoriguncelle" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${kategori != null}">
                        kategori güncelle
                    </c:if>
                </h2>
            </caption>         
               <tr>
                  <th>kategori id :</th>
                  <td>
                    <input type="text" name="id" size="45"
                            value="<c:out value='${kategori.kategoriId}' />"
                        />
                 </td>
              </tr>
              <tr>
                 <th>Kategori ad: </th>
                 <td>
                    <input type="text" name="ad" size="45"
                            value="<c:out value='${kategori.kategoriAd}' />"
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