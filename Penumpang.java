public class Penumpang {
  // Atribut dasar Penumpang
  private int id; // ID unik untuk setiap penumpang pada Bus Trans Koetaradja
  private int umur; // Umur penumpang dalam satuan integer tahun
  private boolean hamil; // Status kehamilan penumpang, True = Penumpang hamil, False = Penumpang tidak hamil
  private int saldo; // Saldo uang yang dimiliki penumpang

  // Method Konstruktor Penumpang
  public Penumpang(int id, int umur, boolean hamil, int saldo) {
    if (id <= 0){ // Validasi ID penumpang tidak boleh negatif atau nol
      throw new IllegalArgumentException("ID tidak boleh negatif atau nol! Harus > 0!");
    }

    if (umur < 0){ // Validasi umur penumpang tidak boleh negatif
      throw new IllegalArgumentException("Umur tidak boleh negatif!");
    }

    this.id = id; // Inisialisasi atribut ID penumpang
    this.umur = umur; // Inisialisasi atribut umur penumpang
    this.hamil = hamil; // Inisialisasi atribut status kehamilan penumpang
    this.saldo = 10000; // Inisialisasi atribut saldo penumpang dengan nilai awal 10000
  }

  // Method Getter untuk mendapatkan ID penumpang
  public int getId() {
    return this.id;
  }

  // Method Getter untuk mendapatkan umur penumpang
  public int getUmur() {
    return this.umur; // Mengembalikan umur penumpang (dalam satuan integer tahun)
  }

  // Method Getter untuk mendapatkan status kehamilan penumpang
  public boolean getHamil() {
    return this.hamil; // Mengembalikan status kehamilan penumpang (True/False)
  }

  // Method Getter untuk mendapatkan saldo penumpang
  public int getSaldo() {
    return this.saldo; // Mengembalikan saldo penumpang (dalam satuan integer)
  }

  // Method behavior untuk menambah saldo penumpang
  public void tambahSaldo(int saldoBaru){
    if (saldoBaru < 0){ // Validasi saldo baru yang ditambahkan tidak boleh negatif
      throw new IllegalArgumentException("Saldo baru tidak boleh negatif!");
    }

    this.saldo += saldoBaru; // Menambahkan saldo baru ke saldo penumpang, sama bentuknya dengan saldo = saldo + saldoBaru
  }

  // Method behavior untuk mengurangi saldo penumpang
  public void kurangiSaldo(int ongkos){
    if (ongkos < 0){ // Validasi ongkos yang akan dikurangi tidak boleh negatif
      throw new IllegalArgumentException("Ongkos tidak boleh negatif!");
    }

    this.saldo -= ongkos; // Mengurangi saldo penumpang dengan ongkos, sama bentuknya dengan saldo = saldo - ongkos
  }

  // Method untuk mengecek apakah penumpang termasuk penumpang prioritas atau tidak
  public boolean isPenumpangPrioritas(){
    return (this.umur > 60 || this.umur < 10 || this.hamil); // Mengembalikan True jika penumpang prioritas, False jika bukan penumpang prioritas
  }
}