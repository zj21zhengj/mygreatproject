<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
<rapid:override name="left-content">
<div class="uk-float-right" style="padding-top:5px">
    <a href="#0" onclick="expandWikiNode($('#x-wiki-index>div>i').get(0), true)" style="margin-left:5px"><i class="uk-icon-expand"></i></a>
    <a href="#0" onclick="collapseWikiNode($('#x-wiki-index>div>i').get(0), true);expandActiveNode()" style="margin-left:5px"><i class="uk-icon-dot-circle-o"></i></a>
    <a href="#0" onclick="collapseWikiNode($('#x-wiki-index>div>i').get(0), true)" style="margin-left:5px"><i class="uk-icon-compress"></i></a>
</div>
<ul class="uk-nav uk-nav-side">
    <li class="uk-nav-header">目录</li>
</ul>
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

        <div id="0014344992519683bcfa2e33760462fb5db8eb9430924be000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344992519683bcfa2e33760462fb5db8eb9430924be000" class="x-wiki-index-item">函数</a>


            <div id="00143449926746982f181557d9b423f819e89709feabdb4000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449926746982f181557d9b423f819e89709feabdb4000" class="x-wiki-index-item">函数定义和调用</a>

            </div>

            <div id="0014344993159773a464f34e1724700a6d5dd9e235ceb7c000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344993159773a464f34e1724700a6d5dd9e235ceb7c000" class="x-wiki-index-item">变量作用域与解构赋值</a>

            </div>

            <div id="0014345005399057070809cfaa347dfb7207900cfd116fb000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345005399057070809cfaa347dfb7207900cfd116fb000" class="x-wiki-index-item">方法</a>

            </div>

            <div id="001434499355829ead974e550644e2ebd9fd8bb1b0dd721000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499355829ead974e550644e2ebd9fd8bb1b0dd721000" class="x-wiki-index-item">高阶函数</a>


                <div id="001435119854495d29b9b3d7028477a96ed74db95032675000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001435119854495d29b9b3d7028477a96ed74db95032675000" class="x-wiki-index-item">map/reduce</a>

                </div>

                <div id="0014351219769203e3fbe1ed611475db3d439393add8997000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014351219769203e3fbe1ed611475db3d439393add8997000" class="x-wiki-index-item">filter</a>

                </div>

                <div id="0014351226817991a9c08f1ec0a45c99b9209bcfc71b8f6000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014351226817991a9c08f1ec0a45c99b9209bcfc71b8f6000" class="x-wiki-index-item">sort</a>

                </div>



            </div>

            <div id="00143449934543461c9d5dfeeb848f5b72bd012e1113d15000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449934543461c9d5dfeeb848f5b72bd012e1113d15000" class="x-wiki-index-item">闭包</a>

            </div>

            <div id="001438565969057627e5435793645b7acaee3b6869d1374000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001438565969057627e5435793645b7acaee3b6869d1374000" class="x-wiki-index-item">箭头函数</a>

            </div>

            <div id="00143450083887673122b45a4414333ac366c3c935125e7000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143450083887673122b45a4414333ac366c3c935125e7000" class="x-wiki-index-item">generator</a>

            </div>



        </div>

        <div id="00143449957099176f55ba07b764c3daa522217d0e42643000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449957099176f55ba07b764c3daa522217d0e42643000" class="x-wiki-index-item">标准对象</a>


            <div id="001434499525761186acdd5ac3a44f8a50cc0ed8606139b000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499525761186acdd5ac3a44f8a50cc0ed8606139b000" class="x-wiki-index-item">Date</a>

            </div>

            <div id="001434499503920bb7b42ff6627420da2ceae4babf6c4f2000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499503920bb7b42ff6627420da2ceae4babf6c4f2000" class="x-wiki-index-item">RegExp</a>

            </div>

            <div id="001434499490767fe5a0e31e17e44b69dcd1196f7ec6fc6000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499490767fe5a0e31e17e44b69dcd1196f7ec6fc6000" class="x-wiki-index-item">JSON</a>

            </div>



        </div>

        <div id="001434499763408e24c210985d34edcabbca944b4239e20000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499763408e24c210985d34edcabbca944b4239e20000" class="x-wiki-index-item">面向对象编程</a>


            <div id="0014344997235247b53be560ab041a7b10360a567422a78000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344997235247b53be560ab041a7b10360a567422a78000" class="x-wiki-index-item">创建对象</a>

            </div>

            <div id="0014344997013405abfb7f0e1904a04ba6898a384b1e925000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344997013405abfb7f0e1904a04ba6898a384b1e925000" class="x-wiki-index-item">原型继承</a>

            </div>

            <div id="001458267339633fd3a83c597d04b5fb59f7d1f6792efb3000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001458267339633fd3a83c597d04b5fb59f7d1f6792efb3000" class="x-wiki-index-item">class继承</a>

            </div>



        </div>

        <div id="0014344997647015f03abc1bb5f46129a7526292a12ab26000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014344997647015f03abc1bb5f46129a7526292a12ab26000" class="x-wiki-index-item">浏览器</a>


            <div id="001434499832124d97d77b00706461f9daf1a390b75ade1000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499832124d97d77b00706461f9daf1a390b75ade1000" class="x-wiki-index-item">浏览器对象</a>

            </div>

            <div id="001434499851683f7f8d6b7717343248a75d5e7f930def4000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499851683f7f8d6b7717343248a75d5e7f930def4000" class="x-wiki-index-item">操作DOM</a>


                <div id="0014345011220342fa37b4a62ea4972bf9e6da10edc2a85000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345011220342fa37b4a62ea4972bf9e6da10edc2a85000" class="x-wiki-index-item">更新DOM</a>

                </div>

                <div id="0014359940861047248456754f44e55919fe9370c723ae6000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014359940861047248456754f44e55919fe9370c723ae6000" class="x-wiki-index-item">插入DOM</a>

                </div>

                <div id="001435997163473d309006809fa43abbba322be3eb090a8000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001435997163473d309006809fa43abbba322be3eb090a8000" class="x-wiki-index-item">删除DOM</a>

                </div>



            </div>

            <div id="001434499922277b890fd537901490a84fc24b2b8b8867e000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499922277b890fd537901490a84fc24b2b8b8867e000" class="x-wiki-index-item">操作表单</a>

            </div>

            <div id="00143449993875172bbfac4b9764e2d9e2b5a17c706b3db000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449993875172bbfac4b9764e2d9e2b5a17c706b3db000" class="x-wiki-index-item">操作文件</a>

            </div>

            <div id="001434499861493e7c35be5e0864769a2c06afb4754acc6000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499861493e7c35be5e0864769a2c06afb4754acc6000" class="x-wiki-index-item">AJAX</a>

            </div>

            <div id="0014345008539155e93fc16046d4bb7854943814c4f9dc2000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345008539155e93fc16046d4bb7854943814c4f9dc2000" class="x-wiki-index-item">Promise</a>

            </div>

            <div id="00143449990549914b596ac1da54a228a6fa9643e88bc0c000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143449990549914b596ac1da54a228a6fa9643e88bc0c000" class="x-wiki-index-item">Canvas</a>

            </div>



        </div>

        <div id="001434499993118b8173572625b4afe93a8b19dd707ea1d000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499993118b8173572625b4afe93a8b19dd707ea1d000" class="x-wiki-index-item">jQuery</a>


            <div id="0014345004443979a29e0e0be054e75a652613f132f7f0b000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345004443979a29e0e0be054e75a652613f132f7f0b000" class="x-wiki-index-item">选择器</a>


                <div id="001437023139167510b90eb2c924f72aeba0db592a9eb54000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001437023139167510b90eb2c924f72aeba0db592a9eb54000" class="x-wiki-index-item">层级选择器</a>

                </div>

                <div id="0014370268753868fc999e1563341fcb9df078b160a20e5000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014370268753868fc999e1563341fcb9df078b160a20e5000" class="x-wiki-index-item">查找和过滤</a>

                </div>



            </div>

            <div id="001434500494451273e6b3dec9d411d9ba841dee8caec45000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434500494451273e6b3dec9d411d9ba841dee8caec45000" class="x-wiki-index-item">操作DOM</a>


                <div id="001437110841551950380fdc17c4abdaebd38363dbe2348000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001437110841551950380fdc17c4abdaebd38363dbe2348000" class="x-wiki-index-item">修改DOM结构</a>

                </div>



            </div>

            <div id="00143564690172894383ccd7ab64669b4971f4b03fa342d000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143564690172894383ccd7ab64669b4971f4b03fa342d000" class="x-wiki-index-item">事件</a>

            </div>

            <div id="001434500456006abd6381dc3bb439d932cb895b62d9eee000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434500456006abd6381dc3bb439d932cb895b62d9eee000" class="x-wiki-index-item">动画</a>

            </div>

            <div id="00143450046645491e306a4f74746daaef4d172f66335b5000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143450046645491e306a4f74746daaef4d172f66335b5000" class="x-wiki-index-item">AJAX</a>

            </div>

            <div id="0014356468967974219593d94f64d06b370c87fc38eade4000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014356468967974219593d94f64d06b370c87fc38eade4000" class="x-wiki-index-item">扩展</a>

            </div>



        </div>

        <div id="001481157421687632cbe98b0094e96ba12c45c411f59ac000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001481157421687632cbe98b0094e96ba12c45c411f59ac000" class="x-wiki-index-item">错误处理</a>


            <div id="00148116122948434eed80915274cbdbc5d3ae36862f263000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00148116122948434eed80915274cbdbc5d3ae36862f263000" class="x-wiki-index-item">错误传播</a>

            </div>

            <div id="001481162239686df8cf688c03d4661b7a316306404906d000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001481162239686df8cf688c03d4661b7a316306404906d000" class="x-wiki-index-item">异步错误处理</a>

            </div>



        </div>

        <div id="001450370530539bc6e0e3dc02c4d3bb79993a8cde056b5000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001450370530539bc6e0e3dc02c4d3bb79993a8cde056b5000" class="x-wiki-index-item">underscore</a>


            <div id="001450372452505599881a3debd4becbe1591a94950fbb8000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001450372452505599881a3debd4becbe1591a94950fbb8000" class="x-wiki-index-item">Collections</a>

            </div>

            <div id="001450375778335b78230044e114619bb4211c3769897a7000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001450375778335b78230044e114619bb4211c3769897a7000" class="x-wiki-index-item">Arrays</a>

            </div>

            <div id="001450391119558965d1614860145b881340e490534c5c3000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001450391119558965d1614860145b881340e490534c5c3000" class="x-wiki-index-item">Functions</a>

            </div>

            <div id="0014504059891467b6dacbe5960461983d2c0a8d423d037000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014504059891467b6dacbe5960461983d2c0a8d423d037000" class="x-wiki-index-item">Objects</a>

            </div>

            <div id="001450409116077b5e000f9cb57448785b181b0939caecd000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001450409116077b5e000f9cb57448785b181b0939caecd000" class="x-wiki-index-item">Chaining</a>

            </div>



        </div>

        <div id="001434501245426ad4b91f2b880464ba876a8e3043fc8ef000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501245426ad4b91f2b880464ba876a8e3043fc8ef000" class="x-wiki-index-item">Node.js</a>


            <div id="00143450141843488beddae2a1044cab5acb5125baf0882000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143450141843488beddae2a1044cab5acb5125baf0882000" class="x-wiki-index-item">安装Node.js和npm</a>

            </div>

            <div id="001434501436552e03ec6cc152b4c84959f14d0ea278488000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501436552e03ec6cc152b4c84959f14d0ea278488000" class="x-wiki-index-item">第一个Node程序</a>

            </div>

            <div id="001470969077294a6455fc9cd1f48b69f82cd05e7fa9b40000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001470969077294a6455fc9cd1f48b69f82cd05e7fa9b40000" class="x-wiki-index-item">搭建Node开发环境</a>

            </div>

            <div id="001434502419592fd80bbb0613a42118ccab9435af408fd000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434502419592fd80bbb0613a42118ccab9435af408fd000" class="x-wiki-index-item">模块</a>

            </div>

            <div id="001434501482448f6b36071ab6949d3a7ecb5a71a3c9df9000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501482448f6b36071ab6949d3a7ecb5a71a3c9df9000" class="x-wiki-index-item">基本模块</a>


                <div id="001434501497361a4e77c055f5c4a8da2d5a1868df36ad1000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501497361a4e77c055f5c4a8da2d5a1868df36ad1000" class="x-wiki-index-item">fs</a>

                </div>

                <div id="001434501515527e6fce6d5ec4b4fd9b572122cd1ec8ded000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501515527e6fce6d5ec4b4fd9b572122cd1ec8ded000" class="x-wiki-index-item">stream</a>

                </div>

                <div id="0014345015296018cac40c198b543fead5c549865b9bd4a000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014345015296018cac40c198b543fead5c549865b9bd4a000" class="x-wiki-index-item">http</a>

                </div>

                <div id="001434501504929883d11d84a1541c6907eefd792c0da51000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501504929883d11d84a1541c6907eefd792c0da51000" class="x-wiki-index-item">crypto</a>

                </div>



            </div>

            <div id="001434501549492cdf5d4013db14fa9ad8ca172f0664345000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501549492cdf5d4013db14fa9ad8ca172f0664345000" class="x-wiki-index-item">Web开发</a>


                <div id="001434501579966ab03decb0dd246e1a6799dd653a15e1b000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501579966ab03decb0dd246e1a6799dd653a15e1b000" class="x-wiki-index-item">koa</a>


                    <div id="001471087582981d6c0ea265bf241b59a04fa6f61d767f6000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001471087582981d6c0ea265bf241b59a04fa6f61d767f6000" class="x-wiki-index-item">koa入门</a>

                    </div>

                    <div id="001471133885340dad9058705804899b1cc2d0a10e7dc80000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001471133885340dad9058705804899b1cc2d0a10e7dc80000" class="x-wiki-index-item">处理URL</a>

                    </div>

                    <div id="0014713964925087c29166d8c344a949364e40e2f28dc09000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014713964925087c29166d8c344a949364e40e2f28dc09000" class="x-wiki-index-item">使用Nunjucks</a>

                    </div>

                    <div id="001434501628911140e1cb6ce7d42e5af81480f7ecd5802000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434501628911140e1cb6ce7d42e5af81480f7ecd5802000" class="x-wiki-index-item">使用MVC</a>

                    </div>



                </div>

                <div id="00143450161807565b0c93cb65d4df0a733bf15dc1f8c79000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00143450161807565b0c93cb65d4df0a733bf15dc1f8c79000" class="x-wiki-index-item">mysql</a>


                    <div id="001471955049232be7492e76f514d45a2180e2c224eb7a6000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001471955049232be7492e76f514d45a2180e2c224eb7a6000" class="x-wiki-index-item">使用Sequelize</a>

                    </div>

                    <div id="001472286125147031e735933574ae099842afd31be80d1000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001472286125147031e735933574ae099842afd31be80d1000" class="x-wiki-index-item">建立Model</a>

                    </div>



                </div>

                <div id="00147203593334596b366f3fe0b409fbc30ad81a0a91c4a000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00147203593334596b366f3fe0b409fbc30ad81a0a91c4a000" class="x-wiki-index-item">mocha</a>


                    <div id="00147204317563462840426beb04a849ba813eb46bb347c000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00147204317563462840426beb04a849ba813eb46bb347c000" class="x-wiki-index-item">编写测试</a>

                    </div>

                    <div id="0014723007105817ff3d8fae5b9491a88982aa1655e66be000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014723007105817ff3d8fae5b9491a88982aa1655e66be000" class="x-wiki-index-item">异步测试</a>

                    </div>

                    <div id="001489059908796ab910b35d443485aa064322863372732000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001489059908796ab910b35d443485aa064322863372732000" class="x-wiki-index-item">Http测试</a>

                    </div>



                </div>

                <div id="001472780997905c8f293615c5a42eab058b6dc29936a5c000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001472780997905c8f293615c5a42eab058b6dc29936a5c000" class="x-wiki-index-item">WebSocket</a>


                    <div id="0014727922914053479c966220f47da91991fa9c27ac3ea000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014727922914053479c966220f47da91991fa9c27ac3ea000" class="x-wiki-index-item">使用ws</a>

                    </div>

                    <div id="001472794708264206fcf1589bb43caa0395752aa26538c000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001472794708264206fcf1589bb43caa0395752aa26538c000" class="x-wiki-index-item">编写聊天室</a>

                    </div>



                </div>

                <div id="001473590199114b8523ba038dd4359a16ad0bbd3c8a1f2000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001473590199114b8523ba038dd4359a16ad0bbd3c8a1f2000" class="x-wiki-index-item">REST</a>


                    <div id="0014735914606943e2866257aa644b4bdfe01d26d29960b000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014735914606943e2866257aa644b4bdfe01d26d29960b000" class="x-wiki-index-item">编写REST API</a>

                    </div>

                    <div id="0014735944539193ab2edd2740f44a79efb438a05e83727000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014735944539193ab2edd2740f44a79efb438a05e83727000" class="x-wiki-index-item">开发REST API</a>

                    </div>



                </div>

                <div id="001475449022563a6591e6373324d1abd93e0e3fa04397f000" depth="3" style="display:none;position:relative;margin-left:15px;">

                    <i onclick="toggleWikiNode(this)" class="uk-icon-plus-square-o" style="position:absolute;margin-left:-1em;padding-top:8px;"></i>
                    <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001475449022563a6591e6373324d1abd93e0e3fa04397f000" class="x-wiki-index-item">MVVM</a>


                    <div id="0014757105098309140e608db714251bf071db711a9d183000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014757105098309140e608db714251bf071db711a9d183000" class="x-wiki-index-item">单向绑定</a>

                    </div>

                    <div id="00147574857851718682c42639f466a934ad9d4f485d1f2000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00147574857851718682c42639f466a934ad9d4f485d1f2000" class="x-wiki-index-item">双向绑定</a>

                    </div>

                    <div id="0014757513445737513d7d65cd64333b5b6ba772839e401000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014757513445737513d7d65cd64333b5b6ba772839e401000" class="x-wiki-index-item">同步DOM结构</a>

                    </div>

                    <div id="00147576011615487c65971b3bd4acfa8ee94baaab3dbf7000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/00147576011615487c65971b3bd4acfa8ee94baaab3dbf7000" class="x-wiki-index-item">集成API</a>

                    </div>

                    <div id="0014757971662334e405bae72894f5c88a4bc75d01406da000" depth="4" style="display:none;position:relative;margin-left:15px;">

                        <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014757971662334e405bae72894f5c88a4bc75d01406da000" class="x-wiki-index-item">在线电子表格</a>

                    </div>



                </div>



            </div>

            <div id="001434502089103cfd7d8160b6341d280499f541f430b64000" depth="2" style="display:none;position:relative;margin-left:15px;">

                <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434502089103cfd7d8160b6341d280499f541f430b64000" class="x-wiki-index-item">自动化工具</a>

            </div>



        </div>

        <div id="0014702883533702219013a10964054bd9a7c322b1c7e9c000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/0014702883533702219013a10964054bd9a7c322b1c7e9c000" class="x-wiki-index-item">React</a>

        </div>

        <div id="001434502446010ad7a7602d71b49c9a3a0b8484f88f2cd000" depth="1" style="display:none;position:relative;margin-left:15px;">

            <a href="/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434502446010ad7a7602d71b49c9a3a0b8484f88f2cd000" class="x-wiki-index-item">期末总结</a>

        </div>


    </div>
