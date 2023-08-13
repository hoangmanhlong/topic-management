import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JFrame oldFrame;

    public MainFrame(JFrame oldFrame) {
        this.oldFrame = oldFrame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tắt frame cũ khi bấm xác nhận");
        setSize(300, 200);

        // Tạo một button để mở frame mới
        JButton openButton = new JButton("Mở frame mới");
        openButton.addActionListener(e -> openNewFrame());

        // Thêm button vào frame
        add(openButton);
    }

    private void openNewFrame() {
        // Tạo frame mới
        JFrame newFrame = new JFrame();
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setTitle("Frame mới");
        newFrame.setSize(200, 150);

        // Tạo nút xác nhận trong frame mới
        JButton confirmButton = new JButton("Xác nhận");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đóng frame cũ khi bấm xác nhận
                oldFrame.dispose();
                // Đóng frame mới
                newFrame.dispose();
            }
        });

        // Thêm nút xác nhận vào frame mới
        newFrame.setLayout(new FlowLayout());
        newFrame.add(confirmButton);

        // Hiển thị frame mới
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame oldFrame = new JFrame();
            oldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            oldFrame.setTitle("Frame cũ");
            oldFrame.setSize(200, 150);
            oldFrame.setVisible(true);

            JFrame mainFrame = new MainFrame(oldFrame);
            mainFrame.setVisible(true);
        });
    }
}