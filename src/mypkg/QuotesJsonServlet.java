package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QuotesJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 12345L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        boolean first = true;
        out.print("{ \"quotes\" : [ ");
        QuotesData quotesData = new QuotesData();
        ArrayList<Quote> quotes = quotesData.getQuotes();
        for (Quote quote: quotes) {
            if(!first) { out.print(", "); } else { first = false; }
            out.print("{ \"quote\" : \"" + quote.getQuote() + "\"} ");
        }
        out.println(" ] }");
    }
}
