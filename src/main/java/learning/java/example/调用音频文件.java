package learning.java.example;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import org.apache.commons.io.FileUtils;

import javazoom.jl.player.Player;

public class 调用音频文件 {

    public static void main(String[] args) throws Exception {
        playWAV();
        //playLoop();
        //playMP3();
        //playAndStopMP3();
        //play2music();
    }

    /**
     * 播放WAV格式文件
     */
    public static void playWAV() {
        String strFilename = "/Users/Rayliu40k/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(strFilename));
            AudioFormat audioFormat = audioStream.getFormat();
            SourceDataLine sourceLine = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
            sourceLine.start();
            int nBytesRead = 0;
            byte[] abData = new byte[128000];
            while (nBytesRead != -1) {
                try {
                    nBytesRead = audioStream.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    @SuppressWarnings("unused")
                    int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                }
            }
            sourceLine.drain();
            sourceLine.close();
        } catch (Exception e) {
            //处理错误
            e.printStackTrace();
        }
    }

    /**
     * 播放MP3，直到MP3结束
     */
    public static void playMP3() {
        try {
            // 定义MP3文件路径
            String filePath = "/Users/Rayliu40k/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
            // 创建播放器对象，把文件的缓冲流传入进去
            Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
            // 播放，直到MP3结束
            player.play();
        } catch (Exception e) {
            // 处理错误
            e.printStackTrace();
        }
    }

    /**
     * 循环播放MP3
     */
    public static void playLoop() {
        try {
            for (int i = 0; i < 5; i++) {
                // 定义MP3文件路径
                String filePath = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
                // 创建播放器对象，把文件的缓冲流传入进去
                Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
                // 播放，直到MP3结束
                player.play();
            }
        } catch (Exception e) {
            // 处理错误
            e.printStackTrace();
        }
    }

    /**
     * 播放MP3，2s后马上停止
     */
    public static void playAndStopMP3() {
        try {
            // 定义MP3文件路径
            String filePath = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
            // 创建播放器对象，把文件的缓冲流传入进去
            Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
            // 播放
            new Thread(() -> {
                try {
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            // 2s后马上停止
            Thread.sleep(2000);
            player.close();
        } catch (Exception e) {
            // 处理错误
            e.printStackTrace();
        }
    }

    /**
     * 同时播放2个音乐
     */
    public static void play2music() {
        try {
            // 定义愤怒小鸟.mp3文件路径
            String backgroundFilePath = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
            // 创建播放器对象，把文件的缓冲流传入进去
            Player player1 = new Player(
                FileUtils.openInputStream(FileUtils.getFile(backgroundFilePath)));
            // 定义愤怒小鸟.mp3文件路径
            String stopFilePath = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
            Player player2 = new Player(FileUtils.openInputStream(FileUtils.getFile(stopFilePath)));
            // 定义愤怒小鸟.mp3文件路径
            String stopFilePath2 = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/infected_p.wav";
            Player player3 = new Player(
                FileUtils.openInputStream(FileUtils.getFile(stopFilePath2)));
            // 先播放愤怒小鸟
            new Thread(() -> {
                try {
                    player1.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            // 4.095s后播放愤怒小鸟
            Thread.sleep(4099);
            new Thread(() -> {
                try {
                    player2.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            // 4.095s后播放愤怒小鸟
            Thread.sleep(4099);
            new Thread(() -> {
                try {
                    player3.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            // 处理错误
            e.printStackTrace();
        }
    }

}
