;(function (window, document, $) {
    /** 1、常用工具*/


    // jQuery扩展命名空间
    $.extend({
        whiteCode: {}
    });

    /** 2、项目中其他扩展方法*/
    $.extend($.whiteCode, {
        // 表单数组 ==> json对象
        formDataArrayToJson: function(formData) {
            var param = {};
            formData.forEach(function (e) {
                param[e.name] = e.value;
            });
            return param;
        }
    });

    $.fn.extend({
        customDataTable: function (options) {
            var defaultOption = {
                info: true,
                lengthChange: false,
                ordering: false,
                paging: true,
                processing: true,
                searching: false,
                deferRender: true,
                serverSide: true,
                pageLength: 10,
                pagingType: "full_numbers",
                drawCallback: function() {
                    //每次表格重绘时，都要加载一下iCheck样式
                    /* $('input[type="checkbox"].minimal').iCheck({
                         checkboxClass: 'icheckbox_minimal-blue',
                         radioClass: 'iradio_minimal-blue'
                     });*/
                    App.init();
                },
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
                }
            };
            $.extend(defaultOption,options);
            return this.DataTable(defaultOption);
        },
        customBootstrapValidator: function (options) {
            var defaultOptions= {
                //container:'tooltip', 可选tooltip、popover
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                }
            };
            $.extend(defaultOptions,options);
            return this.bootstrapValidator(defaultOptions);
        },
        customDateTimePicker: function (dateType) {
            if (dateType === 'date') {
                return this.datetimepicker({
                    language: 'zh-CN',
                    format: 'yyyy-mm-dd',
                    weekStart: 1,
                    todayBtn: true,
                    autoclose: true,
                    todayHighlight: true,
                    startView: 2,
                    minView: 2,
                    fontAwesome: true
                });
            } else if (dateType === 'datetime') {
                return this.datetimepicker({
                    language: 'zh-CN',
                    weekStart: 1,
                    todayBtn: true,
                    autoclose: true,
                    todayHighlight: true,
                    startView: 2,
                    minView: 1,
                    fontAwesome: true
                });
            }
        }
    });

})(window, document, $);