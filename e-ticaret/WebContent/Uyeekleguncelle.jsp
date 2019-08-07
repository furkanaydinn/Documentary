<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>Uyeler</h1>
        <h2>
            <a href="Uyeekle"> uye ekle</a>
            &nbsp;&nbsp;&nbsp;
        </h2>
    </center>
    <div align="center">
        <c:if test="${uye != null}">
            <form action="Uyeguncelle" method="post">
        </c:if>
        <c:if test="${uye == null}">
            <form action="Uyeekle" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${uye != null}">
                        uye guncelle
                    </c:if>
                    <c:if test="${uye == null}">
                        uye ekle
                    </c:if>
                </h2>
            </caption>
                <c:if test="${uye != null}">
                    <input type="hidden" name="id" value="<c:out value='${uye.uyeId}' />" />
                </c:if>           
            <tr>
                <th>uye id :</th>
                <td>
                    <input type="text" name="id" size="45"
                            value="<c:out value='${uye.uyeId}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>uye ad: </th>
                <td>
                    <input type="text" name="ad" size="45"
                            value="<c:out value='${uye.uyeAd}' />"
                    />
                </td>
            </tr>
            <tr>
             <th>uye soyad :</th>
                <td>
                    <input type="text" name="soyad" size="45"
                            value="<c:out value='${uye.uyeSoyad}' />"
                        />
                </td>
            </tr>
            <tr>
             <th>uye tel :</th>
                <td>
                    <input type="text" name="tel" size="45"
                            value="<c:out value='${uye.uyeTel}' />"
                        />
                </td>
              </tr>
              <tr>
             <th>uye adres :</th>
                <td>
                    <input type="text" name="adres" size="45"
                            value="<c:out value='${uye.uyeAdres}' />"
                        />
                </td>
              </tr>
              <tr>
             <th>uye mail :</th>
                <td>
                    <input type="text" name="eposta" size="45"
                            value="<c:out value='${uye.uyeEposta}' />"
                        />
                </td>
              </tr>
              <tr>
             <th>uye sifre :</th>
                <td>
                    <input type="text" name="sifre" size="45"
                            value="<c:out value='${uye.uyeSifre}' />"
                        />
                </td>
              </tr>
               <tr>
             <th>uye yetki :</th>
                <td>
                    <input type="text" name="yetki" size="45"
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