<%@ include file="/WEB-INF/jsp/base.jsp" %>
<style>
    .x-wiki-visible {
        display: block;
    }
    .x-can-edit {
        display: none;
    }
</style>

<script>
    function toggleWikiNode(icon) {
        var
            $i = $(icon),
            $div = $i.parent(),
            expand = $div.attr('expand');
        if (expand === 'true') {
            collapseWikiNode(icon);
        } else {
            expandWikiNode(icon);
        }
    }

    function collapseWikiNode(icon, rec) {
        var
            $i = $(icon),
            $div = $i.parent();
        $div.attr('expand', 'false');
        $i.removeClass('uk-icon-minus-square-o');
        $i.addClass('uk-icon-plus-square-o');
        $div.find('>div').hide();
        if (rec) {
            $div.find('>div>i').each(function () {
                collapseWikiNode(this, rec);
            });
        }
    }

    function expandWikiNode(icon, rec) {
        var
            $i = $(icon),
            $div = $i.parent();
        $div.attr('expand', 'true');
        $i.removeClass('uk-icon-plus-square-o');
        $i.addClass('uk-icon-minus-square-o');
        $div.find('>div').show();
        if (rec) {
            $div.find('>div>i').each(function () {
                expandWikiNode(this, rec);
            });
        }
    }
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="uk-float-right" style="padding-top:5px">
    <a href="#0" onclick="expandWikiNode($('#x-wiki-index>div>i').get(0), true)" style="margin-left:5px"><i class="uk-icon-expand"></i></a>
    <a href="#0" onclick="collapseWikiNode($('#x-wiki-index>div>i').get(0), true);expandActiveNode()" style="margin-left:5px"><i class="uk-icon-dot-circle-o"></i></a>
    <a href="#0" onclick="collapseWikiNode($('#x-wiki-index>div>i').get(0), true)" style="margin-left:5px"><i class="uk-icon-compress"></i></a>
</div>
<ul class="uk-nav uk-nav-side">
    <li class="uk-nav-header">目录</li>
</ul>
<ul id="x-wiki-index" class="uk-nav uk-nav-side" style="margin-right:-15px;">
    <div id="001434446689867b27157e896e74d51a89c25cc8b43bdb3000" depth="0" style="position:relative;margin-left:15px;">
        <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000" class="x-wiki-index-item">JavaScript教程</a>


        <div id="0014344991049250a2c80ec84cb4861bbd1d9b2c0c2850e000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344991049250a2c80ec84cb4861bbd1d9b2c0c2850e000" class="x-wiki-index-item">JavaScript简介</a>

        </div>

        <div id="00143449917624134f5c4695b524e81a581ab5a222b05ec000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449917624134f5c4695b524e81a581ab5a222b05ec000" class="x-wiki-index-item">快速入门</a>


            <div id="00143470025281435e4e03117a74438aaf98c4f7b30b307000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143470025281435e4e03117a74438aaf98c4f7b30b307000" class="x-wiki-index-item">基本语法</a>

            </div>

            <div id="001434499190108eec0bdf14e704a09935cd112e501e31a000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499190108eec0bdf14e704a09935cd112e501e31a000" class="x-wiki-index-item">数据类型和变量</a>

            </div>

            <div id="001434499203693072018f8878842a9b0011e3ff4e38b6b000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499203693072018f8878842a9b0011e3ff4e38b6b000" class="x-wiki-index-item">字符串</a>

            </div>

            <div id="00143449921138898cdeb7fc2214dc08c6c67827758cd2f000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449921138898cdeb7fc2214dc08c6c67827758cd2f000" class="x-wiki-index-item">数组</a>

            </div>

            <div id="00143449922400335c44d4b8c904ff29a78fd4334347131000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449922400335c44d4b8c904ff29a78fd4334347131000" class="x-wiki-index-item">对象</a>

            </div>

            <div id="0014345005693811782d9e338994ec19aa1c5325824bc15000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345005693811782d9e338994ec19aa1c5325824bc15000" class="x-wiki-index-item">条件判断</a>

            </div>

            <div id="001434500620831b2aeb535f5e245c788493e9f4ff416c0000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434500620831b2aeb535f5e245c788493e9f4ff416c0000" class="x-wiki-index-item">循环</a>

            </div>

            <div id="0014345007434430758e3ac6e1b44b1865178e7aff9082e000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345007434430758e3ac6e1b44b1865178e7aff9082e000" class="x-wiki-index-item">Map和Set</a>

            </div>

            <div id="00143450082788640f82a480be8481a8ce8272951a40970000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143450082788640f82a480be8481a8ce8272951a40970000" class="x-wiki-index-item">iterable</a>

            </div>
        </div>
    </div>
