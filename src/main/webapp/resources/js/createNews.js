
function makeEditable1() {

    $('#saveNews').click(function () {
        form = $('#detNewsForm');
        var catid = $('#selectpicker').children(":selected").attr("id");
        document.getElementById('categoriesid').value = catid;
        $.ajax({
            type: "POST",
            url: 'ajax/createnews',
            data: form.serialize(),
            success: function () {
                location.href = "?_addNews";
            }
        });
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        $("#help1").text("");
        $("#help2").text("");
        try {
            var textError = jqXHR.responseJSON.split("<br>");
            for(var i = 0; i<textError.length-1; i++){
                var textLocalErr = textError[i];
                if(textLocalErr.split(" ")[0]==="name") $("#help1").text("Название "+textLocalErr.substring(5, textLocalErr.length));
                else if(textLocalErr.split(" ")[0] === "content") $("#help2").text("Содержание "+textLocalErr.substring(7, textLocalErr.length));
            }
        }catch (error){
            /*failNoty(event, jqXHR, options, jsExc);*/
        }
    })
}

function successNoty(value) {
    iziToast.show({
        color: 'green',
        position: 'bottomRight',
        timeout: 2000,
        message: value
    });
}

$(function () {
    makeEditable1();
});