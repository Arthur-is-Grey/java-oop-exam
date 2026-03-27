import java.util.ArrayList;

public class CommSystem {

    private String stationNer;
    private ArrayList<String> log;
    private int signalHvch = 100;
    private boolean offline = false;

    public CommSystem(String stationNer) {
        this.stationNer = stationNer;
        this.log = new ArrayList<>();
    }

    public String ilgeeh(String hvleenAvagch, String mesg) {
        if (offline) {
            return "📡 Офлайн!";
        }

        signalHvch -= 5;
        if (signalHvch < 10) {
            offline = true;
        }

        log.add("→ " + hvleenAvagch + ": " + mesg);
        return "Илгээлээ: " + hvleenAvagch;
    }

    public void hvleenAvah(String ilgeegch, String mesg) {
        log.add("← " + ilgeegch + ": " + mesg);
    }

    public void signalSergemjuuleh() {
        signalHvch = 100;
        offline = false;
    }

    public String logHarah(int n) {
        StringBuilder builder = new StringBuilder();
        int startIndex = Math.max(0, log.size() - n);

        for (int i = startIndex; i < log.size(); i++) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(log.get(i));
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        String status = offline ? "OFFLINE" : "ONLINE";
        return "📡 " + stationNer + " [" + status + "] Signal: " + signalHvch + "% | Лог: " + log.size() + " мессеж";
    }
}
