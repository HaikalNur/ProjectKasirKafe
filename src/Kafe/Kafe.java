/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kafe;

/**
 *
 * @author moxy
 */
public class Kafe {
    private String nama;
    private String alamat;
    private String telpon;
    
    public Kafe(String nama, String alamat, String telpon){
        this.nama=nama;
        this.alamat=alamat;
        this.telpon=telpon;
    }
    public void setInfoNama(String nama){
    this.nama= nama;
    }
    public void setInfoAlamat(String alamat){
    this.alamat= alamat;
    }
    public void setInfoTelepon(String telpon){
    this.telpon= telpon;
    }
    
    public String getNama(){
        return this.nama;
    }
    public String getAlamat(){
        return this.alamat;
    }
    public String getTelpon(){
        return this.telpon;
    }
    
    public void DisplayInfo(){
        System.out.println("Nama Kafe : " + nama);
        System.out.println("Alamat Kafe : " + alamat);
        System.out.println("Telepon Kafe :  " +telpon);
    }
}


