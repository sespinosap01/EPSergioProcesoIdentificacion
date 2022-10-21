/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "ControladorDatos", urlPatterns = {"/ControladorDatos"})
public class ControladorDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ESTA SENTENCIA NO SIRVE PARA NADA YA QUE EN EL CONTROLADOR NO SE VA A GENERAR CÓDIGO HTML
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "JSP/inicio.jsp";
        // ES POSIBLE QUE LA COOKIE YA EXISTA
        Cookie cookieUsuario = new Cookie("nombreUsuario", request.getParameter("usuario"));
        response.addCookie(cookieUsuario);
        cookieUsuario.setMaxAge(60*60*24); //duracion 24H 
        // ESTA OPERACIÓN SÓLO SE TIENE QUE HACER CUANDO LAS CREDENCIALES DE ACCESO SON CORRECTAS
        if(request.getParameter("recordar")==null){
            cookieUsuario.setMaxAge(0);
            response.addCookie(cookieUsuario);
        }
        // CUANDO HEMOS GUARDADO EL NOMBRE DE USUARIO Y LAS CREDENCIALES SON INCORRECTAS AL VOLVER AL index NO APARECE
        // NO LLEVAS EL CONTROL DE LA ÚLTIMA VISITA
        
        String mensajeError = " ";
        // TIENES QUE CAMBIAR LA CONDICIÓN PARA NO TENER LA PARTE DEL SI VACÍA
        if(request.getParameter("usuario").equals("Sergio") && request.getParameter("password").equals("Sergio")){
            // CUANDO LAS CREDENCIALES SON CORRECTAS DEBES PONER LAS CREDENCIALES EN UN BEAN Y AÑADIRLAS A LA SESIÓN
        }else{
            // ESTE MENSAJE DEBERÍA SER Usuario no identificado
                mensajeError = "Datos Erroneos";
                request.setAttribute("error", mensajeError);
                // UTILIZAS VARIAS SENTENCIAS getRequestDispatcher
                request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
