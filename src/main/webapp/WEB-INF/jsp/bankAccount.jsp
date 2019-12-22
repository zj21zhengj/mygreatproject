
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/asset/static/css/Styles-std.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/static/css/calendar-blue.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        var flowList = {
            //封装秒杀相关ajax的url
            URL : {
                now:function() {
                    return "${pageContext.request.contextPath}/getFlow";
                },
                execution : function(){
                    return  "${pageContext.request.contextPath}/getFlowByConditon";;
                }
            },
            init : function() {
                $.get(flowList.URL.now(),function(data,status) {
                    console.log(data.length);
                    flowList.postLayout(data);
                });
            },
            searchHandle:function (ddlTransType) {
                $.get(flowList.URL.execution(),{'ddlTransType':ddlTransType},function(result){

                });
            },
            postLayout:function (data) {
                var html;
                for (var i = 0; i < data.length; i++) {
                    if(data[i].num % 2 == 0) {
                        html += '<tr class="dgAlternatingItem"> <td align="center">' + data[i].date +
                            '</td><td align="center">' + data[i].time +
                            '</td><td align="right">' + data[i].strOfTransAmountOut +
                            '</td><td align="right">' + data[i].strOfTransAmountIn +
                            '</td><td align="right" style="color:#585858;">' + data[i].strOfBalance +
                            '</td><td align="left">' + data[i].transType +
                            '</td><td align="left">' + data[i].transRemark + '</td></tr>';
                    } else {
                        html += '<tr > <td align="center">' + data[i].date +
                            '</td><td align="center">' + data[i].time +
                            '</td><td align="right">' + data[i].strOfTransAmountOut +
                            '</td><td align="right">' + data[i].strOfTransAmountIn +
                            '</td><td align="right" style="color:#585858;">' + data[i].strOfBalance +
                            '</td><td align="left">' + data[i].transType +
                            '</td><td align="left">' + data[i].transRemark + '</td></tr>';
                    }
                }
                $("#archiveList").html(html);
            }

        };

        (function () {
            flowList.init();
        })();


    </script>
</head>
<body>

<TABLE class="tbMain" id="Table1" cellSpacing="0" border="0">
    <TR>
        <TD class="tdCommonTop">
            <TABLE class="tbTitle" id="Table2" cellSpacing="0" border="0">
                <TR>
                    <TD class="tdTitle1" colSpan="1" rowSpan="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前功能：
                        <span id="Location">账户管理 > 交易查询</span>&nbsp;&nbsp;&nbsp; </TD>
                    <TD class="tdTitle2"><FONT face="宋体"></FONT></TD>
                    <TD class="tdTitle3">版面号：901023<IMG alt="" src="../doc/Images/title_06.gif"></TD>
                </TR>
            </TABLE>
            <TABLE class="tbBlock" id="Table3" cellSpacing="1" border="0">
                <TR>
                    <TD class="tdCenterW20H40" colSpan="1" rowSpan="1">一卡通卡号：</TD>
                    <TD class="tdLeftH40"><span style="FLOAT:left"><select name="ddlDebitCardList" id="ddlDebitCardList">
	<option selected="selected" value="1OZzb9INwtFdpmMLMi3CzkGuWgC7gGvF">6214********3787</option>

