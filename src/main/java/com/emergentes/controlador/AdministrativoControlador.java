package com.emergentes.controlador;

import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.dao.AdministrativoDAO;
import com.emergentes.dao.AdministrativoDAOimpl;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Administrativo;
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

@WebServlet(name = "AdministrativoControlador", urlPatterns = {"/AdministrativoControlador"})
public class AdministrativoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AdministrativoDAO dao = new AdministrativoDAOimpl();
            PersonaDAO daoP = new PersonaDAOimpl();
            Administrativo admi = new Administrativo();

            List<Persona> per = daoP.getAll();
            
            String administrativo_nro;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("administrativo", admi);
                    request.setAttribute("persona", per);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    administrativo_nro = request.getParameter("administrativo_nro");
                    request.setAttribute("persona", per);
                    admi = dao.getById(administrativo_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("administrativo", admi);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    administrativo_nro = request.getParameter("administrativo_nro");
                    dao.delete(administrativo_nro);
                    response.sendRedirect("AdministrativoControlador");
                    break;
                case "view":
                    List<Administrativo> lista = dao.getAll();
                    request.setAttribute("administrativo", lista);
                    request.setAttribute("vista", "administrativo");
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

        String administrativo_nro = request.getParameter("administrativo_nro") != null ? request.getParameter("administrativo_nro") : null;
        String cargo = request.getParameter("cargo");
        String persona_nro = request.getParameter("persona_nro");
        
        Administrativo admi = new Administrativo();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        admi.setAdministrativo_nro(administrativo_nro);
        admi.setCargo(cargo);
        admi.setPersona_nro(persona_nro);
  
        switch (action) {
            case "add":
                //Nuevo
                AdministrativoDAO dao = new AdministrativoDAOimpl();
                try {
                    dao.insert(admi);
                    request.setAttribute("vista", "administrativo");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("AdministrativoControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                AdministrativoDAO da = new AdministrativoDAOimpl();
                try {
                    da.update(admi);
                    response.sendRedirect("AdministrativoControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
