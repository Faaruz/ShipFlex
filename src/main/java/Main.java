import java.io.*;
import java.util.*;
import java.text.NumberFormat;


class Main {
    public static void main(String[] args) throws IOException {
        Banner banner = new Banner();
        Startup startup = new Startup();
        banner.printBannerLogo();
        startup.askAdmin();
    }
}