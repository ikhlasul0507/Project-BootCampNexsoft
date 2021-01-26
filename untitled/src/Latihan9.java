
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Worker5 {
    private int idKaryawan;
    private String namaKaryawan;
    private int tunjanganPulsa;
    private int gajiPokok;
    int absen;

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public int getTunjanganPulsa() {
        return tunjanganPulsa;
    }

    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public void setAbsen() {
        absen++;
    }

    public Worker5(int idKaryawan, String namaKaryawan, int tunjanganPulsa, int gajiPokok, int absen) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.tunjanganPulsa = tunjanganPulsa;
        this.gajiPokok = gajiPokok;
        this.absen = absen;
    }
}

class Staff5 extends Worker5 {

    private int tunjanganMakan;
    private int absen;
    ArrayList<String> email = new ArrayList<>();

    public Staff5(int idKaryawan, String namaKaryawan, int gajiPokok,int tunjanganPulsa,  int tunjanganMakan,
                  int absen) {
        super(idKaryawan, namaKaryawan, tunjanganPulsa, gajiPokok, absen);
        this.tunjanganMakan = tunjanganMakan;
        this.absen = absen;
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }
    public int hitungTunjanganMakan(){
        return tunjanganMakan * 20000 * getAbsen();
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }


    public int getAbsen() {
        return absen;
    }

    public void setAbsen() {
        absen++;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

}

class Manager5 extends Worker5 {
    private int tunjanganTransport;
    private int tunjanganEntertaint;
    int absen;

    ArrayList<String> handphone = new ArrayList<>();

    public Manager5(int idKaryawan, String namaKaryawan, int gajiPokok, int tunjanganPulsa, int tunjanganTransport,
                    int tunjanganEntertaint, int absen) {
        super(idKaryawan, namaKaryawan, tunjanganPulsa, gajiPokok, absen);
        this.tunjanganTransport = tunjanganTransport;
        this.tunjanganEntertaint = tunjanganEntertaint;
        this.absen = absen;
    }
    public int getAbsen() {
        return absen;
    }

    public void setAbsen() {
        absen++;
    }

    public int getTunjanganTransport() {
        return tunjanganTransport;
    }
    public int hitungTunjanganTransport(){
        return tunjanganTransport * 50000 * getAbsen();
    }

    public void setTunjanganTransport(int tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public int getTunjanganEntertaint() {
        if (tunjanganEntertaint==1) {
            return 0;
        }else{
            return tunjanganEntertaint;
        }
    }

    public ArrayList<String> getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone.add(handphone);
    }


    public int hitungTunjanganEntertaint(int lm){
        return tunjanganEntertaint = tunjanganEntertaint * lm * 500000;
    }
    public void setTunjanganEntertaint(int tunjanganEntertaint) {
        this.tunjanganEntertaint = tunjanganEntertaint;
    }
}

public class Latihan9 {

    static Scanner sc = new Scanner(System.in);
    static LinkedList<Staff5> st = new LinkedList<>();
    static LinkedList<Manager5> mn = new LinkedList<>();

    public static void menuData() {
        System.out.println("=========================");
        System.out.println("Pilihan Menu");
        System.out.println("1. Buat Object\n2. Cetak " +
                "JSON\n3. Lihat JSON\n4. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
    }

    public static void main(String[] args) throws IOException, ParseException {
        boolean aktif = true;
        do {
            menuData();
            int pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    //buat object
                    buatObject();
                    break;
                case 2:
                    laporanGaji();
                    break;
                case 3:
                    lihatJson();
                    break;
                default:
                    System.out.println("Program Selesai !");
                    aktif = false;
                    break;
            }
        } while (aktif);
    }

