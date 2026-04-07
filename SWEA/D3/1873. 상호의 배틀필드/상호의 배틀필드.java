
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static char[][] map;
	static int H, W;
	static int[] dx = {-1, 1, 0, 0}; // U, D, L, R
	static int[] dy = {0, 0, -1, 1};
	static class tank{
		int h;
		int w;
		int dir;
		public tank(int h, int w, int dir) {
			super();
			this.h = h;
			this.w = w;
			this.dir = dir;
		}
		public void shoot() {
			int nx = h + dx[this.dir];
			int ny = w + dy[this.dir];
			while(inRange(nx, ny)) {
				
				if(map[nx][ny] == '*') {
					map[nx][ny] = '.';
					break;
				} else if(map[nx][ny] == '#')
					break;
				
				nx += dx[this.dir];
				ny += dy[this.dir];
			}
			
		}
		
		public void move(int d) {
			this.dir = d;
			int nx = h + dx[d];
			int ny = w + dy[d];
			
			if(inRange(nx, ny) && map[nx][ny] == '.') {
				this.h = nx;
				this.w = ny;
			}
		}
		
		private boolean inRange(int x, int y) {
			return x >= 0 && y >= 0 && x < H && y < W;
		}
		public void setTank() {
			char tankDir = '.';
			switch (this.dir) {
			case 0: {
				tankDir = '^';
				break;
			}case 1: {
				tankDir = 'v';
				break;
			}case 2: {
				tankDir = '<';
				break;
			}case 3: {
				tankDir = '>';
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + this.dir);
			}
			map[this.h][this.w] = tankDir;
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		tank tank = null;
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '^') {
						map[i][j] = '.';
						tank = new tank(i, j, 0);
					}
					if(map[i][j] == '<') {
						map[i][j] = '.';
						tank = new tank(i, j, 2);
					}
					if(map[i][j] == '>') {
						map[i][j] = '.';
						tank = new tank(i, j, 3);
					}
					if(map[i][j] == 'v') {
						map[i][j] = '.';
						tank = new tank(i, j, 1);
					}
				}
			}
				
			int N = Integer.parseInt(br.readLine());
			char[] commands = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				switch (commands[i]) {
				case 'S': {
					tank.shoot();
					break;
				}default:
					tank.move(change(commands[i]));
				}
			}
			tank.setTank();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			
		}
		
	}
	private static int change(char c) {
	    switch (c) {
	        case 'U': return 0;
	        case 'D': return 1;
	        case 'L': return 2;
	        case 'R': return 3;
	        default: throw new IllegalArgumentException("잘못된 입력: " + c);
	    }
	}

}
