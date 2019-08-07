package eticaret.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.UrunDao;
import eticaret.model.Urun;


@WebServlet("/Urunguncelle")
public class Urunguncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Urunguncelle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String ad = request.getParameter("ad");
        int fiyat = Integer.parseInt(request.getParameter("fiyat"));
        int adet = Integer.parseInt(request.getParameter("adet"));
        int garanti = Integer.parseInt(request.getParameter("garanti"));
        String renk = request.getParameter("renk");
        int kid = Integer.parseInt(request.getParameter("kid"));
      
        Urun urun = new Urun(id, ad,fiyat,adet,garanti,renk,kid);
        try {
        UrunDao.urunGuncelle(urun);
        }catch(Exception e) {
        	  System.out.println("servlet hata  "+ e);
        }
        response.sendRedirect("Urun.jsp");
      
	}

}