</ul>
<div class="x-placeholder"></div>
</rapid:override>
</div>

<rapid:override name="block content">

        <h4>JavaScript教程</h4>
        <div class="x-wiki-info"><span>阅读: 2055966</span> <a href="/manage/wiki/edit_wiki?id=001434446689867b27157e896e74d51a89c25cc8b43bdb3000" target="_blank" class="x-can-edit uk-text-danger">编辑</a></div>

        <hr>

        <div class="x-wiki-content x-main-content"><p><img src="https://cdn.liaoxuefeng.com/cdn/static/themes/default/img/loading.gif" data-src="https://cdn.liaoxuefeng.com/cdn/files/attachments/0014355670304100cdaa4e7e651474d9672ed73797378bd000/l" alt="JavaScript全栈教程"></p>
            <p>这是小白的零基础JavaScript全栈教程。</p>
            <p>JavaScript是世界上最流行的脚本语言，因为你在电脑、手机、平板上浏览的所有的网页，以及无数基于HTML5的手机App，交互逻辑都是由JavaScript驱动的。</p>
            <p>简单地说，JavaScript是一种运行在浏览器中的解释型的编程语言。</p>
            <p>那么问题来了，为什么我们要学JavaScript？尤其是当你已经掌握了某些其他编程语言如Java、C++的情况下。</p>
            <p>简单粗暴的回答就是：因为你没有选择。在Web世界里，只有JavaScript能跨平台、跨浏览器驱动网页，与用户交互。</p>
            <p>Flash背后的ActionScript曾经流行过一阵子，不过随着移动应用的兴起，没有人用Flash开发手机App，所以它目前已经边缘化了。相反，随着HTML5在PC和移动端越来越流行，JavaScript变得更加重要了。并且，新兴的Node.js把JavaScript引入到了服务器端，JavaScript已经变成了全能型选手。</p>
            <p>JavaScript一度被认为是一种玩具编程语言，它有很多缺陷，所以不被大多数后端开发人员所重视。很多人认为，写JavaScript代码很简单，并且JavaScript只是为了在网页上添加一点交互和动画效果。</p>
            <p>但这是完全错误的理解。JavaScript确实很容易上手，但其精髓却不为大多数开发人员所熟知。编写高质量的JavaScript代码更是难上加难。</p>
            <p>一个合格的开发人员应该精通JavaScript和其他编程语言。如果你已经掌握了其他编程语言，或者你还什么都不会，请立刻开始学习JavaScript，不要被Web时代所淘汰。</p>
            <p>等等，你会问道，现在有这么多在线JavaScript教程和各种从入门到精通的JavaScript书籍，为什么我要选择这个教程？</p>
            <p>原因是，这个教程：</p>
            <h3><a name="#-E6-98-AFJavaScript-E5-85-A8-E6-A0-88-E6-95-99-E7-A8-8B-EF-BC-81"></a>是JavaScript全栈教程！</h3>
            <h3><a name="#-E5-8F-AF-E4-BB-A5-E5-9C-A8-E7-BA-BF-E5-85-8D-E8-B4-B9-E5-AD-A6-E4-B9-A0-EF-BC-81"></a>可以在线免费学习！</h3>
            <h3><a name="#-E5-8F-AF-E4-BB-A5-E5-9C-A8-E7-BA-BF-E7-BC-96-E5-86-99JavaScript-E4-BB-A3-E7-A0-81-E5-B9-B6-E7-9B-B4-E6-8E-A5-E8-BF-90-E8-A1-8C-EF-BC-81"></a>可以在线编写JavaScript代码并直接运行！</h3>
            <pre><code class="lang-x-javascript">// 直接点击Run运行
