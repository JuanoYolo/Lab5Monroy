import javax.faces.bean.*;
import java.util.ArrayList;
import java.lang.Math

@ApplicationScoped
@ManagedBean(name = "calculadoraBean")
public class AplicationBean {

    private List<Integer> datos = new ArrayList<>();
    private float promediofinal = 0;
    private float varianza = 0;
    private float desvestandatarfinal = 0;
    private float moda = 0;
    private int cantidadnum = 0;
    private float total = 0;

    public float calculateMean(ArrayList<Integer> promedio){
        cantidadnum = promedio.length;
        for(int i = 0 ; i<promedio.length; i++){
            total += promedio[i];
        }
        promediofinal = total/promedio.length;
        return promediofinal;
    }

    public float calculateVariance(ArrayList<Integer> lisvarianza){
        cantidadnum = lisvarianza.length;
        for(int i = 0 ; i<promedio.length; i++){
            media = calculateMean(lisvarianza)
            double rango;
            rango = Math.pow(valor[i] - media,2f);
            lisvarianza = lisvarianza + rango;
        }
        varianza = lisvarianza / promedio.length;
        return varianza;
    }

    public float calculateStandardDeviation(ArrayList<Integer> desvestandar){
        cantidadnum = desvestandar.length;
        float varianza = calculateVariance(desvestandar);
        desvestandatarfinal = Math.sqrt(varianza);
        return desvestandatarfinal;
    }



    public float calculateMode(ArrayList<Integer> lismoda){
        cantidadnum = lismoda.length;
        int maxValue, maxCount;

        for (int i = 0; i < lismoda.length; ++i) {
            int count = 0;
            for (int j = 0; j < lismoda.length; ++j) {
                if (lismoda[j] == lismoda[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = lismoda[i];
            }
        }
        moda = maxValue;
        return moda;
    }

    public void restart(){
        promediofinal, varianza, desvestandatarfinal, moda, cantidadnum, total = 0;
    }
}
