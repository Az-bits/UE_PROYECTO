package com.emergentes.controlador;

import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Usuario;
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

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO dao = new UsuarioDAOimpl();
            PersonaDAO daoP = new PersonaDAOimpl();
            Usuario usu = new Usuario();

            List<Persona> per = daoP.getAll();
            
            String usuario_nro;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            String vista = (request.getParameter("vista") != null) ? request.getParameter("vista") : "Dashboard";

            switch (action) {
                case "add":

                    request.setAttribute("action", action);
                    request.setAttribute("usuario", usu);
                    request.setAttribute("persona", per);
                    request.setAttribute("vista", vista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "edit":
                    usuario_nro = request.getParameter("usuario_nro");
                    request.setAttribute("persona", per);
                    usu = dao.getById(usuario_nro);
                    request.setAttribute("action", action);
                    request.setAttribute("vista", vista);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "delete":
                    usuario_nro = request.getParameter("usuario_nro");
                    dao.delete(usuario_nro);
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "view":
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuario", lista);
                    request.setAttribute("vista", "usuario");
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

        String usuario_nro = request.getParameter("usuario_nro") != null ? request.getParameter("usuario_nro") : null;
        String persona_nro = request.getParameter("persona_nro");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contrasenia");
        String tipo_usuario = request.getParameter("tipo_usuario");
        String correo_electronico = request.getParameter("correo_electronico");
        
        Usuario usu = new Usuario();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        usu.setUsuario_nro(usuario_nro);
        usu.setPersona_nro(persona_nro);
        usu.setUsuario(usuario);
        usu.setContraseña(contraseña);
        usu.setTipo_usuario(tipo_usuario);
        usu.setCorreo_electronico(correo_electronico);
        switch (action) {
            case "add":
                //Nuevo
                UsuarioDAO dao = new UsuarioDAOimpl();
                try {
                    dao.insert(usu);
                    request.setAttribute("vista", "persona");
                    //request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    response.sendRedirect("UsuarioControlador");
                } catch (Exception ex) {

                    System.out.println("Error al insertar " + ex.getMessage());
                }
                break;
            case "edit":
                //Editar
                UsuarioDAO da = new UsuarioDAOimpl();
                System.out.println(usu);
                try {
                    da.update(usu);
                    response.sendRedirect("UsuarioControlador");
                } catch (Exception ex) {
                    System.out.println("Error al editar" + ex.getMessage());
                }
                break;
        }

    }

}
