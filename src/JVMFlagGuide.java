import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class JVMFlagGuide extends JFrame {
    JVMFlagGuide(String path) {
        super("토미의 마인크래프트 최적화 가이드 - Step 3. JVM Flag 설정");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String flag = "-XX:+UseZGC -XX:+UseCompactObjectHeaders";
        JLabel lb1 = new JLabel("거의 다 왔습니다. Modrinth App에서 Settings -> Java and Memory로 들어와주세요.");
        lb1.setBounds(50, 10, 600, 50);
        add(lb1);

        JLabel lb22 = new JLabel("Memory Allocated에서 원하는 램 용량을 설정해주세요. (최대 4,096MB 설정 권장)");
        lb22.setBounds(50, 30, 600, 50);
        add(lb22);

        JButton jvmPath = new JButton("여기를 눌러 JVM 위치를 복사하고 Java Installation에 붙여넣기 해주세요.");
        jvmPath.setBounds(50, 50, 600, 30);
        jvmPath.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(path + "/bin/javaw.exe"), null);
            JOptionPane.showMessageDialog(null, "성공적으로 JVM의 파일 경로를 복사했습니다.", "복사 완료", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton jvmFlag = new JButton("여기를 눌러 JVM Flag를 복사하고 Java Arguments에 붙혀넣기 해주세요.");
        jvmFlag.setBounds(50, 100, 600, 30);
        jvmFlag.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(flag), null);
            JOptionPane.showMessageDialog(null, "성공적으로 JVM Flag를 복사했습니다.", "복사 완료", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton next = new JButton("다 했으면 이제 끝입니다~");
        next.setBounds(50, 170, 600, 30);
        next.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "모든 설정이 완료 되었습니다. 당신은 이제 최강 최적화 마인크래프트 소유자입니다!", "완료", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        add(jvmPath);
        add(jvmFlag);
        add(next);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
