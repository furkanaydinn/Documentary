package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eticaret.dao.UrunSiparisDao;
import eticaret.model.UrunSiparis;



@WebServlet("/Sepetekle")
public class Sepetekle extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Sepetekle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
		    request.setCharacterEncoding("UTF-8");
		    
			String id = request.getParameter("id");
			String ad = request.getParameter("ad");
		    String fiyat = request.getParameter("fiyat");
		    String uyeid = request.getParameter("uyeid");
		     
	        int uid=Integer.parseInt(id);
	        int ufiyat=Integer.parseInt(fiyat);
	        int uyid=Integer.parseInt(uyeid);
	        
	        HttpSession session = request.getSession(true);

	    
	        try {
	           UrunSiparis yenisepetur = new UrunSiparis(uid, uyid,ad,ufiyat);
	           UrunSiparisDao.SepeturunEkle(yenisepetur);
	           int toplamfiyat=new UrunSiparisDao().ugetirFiyat( uyid);
	           int adet=new UrunSiparisDao().ugetirAdet( uyid);
	           
	           session.setAttribute("urunadetsayisi", adet);
	           session.setAttribute("toplamurunfiyati", toplamfiyat);
	           
	           System.out.println(adet);
	        }
	        catch(Exception e){
				System.out.println("sepete eklenirken hata oluþtu..." + e);
			} 
	        response.sendRedirect("kat1.jsp");
		 
	}

}
