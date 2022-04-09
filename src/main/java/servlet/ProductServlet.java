package servlet;

import product.Product;
import product.ProductList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductList productList;

    @Override
    public void init() throws ServletException {
        this.productList = new ProductList();
         for (int i =0;i<10;i++){
             productList.createProduct(new Product(0,"Product " +i,(i+3)*10));
         }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (productList==null){
           resp.getWriter().println("product not found");

       } else {
           for (int i=0;i<productList.getAllProducts().size();i++){
               resp.getWriter().println(productList.getAllProducts().get(i).getName() + " " + productList.getAllProducts().get(i).getPrice());
           }

       }

    }
}