    static void buatObject() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                inputManager();
                break;
            case 2:
                inputStaff();
                break;
            default:
                break;
        }
    }

    static void laporanGaji() throws IOException {
        System.out.println("=========================");
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                laporanManager();
                buatJsonManajer();
                cetakJsonManajer();
                break;
            case 2:
                laporanStaff();
                buatJsonStaff();
                cetakJsonStaff();
                break;
            default:
                break;
        }
    }

    static void laporanManager() {
        Iterator itr2 = mn.iterator();
        System.out.println("================================================================");
        System.out.println("ID\tNama\tGaji Pokok\tT Pulsa\tT Transport\tT Entertaint\tAbsen");
        System.out.println("================================================================");
        while (itr2.hasNext()) {
            Manager5 km = (Manager5) itr2.next();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+
                    km.getGajiPokok()+"\t\t"+
                    km.getTunjanganPulsa()+"\t\t"+
                    km.hitungTunjanganTransport()+"\t\t"+
                    km.getTunjanganEntertaint()+"\t\t"+
                    km.absen);
        }
        System.out.println("================================================================\n");
    }

    static void buatJsonManajer() throws IOException {

        JSONArray jr = new JSONArray();
        JSONObject obj = new JSONObject();
        System.out.println("||--------------------------------------------------------");
        System.out.println("|| Hasil Cetak JSON FILE");
        System.out.println("||--------------------------------------------------------");


        Iterator itr2 = mn.iterator();
        while (itr2.hasNext()) {
            Manager5 km = (Manager5) itr2.next();
            obj.put("id", km.getIdKaryawan());
            obj.put("nama", km.getNamaKaryawan());
            obj.put("gajiPokok", km.getGajiPokok());
            obj.put("tPulsa", km.getTunjanganPulsa());
            obj.put("tTransport", km.getTunjanganTransport());
            obj.put("tEntertaint", km.getTunjanganEntertaint());
            obj.put("absen",km.getAbsen());
            String handphone = JSONValue.toJSONString(km.getHandphone());
            obj.put("handphone", handphone);

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            String jsontext = out.toString();
            jr.add(jsontext);

        }
        System.out.println("|| "+jr);

        System.out.println("||--------------------------------------------------------");
    }

    static void cetakJsonManajer() throws IOException {
        JSONArray jr = new JSONArray();
        JSONObject obj = new JSONObject();
        FileWriter file = new FileWriter("C:\\Users\\User\\IdeaProjects\\untitled\\src\\manajer.json");

        Iterator itr2 = mn.iterator();
        while (itr2.hasNext()) {
            Manager5 km = (Manager5) itr2.next();
            obj.put("id", km.getIdKaryawan());
            obj.put("nama", km.getNamaKaryawan());
            obj.put("gajiPokok", km.getGajiPokok());
            obj.put("tPulsa", km.getTunjanganPulsa());
            obj.put("tTransport", km.getTunjanganTransport());
            obj.put("tEntertaint", km.getTunjanganEntertaint());
            obj.put("absen", km.getAbsen());
            String handphone = JSONValue.toJSONString(km.getHandphone());
            obj.put("handphone", handphone);

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            String jsontext = out.toString();
            jr.add(jsontext);

        }
        file.write(String.valueOf(jr));

        file.close();
        System.out.println("Cetak File Success.....");
        System.out.println("||--------------------------------------------------------");
    }

    static void laporanStaff() {
        Iterator itr2 = st.iterator();
        System.out.println("================================================================");
        System.out.println("ID\tNama\tGaji Pokok\tT Pulsa\t\tT Makan\t\tAbsen");
        System.out.println("================================================================");
        while (itr2.hasNext()) {
            Staff5 km = (Staff5) itr2.next();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+
                    km.getGajiPokok()+"\t\t"+
                    km.getTunjanganPulsa()+"\t\t"+
                    km.hitungTunjanganMakan()+"\t\t"+
                    km.getAbsen());
        }
        System.out.println("================================================================");
    }

    static void buatJsonStaff() throws IOException {
        JSONArray jr = new JSONArray();
        JSONObject obj = new JSONObject();
        System.out.println("||--------------------------------------------------------");
        System.out.println("|| Hasil Cetak JSON FILE");
        System.out.println("||--------------------------------------------------------");
        Iterator itr2 = st.iterator();
        while (itr2.hasNext()) {
            Staff5 km = (Staff5) itr2.next();
            obj.put("id", km.getIdKaryawan());
            obj.put("nama", km.getNamaKaryawan());
            obj.put("gajiPokok", km.getGajiPokok());
            obj.put("tPulsa", km.getTunjanganPulsa());
            obj.put("tTransport", km.getTunjanganMakan());
            obj.put("absen", km.getAbsen());
            String email = JSONValue.toJSONString(km.getEmail());
            obj.put("email", email);
            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            String jsontext = out.toString();
            jr.add(jsontext);

        }
        System.out.println("|| "+jr);

        System.out.println("||--------------------------------------------------------");
    }

    static void cetakJsonStaff() throws IOException {
        JSONArray jr = new JSONArray();
        JSONObject obj = new JSONObject();
        FileWriter file = new FileWriter("C:\\Users\\User\\IdeaProjects\\untitled\\src\\staff.json");

        Iterator itr2 = st.iterator();
        while (itr2.hasNext()) {
            Staff5 km = (Staff5) itr2.next();
            obj.put("id", km.getIdKaryawan());
            obj.put("nama", km.getNamaKaryawan());
            obj.put("gajiPokok", km.getGajiPokok());
            obj.put("tPulsa", km.getTunjanganPulsa());
            obj.put("tMakan", km.getTunjanganMakan());
            obj.put("absen", km.getAbsen());
            String email = JSONValue.toJSONString(km.getEmail());
            obj.put("email", email);
            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            String jsontext = out.toString();
            jr.add(jsontext);

        }
        file.write(String.valueOf(jr));
        file.close();
        System.out.println("Cetak File Success.....");
        System.out.println("||--------------------------------------------------------");
    }

    static void lihatJson() throws IOException, ParseException {
        System.out.println("=========================");
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                lihatJsonManajer();
                break;
            case 2:
                lihatJsonStaff();
                break;
            default:
                break;
        }
    }

    static void lihatJsonManajer() throws IOException, ParseException {

        FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\untitled\\src\\manajer.json");
        BufferedReader bfr = new BufferedReader(fr);

        String dataJson = bfr.readLine();
        JSONParser parser = new JSONParser();
        Object objStaff = parser.parse(String.valueOf(dataJson));
        JSONArray arrayStaff = (JSONArray) objStaff;

        for (Object mn : arrayStaff){
            Object objct= parser.parse(String.valueOf(mn));
            JSONObject objDataStaff =(JSONObject) objct;
            System.out.println("---------------------------------------");
            System.out.println("|| ID           : "+objDataStaff.get("id"));
            System.out.println("|| Nama         : "+objDataStaff.get("nama"));
            System.out.println("|| Gaji Pokok   : "+objDataStaff.get("gajiPokok"));
            System.out.println("|| T Pulsa      : "+objDataStaff.get("tPulsa"));
            System.out.println("|| T Transport  : "+objDataStaff.get("tTransport"));
            System.out.println("|| T Entertaint : "+objDataStaff.get("tEntertaint"));
            String strEmail = (String) objDataStaff.get("handphone");
            Object objEmail = parser.parse(strEmail);
            JSONArray arrayEmail = (JSONArray) objEmail;
            int i = 0;
            for (Object handphone : arrayEmail){
                if (i == 0){
                    System.out.print("|| Handphone    : "+(i+1)+". "+handphone + "\n");
                }else{
                    System.out.print("||              : "+(i+1)+". "+handphone + "\n");
                }
                i++;
            }
            i = 0;
            System.out.println("---------------------------------------");
        }
    }
    static void lihatJsonStaff() throws IOException, ParseException {
        FileReader fr = new FileReader("C:\\Users\\User\\IdeaProjects\\untitled\\src\\staff.json");
        BufferedReader bfr = new BufferedReader(fr);

        String dataJson = bfr.readLine();
        JSONParser parser = new JSONParser();
        Object objStaff = parser.parse(dataJson);
        JSONArray arrayStaff = (JSONArray) objStaff;


        System.out.println("------------------------------------------------------------------------------");
        System.out.println("ID\tNama\t\t\tGaji\t\t\tT Pulsa\t\t\tEmail");
        System.out.println("------------------------------------------------------------------------------");

        for (Object o : arrayStaff){
            JSONObject objDataStaff =(JSONObject) o;
            System.out.print(objDataStaff.get("id") + "\t" +
                    objDataStaff.get("nama") + "\tRp. " +
                    objDataStaff.get("gajiPokok") + "\t\tRp. " +
                    objDataStaff.get("tPulsa") + "\t\tRp. ");
            String strEmail = (String) objDataStaff.get("email");
            Object objEmail = parser.parse(strEmail);
            JSONArray arrayEmail = (JSONArray) objEmail;
            int i = 0;
            for (Object m : arrayEmail){
                if (i == 0){
                    System.out.print("\t\t" + m + "\n");
                }else{
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + m + "\n");
                }
                i++;
            }
            i = 0;
        }
    }

    static void inputManager() {
        System.out.print("Masukan Jumlah Data :");
        int jml = sc.nextInt();
        System.out.println("=========================");
        for (int i = 0; i < jml; i++) {
            System.out.print("ID : ");
            int idm = sc.nextInt();
            System.out.print("Nama : ");
            String nmm = sc.next();
            System.out.print("Gaji Pokok : ");
            int gpm = sc.nextInt();
            System.out.print("Tunjangan Pulsa : ");
            int tpm = sc.nextInt();

            mn.add(new Manager5(idm, nmm, gpm, tpm, 1, 1, 0));

            int index = mn.size()-1;
            System.out.print("Jumlah No Handphone :");
            int jumlahHanpdhone = sc.nextInt();
            for (int j=0;j<jumlahHanpdhone;j++){
                System.out.print("Masukan No Handhpone : ");
                String handphone = sc.next();
                mn.get(index).setHandphone(handphone);
            }
            System.out.println("=========================");

        }
    }

    static void inputStaff() {
        System.out.print("Masukan Jumlah Data :");
        int jml = sc.nextInt();
        System.out.println("=========================");
        for (int i = 0; i < jml; i++) {
            System.out.print("ID : ");
            int ids = sc.nextInt();
            System.out.print("Nama : ");
            String nms = sc.next();
            System.out.print("Gaji Pokok : ");
            int gps = sc.nextInt();
            System.out.print("Tunjangan Pulsa : ");
            int tps = sc.nextInt();
            st.add(new Staff5(ids, nms, gps, tps, 1, 0));

            int index = st.size()-1;
            System.out.print("Jumlah Email :");
            int jumlahEmail = sc.nextInt();
            for (int j=0;j<jumlahEmail;j++){
                System.out.print("Masukan Email : ");
                String email = sc.next();
                st.get(index).setEmail(email);
            }
            System.out.println("=========================");
        }
    }

    static void hitungGaji() {
        System.out.println("1. Manager\n2. Staff");
        System.out.print("Pilih :");
        int jml = sc.nextInt();
        switch (jml) {
            case 1:
                gajiManager();
                break;
            case 2:
                gajiStaff();
                break;
            default:
                break;
        }
    }

    static void gajiManager() {
        Iterator itr2 = mn.iterator();
        System.out.println("======================");
        System.out.println("ID\tNama\tGaji Pokok");
        System.out.println("======================");
        int totalGaji =0;
        while (itr2.hasNext()) {
            Manager5 km = (Manager5) itr2.next();
            int total =
                    km.getGajiPokok()+km.getTunjanganPulsa()+km.hitungTunjanganTransport()+km.getTunjanganEntertaint();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+total);
            totalGaji = totalGaji + total;
        }
        System.out.println("=======================");
        System.out.println("Total :Rp."+ totalGaji);
        System.out.println("=======================");
    }

    static void gajiStaff() {
        Iterator itr2 = st.iterator();
        System.out.println("======================");
        System.out.println("ID\tNama\tGaji Pokok");
        System.out.println("======================");
        int totalGaji=0;

        while (itr2.hasNext()) {
            Staff5 km = (Staff5) itr2.next();
            int total = km.getGajiPokok()+ km.hitungTunjanganMakan()+ km.getTunjanganPulsa();
            System.out.println(km.getIdKaryawan() + "\t" +
                    km.getNamaKaryawan()+"\t"+ total);
            totalGaji = totalGaji + total;
        }
        System.out.println("=======================");
        System.out.println("Total :Rp. "+ totalGaji);
        System.out.println("=======================");

    }

}
