package ukdw.bva;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {   
        // Define Input User
        Scanner input = new Scanner(System.in);

        // Simpan Variabel
        double berat_badan = 0.0 , tinggi_badan = 0.0;

        // Print ==
        System.out.println("===============================================");
        System.out.println("");

        // Tinggi Badan | Simpan ke Variabel tinggi_badan
        System.out.println("Masukkan Tinggi Badan (dalam CM) - Sistem Otomatis Akan Convert ke satuan Meter : ");
        tinggi_badan = (input.nextDouble()) / 100;

        // Berat Badan | Simpan ke Variabel berat_badan
        System.out.println("Masukkan Berat Badan : ");
        berat_badan = input.nextDouble();

        // Print ==
        System.out.println("");
        System.out.println("===============================================");

        // Debugging
        System.out.println("Berat Badan : " + String.valueOf(berat_badan));
        System.out.println("Tinggi Badan : " + String.valueOf(tinggi_badan));

        // Print ==
        System.out.println("");

        // Hitung BMI
        double BMI = BMIService.hitungBMI(berat_badan, tinggi_badan);
        System.out.println("Nilai BMI Adalah " + String.valueOf(BMI));

        // Klasifikasi BMI
        String klasifikasi = BMIService.klasifikasiBMI(BMI);
        System.out.println("Klasifikasi BMI : " + klasifikasi);

        // Print ==
        System.out.println("");
        System.out.println("===============================================");

        // Close Scanner
        input.close();
    }
}
