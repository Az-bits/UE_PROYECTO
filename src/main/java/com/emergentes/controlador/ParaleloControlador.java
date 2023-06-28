package com.emergentes.controlador;

import com.emergentes.dao.ParaleloDAO;
import com.emergentes.dao.ParaleloDAOimpl;
import com.emergentes.modelo.Paralelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParaleloControlador", urlPatterns = {"/ParaleloControlador"})
public class ParaleloControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ParaleloDAO dao = new ParaleloDAOimpl();
            String paralelo_nro;
            Paralelo par = new Paralelo();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("paralelo", par);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    paralelo_nro = request.getParameter("paralelo_nro");

                    par = dao.getById(paralelo_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("paralelo", par);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    paralelo_nro = request.getParameter("paralelo_nro");
                    dao.delete(paralelo_nro);
                    response.sendRedirect("ParaleloControlador");
                    break;
                case "view":

                    List<Paralelo> lista = dao.getAll();
                    request.setAttribute("paralelo", lista);
                    request.setAttribute("vista", "paralelo");
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "buscar":
                    //dato= request.getParameter("txtBuscar");

                    // List<Estudiantes> list = dao.buscar(dato);
                    // request.setAttribute("estudiante", list);
                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                    break;

                default:
                    break;
            }
        } catch (Exception ex) {
            log("Se produjo un error en el servlet", ex);
            System.out.println("Error Fatal" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paralelo_nro = request.getParameter("paralelo_nro") != null ? request.getParameter("paralelo_nro") : null;
        String paralelo = request.getParameter("paralelo");

        Paralelo par = new Paralelo();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        par.setParalelo_nro(paralelo_nro);
        par.setParalelo(paralelo);
        switch (action) {
            case "add":
                //Nuevo
                ParaleloDAO dao = new ParaleloDAOimpl();
                try {
                    dao.insert(par);
                    request.setAttribute("vista", "paralelo");
                    response.sendRedirect("ParaleloControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                ParaleloDAO da = new ParaleloDAOimpl();
                System.out.println(par);
                try {
                    da.update(par);
                    response.sendRedirect("ParaleloControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
