package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import eticaret.dao.UyeDao;
import eticaret.model.Uye;

@WebServlet("/Uyekaydol")
public class Uyekaydol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Uyekaydol() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean kayitlimi;
		
		String id = request.getParameter("id");
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String tel = request.getParameter("tel");
        String adres = request.getParameter("adres");
        String eposta = request.getParameter("eposta");
        String sifre = request.getParameter("sifre");
        
        int uid=Integer.parseInt(id);
        long utel=Long.parseLong(tel);
          
        HttpSession session = request.getSession(true);
        
        Uye yeniuy = new Uye(uid, ad,soyad,utel,adres,eposta,sifre,false); // eklenen musteri oldugu icin false
        
        if (id != null && !id.equals("") && ad != null && !ad.equals("") && soyad != null && !soyad.equals("") && tel != null && !tel.equals("") &&adres != null && !adres.equals("") && eposta != null && !eposta.equals("")&& sifre != null && !sifre.equals("")) {
        	   kayitlimi=UyeDao.Kayitlimi(uid);
        	 if (kayitlimi==true) { 	    
        	     response.sendRedirect("giris.jsp");
        	     session.setAttribute("kayitli",true);
        	     System.out.println("uye var");
        	 }
             else {
            	  
            	  UyeDao.UyeEkle(yeniuy);
            	  Uye uye=new UyeDao().ugetirAd( uid);	    
      	          session.setAttribute("kullanici",uye);
                  System.out.println("uye yeni"+uye);
                  session.setAttribute("kayitli",false);
                  response.sendRedirect("kat1.jsp"); 
           }
	   }
        else {
		   response.sendRedirect("giris.jsp");  
	   }
	}
}

