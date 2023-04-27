layui.define([ 'layer','admin','form', 'table', 'util',"element"],
    function (exports) {
        function columnBpmOpenButtoStatus(data,lockForm){
            //列表状态
            if(data.status){
                if(data.status=="incomplete"){
                    console.log("edit")
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                }else if(data.status=="complete"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                    fox.lockForm($("#"+lockForm),true);
                }else if(data.status=="deny"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                    fox.lockForm($("#"+lockForm),true);
                }else if(data.status=="approval"){
                    fox.lockForm($("#"+lockForm),true);

                }else if(data.status=="cancel"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                    fox.lockForm($("#"+lockForm),true);
                }else{
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data.id + "']"), true);
                    fox.lockForm($("#"+lockForm),true);
                }
            }

            return 1;
        }
        exports('commonFunction', commonFunction);
    });