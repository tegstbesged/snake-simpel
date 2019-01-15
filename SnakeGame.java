import java.util.Scanner;

public class SnakeGame {
	
	public static void main (String args[]) {
		System.out.println("This is a classic game of Snake.");
		Scanner console = new Scanner (System.in);
		
		int x = getInt(console, "Please enter width of field: ");
		int y = getInt(console, "Please enter height of field: ");
		
		GameField field = new GameField(x/2,y/2);
		
		Snake snake = new Snake(x,y);
		
		field.spawnFood(snake.size, snake.snakebody);
		
		while (true) {
			
			snake.printSnake();
			field.printFood();
			
			int move = getMove(console, "Input New Move (WASD): ");
			while (move == -snake.heading) {
				System.out.println("You can't move back the way you came!");
				move = getMove(console, "Input New Move (WASD): ");
			}
			snake.moveSnake(move, field);
			
			if (snake.crashed) {
				snake.printSnake();
				System.out.println("--- You crashed into yourself! ---");
				System.out.println("-------|    GAME OVER!    |-------");
				System.out.println("You got "+(snake.size-2)+" point(s).");
				
				break;
			}
			
		}
	}
	
	public static int getMove (Scanner console, String promt) {
		
		System.out.print(promt);
		char key = console.next().charAt(0);
		
		while (!(key == 'w' || key == 'a' || key == 's' || key == 'd')) {
			System.out.println("Invalid input - try again.");
			System.out.print(promt);
			key = console.next().charAt(0);
			
		}
		
		int move = 0;
		
		if (key == 'w') {
			move = 1;
		} else if (key == 'a') {
			move = -2;
		} else if (key == 's') {
			move = -1;
		} else {
			move = 2;
		}
		
			
		return move;
	}
	
	public static int getInt (Scanner console, String promt) {
		//Keeps asking for new int if player types non-int. Prints error message and the string "promt" whenever input invalid. 
		System.out.print(promt);
		 while (!console.hasNextInt()) {
			console.next();
			System.out.println("Invalid input - try again. (Must be integer)");
			System.out.print(promt);
		}
		 return console.nextInt();
	}
	
}


