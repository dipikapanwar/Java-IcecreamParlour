
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NCC
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
    public Login() {
        initComponents();
        setIcon();
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        createaccount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 250));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ICECREAM PARLOUR");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 270, 47);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin Login", "Customer Login" }));
        getContentPane().add(cb);
        cb.setBounds(130, 70, 130, 30);

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 120, 70, 21);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 150, 0, 0);

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 181, 80, 30);
        getContentPane().add(t1);
        t1.setBounds(130, 120, 130, 30);

        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });
        getContentPane().add(t2);
        t2.setBounds(130, 180, 130, 30);

        login.setBackground(new java.awt.Color(102, 204, 0));
        login.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 15)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(130, 250, 130, 40);

        createaccount.setBackground(new java.awt.Color(0, 153, 153));
        createaccount.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 15)); // NOI18N
        createaccount.setForeground(new java.awt.Color(255, 255, 255));
        createaccount.setText("CREATE ACCOUNT");
        createaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createaccountActionPerformed(evt);
            }
        });
        getContentPane().add(createaccount);
        createaccount.setBounds(310, 70, 140, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art-artificial-background-1061581.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 510, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
 if(t1.getText().trim().equals("")||t2.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill the User ID and Password");
            }

 else if(cb.getSelectedItem()=="Customer Login")
 {
 
		// 3. connection code
    try
        {
            Class.forName("org.sqlite.JDBC");  
            Connection con=DriverManager.getConnection("jdbc:sqlite:IcecreamParlour.sqlite");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from customeraccount");
                                
            int i=0;
            while(rs.next())
		{
		if(t1.getText().equals(rs.getString(1)) && t2.getText().equals(rs.getString(3)))
                	{
			i=1; break;
			}
		}
		if(i==1)
		{
                    JOptionPane.showMessageDialog(this,"Login Successfully ");
                    con.close();
                    this.dispose();
                 //  CustomerAccount g= new CustomerAccount();
                    
                    
                    
                    Customerpanel1 g=new Customerpanel1();
                    
                    
                    
                    g.setVisible(true);
		}
		else
		{
                    JOptionPane.showMessageDialog(this,"Login User ID or Password Invalid ");
                    t1.setText("");
                    t2.setText("");
                    
		}
	}catch(HeadlessException | ClassNotFoundException | SQLException ex)
			{
				System.out.println(ex);
			}
}
 else{
        try
        {
            Class.forName("org.sqlite.JDBC");  
            Connection con=DriverManager.getConnection("jdbc:sqlite:IcecreamParlour.sqlite");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from admin_login");
            int i=0;
            while(rs.next())
            {
		if(t1.getText().equals(rs.getString(1)) && t2.getText().equals(rs.getString(2)))
		{
                	i=1; break;
		}
            }
            if(i==1)
            {
		JOptionPane.showMessageDialog(this,"Login Successfully ");
                con.close();
                this.dispose();
              //  AdminPanel a= new AdminPanel();
               
               
              Adminpanel a=new Adminpanel();
               
               
               
               
               a.setVisible(true);
            }
            else
            {
		JOptionPane.showMessageDialog(this,"Login Admin ID or Password Invalid ");
                 t1.setText("");
                 t2.setText("");
            }
        }catch(HeadlessException | ClassNotFoundException | SQLException ex)
            {
            System.out.println(ex);
            }

 }
    }//GEN-LAST:event_loginActionPerformed

    private void createaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createaccountActionPerformed
        // TODO add your handling code here:
        CreateAccount ca= new CreateAccount();
        ca.setVisible(true);
    }//GEN-LAST:event_createaccountActionPerformed

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyPressed
/**
     * @param args the command line arguments
     */
    
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
      
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JButton createaccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JButton login;
    public static javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
