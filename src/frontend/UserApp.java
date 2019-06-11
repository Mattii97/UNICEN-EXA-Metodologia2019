package frontend;

import backend.UserManager;
import util.Pair;

import java.time.LocalDate;
import backend.ProductManager;
import backend.Mapa;

public class UserApp {
    private UserManager userManager;
    private boolean logeado;
    private User usuario;
    private Mapa mapa;
    private ProductManager productManager;

    public UserApp(){
        this.userManager=UserManager.getInstance();
        this.mapa = Mapa.getInstance();
        this.productManager = ProductManager.getInstance();
        this.logeado = false;
        this.usuario = null;
    }

    public void login(String mail, String pass) {
    	if ((this.userManager.existeUser(mail)) && !this.logeado) {
    		if (this.userManager.validarPassword(mail,pass)) {
    			this.logeado = true;
    			this.usuario = this.userManager.getUser(mail);
    			this.usuario.addActivity(LocalDate.now());
    		}
    	}
    }
    
    public void verMapa() {
    	this.mapa.mostrar();
    }
    
    public double calcularEstadisticas() {
    	if (this.logeado)
    		return this.usuario.getCantEnPeso();
    	return 0;
    }

    
    public void signIn(String nombre, String apellido, String mail, String pass, String domicilio, String barrio, int dni) {
    	if (!this.userManager.existeUser(mail) && !this.logeado) {
    		User aux = new User(nombre, apellido, domicilio, barrio, pass, mail, dni);
    		userManager.addUser(aux);
			login(mail, pass);
    	}
    }
    
    
    public void logOut() {
    	this.usuario = null;
    	this.logeado = false;
    }
    
    public void verAhorro() {
    	// Hacer simulacion, mensajes con municipio
    }
    
    
    public void verCronograma() {
    	// Hacer simulacion, mensajes con municipio
    }
    
    public void verAyudaONG() {
    	// Hacer simulacion, mensajes con municipio
    }
    
    public void addProduct(String codBarras, Integer cant) {
    	if ((this.productManager.existeProducto(codBarras)) && this.logeado) {
    		Product p = this.productManager.getProducto(codBarras);
            Pair<Product, Integer> pAux = new Pair<Product, Integer>(p,cant);
    		this.usuario.addAcopio(pAux);
    	}
    }
    
}
