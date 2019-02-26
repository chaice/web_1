(function ($) {

    var $into = $('.into-info'), $panel = $into.find('.panel:first-child');
    var $collapse = $into.find('.panel-heading'), $into3 = $('.into-info3');
    var postNode = [], postLine = [];

    var canvas = document.getElementById('canvas'); //舞台
    var stage = new JTopo.Stage(canvas);//场景
    stage.wheelZoom = 1.2;//鼠标缩放比率
    //显示工具
    var scene = new JTopo.Scene(stage);

    var nodes = {};
    var lines = {};

    var canvasrect = $('#canvas')[0].getBoundingClientRect().width;
    $('#canvas').attr({height: canvasrect * 300 / 500, width: canvasrect});

    $into.on({//panel开关
        'click': function () {
            $(this).parent().siblings().find('.panel-heading').removeClass('collapsed');
            $(this).parent().siblings().find('.panel-collapse').removeClass('in');

            if ($(this).next().hasClass('in')) {
                $(this).removeClass('collapsed').next().removeClass('in')
            } else {
                $(this).addClass('collapsed').next().addClass('in')
            }

        }
    }, '.panel-heading')

    $('.glyphicon-plus').click(function () {//添加一个空panel
        $('.panel-heading').removeClass('collapsed');
        $('.panel-collapse').removeClass('in');

        var orderBzType = $('#orderBzType').val();
        var areaInfoList = $('#areaInfoLJson').val();

        areaInfoList = JSON.parse(areaInfoList);
        areaInfoStr = "";
        for (var i = 0; i < areaInfoList.length; i++) {
            areaInfoStr = areaInfoStr + '<option >' + areaInfoList[i].engineRoom + '</option>';
        }

        var str1;
        var cityList = $('#cityJson').val();
        console.log(cityList);
        cityList = JSON.parse(cityList);
        str1 = "";
        for (var i = 0; i < cityList.length; i++) {
            str1 = str1 + '<option >' + cityList[i].dicDetailVal + '</option>';
        }

        var str2;

        if (orderBzType == 1) {
            str2 = '<option value="本地专线接入">本地专线接入</option>';
        } else {
            str2 = '<option value="互联网接入">互联网接入</option>';
        }

        $into.append('<div class="panel panel-default">' +
            '<div class="panel-heading collapsed clearfix" role="tab" data-toggle="collapse" data-parent="#accordion" aria-controls="collapseOne">' +
            '<h4 class="panel-title">' +
            '</h4>' +
            '<div class="tit-info">' +
            '0端口' +
            '</div>' +
            '<div class="tit-info2">' +
            '0MB' +
            '</div>' +
            '<i class="glyphicon glyphicon-menu-down"></i>' +
            '</div>' +
            '<div class="panel-collapse in collapse" role="tabpanel" aria-labelledby="headingOne">' +
            '<div class="panel-body">' +
            '<div class="form-group">' +
            '<label class="col-sm-3 control-label">所在城市/云服务商:</label>' +
            '<div class="col-sm-9">' +
            '<select class="form-control city" onchange="cityRoom(this)">' +
            '<option value="">--请选择城市--</option>' +
            str1 +
            '</select>' +
            '</div>' +
            '</div>' +

            '<div class="form-group inProp-box">' +
            '<label class="col-sm-3 control-label">接入性质:</label>' +
            '<div class="col-sm-9">' +
            '<select class="form-control inprop">' +
            str2 +
            '</select>' +
            '</div>' +
            '</div>' +
            '<div class=" nodeRoom-box" style="display:none">' +

            '<form>' +
            '<div class="form-group" >' +
            '<label class="col-sm-3 control-label">机房选择:</label>' +
            '<div class="col-sm-9">' +
            '<label class="radio-control col-sm-3 nodeRoomCheck" >' +
            '<input type="radio" style=" width:50px" name="check" value="1" checked ="checked" data-checkval="自有" data-name="mode" onchange="changeRoom(this)">' +
            '<p>' +
            '<span>自有<span>' +
            '<svg viewBox="0 0 1024 1024" width="20" height="20"><path fill="#3c8dbc" d="M0 1024h1024V0L0 1024z m895.404651-381.023256l-216.706977 214.325582c-4.762791 4.762791-11.906977 9.525581-19.051162 9.525581-7.144186 0-14.288372-2.381395-19.051163-9.525581l-107.162791-107.162791c-11.906977-11.906977-11.906977-28.576744 0-40.483721s28.576744-11.906977 40.483721 0l88.111628 88.111628 195.274419-195.274419c11.906977-11.906977 28.576744-11.906977 40.483721 0 9.525581 11.906977 9.525581 30.95814-2.381396 40.483721z" p-id="8001"/></svg>' +
            '</p>' +
            '</label>' +
            '<label class="radio-control col-sm-3 nodeRoomCheck" >' +
            '<input type="radio" value="2" name="check" data-checkval="其他" data-name="mode" onchange="changeRoom(this)">' +
            '<p>' +
            '<span>其他<span>' +
            '<svg viewBox="0 0 1024 1024" width="20" height="20"><path fill="#3c8dbc" d="M0 1024h1024V0L0 1024z m895.404651-381.023256l-216.706977 214.325582c-4.762791 4.762791-11.906977 9.525581-19.051162 9.525581-7.144186 0-14.288372-2.381395-19.051163-9.525581l-107.162791-107.162791c-11.906977-11.906977-11.906977-28.576744 0-40.483721s28.576744-11.906977 40.483721 0l88.111628 88.111628 195.274419-195.274419c11.906977-11.906977 28.576744-11.906977 40.483721 0 9.525581 11.906977 9.525581 30.95814-2.381396 40.483721z" p-id="8001"/></svg>' +
            '</p>' +
            '</label>' +
            '</div>' +
            '</div>' +
            '</form>' +
            '<div class="form-group room1">' +
            '<label class="col-sm-3 control-label">设备接入具体信息:</label>' +
            ' <div class="col-sm-9">' +
            '<select class="form-control nodeRoom1" onchange="nodeRoomVal(this)">' +
            '<option value="">--请选择节点--</option>' +
            areaInfoStr +
            ' </select>' +
            '</div>' +
            ' </div>' +
            '<div class="form-group room2" style="display:none">' +
            '<label class="col-sm-3 control-label">设备接入具体信息:</label>' +
            ' <div class="col-sm-9">' +
            '<input class="form-control nodeRoom2" placeholder="例：转塘机房-A01包间-E03柜"	onchange="nodeRoomVal(this)" >' +
            '</div>' +
            ' </div>' +
            '<input type="hidden" class="form-control nodeRoom">' +

            '</div>' +
            '<hr/>' +
            '<div class="inType-box none">' +
            '<div class="form-group ">' +
            '<label class="col-sm-3 control-label">接入方式:</label>' +
            '<div class="col-sm-9">' +
            '<select class="form-control intype">' +
            '<option value="">--请选择接入方式--</option>' +
            '<option value="软件接入">软件接入（客户端）</option>' +
            '<option value="硬件接入">硬件接入（盒子）</option>' +
            '</select>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="form-group">' +
            '<label class="col-sm-3 control-label">接入带宽:</label>' +
            '<div class="col-sm-6">' +
            '<input type="text" class="form-control bandwidth" placeholder="">' +
            '</div>' +
            '<div class="col-sm-2">' +
            '<select class="form-control bandunit">' +
            '<option>MB</option>' +
            '<option>GB</option>' +
            '</select>' +
            '</div>' +
            '</div>' +
            '<div class="gd-kou-box">' +
            '<div class="form-group">' +
            '<label class="col-sm-3 control-label">光口数量:</label>' +
            '<div class="col-sm-9">' +
            '<input type="text" class="form-control g-kou" placeholder="">' +
            '</div>' +
            '</div>' +
            '<div class="form-group">' +
            '<label class="col-sm-3 control-label">电口数量:</label>' +
            '<div class="col-sm-9">' +
            '<input type="text" class="form-control d-kou" placeholder="">' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="form-group none intoPoint-box">' +
            '<label for="inputEmail3" class="col-sm-3 control-label">接入点:</label>' +
            '<div class="col-sm-9">' +
            '<select class="form-control bandpoint">' +
            '<option value="">--请选择接入点--</option>' +
            '<option value="杭州">杭州接入点</option>' +
            '<option value="杭州青山湖">杭州青山湖接入点</option>' +
            '<option value="杭州淘宝城">杭州淘宝城接入点</option>' +
            '<option value="北京">北京接入点</option>' +
            '<option value="上海">上海接入点</option>' +
            '<option value="上海GDS">上海GDS</option>' +
            '<option value="广州">广州接入点</option>' +
            '</select>' +
            '</div>' +
            '</div>' +
            '<div class="form-group intoAddress-box">' +
            '<label for="inputEmail3" class="col-sm-3 control-label">客户接入地址:</label>' +
            '<div class="col-sm-9">' +
            '<textarea class="form-control addarea1" name="" id="" cols="30" rows="10"></textarea>' +
            '</div>' +
            '</div>' +
            '<div class="form-group addTel-box">' +
            '<label class="col-sm-3 control-label">客户联系方式:</label>' +
            '<div class="col-sm-9">' +
            '<input type="text" class="form-control addtel" placeholder="">' +
            '</div>' +
            '</div>' +

            '<div class="form-group ">' +
            '<label class="col-sm-3 control-label">UID:</label>' +
            '<div class="col-sm-9">' +
            '<input class="form-control uid">' +
            '</div>' +
            '</div>' +
            '<div class="form-group ">' +
            '<label class="col-sm-3 control-label">备注:</label>' +
            '<div class="col-sm-9">' +
            '<textarea class="form-control remark" s cols="20" rows="3"></textarea>' +
            '</div>' +
            '</div>' +
            '<input type="hidden" class="accessDevices" >' +
            '<input type="hidden" class="lightNo" >' +
            '<input type="hidden" class="electNo" >' +
            '<input type="hidden" class="routerProtection" >' +
            '<input type="hidden" class="inputNature_b" >' +
            '<input type="hidden" class="estimatedPrice" >' +
            '<input type="hidden" class="layingDistance" >' +
            '<input type="hidden" class="surveyCycle" >' +
            '<input type="hidden" class="constructionCycle" >' +
            '<input type="hidden" class="userMod" >' +
            '<input type="hidden" class="popMod" >' +
            '<input type="hidden" class="localSupplier" >' +
            '<input type="hidden" class="accessInfor" >' +
            '<input type="hidden" class="linkNum" >' +
            '<input type="hidden" class="repairPhone" >' +
            '<div class="form-group">' +
            '<div class="col-sm-offset-4 col-sm-10">' +
            '<button class="btn btn-primary intopoint-btn">确认</button>' +
            '</div>' +
            '</div>' +
            '<i class="delete glyphicon glyphicon-trash">' +
            '</i>' +
            '</div>' +
            '</div>' +
            '</div>')
    })

    $into.on({
        'change': function () {
            var $_panel = $(this).parents('.panel');
            var dk = Number($_panel.find('.d-kou').val()) || 0;
            var gk = Number($_panel.find('.g-kou').val()) || 0;
            var total = dk + gk;
            $_panel.find('.tit-info').html(total + '端口')
        }
    }, '.d-kou,.g-kou')

    $into.on({
        'change': function () {
            var $_panel = $(this).parents('.panel');
            var num = $_panel.find('.bandwidth').val() || 0;
            var mb = $_panel.find('.bandunit').val() || 'MB';
            $_panel.find('.tit-info2').html(num + mb)
        }
    }, '.bandwidth,.bandunit')

    //实时记录线和节点信息
    var scenechange = function () {
        var elems = scene.getDisplayedElements();
        nodes = {};
        lines = {};
        citys = {};

        $.each(elems, function (i, item) {
            if (item.elementType == 'node') {
                nodes[item.text] = item
            }
        })

        $.each(elems, function (i, item) {
            if (item.elementType != 'node') {
                lines[item.nodeA.text + '||' + item.nodeZ.text] = item
                citys[nodes[item.nodeA.text].city2 + '-' + nodes[item.nodeZ.text].city2] = nodes[item.nodeA.text].city2 + '-' + nodes[item.nodeZ.text].city2
            }
        })

        var index = 0;
        for (x in lines) {
            $('.into-info3 .d1').eq(index).html(x);
            index++
        }

        var index2 = 0
        for (y in citys) {
            $('.into-info3 .d2').eq(index2).html(y);
            index2++
        }
    }

    //线的相关操作
    var addLine = function (sCity, eCity, oType) {
        $('.into-info3 ul').append('<li class="clearfix">' +
            '<div class="d1">' + sCity + '||' + eCity + '</div>' +
            '<div class="d2" style="display:none">' + nodes[sCity].city2 + '-' + nodes[eCity].city2 + '</div>' +
            '<div class="delete-line">×</div>' +
            '<input type="hidden" class="platform" >' +
            '<input type="hidden" class="vllId" >' +
            '<input type="hidden" class="connectionId" >' +
            '<input type="hidden" class="connection2Id" >' +
            '<input type="hidden" class="equipmentType" >' +
            '<input type="hidden" class="finishTime" >' +
            '<input type="hidden" class="bossTime" >' +
            '<input type="hidden" class="supplier" >' +
            '<input type="hidden" class="lineResources" >' +
            '</li>')
    }

    $into3.on({//更换线颜色
        'change': function () {
            var type = $(this).val(), line = $(this).parent().find('.d1').html();
            if (type == 1) {
                lines[line].strokeColor = '0,0,255'
            } else {
                lines[line].strokeColor = '255,0,255'
            }
        }
    }, 'select')

    var removeLine = function (oline) {//删除线
        $.each($('.into-info3 ul li'), function () {
            var line = $(this).find('.d1').html();
            if (oline == line) {
                $(this).remove()
            }
        })
    }

    $into3.on({
        'click': function () {
            var line = $(this).parent().find('.d1').html();
            scene.remove(lines[line]);
            removeLine(line);
            scenechange()
        }
    }, '.delete-line')

    //点的相关操作
    var newNode = function (city, panel, city2) {//新建节点方法

        var node = new JTopo.Node(city);
        var coord = coordinate();
        var length = city.length * 15 + 10;
        if (length < 100) {
            length = 100
        }
        node.setBound(coord[0], coord[1], length, 40);
        node.fillColor = '0, 0, 255';

        node.font = '12pt 微软雅黑';
        node.textOffsetY = -8;

        if (city.indexOf('云') > -1) {
            node.setImage('/dist/img/cloud.png', true);
            node.fontColor = "0,0,0";
        } else {
            node.fontColor = "255,255,255";
            node.textPosition = "Middle_Center";
        }

        node.borderRadius = 5;
        node.city2 = 3;
        if (city2) {
            node.city2 = city2
        }
        scene.add(node);

        panel.attr('data-city', city);
        stage.centerAndZoom();
        scenechange()
    }

    //删除节点
    var removeNode = function (city) {
        scene.remove(nodes[city]);
        $('.into-info3 .d1').each(function (i, item) {//删除节点相关的线
            var cc = $(this).html().split('||');
            if (cc[0] == "" || cc[1] == "") {
                $(this).parent().remove()
            }

        })
        scenechange()
    }

    //更换节点
    var chageNode = function (ocity, ncity, panel, city2) {
        var coord = coordinate();
        var length = ncity.length * 16 + 20;
        if (length < 100) {
            length = 100
        }
        nodes[ocity].setBound(coord[0], coord[1], length, 40);
        nodes[ocity].text = ncity;
        nodes[ocity].city2 = city2;
        panel.attr('data-city', ncity);
        stage.centerAndZoom()
        scenechange()
    }

    //更换节点颜色
    var chageNodeColor = function (pannel) {
        var inprop = pannel.find('.inprop').val()
        var node = pannel.find('.panel-title').html()
        if (inprop == '互联网接入') {
            nodes[node].fillColor = '255,0,255'
            pannel.removeClass('panel-blue').addClass('panel-red')
        } else {
            if (nodes[node]) {
                nodes[node].fillColor = '0,0,255'
            }
            pannel.removeClass('panel-red').addClass('panel-blue')
        }
    }

    $into.on({
        'click': function () {
            var $_panel = $(this).parents('.panel');
            var city = $_panel.find('.city').val();

            var panelTitle = $(this).parents('.panel').find('.panel-title').html()
            $.each($('.into-info3 li'), function (i, item) {
                var plName = $(this).find('.d1').html();
                if (plName.indexOf(panelTitle) >= 0) {
                    $(this).remove()
                }

            })

            $_panel.remove();
            if ($_panel.attr('data-city')) {
                removeNode($_panel.attr('data-city'))
            }

            $.each(postNode, function (i, item) {
                if (item && (item.city == $_panel.attr('data-city') || item.city == $_panel.attr('data-old'))) {
                    postNode.splice(i, 1);
                }
            })

            sureData();
            beginNode = null
        }
    }, '.delete')

    $into.on({//添加或更新节点
        'change': function () {
            var $_panel = $(this).parents('.panel');
            var city = $_panel.find('.city').val();
            var nodeRoom = $_panel.find('.nodeRoom').val();
            var inProp = $_panel.find('.inprop').val();

            var orderBzType = $('#orderBzType').val();

            if (orderBzType == 2) {
                if (nodes[city] && city != $_panel.attr('data-city')) {
                    alert('节点已经存在')
                    $_panel.find('.city').val('')
                    return

                } else {
                    if ($_panel.attr('data-city')) {
                        chageNode($_panel.attr('data-city'), city, $_panel, city);
                    } else {
                        newNode(city, $_panel, city);
                    }
                }
                $_panel.find('.panel-title').html(city)
            } else {
                if (nodes[nodeRoom] && nodeRoom != $_panel.attr('data-city')) {
                    alert('节点已经存在')
                    $_panel.find('.nodeRoom').val('');
                    return

                } else {

                    if ($_panel.attr('data-city')) {
                        chageNode($_panel.attr('data-city'), nodeRoom, $_panel, city);
                    } else {
                        newNode(nodeRoom, $_panel, city);
                    }
                }
                $_panel.find('.panel-title').html(nodeRoom)
            }

            if ((nodeRoom == '' && orderBzType == 1) || (city == '' && orderBzType == 2)) {
                removeNode($_panel.attr('data-city'))
            }
            $_panel.find('.inProp-box').show();
            $_panel.find('.intoAddress-box').show();
            $_panel.find('.addTel-box').show();
            $_panel.find('.intoPoint-box').hide().find('.bandpoint').val('');
            chageNodeColor($_panel)
            if (inProp == '本地专线接入') {
                $_panel.find('.gd-kou-box').show();
                $_panel.find('.inType-box').hide().find('.intype').val('');
                $_panel.find('.nodeRoom-box').show()
            } else if (inProp == '互联网接入') {
                $_panel.find('.inType-box').show();
                $_panel.find('.gd-kou-box').hide().find('.g-kou,.d-kou').val('');
                $_panel.find('.nodeRoom-box').hide();
            }
        }
    }, '.nodeRoom,.inprop')

    $into.on({
        'change': function () {
            var $_panel = $(this).parents('.panel');
            var city = $_panel.find('.city').val();
            var inProp = $_panel.find('.inprop').val();
            var orderBzType = $('#orderBzType').val();
            $_panel.find('.nodeRoom1').val('');
            $_panel.find('.nodeRoom2').val('');
            $_panel.find('.nodeRoom').val('');
            if (orderBzType == 2) {
                if (nodes[city] && city != $_panel.attr('data-city')) {
                    alert('节点已经存在');
                    $_panel.find('.city').val('');
                    return
                } else {
                    if ($_panel.attr('data-city')) {
                        chageNode($_panel.attr('data-city'), city, $_panel, city);
                    } else {
                        newNode(city, $_panel, city);
                    }
                }
                $_panel.find('.panel-title').html(city);
            }

            if (city == '阿里云' || city == '腾讯云' || city == '华为云') {
                if (nodes[city] && city != $_panel.attr('data-city')) {
                    alert('节点已经存在');
                    $_panel.find('.city').val('');
                    return
                } else {
                    if ($_panel.attr('data-city')) {
                        chageNode($_panel.attr('data-city'), city, $_panel, city);
                    } else {
                        newNode(city, $_panel, city);
                    }
                }
                $_panel.find('.panel-title').html(city);
                $_panel.find('.intoPoint-box').show();
                $_panel.find('.intoAddress-box').hide().find('.addarea1').val('');
                $_panel.find('.gd-kou-box').hide().find('.g-kou,.d-kou').val('');
                $_panel.find('.inProp-box').hide().find('.inprop').val('');
                $_panel.find('.addTel-box').hide().find('.addtel').val('');
                $_panel.find('.inType-box').hide().find('.intype').val('');
                $_panel.find('.nodeRoom-box').hide();
                chageNodeColor($_panel)
            } else if (city == '') {
                removeNode($_panel.attr('data-city'))
            } else {
                $_panel.find('.inProp-box').show();
                $_panel.find('.intoAddress-box').show();
                $_panel.find('.addTel-box').show();
                $_panel.find('.intoPoint-box').hide().find('.bandpoint').val('');
                chageNodeColor($_panel);
                if (inProp == '本地专线接入') {
                    $_panel.find('.nodeRoom-box').show();
                    $_panel.find('.gd-kou-box').show();
                    $_panel.find('.inType-box').hide().find('.intype').val('')

                } else if (inProp == '互联网接入') {
                    $_panel.find('.nodeRoom-box').hide();
                    $_panel.find('.inType-box').show();
                    $_panel.find('.gd-kou-box').hide().find('.g-kou,.d-kou').val('')
                }
            }
        }
    }, '.city')

    $into.on({
        'change': function () {
            var $_panel = $(this).parents('.panel');
            var city = $_panel.find('.city').val();
            var subcity = $(this).val() ? '(' + $(this).val() + ')' : '';
            var iscity = city + subcity;
            $_panel.find('.panel-title').html(iscity);
            if (nodes[iscity] && iscity != $_panel.attr('data-city')) {
                alert('节点已经存在');
                $_panel.find('.bandpoint').val('');
            } else {
                if ($_panel.attr('data-city')) {
                    chageNode($_panel.attr('data-city'), iscity, $_panel, city);
                }
            }
        }
    }, '.bandpoint')

    $into.on({
        'click': function () {
            var $_panel = $(this).parents('.panel');
            var snode = {};
            snode.city = $_panel.find('.panel-title').html();
            snode.bandwidth = $_panel.find('.bandwidth').val();
            snode.unit = $_panel.find('.bandunit').val();
            snode.electNum = $_panel.find('.d-kou').val();
            snode.lightNum = $_panel.find('.g-kou').val();
            snode.pointNum = Number(snode.electNum) + Number(snode.lightNum);
            snode.address = $_panel.find('.addarea1').val();

            snode.point = $_panel.find('.bandpoint').val();
            snode.contactInfor = $_panel.find('.addtel').val();
            snode.lightNo = '';
            snode.electNo = '';
            snode.accessDevices = '';
            snode.nodeRoom = '';
            snode.routerProtection = '';
            snode.inputType = $_panel.find('.inprop').val();
            snode.inputNature_h = $_panel.find('.intype').val();

            snode.uid = $_panel.find('.uid').val();
            snode.remark = $_panel.find('.remark').val();

            snode.inputNature_b = '';
            snode.estimatedPrice = '';
            snode.layingDistance = '';
            snode.surveyCycle = '';
            snode.constructionCycle = '';
            snode.userMod = '';
            snode.popMod = '';
            snode.localSupplier = '';
            snode.accessInfor = '';
            snode.linkNum = '';
            snode.repairPhone = '';

            var have = false;
            $.each(postNode, function (i, item) {
                if (item.city == $_panel.attr('data-old')) {
                    postNode[i] = snode;
                    $_panel.attr('data-old', snode.city);
                    have = true
                }
            });

            if (!have) {
                $_panel.attr('data-old', snode.city);
                postNode.push(snode)
            }
            sureData()

        }
    }, '.intopoint-btn')

    var sureData = function () {

        postLine = [];
        $.each($('.into-info3 li'), function (i, item) {
            var sline = {};
            sline.plName = $(this).find('.d1').html();
            sline.cityName = $(this).find('.d2').html();

            sline.platform = $(this).find('.platform').val() || "";
            sline.vllId = $(this).find('.vllId').val() || "";
            sline.connectionId = $(this).find('.connectionId').val() || "";
            sline.connection2Id = $(this).find('.connection2Id').val() || "";
            sline.equipmentType = $(this).find('.equipmentType').val() || "";
            sline.finishTime = $(this).find('.finishTime').val() || "";
            sline.bossTime = $(this).find('.bossTime').val() || "";
            sline.supplier = $(this).find('.supplier').val() || "";
            sline.lineResources = $(this).find('.lineResources').val() || "";

            postLine.push(sline)
        })

        var cacheNode = [];
        $.each($('.panel'), function (i, item) {
            var snode = {};
            snode.panelTitle = $(this).find('.panel-title').html() || "";
            snode.check = $(this).find('input[name="check"]:checked').val() || "1";
            snode.city = $(this).find('.city').val();
            snode.bandwidth = $(this).find('.bandwidth').val();
            snode.unit = $(this).find('.bandunit').val();
            snode.electNum = $(this).find('.d-kou').val();
            snode.lightNum = $(this).find('.g-kou').val();
            snode.pointNum = Number(snode.electNum) + Number(snode.lightNum);
            snode.address = $(this).find('.addarea1').val();

            snode.point = $(this).find('.bandpoint').val();
            snode.contactInfor = $(this).find('.addtel').val();

            snode.lightNo = $(this).find('.lightNo').val() || "";
            snode.electNo = $(this).find('.electNo').val() || "";
            snode.accessDevices = $(this).find('.accessDevices').val() || "";
            snode.nodeRoom = $(this).find('.nodeRoom').val() || "";
            snode.routerProtection = $(this).find('.routerProtection').val() || "";

            snode.inputType = $(this).find('.inprop').val();
            snode.inputNature_h = $(this).find('.intype').val();

            snode.uid = $(this).find('.uid').val() || "";
            snode.remark = $(this).find('.remark').val() || "";

            snode.inputNature_b = $(this).find('.inputNature_b').val() || "";
            snode.estimatedPrice = $(this).find('.estimatedPrice').val() || "";
            snode.layingDistance = $(this).find('.layingDistance').val() || "";
            snode.surveyCycle = $(this).find('.surveyCycle').val() || "";
            snode.constructionCycle = $(this).find('.constructionCycle').val() || "";
            snode.userMod = $(this).find('.userMod').val() || "";
            snode.popMod = $(this).find('.popMod').val() || "";
            snode.localSupplier = $(this).find('.localSupplier').val() || "";
            snode.accessInfor = $(this).find('.accessInfor').val() || "";
            snode.linkNum = $(this).find('.linkNum').val() || "";
            snode.repairPhone = $(this).find('.repairPhone').val() || "";

            snode.location = [nodes[snode.panelTitle].x, nodes[snode.panelTitle].y];
            cacheNode.push(snode)
        })

        $('#nodes').val(JSON.stringify(cacheNode));
        $('#lines').val(JSON.stringify(postLine));

        var formData = new FormData($("#form")[0]);
        $.ajax({
            url: '/cms/order/editOrder?state=1',
            type: 'post',
            dataType: 'json',
            contentType: false,
            processData: false,
            data: formData,
            success: function (data) {
                if (data.state == "success") {
                    alert("保存成功！");
                }
            },
            error: function () {

            }
        })

    }

    $('#submit').click(function () {
        postLine = [];
        $.each($('.into-info3 li'), function (i, item) {
            var sline = {};
            sline.plName = $(this).find('.d1').html();
            sline.cityName = $(this).find('.d2').html();

            sline.platform = $(this).find('.platform').val() || "";
            sline.vllId = $(this).find('.vllId').val() || "";
            sline.connectionId = $(this).find('.connectionId').val() || "";
            sline.connection2Id = $(this).find('.connection2Id').val() || "";
            sline.equipmentType = $(this).find('.equipmentType').val() || "";
            sline.finishTime = $(this).find('.finishTime').val() || "";
            sline.bossTime = $(this).find('.bossTime').val() || "";
            sline.supplier = $(this).find('.supplier').val() || "";
            sline.lineResources = $(this).find('.lineResources').val() || "";

            postLine.push(sline)
        })

        var cacheNode = [];
        $.each($('.panel'), function (i, item) {
            var snode = {};
            snode.panelTitle = $(this).find('.panel-title').html() || "";
            snode.check = $(this).find('input[name="check"]:checked').val() || "1";

            snode.city = $(this).find('.city').val();
            snode.bandwidth = $(this).find('.bandwidth').val();
            snode.unit = $(this).find('.bandunit').val();
            snode.electNum = $(this).find('.d-kou').val();
            snode.lightNum = $(this).find('.g-kou').val();
            snode.pointNum = Number(snode.electNum) + Number(snode.lightNum);
            snode.address = $(this).find('.addarea1').val();

            snode.point = $(this).find('.bandpoint').val();
            snode.contactInfor = $(this).find('.addtel').val();

            snode.lightNo = $(this).find('.lightNo').val() || "";
            snode.electNo = $(this).find('.electNo').val() || "";
            snode.accessDevices = $(this).find('.accessDevices').val() || "";
            snode.nodeRoom = $(this).find('.nodeRoom').val() || "";
            snode.routerProtection = $(this).find('.routerProtection').val() || "";

            snode.inputType = $(this).find('.inprop').val();
            snode.inputNature_h = $(this).find('.intype').val();

            snode.uid = $(this).find('.uid').val() || "";
            snode.remark = $(this).find('.remark').val() || "";

            snode.inputNature_b = $(this).find('.inputNature_b').val() || "";
            snode.estimatedPrice = $(this).find('.estimatedPrice').val() || "";
            snode.layingDistance = $(this).find('.layingDistance').val() || "";
            snode.surveyCycle = $(this).find('.surveyCycle').val() || "";
            snode.constructionCycle = $(this).find('.constructionCycle').val() || "";
            snode.userMod = $(this).find('.userMod').val() || "";
            snode.popMod = $(this).find('.popMod').val() || "";
            snode.localSupplier = $(this).find('.localSupplier').val() || "";
            snode.accessInfor = $(this).find('.accessInfor').val() || "";
            snode.linkNum = $(this).find('.linkNum').val() || "";
            snode.repairPhone = $(this).find('.repairPhone').val() || "";

            snode.location = [nodes[snode.panelTitle].x, nodes[snode.panelTitle].y];
            cacheNode.push(snode)
        })

        $('#nodes').val(JSON.stringify(cacheNode));
        $('#lines').val(JSON.stringify(postLine));

        var formData = new FormData($("#form")[0]);
        $.ajax({
            url: '/cms/order/editOrder?state=4',
            type: 'post',
            dataType: 'json',
            contentType: false,
            processData: false,
            data: formData,
            success: function (data) {
                if (data.state == "success") {
                    alert("操作成功！");
                    location.href = "/cms/order/orderList";
                }
            },
            error: function () {

            }
        })

    })


    var coordTop = -60;
    var coordinate = function () {//计算NODE位置
        var width = $('#canvas')[0].getBoundingClientRect().width - 200;
        var coordLeft = width * Math.random() + 100;
        coordTop += 60
        if (coordTop == 0) {
            return [0, 100]
        }
        return [coordLeft, coordTop]
    }

    var beginNode = null;
    var tempNodeA = new JTopo.Node('tempA');
    tempNodeA.setSize(1, 1);

    var tempNodeZ = new JTopo.Node('tempZ');
    tempNodeZ.setSize(1, 1);

    var link = new JTopo.Link(tempNodeA, tempNodeZ);

    scene.mouseup(function (e) {
        if (e.button == 2) {
            scene.remove(link);
            return;
        }
        if (e.target != null && e.target instanceof JTopo.Node) {
            if (beginNode == null) {
                beginNode = e.target;
                scene.add(link);
                tempNodeA.setLocation(e.x, e.y);
                tempNodeZ.setLocation(e.x, e.y);
                scene.remove(link);
            } else if (beginNode !== e.target) {
                var endNode = e.target;
                if (lines[beginNode.text + '||' + endNode.text] || lines[endNode.text + '||' + beginNode.text]) {
                    beginNode = null;
                    alert('不能重复连线');
                    scene.remove(link);
                    scenechange();
                    return
                }
                var l = new JTopo.Link(beginNode, endNode);

                l.font = '20pt 微软雅黑';
                l.fontColor = "#000";
                l.textOffsetY = 34;
                l.bundleOffset = 60; // 折线拐角处的长度
                l.bundleGap = 20; // 线条之间的间隔
                l.strokeColor = '0,0,255';

                scene.add(l);
                addLine(l.nodeA.text, l.nodeZ.text);
                beginNode = null;
                scene.remove(link);
                scenechange()
            } else {
                beginNode = null;
                scene.remove(link);
            }
        } else {
            scene.remove(link);
        }
    });

    scene.mousedown(function (e) {
        if (e.target == null || e.target === beginNode || e.target === link) {
            scene.remove(link);
        }
    });
    scene.mousemove(function (e) {
        tempNodeZ.setLocation(e.x, e.y);
    });


    //编辑
    var info = null;
    if ($('#nodes').val() != null && $('#nodes').val() != "") {

        var postNodes = JSON.parse($('#nodes').val());
        var postLines = [];
        if ($('#lines').val() != null && $('#lines').val() != "") {
            postLines = JSON.parse($('#lines').val());
        }
        info = {"nodes": postNodes, "lines": postLines};
        scenechange();
    }

    if (info) {
        var newNodess = function (city, coord, city2) {
            var node = new JTopo.Node(city);
            var length = city.length * 15 + 10;
            if (length < 100) {
                length = 100
            }
            node.setBound(coord[0], coord[1], length, 40);
            node.fillColor = '0, 0, 255';
            node.font = '12pt 微软雅黑';
            node.textOffsetY = -8;
            if (city.indexOf('云') > -1) {
                node.setImage('/dist/img/cloud.png', true);
                node.fontColor = "0,0,0";
            } else {
                node.fontColor = "255,255,255";
                node.textPosition = "Middle_Center";
            }
            node.borderRadius = 5;
            node.city2 = city2;
            scene.add(node);
            nodes[city] = node
        }

        var newLiness = function (beginNode, endNode, item) {
            var l = new JTopo.Link(beginNode, endNode);
            l.font = '20pt 微软雅黑';
            l.fontColor = "#000";
            l.textOffsetY = 34;
            l.bundleOffset = 60; // 折线拐角处的长度
            l.bundleGap = 20; // 线条之间的间隔
            l.strokeColor = '0,0,255';

            scene.add(l);
            lines[beginNode.text + '||' + endNode.text] = l;
            $('.into-info3 ul').append('<li class="clearfix">' +
                '<div class="d1">' + beginNode.text + '||' + endNode.text + '</div>' +
                '<div class="d2" style="display:none">' + nodes[beginNode.text].city2 + '-' + nodes[endNode.text].city2 + '</div>' +
                '<div class="delete-line">×</div>' +
                '<input type="hidden" class="platform" value="' + item.platform + '">' +
                '<input type="hidden" class="vllId" value="' + item.vllId + '">' +
                '<input type="hidden" class="connectionId" value="' + item.connectionId + '">' +
                '<input type="hidden" class="connection2Id" value="' + item.connection2Id + '">' +
                '<input type="hidden" class="equipmentType" value="' + item.equipmentType + '">' +
                '<input type="hidden" class="finishTime" value="' + item.finishTime + '">' +
                '<input type="hidden" class="bossTime" value="' + item.bossTime + '">' +
                '<input type="hidden" class="supplier" value="' + item.supplier + '">' +
                '<input type="hidden" class="lineResources" value="' + item.lineResources + '">' +
                '</li>')
        };

        $.each(info.nodes, function (i, item) {
            newNodess(item.panelTitle, item.location, item.city)
        })

        $.each(info.lines, function (i, item) {
            var beginNode = nodes[item.plName.split('||')[0]];
            var endNode = nodes[item.plName.split('||')[1]];
            newLiness(beginNode, endNode, item);
        })
        coordTop = 1;

        $('.panel').each(function () {
            var $_panel = $(this);
            var city = $_panel.find('.city').val();
            var nodeRoom = $_panel.find('.nodeRoom').val();
            var inProp = $_panel.find('.inprop').val();
            var orderBzType = $('#orderBzType').val();

            if (city == '阿里云' || city == '腾讯云' || city == '华为云') {
                $_panel.find('.intoPoint-box').show();
                $_panel.find('.intoAddress-box').hide();
                $_panel.find('.gd-kou-box').hide();
                $_panel.find('.inProp-box').hide();
                $_panel.find('.addTel-box').hide();
                $_panel.find('.inType-box').hide();
                chageNodeColor($_panel)
            } else if ((nodeRoom == '' && orderBzType == 1) || (city == '' && orderBzType == 2)) {
                removeNode($_panel.attr('data-city'));
            } else {
                $_panel.find('.inProp-box').show();
                $_panel.find('.intoAddress-box').show();
                $_panel.find('.addTel-box').show();
                $_panel.find('.intoPoint-box').hide();
                chageNodeColor($_panel);
                if (inProp == '本地专线接入') {
                    $_panel.find('.nodeRoom-box').show();
                    $_panel.find('.gd-kou-box').show();
                    $_panel.find('.inType-box').hide();
                } else if (inProp == '互联网接入') {
                    $_panel.find('.nodeRoom-box').hide();
                    $_panel.find('.inType-box').show();
                    $_panel.find('.gd-kou-box').hide();
                }
            }
        })
    }

    $('.nodeRoom1').each(function () {
        var city = $(this).parents('.panel').find('.city').val();
        $(this).find('option').each(function () {
            var _this = this
            if ($(_this).html().indexOf("--请选择节点--") != -1) {
                $(_this).show()
            } else if ($(_this).html().indexOf(city) != -1) {
                $(_this).show()
            }
            else {
                $(_this).hide()
            }
        })
    })

})(jQuery)

