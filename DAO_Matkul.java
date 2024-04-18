
package DAO;
import Koneksi.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Model.varMatkul;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_Matkul implements DAO_Interface<varMatkul>{
    Connection connection;
    public DAO_Matkul(){
        connection = Database.KoneksiDB();
    }
    String INSERT = "INSERT INTO matakuliah(kodemtk, namamtk, sks, kodeprasyarat) VALUES(?,?,?,?)";
    String UPDATE = "UPDATE matakuliah set namamtk=?, sks=?, kodeprasyarat=? WHERE kodemtk=?";
    String DELETE = "DELETE FROM matakuliah WHERE kodemtk=?";
    String SELECT = "SELECT * FROM matakuliah";
    String CARI = "SELECT * FROM matakuliah WHERE kodemtk=?";

    @Override
    public void insert(varMatkul Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvKodematkul());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else{
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvKodematkul());
                st.setString(2, Object.getvNama());
                st.setString(3, Object.getvSKS());
                st.setString(4, Object.getvKdpersyarat());
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
    public void update(varMatkul Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvNama());
            st.setString(2, Object.getvSKS());
            st.setString(3, Object.getvKdpersyarat());
            st.setString(4, Object.getvKodematkul());    
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
    public List<varMatkul> getAll() {
    List<varMatkul> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMatkul>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMatkul objMhs = new varMatkul();
                objMhs.setvKodematkul(rs.getString("kodemtk"));
                objMhs.setvNama(rs.getString("namamtk"));
                objMhs.setvSKS(rs.getString("sks"));
                objMhs.setvKdpersyarat(rs.getString("kodeprasyarat"));
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
    public List<varMatkul> getCari(String key) {
        List<varMatkul> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMatkul>();
            st = connection.prepareStatement(CARI);
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMatkul objMhs = new varMatkul();
                objMhs.setvKodematkul(rs.getString("kodemtk"));
                objMhs.setvNama(rs.getString("namamtk"));
                objMhs.setvSKS(rs.getString("sks"));
                objMhs.setvKdpersyarat(rs.getString("kodeprasyarat"));
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