----
alert(&#39;我要学JavaScript!&#39;);
</code></pre>
            <p>不要再犹豫了，立刻从现在开始，零基础迈向全栈开发工程师！</p>
            <h3><a name="#-E5-85-B3-E4-BA-8E-E4-BD-9C-E8-80-85"></a>关于作者</h3>
            <p><a href="http://weibo.com/liaoxuefeng">廖雪峰</a>，十年软件开发经验，业余产品经理，精通Java/Python/Ruby/Visual Basic/Objective C等，对开源框架有深入研究，著有《Spring 2.0核心技术与最佳实践》一书，多个业余开源项目托管在<a target="_blank" href="https://github.com/michaelliao">GitHub</a>，欢迎微博交流：</p>
            <iframe width="100%" height="90" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=2&ptype=1&speed=0&skin=5&isTitle=0&noborder=0&isWeibo=0&isFans=0&uid=1658384301&verifier=078cedea&colors=0593d3,ffffff,666666,0593d3,0477ab&dpc=1"></iframe></div>

        <hr>

        <div class="x-wiki-prev-next uk-clearfix"></div>

        <div id="x-sponsor-a" class="uk-clearfix"><!-- sponsor A --></div>

        <div class="x-anchor x-comment-anchor"><a name="comments"></a></div>

        <h3>评论</h3>

        <ul id="x-comment-list" class="uk-comment-list">
        </ul>

        <h3>发表评论</h3>

        <div class="x-display-if-not-signin">
            <p><button type="button" class="uk-button" onclick="showSignin()"><i class="uk-icon-signin"></i> 登录后发表评论</button></p>
        </div>

        <div id="x-comment-area"></div>
</rapid:override>

<%@ include file="/WEB-INF/jsp/base.jsp" %>