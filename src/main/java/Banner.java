/**
 * Vaak gebruikte print statements zoals banners(Logo) en dividers
 */
class Banner {
    //ANSI SHADOW ASCII ART
    //https://manytools.org/hacker-tools/ascii-banner/

    String red = "\033[0;31m";    // ANSI color code for red
    String white = "\u001b[37;1m";  // ANSI color code for white
    String blue = "\033[0;34m";   // ANSI color code for blue
    String ANSI_RESET = "\u001B[0m";





    public void printBannerLogo() {
        String banner = red + "███████╗██╗  ██╗██╗██████╗ ███████╗██╗     ███████╗██╗  " +
                "██╗                                                        \n" +
                red + "██╔════╝██║  ██║██║██╔══██╗██╔════╝██║     ██╔════╝╚██╗██╔╝\n" +
                white + "███████╗███████║██║██████╔╝█████╗  ██║     █████╗   ╚███╔╝ \n" +
                white + "╚════██║██╔══██║██║██╔═══╝ ██╔══╝  ██║     ██╔══╝   ██╔██╗ \n" +
                blue + "███████║██║  ██║██║██║     ██║     ███████╗███████╗██╔╝ ██╗\n" +
                blue + "╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                           " + ANSI_RESET;
        System.out.println(banner);
    }

    public void printBannerOfferte() {
        String banner = red + " ██████╗ ███████╗███████╗███████╗██████╗ ████████╗███████╗\n" +
                red + "██╔═══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝██╔════╝\n" +
                white + "██║   ██║█████╗  █████╗  █████╗  ██████╔╝   ██║   █████╗  \n" +
                white + "██║   ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██╗   ██║   ██╔══╝  \n" +
                blue + "╚██████╔╝██║     ██║     ███████╗██║  ██║   ██║   ███████╗\n" +
                blue + " ╚═════╝ ╚═╝     ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝\n" +
                "                                                          " + ANSI_RESET;
        System.out.println(banner);
    }

    public void printDivider() {
        String divider = "=====================================";
        for (int i = 0; i < divider.length(); i++) {
            System.out.print(divider.charAt(i));
        }
        System.out.println();
    }

}
