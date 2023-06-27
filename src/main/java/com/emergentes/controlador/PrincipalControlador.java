/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Azbits
 */
@WebServlet(name = "PrincipalControlador", urlPatterns = {"/PrincipalControlador"})
public class PrincipalControlador extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String vista = request.getParameter("vista");

        vista = (request.getParameter("vista") == null) ? "Dashboard" : request.getParameter("vista");
        if (vista.equals("logout")) {
            HttpSession ses = request.getSession();
            //Eliminar  la sesion
            ses.invalidate();
        }
        request.setAttribute("vista", vista);
        request.getRequestDispatcher("Principal.jsp").forward(request, response);

        //response.sendRedirect(vista+"/"+vista+".jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
