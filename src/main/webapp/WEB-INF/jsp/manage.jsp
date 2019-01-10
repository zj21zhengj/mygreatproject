<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/static/css/codemirror.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/static/css/itranswarp.css" />
    <script src="${pageContext.request.contextPath}/asset/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/underscore.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/sha1.min.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/qrcode.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/jquery.qrcode.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/codemirror.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/marked.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/uikit.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/autocomplete.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/sticky.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/tooltip.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/notify.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/timepicker.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/uikit/components/htmleditor.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/vue.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/vue-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/asset/static/js/itranswarp.js"></script>
</head>
<body>
<div id="modal-upload-image" class="uk-modal">
    <div class="uk-modal-dialog">
        <div class="uk-modal-header">Upload Image</div>
        <div class="x-upload-preview" style="background-repeat:no-repeat;background-position:center center;background-size:cover;height:320px;border:solid 1px #ccc">
            Preview
        </div>
        <div>
            <form class="uk-form uk-form-stacked">
                <div class="uk-alert uk-alert-danger" style="display:none;">
                    ERROR: upload failed.
                </div>
                <div class="uk-form-row">
                    <label class="uk-form-label">Image File</label>
                    <div class="uk-form-controls">
                        <input name="file" type="file">
                    </div>
                </div>
                <div class="uk-form-row">
                    <label class="uk-form-label">Image Name</label>
                    <div class="uk-form-controls">
                        <input name="name">
                    </div>
                </div>
                <div class="uk-form-row">
                    <div class="uk-form-controls">
                        <button type="submit" disabled class="uk-button uk-button-primary"><i class="uk-icon-upload"></i> Upload</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="uk-modal-footer uk-text-right">
            <button type="button" class="uk-button x-cancel">Cancel</button>
        </div>
    </div>
</div>
<div id="header" class="uk-navbar uk-navbar-attached">
    <div class="uk-container x-container">
        <div class="uk-navbar uk-navbar-attached">
            <a href="/" target="_blank" class="uk-navbar-brand"><i class="uk-icon-home"></i></a>
            <ul id="ul-navbar" class="uk-navbar-nav">
                <div class="uk-navbar-content">Management</div>
                <li><a href="/manage/discuss/">Discuss</a></li>
                <li><a href="/manage/article/">Articles')</a></li>
                <li><a href="/manage/webpage/">Web Pages</a></li>
                <li><a href="/manage/wiki/">Wikis</a></li>
                <li><a href="/manage/attachment/">Attachments</a></li>
                <li><a href="/manage/user/">Users</a></li>
                <li><a href="/manage/navigation/">Navigations</a></li>
                <li><a href="/manage/ad/">AD</a></li>
                <li><a href="/manage/setting/">Settings</a></li>
                <!-- <li><a href="/manage/api/">API</a></li> -->
            </ul>

            <div class="uk-navbar-flip">
                <ul class="uk-navbar-nav">
                    <li class="uk-parent" data-uk-dropdown>
                        <a href="#0"><i class="uk-icon-user"></i><span>&nbsp;</span><span class="x-user-name">{{ __user__.name }}</span></a>
                        <div class="uk-dropdown uk-dropdown-navbar">
                            <ul class="uk-nav uk-nav-navbar">
                                <li><a href="/auth/signout"><i class="uk-icon-power-off"></i> {{ _('Sign Out') }}</a></li>
                            </ul>
                        </div>
                    </li>
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
            <rapid:block name="block-main">
            <div class="uk-width-1-6">
                <ul class="uk-nav uk-nav-side">
                    <li class="uk-nav-header">Sample Menu</li>
                    <li id="menu-1"><a href="#0">Menu 1</a></li>
                    <li id="menu-2"><a href="#0">Menu 2</a></li>
                    <li id="menu-3"><a href="#0">Menu 3</a></li>
                </ul>
            </div>
            <div class="uk-width-5-6">
                <h3>Content</h3>
            </div>
            </rapid:block>
        </div>
    </div>
    <div class="x-push-to-bottom"></div>
</div>

<div id="footer">
    <div class="uk-container x-container">
        <hr>
        <div class="uk-grid">
            <div class="uk-width-2-6">
                <p>
                    <a href="/">{{ __website__.name }}</a>&copy;2015
                    <br>
                    Powered by <a href="http://js.itranswarp.com" target="_blank">iTranswarp.js</a>
                </p>
            </div>
            <div class="uk-width-2-6">
                <a href="https://github.com/michaelliao/itranswarp.js" target="_blank" class="uk-icon-button uk-icon-github" data-uk-tooltip title="Source code"></a>
                <a href="#0" id="wechat-link" target="_blank" class="uk-icon-button uk-icon-wechat" data-uk-tooltip title="Follow author on Wechat">
                    <div id="wechat" class="uk-panel uk-panel-box">
                        <div id="wechat-qrcode"></div>
                    </div>
                </a>
                <a href="https://twitter.com/liaoxuefeng" target="_blank" class="uk-icon-button uk-icon-twitter" data-uk-tooltip title="Follow author on Twitter"></a>
                <a href="http://www.weibo.com/liaoxuefeng" target="_blank" class="uk-icon-button uk-icon-weibo uk-visible-large uk-hidden-medium" data-uk-tooltip title="Follow author on Weibo"></a>
            </div>
            <div class="uk-width-2-6">
                <p>
                    <a href="https://github.com/michaelliao/itranswarp.js/issues" target="_blank">Feedback</a>
                    <br>
                    <a href="https://github.com/michaelliao/itranswarp.js/blob/master/LICENSE" target="_blank">License</a>
                </p>
            </div>
        </div>
    </div>
</div>

<div id="oldBrowser">
    <div class="uk-alert uk-alert-danger" data-uk-alert>
        <a href="#0" class="uk-alert-close uk-close"></a>
        <p>
            WARNING: You are using an old browser that does not support HTML5.
            Please choose a modern browser (<a href="http://www.google.com/chrome" target="_blank">Chrome</a> / <a href="http://www.mozilla.org/firefox/" target="_blank">Firefox</a> / <a href="http://www.apple.com/safari/" target="_blank">Sarafi</a>) to get a good experience.
        </p>
    </div>
</div>
</body>
</html>
