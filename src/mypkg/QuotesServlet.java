package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QuotesServlet extends HttpServlet {
    private static final long serialVersionUID = 12345L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<html><head></head><body> Here's the Quotes ...");
        
        QuotesData quotesData = new QuotesData();
        ArrayList<Quote> quotes = quotesData.getQuotes();
        for (Quote quote: quotes) {
            out.println("<div>" + quote.getQuote() + "</div>");
        }
        out.println("</body></html>");
    }
}
