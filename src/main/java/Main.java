import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;


class Point {
	int x, y;
	public static void point(int x, int y) {
		
	}
}

public class Main {
    public static void main(String args[]) {
        InitWindow(1080, 720, "Procedural Animation");
        SetTargetFPS(60);
        
        while (!WindowShouldClose()) {
        	
            BeginDrawing();
            
            ClearBackground(RAYWHITE);
            
            DrawText("Hello world", 190, 200, 20, BLACK);
            
            EndDrawing();
        }
        CloseWindow();
    }
}
