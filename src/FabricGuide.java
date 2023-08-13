import javax.swing.*;
import java.awt.*;

public class FabricGuide extends JFrame {
    FabricGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 1. Fabric 설치");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel lb1 = new JLabel("Accounts로 들어가셔서 계정 로그인 하세요.");
        lb1.setBounds(50, 20, 600, 50);
        add(lb1);

        JLabel lb2 = new JLabel("Vanilla Packs 들어가서 1.20.1 선택 후 Fabric 선택 후 Create Instance를 누르세요.");
        lb2.setBounds(50, 70, 600, 50);
        add(lb2);

        JButton next = new JButton("다 했으면 넘어가자~");
        next.setBounds(50, 120, 600, 30);

        next.addActionListener(e -> {
            new ModGuide();
            setVisible(false);
        });

        add(next);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}