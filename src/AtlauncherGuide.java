import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AtlauncherGuide extends JFrame {
    File selectedFile;

    AtlauncherGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 0. ATLauncher 설치");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton link = new JButton("ATLauncher를 설치하시고 ATLauncher.exe를 선택해주세요.");
        link.setBounds(50, 20, 600, 30);

        JButton openButton = new JButton("파일 열기");
        JFileChooser fileChooser = new JFileChooser();

        JLabel lb1 = new JLabel("선택된 파일: 없음");
        lb1.setBounds(50, 100, 600, 50);
        add(lb1);

        openButton.setBounds(50, 70, 600, 30);

        JButton confirm = new JButton("확인");
        confirm.setBounds(50, 150, 600, 30);

        confirm.addActionListener(e -> {
            if (Files.isExecutable(selectedFile.toPath())) {
                if (selectedFile.getName().equals("ATLauncher.exe")) {
                    try {
                        Desktop.getDesktop().open(selectedFile);
                        new FabricGuide();
                        setVisible(false);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else
                    JOptionPane.showMessageDialog(null, "ATLauncher.exe를 선택하고 눌러주세요.", "에러", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "ATLauncher.exe를 선택하고 눌러주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        });

        openButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                lb1.setText("선택된 파일: " + selectedFile.getName());
            }
        });

        add(openButton);
        setLocationRelativeTo(null);

        link.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create("https://atlauncher.com/downloads"));
            } catch (java.io.IOException er) {
                System.out.println(er.getMessage());
            }
        });

        add(link);
        add(confirm);

        setLayout(null);
        setVisible(true);
    }
}
