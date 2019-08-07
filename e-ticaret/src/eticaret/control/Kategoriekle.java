package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.KategoriDao;
import eticaret.model.Kategori;


@WebServlet("/Kategoriekle")
public class Kategoriekle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Kategoriekle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
        String ad = request.getParameter("ad");
        int kid=Integer.parseInt(id);
        System.out.println("id:"+id);
        System.out.println("ad:"+ad);
        Kategori yenikat = new Kategori(kid, ad);
        try {
        KategoriDao.kategoriEkle(yenikat);
        }
        catch(Exception e){
			System.out.println("Kategori eklenirken hata oluþtu..." + e);
		}
        response.sendRedirect("Kategori.jsp");
	
	}

}
