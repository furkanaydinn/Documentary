<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="eticaret.dao.UrunDao"
        import="eticaret.model.Urun" %>
<%
 String uId = request.getParameter("id");
Urun urun = new UrunDao().ugetirId(Integer.valueOf(uId));
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
        <h1>Ürünler</h1>
    </center>
    <div align="center">
        <c:if test="${urun != null}">
            <form action="Urunguncelle" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${urun != null}">
                        ürün güncelle
                    </c:if>
                </h2>
            </caption>         
               <tr>
                  <th>ürün id :</th>
                  <td>
                    <input type="text" name="id" size="45"
                            value="<c:out value='${urun.urunId}' />"
                        />
                 </td>
              </tr>
              <tr>
                 <th>ürün ad: </th>
                 <td>
                    <input type="text" name="ad" size="45"
                            value="<c:out value='${urun.urunAd}' />"
                    />
                 </td>
            </tr>
              <tr>
                 <th>ürün fiyat: </th>
                 <td>
                    <input type="text" name="fiyat" size="45"
                            value="<c:out value='${urun.urunFiyat}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th>ürün adet: </th>
                 <td>
                    <input type="text" name="adet" size="45"
                            value="<c:out value='${urun.urunAdet}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th>ürün garanti: </th>
                 <td>
                    <input type="text" name="garanti" size="45"
                            value="<c:out value='${urun.urunGaranti}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th>ürün renk: </th>
                 <td>
                    <input type="text" name="renk" size="45"
                            value="<c:out value='${urun.urunRenk}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th>kategori id: </th>
                 <td>
                    <input type="text" name="kid" size="45"
                            value="<c:out value='${urun.kategoriId}' />"
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