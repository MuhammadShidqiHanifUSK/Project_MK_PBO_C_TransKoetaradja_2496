import java.util.ArrayList; // Import ArrayList dulu untuk nyimpan data penumpang di dalam bus Trans Koetaradja

public class Bus {

  // Atribut dasar Bus
  private ArrayList<Penumpang> penumpangBiasa; // ArrayList untuk menyimpan data penumpang biasa yang duduk di kursi bus
  private ArrayList<Penumpang> penumpangPrioritas; // ArrayList untuk menyimpan data penumpang prioritas yang duduk di kursi bus
  private ArrayList<Penumpang> penumpangBerdiri; // ArrayList untuk menyimpan data penumpang yang berdiri di dalam bus
  private static final int ONGKOS_BUS = 2000; // Ongkos bus untuk setiap penumpang
  private int totalPendapatan; // Total pendapatan bus dari seluruh penumpang yang membayar ongkos bus

  private static final int KAPASITAS_KURSI_PENUMPANG_BIASA = 16; // Kapasitas kursi untuk penumpang biasa
  private static final int KAPASITAS_KURSI_PENUMPANG_PRIORITAS = 4; // Kapasitas kursi untuk penumpang prioritas
  private static final int KAPASITAS_PENUMPANG_BERDIRI = 20; // Kapasitas penumpang yang berdiri di dalam bus
  private static final int KAPASITAS_TOTAL_BUS = KAPASITAS_KURSI_PENUMPANG_BIASA + KAPASITAS_KURSI_PENUMPANG_PRIORITAS + KAPASITAS_PENUMPANG_BERDIRI; // Kapasitas total bus

  // Method Konstruktor Bus
  public Bus(){
    penumpangBiasa = new ArrayList<>(); // Inisialisasi ArrayList penumpang biasa
    penumpangPrioritas = new ArrayList<>(); // Inisialisasi ArrayList penumpang prioritas
    penumpangBerdiri = new ArrayList<>(); // Inisialisasi ArrayList penumpang berdiri
    totalPendapatan = 0; // Inisialisasi total pendapatan bus dengan nilai
  }

  // Method Getter untuk mendapatkan total penumpang biasa
  public ArrayList<Penumpang> getPenumpangBiasa(){
    return this.penumpangBiasa; // Mengembalikan ArrayList penumpang biasa
  }

  // Method Getter untuk mendapatkan total penumpang prioritas
  public ArrayList<Penumpang> getPenumpangPrioritas(){
    return this.penumpangPrioritas; // Mengembalikan ArrayList penumpang prioritas
  }

  // Method Getter untuk mendapatkan total penumpang berdiri
  public ArrayList<Penumpang> getPenumpangBerdiri(){
    return this.penumpangBerdiri; // Mengembalikan ArrayList penumpang berdiri
  }

  // Method Getter untuk mendapatkan jumlah total penumpang biasa
  public int getJumlahPenumpangBiasa(){
    return this.penumpangBiasa.size(); // Mengembalikan jumlah total penumpang biasa dengan method size() dari ArrayList
  }

  // Method Getter untuk mendapatkan jumlah total penumpang prioritas
  public int getJumlahPenumpangPrioritas(){
    return this.penumpangPrioritas.size(); // Mengembalikan jumlah total penumpang prioritas dengan method size() dari ArrayList
  }

  // Method Getter untuk mendapatkan jumlah total penumpang berdiri
  public int getJumlahPenumpangBerdiri(){
    return this.penumpangBerdiri.size(); // Mengembalikan jumlah total penumpang berdiri dengan method size() dari ArrayList
  }

  // Method Getter untuk mendapatkan total pendapatan bus
  public int getTotalPendapatan(){
    return this.totalPendapatan; // Mengembalikan total pendapatan bus
  }

  public int getTotalPenumpang(){
    return this.getJumlahPenumpangBiasa() + this.getJumlahPenumpangPrioritas() + this.getJumlahPenumpangBerdiri();
  }

  public boolean naikkanPenumpang(Penumpang penumpang){
    // Cek apakah kapasitas bus sudah penuh ato blm
    if (getTotalPenumpang() >= KAPASITAS_TOTAL_BUS && penumpang.getSaldo() < ONGKOS_BUS){
      return false; // bakalan return false kalo bus penuh dan saldo penumpang nggak cukup
    }

    // Cek apakah penumpang termasuk penumpang prioritas ato bukan
    if (penumpang.isPenumpangPrioritas()){
      if (getJumlahPenumpangPrioritas() < KAPASITAS_KURSI_PENUMPANG_PRIORITAS){
        penumpangPrioritas.add(penumpang);
      } else if (getJumlahPenumpangBiasa() < KAPASITAS_KURSI_PENUMPANG_BIASA){
        penumpangBiasa.add(penumpang);
      } else if (getJumlahPenumpangBerdiri() < KAPASITAS_PENUMPANG_BERDIRI){
        penumpangBerdiri.add(penumpang);
      } else {
        return false; // bakalan return false, berarti busnya ud penuh
      }
    } else { // Penumpang bukan penumpang prioritas
      if (getJumlahPenumpangBiasa() < KAPASITAS_KURSI_PENUMPANG_BIASA){
        penumpangBiasa.add(penumpang);
      } else if (getJumlahPenumpangBerdiri() < KAPASITAS_PENUMPANG_BERDIRI){
        penumpangBerdiri.add(penumpang);
      } else {
        return false; // bakalan return false, berarti busnya ud penuh
      }
    }

    // Kurangi saldo penumpang dan tambahkan ke total pendapatan bus
    penumpang.kurangiSaldo(ONGKOS_BUS);
    totalPendapatan += ONGKOS_BUS;
    return true; // Penumpang boleh naik, yeahh :)
  }
}