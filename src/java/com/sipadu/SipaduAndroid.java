/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sipadu;

import java.security.MessageDigest;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Septiawan Aji
 

/**
 *
 * @author Septiawan Aji
 */
@WebService(serviceName = "NewWebService")
public class SipaduAndroid{
    
    //enkripsi md5 untuk password saat login
     public String ubahJadiMD5(String password){
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();
            
            StringBuffer hexString = new StringBuffer();
            for(int i=0;i<messageDigest.length;i++){
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
     }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNama")
    public String getNama(@WebParam(name = "nim") String nim) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();
        
        //query nama,kelas,dan path_foto dengan parameter nim
        if(nim.equals("13.7868")){
            prop.put("nama","Septiawan Aji Pradana");
            prop.put("kelas","3KS1");
            prop.put("path_foto_profile","http://192.168.1.100/sipadu/foto.png");
           
        }else{
            prop.clear();
        }
        return prop.toString();        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginAkun")
    public String loginAkun(@WebParam(name = "nim") String nim, @WebParam(name = "password") String password) throws java.lang.Exception {
        //TODO write your implementation code here:
        
        //dummy nim dan password
        final String contohNim = "13.7868";
        final String contohPassword = "5f4dcc3b5aa765d61d8327deb882cf99";        
        
        //query mencocokan nim dan password
        if(nim.equals(contohNim) && ubahJadiMD5(password).equals(contohPassword))
            return "1";
        else 
            return "0";      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getJadwalSaya")
    public String getJadwalSaya(@WebParam(name = "nim") String nim, @WebParam(name = "tanggal") String tanggal) throws java.lang.Exception {
        //TODO write your implementation code here:
       
    Properties prop = new Properties();
        Properties prop1 = new Properties();
        ArrayList<Properties> array = new ArrayList<Properties>();
        
       
            prop.put("kode_sesi","2");
            prop.put("matkul","Pemrograman Berbasis Objek");
            prop.put("dosen","Dosen A");
            prop.put("kode_ruang","323");
            prop.put("nama_singkat","OOP");
            
            prop1.put("kode_sesi","3");
            prop1.put("matkul","RPL");
            prop1.put("dosen","Rancangan Piranti Lunak");
            prop1.put("kode_ruang","343");
            prop1.put("nama_singkat","RPL");
            if(nim.equals("13.7868")&&tanggal.equals("1")){
                array.add(prop);
                array.add(prop1);
            }else{
                array.clear();
            }       
        return array.toString();    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPengumuman")
    public String getPengumuman(@WebParam(name = "halaman") String halaman, @WebParam(name = "jumlah") String jumlah, @WebParam(name = "nim") String nim) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();
        Properties prop2 = new Properties();
        ArrayList<Properties> array = new ArrayList<Properties>();
        
        
            prop.put("kode_berita","111");
            prop.put("judul","Pengumuman Pengawas PMB");
            prop.put("unit_kerja","BAAK");
            prop.put("hari","Kamis");
            prop.put("tanggal", "12-06-2016");
            
            
            prop2.put("kode_berita","222");
            prop2.put("judul","Apel Tingkat 3");
            prop2.put("unit_kerja","BAAK");
            prop2.put("hari","Jumat");
            prop2.put("tanggal", "23-01-2016");
            
            
            if(halaman.equals("1")&&jumlah.equals("1")&&nim.equals("1")){
               array.add(prop);
                array.add(prop2); 
            }else{
                array.clear();
            }
        return array.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDetailPengumuman")
    public String getDetailPengumuman(@WebParam(name = "kodeBerita") String kodeBerita, @WebParam(name = "nim") String nim) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();
        
        if(kodeBerita.equals("1")&&nim.equals("1")){
           prop.put("judul","Pengumuman Pengawas PMB");
        prop.put("konten","Pengumuman Ini dibuat untuk memberitahukan tentang mahasiswa......."); 
       }else{
           prop.clear();
       }
        
        return prop.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAbsensi")
    public String getAbsensi(@WebParam(name = "nim") String nim, @WebParam(name = "kelas") String kelas) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();
        Properties prop1 = new Properties();
        ArrayList<Properties> array = new ArrayList<Properties>();
       
       
            prop.put("kode_matkul","23");
            prop.put("nama_matkul","Aljabar Linier");
            prop.put("nama_dosen","Dosen B");
            prop.put("skor","90");
            
            prop1.put("kode_matkul","25");
            prop1.put("nama_matkul","Bahasa Inggris");
            prop1.put("nama_dosen","Dosen C");
            prop1.put("skor","90");
             if(nim.equals("1")&&kelas.equals("1")){
               array.add(prop);
            array.add(prop1); 
            }else{
                array.clear();
            }
                       
        return array.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDetailAbsensi")
    public String getDetailAbsensi(@WebParam(name = "kodeMatkul") String kodeMatkul, @WebParam(name = "nim") String nim) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();   
        
            
           if(kodeMatkul.equals("1")&&nim.equals("1")){
                prop.put("skor","100");
            prop.put("tanggal","12-05-2016");
            prop.put("ruang","321");
            prop.put("sesi","3");
            prop.put("keterangan","hadir");//hadir
                prop.put("pertemuan","7");
            }else{
                prop.clear();
            }
           
        
        return prop.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getJadwalHariIni")
    public String getJadwalHariIni(@WebParam(name = "tanggal") String tanggal) throws java.lang.Exception {
        //TODO write your implementation code here:
        Properties prop = new Properties();
        Properties prop1 = new Properties();
        ArrayList<Properties> array = new ArrayList<Properties>();
        
       
            prop.put("kode_sesi","1");
            prop.put("ruang","321");
            prop.put("kelas","3KS1");
            prop.put("nama_matkul","Metode Penelitian");
            prop.put("nama_dosen","Dr. ABC");
            prop.put("status","Telah Dimulai");//blm dimulai,telah dimulai,atau selesai
           
            
            prop1.put("kode_sesi","3");
            prop1.put("ruang","343");
            prop1.put("kelas","3KS1");
            prop1.put("nama_matkul","Sistem Informasi Geografis");
            prop1.put("nama_dosen","Dr. MNB");
            prop1.put("status","Telah Dimulai");//blm dimulai,telah dimulai,atau selesai
           
            
             if(tanggal.equals("1")){
                array.add(prop);
            array.add(prop1);
            }else{
                array.clear();
            }
        
        return array.toString();
    }
    
    
    
    
    
}
