package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import dto.productResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.productService;

@WebServlet("/products/*")
public class productController extends HttpServlet {
	private productService productservice;
	
	@Override
	public void init() throws ServletException {
		this.productservice= new productService();
		System.out.println("init");
		this.productservice=new productService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get method invoked");
		resp.setContentType("text/html");
		 PrintWriter out=  resp.getWriter();
		 
		 int id=Integer.parseInt(req.getParameter("productId"));
		 try {
		productResponse	product= productservice.getProductById(id);
		out.println("<h2>Product Controller<h2>");
		out.printf("<p> %d </p>", product.getProductId());
		out.printf("<p> %s </p>", product.getProductName());
		out.printf("<p> %d </p>", product.getCategoryId());
		out.printf("<p> %f </p>", product.getPrice());
		out.printf("<p> %s </p>", product.getProductDescription());
		out.printf("<p> %d </p>", product.getSellerId());
		out.printf("<p> %d </p>", product.getProductQuantity());
		out.printf("<p> %s </p>", product.getUserReview());
			 
		 }catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	

}
