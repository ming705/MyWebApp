<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head> 
        <title>Quote List</title>
    </head>
    <body>
        <div><h2>Here's the Quotes ...</h2></div>
        <table>
            <%@ page import="mypkg.*" %>
            
            <%
            QuotesData quotesData = new QuotesData();
            for (Quote quote: quotesData.getQuotes()) {
            %>
            
            <tr>
                <td><%= quote.getQuote() %></td>
            </tr>
            
            <% } %>
        </table>
    </body>
</html>