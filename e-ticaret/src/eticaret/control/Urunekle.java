package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.UrunDao;
import eticaret.model.Urun;


@WebServlet("/Urunekle")
public class Urunekle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Urunekle() {
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
        String adet = request.getParameter("adet");
        String garanti = request.getParameter("garanti");
        String renk = request.getParameter("renk");
        String kid = request.getParameter("kid");
        int uid=Integer.parseInt(id);
        int ufiyat=Integer.parseInt(fiyat);
        int uadet=Integer.parseInt(adet);
        int ugaranti=Integer.parseInt(garanti);
        int kuid=Integer.parseInt(kid);
        Urun yeniur = new Urun(uid, ad,ufiyat,uadet,ugaranti,renk,kuid);
        try {
           UrunDao.UrunEkle(yeniur);
        }
        catch(Exception e){
			System.out.println("Kategori eklenirken hata oluþtu..." + e);
		}
        response.sendRedirect("Urun.jsp");

	}

}
