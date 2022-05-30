/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.HDDAO;
import DAO.HangHoaDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.CTHD;
import model.HangHoa;
import model.HoaDon;

/**
 *
 * @author PraKo
 */
public class BanHangJPanel extends javax.swing.JPanel {

    private HangHoaDAO hhdao;
    private HDDAO hddao;
    /**
     * Creates new form BanHangJPanel
     */
    Image resizeimg(String path, int width, int height)
    { 
        Image img;
        try {
            File file = new File(path);
            ImageInputStream link = ImageIO.createImageInputStream(file);
            BufferedImage rsimg = ImageIO.read(link);
            
            img = rsimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    private void getpDSHH(ArrayList<HangHoa> lhh)
    {
        pDSHH.removeAll();
        pDSHH.setLayout(new FlowLayout(FlowLayout.LEFT));
        int w ,h;
        w = h = 250;
        String dir = System.getProperty("user.dir");
       for(int i = 0; i < lhh.size(); i++)
       {
           Integer name = lhh.get(i).getMaHang();
           String img_name = dir+"\\build\\classes\\imgHH\\"+(name)+".jpg";
           Image img = resizeimg(img_name, w, h);
           ImageIcon imgic = new ImageIcon(img);
           JPanel jp = new JPanel();
           jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
           jp.setSize(300, 400);
           
           JLabel lb = new JLabel(imgic);
           
           lb.setSize(w, h);
           lb.setName(name.toString());
           jp.add(lb);
           JLabel lbname = new JLabel(lhh.get(i).getTenHang());
           jp.setName(name.toString());
           jp.setAlignmentY(CENTER_ALIGNMENT);
           
           jp.setPreferredSize(new Dimension(250, 330));
           jp.setMaximumSize(new Dimension(250, 330));
           jp.setBorder(BorderFactory.createTitledBorder(lhh.get(i).getTenHang()));
           JButton btmua = new JButton();
           btmua.setText("Thêm");
           btmua.setName(name.toString());
           btmua.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btmuaMouseClicked(evt);
            }
        });
           //jp.add(lbname);
           jp.add(btmua);
           
           
           System.out.println(img_name);
           pDSHH.add(jp);
           pDSHH.setVisible(true);
       }

    }
    
   private DefaultTableModel inittablemodel()
   {
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("mã");
       dtm.addColumn("tên");
       dtm.addColumn("đơn giá");
       dtm.addColumn("số lượng");
       dtm.addColumn("tổng tiển");
       dtm.addColumn("      ");
       
       dtm.addTableModelListener(new javax.swing.event.TableModelListener()
       {
           @Override
           public void tableChanged(javax.swing.event.TableModelEvent e)
           {
               tableChange(e);
               
           }
       });
       return dtm;
   }
    public BanHangJPanel() {
        initComponents();
        hddao = new HDDAO();
        txtSL = new JTextField();
        txtSL.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSL(e);
            }
        });
        hhdao = new HangHoaDAO();
        ArrayList<HangHoa> lhh = hhdao.DSHH();
        tmgh = inittablemodel();
        tbGH.setModel(tmgh);
        tbGH.setDefaultEditor(Object.class, null);
        TableColumnModel tableColumnModel = tbGH.getColumnModel();
        TableColumn tbcl = tableColumnModel.getColumn(3);
        tbcl.setCellEditor(new DefaultCellEditor(txtSL));
        tbGH.setRowHeight(30);
        
        getpDSHH(lhh);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pDSHH = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pDSHHDM = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfSDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbtamtinh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btThanhToan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1920, 1080));

        pDSHH.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pDSHH.setAlignmentX(3.0F);
        pDSHH.setAlignmentY(3.0F);
        pDSHH.setAutoscrolls(true);
        pDSHH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pDSHH.setFocusable(false);
        pDSHH.add(canvas1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Bán Hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tbGH.setEditingColumn(3);
        tbGH.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tbGHComponentAdded(evt);
            }
        });
        tbGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGH);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Số điện thoại:");

        jLabel3.setText("---------------------------------------------");

        jLabel4.setText("Tạm tính");

        lbtamtinh.setText("0");

        jLabel6.setText("Tổng tiền:");

        jLabel7.setText("0");

        jLabel8.setText("Tiền khách đưa:");

        jLabel9.setText("0");

        btThanhToan.setBackground(new java.awt.Color(0, 104, 255));
        btThanhToan.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btThanhToan.setText("Thanh Toán");
        btThanhToan.setBorder(null);
        btThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThanhToanMouseClicked(evt);
            }
        });
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lbtamtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(btThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbtamtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pDSHHDMLayout = new javax.swing.GroupLayout(pDSHHDM);
        pDSHHDM.setLayout(pDSHHDMLayout);
        pDSHHDMLayout.setHorizontalGroup(
            pDSHHDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDSHHDMLayout.createSequentialGroup()
                .addContainerGap(1048, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pDSHHDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDSHHDMLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 316, Short.MAX_VALUE)))
        );
        pDSHHDMLayout.setVerticalGroup(
            pDSHHDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDSHHDMLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
            .addGroup(pDSHHDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDSHHDMLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(206, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pDSHHDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pDSHH, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 552, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 910, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 910, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDSHH, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(pDSHHDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 490, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 490, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btThanhToanActionPerformed
    private boolean check_sdt()
    {
        String SDT = tfSDT.getText();
        for( int i = 0; i < SDT.length(); i++)
        {
            if(SDT.charAt(i) < '0' || SDT.charAt(i) > '9')
            {
                JOptionPane.showMessageDialog(this, "số điẹn thoại sai định dạng");
                return false;
            }
        }
        return true;
    }
    private boolean check_tt()
    {
        if(lbtamtinh.getText().equals("0"))
        {
            JOptionPane.showMessageDialog(this, "không có mặt hàng nào trong hóa đơn");
            return false;
            
        }
        return true;
    }
    
    private void tbGHComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbGHComponentAdded
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tbGHComponentAdded

    
    private void tbGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGHMouseClicked
        int idr = tbGH.getSelectedRow();
        int idc = tbGH.getSelectedColumn();
        if(idc == 5)
        {
            tmgh.removeRow(idr);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbGHMouseClicked

    private void btThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThanhToanMouseClicked
            // TODO add your handling code here:
            if(check_sdt() && check_tt())
        {
            String sdt;
            if(tfSDT.getText().length() == 0)
            {
                sdt = "0";
            }
            else{
                sdt = tfSDT.getText();
            }
            HoaDon hd = new HoaDon();
            int tongtien = Integer.parseInt(lbtamtinh.getText());
            hd.setTT(tongtien);
            hd.setMaKH(Integer.parseInt(sdt));
            int mahd = hddao.createhd(hd);
            for( int i  = 0; i < tmgh.getRowCount(); i++)
            {
                CTHD cthd = new CTHD();
                cthd.setMahd(mahd);
                cthd.setMahh(Integer.parseInt(tmgh.getValueAt(i, 0).toString()));
                cthd.setSl(Integer.parseInt(tmgh.getValueAt(i, 3).toString()));
                cthd.setDongia(Integer.parseInt(tmgh.getValueAt(i, 2).toString()));
                hddao.createCTHD(cthd);
            }
            JOptionPane.showMessageDialog(this, "da thanh toan");
            
        }
        
    }//GEN-LAST:event_btThanhToanMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        ArrayList<HangHoa> dshh = new ArrayList<HangHoa>();
        String dk = txtTimKiem.getText();
        if(dk.equals(""))
        {
            dshh = hhdao.DSHH();
        }
        else
        {
            dshh = hhdao.dshh(dk);
        }
        getpDSHH(dshh);
        
    }//GEN-LAST:event_txtTimKiemActionPerformed

    public BanHangJPanel(HangHoaDAO hhdao, Canvas canvas1, JButton jButton1, JLabel jLabel1, JLabel jLabel2, JLabel jLabel3, JLabel jLabel4, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JPanel jPanel2, JPanel jPanel3, JScrollPane jScrollPane1, JLabel lbtamtinh, JPanel pDSHH, JPanel pDSHHDM, JTable tbGH, JTextField tfSDT, DefaultTableModel tmgh, JTextField txtSL) {
        this.hhdao = hhdao;
        this.canvas1 = canvas1;
        this.btThanhToan = jButton1;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jLabel8 = jLabel8;
        this.jLabel9 = jLabel9;
        this.jPanel2 = jPanel2;
        this.jPanel3 = jPanel3;
        this.jScrollPane1 = jScrollPane1;
        this.lbtamtinh = lbtamtinh;
        this.pDSHH = pDSHH;
        this.pDSHHDM = pDSHHDM;
        this.tbGH = tbGH;
        this.tfSDT = tfSDT;
        this.tmgh = tmgh;
        this.txtSL = txtSL;
    }
    private void checkSL(ActionEvent e)
    {
        for( int i = 0; i < tmgh.getRowCount(); i++)
        {
            String sl = tmgh.getValueAt(i, 3).toString();
            boolean check = true;
            int so =1;
            for( int j = 0; j < sl.length(); j++)
            {
                if(sl.charAt(j) <'0' || sl.charAt(j)>'9')
                {
                    check = false;
                    
                    break;
                }
                so = Integer.parseInt(sl);
                if(so <= 0)
                {
                    JOptionPane.showMessageDialog(this, "số lượng phải là số tự nhiên lớn hơn 0");
                    check = false;
                    break;
                }
            }
            if(!check )
            {
                tmgh.setValueAt("1", i, 3);
                so = 1;
            }
            
            int tt = tinh_tong_tien(so, Integer.parseInt(tmgh.getValueAt(i, 2).toString()));
            tmgh.setValueAt(tt, i, 4);
        }
        
    }
    private boolean check_all()
    {
        return true;
    }
    private void tableChange(javax.swing.event.TableModelEvent e)
    {
        Integer tttt = tongtienSP();
        System.out.print(tttt.toString());
        lbtamtinh.setText(tttt.toString());
        
    }
    private int tongtienSP()
    {
        int tttt = 0;
        int count = tmgh.getRowCount();
        
        for (int i = 0; i < count; i++)
        {
            int gia = Integer.parseInt( tmgh.getValueAt(i, 4).toString());
            
            tttt += gia;
        }
        return tttt;
    }
    private void btmuaMouseClicked(java.awt.event.MouseEvent evt)
    {
        JButton bt = (JButton)evt.getComponent();
        
        
        int ma = Integer.parseInt(bt.getName());
        HangHoa hhthem = hhdao.getHH(ma);
        Object[] arrayObjects = new Object[6];
        arrayObjects[0] = hhthem.getMaHang();
        arrayObjects[1] = hhthem.getTenHang();
        arrayObjects[2] = hhthem.getDonGia();
        arrayObjects[3] = 1;
        int tt = tinh_tong_tien(1,Integer.parseInt(hhthem.getDonGia()) );
        arrayObjects[4] = tt;
        arrayObjects[5] = "Xóa";
        
        tmgh.addRow(arrayObjects);
        
        
    }

    private int tinh_tong_tien(int sl, int dg)
    {
        return sl*dg;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThanhToan;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbtamtinh;
    private javax.swing.JPanel pDSHH;
    private javax.swing.JPanel pDSHHDM;
    private javax.swing.JTable tbGH;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel tmgh;
    private javax.swing.JTextField txtSL;
}
