import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class JVMFlagGuide extends JFrame {
    JVMFlagGuide(String path) {
        super("토미의 마인크래프트 최적화 가이드 - Step 4. JVM Flag 설정");
        setSize(700, 600);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String flag = "-XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=37 -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=23 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=16M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=18 -XX:G1MixedGCCountTarget=3 -XX:InitiatingHeapOccupancyPercent=10 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=0 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:G1SATBBufferEnqueueingThresholdPercent=30 -XX:G1ConcMarkStepDurationMillis=5.0 -XX:G1ConcRSHotCardLimit=16 -XX:MaxTenuringThreshold=1 -XX:G1ConcRefinementServiceIntervalMillis=150 -XX:UseAVX=3 -XX:+UseStringDeduplication -XX:+UseFastUnorderedTimeStamps -XX:+UseAES -XX:GCTimeRatio=99 -XX:+UseAESIntrinsics -XX:UseSSE=4 -XX:+UseFMA -XX:AllocatePrefetchStyle=3 -XX:+UseLoopPredicate -XX:+RangeCheckElimination -XX:+EliminateLocks -XX:+DoEscapeAnalysis -XX:+UseCodeCacheFlushing -XX:+SegmentedCodeCache -XX:+UseFastJNIAccessors -XX:+OptimizeStringConcat -XX:+UseCompressedOops -XX:+UseThreadPriorities -XX:+OmitStackTraceInFastThrow -XX:+TrustFinalNonStaticFields -XX:ThreadPriorityPolicy=1 -XX:+UseInlineCaches -XX:+RewriteBytecodes -XX:+RewriteFrequentPairs -XX:+UseNUMA -XX:NmethodSweepActivity=1 -XX:-DontCompileHugeMethods -XX:+UseFPUForSpilling -XX:+UseFastStosb -XX:+UseNewLongLShift -XX:+UseVectorCmov -XX:+UseXMMForArrayCopy -XX:+UseXmmI2D -XX:+UseXmmI2F -XX:+UseXmmLoadAndClearUpper -XX:+UseXmmRegToRegMoveAll -XX:+UseLargePages -XX:LargePageSizeInBytes=2m -Xlog:gc+init -Dfile.encoding=UTF-8 -Xlog:async -Djava.security.egd=file:/dev/urandom -XX:NmethodSweepActivity=1 -XX:+AlwaysActAsServerClassMachine -XX:ReservedCodeCacheSize=400M -XX:NonNMethodCodeHeapSize=12M -XX:ProfiledCodeHeapSize=194M -XX:NonProfiledCodeHeapSize=194M -XX:MaxNodeLimit=240000 -XX:NodeLimitFudgeFactor=8000 -XX:+UseCriticalJavaThreadPriority -XX:+EnableJVMCIProduct -XX:+EnableJVMCI -XX:+UseJVMCICompiler -XX:+EagerJVMCI -Dgraal.TuneInlinerExploration=1 -Dgraal.CompilerConfiguration=enterprise --add-modules jdk.incubator.vector";

        JLabel lb1 = new JLabel("거의 다 왔습니다. ATLauncher에서 Settings -> Java/Minecraft로 들어와주세요.");
        lb1.setBounds(50, 20, 600, 50);
        add(lb1);

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
