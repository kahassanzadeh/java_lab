import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) /*throws InterruptedException*/
	 {
	    ClockDisplay clk = new ClockDisplay();
	    while (true){
	        clk.timeTick();
	        System.out.println(clk.getTime());
			clk.setAlarm(0,0,1);
			//Thread.sleep(1);
        }

    }
}
