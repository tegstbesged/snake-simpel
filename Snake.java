public class Snake {
	
	public static int MAX = 50;
	int size;
	int[][] snakebody;
	boolean crashed;
	int heading;
	
	public Snake (int x, int y) {
		size = 2;
		snakebody = new int [x*y][2];
		snakebody[1][1] = 1;
		crashed = false;

	}
	
	public void moveSnake(int dir, GameField field) {
		
		System.out.println("Size is: "+size);
		
		int xtail = snakebody[0][0];
		int ytail = snakebody[0][1];
		
		for (int i = 1; i < size; i++) {
			snakebody[size-i][0] = snakebody[size-i-1][0];
			snakebody[size-i][1] = snakebody[size-i-1][1];
		}
		
		if (dir == 1) {			
			snakebody[0][1] = snakebody[1][1]+1;
			if (snakebody[0][1] > field.y) {
				snakebody[0][1] = -field.y;
			}
			
		} else if (dir == -1) {
			snakebody[0][1] = snakebody[1][1]-1;
			if (snakebody[0][1] < -field.y) {
				snakebody[0][1] = field.y;
			}
			
		} else if (dir == -2) {
			snakebody[0][0] = snakebody[1][0]-1;
			if (snakebody[0][0] < -field.x) {
				snakebody[0][0] = field.x;
			}
			
		} else {
			snakebody[0][0] = snakebody[1][0]+1;
			if (snakebody[0][0] > field.x) {
				snakebody[0][0] = -field.x;
			}
		}
		
		if (snakebody[0][0] == field.food[0] && snakebody[0][1] == field.food[1]) {
			size++;
			field.spawnFood(size, snakebody);
			snakebody[size-1][0]=xtail;
			snakebody[size-1][1]=ytail;
		}
		
		heading = dir;
		
		crashTest();
		
		}
		
	public void crashTest() {
		
		for (int i = 1; i < size; i++){
			if (snakebody[i][0] == snakebody[0][0] && snakebody[i][1] == snakebody[0][1]) {
				crashed = true;
			}
		}
		
		
	}
	
	public void printSnake() {
		for (int i = size-1; i >= 0; i--) {
				System.out.println(i+"#: ("+snakebody[i][0]+","+snakebody[i][1]+")");
		}
		
	}
	
	
	
}