</ul>
<div class="x-placeholder"></div>

</div>
<div class="x-sidebar-left-bottom">
    <h3>关于作者</h3>
    <iframe width="100%" height="90" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=2&ptype=1&speed=0&skin=5&isTitle=0&noborder=0&isWeibo=0&isFans=0&uid=1658384301&verifier=078cedea&colors=0593d3,ffffff,666666,0593d3,0477ab&dpc=1"></iframe>

</div>
<div id="x-sponsor-b" class="uk-clearfix"><!-- sponsor B --></div>
</div>



<div class="x-center">
    <div class="x-content-top">
        <!-- content_top -->
    </div>
    <div class="x-content" style="width:100%">

        <h4>字符串和编码</h4>
        <div class="x-wiki-info"><span>阅读: 895464</span> <a href="/manage/wiki/edit_wikipage?id=001431664106267f12e9bef7ee14cf6a8776a479bdec9b9000" target="_blank" class="x-can-edit uk-text-danger">编辑</a></div>

        <hr>

        <div class="x-wiki-content x-main-content"><h3><a name="#-E5-AD-97-E7-AC-A6-E7-BC-96-E7-A0-81"></a>字符编码</h3>
            <p>我们已经讲过了，字符串也是一种数据类型，但是，字符串比较特殊的是还有一个编码问题。</p>
            <p>因为计算机只能处理数字，如果要处理文本，就必须先把文本转换为数字才能处理。最早的计算机在设计时采用8个比特（bit）作为一个字节（byte），所以，一个字节能表示的最大的整数就是255（二进制11111111=十进制255），如果要表示更大的整数，就必须用更多的字节。比如两个字节可以表示的最大整数是<code>65535</code>，4个字节可以表示的最大整数是<code>4294967295</code>。</p>
            <p>由于计算机是美国人发明的，因此，最早只有127个字符被编码到计算机里，也就是大小写英文字母、数字和一些符号，这个编码表被称为<code>ASCII</code>编码，比如大写字母<code>A</code>的编码是<code>65</code>，小写字母<code>z</code>的编码是<code>122</code>。</p>
            <p>但是要处理中文显然一个字节是不够的，至少需要两个字节，而且还不能和ASCII编码冲突，所以，中国制定了<code>GB2312</code>编码，用来把中文编进去。</p>
            <p>你可以想得到的是，全世界有上百种语言，日本把日文编到<code>Shift_JIS</code>里，韩国把韩文编到<code>Euc-kr</code>里，各国有各国的标准，就会不可避免地出现冲突，结果就是，在多语言混合的文本中，显示出来会有乱码。</p>
            <p><img src="https://cdn.liaoxuefeng.com/cdn/static/themes/default/img/loading.gif" data-src="https://cdn.liaoxuefeng.com/cdn/files/attachments/0013872491802084161ec9ef7d143a897e1584819535656000/0" alt="char-encoding-problem"></p>
            <p>因此，Unicode应运而生。Unicode把所有语言都统一到一套编码里，这样就不会再有乱码问题了。</p>
            <h3><a name="#-E5-B0-8F-E7-BB-93"></a>小结</h3>
            <p>Python 3的字符串使用Unicode，直接支持多语言。</p>
            <p>当<code>str</code>和<code>bytes</code>互相转换时，需要指定编码。最常用的编码是<code>UTF-8</code>。Python当然也支持其他编码方式，比如把Unicode编码成<code>GB2312</code>：</p>
            <pre><code>&gt;&gt;&gt; &#39;中文&#39;.encode(&#39;gb2312&#39;)
b&#39;\xd6\xd0\xce\xc4&#39;
</code></pre><p>但这种方式纯属自找麻烦，如果没有特殊业务要求，请牢记仅使用<code>UTF-8</code>编码。</p>
            <p>格式化字符串的时候，可以用Python的交互式环境测试，方便快捷。</p>
            <h3><a name="#-E5-8F-82-E8-80-83-E6-BA-90-E7-A0-81"></a>参考源码</h3>
            <p><a target="_blank" href="https://github.com/michaelliao/learn-python3/blob/master/samples/basic/the_string.py">the_string.py</a></p>
        </div>
    </div>
</div>
