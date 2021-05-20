package cookercucumber_reporter;

public enum Pages {
    DASHBOARD(0),
    GRAPH(1),
    FEATURES(2),
    LOG(3);

    private int pageIndex = 0;

    Pages(int i) {
        this.pageIndex = i;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}