function cityRoom(obj) {
    var city = obj.value;
    if (city == "阿里云" || city == "腾讯云" || city == '华为云') {
        $(obj).parents('.panel-default').find('.bandpoint').each(function () {
            $(this).find('option').each(function () {
                var _this = this;
                if ($(_this).html().indexOf("--请选择接入点--") != -1) {
                    $(_this).show();
                } else if ($(_this).html().indexOf("杭州接入点") != -1 && city == "阿里云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("杭州青山湖接入点") != -1 && city == "阿里云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("杭州淘宝城接入点") != -1 && city == "阿里云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("北京接入点") != -1 && city == "阿里云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("上海接入点") != -1 && city == "腾讯云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("上海GDS") != -1 && city == "华为云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("上海接入点") != -1 && city == "阿里云") {
                    $(_this).show();
                } else if ($(_this).html().indexOf("广州接入点") != -1 && city == "腾讯云") {
                    $(_this).show();
                } else {
                    $(_this).hide();
                }
            })
        })
    } else {
        $(obj).parents('.panel-default').find('.nodeRoom1').each(function () {
            $(this).find('option').each(function () {
                var _this = this;
                if ($(_this).html().indexOf("--请选择节点--") != -1) {
                    $(_this).show();
                } else if ($(_this).html().indexOf(city) != -1) {
                    $(_this).show();
                } else {
                    $(_this).hide();
                }
            })
        })
    }
}

function changeRoom(obj) {
    var flag = obj.value;
    if (flag == 1) {
        $(obj).parents('.panel-default').find('.room1').show();
        $(obj).parents('.panel-default').find('.room2').hide();
    } else {
        $(obj).parents('.panel-default').find('.room1').hide();
        $(obj).parents('.panel-default').find('.room2').show();
    }
    $(obj).parents('.panel-default').find('.nodeRoom1').val('');
    $(obj).parents('.panel-default').find('.nodeRoom2').val('');
    $(obj).parents('.panel-default').find('.nodeRoom').val('');
}

function nodeRoomVal(obj) {
    var nodeRoom = obj.value;
    $(obj).parents('.panel-default').find('.nodeRoom').val(nodeRoom);
    $(obj).parents('.panel-default').find('.nodeRoom').change()

}