import java.util.Random;

public class GameField {
	int x;
	int y;
	int [] food;
	Random rand = new Random();
	
	public GameField(int xi,int yi){
		x = xi;
		y = yi;
		
		food = new int [2];
		
	}
	
	public void spawnFood(int snakesize, int[][] snakebody) {
		
		food[0] = rand.nextInt(x)+1;
		food[1] = rand.nextInt(y)+1;
		
		int negativex = rand.nextInt(2);
		int negativey = rand.nextInt(2);
		
		if (negativex == 1) {
			food[0] = food[0]*-1;
		}
		if (negativey == 1) {
			food[1] = food[1]*-1;
		}
		
		for (int i = 0; i < snakesize; i++) {
			if (food == snakebody[i]){
				spawnFood(snakesize, snakebody);
		}
	}
	}
	
	public void isFoodConsumed(Snake snake) {
		if (snake.snakebody[0][0] == food[0] && snake.snakebody[0][1] == food[1]) {
			snake.size++;
			spawnFood(snake.size, snake.snakebody);
			snake.snakebody[snake.size-1][0]=snake.snakebody[snake.size-2][0];
			snake.snakebody[snake.size-1][1]=snake.snakebody[snake.size-2][1];
		}
	}
	
	public void printFood() {
		System.out.println("Food is at ("+food[0]+","+food[1]+").");
	}
}
