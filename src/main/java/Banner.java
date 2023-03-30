/**
 * Vaak gebruikte print statements zoals banners(Logo) en dividers
 */
class Banner {
    //ANSI SHADOW ASCII ART
    //https://manytools.org/hacker-tools/ascii-banner/


    public void printBannerLogo() {
        String banner = "███████╗██╗  ██╗██╗██████╗ ███████╗██╗     ███████╗██╗  " +
                "██╗                                                        \n" +
                "██╔════╝██║  ██║██║██╔══██╗██╔════╝██║     ██╔════╝╚██╗██╔╝\n" +
                "███████╗███████║██║██████╔╝█████╗  ██║     █████╗   ╚███╔╝ \n" +
                "╚════██║██╔══██║██║██╔═══╝ ██╔══╝  ██║     ██╔══╝   ██╔██╗ \n" +
                "███████║██║  ██║██║██║     ██║     ███████╗███████╗██╔╝ ██╗\n" +
                "╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                           ";
        for (int i = 0; i < banner.length(); i++) {
            System.out.print(banner.charAt(i));

        }
    }

    public void printBannerOfferte() {
        String banner = " ██████╗ ███████╗███████╗███████╗██████╗ ████████╗███████╗\n" +
                "██╔═══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝██╔════╝\n" +
                "██║   ██║█████╗  █████╗  █████╗  ██████╔╝   ██║   █████╗  \n" +
                "██║   ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██╗   ██║   ██╔══╝  \n" +
                "╚██████╔╝██║     ██║     ███████╗██║  ██║   ██║   ███████╗\n" +
                " ╚═════╝ ╚═╝     ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝\n" +
                "                                                          ";
        for (int i = 0; i < banner.length(); i++) {
            System.out.print(banner.charAt(i));

        }
    }

    public void printDivider() {
        String divider = "=====================================";
        for (int i = 0; i < divider.length(); i++) {
            System.out.print(divider.charAt(i));
        }
        System.out.println();
    }

}
