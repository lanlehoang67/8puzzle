
public class State {
	State TrangThai;
	Operator HanhDong;
	int a[][] = new int[3][3];
	public State Clone() {
		State sc= new State();
		for(int y=0;y<3;y++)
			for(int x=0;x<3;x++)
				sc.a[y][x] = this.a[y][x];
		return sc;
	}
	public void Print(){
		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 3; x++){
				System.out.print(a[y][x]);
			}
			System.out.println();
		}
		System.out.println(".............");
	}
	public String GetKey() {
		String key = "";
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				key += a[y][x];
			}
		}
		return key;
	}
}
