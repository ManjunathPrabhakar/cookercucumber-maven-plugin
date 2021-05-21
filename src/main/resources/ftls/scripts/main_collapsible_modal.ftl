<!-- main_collapsible_modal.js STYLESHEET START -->
<script type="text/javascript">
    function showPopUp(somvalue, popupmodal) {
//Get element using the ID of popup modal
//And Call private method with both Elements
        disp(somvalue, document.getElementById(popupmodal));

//Keeping it private
        function disp(anchor, popupbox) {
//Display modal popup
            popupbox.style.display = "block";
// Get the <span> element that closes the modal
            let span = popupbox.getElementsByClassName("close")[0];
            // If user click on close, then close modal popup
            span.addEventListener("click", function () {
                popupbox.style.display = "none";
            });
            //If user click outside modal popup then close modal popup
            window.addEventListener("click", function (event) {
                if (event.target === popupbox) {
                    popupbox.style.display = "none";
                }
            });
        }
    }
</script>
<!-- main_collapsible_modal.js STYLESHEET END -->