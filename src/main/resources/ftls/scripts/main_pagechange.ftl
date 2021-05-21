<!-- main_pagechange.js STYLESHEET START -->
<script type="text/javascript">
    function enableView(index) {
        let selectColor = 'rgb(96, 128, 197)';
        revertSideMenu();
        let _sidebar = document.getElementsByClassName("sidebar-menu");
        let borderbox = _sidebar[index].getElementsByTagName('div')[0];
        let selectedline = _sidebar[index].getElementsByTagName('div')[1]
        selectedline.style.display = 'block';
        borderbox.style.backgroundColor = selectColor;
        perfromContentLoad(index);
    }

    function revertSideMenu() {
        let profile = document.getElementsByClassName("user-txt-holder");
        profile[0].getElementsByClassName('boxborder')[0].style.backgroundColor = 'rgb(27, 45, 85)';
        let sidebarBoxes = document.getElementsByClassName("sidebar-menu");
        for (let i = 0; i < sidebarBoxes.length; i++) {
            let borderbox = sidebarBoxes[i].getElementsByTagName('div')[0];
            let selectedline = sidebarBoxes[i].getElementsByTagName('div')[1]
            selectedline.style.display = 'none';
            borderbox.style.backgroundColor = 'rgb(27, 45, 85)';
        }
    }

    function perfromContentLoad(what) {
        hideAllPages();
        let pages = document.getElementsByClassName("main-content")[0];
        pages.children[what].style.display = 'block';
//console.log("Enabled : " + pages.children[what].getAttribute('class'));
    }

    function hideAllPages() {
//Get 1st Element with Class Name 'content'
        let pages = document.getElementsByClassName("main-content")[0];
//Get the number of childrens of element with class name 'content'
        let a = pages.children.length;
//Loop through every child and hide it
        for (let i = 0; i < a; i++) {
            pages.children[i].style.display = 'none';
        }
    }
</script>
<!-- main_pagechange.js STYLESHEET END -->