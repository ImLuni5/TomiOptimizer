import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ModGuide extends JFrame {
    ModGuide() {
        super("토미의 마인크래프트 최적화 가이드 - Step 2. 모드 설치");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String fileName = "mod.txt";
        StringBuilder sb = new StringBuilder();
        sb.append("아래 모드를 Instances -> Add Mods에 들어가 추가해주세요! Modrinth를 권장 드리며, 일부 모드는 CurseForge에서만 제공됩니다.\n");
        sb.append("\nAlternate Current");
        sb.append("\nBetter Ping Display");
        sb.append("\nCapes");
        sb.append("\nChunk Sending (CurseForge)");
        sb.append("\nClient Side NoteBlocks");
        sb.append("\nCloth Config API");
        sb.append("\nConcurrent Chunk Management Engine");
        sb.append("\nConnectivity (CurseForge)");
        sb.append("\nContinuity");
        sb.append("\nCupboard (CurseForge)");
        sb.append("\nDark Loading Screen");
        sb.append("\nDebugify");
        sb.append("\nDynamic FPS");
        sb.append("\nEnhanced Block Entities");
        sb.append("\nEntity Culling");
        sb.append("\nExordium");
        sb.append("\nFabric API");
        sb.append("\nFabric Language Kotlin");
        sb.append("\nFastAnim");
        sb.append("\nFastload");
        sb.append("\nFerriteCore");
        sb.append("\nImmediatelyFast");
        sb.append("\nIndium");
        sb.append("\nKrypton");
        sb.append("\nLithium");
        sb.append("\nMemory Leak Fix");
        sb.append("\nModel Gap Fix");
        sb.append("\nModernFix");
        sb.append("\nMore Culling");
        sb.append("\nNoxesium");
        sb.append("\nReese's Sodium Options");
        sb.append("\nSmooth Chunk Save (CurseForge)");
        sb.append("\nServerCore");
        sb.append("\nSmoke Suppression");
        sb.append("\nSodium");
        sb.append("\nSodium Extra");
        sb.append("\nStarlight");
        sb.append("\nToolTipFix");
        sb.append("\nVery Many Players");
        sb.append("\nXXL Packets");
        sb.append("\nYetAnotherConfigLib");
        sb.append("\n");
        sb.append("\nMinecraft 1.20.1 Mod List by DeveloperTomi");
        sb.append("\nYoutube: https://www.youtube.com/c/개발자토미");

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.valueOf(sb));
            System.out.println("Text file created successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        JLabel lb1 = new JLabel("생성된 mod.txt 파일을 확인해주세요.");
        lb1.setBounds(50, 20, 600, 50);
        add(lb1);

        JButton next = new JButton("모드 다 추가했으면 넘어가자~");
        next.setBounds(50, 60, 600, 30);
        next.addActionListener(e -> {
            new GraalVMGuide();
            setVisible(false);
        });

        add(next);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
