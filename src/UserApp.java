import backend.UserManager;
import etc.User;
import java.time.LocalDate;

public class UserApp {
    private UserManager userManager;
    private boolean logeado;
    private User usuario;
    private Mapa mapa;
    private ProductManager productManager;

    public UserApp(){
        this.userManager=UserManager.getInstance();
        this.mapa = Mapa.getIntance();
        this.productManager = ProductManager.getInstance();
        this.logeado = false;
        this.usuario = usuario;
    }

    public void login(String mail, String pass) {
    	if (this.userManager.existeUser(mail)) {
    		if (this.userManager.validarPassword(pass)) {
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
    	return this.usuario.getPromedio();
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
    
    public void addProduct(String codBarras, int cant) {
    	if (this.productManager.existeProducto(codBarras)) {
    		Product p = this.productManager.getProducto(codBarras);
    		Pair <p, cant> pAux;
    		this.usuario.addAcopio(pAux);
    	}
    }
    
}