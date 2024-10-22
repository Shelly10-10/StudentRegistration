
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class studentTable extends JFrame implements ActionListener {
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
   private Container c; 
   private JLabel titleLabel,fnLabel,lnLabel,phonelabel,gpalabel;
   private JTextField fntf,lntf,phonetf,gpatf;
   private JButton addbutton,updatebutton,deletebutton,clearbutton;
   
   private String[] columns={"First name","Last name","Phone no","GPA"};
   private String[] rows=new String[4];//there are four colums
   
   studentTable(){
       initcompo();
   }
   public void initcompo(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(780,960);
       this.setLocationRelativeTo(null);
       this.setTitle("Student table");
       
       c=this.getContentPane();
       c.setLayout(null);
       c.setBackground(Color.BLUE);
       
       Font font=new Font("Arial",Font.BOLD,16);
       Font f=new Font("Arial",Font.BOLD,22);
       titleLabel=new JLabel("Student Registration");
       titleLabel.setForeground(Color.WHITE);
       titleLabel.setFont(f);
       titleLabel.setBounds(140,10,250,50);
       c.add(titleLabel);
       
       fnLabel=new JLabel("First name  ");
       fnLabel.setFont(font);
       fnLabel.setBounds(10,80,140,30);
       c.add(fnLabel);
       
       fntf=new JTextField();
       fntf.setBounds(110, 80, 200, 30);
       fntf.setFont(font);
       c.add(fntf);
       
       addbutton=new JButton("ADD");
       addbutton.setBounds(400,80,100,30);
       addbutton.setFont(font);
       c.add(addbutton);
       
       lnLabel=new JLabel("Last name  ");
       lnLabel.setFont(font);
       lnLabel.setBounds(10,130,150,30);
       c.add(lnLabel);
       
       lntf=new JTextField();
       lntf.setBounds(110, 130, 200, 30);
       lntf.setFont(font);
       c.add(lntf);
       
       updatebutton=new JButton("UPDATE");
       updatebutton.setBounds(400,130,100,30);
       updatebutton.setFont(font);
       c.add(updatebutton);
       
      phonelabel=new JLabel("Phone no  ");
       phonelabel.setFont(font);
       phonelabel.setBounds(10,180,150,30);
       c.add(phonelabel);
       
       phonetf=new JTextField();
       phonetf.setBounds(110, 180, 200, 30);
       phonetf.setFont(font);
       c.add(phonetf);
       
       deletebutton=new JButton("DELETE");
       deletebutton.setBounds(400,180,100,30);
       deletebutton.setFont(font);
       c.add(deletebutton);
       
       gpalabel=new JLabel("GPA  ");
       gpalabel.setFont(font);
       gpalabel.setBounds(10,230,150,30);
       c.add(gpalabel);
       
       gpatf=new JTextField();
       gpatf.setBounds(110, 230, 200, 30);
       gpatf.setFont(font);
       c.add(gpatf);
       
       clearbutton=new JButton("CLEAR");
       clearbutton.setBounds(400,230,100,30);
       clearbutton.setFont(font);
       c.add(clearbutton);
       
       table=new JTable();
       
       model=new DefaultTableModel();
       model.setColumnIdentifiers(columns);
       table.setModel(model);
       table.setFont(font);
       table.setBackground(Color.WHITE);
       table.setSelectionBackground(Color.lightGray);
       table.setRowHeight(30);
       
       scroll=new JScrollPane(table);
       scroll.setBounds(10, 360, 740, 265);
       c.add(scroll);
       
       addbutton.addActionListener(this);
       clearbutton.addActionListener(this);
       deletebutton.addActionListener(this);
       updatebutton.addActionListener(this);
       
       table.addMouseListener(new MouseAdapter(){
           public void mouseClicked (MouseEvent m){
               int num=table.getSelectedRow();
               
               String f_name=model.getValueAt(num, 0).toString();
               String l_name=model.getValueAt(num, 1).toString();
               String ph_no=model.getValueAt(num, 2).toString();
               String gpa=model.getValueAt(num, 3).toString();
               
               fntf.setText(f_name);
               lntf.setText(l_name);
               phonetf.setText(ph_no);
               gpatf.setText(gpa);
           }
       });
               
               
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addbutton){
            rows[0]=fntf.getText();
            rows[1]=lntf.getText();
            rows[2]=phonetf.getText();
            rows[3]=gpatf.getText();
            model.addRow(rows);
        }
        else if(ae.getSource()==clearbutton){
            fntf.setText("");
            lntf.setText("");
            phonetf.setText("");
            gpatf.setText("");
        }
        else if(ae.getSource()==deletebutton){
            int val=table.getSelectedRow();
            if(val>=0){
                model.removeRow(val);
            }else{
                JOptionPane.showMessageDialog(null,"No row has been selected or the row doesn't exist");
            }
        }
        else if(ae.getSource()==updatebutton){
            int n=table.getSelectedRow();
            String f_name=fntf.getText();
            String l_name=lntf.getText();
            String ph=phonetf.getText();
            String gpa=gpatf.getText();
            
            model.setValueAt(f_name,n, 0);
            model.setValueAt(l_name,n, 1);
            model.setValueAt(ph,n, 2);
            model.setValueAt(gpa,n, 3);
        }
    }
    public static void main(String[] args) {
        studentTable frame=new studentTable();
        frame.setVisible(true);
    }
   
}
