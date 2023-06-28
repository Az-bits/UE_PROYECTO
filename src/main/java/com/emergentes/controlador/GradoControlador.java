package com.emergentes.controlador;

import com.emergentes.dao.ParaleloDAO;
import com.emergentes.dao.ParaleloDAOimpl;
import com.emergentes.dao.GradoDAO;
import com.emergentes.dao.GradoDAOimpl;
import com.emergentes.modelo.Paralelo;
import com.emergentes.modelo.Grado;
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

@WebServlet(name = "GradoControlador", urlPatterns = {"/GradoControlador"})
public class GradoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GradoDAO dao = new GradoDAOimpl();
            ParaleloDAO daoP = new ParaleloDAOimpl();
            Grado gra = new Grado();

            List<Paralelo> par = daoP.getAll();

            String grado_nro;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":

                    request.setAttribute("action", action);
                    request.setAttribute("grado", gra);
                    request.setAttribute("paralelo", par);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    grado_nro = request.getParameter("grado_nro");
                    request.setAttribute("paralelo", par);
                    gra = dao.getById(grado_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("grado", gra);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    grado_nro = request.getParameter("grado_nro");
                    dao.delete(grado_nro);
                    response.sendRedirect("GradoControlador");
                    break;
                case "view":
                    List<Grado> lista = dao.getAll();
                    request.setAttribute("grado", lista);
                    request.setAttribute("vista", "grado");
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "buscar":
                    //dato= request.getParameter("txtBuscar");

                    // List<Estudiantes> list = dao.buscar(dato);
                    // request.setAttribute("estudiante", list);
                    request.getRequestDispatcher("none.jsp").forward(request, response);
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

        String grado_nro = request.getParameter("grado_nro") != null ? request.getParameter("grado_nro") : null;
        String paralelo_nro = request.getParameter("paralelo_nro");
        String descripcion = request.getParameter("descripcion");
        String nivel = request.getParameter("nivel");

        Grado gra = new Grado();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        gra.setGrado_nro(grado_nro);
        gra.setDescripcion(descripcion);
        gra.setNivel(nivel);
        gra.setParalelo_nro(paralelo_nro);

        gra.setParalelo_nro(paralelo_nro);
        switch (action) {
            case "add":
                //Nuevo
                GradoDAO dao = new GradoDAOimpl();
                try {
                    dao.insert(gra);
                    request.setAttribute("vista", "paralelo");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("GradoControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                GradoDAO da = new GradoDAOimpl();
                System.out.println(gra);
                try {
                    da.update(gra);
                    response.sendRedirect("GradoControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
