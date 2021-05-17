<!-- main_splashscreen_styles.css STYLESHEET START -->
<style type="text/css">
    .splashscreen {
        padding-top: 40vh;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100vh;
        background-color: rgb(8, 23, 54);
        z-index: 9999;
        color: white;
        text-align: center;
        animation: fadeIn 2s ease-in forwards;
    }

    .splashscreen > div {
        display: flex;
        flex-direction: row;
        padding-left: 40vw;
    }

    @keyframes fadeIn {
        from {
            opacity: 1;
        }
        to {
            opacity: 0;
            display: none;
            visibility: hidden;
        }
    }
</style>
<!-- main_splashscreen_styles.css STYLESHEET END -->

