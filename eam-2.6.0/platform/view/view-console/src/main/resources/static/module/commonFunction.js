layui.define([],
    function (exports) {
        function columnBpmOpenButtonStatus(data){
            //列表状态
            console.log(data);
            if(data.status){
                if(data.status=="incomplete"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }else if(data.status=="complete"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }else if(data.status=="deny"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }else if(data.status=="approval"){
                }else if(data.status=="cancel"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }else{
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }
            }
            return 1;
        }
        var bpmFunction = {
            columnBpmOpenButtonStatus:columnBpmOpenButtonStatus,
        }
        exports('bpmFunction', bpmFunction);
    });