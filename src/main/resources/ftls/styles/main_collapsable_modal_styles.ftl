/* --------------------------------------------- */

.scenario {
    margin-top: 2px;
    margin-bottom: 2px;
    border-radius: 3px;
    background-color: #777;
    color: white;
    cursor: pointer;
    padding: 10px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
}

/* -----------------COLLAPSIBLE---------------------------- */

.collapsibleM {
    margin-top: 2px;
    margin-bottom: 2px;
    border-radius: 3px;
    background-color: #777;
    color: white;
    cursor: pointer;
    padding: 10px;
    width: 98%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
}

.active,
.collapsibleM:hover,
.scenario:hover {
    width: 100%;
    background-color: #555;
}

.contentM {
    border-radius: 5px;
    padding: 0 18px;
    display: none;
    overflow: hidden;
    /*background-color: rgb(96, 128, 197);*/
    background-color: #e0dfdf;
    padding-bottom: 18px;
    /* background-color: #f1f1f1; */
}

.featbar {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

/* --------------- MODAL ----------------- */

/* The Modal (background) */

.modal {
    display: none;
    /* Hidden by default */
    position: fixed;
    /* Stay in place */
    z-index: 1;
    /* Sit on top */
    padding-top: 80px;
    /* Location of the box */
    left: 0;
    top: 0;
    width: 100%;
    /* Full width */
    height: 100%;
    /* Full height */
    overflow: auto;
    /* Enable scroll if needed */
    background-color: rgb(0, 0, 0);
    /* Fallback color */
    background-color: rgba(0, 0, 0, 0.4);
    /* Black w/ opacity */
    overflow: auto;
}


/* Modal Content */

.modal-content {
    max-height: 80%;
    overflow: auto;
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}


/* Add Animation */

@-webkit-keyframes animatetop {
    from {
        transform: scale(0);
    }

    to {
        transform: scale(1);
    }

}

@keyframes animatetop {
    from {
        transform: scale(0);
    }

    to {
        transform: scale(1);
    }
}


/* The Close Button */

.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {
    padding: 2px 16px;
}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}