package backend;

import java.util.HashMap;

import frontend.User;

public class UserManager {
    //atributos
    private HashMap<String, User> usuarios;
    static UserManager instance;

    //metodos

    // manejos de usuarios
    private UserManager() {
        this.usuarios = new HashMap<String, User>();
    }

    public static UserManager getInstance() {
        if (instance == null)
            instance = new UserManager();
        return instance;
    }

    public void addUser(User usuario) {
        usuarios.put(usuario.getMail(), usuario);
    }

    public void imprimirUsuarios() {
        System.out.println(usuarios);
    }

    public boolean existeUser(String mail){
        return usuarios.containsKey(mail);
    }

    public boolean validarPassword(String mail,String password){
        if(existeUser(mail)){
            return usuarios.get(mail).getPassword().equals(password);
        }
        return false;
    }

    public User getUser(String mail){
        if(existeUser(mail)){
            return usuarios.get(mail);
        }
        return null;
    }
}
