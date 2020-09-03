package prs.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prs.business.Product;
import prs.db.DAOFactory;
import prs.db.product.ProductDAO;
import prs.db.user.UserDAO;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet({ "/ProductsServlet", "/products" })
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductsServlet.doGet");
		String url = "/welcome.jsp";
		String action = request.getParameter("action");
		ProductDAO pDAO = DAOFactory.getProductDAO();
		if (action!=null&&action.equalsIgnoreCase("list")) {
			ArrayList<Product> products = pDAO.getAllProducts();
			if (products!=null) {
				//products found...  go to product list page
				url = "/products.jsp";
				request.setAttribute("products", products);
			}
			else {
				//no products found
				System.err.println("No products found!");
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ProductsServlet.doPost");
		doGet(request, response);
	}

}
