package cookercucumber_reporter;

public enum Pages {
    DASHBOARD(0),
    GRAPH(1),
    STATISTICS(2),
    FEATURES(3),
    LOG(4);

    private int pageIndex = 0;

    Pages(int i) {
        this.pageIndex = i;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}
