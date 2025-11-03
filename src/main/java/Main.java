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
		
		int deltaX;
		int deltaY;
		
		if(pointA.x > pointB.x){
			deltaX = pointA.x - pointB.x;
		}
		else {
			deltaX = pointB.x - pointA.x;
		}
		if(pointA.y > pointB.y) {
			deltaY = pointA.y - pointB.y;
		}
		else {
			deltaY = pointB.y - pointA.y;
		}
		
		if(Math.sqrt(deltaX * deltaX + deltaY * deltaY) > lenth) {
			if(pointA.x > pointB.x) {
				pointA.speed(-(float)((deltaX - Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f), 0);
				pointB.speed((float)((deltaX - Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f), 0);
			}
			else {
				pointA.speed((float)((deltaX - Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f), 0);
				pointB.speed(-(float)((deltaX - Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f), 0);
			}
			if(pointA.y > pointB.y) {
				pointA.speed(0,-(float)((deltaY - Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f));
				pointB.speed(0,(float)((deltaY - Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/2.0f));
			}
			else {
				pointA.speed(0,(float)((deltaY - Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/1.5f));
				pointB.speed(0,-(float)((deltaY - Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth)/1.5f));
			}
			
		}
		else if(Math.sqrt(deltaX * deltaX + deltaY * deltaY) < lenth) {
			if(pointA.x > pointB.x) {
				pointA.speed((float)(((Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaX)/2.0f), 0);
				pointB.speed(-(float)(((Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaX)/2.0f), 0);
			}
			else {
				pointA.speed(-(float)(((Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaX)/2.0f), 0);
				pointB.speed((float)(((Math.cos(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaX)/2.0f), 0);
			}
			if(pointA.y > pointB.y) {
				pointA.speed(0,(float)(((Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaY)/2.0f));
				pointB.speed(0,-(float)(((Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaY)/2.0f));
			}
			else {
				pointA.speed(0,-(float)(((Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaY)/2.0f));
				pointB.speed(0,(float)(((Math.sin(Math.acos(deltaX/Math.sqrt(deltaX * deltaX + deltaY * deltaY)))* lenth) - deltaY)/2.0f));
			}
			
		}
		
		DrawLine(pointA.x, pointA.y, pointB.x, pointB.y, BLACK);
	}

    public static void main(String args[]) {
    	Point pointA = new Point();
    	pointA.x = 390; pointA.y = 120;
    	Point pointB = new Point();
    	pointB.x = 430; pointB.y = 140;
    	Point pointC = new Point();
    	pointC.x = 420; pointC.y = 160;
    	
    	
        InitWindow(1080, 720, "Procedural Animation");
        SetTargetFPS(60);
        
        while (!WindowShouldClose()) {
        	
        	// update
        	pointA.speed(0, 0);
        	pointB.speed(0, 0);
        	
        	// render
            BeginDrawing();
            
            ClearBackground(RAYWHITE);
            
            pointA.point(pointA.x, pointA.y, RED);
            
            pointB.point(pointB.x, pointB.y, RED);
            
            pointC.point(pointC.x, pointC.y, RED);
            
            link(pointA, pointB, 40);
            link(pointC, pointB, 40);
            
            EndDrawing();
        	
        }
        CloseWindow();
    }
}
