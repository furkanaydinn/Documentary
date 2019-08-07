package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eticaret.dao.SiparisDao;
import eticaret.dao.UrunSiparisDao;
import eticaret.model.Siparis;


@WebServlet("/Sepeturunsipariset")
public class Sepeturunsipariset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Sepeturunsipariset() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fiyat = request.getParameter("siparisfiyat");
        String urunadet = request.getParameter("urunsayisi");
        String uyeid = request.getParameter("uyeid");
        String odeme = request.getParameter("kartile");
     
        int toplamfiyat=Integer.parseInt(fiyat);
        int toplamadet=Integer.parseInt(urunadet);
        int uyenumara=Integer.parseInt(uyeid);
        
        HttpSession session = request.getSession(true);
        
        Siparis yenisiparis = new Siparis(toplamfiyat, toplamadet,true,uyenumara,odeme);
       
        try {
           SiparisDao.siparisTamamla(yenisiparis);
           UrunSiparisDao.sepeturunlerisil(uyenumara);
           int adet=new UrunSiparisDao().ugetirAdet( uyenumara);
		   int borc=new UrunSiparisDao().ugetirFiyat( uyenumara);
           session.setAttribute("urunadetsayisi", adet);
	       session.setAttribute("toplamurunfiyati", borc);

        }
        catch(Exception e){
			System.out.println("siparis eklenirken hata oluþtu..." + e);
		}
        response.sendRedirect("kat1.jsp"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
