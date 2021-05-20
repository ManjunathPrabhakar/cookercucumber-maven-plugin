<!--side menu bar start-->
<div class="side-bar">
    <div class="companylogo-holder">
        <a target="_blank" href="https://manjunathprabhakar.github.io/cookercucumber-maven-plugin/"
           style="text-decoration: none;">
            <img class="companylogo" src="${cookerlogo}" alt="logo"/>
        </a>
    </div>
    <div class="user-txt-holder"
         style="margin-top: 1rem;margin-bottom: 2rem;">
        <div class="boxborder">
            <p class="user-txt">${userLetter}</p>
        </div>
    </div>
    <div class="sidebar-menu" onclick="enableView(0)">
        <div class="boxborder">
            <div class="menubox-01-selected"></div>
            <p class="user-txt">
                <i class="fa fa-tachometer" aria-hidden="true"></i>
            </p>
        </div>
        <p class="nav-text">Dashboard</p>
    </div>
    <div class="sidebar-menu" onclick="enableView(1)">
        <div class="boxborder">
            <div class="menubox-02-selected"></div>
            <p class="user-txt">
                <i class="fa fa-bar-chart" aria-hidden="true"></i>
                <!--                <i class="material-icons" style="vertical-align: -6px;">analytics</i>-->
            </p>
        </div>
        <p class="nav-text">Graph</p>
    </div>
    <div class="sidebar-menu" onclick="enableView(2)/*enableView(3)*/">
        <div class="boxborder">
            <div class="menubox-04-selected"></div>
            <p class="user-txt">
                <i class="fa fa-list-alt" aria-hidden="true"></i>
                <!--                <i class="material-icons" style="vertical-align: -6px;">article</i>-->
            </p>
        </div>
        <p class="nav-text">Features</p>
    </div>
    <div class="sidebar-menu"
         onclick="enableView(3)">
        <div class="boxborder">
            <div class="menubox-05-selected"></div>
            <p class="user-txt">
                <i class="fa fa-info-circle" aria-hidden="true"></i>
                <!--                <i class="material-icons" style="vertical-align: -6px;">storage</i>-->
            </p>
        </div>
        <p class="nav-text">Logs</p>
    </div>
</div>
<!--side menu bar end-->