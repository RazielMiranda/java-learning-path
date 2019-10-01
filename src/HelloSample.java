import java.lang.reflect.Array;

public class HelloSample {

    static void funcao(String letras) {
        System.out.println("teste da funcao = " + letras);
    }

    static  void metodo(){
        System.out.println("Oi eu sou o metodo!");
    }


    public static void main(String[] args){

        int x = 10;
        int y = 87;
        int contador = 0;
        int[] vetornumeros = { 1 , 2, 4, 59273};
        int z = x + y;

        if(z > 97){
            System.out.println("z é maior que 97");
        }else{
            System.out.println("z é menor que 97");
        }

        while(contador < 10){
            contador++;
            System.out.println(contador);
        }

        for (contador = 0; contador < vetornumeros.length; contador++){
            System.out.println(vetornumeros[contador]);
        }

        System.out.println(vetornumeros[3]);
        String letras = "eu sou varias letras";

        funcao("Estou sendo passado de parametro para a função :)");
        metodo();
    }

}
