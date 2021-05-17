/**
 * This Method is used to display the popup modal based on parameters
 * <br>Used in Features Content & Scenario Content
 * <br>Author : Manjunath Prahakar (manjunath189@gmail.com)
 * @param {Element} somvalue Element Instance passed from 'this' keyword
 * @param {String} popupmodal ID of Modal Popup
 */
function showPopUp(somvalue, popupmodal) {
    //Get element using the ID of popup modal
    //And Call private method with both Elements
    disp(somvalue, document.getElementById(popupmodal));

    //Keeping it private
    function disp(anchor, popupbox) {
        //Display modal popup
        popupbox.style.display = "block";

        // Get the <span> element that closes the modal
        var span = popupbox.getElementsByClassName("close")[0];
        // If user click on close, then close modal popup
        span.addEventListener("click", function (event) {
            popupbox.style.display = "none";
        });

        //If user click outside modal popup then close modal popup
        window.addEventListener("click", function (event) {
            if (event.target == popupbox) {
                popupbox.style.display = "none";
            }
        });
    }
}









