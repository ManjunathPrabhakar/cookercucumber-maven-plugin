<!-- main_pagechange.js STYLESHEET START -->
<script type="text/javascript">
    function enableView(index) {
        var selectColor = 'rgb(96, 128, 197)';
        revertSideMenu();
        var _sidebar = document.getElementsByClassName("sidebar-menu");
        var borderbox = _sidebar[index].getElementsByTagName('div')[0];
        var selectedline = _sidebar[index].getElementsByTagName('div')[1]
        selectedline.style.display = 'block';
        borderbox.style.backgroundColor = selectColor;
        perfromContentLoad(index);
    }

    function revertSideMenu() {
        var profile = document.getElementsByClassName("user-txt-holder");
        profile[0].getElementsByClassName('boxborder')[0].style.backgroundColor = 'rgb(27, 45, 85)';

        var sidebarBoxes = document.getElementsByClassName("sidebar-menu");
        for (var i = 0; i < sidebarBoxes.length; i++) {
            var borderbox = sidebarBoxes[i].getElementsByTagName('div')[0];
            var selectedline = sidebarBoxes[i].getElementsByTagName('div')[1]
            selectedline.style.display = 'none';
            borderbox.style.backgroundColor = 'rgb(27, 45, 85)';
        }
    }

    function perfromContentLoad(what) {
        hideAllPages();
        var pages = document.getElementsByClassName("main-content")[0];
        pages.children[what].style.display = 'block';
//console.log("Enabled : " + pages.children[what].getAttribute('class'));
    }

    /**
     * Hide all content of all sidemenus
     * <br>Author : Manjunath Prahakar (manjunath189@gmail.com)
     */
    function hideAllPages() {
//Get 1st Element with Class Name 'content'
        var pages = document.getElementsByClassName("main-content")[0];
//Get the number of childrens of element with class name 'content'
        var a = pages.children.length;
//Loop through every child and hide it
        for (var i = 0; i < a; i++) {
            pages.children[i].style.display = 'none';
        }
    }
</script>
<!-- main_pagechange.js STYLESHEET END -->