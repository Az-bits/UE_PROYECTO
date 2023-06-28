package com.emergentes.controlador;

import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.dao.TutorDAO;
import com.emergentes.dao.TutorDAOimpl;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Tutor;
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

@WebServlet(name = "TutorControlador", urlPatterns = {"/TutorControlador"})
public class TutorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TutorDAO dao = new TutorDAOimpl();
            PersonaDAO daoP = new PersonaDAOimpl();
            Tutor tut = new Tutor();

            List<Persona> per = daoP.getAll();

            String tutor_nro;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":

                    request.setAttribute("action", action);
                    request.setAttribute("tutor", tut);
                    request.setAttribute("persona", per);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    tutor_nro = request.getParameter("tutor_nro");
                    request.setAttribute("persona", per);
                    tut = dao.getById(tutor_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("tutor", tut);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    tutor_nro = request.getParameter("tutor_nro");
                    dao.delete(tutor_nro);
                    response.sendRedirect("TutorControlador");
                    break;
                case "view":
                    List<Tutor> lista = dao.getAll();
                    request.setAttribute("tutor", lista);
                    request.setAttribute("vista", "tutor");
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

        String tutor_nro = request.getParameter("tutor_nro") != null ? request.getParameter("tutor_nro") : null;
        String parentesco = request.getParameter("parentesco");
        String persona_nro = request.getParameter("persona_nro");

        Tutor tut = new Tutor();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        tut.setTutor_nro(tutor_nro);
        tut.setParentesco(parentesco);
        tut.setPersona_nro(persona_nro);
        switch (action) {
            case "add":
                //Nuevo
                TutorDAO dao = new TutorDAOimpl();
                try {
                    dao.insert(tut);
                    request.setAttribute("vista", "tutor");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("TutorControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                TutorDAO da = new TutorDAOimpl();
                System.out.println(tut);
                try {
                    da.update(tut);
                    response.sendRedirect("TutorControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
