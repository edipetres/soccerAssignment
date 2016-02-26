/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.DomainFacade;
import domain.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edipetres
 */
@WebServlet(name = "UIServlet", urlPatterns = {"/UIServlet"})
public class UIServlet extends HttpServlet {

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
            throws ServletException, IOException {
       //Establish or reestablish application domain model
       HttpSession session = request.getSession();
       DomainFacade domainModel = (DomainFacade) session.getAttribute("Controller");
        if (domainModel == null) {
            //New session starts
            domainModel = DomainFacade.getInstance();
            session.setAttribute("Controller", domainModel);
        }
        else {
            domainModel = (DomainFacade) session.getAttribute("Controller");
        }
        
        String whereTo = request.getParameter("whereTo");
        switch(whereTo){
           
           case "viewstats":
               RequestDispatcher viewStats = request.getRequestDispatcher("ViewStats.jsp");
               viewStats.forward(request, response);
               
               break;
           
           case "getplayerwithid":
               getPlayer(request,response, domainModel);
               break;
               
           case "getallplayers" :
               
               getAllPlayers(request, response, domainModel);
               break;
           
           case "edit":
               RequestDispatcher edit = request.getRequestDispatcher("Edit.jsp");
               request.setAttribute("Players", domainModel.getAllPlayers());
               edit.forward(request, response);
               break;
               
               
           case "getPlayer":
               getPlayer(request,response, domainModel);
               break;
               
           default:
               RequestDispatcher defaultDispatcher = request.getRequestDispatcher("index.html");
               defaultDispatcher.forward(request, response);
               break;
           
       }
       
       
    }
    
    private void getPlayer(HttpServletRequest request, HttpServletResponse response, DomainFacade domainModel) throws ServletException, IOException {
        int playerid = 1;
        playerid = Integer.parseInt(request.getParameter("playerid"));
        Player player = domainModel.getPlayer(playerid);
        //can add an arraylist later
        request.setAttribute("player", player);
        RequestDispatcher rd = request.getRequestDispatcher("Players.jsp");
        rd.forward(request, response);
    }
     private void getAllPlayers(HttpServletRequest request, HttpServletResponse response, DomainFacade domainModel) throws ServletException, IOException {
        ArrayList<Player> playerList = domainModel.getAllPlayers();
         
        request.setAttribute("playerList", playerList);
        RequestDispatcher rd = request.getRequestDispatcher("Players.jsp");
        rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
