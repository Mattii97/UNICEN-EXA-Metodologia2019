package backend;

import frontend.Product;
import frontend.User;
import util.Pair;

import java.util.List;

public class EstadisticaPorBarrio implements CalculadoraEstadistica {

    private String barrio;

    public EstadisticaPorBarrio(String barrio){
        this.barrio=barrio;
    }

    @Override
    public double calcularKilos(Municipio municipio) {
        List<Pair<User, Pair<Product, Integer>>> aux = municipio.getAcopioAcumulado();
        double result;
        for()
        return result;
    }

    @Override
    public double calcularVolumen() {
        return 0;
    }
}
