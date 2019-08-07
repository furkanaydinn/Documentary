package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.UyeDao;
import eticaret.model.Uye;


@WebServlet("/Uyeguncelle")
public class Uyeguncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Uyeguncelle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("uyeid"));
        Boolean yetki = Boolean.parseBoolean(request.getParameter("uyeyetki"));
        
 
        Uye uye = new Uye(id, yetki);
        try {
        UyeDao.uyeGuncelle(uye);
        }catch(Exception e) {
        	  System.out.println("servlet hata  "+ e);
        }
        response.sendRedirect("UyeListele.jsp");
	}

}
