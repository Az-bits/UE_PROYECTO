package com.emergentes.controlador;

import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.modelo.Persona;
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

@WebServlet(name = "PersonaControlador", urlPatterns = {"/PersonaControlador"})
public class PersonaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PersonaDAO dao = new PersonaDAOimpl();
            //PPFFDAO daoppff = new PPFFDAOimpl();
            String persona_nro;
            // String dato;
            //List<PPFF> lista_ppff = null;
            Persona per = new Persona();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";
            
            switch (action) {
                case "add":

                    //lista_ppff = daoppff.getAll();
                    //request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("action", action);
                    request.setAttribute("persona", per);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    persona_nro = request.getParameter("persona_nro");

                    per = dao.getById(persona_nro);
                    //lista_ppff = daoppff.getAll();
                    request.setAttribute("action", action);
                    // request.setAttribute("lista_ppff", lista_ppff);
                    request.setAttribute("vista", vista);
                    request.setAttribute("persona", per);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    persona_nro = request.getParameter("persona_nro");
                    dao.delete(persona_nro);
                    response.sendRedirect("PersonaControlador");
                    break;
                case "view":

                    List<Persona> lista = dao.getAll();
                    request.setAttribute("persona", lista);
                    request.setAttribute("vista", "persona");
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

        String persona_nro = request.getParameter("persona_nro") != null ? request.getParameter("persona_nro") : null;
        String ci = request.getParameter("ci");
        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String fecha_nac = request.getParameter("fecha_nac");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        Persona per = new Persona();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        per.setPersona_nro( persona_nro);
        per.setCi(ci);
        per.setNombre(nombre);
        per.setPaterno(paterno);
        per.setMaterno(materno);
        per.setFecha_nac(fecha_nac);
        per.setDireccion(direccion);
        per.setTelefono(telefono);
        System.out.println(fecha_nac);
        switch (action) {
            case "add":
                //Nuevo
                PersonaDAO dao = new PersonaDAOimpl();
                try {
                    dao.insert(per);
                    request.setAttribute("vista", "persona");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("PersonaControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                PersonaDAO da = new PersonaDAOimpl();
                System.out.println(per);
                try {
                    da.update(per);
                    response.sendRedirect("PersonaControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
