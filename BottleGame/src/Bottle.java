import java.util.Random;

public class Bottle {
    String color;
    
    Bottle(int colorNum){
        switch (colorNum) {
            case 0: this.color = "Red";
                    break;
            case 1: this.color = "Orange";
                    break;
            case 2: this.color = "Yellow";
                    break;
            case 3: this.color = "Green";
                    break;
            case 4: this.color = "Blue";
                    break;
            case 5: this.color = "Purple";
                    break;
            case 6: this.color = "Pink";
                    break;
            case 7: this.color = "Black";
                    break;
            case 8: this.color = "White";
                    break;
        }
    }
}
