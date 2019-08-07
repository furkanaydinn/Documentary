package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import eticaret.dao.KategoriDao;
import eticaret.model.Kategori;

@WebServlet("/Kategoriguncelle")
public class Kategoriguncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Kategoriguncelle() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
        }
        
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String ad = request.getParameter("ad");
      
        Kategori kategori = new Kategori(id, ad);
        try {
        KategoriDao.kategoriGuncelle(kategori);
        }catch(SQLException e) {
        	  System.out.println("servlet hata  "+ e);
        }
        response.sendRedirect("Kategori.jsp");
      
        
	}

}
