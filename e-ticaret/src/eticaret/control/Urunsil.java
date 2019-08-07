package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.UrunDao;

/**
 * Servlet implementation class Urunsil
 */
@WebServlet("/Urunsil")
public class Urunsil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Urunsil() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		System.out.println("ID: " + id);
		if  (id != null && !id.equals("")){
			try{
				int urunId = Integer.parseInt(id);
				UrunDao.urunSil(urunId);
			}
			catch(Exception e){
				System.out.println("Uye Sil Servlet: " + e);
			}
		}
		response.sendRedirect("Urun.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
