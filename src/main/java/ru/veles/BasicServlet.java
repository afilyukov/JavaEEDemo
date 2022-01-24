package ru.veles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet (name = "BasicServlet" , urlPatterns = "/srv" )
public class BasicServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private transient ServletConfig config;
    private ProductCatalog productList;

@Override
    public void init(ServletConfig config) throws ServletException {
        productList = new ProductCatalog();
        productList.add(new Product(1321, "T1", 11.5f));
        productList.add(new Product(1322, "T2", 1.5f));
        productList.add(new Product(1521, "T3", 66f));
        productList.add(new Product(1101, "T4", 3.5f));
        productList.add(new Product(1325, "T5", 15.2f));
        productList.add(new Product(1210, "T6", 12.59f));
        productList.add(new Product(1001, "T7", 112f));
        productList.add(new Product(5019, "T8", 730.22f));
        productList.add(new Product(33, "T9", 1.5f));
    productList.add(new Product(4441, "T10", 273.22f));
        this.config = config;
    }
    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws
        ServletException, IOException
    {
        logger.info( "New request" );
        res.getWriter().print(productList.printAll());
    }

    @Override
    public String getServletInfo()
    {
        return "BasicServlet" ;
    }

    @Override
    public void destroy() {
        logger.info( "Servlet {} destroyed" , getServletInfo()); }
        }
