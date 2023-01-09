package furkan;

import java.io.*;
import java.net.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // Video URL'si
    String videoUrl = "https://www.youtube.com/watch?v=6arY8oSRR54.mp4";
    // İndirilecek dosya yolu
    String filePath = "/Users/furkanturkmen/Desktop/video.mp4";

    // URL'yi aç
    URL url = new URL(videoUrl);
    // Veriyi oku
    InputStream in = url.openStream();
    // Dosyaya yaz
    OutputStream out = new FileOutputStream(filePath);

    byte[] buffer = new byte[1024];
    int length;
    while ((length = in.read(buffer)) > 0) {
      out.write(buffer, 0, length);
    }

    in.close();
    out.close();
  }
}