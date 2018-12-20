<%--
  Created by IntelliJ IDEA.
  User: landmyp
  Date: 2018/12/19
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>订单页面</title>
    <link rel="stylesheet" type="text/css" href="orderFile/css/style.css">
    <link rel="stylesheet" type="text/css" href="orderFile/css/css.css" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function() {
            var region = $("#region");
            var address = $("#address");
            var number_this = $("#number_this");
            var name = $("#name_");
            var phone = $("#phone");
            $("#sub_setID").click(function() {
                var input_out = $(".input_style");
                for (var i = 0; i <= input_out.length; i++) {
                    if ($(input_out[i]).val() == "") {
                        $(input_out[i]).css("border", "1px solid red");

                        return false;
                    } else {
                        $(input_out[i]).css("border", "1px solid #cccccc");
                    }
                }
            });
            var span_momey = $(".span_momey");
            var b = 0;
            for (var i = 0; i < span_momey.length; i++) {
                b += parseFloat($(span_momey[i]).html());
            }
            var out_momey = $(".out_momey");
            out_momey.html(b);
            $(".shade_content").hide();
            $(".shade").hide();
            $('.nav_mini ul li').hover(function() {
                $(this).find('.two_nav').show(100);
            }, function() {
                $(this).find('.two_nav').hide(100);
            })
            $('.left_nav').hover(function() {
                $(this).find('.nav_mini').show(100);
            }, function() {
                $(this).find('.nav_mini').hide(100);
            })
            $('#jia').click(function() {
                $('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
            })
            $('#jian').click(function() {
                $('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
            })
            $('.Caddress .add_mi').click(function() {
                $(this).css('background', 'url("orderFile/images/mail_1.jpg") no-repeat').siblings('.add_mi').css('background', 'url("orderFile/images/mail.jpg") no-repeat')
            })
        })
        var x = Array();

        function func(a, b) {
            x[b] = a.html();
            alert(x)
            a.css('border', '2px solid #f00').siblings('.min_mx').css('border', '2px solid #ccc');
        }

        function onclick_close() {
            var shade_content = $(".shade_content");
            var shade = $(".shade");
            if (confirm("确认关闭么！此操作不可恢复")) {
                shade_content.hide();
                shade.hide();
            }
        }

        function onclick_open() {
            $(".shade_content").show();
            $(".shade").show();
            var input_out = $(".input_style");
            for (var i = 0; i <= input_out.length; i++) {
                if ($(input_out[i]).val() != "") {
                    $(input_out[i]).val("");
                }
            }
        }

        function onclick_remove(r) {
            if (confirm("确认删除么！此操作不可恢复")) {
                var out_momey = $(".out_momey");
                var shit = $(".span_order");
                var input_val = $(r).parent().prev().children().eq(1).val();
                var span_html = $(r).parent().prev().prev().children().html();
                console.log(span_html);
                var out_add = parseFloat(input_val).toFixed(2) * parseFloat(span_html).toFixed(2);
                var reduce = parseFloat(out_momey.html()).toFixed(2)- parseFloat(out_add).toFixed(2);
                console.log(parseFloat(reduce).toFixed(2));
                out_momey.text(parseFloat(reduce).toFixed(2))


                $.ajax({
                    url:'/house/deleteByOid',
                    data:"oid="+span_html,
                    success:function(data){

                        alert("删除成功！！");
                    },
                    error:function(data){
                        alert("I am fucking coming !!!");
                    },
                    dataType:"json",
                    type:"GET"
                });
                $(r).parent().parent().remove();
            }
        }

        function onclick_btnAdd(a) {
            var out_momey = $(".out_momey");
            var input_ = $(a).prev();
            var input_val = $(a).prev().val();
            var input_add = parseInt(input_val) + 1;
            input_.val(input_add);
            var btn_momey = parseFloat($(a).parent().prev().children().html());
            var out_momey_float = parseFloat(out_momey.html()) + btn_momey;
            out_momey.text(out_momey_float.toFixed(2));
        }

        function onclick_reduce(b) {
            var out_momey = $(".out_momey");
            var input_ = $(b).next();
            var input_val = $(b).next().val();
            if (input_val <= 1) {
                alert("商品个数不能小于1！")
            } else {
                var input_add = parseInt(input_val) - 1;
                input_.val(input_add);
                var btn_momey = parseFloat($(b).parent().prev().children().html());
                var out_momey_float = parseFloat(out_momey.html()) - btn_momey;
                out_momey.text(out_momey_float.toFixed(2));
            }
        }
    </script>
</head>

<body>


<div id="top">
    <div id="top_main">
        <ul class="topu">
            <li>
                <div class="xing">
                </div>
                <a href="http://localhost:8080/house/">返回主页</a>
            </li>
        </ul>
        <div id="hello">
					<span>您好，欢迎来到商城！
			<a href="login.html">[登陆]</a><a href="login.html">[免费注册]</a>
			</span>
        </div>
        <div class="topright">
            <ul>
                <li>
                    <div class="cun">
                        <a href="#">我的订单</a>
                    </div>
                </li>
                <li class="kefu">
                    <div class="cun">
                        <div class="a1">
                            <div class="kefuhide">
                                <span>客户服务</span>
                                <div class="downjian1">
                                </div>
                                <ul>
                                    <li><a href="#">帮助中心</a></li>
                                    <li><a href="#">售后服务</a></li>
                                    <li><a href="#">在线客服</a></li>
                                    <li><a href="#">投诉中心</a></li>
                                    <li><a href="#">客服邮箱</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="wangzhan">
                    <div class="cun">
                        <span>网站导航</span>
                        <div class="downjian1">
                        </div>
                    </div>
                    <div class="wangzhanhide">
                        <div class="tese">
                            <span>特色栏目</span>
                        </div>
                        <div class="tesemain">
                            <a href="#">商城通信</a>
                            <a href="#">校园之星</a>
                            <a href="#">视频购物</a>
                            <a href="#">商城社区</a>
                            <a href="#">在线读书</a>
                            <a href="#">装机大师</a>
                            <a href="#">商城E卡　</a>
                            <a href="#">家装城</a>
                            <a href="#">搭配购　</a>
                            <a href="#">我喜欢　</a>
                            <a href="#">游戏社区</a>
                        </div>
                        <div class="tese">
                            <span>企业服务</span>
                        </div>
                        <div class="tesemain1">
                            <a href="#">企业采购</a>
                            <a href="#">办公直通车</a>
                        </div>
                        <div class="tese">
                            <span>旗下网站</span>
                        </div>
                        <div class="tesemain2">
                            <a href="#">English Site</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- 搜索区域开始 -->
<div id="serach">
    <div class="logo">
        <a href="index.html">
            <img src="orderFile/images/logo.png" alt="" style="width: 100px;height: 100px"/></a>
        <div class="dongtu">
        </div>
    </div>
    <div class="sou">
        <%--<div class="sousuo">--%>
            <%--&lt;%&ndash;<input type="text" class="kuang" value="跨界" style="color:#999;font-size:14px" />&ndash;%&gt;--%>
            <%--<div class="souzi">--%>
                <%--&lt;%&ndash;<a href="#">搜索</a>&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="reci">
            <span>热门搜索:</span>
            <a href="#" style="color:red">校园之星</a>
            <a href="#">影院到家</a>
            <a href="#">JD制暖节</a>
            <a href="#">腕表领券</a>
            <a href="#">自营满减</a>
            <a href="#">N3抢购</a>
            <a href="#">图书换购</a>
            <a href="#">12.12</a>
        </div>
    </div>
    <div class="myjd">
        <div class="mytu">
        </div>
        <a href="#">我的商城</a>
        <div class="jiantou">
        </div>
        <div class="myjdhide">
            <div class="hello">
                <span>您好，请</span>
                <a href="#">登录</a>
            </div>
            <div class="hey">
                <div class="heyleft">
                    <ul>
                        <li><a href="#">待处理订单</a></li>
                        <li><a href="#">咨询回复</a></li>
                        <li><a href="#">降价商品</a></li>
                        <li><a href="#">返修退换货</a></li>
                        <li><a href="#">优惠券</a></li>
                    </ul>
                </div>
                <div class="heyright">
                    <ul>
                        <li><a href="#">我的关注></a></li>
                        <li><a href="#">我的京豆></a></li>
                        <li><a href="#">我的理财></a></li>
                        <li><a href="#">我的白条></a></li>
                    </ul>
                </div>
            </div>
            <div class="hidebot">
                <div class="bottop">
                    <span>最近浏览的商品:</span>
                    <a href="#">查看浏览历史></a>
                </div>
                <div class="botdown">
                    <span>「暂无数据」</span>
                </div>
            </div>
        </div>
    </div>
    <div class="gouwuche">
        <div class="chetu">
        </div>
        <a href="#">去购物车结算</a>
        <div class="jianleft">
        </div>
        <div class="num">
            <div class="numright">
            </div>
            <div class="numzi">
                <span>0</span>
            </div>
        </div>
        <div class="hideche">
            <div class="kongche">
            </div>
            <span>购物车中还没有商品，赶紧选购吧！</span>
        </div>
    </div>
    <div class="jubao">
    </div>
</div>
<div class="Caddress">
    <div class="open_new">
        <button class="open_btn" onclick="javascript:onclick_open();">使用新地址</button>
    </div>
    <div class="add_mi">
        <p style="border-bottom:1px dashed #ccc;line-height:28px;">浙江杭州(电音邪神收)</p>
        <p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
    </div>
    <div class="add_mi">
        <p style="border-bottom:1px dashed #ccc;line-height:28px;">浙江杭州(电音邪神收)</p>
        <p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
    </div>
    <div class="add_mi">
        <p style="border-bottom:1px dashed #ccc;line-height:28px;">浙江杭州(电音邪神收)</p>
        <p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
    </div>
    <div class="add_mi">
        <p style="border-bottom:1px dashed #ccc;line-height:28px;">浙江杭州(电音邪神收)</p>
        <p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
    </div>
    <div class="add_mi">
        <p style="border-bottom:1px dashed #ccc;line-height:28px;">浙江杭州(电音邪神收)</p>
        <p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
    </div>
</div>

<!--
    作者：z@163.com
    时间：2016-03-04
    描述：商品内容
-->
<div class="shopping_content">
    <div class="shopping_table">
        <table border="1" bordercolor="#cccccc" cellspacing="0" cellpadding="0" style="width: 100%; text-align: center;">
            <tr>

                <td>租房图片</td>
                <td>租房类型</td>
                <td>用户名</td>
                <td>租房面积</td>
                <td>所在地址</td>

                <td>租房价格</td>
                <td style="width: 100px">订单号</td>
                <td>数量</td>
                <td>操作</td>

            </tr>
            <c:forEach  items="${orderPage.date}" step="1" var="fuck" varStatus="i">
                <tr>
                    <td>
                        <a href="#"><img src="${fuck.picture}" style="width: 150px;height: 100px;"/></a>
                    </td>
                    <td>
                          ${fuck.houseType}
                    </td>
                    <td>

                      ${fuck.cname}


                    </td>
                    <td>
                       ${fuck.area}
                    </td>
                    <td>
                       ${fuck.position}
                    </td>
                    <td>

                        <span class="span_order">${fuck.price}</span>

                    </td>
                    <td>

                        <span class="span_momey">${fuck.oid}</span>
                    </td>

                    <td>
                        <button class="btn_reduce" onclick="javascript:onclick_reduce(this);">-</button>
                        <input class="momey_input" type="" name="" id="" value="1" disabled="disabled" />
                        <button class="btn_add" onclick="javascript:onclick_btnAdd(this);">+</button>
                    </td>
                    <td>
                        <button class="btn_r" onclick="javascript:onclick_remove(this);">移除</button>
                    </td>
                </tr>

            </c:forEach>




        </table>


        <div align="center">
            <ul class="pagination">
                <li><a href="orderMain?currentPage=1">首页&raquo;</a></li>

                <c:if test="${orderPage.currentPage==1}">
                    <li class="disabled"><a>&laquo;first</a></li>
                </c:if>
                <c:if test="${orderPage.currentPage>1}">
                    <li><a href="orderMain?currentPage=${orderPage.currentPage-1}">&laquo;last</a></li>
                </c:if>

                <c:forEach begin="${orderPage.begin}" end="${orderPage.end}" varStatus="i">

                    <c:if test="${orderPage.currentPage==(i.count+orderPage.begin-1)}">
                        <li class="active"><a href="orderMain?currentPage=${i.count+orderPage.begin-1}">${i.count+orderPage.begin-1}</a></li>
                        </a>
                    </c:if>
                    <c:if test="${orderPage.currentPage!=(i.count+orderPage.begin-1)}">

                        <li><a href="orderMain?currentPage=${i.count+orderPage.begin-1}">${i.count+orderPage.begin-1}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${orderPage.currentPage==orderPage.totalPage}">

                    <li class="disabled">
                        <a >finally&raquo;</a>
                    </li>


                </c:if>
                <c:if test="${orderPage.currentPage!=orderPage.totalPage}">
                    <li><a href="orderMain?currentPage=${orderPage.currentPage+1}">next&raquo;</a></li>
                </c:if>
                <li><a href="orderMain?currentPage=${orderPage.totalPage}">尾页&raquo;</a></li>
            </ul>
        </div>




        <div class="" style="width: 100%; text-align: right; margin-top: 10px;">
            <div class="div_outMumey" style="float: left;">
                总价：<span class="out_momey">11</span>
            </div>
            <button class="btn_closing">结算</button>
        </div>
    </div>
</div>

<!--
    作者：z@163.com
    时间：2016-03-01
    描述：shade 遮罩层
-->
<div class="shade">
</div>
<!--
    作者：z@163.com
    时间：2016-03-02
    描述：shade_content
-->
<div class="shade_content">
    <div class="col-xs-12 shade_colse">
        <button onclick="javascript:onclick_close();">x</button>
    </div>
    <div class="nav shade_content_div">
        <div class="col-xs-12 shade_title">
            新增收货地址
        </div>
        <div class="col-xs-12 shade_from">
            <form action="" method="post">
                <div class="col-xs-12">
                    <span class="span_style" id="">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span>
                    <input class="input_style" type="" name="" id="region" value="" placeholder="&nbsp;&nbsp;请输入您的所在地区" />
                </div>
                <div class="col-xs-12">
                    <span class="span_style" id="">详细地址</span>
                    <input class="input_style" type="" name="" id="address" value="" placeholder="&nbsp;&nbsp;请输入您的详细地址" />
                </div>
                <div class="col-xs-12">
                    <span class="span_style" id="">邮政编号</span>
                    <input class="input_style" type="" name="" id="number_this" value="" placeholder="&nbsp;&nbsp;请输入您的邮政编号" />
                </div>
                <div class="col-xs-12">
                    <span class="span_style" class="span_sty" id="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                    <input class="input_style" type="" name="" id="name_" value="" placeholder="&nbsp;&nbsp;请输入您的姓名" />
                </div>
                <div class="col-xs-12">
                    <span class="span_style" id="">手机号码</span>
                    <input class="input_style" type="" name="" id="phone" value="" placeholder="&nbsp;&nbsp;请输入您的手机号码" />
                </div>
                <div class="col-xs-12">
                    <input class="btn_remove" type="button" id="" onclick="javascript:onclick_close();" value="取消" />
                    <input type="submit" class="sub_set" id="sub_setID" value="提交" />
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 底部开始 -->
<div id="down">
    <div class="down_top">
        <a href="#">关于我们</a>
        <a href="#">联系我们</a>
        <a href="#">商家入驻</a>
        <a href="#">营销中心</a>
        <a href="#">手机商城</a>
        <a href="#">友情链接</a>
        <a href="#">销售联盟</a>
        <a href="#">商城社区</a>
        <a href="#">商城公益</a>
        <a href="#" style="border-right:none">English Site</a>
    </div>
    <div class="down_center">
        <span>北京市公安局朝阳分局备案编号110105014669  |  京ICP证070359号  |  <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>  |  新出发京零 字第大120007号</span>
        <span><a href="#">音像制品经营许可证苏宿批005号</a>  |  出版物经营许可证编号新出发(苏)批字第N-012号  |  互联网出版许可证编号新出网证(京)字150号</span>
        <span><a href="#">网络文化经营许可证京网文[2011]0168-061号</a>  违法和不良信息举报电话：4006561155  Copyright © 2004-2014  商城JD.com 版权所有</span>
        <span>商城旗下网站：<a href="#">360TOP</a><a href="#">拍拍网</a><a href="#">网银在线</a></span>
    </div>
    <div class="down_bot">
        <img src="orderFile/images/bot1.gif" alt="" />
        <img src="orderFile/images/bot2.gif" alt="" />
        <img src="orderFile/images/bot3.png" alt="" />
        <img src="orderFile/images/bot4.png" alt="" />
    </div>
</div>
<!-- 底部结束 -->
</body>
</html>
