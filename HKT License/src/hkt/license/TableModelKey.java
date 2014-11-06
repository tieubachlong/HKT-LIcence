/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hkt.license;

import hkt.license.entity.Key;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author longnt
 */
public class TableModelKey extends DefaultTableModel {

    private String[] header = {"Tên khách hàng", "Key", "License", "Ngày bắt đầu", "Ngày kết thúc"};

    public TableModelKey(List<Key> listKey) {
        dataVector = convertToVector(listKey.toArray());
    }

    public void setData(List<Key> list) {
        dataVector = convertToVector(list.toArray());
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return header == null ? 0 : header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {

            case 0:
                try {
                    return ((Key) dataVector.get(row));
                } catch (Exception e) {
                    Vector rowVector = (Vector) dataVector.elementAt(row);
                    return rowVector.elementAt(column);
                }

            case 1:
                try {
                    return ((Key) dataVector.get(row)).getKeyMachine();
                } catch (Exception e) {
                    Vector rowVector = (Vector) dataVector.elementAt(row);
                    return rowVector.elementAt(column);
                }

            case 2:
                try {
                    return ((Key) dataVector.get(row)).getKeyActivate();
                } catch (Exception e) {
                    Vector rowVector = (Vector) dataVector.elementAt(row);
                    return rowVector.elementAt(column);
                }

            case 3:
                try {
                    return new SimpleDateFormat("dd/MM/yyyy").format(((Key) dataVector.get(row)).getDateStart());
                } catch (Exception e) {
                    Vector rowVector = (Vector) dataVector.elementAt(row);
                    return rowVector.elementAt(column);
                }
            case 4:
                try {
                    try {
                        return new SimpleDateFormat("dd/MM/yyyy").format(((Key) dataVector.get(row)).getDateEnd());
                    } catch (Exception e) {
                        return "";
                    }
                } catch (Exception e) {
                    Vector rowVector = (Vector) dataVector.elementAt(row);
                    return rowVector.elementAt(column);
                }


            default:
                return "";
        }
    }
}
