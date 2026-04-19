package ukdw.bva;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


/**
    1. Test dengan parameterized untuk menghitung BMI seseorang dengan tinggi badan dan
        berat tertentu.. Ingat, ada batas maksimal tinggi (m) dan berat (kg) seseorang.
        Buat dahulu untuk rentang nilai dengan EP dan BVA

    2. Jika berat dan tinggi negative akan melemparkan exception

    3. Jika berat dan tinggi 0, maka test akan dihentikan
 */

public class AppTest {

    // Before All Sebelum memulai Test ( Dijalankan Pertama kali )
    @BeforeAll
    static void SetupProgram() {
        
        System.out.println("======== MULAI PENGUJIAN BMI ========");
    }

    // 1. Test Menghitung BMI Seseorang sesuai dengan BVA dan EP
    //=======================================================================
    @ParameterizedTest
    @CsvSource({
        "650, 3",       //Baris 1: Batas EP dan BVA Atas
        "20, 1",        //Baris 2: Batas EP dan BVA Bawah
        "70.0, 1.75",   //Baris 3: EP Tengah (Kategori Normal)
        "150.0, 1.60",  //Baris 4: EP Tengah (Kategori Obesitas)
        "21.0, 1.1"     //Baris 5: BVA paling minimum (naik 1 angka)
    })

    void HitungBMI(double badan, double tinggi){
        
        double hasil_bmi = BMIService.hitungBMI(badan, tinggi);
        String kategori_bmi = BMIService.klasifikasiBMI(hasil_bmi);

        //Check Hasil BMI supaya tidak < 0 perhitungannya
        assumeTrue(hasil_bmi > 0);

        System.out.println("Hasil Perhitungan BMI dari Tinggi Badan " + tinggi + " M dan Berat Badan " + badan + " adalah " + hasil_bmi);
        // Hasil Perhitungan BMI dari Tinggi Badan 150 cm dan Berat Badan 25 KG adalah 20
        System.out.println("kategori BMI adalah " + kategori_bmi);

    }

    //======================================================================

    // 2. Jika berat dan tinggi negative akan melemparkan exception
    //=======================================================================
    // Bagian Test Negative Berat dan tinggi
    @ParameterizedTest
    @CsvSource({
        "65.0, -2.5",       // Baris 1: berat 65, tinggi -2.5
        "-65.0, 2.5",       // Baris 2: berat -65, tinggi 2.5
        "-65.0, -2.5",      // Baris 3: berat -65, tinggi -2.5
        "65.0, 2.5"         // Baris 4: Positif semua
    })

    // Jika berat dan tinggi negative akan melemparkan exception
    void Test_Negatif_Berat_Tinggi(double berat, double tinggi){
        assertThrows(IllegalArgumentException.class, () -> {
            BMIService.hitungBMI(berat, tinggi);
        });
    }
    //=======================================================================


    // 3. Jika berat dan tinggi 0, maka test akan dihentikan
    //=======================================================================
    // Bagian Test 0 berat badan dan tinggi 
    @ParameterizedTest
    @CsvSource({
        "0, 2.5",       // Baris 1: berat 0, tinggi -2.5
        "65.0, 0",      // Baris 2: berat 65, tinggi 0
        "0, 0",         // Baris 3: berat 0, tinggi 0
        "50, 3"         // Baris 4: Lebih besar dari 0 semua
    })

    // Jika berat dan tinggi 0, maka test akan dihentikan
    void Test_Nol_Berat_Tinggi(double berat, double tinggi){
        boolean hasil;
        if(berat > 0 && tinggi > 0){
            hasil = true;
        } else if ( berat == 0 && tinggi == 0){
            hasil = false;
        } else {
            hasil = false;
        }

        // Jika Berhasil Lanjut || Jika Gagal Berhenti
        assumeTrue(hasil);

        // Jika assumeTrue Berhasil Code ini dijalankan || Jika Tidak Berhenti
        double operasi = BMIService.hitungBMI(berat, tinggi);
        String klasifikasi = BMIService.klasifikasiBMI(operasi);
        System.out.println("Hasil Perhitungan BMI : " + operasi);
        System.out.println("Klasifikasi BMI : " + klasifikasi);

    }
    //=======================================================================

    // Setelah Semua Program Test Dijalankan
    @AfterAll
    static void EndProgram() {
        System.out.println("======== SELESAI PENGUJIAN BMI ========");
    }

}
