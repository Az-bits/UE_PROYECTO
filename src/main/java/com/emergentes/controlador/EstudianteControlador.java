package com.emergentes.controlador;

import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.dao.TutorDAO;
import com.emergentes.dao.TutorDAOimpl;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Estudiante;
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

@WebServlet(name = "EstudianteControlador", urlPatterns = {"/EstudianteControlador"})
public class EstudianteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            PersonaDAO daoP = new PersonaDAOimpl();
            TutorDAO daoT = new TutorDAOimpl();

            Estudiante es = new Estudiante();

            List<Persona> per = daoP.getAll();
            List<Tutor> tut = daoT.getAll();

            String estudiante_nro;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("estudiante", es);
                    request.setAttribute("tutor", tut);
                    request.setAttribute("persona", per);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    estudiante_nro = request.getParameter("estudiante_nro");
                    request.setAttribute("persona", per);
                    es = dao.getById(estudiante_nro);
                    //es = dao.getById(estudiante_nro);
                    request.setAttribute("tutor", tut);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("estudiante", es);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    estudiante_nro = request.getParameter("estudiante_nro");
                    dao.delete(estudiante_nro);
                    response.sendRedirect("EstudianteControlador");
                    break;
                case "view":
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiante", lista);
                    request.setAttribute("vista", "estudiante");
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

        String estudiante_nro = request.getParameter("estudiante_nro") != null ? request.getParameter("estudiante_nro") : null;
        int rude = Integer.parseInt(request.getParameter("rude"));
        String tutor_nro = request.getParameter("tutor_nro");
        String persona_nro = request.getParameter("persona_nro");

        Estudiante es = new Estudiante();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        es.setEstudiante_nro(estudiante_nro);
        es.setRude(rude);
        es.setTutor_nro(tutor_nro);
        es.setPersona_nro(persona_nro);

        switch (action) {
            case "add":
                //Nuevo
                EstudianteDAO dao = new EstudianteDAOimpl();
                try {
                    dao.insert(es);
                    request.setAttribute("vista", "estudiante");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("EstudianteControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                EstudianteDAO da = new EstudianteDAOimpl();
                try {
                    da.update(es);
                    response.sendRedirect("EstudianteControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
