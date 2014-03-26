/**
 * Created by Fran on 13/03/14.
 */
public class Estudiante {

    private String matricula;
    private int cuota;

     public Estudiante(){}


    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    public  String getMatricula(){
        return matricula;
    }
    public void setCuota(int cuota){
        this.cuota=cuota;
    }
    public int getCuota(){
        return cuota;
    }

}
class TesterEstudiante{
    public static void main(String[] args) {
        Estudiante estudiante=new Estudiante();
        estudiante.setCuota(1000);
        estudiante.setMatricula("A001");
        System.out.println("Cuota:"+estudiante.getCuota()+"\nMatricula:"+estudiante.getMatricula());
    }
        }
