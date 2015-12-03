/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Contracts.CustomerContract;
import DTO.CustomerDTO;
import ETO.FerryETO;
import DTO.FerryDTO;
import DTO.HarborDTO;
import ETO.CustomerETO;
import ETO.DepartureETO;
import ETO.HarborETO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cluster C Frontend Customer
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
//private CustomerManager cm;

    @EJB
    private CustomerContract cc;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, HarborETO, DepartureETO, CustomerETO {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDTO customer;
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            customer = cc.CustomerLogin(request.getParameter("user"), request.getParameter("pass"));
            
            if (customer != null)
            {                
                out.println("<h1>User:" + customer.getEmail() + " </h1>");    
                out.println("<h1>Password:" + customer.getPassword() + " </h1>");    
          
            
            
            int f = cc.GetListOfFerries().size();
            out.println("<h1>We have :" + cc.GetListOfFerries().size() + " Ferries</h1>");                        
            for(int i = 0; i< f; i++ )
            {
                out.println("Ferry #" + i +" name: "+ cc.GetListOfFerries().get(i).getName() + "<br>");                                          
            }
            
          
            out.println("<br>");
            int h = cc.GetListOfHarbors().size();
            out.println("<h1>We have: " + cc.GetListOfHarbors().size() + " Harbors</h1>");
            for(int i = 0; i< h; i++ )
            {
                out.println("Harbor #" + i +" "+ cc.GetListOfHarbors().get(i).getName() + "<br>");  
            }
            
            out.println("<br>");
            int d = cc.GetListOfDepartures().size();
            out.println("<h1>We have: " + cc.GetListOfDepartures().size() + " Departures</h1>");
            for(int i = 0; i< d; i++ )
            {
                out.println("<br>");
                out.println("<b>Departure: </b><br>");  
                out.println("Date: " + i +" "+ cc.GetListOfDepartures().get(i).getDepartureTime().getDate() + "<br>");  
                out.println("Time: " + i +" "+ cc.GetListOfDepartures().get(i).getDepartureTime().getHours()+ ":" +
                                      + cc.GetListOfDepartures().get(i).getDepartureTime().getMinutes()+ ":" +
                                      + cc.GetListOfDepartures().get(i).getDepartureTime().getSeconds()+ ":" +
                                      "<br>");  
                out.println("Route: <br>");
                out.println("Departure Harbor: " + cc.GetListOfDepartures().get(i).getRoute().getDepartureHarbor().getName() + "<br>");  
                out.println("Desination Harbor: " + cc.GetListOfDepartures().get(i).getRoute().getDestinationHarbor().getName() + "<br>");  
                out.println("Duration: " + cc.GetListOfDepartures().get(i).getRoute().getDuration() + "<br>");  
            }
            
            }
            else
            {
                  out.println("<h1>The User <div style=\"color:#0000FF\" " + request.getParameter("user") + "</div> does not exist or the password does not match the user.</h1>");                  
            }
            out.println("</body>");
            out.println("</html>");

        } catch (FerryETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (HarborETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (DepartureETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (HarborETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DepartureETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CustomerETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            try {
                processRequest(request, response);
            } catch (CustomerETO ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (HarborETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DepartureETO ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //get request parameters for userID and password
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        
        //CustomerContract customer = customer.CustomerLogin(username, password);
        
        
        try {
            
                    CustomerDTO customerL = cc.CustomerLogin(user, pwd);
            if (
                    (user != null) && (customerL != null)
                )
            {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("home");
                
            } else {
                request.setAttribute("error", "Unknown user, please try again");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } 
            catch (CustomerETO ex) {
           Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
