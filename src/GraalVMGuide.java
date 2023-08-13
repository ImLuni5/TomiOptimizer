import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GraalVMGuide extends JFrame {

    File selectedDirectory;

    GraalVMGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 3. GraalVM 설치");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton link = new JButton("GraalVM을 설치하고 디렉토리 파일을 선택해주세요.");
        link.setBounds(50, 20, 600, 30);
        link.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create("https://www.graalvm.org/downloads/"));
            } catch (java.io.IOException er) {
                System.out.println(er.getMessage());
            }
        });

        JButton openButton = new JButton("디렉토리 열기");
        openButton.setBounds(50, 70, 600, 30);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JLabel lb1 = new JLabel("선택된 디렉토리: 없음");
        lb1.setBounds(50, 100, 600, 50);
        add(lb1);

        openButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedDirectory = fileChooser.getSelectedFile();
                lb1.setText("선택된 디렉토리: " + selectedDirectory.getAbsolutePath());
            }
        });

        JButton confirm = new JButton("확인");
        confirm.setBounds(50, 140, 600, 30);

        confirm.addActionListener(e -> {
            File[] files = selectedDirectory.listFiles();
            for (File f : files) {
                if (f.isFile() && f.getName().equals("GRAALVM-README.md")) {
                    new JVMFlagGuide(selectedDirectory.getAbsolutePath());
                    setVisible(false);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "올바른 GraalVM 디렉토리가 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
        });

        add(link);
        add(confirm);
        add(openButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
