import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ModrinthAppGuide extends JFrame {
    ModrinthAppGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 0. Modrinth App 설치");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton link = new JButton("Modrinth App 설치하시고 실행해주세요.");
        link.setBounds(50, 20, 600, 30);

        JButton confirm = new JButton("확인");
        confirm.setBounds(50, 150, 600, 30);

        confirm.addActionListener(e -> {
            if (ProcessHandle.allProcesses()
                    .map(ProcessHandle::info)
                    .map(info -> info.command().orElse("").toLowerCase())
                    .anyMatch(cmd -> cmd.contains("modrinth"))) {
                new FabricGuide();
                setVisible(false);
            } else JOptionPane.showMessageDialog(null, "Modrinth App을 실행하고 눌러주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        });

        setLocationRelativeTo(null);

        link.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create("https://modrinth.com/app"));
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
