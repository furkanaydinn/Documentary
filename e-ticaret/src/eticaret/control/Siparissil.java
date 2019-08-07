package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eticaret.dao.UrunSiparisDao;

@WebServlet("/Siparissil")
public class Siparissil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Siparissil() {
        super(); 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("sepetid");
		String uyeid = request.getParameter("uyeid");
		System.out.println(" uye ID: " + uyeid);
		HttpSession session = request.getSession(true);
		if  (id != null && !id.equals("")){
			try{
				int uId = Integer.parseInt(id);
				int uyeId = Integer.parseInt(uyeid);
				UrunSiparisDao.sepeturunSil(uId);
				int adet=new UrunSiparisDao().ugetirAdet( uyeId);
				int toplamfiyat=new UrunSiparisDao().ugetirFiyat( uyeId);
		        session.setAttribute("urunadetsayisi", adet);
		        session.setAttribute("toplamurunfiyati", toplamfiyat);
		           
			}
			catch(Exception e){
				System.out.println("Uye Sil Servlet: " + e);
			}
		}
		 response.sendRedirect("kat1.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
