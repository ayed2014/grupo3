/**
 * Created by Fran on 13/03/14.
 */
public class NumeroComplejo {

    private float parteReal;
    private  float parteImaginaria;
    private String numeroComplejo;

    public void lecturaDesdeElTeclado(float parteReal,float parteImaginaria){
        this.parteReal=parteReal;
        this.parteImaginaria=parteImaginaria;
        numeroComplejo=Float.toString(parteReal)+Float.toString(parteImaginaria)+"i";
    }

    public void  impresionPorPantalla(){
        System.out.println(numeroComplejo);
    }

    public String suma(float parteReal, float parteImaginaria){
        float parteReal2=this.parteReal+parteReal;
        float parteImmaginaria2=this.parteImaginaria+parteImaginaria;
        String numeroComplejo2=Float.toString(parteReal2)+"+"+Float.toString(parteImmaginaria2)+"i";
        return numeroComplejo2;
    }
    public String resta(float parteReal, float parteImaginaria){
        float parteReal2=this.parteReal-parteReal;
        float parteImmaginaria2=this.parteImaginaria-parteImaginaria;
        String numeroComplejo2=Float.toString(parteReal2)+"+"+Float.toString(parteImmaginaria2)+"i";
        return numeroComplejo2;
    }
    public String producto(float parteReal, float parteImaginaria){
        float numero1=this.parteReal*parteReal;
        float numero2=this.parteReal*(-parteImaginaria);
        float numero3=this.parteImaginaria*parteReal;
        float numero4=this.parteImaginaria*(-parteImaginaria);
        float parteReal2=numero1-numero4;
        float parteImmaginaria2=numero2+numero3;

        String numeroComplejo2=Float.toString(parteReal2)+"+"+Float.toString(parteImmaginaria2)+"i";
        return numeroComplejo2;
    }
    public String cociente(float parteReal, float parteImaginaria){
        float numero1=this.parteReal*parteReal;
        float numero2=this.parteReal*(-parteImaginaria);
        float numero3=this.parteImaginaria*parteReal;
        float numero4=this.parteImaginaria*(-parteImaginaria);
        float numero5=numero1-numero4;
        float numero6=numero2+numero3;
        float numero7=parteReal*parteReal;
        float numero8=-(parteImaginaria+parteImaginaria);
        float numero9=numero8+numero7;
        float parteReal2= numero5/numero9;
        float parteImmaginaria2=numero6/numero9;

                String numeroComplejo2=Float.toString(parteReal2)+"+"+Float.toString(parteImmaginaria2)+"i";
        return numeroComplejo2;
    }

    public String modulo(){
        if (parteReal<0){
            parteReal=parteReal*(-1);
        }
        if (parteImaginaria<0){
            parteImaginaria=parteImaginaria*(-1);
        }
        return Float.toString(parteReal)+"+"+Float.toString(parteImaginaria)+"i";
    }
    public float parteReal(){
       return parteReal;
    }
    public float parteImaginaria(){
        return parteImaginaria;
    }
}
class NumeroComplejoTester{
    public static void main(String[] args) {
        NumeroComplejo numero1=new NumeroComplejo();
        NumeroComplejo numero2=new NumeroComplejo();
        numero1.lecturaDesdeElTeclado(-2,-11);
        numero2.lecturaDesdeElTeclado(3,2);
        System.out.println("Suma:\n" + numero1.suma(numero2.parteReal(), numero2.parteImaginaria()));
        System.out.println("\nResta:\n"+numero1.resta(numero2.parteReal(), numero2.parteImaginaria()));
        System.out.println("\nMultiplicacion:\n"+numero1.producto(numero2.parteReal(),numero2.parteImaginaria()));
        System.out.println("\nDivision:\n"+numero1.cociente(numero2.parteReal(),numero2.parteImaginaria()));
        System.out.println("\nModulo:\n"+numero1.modulo());
     }
}
