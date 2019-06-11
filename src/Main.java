import backend.UserManager;
import frontend.UserApp;
import frontend.User;
import backend.ProductManager;
import frontend.Product;

public class Main {
        private static ProductManager productManager;
        private static UserManager userManager;
        private static UserApp userApp;


        public static void main(String[] args) {
                inicializar();
                escenario1();
        }

        public static void inicializar() {
                productManager = ProductManager.getInstance();
                userManager = UserManager.getInstance();
                userApp = new UserApp();
                User flizalde = new User("Facundo Manuel", "Lizalde Frias", "Alsina 70", "No barrio", "notelavoyadecir", "facundolizalde@gmail.com", 39671568);
                User sur = new User("Facundo", "Martinez Abalo", "Costa Rica 562", "Terminal", "contrasenia", "ilovepenguins@gmail.com", 38957200);
                User pela = new User("Eliel Arturo", "Catauro Nardela", "Mirage 123", "Mirage", "dizleccia", "tubizcochito@gmail.com", 39423084);
                User mati = new User("Matias", "Morandeira Lucero", "Alem 674", "Terminal", "horaciolovenohomo", "matimoran@gmail.com", 40020042);
                User juan = new User("Juan Pablo", "Correa Divitto", "Rosales 2283", "Villa Aguirre", "suplente4ever", "juampicorrea21@gmail.com", 41324982);
                userManager.addUser(flizalde);
                userManager.addUser(sur);
                userManager.addUser(pela);
                userManager.addUser(mati);
                userManager.addUser(juan);
                Product p1 = new Product("00000001", "Botella plastica 2,25", 0.500, 0.2, "plastico");
                Product p2 = new Product("00000002", "Paquete de yerba", 0.1, 0.01, "papel");
                Product p3 = new Product("00000003", "Latita bebida", 0.1, 0.02, "aluminio");
                Product p4 = new Product("00000004", "Tapita plastica", 0.05, 0.005, "plastico");
                Product p5 = new Product("00000005", "Envase desodorante", 0.2, 0.02, "aluminio");
                Product p6 = new Product("00000006", "Botella plastica 1,5", 0.25, 0.1, "plastico");
                Product p7 = new Product("00000007", "Botella plastica 0,5", 0.1, 0.05, "plastico");
                productManager.addProduct(p1);
                productManager.addProduct(p2);
                productManager.addProduct(p3);
                productManager.addProduct(p4);
                productManager.addProduct(p5);
                productManager.addProduct(p6);
                productManager.addProduct(p7);
        }

        public static void escenario1(){
                userManager.imprimirUsuarios();
                userApp.login("sofimangaterra@gmail.com", "123456789"); //Cuenta no existente por lo que no se puede logear
                userApp.addProduct("00000001", 3);//SIMULAR QUE LA APP LE DICE QUE NO EXISTE CUENTA POR LO QUE NO PUEDE REGISTRAR ACOPIO
                userApp.signIn("Sofia", "Mangaterra", "sofimangaterra@gmail.com", "123456789", "Calle 123", "Mirage", 40124452);
                userApp.addProduct("00000001", 3);
                userApp.addProduct("00000002", 1);
                userApp.addProduct("00000004", 4);
                userApp.addProduct("01230914", 5); //Producto no existente (Emula producto no reciclable)
                userApp.addProduct("91249344", 3); //Producto no existente (Emula producto no reciclable)
                System.out.println(userApp.calcularEstadisticas() + "kg");
        }
        
        
        public static void escenario2(){
        	
        }
        
        
}
