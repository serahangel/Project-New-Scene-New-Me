import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Variables
  private String[] pictures26;
  private String[] captions = {
    "2026",
     "2026",
     "2026",
     "2026",
  };
  public static final int SAMPLE_RATE = 44100; // for audioClip
  
  // Constuctors
  public ThisYear() {
    pictures26 = FileReader.toStringArray("pictures26.txt");
  }

  public ThisYear(String[] pictures) {
    this.pictures26 = pictures26;
  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
    // 12 seconds of background track
    playBackgroundTrack(17);
    // Title Screen
    drawTitleScreen();
    // pause here before Images
    pause(2.0);
    // Images With Captions (pause in method)
    drawImagesWithCaptions();
    // End Screen
    drawEndScreen();
  }

  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("white");
    drawText("Hi!", 100, 175);
    drawText("2026", 140, 225);
  }

  public void drawImagesWithCaptions() {
    setCaptionStyle();
    for (int index = 0; index < pictures26.length; index++) {
      // arguments: image, xPosition, yPosition, width, height, rotation
      drawImage(pictures26[index], 0, 0, 400, 400, 0.0);
      // arguments: text, xPosition, yPosition
      drawText(captions[index], 50, 350);
      // arguments: seconds
      pause(2.0);
    }
  }

  public void drawEndScreen() {
    setEndScreenStyle();
    clear("black");
    drawText("Thanks!", 125, 150);
  }

  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("green");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }
  
  public void setCaptionStyle() {
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
  }

  public void setEndScreenStyle() {
    setTextHeight(60);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD_ITALIC);
  }

  public void playBackgroundTrack(int numSeconds) {
    double[] audio = SoundLoader.read("fresh-457883-(1).wav");
    // just play the first numSeconds
    double[] clip = createClip(audio, 0, numSeconds);
    playSound(clip);
  }

  /**
   * Creates an audio clip from a given start time to a end time
   */
  public static double[] createClip(double[] sound, int start, int end) {
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;
    
    double[] newSound = new double[endIndex - startIndex];

    int index = 0;
    
    while (startIndex < endIndex) {
      newSound[index] = sound[startIndex];
      startIndex++;
      index++;
    }

    return newSound;
  }
  
}