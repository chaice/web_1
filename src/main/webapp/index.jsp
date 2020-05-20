<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/styles/kendo.common.min.css">
    <link rel="stylesheet" href="/static/styles/kendo.rtl.min.css">
    <link rel="stylesheet" href="/static/styles/kendo.default.min.css">
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/kendo.all.min.js"></script>
</head>
<body>
<div id="grid"></div>

<div id="vertical" class="vertical">
    <div id="horizontal" style="height:680px; width: 100%;">
        <div id="left-pane">
            <div id="panelbar" style="margin: 10px;"></div>
        </div>
        <div id="center-pane">
            <div id="content" style="margin: 10px;"></div>
        </div>
    </div>
</div>

<script>

    var loadPage = function (path) {
        // load 新页面
        $("#content").load(path, null, function () {

        });
    };

    $(document).ready(function () {
        $("#horizontal").kendoSplitter({
            panes: [
                {
                    //是否可折叠
                    collapsible: true,
                    //是否可调整大小
                    resizable: false,
                    //是否可以滚动
                    scrollable:true,
                    size: "256px"
                },
                {collapsible: false}
            ]
        });
        $('#horizontal').data("kendoDialog");

        var headerHeight = 81;
        var footerHeight = 50;
        var bodyHeight = $(document.body).height() - headerHeight - footerHeight;
        //console.info("bodyHeight=" + bodyHeight);
        $("#horizontal").css({height: bodyHeight});


        var boxInternetCafeKendoGrid = $("#grid").kendoGrid({
            //是否允许copy
            allowCopy: true,
            //
            dataSource: {
                data: boxInternetCafeList,
                schema: {
                    model: {
                        fields: {
                            id: {type: "number"},
                            customer: {type: "object"},
                            manufacturer: {type: "string"},
                            model: {type: "string"},
                            sn: {type: "string"},
                            hardwareVersion: {type: "string"},
                            softwareVersion: {type: "string"},
                            lanIP: {type: "string"},
                            lanNetmask: {type: "string"},
                            ipipBoxMaster: {type: "string"},
                            ipipEntryMaster: {type: "string"},
                            ipipBoxSlave: {type: "string"},
                            ipipEntrySlave: {type: "string"},
                            status: {type: "number"}
                        }
                    }
                },
                serverFiltering: false,
                pageSize: 20
            },
            filterable: {
                mode: "row"
            },
            //是否可排序
            sortable: true,
            //是否可分页
            pageable: true,
            scrollable: false,
            //无记录时显示
            noRecords: {
                template: "无记录"
            },
            //
            toolbar: [
                {
                    template: '<a class="k-button k-button-icontext" href="javascript:loadPage(\'box/internet_cafe/add.html\');" ><span class="k-icon k-i-plus"></span>添加</a><a class="k-button k-button-icontext" href="javascript:loadPage(\'box/internet_cafe/list.html\');" ><span class="k-icon k-i-reload"></span>刷新</a>'
                }
            ],
            columns: [{
                title: "小7盒子列表",
                columns: [
                    {
                        field: "sn",
                        title: "序列号",
                        filterable: {
                            cell: {
                                operator: "contains",
                                suggestionOperator: "contains"
                            }
                        }
                    },
                    {
                        field: "customer.name",
                        title: "所属客户",
                        filterable: {
                            cell: {
                                operator: "contains",
                                suggestionOperator: "contains"
                            }
                        }
                    },
                    {
                        field: "status",
                        title: "状态",
                        template: function (dataItem) {
                            var text = "";
                            switch (dataItem.status) {
                                case 101:
                                    text = "存货";
                                    break;
                                case 102:
                                    text = "在线";
                                    break;
                                case 103:
                                    text = "离线";
                                    break;
                            }
                            return text;
                        },
                        filterable: false
                    },
                    {
                        title: "生产信息",
                        template: function (dataItem) {
                            var text = "";
                            text +="<p>型号："+ dataItem.model +"</p>";
                            text +="<p>生产商 ："+ dataItem.manufacturer +"</p>";
                            return text;
                        }
                    },
                    {
                        title: "版本",
                        template: function (dataItem) {
                            var text = "";
                            text +="<p>硬件："+ dataItem.hardwareVersion +"</p>";
                            text +="<p>软件："+ dataItem.softwareVersion +"</p>";
                            return text;
                        }
                    },
                    {
                        title: "局域网",
                        template: function (dataItem) {
                            var text = "";
                            text +="<p>地址："+ dataItem.lanIP +"</p>";
                            text +="<p>掩码："+ dataItem.lanNetmask +"</p>";
                            return text;
                        }
                    },
                    {
                        title: "盒端IPIP",
                        template: function (dataItem) {
                            var text = "";
                            text +="<p>主："+ dataItem.ipipBoxMaster +"</p>";
                            text +="<p>备："+ dataItem.ipipBoxSlave +"</p>";
                            return text;
                        }
                    },
                    {
                        title: "远端IPIP",
                        template: function (dataItem) {
                            var text = "";
                            text +="<p>主："+ dataItem.ipipEntryMaster +"</p>";
                            text +="<p>备："+ dataItem.ipipEntrySlave +"</p>";
                            return text;
                        }
                    },
                    {
                        field: "id",
                        width: "100px",
                        title: "操作",
                        template: '<a class="k-button k-button-icontext" href="javascript:removeBoxInternetCafe(\'#: id #\');" ><span class="k-icon k-i-delete"></span>删除</a>'
                    }
                ]

            }]

        });


        $("#panelbar").kendoPanelBar({
            dataSource: new kendo.data.HierarchicalDataSource({
                data: [
                    {
                        text: "资源管理",
                        items: [
                            {
                                text: "网吧盒子",
                                url: "javascript:loadPage(\"box/internet_cafe/list.html\");"
                            },
                            {
                                text: "企业盒子",
                                url: "javascript:loadPage(\"box/enterprise/list.html\");"
                            },                        {
                                text: "网吧入口",
                                url: "javascript:loadPage(\"IPIP/entry/list.html\");"
                            },                        {
                                text: "企业入口",
                                url: "javascript:loadPage(\"shadowsocks/entry/list.html\");"
                            }
                        ],
                        expanded: true
                    },
                    {
                        text: "服务管理",
                        items: [
                            {
                                text: "网吧加速业务管理",
                                url: "javascript:loadPage(\"acceleration/internet_cafe/list.html\");"
                            },
                            {
                                text: "加速地址管理",
                                url: "javascript:loadPage(\"acceleration/target/list.html\");"
                            },
                            {
                                text: "网吧订单管理",
                                url: "javascript:loadPage(\"order/internet_cafe/list.html\");"
                            },
                            {
                                text: "企业加速业务管理",
                                url: "javascript:loadPage(\"acceleration/enterprise/list.html\");"
                            }
                        ],
                        expanded: true
                    },
                    {
                        text: "客户管理",
                        items: [
                            {
                                text: "网吧客户",
                                url: "javascript:loadPage(\"customer/internet_cafe/list.html\");"
                            },
                            {
                                text: "企业客户",
                                url: "javascript:loadPage(\"customer/enterprise/list.html\");"
                            }
                        ],
                        expanded: true
                    }
                ]
            })
        });
        $("#panelbar").data("kendoPanelBar");
    });
</script>
</body>
</html>
