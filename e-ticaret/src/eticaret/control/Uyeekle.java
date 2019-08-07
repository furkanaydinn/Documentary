package eticaret.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eticaret.dao.UyeDao;
import eticaret.model.Uye;


@WebServlet("/Uyeekle")
public class Uyeekle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Uyeekle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String tel = request.getParameter("tel");
        String adres = request.getParameter("adres");
        String eposta = request.getParameter("eposta");
        String sifre = request.getParameter("sifre");
        String yetki = request.getParameter("yetki");
        int uid=Integer.parseInt(id);
        long utel=Long.parseLong(tel);
        Boolean uyetki=Boolean.parseBoolean(yetki);
           
        Uye yeniuy = new Uye(uid, ad,soyad,utel,adres,eposta,sifre,uyetki);
        try {
           UyeDao.UyeEkle(yeniuy);
        }
        catch(Exception e){
			System.out.println("uye eklenirken hata oluþtu..." + e);
		}
        response.sendRedirect("UyeListele.jsp");

	}

		
	}


