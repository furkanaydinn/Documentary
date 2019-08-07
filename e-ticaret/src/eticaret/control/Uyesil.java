package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import eticaret.dao.UyeDao;

@WebServlet("/Uyesil")
public class Uyesil extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
     public Uyesil() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		System.out.println("ID: " + id);
		if  (id != null && !id.equals("")){
			try{
				int uyeId = Integer.parseInt(id);
				UyeDao.kisiSil(uyeId);
			}
			catch(Exception e){
				System.out.println("Uye Sil Servlet: " + e);
			}
		}
		response.sendRedirect("UyeListele.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    }

	}
