
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TimeLabel extends JLabel{
	private ImageIcon [] img = new ImageIcon[10];
	public TimeLabel(){
		for(int i=0;i<10;i++){
			String url = "Number/"+i+".png";
			img[i] = new ImageIcon(url);
		}
		this.setIcon(img[0]);
	}
	public void setImg(int n){
		this.setIcon(img[n]);
	}
}
