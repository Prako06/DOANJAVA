package Controller;

import Bean.DanhMucBean;
import View.BanHangJPanel;
import View.HangHoaJPanel;
import View.HoaDonJPanel;
import View.KhachHangJPanel;
import View.NhanVienPanel;
import View.ThongKeJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.HoaDon;

/**
 *
 * @author PraKo
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) throws SQLException{
        kindSelected = "KhachHang";
        jpnItem.setBackground(new Color(0,40,255));
        jlbItem.setBackground(new Color(0,40,255));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new KhachHangJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;
        
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {      
            try {
                switch(kind){
                    case "KhachHang":
                        node = new KhachHangJPanel();
                        break;
                    case "ThongKe":
                        node = new ThongKeJPanel();
                        break;
                    case "HangHoa":
                        node = new HangHoaJPanel();
                        break;
                    case "NhanVien":
                        node = new NhanVienPanel();
                        break;
                    case "BanHang":
                        node = new BanHangJPanel();
                        break;
                    case "HoaDon":
                        node = new HoaDonJPanel();
                        break;
                    default:
                        break;
                }
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(0,40,255));
            jlbItem.setBackground(new Color(0,40,255));      
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(0,40,255));
            jlbItem.setBackground(new Color(0,40,255)); 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(0,104,255));
                jlbItem.setBackground(new Color(0,104,255));
            }
        }            
    }
    
    private void setChangeBackground(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(0,40,255));
                item.getJlb().setBackground(new Color(0,40,255));
            }else{
                item.getJpn().setBackground(new Color(0,104,255));
                item.getJlb().setBackground(new Color(0,104,255));
            }
        }
    }
}