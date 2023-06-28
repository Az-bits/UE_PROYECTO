package com.emergentes.controlador;

import com.emergentes.dao.TurnoDAO;
import com.emergentes.dao.TurnoDAOimpl;
import com.emergentes.modelo.Turno;
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

@WebServlet(name = "TurnoControlador", urlPatterns = {"/TurnoControlador"})
public class TurnoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TurnoDAO dao = new TurnoDAOimpl();
            String turno_nro;
            Turno tur = new Turno();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":
                    request.setAttribute("action", action);
                    request.setAttribute("turno", tur);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    turno_nro = request.getParameter("turno_nro");

                    tur = dao.getById(turno_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("turno", tur);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    turno_nro = request.getParameter("turno_nro");
                    dao.delete(turno_nro);
                    response.sendRedirect("TurnoControlador");
                    break;
                case "view":

                    List<Turno> lista = dao.getAll();
                    request.setAttribute("turno", lista);
                    request.setAttribute("vista", "turno");
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

        String turno_nro = request.getParameter("turno_nro") != null ? request.getParameter("turno_nro") : null;
        String turno = request.getParameter("turno");
        String entrada = request.getParameter("entrada");
        String salida = request.getParameter("salida");

        Turno tur = new Turno();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        tur.setTurno_nro(turno_nro);
        tur.setTurno(turno);
        tur.setEntrada(entrada);
        tur.setSalida(salida);
        switch (action) {
            case "add":
                //Nuevo
                TurnoDAO dao = new TurnoDAOimpl();
                try {
                    dao.insert(tur);
                    request.setAttribute("vista", "turno");
                    response.sendRedirect("TurnoControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                TurnoDAO da = new TurnoDAOimpl();
                System.out.println(tur);
                try {
                    da.update(tur);
                    response.sendRedirect("TurnoControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
