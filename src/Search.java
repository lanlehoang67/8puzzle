import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Search {
	public static void main(String[] args) {
		new Search();
	}
	public Search() {
		List<State> Open = new ArrayList<State>();
		Map<String,State> Closed = new HashMap<String,State>();
		Random rd = new Random();
		State O = null;
		State Goal = new State();
		for(int y=0; y<3;y++)
			for(int x=0;x<3;x++)
				Goal.a[y][x] = (x+y*3+1)%9;
		State Start =  Goal.Clone();
		for(int i=0;i<10000;i++) {
			State tmp = new Operator(rd.nextInt(4)).Move(Start);
			if(tmp != null) {
				Start = tmp;
			}
		}
		Goal.Print();
		Start.Print();
		//1.cho dinh xp vao open
		Open.add(Start);
		Closed.put(Start.GetKey(),Start);
		//2.neu open rong thi tim kiem that bai
		while(Open.size()!=0) {
		//3.ko thi lay dinh dau ra
			O= Open.remove(0);
			Closed.put(O.GetKey(), O);
		//4
			if(Equal(O,Goal)) {
				break;
			}
		//5
			for(int i=0;i<4;i++) {
				Operator op = new Operator(i);
				State child = op.Move(O);
				if(child==null) continue;
				if(In(child,Closed)) continue;
				Open.add(child);
				Closed.put(child.GetKey(), child);
				child.TrangThai = O;
				child.HanhDong = op;
			}
		
		}
		Print(O);
	}
	private boolean In(State child,Map<String,State> closed) {
		State s= closed.get(child.GetKey());
		if(s==null) return false;
		return true;
	}
	private boolean Equal(State comparer,State goal) {
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++) {
				if(comparer.a[y][x]!=goal.a[y][x]) {
					return false;
				}
			}
		}
		return true;
	}
	private void Print(State o) {
		if(o.TrangThai!=null) {
			Print(o.TrangThai);
			System.out.println(o.HanhDong.i);
		}
		o.Print();
	}

}
