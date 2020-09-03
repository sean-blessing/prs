package prs.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prs.business.User;
import prs.db.DAOFactory;
import prs.db.user.UserDAO;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet({ "/RegistrationServlet", "/register", "/login" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegistrationServlet doGet");
		String url = "/index.html";
		String action = request.getParameter("action");   // retrieved from hidden 'action' field in form
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		UserDAO uDAO = DAOFactory.getUserDAO();
		if (action!=null&&action.equalsIgnoreCase("login")) {
			url = "/index.html";
			User usr = uDAO.getUserByUserName(username);
			if (usr!=null) {
				//user found...  go to welcome page
				url = "/welcome.jsp";
			}
			else {
				//no user found
			}
		}
		else if (action.equalsIgnoreCase("register")){
			url = "/registration.html";
			String fname = request.getParameter("firstName");
			String lname = request.getParameter("lastName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String isReviewer = request.getParameter("reviewer");
			String isAdmin = request.getParameter("admin");
			boolean r = false;
			if (isReviewer!=null)
				r = true;
			boolean a = false;
			if (isAdmin!=null)
				a = true;
			
			User usr = new User(username, pwd, fname, lname, phone, email, r, a);
			if (uDAO.addUser(usr)) {
				System.out.println("oid of new user = "+usr.getId());
				request.setAttribute("user", usr);
				url="/welcome.jsp";
			}
			else {
				// user add failed... return to registration page
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegistrationServlet doPost");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
