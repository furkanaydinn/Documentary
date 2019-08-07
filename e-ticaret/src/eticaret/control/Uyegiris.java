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

@WebServlet("/Uyegiris")
public class Uyegiris extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Uyegiris() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean var;
        Boolean uyemi;
        Boolean uyeyok=false;
		String id = request.getParameter("id");
        String sifre = request.getParameter("sifre");
        
        HttpSession session = request.getSession(true);

        int uid=Integer.parseInt(id);
        
        Uye uye=new UyeDao().ugetirAd( uid); //uye adi ve soyadini getiriyor
        
        if ( (id != null && !id.equals("") ) && (sifre != null && !sifre.equals("") ) ) {
        	   var=UyeDao.Girisadmin(uid,sifre); // admin mi diye bakiyor
        	   uyemi= UyeDao.Girisuye(uid,sifre);// uyemi kontrol ediyor sonuc boolean donuyor
        	   if (var==true) {
        		  try { 	    
        	          session.setAttribute("uyelik",uye); 
        	          uyeyok=false;	    
             	      session.setAttribute("uyeyok",uyeyok);
        	       }
        		   catch(Exception e) {
        		      System.out.println("servlet hata  "+ e);
        		   }
        	       response.sendRedirect("admin.jsp");
        	       System.out.println("uye admin");
        	    }  
               else if(uyemi==true ) {
                   try {    
             	       session.setAttribute("kullanici",uye); 
             	       uyeyok=false;	    
             	       session.setAttribute("uyeyok",uyeyok);
           	        }
           		    catch(Exception e) {
           		       System.out.println("servlet hata  "+ e);
           		    }
                       System.out.println("uye kullanici");
                       response.sendRedirect("kat1.jsp"); 
               }
               else {
                   System.out.println("uye numarasi veya sifre yanlis");
                   uyeyok=true;	    
          	       session.setAttribute("uyeyok",uyeyok);
          	       response.sendRedirect("giris.jsp"); 
               }
	    }
        else {
        	 response.sendRedirect("giris.jsp");
        }
	}
}
