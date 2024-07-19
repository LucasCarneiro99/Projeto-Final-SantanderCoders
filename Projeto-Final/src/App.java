import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] salariosBrutos = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salariosBrutos[i] = sc.nextDouble();
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            double salarioBruto = salariosBrutos[i];
            double inss = calcularINSS(salarioBruto);
            double impostoDeRenda = calcularImpostoDeRenda(salarioBruto);
            double salarioLiquido = salarioBruto - inss - impostoDeRenda;
            
            System.out.println("Salário bruto do funcionário " + (i + 1) + ": R$ " + String.format("%.2f", salarioBruto));
            System.out.println("Desconto de INSS: R$ " + String.format("%.2f", inss));
            System.out.println("Desconto de Imposto de Renda: R$ " + String.format("%.2f", impostoDeRenda));
            System.out.println("Salário líquido: R$ " + String.format("%.2f", salarioLiquido));
            System.out.println();
        }
        sc.close();
    }

    public static double calcularINSS(double salarioBruto) {
        double inss = 0.0;
        if (salarioBruto <= 1212.00) {
            inss = salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            inss = salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            inss =salarioBruto * 0.12;
        } else {
            inss = salarioBruto * 0.14;
        }
        return inss;
    }
    
    public static double calcularImpostoDeRenda(double salarioBase) {
        double impostoDeRenda = 0.0;
        if (salarioBase <= 1903.98) {
            impostoDeRenda = 0.0;
        } else if (salarioBase <= 2826.65) {
            impostoDeRenda = salarioBase*0.075;
        } else if (salarioBase <= 3751.05) {
            impostoDeRenda = salarioBase * 0.15;
        } else if (salarioBase <= 4664.68) {
            impostoDeRenda = salarioBase * 0.225;
        } else {
            impostoDeRenda = salarioBase * 0.275;
        }
        return impostoDeRenda;
    }
}
