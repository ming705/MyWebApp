package mypkg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QuotesData {
    public ArrayList<Quote> getQuotes() {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/c9");
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Quotes");
            
            while (rs.next()) {
                Quote tempQuote = new Quote(rs.getString(3));
                quotes.add(tempQuote);
            }
        } catch(SQLException ex) {
            Logger lgr = Logger.getLogger(QuotesData.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch(NamingException nmex) {
            Logger lgr = Logger.getLogger(QuotesData.class.getName());
            lgr.log(Level.SEVERE, nmex.getMessage(), nmex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(QuotesData.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return quotes;
    }
}