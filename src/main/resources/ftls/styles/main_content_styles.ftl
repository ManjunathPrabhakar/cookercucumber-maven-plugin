<!-- main_content_styles.css STYLESHEET START -->
<style>
    /* IMPORT TO USE FONT FAMILY ROBOTO SLAB */
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;500&display=swap');

    .main-content {
        display: block;
        /* position: fixed; */
        width: auto;
        height: auto;
        margin-left: 5rem;
        padding-left: 1rem;
        padding-right: 1rem;
    }

    .container-title {
        width: 100%;
        height: 3rem;
        /* position: fixed; */
        background-color: aliceblue;
        margin-bottom: 1rem;
        font-family: 'Roboto Slab', serif;
        font-weight: 500;
        -webkit-box-align: center;
        align-items: center;
        display: flex;
        margin-right: auto;
        font-size: 1.75rem;
        line-height: 2rem;
    }

    .container-title > i:hover {
        color: gray;
        cursor: pointer;
    }

    /* ================ BOX ================= */
    .card-content {
        margin: 5px;
        background-color: rgb(255, 255, 255);
        border-radius: 0.25rem;
        padding: 0.875rem 1.25rem 1.25rem;
        box-shadow: rgba(148, 162, 186, 0.2) 0px 3px 4px;
        display: flex;
        flex-direction: column;
        -webkit-box-pack: center;
        justify-content: center;
        display: table-cell;
    }

    .card-title {
        font-family: 'Roboto Slab', serif;
        /* color: rgb(71, 91, 135); */
        margin-bottom: 0.375rem;
        font-size: 0.75rem;
        line-height: 0.875rem;
        letter-spacing: 0.03125rem;
        text-transform: uppercase;
    }

    .card-data {
        color: rgb(27, 45, 85);
        padding-left: 0.75rem;
        position: relative;
        font-size: 1.25rem;
        line-height: 1.5rem;
    }

    .card-start-line {
        background-color: rgb(71, 135, 103);
        bottom: 0px;
        left: 0px;
        position: absolute;
        border-radius: 0.125rem;
        top: 0px;
        width: 0.25rem;
    }
</style>
<!-- main_content_styles.css STYLESHEET END -->