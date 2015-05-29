package web_servlet_hello2;

import java.io.PrintWriter;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet{
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                + "<img src=\"duke.waving.gif\" "
                + "alt=\"Duke waving his hand\">"
                + "<form method=\"get\">"
                + "<h2>Hello, my name is Duke. What's yours?</h2>"
                + "<input title=\"My name is: \"type=\"text\" "
                + "name=\"username\" size=\"25\">"
                + "<p></p>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">"
                + "</form>");
            
            String username = request.getParameter("username");
            if (username != null && username.length()> 0) {
                RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/response");

                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
}
}
