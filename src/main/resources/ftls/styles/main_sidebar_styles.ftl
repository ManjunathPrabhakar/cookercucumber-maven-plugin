<!-- main_sidebar_styles.css STYLESHEET START -->
<style>
    /* IMPORT TO USE FONT FAMILY ROBOTO SLAB */
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;500&display=swap');
    /* Apply to All Elements unless specified seperately */
    * {
        padding: 0;
        margin: 0;
        font-family: 'Roboto Slab', serif;
    }

    /* Apply to Body */
    body {
        background-color: aliceblue;
    }

    /* == SIDE BAR STYLES START == */
    /* Apply to whole of side bar on the LEFT */
    .side-bar {
        padding-top: 10px;
        display: flex;
        flex-direction: column;
        position: fixed;
        height: 100%;
        width: 5rem; /* TODO - CHnage to vw */
        background-color: rgb(8, 23, 54);
        align-items: center;
    }

    /* Apply to company image in the side bar on the LEFT */
    .side-bar .companylogo {
        /* background: linear-gradient(#3204fde6, #9907fae6);  */
        overflow: hidden;
        width: 100%;
        height: 100%;
        max-width: 3rem;
        max-height: 4rem;
    }

    /* Apply to Menu Text in the side bar on the LEFT, Under the Menu LOGO */
    .nav-text {
        color: white;
        text-transform: uppercase;
        font-family: 'Roboto Slab', serif;
        font-size: 0.6875rem;
        margin-top: 0.25rem;
    }

    /* Apply to Menu BOX(Contains Menu LOGO & Menu Text) in the side bar on the LEFT */
    .sidebar-menu {
        margin-top: 15px;
        -webkit-box-align: center;
        align-items: center;
        color: rgb(27, 45, 85);
        display: flex;
        flex-direction: column;
        position: relative;
        width: 100%;
    }

    /* Apply to Menu LOGO BOX in the side bar on the LEFT */
    .boxborder {
        display: flex;
        -webkit-box-align: center;
        align-items: center;
        -webkit-box-pack: center;
        justify-content: center;
        background-color: rgb(27, 45, 85);
        border-radius: 0.25rem;
        height: 2.5rem;
        width: 2.5rem;
        cursor: pointer;
    }

    /* Display Line when the menu box is selected/clicked */
    div[class^="menubox-"][class$="-selected"] {
        display: none;
        background-color: rgb(96, 128, 197);
        border-radius: 0.125rem;
        height: 2.5rem;
        left: 0;
        position: absolute;
        top: 0;
        width: 0.25rem;
    }

    /* Apply to Menu LOGO BOX in the side bar on the LEFT */
    .boxborder:hover {
        background-color: rgb(96, 128, 197);
    }

    /* Apply to Menu LOGO BOX when not selected in the side bar on the LEFT */
    .boxborder:hover > div[class^="menubox-"][class$="-selected"] {
        display: block;
    }

    /* Apply to Menu LOGO holder when not selected in the side bar on the LEFT */
    .user-txt {
        font-family: Drive, sans-serif;
        color: rgb(255, 255, 255);
        font-weight: 700;
        text-transform: uppercase;
        font-size: 1.25rem;
        line-height: 1.5rem;
    }

    /* == SIDE BAR STYLES END == */
</style>
<!-- main_sidebar_styles.css STYLESHEET END -->