package web_servlet_hello2;
@WebServlet("/response")
public class ResponseServlet extends HttpServlet{
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            // then write the data of the response
            String username = request.getParameter("username");
            if (username != null && username.length()> 0) {
                out.println("<h2>Hello, " + username + "!</h2>");
            }
        }
}
}