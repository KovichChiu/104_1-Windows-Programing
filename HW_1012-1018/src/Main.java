
/*
 * Homewerk 4:(2015/10/14)
 * 延伸課堂的題目再做下列功能
 * 程式依執行起來先檢查有沒有 note.cnf 檔
 * 如果有就讀入 note.cnf 檔裡的資料設定TextArea的風格與字體
 * 如果note.cnf 檔不存在,那就用預設"新細明體",無風格,12點字,同時要產生一個note.cnf檔寫入硬碟
 * 在Help中加一個set功能
 * Set功能要能出現對話框可以設定字體顏色與文字區域的背景色
 * note.cnf 內容如下
 * 
 * 新細明體
 * 粗體
 * 18
 * green
 * yellow
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}

}