</select>
									</span>
                    </TD>
                </TR>
            </TABLE>
        </TD>
    </TR>
    <TR>
        <TD class="tdSpaceH12"><FONT face="宋体"></FONT></TD>
    </TR>
    <TR>
        <TD class="tdCommonTop">
            <TABLE class="tbPanel" id="Table4" cellSpacing="0" cellPadding="0" border="0">
                <TR>
                    <TD class="tdPanelContent" colSpan="1" rowSpan="1">
                        <!-- 交易查询标签 -->
                        <table width="300px" border="0" cellpadding="0" cellspacing="0" class=tbPanelContent>
                            <tr>
                                <td class=tdPanelHead> </td>
                                <td class=tdPanelNoSel> <a href="#" class=lkPanelNoSel onclick="triggerFunc('../AccountQuery/am_QueryTodayTrans.aspx','FORM','_self')">当天交易查询</a></td>
                                <td class=tdPanelSel> <a href="#" class=lkPanelSel onclick="triggerFunc('../AccountQuery/am_QueryHistoryTrans.aspx','FORM','_self')">历史交易查询</a></td>
                            </tr>
                        </table>
                        <!-- END 交易查询标签 -->
                    </TD>
                    <TD class="tdPanelTrail"></TD>
                </TR>
            </TABLE>
        </TD>
    </TR>
    <TR>
        <TD id="tdQueryResult1" class="tdCommonTop"><TABLE class="tbCommonColor" id="Table5" cellSpacing="0" border="0">
            <TR>
                <TD class=""></TD>
            </TR>
        </TABLE>
            <TABLE class="tbCommonColor" id="Table6" cellSpacing="1" border="0">
                <TR>
                    <TD class="tdLeftH30">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;子 账 户：<select name="ddlSubAccountList" id="ddlSubAccountList" style="width:200px;">
                        <option selected="selected" value="571240382820001"> 活期结算户 人民币 20001 </option>

                    </select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交易类型：<select name="ddlTransTypeList" id="ddlTransTypeList" style="width:100px;">
                        <option selected="selected" value="-">[ 全部 ]</option>
                        <option value="AGBX">报销款</option>
                        <option value="AGPY">代发工资</option>
                        <option value="CUCR">银联代付</option>
                        <option value="ICRR">客户转账</option>
                        <option value="ICSP">客户转账</option>
                        <option value="IINT">账户结息</option>
                        <option value="N5CP">N5CP</option>
                        <option value="N5CR">N5CR</option>
                        <option value="ONNK">直付通交易</option>
                        <option value="PCH2">银联POS消费</option>
                        <option value="RYTB">汇入汇款</option>
                        <option value="U1PY">U1PY</option>
                        <option value="XYPY">信用卡还款</option>

                    </select>
                    </TD>
                </TR>
                <TR>
                    <TD class="tdLeftH30">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起始日期：<input name="BeginDate" type="text" value="20150801" maxlength="8" id="BeginDate" style="width:80px;" /><img src="../doc/Images/bt_selDate.gif" id="BtnBeginDate" style="CURSOR: pointer" onclick="openWinBeginDateSel()" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;终止日期：<input name="EndDate" type="text" value="20191026" maxlength="8" id="EndDate" style="width:80px;" /><img src="../doc/Images/bt_selDate.gif" id="BtnEndDate" style="CURSOR: pointer" onclick="openWinEndDateSel()" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="BtnOK" value="查 询" onclick="return CheckValid();" id="BtnOK" class="btn" />
                    </TD>
                </TR>
            </TABLE>
        </TD>

    </TR>
    <TR>
        <TD class="tdSpaceH12"></TD>
    </TR>
    <TR>
        <TD id="tdQueryResult2" class="tdCommonTop">
            <TABLE class="tbBlock" id="Table7" cellSpacing="1" border="0">
                <TR>
                    <TD class="tdPrompt">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以下是一卡通&nbsp;
                        <span id="AccountNo" class="wcLabel">6214********3787</span>&nbsp;的历史交易记录：</TD>
                </TR>
            </TABLE>
            <table class="dgMain" cellspacing="0" cellpadding="3" align="Center" rules="all" border="1" id="dgHistoryTransRecSet" style="border-color:#9FD6FF;border-width:1px;border-style:solid;border-collapse:collapse;">
                <thead>
                <tr class="dgHeader" align="center">
                    <td class="dgHeader" style="width:12%;">交易日期</td><td class="dgHeader" style="width:12%;">交易时间</td><td class="dgHeader" style="width:12%;">支出</td><td class="dgHeader" style="width:12%;">存入</td><td class="dgHeader" style="width:12%;">余额</td><td class="dgHeader" style="width:20%;">交易类型</td><td class="dgHeader" style="width:20%;">交易备注</td>
                </tr>
                </thead>
                <tbody id="archiveList">
                </tbody>
               <%-- <tr class="dgAlternatingItem">
                    <td align="center">2019-10-21</td><td align="center">22:21:47</td><td align="right">14.80</td><td align="right">&nbsp;</td><td align="right" style="color:#585858;">3,173.09</td><td align="left">N5CP</td><td align="left">支付宝 - 杭州可承通信服务有限公司</td>
                </tr>--%>
            </table>
            <TABLE class="tbBlock" id="Table8" cellSpacing="1" border="0">
                <TR>
                    <TD class="tdCommonTopColor">
                        <TABLE class="tbCommonColor" id="Table9" cellSpacing="1" border="0">
                            <TR>
                                <TD class="tdLeftW30H20">&nbsp; 支出交易笔数：
                                    <span id="OutCount" class="wcLabel">207</span></TD>
                                <TD class="tdLeftW30H20">&nbsp; 存入交易笔数：
                                    <span id="InCount" class="wcLabel">30</span></TD>
                                <TD class="tdLeftH20">&nbsp;</TD>
                            </TR>
                            <TR>
                                <TD class="tdLeftW30H20">&nbsp; 支出金额合计：
                                    <span id="OutTotalMoney" class="wcLabel">805,497.93</span></TD>
                                <TD class="tdLeftW30H20" colSpan="1" rowSpan="1">&nbsp; 存入金额合计：
                                    <span id="InTotalMoney" class="wcLabel">806,271.91</span></TD>
                                <TD class="tdLeftH20">&nbsp;</TD>
                            </TR>
                        </TABLE>
                    </TD>
                </TR>
            </TABLE>

        </TD>

    </TR>
    <TR>
        <TD class="tdSpaceH12"></TD>
    </TR>

    <TR>
        <TD class="tdSpaceH12"></TD>
    </TR>
</TABLE>
</body>
</html>
