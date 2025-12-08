import javax.swing.*;
import java.awt.*;

public class LargePageGuide extends JFrame{
    LargePageGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 4. Large Page 설정");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel lb1 = new JLabel("Large Page를 활성화 해야 합니다. 윈도우 기준으로 설명 드리겠습니다.");
        lb1.setBounds(50, 20, 600, 50);
        add(lb1);

        JLabel lb1extra = new JLabel("그 외의 운영체제 이용자는 인터넷에서 검색해주세요.");
        lb1extra.setBounds(50,40,600,50);
        add(lb1extra);

        JLabel lb2 = new JLabel("1. 로컬 보안 정책 실행");
        lb2.setBounds(50, 70, 600, 50);
        add(lb2);

        JLabel lb3 = new JLabel("2. 로컬정책 -> 사용자 권한 할당 -> 메모리에 페이지 잠금 더블클릭");
        lb3.setBounds(50, 120, 600, 50);
        add(lb3);

        JLabel lb4 = new JLabel("3. 본인의 윈도우 계정 이름 입력");
        lb4.setBounds(50, 170, 600, 50);
        add(lb4);

        JButton done = new JButton("다 했으면 이제 끝입니다~");
        done.setBounds(50, 220, 600, 30);
        done.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "모든 설정이 완료 되었습니다. 당신은 이제 최강 최적화 마인크래프트 소유자입니다!", "완료", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        add(done);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
