import javax.faces.bean.*;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.*;
import java.util.Arrays;

@ApplicationScoped
@ManagedBean(name = "calculadoraBean")
public class AplicationBean {

    protected ArrayList<String> datosString = new ArrayList<>();
    protected ArrayList<Integer> datos = new ArrayList<>();
    protected float promediofinal = 0;
    protected float varianza = 0;
    protected float desvestandatarfinal = 0;
    protected float moda = 0;
    protected int cantidadnum = 0;
    protected float total = 0;

    public float calculateMean(ArrayList<Integer> promedio){
        cantidadnum = promedio.size();
        for(int i = 0 ; i<promedio.size(); i++){
            total += promedio.get(i);
        }
        promediofinal = total/promedio.size();
        return promediofinal;
    }

    public float calculateVariance(ArrayList<Integer> lisvarianza){
        cantidadnum = lisvarianza.size();
        double media;
        float varia = 0;

        for(int i = 0 ; i<lisvarianza.size(); i++){
            media = calculateMean(lisvarianza);

            double rango;
            rango = Math.pow((lisvarianza.get(i)).doubleValue() - media,2f);
            varia = varia + (float)rango;
        }
        varianza = varia / lisvarianza.size();
        return varianza;
    }

    public float calculateStandardDeviation(ArrayList<Integer> desvestandar){
        cantidadnum = desvestandar.size();
        float varianza = calculateVariance(desvestandar);
        desvestandatarfinal = (float)Math.sqrt(varianza);
        return desvestandatarfinal;
    }



    public float calculateMode(ArrayList<Integer> lismoda){
        cantidadnum = lismoda.size();
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < lismoda.size(); ++i) {
            int count = 0;
            for (int j = 0; j < lismoda.size(); ++j) {
                if (lismoda.get(j) == lismoda.get(i)) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = lismoda.get(i);
            }
        }
        moda = maxValue;
        return moda;
    }

    public void restart(){
        promediofinal = 0;
        varianza = 0;
        desvestandatarfinal = 0;
        moda = 0;
        cantidadnum = 0;
        total = 0;
    }

    public void calbean(){
        datos = new ArrayList<>(Arrays.asList(datosString));
        calculateMean(datos);
        calculateVariance(datos);
        calculateStandardDeviation(datos);
        calculateMode(datos);
    }

    public ArrayList<Integer> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Integer> datos) {
        this.datos = datos;
    }

    public float getPromediofinal() {
        return promediofinal;
    }

    public void setPromediofinal(float promediofinal) {
        this.promediofinal = promediofinal;
    }

    public float getVarianza() {
        return varianza;
    }

    public void setVarianza(float varianza) {
        this.varianza = varianza;
    }

    public float getDesvestandatarfinal() {
        return desvestandatarfinal;
    }

    public void setDesvestandatarfinal(float desvestandatarfinal) {
        this.desvestandatarfinal = desvestandatarfinal;
    }

    public float getModa() {
        return moda;
    }

    public void setModa(float moda) {
        this.moda = moda;
    }

    public int getCantidadnum() {
        return cantidadnum;
    }

    public void setCantidadnum(int cantidadnum) {
        this.cantidadnum = cantidadnum;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<String> getDatosString() {
        return datosString;
    }

    public void setDatosString(ArrayList<String> datosString) {
        this.datosString = datosString;
    }
}
