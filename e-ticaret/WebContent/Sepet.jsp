<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="eticaret.dao.UrunSiparisDao"
        import="java.util.List"
        import="eticaret.model.UrunSiparis" %>
<%
 String uId = request.getParameter("id");

List<UrunSiparis> urunsepet = new UrunSiparisDao().SepuyeyeGoreGetir(Integer.valueOf(uId));
 request.setAttribute("urunSiparis", urunsepet);
%>
<!-- sepet -->
<!DOCTYPE html>
<html>
 <head>
   <jsp:include page="headerfirst.jsp" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="sayfatasarimi.css" type="text/css" rel="stylesheet"/><!-- css dosyasindan aliyo  -->
   <title>Sepetim</title>
   <style>
    .giristab{
        border:3px solid LightSteelBlue    ;
        border-radius:10px;
        background-color:white;
        margin-top:20px;
    }
   </style>
 </head>
<body>
  
    
      
    <div>
		<table class="giristab" align="center" class="tab" border="1" cellpadding="5">
           <tr>
             <th> üye numaranız</th>
             <th> ürün kodu </th>
             <th> ürün adı </th>
             <th> ürün fiyatı </th>
             <th></th>
           </tr>
             <c:forEach var="urunSiparis" items="${urunSiparis}">
                <tr>
                    <td> ${urunSiparis.uyeId} </td>
                    <td> ${urunSiparis.urunId}</td>
                    <td> ${urunSiparis.urunAd} </td>
                    <td> ${urunSiparis.urunFiyat}₺ </td> 
                   <td>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Siparissil?sepetid=${urunSiparis.urunId}&uyeid=${kullanici.uyeId}&??">sil</a>                     
                    </td>
                </tr>
            </c:forEach> 
          </table>
          
          <h4 align="center" style="border-radius:7px ; border:1px solid  red; margin:20px 450px 20px 450px">
             <c:if test="${urunadetsayisi!=null}">
                <p> toplam ürün sayısı= ${urunadetsayisi}  toplam fiyat= ${toplamurunfiyati}₺</p>
                <c:set var="adet" value="${urunadetsayisi}"></c:set>
                <c:if test="${urunadetsayisi==0}">
                   <p>sepetinizde ürün bulunmamaktadır.</p>               	
                   <c:out value="${adet}"/>
                </c:if>
            </c:if >
         </h4>
           
           
           <h3 align="center" style="border-radius:7px ; border:1px solid green; margin:20px 450px 20px 450px" >Siparis et 
             <br>
             <a href="Sepeturunsipariset?siparisfiyat=${toplamurunfiyati}&urunsayisi=${urunadetsayisi}&uyeid=${kullanici.uyeId}&kartile=kartile&????">kart ile</a>
             <a href="Sepeturunsiparisnakit?siparisfiyat=${toplamurunfiyati}&urunsayisi=${urunadetsayisi}&uyeid=${kullanici.uyeId}&nakit=nakit&????">nakit ödeme ile</a>
           </h3>
	</div>
</body>
</html>