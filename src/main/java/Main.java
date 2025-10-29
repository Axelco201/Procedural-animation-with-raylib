import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;


class Point {
	int x, y;
	float radius;
	public static void point(int x, int y, Color color) {
		DrawCircle( x, y, 7.0f, color);
	}
	public static void drawCircle(int x, int y, float radius, Color color, Color backGroundColor) {
		DrawCircle( x, y, radius - 3.0f, backGroundColor);
		DrawCircle( x, y, radius, color);
	}
	public static void speed() {
		
	}
}

public class Main {
	private static void link(Point pointA, Point pointB) {
		DrawLine(pointA.x, pointA.y, pointB.x, pointB.y, BLACK);
	}
	
    public static void main(String args[]) {
    	Point pointA = new Point();
    	pointA.x = 460; pointA.y = 170;
    	Point pointB = new Point();
    	pointB.x = 500; pointB.y = 370;
    	
        InitWindow(1080, 720, "Procedural Animation");
        SetTargetFPS(60);
        
        while (!WindowShouldClose()) {
        	
            BeginDrawing();
            
            ClearBackground(RAYWHITE);
            
            pointA.point(pointA.x, pointA.y, RED);
            
            pointB.point(pointB.x, pointB.y, RED);
            
            link(pointA, pointB);
            
            EndDrawing();
        }
        CloseWindow();
    }
}
