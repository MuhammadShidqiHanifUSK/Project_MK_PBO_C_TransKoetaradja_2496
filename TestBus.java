import java.util.Scanner;

public class TestBus{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Deklarasi Scanner
    Bus bus = new Bus(); // Membuat objek Bus
    boolean status = true;

    while (status){
      System.out.println("==========MENU BUS TRANS KOETARADJA==========");
      System.out.println("1. Tambah Penumpang");
      System.out.println("2. Hapus Penumpang");
      System.out.println("3. Lihat Penumpang");
      System.out.println("4. Keluar");
      System.out.print("Pilih menu (1-4): ");

      int pilihan;
      try {
        pilihan = Integer.parseInt(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Input tidak valid. Silakan masukkan angka antara 1-4.");
        continue;
      }

      System.out.println();
      switch (pilihan){
        case 1:
          try {
            System.out.print("Masukkan ID Penumpang: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan Nama Penumpang: ");  
            String nama = scanner.nextLine();

            System.out.print("Masukkan Umur Penumpang: ");
            int umur = Integer.parseInt(scanner.nextLine());

            System.out.print("Apakah penumpang hamil (y/n)? ");
            String isHamil = scanner.nextLine().trim().toLowerCase();
            boolean hamil = (isHamil.equals("y"));

            System.out.print("Masukkan Saldo Penumpang: ");
            int saldo = Integer.parseInt(scanner.nextLine());

            Penumpang penumpangBaru = new Penumpang(id, nama, umur, hamil, saldo);
            boolean berhasil = bus.naikkanPenumpang(penumpangBaru);

            if (berhasil){
              System.out.println("Penumpang " + nama + " berhasil ditambahkan ke bus.");
            } else {
              System.out.println("Penumpang " + nama + " gagal ditambahkan ke bus (mungkin kapasitas penuh atau saldo tidak mencukupi).");
            }

          } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
          }
          System.out.println();
          break;
        
        case 2:
          System.out.print("Masukkan Nama Penumpang yang akan diturunkan: ");
          String namaTurun = scanner.nextLine();
          boolean berhasilTurun = bus.turunkanPenumpang(namaTurun);

          if (berhasilTurun){
            System.out.println("Penumpang " + namaTurun + " berhasil diturunkan dari bus.");
          } else {
            System.out.println("Penumpang " + namaTurun + " tidak ditemukan di bus.");
          }
          System.out.println();
          break;

        case 3:
          System.out.println(bus.toString());
          System.out.println();
          break;
        
        case 4:
          status = false;
          System.out.println("Terima kasih telah menggunakan layanan Bus Trans Koetaradja! By Shidqi :)");
          return;
        
        default:
          System.out.println("Pilihan tidak valid!\n");
      }
    }
  }
}