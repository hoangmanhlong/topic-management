import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    public static void main(String[] args) {
        // Tạo một JTable và mô hình dữ liệu (TableModel)
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Thêm dữ liệu vào JTable
        model.addRow(new Object[]{"John", 25, "Engineer"});
        model.addRow(new Object[]{"Alice", 30, "Manager"});
        model.addRow(new Object[]{"Bob", 35, "Developer"});

        // Lấy chỉ số hàng cần lấy
        int rowIndex = 1;

        // Lấy dữ liệu từ hàng chỉ mục rowIndex
        Object[] rowData = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowData[i] = model.getValueAt(rowIndex, i);
        }

        // In dữ liệu của hàng đã lấy
        for (Object value : rowData) {
            System.out.print(value + " ");
        }
    }
}
