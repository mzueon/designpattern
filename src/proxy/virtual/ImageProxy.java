package proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    volatile ImageIcon imageIcon;               // 실제 아이콘. 로딩이 끝났을 때 표시되는 실제 객체이다
    final URL imageURL;
    Thread retrievalThread;
    boolean retriving = false;

    public ImageProxy(URL imageURL) {           // 이미지의 URL을 생성자에게 전달한다. 로딩이 완료되면 표시될 이미지이다.
        this.imageURL = imageURL;
    }

    @Override
    public int getIconWidth() {                 // ImageIcon이 로드되기 전까지는 기본값으로 설정된 width와 height를 리턴한다
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }
    // ImageIcon은 두개의 다른 스레드에서 사용된다. 따라서 volatile 키워드를 사용하여 읽기 동작에서부터 보호하고
    // 쓰기 동작에서부터 보호하기 위해서 동기화된 setter를 사용한다.
    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {  // 아이콘은 화면에 그릴 때 호출되는 메소드
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);                        // 아이콘이 존재하는 경우, 이를 화면에 그려준다.
        } else {
            g.drawString("로딩 중입니다~~~~", x + 300, y + 190);  // 아이콘이 존재하지 않는 경우 로딩 메세지 표시
            if (!retriving) {
                retriving = true;

                // 실제 아이콘 이미지를 로드한다.
                // ImageIcon을 이용한 이미지 로딩은 동기적이다. ImageIcon 생성자는 이미지가 로드될 떄까지 리턴하지 않는다. 이로 인해 스크린을
                // 업데이트 하고 로딩 메세지를 표시할 수 없기 땨문에, 이를 비동기적으로 처리한다.
                retrievalThread = new Thread(() -> {
                    setImageIcon(new ImageIcon(imageURL, "Album Cover"));
                    c.repaint();
                });
                retrievalThread.start();
            }
        }
    }

}
