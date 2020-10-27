$("#main-container > div:nth-child(1) > form > div > div.form-group.col-12.col-sm-6.col-md-2.mb-md-0 > button").click((e)=>{
    e.preventDefault();
    let inputNeedValid = $("#modules\\.search\\.pages\\.home\\.fields\\.registration_number");
    if(inputNeedValid.val()){
        inputNeedValid.removeClass("is-invalid");
        $("form > div > div.form-group.col-12.col-sm-6.col-md-5 > div").hide();
    }else{
        inputNeedValid.addClass("is-invalid");
        $("form > div > div.form-group.col-12.col-sm-6.col-md-5 > div").show();
    }
});