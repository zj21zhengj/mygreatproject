<%--
  Created by IntelliJ IDEA.
  User: zhengj
  Date: 2018/12/10
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<style>
    .x-center {
        margin: 0;
    }

    .x-center {
        margin-left: 316px;
        padding-left: 15px;
    }
</style>
<head>
    <title>Title</title>
    <!--搞不懂为什么公司的项目不用加{pageContext.request.contextPath}，直接../就好-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/uikit/css/uikit.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/static/themes/default/css/all.css?v=bc43d83" />
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/asset/uikit/js/uikit.min.js"></script>
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

<div id="main">
    <div class="x-placeholder-50"><!-- placeholder --></div>
    <div class="x-placeholder"><!-- placeholder --></div>
    <div class="uk-container x-container">
        <div class="uk-grid">
            <div class="x-body-top uk-width-1-1">
            </div>
            <div class="uk-width-1-1">
                <div class="x-sidebar-left">
                    <div class="x-sidebar-left-top">
                    </div>
                    <div class="x-sidebar-left-content">
                        <rapid:block name="left-content">base_head</rapid:block>
                    </div>
                    <div class="x-sidebar-left-bottom">
                    </div>
                    <div id="x-sponsor-b" class="uk-clearfix"><!-- sponsor B --></div>
                </div>

                <div class="x-center">
                    <div class="x-content-top">
                    </div>
                    <div class="x-content" style="width:100%">
                        <rapid:block name="block content"><p>TODO: override block <em>content</em></p></rapid:block>
                    </div>
                    <div class="x-content-bottom">
                    </div>
                </div>
            </div>

            <div class="x-body-bottom uk-width-1-1">

            </div>
        </div>
    </div>
</div>


<div id="footer">
    <div class="x-footer uk-container x-container">
        <hr>
        <div class="uk-grid">
            <div class="x-footer-copyright uk-width-small-1-2 uk-width-medium-1-3">
                <p>
                    <a href="/">{{ __website__.name }}</a>&copy;2017 v{{ __version__ }}
                    <br>
                    Powered by <a href="https://github.com/michaelliao/itranswarp.js" target="_blank">iTranswarp.js</a>
                </p>
            </div>
            <div class="uk-width-small-1-2 uk-width-medium-1-3 x-hidden-tiny">
                <a href="/feed" target="_blank" class="uk-icon-button uk-icon-rss" data-uk-tooltip title="Subscribe the RSS"></a>
                <a href="https://github.com/michaelliao/itranswarp.js" target="_blank" class="uk-icon-button uk-icon-github" data-uk-tooltip title="View source code on GitHub"></a>
                <a href="https://twitter.com/liaoxuefeng" target="_blank" class="uk-icon-button uk-icon-twitter" data-uk-tooltip title="Follow author on Twitter"></a>
                <a href="https://www.weibo.com/liaoxuefeng" target="_blank" class="uk-icon-button uk-icon-weibo uk-visible-large uk-hidden-medium" data-uk-tooltip title="Follow author on Weibo"></a>
            </div>
            <div class="uk-width-medium-1-3 uk-hidden-small">
                <p>
                    <a href="https://github.com/michaelliao/itranswarp.js/issues" target="_blank">{{ _('Feedback') }}</a>
                    <br>
                    <a href="https://github.com/michaelliao/itranswarp.js/blob/master/LICENSE" target="_blank">{{ _('License') }}</a>
                </p>
            </div>
        </div>
    </div>
</div>

<div id="modal-signin" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        <div class="uk-modal-header">
            <h2>Please Sign In</h2>
        </div>
        <p>You can sign in directly without register:</p>
        <p>You need authorize to allow connect to your social passport for the first time.</p>
    </div>
</div>

<div id="oldBrowser">
    <div class="uk-alert uk-alert-danger" data-uk-alert>
        <a href="#0" class="uk-alert-close uk-close"></a>
        <p>
            WARNING: You are using an old browser that does not support HTML5.
            Please choose a modern browser (<a href="https://www.google.com/chrome" target="_blank">Chrome</a> / <a href="https://www.microsoft.com/windows/microsoft-edge" target="_blank">Microsoft Edge</a> / <a href="https://www.mozilla.org/firefox/" target="_blank">Firefox</a> / <a href="https://www.apple.com/safari/" target="_blank">Sarafi</a>) to get a good experience.
        </p>
    </div>
</div>
</body>
</html>
