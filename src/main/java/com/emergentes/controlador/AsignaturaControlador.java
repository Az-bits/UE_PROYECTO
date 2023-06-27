package com.emergentes.controlador;

import com.emergentes.dao.AsignaturaDAO;
import com.emergentes.dao.AsignaturaDAOimpl;
import com.emergentes.modelo.Asignatura;
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

@WebServlet(name = "AsignaturaControlador", urlPatterns = {"/AsignaturaControlador"})
public class AsignaturaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AsignaturaDAO dao = new AsignaturaDAOimpl();
            //PPFFDAO daoppff = new PPFFDAOimpl();
            String asignatura_nro;
            // String dato;
            //List<PPFF> lista_ppff = null;
            Asignatura asi = new Asignatura();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";
            
            switch (action) {
                case "add":

                    //lista_ppff = daoppff.getAll();
                    //request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("action", action);
                    request.setAttribute("asignatura", asi);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    asignatura_nro = request.getParameter("asignatura_nro");

                    asi = dao.getById(asignatura_nro);
                    //lista_ppff = daoppff.getAll();
                    request.setAttribute("action", action);
                    // request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("vista", vista);
                    request.setAttribute("asignatura", asi);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    asignatura_nro = request.getParameter("asignatura_nro");
                    dao.delete(asignatura_nro);
                    response.sendRedirect("AsignaturaControlador");
                    break;
                case "view":

                    List<Asignatura> lista = dao.getAll();
                    request.setAttribute("asignatura", lista);
                    request.setAttribute("vista", "asignatura");
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

        String asignatura_nro = request.getParameter("asignatura_nro") != null ? request.getParameter("asignatura_nro") : null;
        String descripcion = request.getParameter("descripcion");
        String sigla = request.getParameter("sigla");

        Asignatura asi = new Asignatura();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        asi.setAsignatura_nro( asignatura_nro);
        asi.setDescripcion(descripcion);
        asi.setSigla(sigla);
        switch (action) {
            case "add":
                //Nuevo
                AsignaturaDAO dao = new AsignaturaDAOimpl();
                try {
                    dao.insert(asi);
                    request.setAttribute("vista", "asignatura");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("AsignaturaControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                AsignaturaDAO da = new AsignaturaDAOimpl();
                System.out.println(asi);
                try {
                    da.update(asi);
                    response.sendRedirect("AsignaturaControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
