/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO_Interface;
import DAO.DAO_Matkul;
import Model.varMatkul;
import View.EntriMatkul;
import java.util.List;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Controller_Matkul {
    EntriMatkul form;
    DAO_Interface<varMatkul> model;
    List<varMatkul> list;
    String[] header;
    
    public Controller_Matkul(EntriMatkul form){
        this.form = form;
        model = new DAO_Matkul();
        list = model.getAll();
        header = new String[]{"Kode Matakuliah", "Nama Matkul", "sks", "kodeprasyarat"};
        form.getTblMatkul().setShowGrid(true);
        form.getTblMatkul().setShowVerticalLines(true);
        form.getTblMatkul().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtMatkul().setText("");
        form.getTxtNama().setText("");
        form.getTxtSKS().setText("");
        form.getTxtKode().setText("");
        form.getTxtMatkul().requestFocus();
        isiTabel();
    }
    
    public void isiTabel(){
        list = model.getAll();
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }            
        };
        Object[] data = new Object[header.length];
        for(varMatkul objMhs : list){
            data[0] = objMhs.getvKodematkul();
            data[1] = objMhs.getvNama();
            data[2] = objMhs.getvSKS();
            data[3] = objMhs.getvKdpersyarat();
            tblModel.addRow(data);
        }
        form.getTblMatkul().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtMatkul().setText(list.get(row).getvKodematkul());
        form.getTxtNama().setText(list.get(row).getvNama());
        form.getTxtSKS().setText(list.get(row).getvSKS());
        form.getTxtKode().setText(list.get(row).getvKdpersyarat());
    }
    
    public void insert(){
        varMatkul objMhs = new varMatkul();
        
        objMhs.setvKodematkul(form.getTxtMatkul().getText());
        objMhs.setvNama(form.getTxtNama().getText());
        objMhs.setvSKS(form.getTxtSKS().getText());
        objMhs.setvKdpersyarat(form.getTxtKode().getText());
        
        model.insert(objMhs);
    }
        
    public void update(){
        varMatkul objMhs = new varMatkul();
        
        objMhs.setvKodematkul(form.getTxtMatkul().getText());
        objMhs.setvNama(form.getTxtNama().getText());
        objMhs.setvSKS(form.getTxtSKS().getText());
        objMhs.setvKdpersyarat(form.getTxtKode().getText());
        
        model.update(objMhs);
   }
   
   public void delete(){
        if(!form.getTxtMatkul().getText().trim().isEmpty()){
            String key = form.getTxtMatkul().getText();
            
            model.delete(key);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan di hapus");
        }
    }
   
   public void isiTabelCari(){
        list = model.getCari(form.getTxtMatkul().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for(varMatkul objMhs : list){
            data[0] = objMhs.getvKodematkul();
            data[1] = objMhs.getvNama();
            data[2] = objMhs.getvSKS();
            data[3] = objMhs.getvKdpersyarat();
            tblModel.addRow(data);
        }
        form.getTblMatkul().setModel(tblModel);
    }
}
