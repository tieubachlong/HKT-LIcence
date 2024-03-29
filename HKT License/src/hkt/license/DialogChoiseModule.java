/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogChoiseModule.java
 *
 * Created on Oct 15, 2014, 1:56:44 PM
 */
package hkt.license;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author longnt
 */
public class DialogChoiseModule extends javax.swing.JDialog {

    /** Creates new form DialogChoiseModule */
    private DefaultTableModel tableModelDelete, tableModelDeleteRight;

    public DefaultTableModel getTableModelDeleteRight() {
        return tableModelDeleteRight;
    }

    public void setTableModelDeleteRight(DefaultTableModel tableModelDeleteRight1) {
        this.tableModelDeleteRight = tableModelDeleteRight1;
        tableModelDelete = (DefaultTableModel) tableCustomersLeft.getModel();
        tableCustomersRight.setModel(tableModelDeleteRight);

        Vector v = new Vector();
        v.add("Bán hàng");
        tableModelDelete.addRow(v);

        Vector v6 = new Vector();
        v6.add("Quản lý kho");
        tableModelDelete.addRow(v6);

        Vector v1 = new Vector();
        v1.add("Khuyến mãi");
        tableModelDelete.addRow(v1);

        Vector v5 = new Vector();
        v5.add("Menu Voucher");
        tableModelDelete.addRow(v5);

        Vector v2 = new Vector();
        v2.add("Điểm, Trả trước");
        tableModelDelete.addRow(v2);

        Vector v4 = new Vector();
        v4.add("Thống kê");
        tableModelDelete.addRow(v4);


        btnAddOne.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableCustomersLeft.getSelectedRow() >= 0) {
                    tableModelDeleteRight.addRow((Vector) tableModelDelete.getDataVector().elementAt(
                            tableCustomersLeft.getSelectedRow()));
                    tableModelDelete.removeRow(tableCustomersLeft.getSelectedRow());
                    tableModelDelete.fireTableDataChanged();
                    tableModelDeleteRight.fireTableDataChanged();
                }
            }
        });

        btnAddAll.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelDeleteRight.getDataVector().addAll(tableModelDelete.getDataVector());
                tableModelDelete.getDataVector().removeAllElements();
                tableModelDelete.fireTableDataChanged();
                tableModelDeleteRight.fireTableDataChanged();
            }
        });

        btnRemoveOne.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableCustomersRight.getSelectedRow() >= 0) {
                    tableModelDelete.addRow((Vector) tableModelDeleteRight.getDataVector().elementAt(
                            tableCustomersRight.getSelectedRow()));
                    tableModelDeleteRight.removeRow(tableCustomersRight.getSelectedRow());
                    tableModelDelete.fireTableDataChanged();
                    tableModelDeleteRight.fireTableDataChanged();
                }
            }
        });

        btnRemoveAll.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelDelete.getDataVector().addAll(tableModelDeleteRight.getDataVector());
                tableModelDeleteRight.getDataVector().removeAllElements();
                tableModelDelete.fireTableDataChanged();
                tableModelDeleteRight.fireTableDataChanged();
            }
        });

        for (int i = 0; i < tableCustomersRight.getRowCount(); i++) {
            for (int j = 0; j < tableCustomersLeft.getRowCount();) {
                if (tableCustomersRight.getValueAt(i, 0).toString().
                        equals(tableCustomersLeft.getValueAt(j, 0).toString())) {
                    tableModelDelete.removeRow(j);
                } else {
                    j++;
                }
            }
        }
    }

    public DialogChoiseModule() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(this);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomersLeft = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCustomersRight = new javax.swing.JTable();
        btnAddAll = new javax.swing.JButton();
        btnAddOne = new javax.swing.JButton();
        btnRemoveOne = new javax.swing.JButton();
        btnRemoveAll = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn module");
        setIconImage(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chọn module để cấp quyền sử dụng");

        tableCustomersLeft.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableCustomersLeft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomersLeft.setRowHeight(23);
        jScrollPane1.setViewportView(tableCustomersLeft);

        tableCustomersRight.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableCustomersRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomersRight.setRowHeight(23);
        jScrollPane2.setViewportView(tableCustomersRight);

        btnAddAll.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnAddAll.setText(">>");

        btnAddOne.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnAddOne.setText(">");

        btnRemoveOne.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnRemoveOne.setText("<");

        btnRemoveAll.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnRemoveAll.setText("<<");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton5.setText("Thoát");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton6.setText("Đồng ý");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveOne, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveAll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAddAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveAll)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    tableModelDeleteRight = null;
    this.dispose();
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    this.dispose();
}//GEN-LAST:event_jButton6ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAll;
    private javax.swing.JButton btnAddOne;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveOne;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCustomersLeft;
    private javax.swing.JTable tableCustomersRight;
    // End of variables declaration//GEN-END:variables
}
