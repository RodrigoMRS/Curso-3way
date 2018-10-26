package com.framework.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;
  

  
@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean {
  
      private UsuarioDAO usuarioDAO = new UsuarioDAO();
      private Usuario usuario = new Usuario();
      
       
      public String enviar() {
             
            usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
            if (usuario == null) {
                  usuario = new Usuario();
                  FacesContext.getCurrentInstance().addMessage(
                             null,
                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio n�o encontrado!",
                                         "Erro no Login!"));
                  return null;
            } else {
                  return "/inicial";
            }
             
             
      }
  
      public Usuario getUsuario() {
            return usuario;
      }
  
      public void setUsuario(com.framework.model.Usuario usuario) {
            this.usuario = usuario;
      }
}