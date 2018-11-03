var App = function () {

    // 全局变量
    var _allCheckbox;
    var _checkbox;

    /** 初始化Ajax**/
    var handlerInitAjax = function () {
        $.ajaxSetup({
            beforeSend: function () {
                //ajax请求之前
            },
            complete: function () {
                //ajax请求完成，不管成功失败
            },
            error: function () {
                //ajax请求失败
            }
        })
    };

    /** 私有方法初始化iCheck **/
    var handlerInitCheckbox = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        // 获取控制 Checkbox
        _allCheckbox =  $('input[type="checkbox"].minimal.allCheck');
        // 获取全部的Checkbox集合
        _checkbox =  $('input[type="checkbox"].minimal');
    };

    /** 初始化CheckBox全选 **/
    var handlerInitCheckboxAll = function () {
        _allCheckbox.on("ifChecked ifUnchecked",function (event) {
            var type = event.type;
            if (type === 'ifChecked') {
                _checkbox.iCheck('check');
            } else if (type === 'ifUnchecked') {
                _checkbox.iCheck('uncheck');
            }
        });
    };

    /** 批量删除CheckBox **/
    var handlerDeleteBatchByCheckBoxId = function (url) {
        // 用于存放Id数组
        var idArray = new Array();
        var _checkbox = App.getCheckbox();
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id !== 'undefined' && $(this).is(":checked")) {
                idArray.push(_id);
            }
        });
        if (idArray.length === 0) {
            //至少要选择一项
            Ewin.alert("请至少要选择一项!");
        } else {
            //进行批量删除
            Ewin.confirm({message: "确定要删除这几项？"}).on(function () {
                $.ajax({
                    type: "POST",
                    dataType: "JSON",
                    url: url,
                    data: {
                        ids: idArray.toString()
                    },
                    success: function (data) {
                        if (data && data.status === 'SUCCESS') {
                            alert("删除成功");
                        }
                    }
                })
            });
        }
    };

    /** 初始化DataTables**/
    var handlerDataTables = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
            paging: true,
            info: true,
            lengthChange: false,
            ordering: false,
            processing: true,
            searching: false,
            deferRender: true,
            serverSide: true,
            pageLength : 1,
            ajax: {
                type: "POST",
                url: url
            },
            columns: columns,
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            drawCallback: function() {
                //每次表格重绘时，都要加载一下iCheck样式
                /* $('input[type="checkbox"].minimal').iCheck({
                     checkboxClass: 'icheckbox_minimal-blue',
                     radioClass: 'iradio_minimal-blue'
                 });*/
                handlerInitCheckbox();
                handlerInitCheckboxAll();
            }
        });
        return _dataTable;
    };

    return {
        init: function () {
            handlerInitAjax();
            handlerInitCheckbox();
            handlerInitCheckboxAll();
        },
        getCheckbox: function () {
            return _checkbox;
        },
        deleteBatchByCheckBoxId: function (url) {
            handlerDeleteBatchByCheckBoxId(url);
        },
        initDataTables: function (url, columns) {
            return handlerDataTables(url, columns);
        }
    }
}();

$(document).ready(function () {
    App.init();
});