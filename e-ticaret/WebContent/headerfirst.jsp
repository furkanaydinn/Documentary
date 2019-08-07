<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="eticaret.dao.KategoriDao"
        import="eticaret.model.Kategori" 
        import="java.util.List"%>
<%
 List<Kategori> katiyaz = new KategoriDao().Kategoriler();
 request.setAttribute("kategori", katiyaz);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css">
    .giris{
      border:2px solid LightSteelBlue   ;
      border-radius:6px;
      margin-left: 1150px;
      padding:3px 3px 3px 5px ;
      background-color:White  ;
      font-size: 13px;
    }
  </style>
  </head>
<body>

<div class="container-center">
  <div class="jumbotron" style="background-color:LightSlateGrey">
     <h1 align="center" style="font-family:algerian;">AYDIN TİCARET</h1> 
         <form class="navbar-form navbar-right" action="/action_page.php" >
         <div class="input-group">
             <input type="text" class="form-control" autocomplete="on" placeholder="search" name="search">
             <div class="input-group-btn">
                 <button class="btn btn-default" type="submit">
                        <i class="glyphicon glyphicon-search"></i>
                 </button>
             </div>
         </div>
    </form>
    
    <nav class="navbar navbar-default ">
       <div class="container-fluid">
         <div class="navbar-header ">
           <a class="navbar-brand-fixed-top" href="#"></a>
         </div>
         <ul class="nav navbar-nav"  >
           <c:forEach var="kategori" items="${kategori}">
               <li><a href="http://localhost:8080/akset/kat${kategori.kategoriId}.jsp" >${kategori.kategoriAd}</a></li>
           </c:forEach>
         </ul>
       </div>
    </nav>
  </div> 
  <c:choose>
      <c:when test="${kullanici == null}">
          <a class="giris" href="http://localhost:8080/akset/giris.jsp">giriş yap veya kaydol</a>
      </c:when>
      <c:when test="${kullanici != null}">
           <p style="margin-left:1100px" class="giris"> ${kullanici.uyeAd}  ${kullanici.uyeSoyad} </>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="http://localhost:8080/akset/Sepet.jsp?id=${kullanici.uyeId}" >Sepet </a>  <a href=http://localhost:8080/akset/giris.jsp><script> kullanici=null;</script> Çıkış</a>
      </c:when>
  </c:choose>
</div>

</body>
</html>


