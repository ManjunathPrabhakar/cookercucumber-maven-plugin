package cookercucumber_reporter.template;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 09/02/2021
 * @project cooker-maven-plugin
 */
public class TemplateHTML {

    static String htmlfiledata = "<!DOCTYPE html>\n" +
            "\n" +
            "<head>\n" +
            "    <title>Cooker Cucumber Report</title>\n" +
            "    <link rel=\"icon\" type=\"image/png\" href=\"cooker-cucumber-logo.png\" />\n" +
            "    <style>\n" +
            "        /* IMPORT TO USE FONT FAMILY ROBOTO SLAB */\n" +
            "        @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@400;500&display=swap');\n" +
            "\n" +
            "        /* Apply to All Elements unless specified seperately */\n" +
            "        * {\n" +
            "            padding: 0;\n" +
            "            margin: 0;\n" +
            "            font-family: 'Roboto Slab', serif;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Body */\n" +
            "        body {\n" +
            "            background-color: aliceblue;\n" +
            "        }\n" +
            "\n" +
            "        /* =============== SIDE BAR STYLES ======================== */\n" +
            "\n" +
            "        /* Apply to whole of side bar on the LEFT */\n" +
            "        .side-bar {\n" +
            "            padding-top: 10px;\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            position: fixed;\n" +
            "            height: 100%;\n" +
            "            width: 5rem;\n" +
            "            background-color: rgb(8, 23, 54);\n" +
            "            align-items: center;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to company image in the side bar on the LEFT */\n" +
            "        .side-bar img {\n" +
            "            /* background: linear-gradient(#3204fde6, #9907fae6);  */\n" +
            "            overflow: hidden;\n" +
            "            width: 100%;\n" +
            "            height: 100%;\n" +
            "            max-width: 3rem;\n" +
            "            max-height: 4rem;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Menu Text in the side bar on the LEFT, Under the Menu LOGO */\n" +
            "        #nav-text {\n" +
            "            color: white;\n" +
            "            text-transform: uppercase;\n" +
            "            font-family: 'Roboto Slab', serif;\n" +
            "            font-size: 0.6875rem;\n" +
            "            margin-top: 0.25rem;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Menu BOX(Contains Menu LOGO & Menu Text) in the side bar on the LEFT */\n" +
            "        .sidebar-menu {\n" +
            "            margin-top: 15px;\n" +
            "            -webkit-box-align: center;\n" +
            "            align-items: center;\n" +
            "            color: rgb(27, 45, 85);\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            position: relative;\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Menu LOGO BOX in the side bar on the LEFT */\n" +
            "        .boxborder {\n" +
            "            display: flex;\n" +
            "            -webkit-box-align: center;\n" +
            "            align-items: center;\n" +
            "            -webkit-box-pack: center;\n" +
            "            justify-content: center;\n" +
            "            background-color: rgb(27, 45, 85);\n" +
            "            border-radius: 0.25rem;\n" +
            "            height: 2.5rem;\n" +
            "            width: 2.5rem;\n" +
            "        }\n" +
            "\n" +
            "        /* Display Line when the menu box is selected/clicked */\n" +
            "        div[class^=\"menubox-\"][class$=\"-selected\"] {\n" +
            "            display: none;\n" +
            "            background-color: rgb(96, 128, 197);\n" +
            "            border-radius: 0.125rem;\n" +
            "            height: 2.5rem;\n" +
            "            left: 0px;\n" +
            "            position: absolute;\n" +
            "            top: 0px;\n" +
            "            width: 0.25rem;\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Menu LOGO BOX in the side bar on the LEFT */\n" +
            "        .boxborder:hover {\n" +
            "            background-color: rgb(96, 128, 197);\n" +
            "        }\n" +
            "\n" +
            "        /* Apply to Menu LOGO BOX when not selected in the side bar on the LEFT */\n" +
            "        .boxborder:hover>div[class^=\"menubox-\"][class$=\"-selected\"] {\n" +
            "            display: block;\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        /* Apply to Menu LOGO holder when not selected in the side bar on the LEFT */\n" +
            "        .user-txt {\n" +
            "            font-family: Drive, sans-serif;\n" +
            "            color: rgb(255, 255, 255);\n" +
            "            font-weight: 700;\n" +
            "            text-transform: uppercase;\n" +
            "            font-size: 1.25rem;\n" +
            "            line-height: 1.5rem;\n" +
            "        }\n" +
            "\n" +
            "        /* -------------------------------------------- */\n" +
            "\n" +
            "        /* THE PAGE CONTENT STYLE */\n" +
            "        .content {\n" +
            "            display: block;\n" +
            "            /* position: fixed; */\n" +
            "            width: auto;\n" +
            "            height: auto;\n" +
            "            margin-left: 5rem;\n" +
            "            padding-left: 1rem;\n" +
            "            padding-right: 1rem;\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        .css-xmwpqf-Box {\n" +
            "            background-color: rgb(255, 255, 255);\n" +
            "            border-radius: 0.25rem;\n" +
            "            padding: 0.875rem 1.25rem 1.25rem;\n" +
            "            box-shadow: rgba(148, 162, 186, 0.2) 0px 3px 4px;\n" +
            "            display: flex;\n" +
            "            flex-direction: column;\n" +
            "            -webkit-box-pack: center;\n" +
            "            justify-content: center;\n" +
            "        }\n" +
            "\n" +
            "        .css-15s48jc-Text {\n" +
            "            font-family: 'Roboto Slab';\n" +
            "            /* color: rgb(71, 91, 135); */\n" +
            "            margin-bottom: 0.375rem;\n" +
            "            font-size: 0.75rem;\n" +
            "            line-height: 0.875rem;\n" +
            "            letter-spacing: 0.03125rem;\n" +
            "            text-transform: uppercase;\n" +
            "        }\n" +
            "\n" +
            "        .css-lsdv8t-Box {\n" +
            "            color: rgb(27, 45, 85);\n" +
            "            padding-left: 0.75rem;\n" +
            "            position: relative;\n" +
            "            font-size: 1.25rem;\n" +
            "            line-height: 1.5rem;\n" +
            "        }\n" +
            "\n" +
            "        .css-crie0s-Box {\n" +
            "            background-color: rgb(71, 135, 103);\n" +
            "            bottom: 0px;\n" +
            "            left: 0px;\n" +
            "            position: absolute;\n" +
            "            border-radius: 0.125rem;\n" +
            "            top: 0px;\n" +
            "            width: 0.25rem;\n" +
            "        }\n" +
            "\n" +
            "        .container-title {\n" +
            "            width: 100%;\n" +
            "            height: 3rem;\n" +
            "            /* position: fixed; */\n" +
            "            background-color: aliceblue;\n" +
            "            margin-bottom: 1rem;\n" +
            "            font-family: 'Roboto Slab', serif;\n" +
            "            font-weight: 500;\n" +
            "            -webkit-box-align: center;\n" +
            "            align-items: center;\n" +
            "            display: flex;\n" +
            "            margin-right: auto;\n" +
            "            font-size: 1.75rem;\n" +
            "            line-height: 2rem;\n" +
            "        }\n" +
            "\n" +
            "        .container-title>i:hover {\n" +
            "            color: gray;\n" +
            "            cursor: pointer;\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        /* ----------------------------------- */\n" +
            "\n" +
            "        #dash {\n" +
            "            border-spacing: 5px;\n" +
            "            display: table;\n" +
            "        }\n" +
            "\n" +
            "        .feature-content {\n" +
            "            display: table-row;\n" +
            "        }\n" +
            "\n" +
            "        .scenario-content {\n" +
            "            display: table-row;\n" +
            "        }\n" +
            "\n" +
            "        .css-xmwpqf-Box {\n" +
            "            display: table-cell;\n" +
            "        }\n" +
            "\n" +
            "        .dashboard-content #dash {\n" +
            "            display: inline-block;\n" +
            "            width: auto;\n" +
            "        }\n" +
            "\n" +
            "        .info-content #dash {\n" +
            "            display: inline-block;\n" +
            "            width: auto;\n" +
            "        }\n" +
            "\n" +
            "        #dash:nth-child() {\n" +
            "            float: left;\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        #info-tooltip:hover::after {\n" +
            "            margin-left: 0.5rem;\n" +
            "            content: \"A Breif Overview of Report\";\n" +
            "            font-family: 'Roboto Slab', serif;\n" +
            "            position: absolute;\n" +
            "            top: 1;\n" +
            "            padding: 2px;\n" +
            "            border-radius: 4px;\n" +
            "            border-bottom: 1px;\n" +
            "            width: auto;\n" +
            "            height: auto;\n" +
            "            background-color: rgb(135, 157, 201);\n" +
            "            color: rgb(8, 23, 54);\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "\n" +
            "        /*Features Page Features List */\n" +
            "        /* table,\n" +
            "tr,\n" +
            "td,\n" +
            "th {\n" +
            "  border: 1px solid black;\n" +
            "  border-collapse: collapse;\n" +
            "}\n" +
            "\n" +
            "tr.header {\n" +
            "  cursor: pointer;\n" +
            "} */\n" +
            "\n" +
            "        #myTable {\n" +
            "            margin: 0.875rem 1.25rem 1.25rem;\n" +
            "        }\n" +
            "\n" +
            "        table {\n" +
            "            border-spacing: 1;\n" +
            "            border-collapse: collapse;\n" +
            "            background: white;\n" +
            "            border-radius: 8px;\n" +
            "            overflow: hidden;\n" +
            "            width: 95%;\n" +
            "            margin: 0 auto;\n" +
            "            position: relative;\n" +
            "        }\n" +
            "\n" +
            "        table tr.header {\n" +
            "            font-weight: normal;\n" +
            "            height: 40px;\n" +
            "            background: white;\n" +
            "            color: rgb(8, 23, 54);\n" +
            "        }\n" +
            "\n" +
            "        table tr.header:hover {\n" +
            "            font-weight: normal;\n" +
            "            background-color: rgb(220, 221, 235);\n" +
            "        }\n" +
            "\n" +
            "        table tr {\n" +
            "            height: 30px;\n" +
            "        }\n" +
            "\n" +
            "        tr td {\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "\n" +
            "        #passicon {\n" +
            "            color: #3FFC07;\n" +
            "        }\n" +
            "\n" +
            "        #failicon {\n" +
            "            color: #FC2507;\n" +
            "        }\n" +
            "\n" +
            "        .css-1nmzs0h {\n" +
            "            display: flex;\n" +
            "            -webkit-box-align: center;\n" +
            "            align-items: center;\n" +
            "            -webkit-box-pack: end;\n" +
            "            justify-content: flex-end;\n" +
            "            background-color: rgb(255, 255, 255);\n" +
            "            border: 1px solid rgb(225, 237, 255);\n" +
            "            border-top-left-radius: 0.5rem;\n" +
            "            grid-area: topbar / topbar / topbar / topbar;\n" +
            "            height: 4rem;\n" +
            "            padding-right: 1.25rem;\n" +
            "            width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        /*-------------------------------*/\n" +
            "    </style>\n" +
            "    <!--    <script src=\"main.js\">// External JS</script>-->\n" +
            "    <!-- Angular JS -->\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js\"></script>\n" +
            "    <!-- Font Awesome for Icons -->\n" +
            "    <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n" +
            "    <!-- Google Font for Status Icons -->\n" +
            "    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" +
            "    <!-- Chart JS -->\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js\"></script>\n" +
            "    <!-- JQuery -->\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body onload=\"onPageLoad()\">\n" +
            "<div style=\"position:fixed; top:0; right:0; font-size: xx-small; padding: 2px; background-color: aliceblue;\">\n" +
            "    <p>Powered by <b><a href=\"#\" style=\"text-decoration: none;\">Cooker Cucumber Reports v3.0.0</a></b></p>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"side-bar\">\n" +
            "    <div class=\"companylogo-holder\">\n" +
            "        <img class=\"companylogo\"\n" +
            "             src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAGDf+RsAAAACXBIWXMAAAsTAAALEwEAmpwYAAA50WlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS41LWMwMTQgNzkuMTUxNDgxLCAyMDEzLzAzLzEzLTEyOjA5OjE1ICAgICAgICAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIKICAgICAgICAgICAgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIgogICAgICAgICAgICB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIKICAgICAgICAgICAgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIKICAgICAgICAgICAgeG1sbnM6dGlmZj0iaHR0cDovL25zLmFkb2JlLmNvbS90aWZmLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIj4KICAgICAgICAgPHhtcDpDcmVhdG9yVG9vbD5BZG9iZSBQaG90b3Nob3AgQ0MgKFdpbmRvd3MpPC94bXA6Q3JlYXRvclRvb2w+CiAgICAgICAgIDx4bXA6Q3JlYXRlRGF0ZT4yMDIwLTA5LTI2VDExOjI3OjA4KzA1OjMwPC94bXA6Q3JlYXRlRGF0ZT4KICAgICAgICAgPHhtcDpNb2RpZnlEYXRlPjIwMjAtMDktMjhUMTA6MzI6NDgrMDU6MzA8L3htcDpNb2RpZnlEYXRlPgogICAgICAgICA8eG1wOk1ldGFkYXRhRGF0ZT4yMDIwLTA5LTI4VDEwOjMyOjQ4KzA1OjMwPC94bXA6TWV0YWRhdGFEYXRlPgogICAgICAgICA8ZGM6Zm9ybWF0PmltYWdlL3BuZzwvZGM6Zm9ybWF0PgogICAgICAgICA8cGhvdG9zaG9wOkNvbG9yTW9kZT4zPC9waG90b3Nob3A6Q29sb3JNb2RlPgogICAgICAgICA8eG1wTU06SW5zdGFuY2VJRD54bXAuaWlkOjM4YzAyZjI4LWEzM2YtYjI0MC05YmVhLTVhNTMwZmRmZTZlYzwveG1wTU06SW5zdGFuY2VJRD4KICAgICAgICAgPHhtcE1NOkRvY3VtZW50SUQ+eG1wLmRpZDphNDk0YWVlNy0xYmVlLTM5NDgtOGM0Yy1hNzRiZjlhMWYzNzg8L3htcE1NOkRvY3VtZW50SUQ+CiAgICAgICAgIDx4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ+eG1wLmRpZDphNDk0YWVlNy0xYmVlLTM5NDgtOGM0Yy1hNzRiZjlhMWYzNzg8L3htcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD4KICAgICAgICAgPHhtcE1NOkhpc3Rvcnk+CiAgICAgICAgICAgIDxyZGY6U2VxPgogICAgICAgICAgICAgICA8cmRmOmxpIHJkZjpwYXJzZVR5cGU9IlJlc291cmNlIj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OmFjdGlvbj5jcmVhdGVkPC9zdEV2dDphY3Rpb24+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDppbnN0YW5jZUlEPnhtcC5paWQ6YTQ5NGFlZTctMWJlZS0zOTQ4LThjNGMtYTc0YmY5YTFmMzc4PC9zdEV2dDppbnN0YW5jZUlEPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6d2hlbj4yMDIwLTA5LTI2VDExOjI3OjA4KzA1OjMwPC9zdEV2dDp3aGVuPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6c29mdHdhcmVBZ2VudD5BZG9iZSBQaG90b3Nob3AgQ0MgKFdpbmRvd3MpPC9zdEV2dDpzb2Z0d2FyZUFnZW50PgogICAgICAgICAgICAgICA8L3JkZjpsaT4KICAgICAgICAgICAgICAgPHJkZjpsaSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDphY3Rpb24+c2F2ZWQ8L3N0RXZ0OmFjdGlvbj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0Omluc3RhbmNlSUQ+eG1wLmlpZDozOGMwMmYyOC1hMzNmLWIyNDAtOWJlYS01YTUzMGZkZmU2ZWM8L3N0RXZ0Omluc3RhbmNlSUQ+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDp3aGVuPjIwMjAtMDktMjhUMTA6MzI6NDgrMDU6MzA8L3N0RXZ0OndoZW4+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDpzb2Z0d2FyZUFnZW50PkFkb2JlIFBob3Rvc2hvcCBDQyAoV2luZG93cyk8L3N0RXZ0OnNvZnR3YXJlQWdlbnQ+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDpjaGFuZ2VkPi88L3N0RXZ0OmNoYW5nZWQ+CiAgICAgICAgICAgICAgIDwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpTZXE+CiAgICAgICAgIDwveG1wTU06SGlzdG9yeT4KICAgICAgICAgPHRpZmY6T3JpZW50YXRpb24+MTwvdGlmZjpPcmllbnRhdGlvbj4KICAgICAgICAgPHRpZmY6WFJlc29sdXRpb24+NzIwMDAwLzEwMDAwPC90aWZmOlhSZXNvbHV0aW9uPgogICAgICAgICA8dGlmZjpZUmVzb2x1dGlvbj43MjAwMDAvMTAwMDA8L3RpZmY6WVJlc29sdXRpb24+CiAgICAgICAgIDx0aWZmOlJlc29sdXRpb25Vbml0PjI8L3RpZmY6UmVzb2x1dGlvblVuaXQ+CiAgICAgICAgIDxleGlmOkNvbG9yU3BhY2U+NjU1MzU8L2V4aWY6Q29sb3JTcGFjZT4KICAgICAgICAgPGV4aWY6UGl4ZWxYRGltZW5zaW9uPjUxMjwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj41MTI8L2V4aWY6UGl4ZWxZRGltZW5zaW9uPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAKPD94cGFja2V0IGVuZD0idyI/Pld/xr0AAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAAW7hJREFUeNrkW09IVEEc/maxS9LB8hIpYYgVtHUJgrZDXWpDQiIil8IIgg5L2BIJkfSHbnYQSaN/eKhozbqoWXnpEkLQLY1cuizqJfFQSUFJTod8tvvezLyZNzPvbbsDHuS9nfl93+/7fvN783YJpRSVPGIRrv0aAC3464wiCBKBAmQWJOWoACoJ3rm3JxIFkL4J88jTcQ9w1jo0HQfjPmI4lqL/q6ymXBK4+1phkM4cpomwagGajlM3+ObnOWl1cdRBaTreW/IWUM26qmR11WDNAqaBh2WLmBW5j0wZL6a2bKFlAVtZt2kLIxaICrgNW8RKUe5h2kLaAlFn3ZQtlC1Q6sB1bRFTkXvLaK4kwUva4o60Bf6XrAexhftJ001AWQBXIaKQAI/ch/O/yubkh0eCQ0AXgAvllHVJIlYIoJUAnkVCDBU+HALu+Xil7C3gKYLJ4UmMzdByBc4koOK3wYpshGKcdpL5EHGgnvw3wBngh1i4eAr4LdohSlkNPkX8DIC7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\" />\n" +
            "    </div>\n" +
            "\n" +
            "    <div onClick=\"profilPage()\" style=\"margin-top: 1rem;margin-bottom: 2rem;\" class=\"user-txt-holder\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <p class=\"user-txt\">@PROFILELETTER</p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div onclick=\"dispTub(0)\" class=\"sidebar-menu\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <div class=\"menubox-01-selected\"></div>\n" +
            "            <p class=\"user-txt\"><i class=\"fa fa-tachometer\" aria-hidden=\"true\"></i></p>\n" +
            "        </div>\n" +
            "        <p id=\"nav-text\">Dashboard</p>\n" +
            "    </div>\n" +
            "\n" +
            "    <div onclick=\"dispTub(1)\" class=\"sidebar-menu\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <div class=\"menubox-02-selected\"></div>\n" +
            "            <p class=\"user-txt\"><i class=\"fa fa-bar-chart\" aria-hidden=\"true\"></i></p>\n" +
            "        </div>\n" +
            "        <p id=\"nav-text\">Graph</p>\n" +
            "    </div>\n" +
            "\n" +
            "    <div onclick=\"dispTub(2)\" class=\"sidebar-menu\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <div class=\"menubox-03-selected\"></div>\n" +
            "            <p class=\"user-txt\"><i class=\"fa fa-file-text-o\" aria-hidden=\"true\"></i></p>\n" +
            "        </div>\n" +
            "        <p id=\"nav-text\">Features</p>\n" +
            "    </div>\n" +
            "\n" +
            "    <div onclick=\"dispTub(3)\" class=\"sidebar-menu\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <div class=\"menubox-04-selected\"></div>\n" +
            "            <p class=\"user-txt\"><i class=\"fa fa-list-alt\" aria-hidden=\"true\"></i></p>\n" +
            "        </div>\n" +
            "        <p id=\"nav-text\">Scenarios</p>\n" +
            "    </div>\n" +
            "\n" +
            "    <div onclick=\"dispTub(4)\" class=\"sidebar-menu\">\n" +
            "        <div class=\"boxborder\">\n" +
            "            <div class=\"menubox-05-selected\"></div>\n" +
            "            <p class=\"user-txt\"><i class=\"fa fa-info-circle\" aria-hidden=\"true\"></i></p>\n" +
            "        </div>\n" +
            "        <p id=\"nav-text\">Log</p>\n" +
            "    </div>\n" +
            "\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "<div class=\"content\">\n" +
            "\n" +
            "    <div class=\"dashboard-content\">\n" +
            "        <div class=\"container-title\">Dashboard\n" +
            "            <i id=\"info-tooltip\" style=\"margin-left: 5px; font-size: medium;\" class=\"fa fa-info-circle\"\n" +
            "               aria-hidden=\"true\"></i>\n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "        <div id=\"dash\">\n" +
            "\n" +
            "\n" +
            "            <div class=\"dash-overview\">\n" +
            "                Cooker Cucumber Report\n" +
            "                <p class=\"e16c4cmj0 css-15s48jc-Text\"><b>Generated at : </b> <span>@REPORTGENERATIONDATE</span>\n" +
            "                </p>\n" +
            "                <br>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"someotherdata\">\n" +
            "                <div>Project Information</div>\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(2)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Project Name</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @PROJECTNAME<br>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(2)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Execution By</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @EXECUTORNAME<br>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(2)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Execution Host</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @HOSTNAME<br>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(2)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Execution Time</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @TOTALEXECUTIONTIME<br>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"feature-content\">\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(2)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Total Features </p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @TOTALFEATURES\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Pass</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @FEATUREPASS\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Fail</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @FEATUREFAIL\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Skip</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @FEATURESKIP\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Others</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @FEATUREOTHERS\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "            </div>\n" +
            "\n" +
            "            <div class=\"scenario-content\">\n" +
            "                <div class=\"css-xmwpqf-Box e1slfth00\" onclick=\"dispTub(3)\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Total Scenarios</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @TOTALSCENARIO\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Pass</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @SCENARIOPASS\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Fail</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @SCENARIOFAIL\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Skip</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @SCENARIOSKIP\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "\n" +
            "                <div style=\"margin-top: 1rem;\" class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                    <p class=\"e16c4cmj0 css-15s48jc-Text\">Others</p>\n" +
            "                    <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                        <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                        @SCENARIOOTHERS\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "        <div id=\"side-dash\"\n" +
            "             style=\"position: relative; top:0; right:0; padding: 2px; background-color: white; height: 80%; width: 15rem; margin: 1rem; border-radius: 8px;\">\n" +
            "            <div>\n" +
            "                <p>Features</p>\n" +
            "                <hr>\n" +
            "                <div class=\"chart-container\" style=\"position: relative; height:15vh; width:15vw\">\n" +
            "                    <canvas id=\"myChart1\"></canvas>\n" +
            "                    <script>\n" +
            "                            //var x = document.getElementById(\"cars\").value;\n" +
            "                            var ctx = document.getElementById('myChart1').getContext('2d');\n" +
            "                            var myChart = new Chart(ctx, {\n" +
            "                                type: 'horizontalBar',\n" +
            "                                data: {\n" +
            "                                    labels: [\"Pass\", \"Fail\", \"Skip\", \"Others\"],\n" +
            "                                    datasets: [\n" +
            "                                        {\n" +
            "                                            labels: [\"Pass\", \"Fail\", \"Skip\", \"Others\"],\n" +
            "                                            backgroundColor: [\"#3cba9f\", \"#3e95cd\", \"#8e5ea2\", \"#e8c3b9\", \"#c45850\"],\n" +
            "                                            data: [@FEATUREPASS, @FEATUREFAIL, @FEATURESKIP, @FEATUREOTHERS]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            options: {\n" +
            "                                responsive: true,\n" +
            "                                    maintainAspectRatio: false,\n" +
            "                                        legend: {\n" +
            "                                    display: false\n" +
            "                                },\n" +
            "                                tooltips: {\n" +
            "                                    enabled: true\n" +
            "                                }\n" +
            "                            }\n" +
            "                        });\n" +
            "                        </script>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <hr>\n" +
            "            <div>\n" +
            "                <p>Scenarios</p>\n" +
            "                <hr>\n" +
            "                <div class=\"chart-container\" style=\"position: relative; height:15vh; width:15vw\">\n" +
            "                    <canvas id=\"myChart12\"></canvas>\n" +
            "                    <script>\n" +
            "                            //var x = document.getElementById(\"cars\").value;\n" +
            "                            var ctx = document.getElementById('myChart12').getContext('2d');\n" +
            "                            var myChart = new Chart(ctx, {\n" +
            "                                type: 'horizontalBar',\n" +
            "                                data: {\n" +
            "                                    labels: [\"Pass\", \"Fail\", \"Skip\", \"Others\"],\n" +
            "                                    datasets: [\n" +
            "                                        {\n" +
            "                                            labels: [\"Pass\", \"Fail\", \"Skip\", \"Others\"],\n" +
            "                                            backgroundColor: [\"#3cba9f\", \"#3e95cd\", \"#8e5ea2\", \"#e8c3b9\", \"#c45850\"],\n" +
            "                                            data: [@SCENARIOPASS, @SCENARIOFAIL, @SCENARIOSKIP, @SCENARIOOTHERS]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            options: {\n" +
            "                                responsive: true,\n" +
            "                                    maintainAspectRatio: false,\n" +
            "                                        legend: {\n" +
            "                                    display: false\n" +
            "                                },\n" +
            "                                tooltips: {\n" +
            "                                    enabled: true\n" +
            "                                }\n" +
            "                            }\n" +
            "                        });\n" +
            "                        </script>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"graph-content\">\n" +
            "\n" +
            "        <div class=\"container-title\">Graph<i style=\"margin-left: 5px; font-size: medium;\" class=\"fa fa-info-circle\"\n" +
            "                                             aria-hidden=\"true\"></i></div>\n" +
            "\n" +
            "        <div class=\"chart-container\" style=\"position: relative; height:20vh; width:40vw\">\n" +
            "            <p>Execution Trend</p>\n" +
            "            <p><i>please select the chart</i></p>\n" +
            "            <canvas id=\"myChartGraph\"></canvas>\n" +
            "            <select name=\"cars\" id=\"cars\" style=\"position:absolute; top:0; right:0;\" onchange=\"changeGraph()\">\n" +
            "                <option value=\"pie\">Pie</option>\n" +
            "                <option value=\"line\">Line</option>\n" +
            "                <option value=\"doughnut\">Dough Nut</option>\n" +
            "                <option value=\"radar\">Radar</option>\n" +
            "                <option value=\"bar\">Bar</option>\n" +
            "                <option value=\"polarArea\">Polar</option>\n" +
            "            </select>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"feature-content\">\n" +
            "\n" +
            "        <div class=\"container-title\">Features<i style=\"margin-left: 5px; font-size: medium;\"\n" +
            "                                                class=\"fa fa-info-circle\" aria-hidden=\"true\"></i></div>\n" +
            "\n" +
            "\n" +
            "        <!-- Features List Start -->\n" +
            "        <div class=\"css-featurestable\">\n" +
            "            <div style=\"display:inline-flex\">\n" +
            "                <input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"Search feature names..\">\n" +
            "                <br>\n" +
            "                <button onclick=\"clearinput()\"><i class=\"material-icons\">cancel</i></button>\n" +
            "            </div>\n" +
            "\n" +
            "            <table id=\"myTable\" border=\"1\">\n" +
            "                <tr class=\"header\"\n" +
            "                    style=\"color: white; background-color:rgb(8, 23, 54) ; text-transform: capitalize;text-decoration: none;font-weight:normal;\">\n" +
            "                    <th>\n" +
            "                        <div>Names</div>\n" +
            "                    </th>\n" +
            "                    <th>\n" +
            "                        <div>Status</div>\n" +
            "                    </th>\n" +
            "                    <th>\n" +
            "                        <div>Duration</div>\n" +
            "                    </th>\n" +
            "                    <th style=\"display: none;\">\n" +
            "                        <div>NA</div>\n" +
            "                    </th>\n" +
            "                </tr>\n" +
            "                @DATA\n" +
            "            </table>\n" +
            "\n" +
            "        </div>\n" +
            "        <!-- Features List End -->\n" +
            "\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"scenario-content\">\n" +
            "\n" +
            "        <div class=\"container-title\">Scenarios<i style=\"margin-left: 5px; font-size: medium;\"\n" +
            "                                                 class=\"fa fa-info-circle\" aria-hidden=\"true\"></i></div>\n" +
            "\n" +
            "        <h1>COMING SOON!!</h1>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"log-content\">\n" +
            "\n" +
            "        <div class=\"container-title\">Log Details<i style=\"margin-left: 5px; font-size: medium;\"\n" +
            "                                                   class=\"fa fa-info-circle\" aria-hidden=\"true\"></i></div>\n" +
            "\n" +
            "\n" +
            "        <div id=\"dash\">\n" +
            "            <div>\n" +
            "                <p>@LOGDATA</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"profile-content\">\n" +
            "\n" +
            "        <div class=\"container-title\">Profile<i style=\"margin-left: 5px; font-size: medium;\"\n" +
            "                                               class=\"fa fa-info-circle\" aria-hidden=\"true\"></i></div>\n" +
            "\n" +
            "        <div class=\"user-content\">\n" +
            "            <div class=\"css-xmwpqf-Box e1slfth00\">\n" +
            "                <p class=\"e16c4cmj0 css-15s48jc-Text\">Executed By </p>\n" +
            "                <div class=\"css-lsdv8t-Box e1slfth00\">\n" +
            "                    <div class=\"css-crie0s-Box e1slfth00\"></div>\n" +
            "                    @EXECUTORNAME <i class=\"material-icons\">\n" +
            "                    verified\n" +
            "                </i>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <script>\n" +
            "            function clearinput() {\n" +
            "                document.getElementById(\"myInput\").value = \"\";\n" +
            "                myFunction();\n" +
            "            }\n" +
            "\n" +
            "            function myFunction() {\n" +
            "                test();\n" +
            "\n" +
            "                // Declare variables\n" +
            "                var input, filter, table, tr, td, i, txtValue;\n" +
            "                input = document.getElementById(\"myInput\");\n" +
            "                filter = input.value.toUpperCase();\n" +
            "                table = document.getElementById(\"myTable\");\n" +
            "                tr = table.getElementsByTagName(\"tr\");\n" +
            "\n" +
            "                console.log(\"hello \" + filter);\n" +
            "\n" +
            "                // Loop through all table rows, and hide those who don't match the search query\n" +
            "                for (i = 1; i < tr.length; i++) {\n" +
            "                    td = tr[i].getElementsByTagName(\"th\")[0];\n" +
            "                    if (td) {\n" +
            "                        txtValue = td.textContent || td.innerText;\n" +
            "                        console.log(\"td\" + txtValue)\n" +
            "                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\n" +
            "                            tr[i].style.display = \"\";\n" +
            "                        } else {\n" +
            "                            tr[i].style.display = \"none\";\n" +
            "                        }\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "\n" +
            "            function test() {\n" +
            "                console.log(\"intest\");\n" +
            "                $(document).ready(function () {\n" +
            "                    $('tr:not(.header)').hide();\n" +
            "                });\n" +
            "            }\n" +
            "\n" +
            "            $(document).ready(function () {\n" +
            "                $('tr:not(.header)').hide();\n" +
            "\n" +
            "                $('tr.header').click(function () {\n" +
            "                    $(this).find('span').text(function (_, value) {\n" +
            "                        return value == 'expand_more' ? 'expand_less' : 'expand_more'\n" +
            "                    });\n" +
            "\n" +
            "                    $(this).nextUntil('tr.header').slideToggle(100, function () { });\n" +
            "                });\n" +
            "            });\n" +
            "\n" +
            "\n" +
            "            /////////////////////////////////////////////////////\n" +
            "\n" +
            "            function changeGraph() {\n" +
            "                var x = document.getElementById(\"cars\").value;\n" +
            "                var ctx = document.getElementById('myChartGraph').getContext('2d');\n" +
            "                var myChart = new Chart(ctx, {\n" +
            "                    type: x,\n" +
            "                    data: {\n" +
            "                        labels: ['Pass', 'Fail', 'Skip', 'Others'],\n" +
            "                        datasets: [{\n" +
            "                            label: 'Features',\n" +
            "                            data: [@FEATUREPASS, @FEATUREFAIL, @FEATURESKIP, @FEATUREOTHERS],\n" +
            "                backgroundColor: \"rgba(153,255,51,0.4)\"\n" +
            "            }, {\n" +
            "                label: 'Scenarios',\n" +
            "                    data: [@SCENARIOPASS, @SCENARIOFAIL, @SCENARIOSKIP, @SCENARIOOTHERS],\n" +
            "                backgroundColor: \"rgba(255,153,0,0.4)\"\n" +
            "            }]\n" +
            "        }\n" +
            "    });\n" +
            "}\n" +
            "            ////////////////////////////////////////////////////\n" +
            "\n" +
            "\n" +
            "            function onPageLoad() {\n" +
            "                dispTub(0);\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "            function profilPage() {\n" +
            "                var selectColor = 'rgb(96, 128, 197)';\n" +
            "\n" +
            "                revertSideMenu();\n" +
            "\n" +
            "                var profile = document.getElementsByClassName(\"user-txt-holder\");\n" +
            "                profile[0].getElementsByClassName('boxborder')[0].style.backgroundColor = selectColor;\n" +
            "\n" +
            "                perfromContentLoad(5);\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "            function dispTub(what) {\n" +
            "                var selectColor = 'rgb(96, 128, 197)';\n" +
            "                revertSideMenu();\n" +
            "\n" +
            "                var _sidebar = document.getElementsByClassName(\"sidebar-menu\");\n" +
            "                var borderbox = _sidebar[what].getElementsByTagName('div')[0];\n" +
            "                var selectedline = _sidebar[what].getElementsByTagName('div')[1]\n" +
            "                selectedline.style.display = 'block';\n" +
            "                borderbox.style.backgroundColor = selectColor;\n" +
            "\n" +
            "                perfromContentLoad(what);\n" +
            "            }\n" +
            "\n" +
            "            function revertSideMenu() {\n" +
            "\n" +
            "                var profile = document.getElementsByClassName(\"user-txt-holder\");\n" +
            "                profile[0].getElementsByClassName('boxborder')[0].style.backgroundColor = 'rgb(27, 45, 85)';\n" +
            "\n" +
            "                var sidebarBoxes = document.getElementsByClassName(\"sidebar-menu\");\n" +
            "                for (var i = 0; i < sidebarBoxes.length; i++) {\n" +
            "                    var borderbox = sidebarBoxes[i].getElementsByTagName('div')[0];\n" +
            "                    var selectedline = sidebarBoxes[i].getElementsByTagName('div')[1]\n" +
            "                    selectedline.style.display = 'none';\n" +
            "                    borderbox.style.backgroundColor = 'rgb(27, 45, 85)';\n" +
            "                }\n" +
            "            }\n" +
            "\n" +
            "            function perfromContentLoad(what) {\n" +
            "\n" +
            "                console.log('in pagecontentload ' + what);\n" +
            "\n" +
            "                hideAllPages();\n" +
            "\n" +
            "                var pages = document.getElementsByClassName(\"content\")[0];\n" +
            "\n" +
            "                pages.children[what].style.display = 'block';\n" +
            "                console.log(\"Enabled : \" + pages.children[what].getAttribute('class'));\n" +
            "\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "            function hideAllPages() {\n" +
            "\n" +
            "                var pages = document.getElementsByClassName(\"content\")[0];\n" +
            "                var a = pages.children.length;\n" +
            "\n" +
            "                for (var i = 0; i < a; i++) {\n" +
            "                    pages.children[i].style.display = 'none';\n" +
            "\n" +
            "                    console.log(\"Disabled : \" + pages.children[i].getAttribute('class'));\n" +
            "                }\n" +
            "\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "\n" +
            "            function myFunction1() {\n" +
            "\n" +
            "                // Declare variables\n" +
            "                var input, filter, table, tr, td, i, txtValue;\n" +
            "                input = document.getElementById(\"myInputscenario\");\n" +
            "                filter = input.value.toUpperCase();\n" +
            "                table = document.getElementById(\"scemariotable\");\n" +
            "                tr = table.getElementsByTagName(\"tr\");\n" +
            "\n" +
            "                console.log(\"hello \" + filter);\n" +
            "\n" +
            "                // Loop through all table rows, and hide those who don't match the search query\n" +
            "                for (i = 1; i < tr.length; i++) {\n" +
            "                    td = tr[i].getElementsByTagName(\"th\")[0];\n" +
            "                    if (td) {\n" +
            "                        txtValue = td.textContent || td.innerText;\n" +
            "                        console.log(\"td\" + txtValue)\n" +
            "                        if (txtValue.toUpperCase().indexOf(filter) > -1) {\n" +
            "                            tr[i].style.display = \"\";\n" +
            "                        } else {\n" +
            "                            tr[i].style.display = \"none\";\n" +
            "                        }\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        </script>\n" +
            "\n" +
            "</body>\n" +
            "\n" +
            "</html>";
}
