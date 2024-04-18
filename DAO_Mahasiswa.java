package DAO;
import Koneksi.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Model.varMahasiswa;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_Mahasiswa implements DAO_Interface<varMahasiswa>{
    Connection connection;
    public DAO_Mahasiswa(){
        connection = Database.KoneksiDB();
    }
    
    String INSERT = "INSERT INTO mahasiswa(NIM, nama, alamat) VALUES(?,?,?)";
    String UPDATE = "UPDATE mahasiswa set nama=?, alamat=? WHERE NIM=?";
    String DELETE = "DELETE FROM mahasiswa WHERE NIM=?";
    String SELECT = "SELECT * FROM mahasiswa";
    String CARI = "SELECT * FROM mahasiswa WHERE NIM=?";
    
    @Override
    public void insert(varMahasiswa object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, object.getvNIM());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else{
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, object.getvNIM());
                st.setString(2, object.getvNama());
                st.setString(3, object.getvAlamat());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            }
            rs.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(varMahasiswa object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, object.getvNama());
            st.setString(2, object.getvAlamat());
            st.setString(3, object.getvNIM());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String key) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(DELETE);
            st.setString(1, key);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<varMahasiswa> getAll() {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNIM(rs.getString("NIM"));
                objMhs.setvNama(rs.getString("Nama"));
                objMhs.setvAlamat(rs.getString("Alamat"));
                list.add(objMhs);
            }
            rs.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varMahasiswa> getCari(String key) {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(CARI);
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNIM(rs.getString("NIM"));
                objMhs.setvNama(rs.getString("Nama"));
                objMhs.setvAlamat(rs.getString("Alamat"));
                list.add(objMhs);
            }
            rs.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }     
}

