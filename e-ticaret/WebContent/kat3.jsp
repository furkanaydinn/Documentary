<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="eticaret.dao.UrunDao"
        import="eticaret.model.Urun" 
        import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 List<Urun> uruni = new UrunDao().UrKatGoreGetir(3);
 request.setAttribute("urun", uruni);
%>
<!-- bulasi kmakinesi -->
<!DOCTYPE html>
<html>
 <head>
   <jsp:include page="headerfirst.jsp" />
   <jsp:include page="sidenav.jsp" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="sayfatasarimi.css" type="text/css" rel="stylesheet"/><!-- css dosyasindan aliyo  -->
   <title>çamaşır makinesi</title>
 </head>
 <body>

  <div class="main">
      <jsp:include page="kayanfoto.jsp" />
      <h3 align="center" >indirimler için takip edin...</h3>
      <div class="container">
         <div class="row">
          <% int i=0; %>
              <c:forEach var="urun" items="${urun}">
                   <div class="col-sm-4">
                   <form  action="Sepetekle" method="post">   
                      <img  src="images/${urun.urunId }.jpg"></img> 
                      <input name="id" type="text" value="<c:out value='${urun.urunId}' />"/>	
					  <input name="ad" type="text"   value="<c:out value='${urun.urunAd}' />">
                      <input name="fiyat" type="text"   value="<c:out value='${urun.urunFiyat}' />"/>
					  <input name="uyeid" type="text"  value="<c:out value='${kullanici.uyeId}' />">
					  <c:if test="${kullanici!=null}">
                          <p class="submit"><input type="submit" value="Sepete ekle"></p>
                      </c:if>
                  </form>
                      <% i++;
                         if(i%3==0){ %><!--  mod3 ise altan devam et -->
                        	 <div class="row"></div>
                       <% } %> 
                 </div>
              </c:forEach>
         </div> 
    </div>
  </div>
  
  <jsp:include page="pageitem.jsp" />
      
 </body>
</html> 
