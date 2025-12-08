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

        String flag = "-XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+UseFastUnorderedTimeStamps -XX:+UseCriticalJavaThreadPriority -XX:+UseStringDeduplication -XX:+UseAES -XX:+UseAESIntrinsics -XX:+UseFMA -XX:+UseLoopPredicate -XX:+RangeCheckElimination -XX:+OptimizeStringConcat -XX:+UseCompressedOops -XX:+UseThreadPriorities -XX:+OmitStackTraceInFastThrow -XX:+RewriteBytecodes -XX:+RewriteFrequentPairs -XX:+UseFPUForSpilling -XX:+UseNewLongLShift -XX:+UseVectorCmov -XX:+UseXMMForArrayCopy -XX:+UseXmmI2D -XX:+UseXmmI2F -XX:+UseXmmLoadAndClearUpper -XX:+UseXmmRegToRegMoveAll -XX:+EliminateLocks -XX:+DoEscapeAnalysis -XX:+AlignVector -XX:+OptimizeFill -XX:+EnableVectorSupport -XX:+UseCharacterCompareIntrinsics -XX:+UseCopySignIntrinsic -XX:+UseVectorStubs -XX:UseAVX=2 -XX:UseSSE=4 -XX:+UseFastJNIAccessors -XX:+UseInlineCaches -XX:+SegmentedCodeCache -XX:ThreadPriorityPolicy=1 -XX:+UseG1GC -XX:MaxGCPauseMillis=37 -XX:+PerfDisableSharedMem -XX:G1HeapRegionSize=16M -XX:G1NewSizePercent=23 -XX:G1ReservePercent=20 -XX:SurvivorRatio=32 -XX:G1MixedGCCountTarget=3 -XX:G1HeapWastePercent=20 -XX:InitiatingHeapOccupancyPercent=10 -XX:G1RSetUpdatingPauseTimePercent=0 -XX:MaxTenuringThreshold=1 -XX:G1SATBBufferEnqueueingThresholdPercent=30 -XX:G1ConcMarkStepDurationMillis=5.0 -XX:GCTimeRatio=99 -XX:AllocatePrefetchStyle=3 -XX:+UseLargePages -XX:LargePageSizeInBytes=2m";
        JLabel lb1 = new JLabel("거의 다 왔습니다. ATLauncher에서 Settings -> Java/Minecraft로 들어와주세요.");
        lb1.setBounds(50, 10, 600, 50);
        add(lb1);

        JLabel lb22 = new JLabel("Maximum Memory/Ram에서 원하는 램 용량을 설정해주세요. (최대 4,096MB 설정 권장)");
        lb22.setBounds(50, 30, 600, 50);
        add(lb22);

        JLabel lb33 = new JLabel("Use Java Provided by Minecraft? 부분 체크 해제 해주시고 Ignore Java Checks On Launch? 체크 해주세요.");
        lb33.setBounds(50, 50, 600, 50);
        add(lb33);

        JButton graalPath = new JButton("여기를 눌러 GraalVM 위치를 복사하고 Java Path 2번째 칸에 붙혀넣기 해주세요.");
        graalPath.setBounds(50, 70, 600, 30);
        graalPath.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(path), null);
            JOptionPane.showMessageDialog(null, "성공적으로 GraalVM의 파일 경로를 복사했습니다.", "복사 완료", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton jvmFlag = new JButton("여기를 눌러 JVM Flag를 복사하고 Java Parameters에 붙혀넣기 해주세요.");
        jvmFlag.setBounds(50, 120, 600, 30);
        jvmFlag.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(flag), null);
            JOptionPane.showMessageDialog(null, "성공적으로 JVM Flag를 복사했습니다.", "복사 완료", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton next = new JButton("이제 마지막 단계로 넘어갈까요?");
        next.setBounds(50, 170, 600, 30);
        next.addActionListener(e -> {
            new LargePageGuide();
            setVisible(false);
        });

        add(graalPath);
        add(jvmFlag);
        add(next);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
