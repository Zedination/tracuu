function showData(res){
    $('#ma-sinh-vien').text(res.maSinhVien);
    $('#so-bao-danh').text(res.soBaoDanh);
    $('#ho-ten').text(res.hoTen);
    $('#ngay-sinh').text(res.ngaySinh);
    $('#ma-de-nghe').text(res.maDeNghe);
    $('#diem-nghe').text(res.diemNghe);
    $('#ma-de-doc').text(res.maDeDoc);
    $('#diem-doc').text(res.diemDoc);
    $('#tong-diem').text(res.tongDiem);
    $('#phan-loai').text(res.phanLoai);
}
$("#main-container > div:nth-child(1) > form > div > div.form-group.col-12.col-sm-6.col-md-2.mb-md-0 > button").click((e)=>{
    e.preventDefault();
    let inputNeedValid = $("#modules\\.search\\.pages\\.home\\.fields\\.registration_number");
    if(inputNeedValid.val()){
        inputNeedValid.removeClass("is-invalid");
        $("form > div > div.form-group.col-12.col-sm-6.col-md-5 > div").hide();
        $.ajax({
            type: 'post',
            url: '/find?q='+inputNeedValid.val(),
            success: (result)=>{
                if(result){
                    showData(result);
                    $('#main-container > div:nth-child(2)').show();
                }else {
                    $('#main-container > div:nth-child(2)').hide();
                    alert("Không tìm thấy sinh viên có mã sinh viên bạn vừa nhập");
                }
            }
        })
    }else{
        inputNeedValid.addClass("is-invalid");
        $("form > div > div.form-group.col-12.col-sm-6.col-md-5 > div").show();
    }
});