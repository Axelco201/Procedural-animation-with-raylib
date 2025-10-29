import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;


class Point {
	public int x;
	public int y;
	float radius;
	public static void point(int posX, int posY, Color color) {
		DrawCircle( posX, posY, 7.0f, color);
	}
	public static void drawCircle(int x, int y, float radius, Color color, Color backGroundColor) {
		DrawCircle( x, y, radius - 3.0f, backGroundColor);
		DrawCircle( x, y, radius, color);
	}
	public void speed(float speedX, float speedY) {
		x += speedX;
		y += speedY;
	}
}

public class Main {
	public static void link(Point pointA, Point pointB, int lenth) {
		DrawLine(pointA.x, pointA.y, pointB.x, pointB.y, BLACK);
		
		if((int)Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) > lenth + 10) {
			if (pointA.x > pointB.x) {
				pointA.speed(-(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15, 0);
				pointB.speed((float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15, 0);
			}
			else {
				pointA.speed((float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15, 0);
				pointB.speed(-(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15, 0);
			}
			if(pointA.y > pointB.y) {
				pointA.speed(0,-(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15);
				pointB.speed(0,(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15);
			}
			else {
				pointA.speed(0,(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15);
				pointB.speed(0,-(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15);
			}
		}
		else if((int)Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) < lenth - 10) {
			if (pointA.x > pointB.x) {
				pointA.speed((float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15, 0);
				pointB.speed(-(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15, 0);
			}
			else {
				pointA.speed(-(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15, 0);
				pointB.speed((float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15, 0);
			}
			if(pointA.y > pointB.y) {
				pointA.speed(0,-(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15);
				pointB.speed(0,(float)(Math.sqrt((pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y)) - lenth)/15);
			}
			else {
				pointA.speed(0,(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15);
				pointB.speed(0,-(float)(Math.sqrt((pointB.x - pointA.x) * (pointB.x - pointA.x) + (pointB.y - pointA.y) * (pointB.y - pointA.y)) - lenth)/15);
			}
		}
	}

    public static void main(String args[]) {
    	Point pointA = new Point();
    	pointA.x = 390; pointA.y = 120;
    	Point pointB = new Point();
    	pointB.x = 500; pointB.y = 370;
    	
        InitWindow(1080, 720, "Procedural Animation");
        SetTargetFPS(60);
        
        while (!WindowShouldClose()) {
        	// update
        	
        	pointA.speed(5, 0);
        	pointB.speed(0, 0);
        	
        	// render
            BeginDrawing();
            
            ClearBackground(RAYWHITE);
            
            pointA.point(pointA.x, pointA.y, RED);
            System.out.println("x : " + pointA.x + " y : " + pointA.y);
            
            pointB.point(pointB.x, pointB.y, RED);
            
            link(pointA, pointB, 100);
            
            EndDrawing();
        }
        CloseWindow();
    }
}
