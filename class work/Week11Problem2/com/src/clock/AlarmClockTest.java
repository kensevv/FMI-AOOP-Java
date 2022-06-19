package clock;

import alarm.AlarmActionEventHandler;
import alarm.AlarmEvent;

public class AlarmClockTest {
    private AlarmClock clock;

    public AlarmClockTest() {
        clock = new AlarmClock(new ClockHandler(), 20);
    }

    private class ClockHandler implements
            AlarmActionEventHandler{

        @Override
        public void alarmActionPerformed(AlarmEvent args) {
            System.out.printf("Rings remaining: %d\n",
                    clock.getNrings());
        }
    }

    public static void main(String[] args) {
        AlarmClockTest test = new AlarmClockTest();
        test.clock.start();
    }
}

