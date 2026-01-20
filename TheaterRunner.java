import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {
    
String[] images = {
"14.jpg",
"15.jpg",
"16.jpg",
"17.jpg",
"18.jpg",
};
    
    // Create scene objects
    LastYear lastYear = new LastYear();
    imagestackty stack = new imagestackty(images);
    ThisYear thisYear = new ThisYear();

    // Call top level methods
    lastYear.drawScene();
    stack.drawStack(true);
    thisYear.drawScene();
    

    // Play scenes (in order of arguments)
    Theater.playScenes(lastYear, stack, thisYear);
    
  }
}