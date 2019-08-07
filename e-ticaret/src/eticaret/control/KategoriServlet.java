package eticaret.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.KategoriDao;


@WebServlet("/KategoriServlet")
public class KategoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public KategoriServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println("ID: " + id);
		if  (id != null && !id.equals("")){
			try{
				int kId = Integer.parseInt(id);
				KategoriDao.kategoriSil(kId);
			}
			catch(Exception e){
				System.out.println("Uye Sil Servlet: " + e);
			}
		}
		response.sendRedirect("Kategori.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
