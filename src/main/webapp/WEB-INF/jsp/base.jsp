<%--
  Created by IntelliJ IDEA.
  User: zhengj
  Date: 2018/12/10
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../mygreatproject_war_exploded/asset/uikit/css/uikit.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="../asset/uikit/js/uikit.min.js"></script>
</head>
<body>
<div class="x-goto-top">
    <div class="x-arrow"></div>
    <div class="x-stick"></div>
</div>

<div id="header" class="uk-navbar uk-navbar-attached">
    <div class="uk-container x-container">
        <div id="navbar" class="uk-navbar uk-navbar-attached">

            <ul class="uk-navbar-nav uk-visible-small">
                <li><a href="#0" onclick="UIkit.offcanvas.show('#x-offcanvas-left')">目录</a></li>
            </ul>

            <a id="brand" href="/" class="uk-navbar-brand uk-visible-large">廖雪峰的官方网站</a>
            <a id="brand-small" href="/" class="uk-navbar-brand uk-hidden-large"><i class="uk-icon-home"></i></a>
            <a class="uk-hidden" href="/blog/1544454398070">Blog</a>
            <ul id="ul-navbar" class="uk-navbar-nav uk-hidden-small">

                <li class="x-nav"><a href="/category/0013738748415562fee26e070fa4664ad926c8e30146c67000">编程</a></li>

                <li class="x-nav"><a href="/category/0013738748248885ddf38d8cd1b4803aa74bcda32f853fd000">读书</a></li>

                <li class="x-nav"><a href="https://www.feiyangedu.com/category/JavaSE">JavaSE课程</a></li>

                <li class="x-nav"><a href="http://pro.kaikeba.com/course/java/?ss=topj">JavaEE课程</a></li>

                <li class="x-nav"><a href="https://www.feiyangedu.com/category/CryptoCurrency">数字货币</a></li>

                <li class="x-nav"><a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000">JavaScript教程</a></li>

                <li class="x-nav"><a href="/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000">Python教程</a></li>

                <li class="x-nav"><a href="/wiki/001508284671805d39d23243d884b8b99f440bfae87b0f4000">SQL教程</a></li>

                <li class="x-nav"><a href="/wiki/0013739516305929606dd18361248578c67b8067c8c017b000">Git教程</a></li>

                <li class="x-nav"><a href="/discuss">问答</a></li>

                <li class="x-nav"><a href="/webpage/donate">赞助</a></li>

                <li id="navbar-more" class="uk-parent" data-uk-dropdown style="display:none">
                    <a href="#0"><i class="uk-icon-chevron-down"></i> 更多</a>
                    <div class="uk-dropdown uk-dropdown-navbar">
                        <ul id="ul-navbar-more" class="uk-nav uk-nav-navbar">

                            <li class="x-nav"><a href="/category/0013738748415562fee26e070fa4664ad926c8e30146c67000">编程</a></li>

                            <li class="x-nav"><a href="/category/0013738748248885ddf38d8cd1b4803aa74bcda32f853fd000">读书</a></li>

                            <li class="x-nav"><a href="https://www.feiyangedu.com/category/JavaSE">JavaSE课程</a></li>

                            <li class="x-nav"><a href="http://pro.kaikeba.com/course/java/?ss=topj">JavaEE课程</a></li>

                            <li class="x-nav"><a href="https://www.feiyangedu.com/category/CryptoCurrency">数字货币</a></li>

                            <li class="x-nav"><a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000">JavaScript教程</a></li>

                            <li class="x-nav"><a href="/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000">Python教程</a></li>

                            <li class="x-nav"><a href="/wiki/001508284671805d39d23243d884b8b99f440bfae87b0f4000">SQL教程</a></li>

                            <li class="x-nav"><a href="/wiki/0013739516305929606dd18361248578c67b8067c8c017b000">Git教程</a></li>

                            <li class="x-nav"><a href="/discuss">问答</a></li>

                            <li class="x-nav"><a href="/webpage/donate">赞助</a></li>

                        </ul>
                    </div>
                </li>
            </ul>

            <ul id="ul-navbar-small" class="uk-navbar-nav uk-visible-small">
                <li class="uk-parent" data-uk-dropdown>
                    <a href="#0"><i class="uk-icon-navicon"></i></a>
                    <div class="uk-dropdown uk-dropdown-navbar">
                        <ul class="uk-nav uk-nav-navbar">

                            <li><a href="/category/0013738748415562fee26e070fa4664ad926c8e30146c67000">编程</a></li>

                            <li><a href="/category/0013738748248885ddf38d8cd1b4803aa74bcda32f853fd000">读书</a></li>

                            <li><a href="https://www.feiyangedu.com/category/JavaSE">JavaSE课程</a></li>

                            <li><a href="http://pro.kaikeba.com/course/java/?ss=topj">JavaEE课程</a></li>

                            <li><a href="https://www.feiyangedu.com/category/CryptoCurrency">数字货币</a></li>

                            <li><a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000">JavaScript教程</a></li>

                            <li><a href="/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000">Python教程</a></li>

                            <li><a href="/wiki/001508284671805d39d23243d884b8b99f440bfae87b0f4000">SQL教程</a></li>

                            <li><a href="/wiki/0013739516305929606dd18361248578c67b8067c8c017b000">Git教程</a></li>

                            <li><a href="/discuss">问答</a></li>

                            <li><a href="/webpage/donate">赞助</a></li>

                        </ul>
                    </div>
                </li>
            </ul>


            <!--
                            <div class="uk-navbar-content x-hidden-tiny">
                                <form id="form-search" class="uk-form uk-margin-remove uk-display-inline-block">
                                    <div class="uk-form-icon">
                                        <i class="uk-icon-search"></i>
                                        <input type="text" placeholder="Search">
                                    </div>
                                </form>
                            </div>
            -->

            <div id="navbar-user-info" class="uk-navbar-flip">
                <ul class="uk-navbar-nav">
                    <li class="uk-parent x-display-if-signin" data-uk-dropdown>
                        <a href="#0"><i class="uk-icon-user"></i><span class="x-hidden-tiny">&nbsp;</span><span class="x-user-name x-hidden-tiny"></span></a>
                        <div class="uk-dropdown uk-dropdown-navbar">
                            <ul class="uk-nav uk-nav-navbar">
                                <li><a target="_blank" href="/me/profile"><i class="uk-icon-cog"></i> 个人资料</a></li>
                                <li class="uk-nav-divider"></li>


                                <li><a href="/auth/signout"><i class="uk-icon-power-off"></i> 登出</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="x-display-if-not-signin uk-hidden-small"><a href="javascript:showSignin()"><i class="uk-icon-sign-in"></i> 登录</a></li>
                    <li class="x-display-if-not-signin uk-visible-small"><a href="javascript:showSignin()"><i class="uk-icon-sign-in"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div><!-- // header -->
</body>
</html>
